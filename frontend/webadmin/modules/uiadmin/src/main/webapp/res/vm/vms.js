var MENU_NAME = "vmshref";
var DEFAULT_CLUSTER_ID = null;
var vmtable = null;

var VM_COLUMNS = [ {
	data : "name",
	title : "Name",
	type : "string",
	width : "100px"
}, {
	data : "host_name",
	title : "Host",
	type : "string",
	width : "100px"
}, {
	data : "ip",
	title : "IP Address",
	type : "string",
	width : "200px"
}, {
	data : "fqdn",
	title : "FQDN",
	type : "string",
	width : "100px"
}, {
	data : "cluster.name",
	title : "Cluster",
	type : "string",
	width : "50px"
}, {
	data : "dcname",
	title : "Data Center",
	type : "string",
	width : "100px"
}, {
	data : "status.state",
	title : "Status",
	type : "string",
	width : "100px"
} ];

$(function() {
	$.contextMenu({
		selector : '#vmstable td',
		build : function($trigger, e) {
			// this callback is executed every time the menu is to be shown
			// its results are destroyed every time the menu is hidden
			// e is the original contextmenu event, containing e.pageX and
			// e.pageY (amongst other data)
			return {
				callback : function(key, options) {
					var m = "clicked: " + key;
					window.console && console.log(m) || alert(m);
				},
				items : {
					"edit" : {
						name : "New",
						icon : "edit"
					},
					"cut" : {
						name : "Edit",
						icon : "cut"
					},
					"copy" : {
						name : "Remove",
						icon : "copy"
					},
					"paste" : {
						name : "Force Remove",
						icon : "paste"
					},
					"delete" : {
						name : "Guide Me",
						icon : "delete"
					},
					"quit" : {
						name : "Re-Initialize Data Center",
						icon : "quit"
					}
				}
			};
		}
	});
});

var reloadData = function() {
	if (sessionStorage["auth"] == null || sessionStorage["user"] == null) {
		window.location.href = "login.html";
		return;
	}
	
	$.ajax({
		type: "GET",
		url: "/api/clusters",
		beforeSend: function(xhr) {
			xhr.setRequestHeader("Accept", "application/json");
			xhr.setRequestHeader("Authorization", "Basic " + sessionStorage["auth"]);
		},
		success: function(data) {
			var allcls = data.cluster;
			for (var i in allcls) {
				var cl = allcls[i];
				if (cl.name === "Default") {
					DEFAULT_CLUSTER_ID = cl.id;
					break;
				}
			}
		}
	});
	
	$.ajax({
		type : "GET",
		url : "/api/vms",
		beforeSend : function(xhr) {
			xhr.setRequestHeader("Accept", "application/json");
			xhr.setRequestHeader("Authorization", "Basic " + sessionStorage["auth"]);
		},
		success : function(data) {
			var allvms = data.vm;
			
			for (var i in allvms) {
				if (allvms[i].host != null) {
					var hostjson = $.ajax({
						type : "GET",
						url : allvms[i].host.href,
						beforeSend : function(xhr) {
							xhr.setRequestHeader("Accept", "application/json");
							xhr.setRequestHeader("Authorization", "Basic " + sessionStorage["auth"]);
						},
						async : false
					});
					allvms[i].host_name = hostjson.responseJSON.name;
				} else {
					allvms[i].host_name = "";
				}
				
				var clusterjson = $.ajax({
					type : "GET",
					url : allvms[i].cluster.href,
					beforeSend : function(xhr) {
						xhr.setRequestHeader("Accept", "application/json");
						xhr.setRequestHeader("Authorization", "Basic " + sessionStorage["auth"]);
					},
					async : false
				});
				allvms[i].cluster.name = clusterjson.responseJSON.name;
				
				var dcjson = $.ajax({
					type : "GET",
					url : clusterjson.responseJSON.data_center.href,
					beforeSend : function(xhr) {
						xhr.setRequestHeader("Accept", "application/json");
						xhr.setRequestHeader("Authorization", "Basic " + sessionStorage["auth"]);
					},
					async : false
				})
				allvms[i].dcname = dcjson.responseJSON.name;
				
				allvms[i].ip = "";
				allvms[i].fqdn = "";
			}
			
			if (vmtable != null) {
				vmtable.clear();
				vmtable.destroy();
			}
			
			vmtable = $("#vmstable").DataTable({
				"dom" : '<"top"p>rt<"bottom">',
				"info" : false,
				"pageLength" : 10,
				"data" : allvms,
				"columns" : VM_COLUMNS,
				"filter" : false,
				"lengthChange" : false,
				"language" : {
					"paginate" : {
						"previous" : "<",
						"next" : ">"
					}
				},
				"columnDefs" : [{
					/*"targets" : [4, 5, 6,7,8,9],
					"render" : function(data, x, full, meta) {
						return "";
					}*/
				}]
			});
		}
	});
};

