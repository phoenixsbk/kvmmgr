var MENU_NAME = "vmshref";

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
			url : "/api/networks",
			beforeSend : function(xhr) {
				xhr.setRequestHeader("Accept", "application/json");
				xhr.setRequestHeader("Authorization", "Basic " + sessionStorage["auth"]);
			},
			success : function(data) {
				var allnets = data.network;
				for (var i in allnets) {
					var netlink = allnets[i].link;
					for (var j in netlink) {
						var linkj = netlink[j];
						if (linkj.rel == "labels") {
							var linklabels = $.ajax({
								type : "GET",
								url : linkj.href,
								beforeSend : function(xhr) {
									xhr.setRequestHeader("Accept", "application/json");
									xhr.setRequestHeader("Authorization", "Basic " + sessionStorage["auth"]);
								},
								async : false
							});
							var labelObj = linklabels.responseJSON;
							if (labelObj.label == null) {
								n.netlabels = "-";
							} else {
								var labelAry = labelObj.label;
								var finalLabel = "";
								for (var k in labelAry) {
									var labelEle = labelAry[k];
									finalLabel += labelEle.id;
								}
								n.netlabels = finalLabel;
							}
						}
					}
				}
		$("#newvmmodal").modal("show");
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
				xhr.setRequestHeader("Authorization", "Basic " + sessionStorage["auth"]);
			},
			data: "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"
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