$(document).ready(function() {
	$("#newvmbutton").on("click", function() {
		$("#nvmname").val("");
		$("#nvmdesc").val("");
		$("#nvmcomment").val("");
		$.ajax({
			type : "GET",
			url : "/api/clusters/" + DEFAULT_CLUSTER_ID + "/networks",
			beforeSend : function(xhr) {
				xhr.setRequestHeader("Accept", "application/json");
				xhr.setRequestHeader("Authorization", "Basic " + sessionStorage["auth"]);
			},
			success : function(data) {
				var allnets = data.network;
				for (var i in allnets) {
					$("#nvmnic").append(new Option(allnets[i].name, allnets[i].name, false));
				}
				
				$.ajax({
					type: "GET",
					url: "/api/storagedomains",
					beforeSend : function(xhr) {
						xhr.setRequestHeader("Accept", "application/json");
						xhr.setRequestHeader("Authorization", "Basic " + sessionStorage["auth"]);
					},
					success : function(data) {
						var alldisks = data.storage_domain;
						for (var i in alldisks) {
							var disk = alldisks[i];
							var totalsize = disk.available + disk.used;
							disk.totalsizeGB = totalsize / 1024 / 1024 / 1024 + " GB";
							
							disk.availableGB = disk.available / 1024 / 1024 / 1024 + " GB";
							
							if (disk.status != null && disk.status.state != null) {
								disk.attachstatus = disk.status.state;
							} else {
								disk.attachstatus = "Active";
							}
							
							if (disk.attachstatus == "Active") {
								$("#nvmsdomain").append(new Option(disk.name + "(" + disk.availableGB + "/" + disk.totalsizeGB + ")", disk.name, false));
							}
						}
						$("#newvmmodal").modal("show");
					}
				});
				
			},
			error: function(neterr) {
				alert(neterr.responseJSON.detail);
			}
		});
	});
	
	$("#refreshbutton").on("click", function() {
		reloadData();
	});
	
	$("#addvmbutton").on("click", function() {
		$.ajax({
			type : "POST",
			url : "/api/vms",
			beforeSend : function(xhr) {
				xhr.setRequestHeader("Accept", "application/json");
				xhr.setRequestHeader("Content-Type", "application/xml");
				xhr.setRequestHeader("Authorization", "Basic " + sessionStorage["auth"]);
			},
			data: "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><vm><name>" + $("#nvmname").val() + "</name>" +
			"<template><name>Blank</name></template><os type=\"" + $("#nvmos option:selected").val() + "\" /><type>" + $("#nvtype option:selected").val() + "</type>" +
			"<description>" + $("#nvmdesc").val() + "</description><comment>" + $("#nvmcomment").val() + "</comment><cluster><name>Default</name></cluster></vm>",
			success: function(vmdata) {
				var vmid = vmdata.id;
				$.ajax({
					type: "GET",
					url: "/api/vnicprofiles",
					beforeSend : function(xhr) {
						xhr.setRequestHeader("Accept", "application/json");
						xhr.setRequestHeader("Authorization", "Basic " + sessionStorage["auth"]);
					},
					success: function(nicpdata) {
						var nicps = nicpdata.vnic_profile;
						for (var i in nicps) {
							if (nicps[i].name == $("#nvmnic option:selected").val()) {
								var nicid = nicps[i].id;
								$.ajax({
									type: "POST",
									url: "/api/vms/" + vmid + "/nics",
									beforeSend : function(xhr) {
										xhr.setRequestHeader("Accept", "application/json");
										xhr.setRequestHeader("Content-Type", "application/xml");
										xhr.setRequestHeader("Authorization", "Basic " + sessionStorage["auth"]);
									},
									data: "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><nic><name>nic1</name><vnic_profile id=\"" + nicid + "\" /></nic>",
									success: function(addnicdata) {
										var dsize = $("#nvmdisk").val();
										dsize = Number(dsize) * 1024 * 1024 * 1024;
										$.ajax({
											type: "POST",
											url: "/api/vms/" + vmid + "/disks",
											beforeSend : function(xhr) {
												xhr.setRequestHeader("Accept", "application/json");
												xhr.setRequestHeader("Content-Type", "application/xml");
												xhr.setRequestHeader("Authorization", "Basic " + sessionStorage["auth"]);
											},
											data: "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><disk><provisioned_size>" + dsize + "</provisioned_size>" +
											"<size>" + dsize + "</size><interface>virtio</interface><format>raw</format><alias>" + $("#nvmname").val() + "_Disk1</alias>" +
											"<name>" + $("#nvmname").val() + "_Disk1</name><bootable>true</bootable><storage_domains><storage_domain><name>" +
											$("#nvmsdomain option:selected").val() + "</name></storage_domain></storage_domains></disk>",
											success: function(diskdata) {
												reloadData();
											},
											error: function(diskerr) {
												alert(diskerr.responseJSON.detail);
											}
										});
									},
									error: function(nicerr) {
										alert(nicerr.responseJSON.detail);
									}
								});
							}
						}
					},
					error: function(getnicerr) {
						alert(getnicerr.responseJSON.detail);
					}
				});
			}
		})
	});

	// $('.page.ui.modal').modal('show');
	// $('.newnet.ui.modal').modal('show');
	// $('.newuser.ui.modal').modal('show');
	// $('.attachiso.ui.modal').modal('show');
	$dropdownItem = $('.menu .dropdown .item'), $menuItem = $(
			'.menu a.item').not($dropdownItem), $('.ui.checkbox')
			.checkbox();
	$('.ui.radio.checkbox').checkbox();
	handler = {
		activate : function() {
			if (!$(this).hasClass('dropdown')) {
				$(this).addClass('active').closest('.ui.menu').find(
						'.item').not($(this)).removeClass('active');
			}
		}

	};
	$menuItem.on('click', handler.activate);
	$('.menu .item').tab();

	$('.selection.dropdown').dropdown('setting', 'transition',
			'vertical flip').dropdown('set selected');

	reloadData();
});