var MENU_NAME = "storagehref";
var storagetable = null;
var DEFAULT_DC_ID = "";

var STORAGE_COLUMNS = [ {
	data : "name",
	title : "Domain Name",
	type : "string",
	width : "100px"
}, {
	data : "type",
	title : "Domain Type",
	type : "string",
	width : "100px"
}, {
	data : "storage.type",
	title : "Storage Type",
	type : "string",
	width : "100px"
}, {
	data: "attachstatus",
	title: "Cross Datacenter Status",
	type: "string",
	width: "100px"
}, {
	data : "storage_format",
	title : "Format",
	type : "string",
	width : "100px"
}, {
	data : "totalsizeGB",
	title : "Total Space",
	type : "string",
	width : "100px"
}, {
	data : "availableGB",
	title : "Free Space",
	type : "string",
	width : "100px"
}, {
	data : "description",
	title : "Description",
	type : "string",
	width : "100px"
} ];
$(function() {
	$.contextMenu({
		selector : '#storagetable td',
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
	if (sessionStorage["user"] == null || sessionStorage["auth"] == null) {
		window.location.href = "login.html";
		return
	}
	
	$.ajax({
		type: "GET",
		url: "/api/datacenters",
		beforeSend: function(xhr) {
			xhr.setRequestHeader("Accept", "application/json");
			xhr.setRequestHeader("Authorization", "Basic " + sessionStorage["auth"]);
		},
		success: function(data) {
			var alldcs = data.data_center;
			for (var i in alldcs) {
				var cl = alldcs[i];
				if (cl.name === "Default") {
					DEFAULT_DC_ID = cl.id;
					break;
				}
			}
		}
	});
	
	$.ajax({
		type : "GET",
		url : "/api/storagedomains",
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
				
				if (disk.description == null) {
					disk.description = "";
				}
				
				if (disk.status != null && disk.status.state != null) {
					disk.attachstatus = disk.status.state;
				} else {
					disk.attachstatus = "Active";
				}
			}
			
			if (storagetable != null) {
				storagetable.clear();
				storagetable.destroy();
			}
			
			storagetable = $("#storagetable").DataTable({
				"dom" : '<"top"p>rt<"bottom">',
				"info" : false,
				"pageLength" : 10,
				"data" : alldisks,
				"columns" : STORAGE_COLUMNS,
				"filter" : false,
				"select": {
					"style": "single"
				},
				"lengthChange" : false,
				"language" : {
					"paginate" : {
						"previous" : "<",
						"next" : ">"
					}
				}
			});
		}
	});
};

var waitJobAndDelete = function(joburl, storageid) {
	$.ajax({
		type: "GET",
		url: joburl,
		beforeSend: function(xhr) {
			xhr.setRequestHeader("Accept", "application/json");
			xhr.setRequestHeader("Authorization", "Basic " + sessionStorage["auth"]);
		},
		success: function(jdata) {
			if (jdata.status.state == "FINISHED") {
				setTimeout(function() { deleteJob(storageid); }, 10500);
			} else {
				setTimeout(function() {
					waitJobAndDelete(joburl, storageid);
				}, 3700);
			}
		},
		error: function(edata) {
			console.log(edata);
			alert(edata.responseJSON.detail);
		}
	});
};

var deleteJob = function(storageid) {
	$.ajax({
		type: "DELETE",
		url: "/api/datacenters/" + DEFAULT_DC_ID + "/storagedomains/" + storageid,
		beforeSend : function(xhr) {
			xhr.setRequestHeader("Accept", "application/json");
			xhr.setRequestHeader("Authorization", "Basic " + sessionStorage["auth"]);
		},
		success: function(sddata) {
			reloadData();
		},
		error: function(errr) {
			console.log(errr);
			alert(errr.responseJSON.detail);
		}
	});
}

$(document).ready(function() {
	$("#newstoragebutton").on("click", function() {
		$.ajax({
			type : "GET",
			url : "/api/hosts",
			beforeSend : function(xhr) {
				xhr.setRequestHeader("Accept", "application/json");
				xhr.setRequestHeader("Authorization", "Basic " + sessionStorage["auth"]);
			},
			success : function(data) {
				$("#shost").find("option").remove();
				var allhosts = data.host;
				for (var i in allhosts) {
					$("#shost").append(new Option(allhosts[i].name, allhosts[i].name, false));
				}
				$("#sname").val("");
				$("#scomment").val("");
				$("#sdesc").val("");
				$("#spath").val("");
				$("#newstoragemodal").modal("show");
			}
		});
	});
	
	$("#rmstoragebutton").on("click", function() {
		if (storagetable.row(".selected") != null) {
			var selstorage = storagetable.row(".selected").data();
			$.ajax({
				type: "GET",
				url: "/api/hosts",
				beforeSend: function(xhr) {
					xhr.setRequestHeader("Accept", "application/json");
					xhr.setRequestHeader("Authorization", "Basic " + sessionStorage["auth"]);
				},
				success: function(hdata) {
					var allhs = hdata.host;
					var selhostname = "";
					for (var i in allhs) {
						var hadd = allhs[i].address;
						if (hadd == selstorage.storage.address) {
							selhostname = allhs[i].name;
							break;
						}
					}
					
					if (selhostname != "") {
						$.ajax({
							type: "DELETE",
							url: "/api/storagedomains/" + selstorage.id,
							beforeSend : function(xhr) {
								xhr.setRequestHeader("Accept", "application/json");
								xhr.setRequestHeader("Authorization", "Basic " + sessionStorage["auth"]);
								xhr.setRequestHeader("Content-Type", "application/xml");
							},
							data: "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><storage_domain><host><name>" +
							selhostname + "</name></host></storage_domain>",
							success: function(ddata) {
								reloadData();
							},
							error: function(err) {
								console.log(err);
								alert(err.responseJSON.detail);
							}
						});
					} else {
						alert("No Host found match the storage");
					}
				}
			});
			
		}
	});
	
	$("#newstoragesubmitbutton").on("click", function() {
		var allpath = $("#spath").val().split(":");
		$.ajax({
			type: "POST",
			url: "/api/storagedomains",
			beforeSend : function(xhr) {
				xhr.setRequestHeader("Accept", "application/json");
				xhr.setRequestHeader("Authorization", "Basic " + sessionStorage["auth"]);
				xhr.setRequestHeader("Content-Type", "application/xml");
			},
			data: "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><storage_domain><host><name>" + $("#shost option:selected").val() +
			"</name></host><type>data</type><format>true</format><name>" + $("#sname").val() + "</name><comment>" + $("#scomment").val() + "</comment><storage>" +
			"<type>" + $("#stype option:selected").val() + "</type><address>" + allpath[0] + "</address><path>" + allpath[1] + "</path></storage><storage_format>v3</storage_format></storage_domain>",
			success: function(data) {
				console.log(data);
				reloadData();
			},
			error: function(err) {
				console.log(err);
				alert(err.responseJSON.detail);
			}
		});
	});
	
	$("#activatestoragebutton").on("click", function() {
		if (storagetable.row(".selected") != null) {
			var selstorage = storagetable.row(".selected").data();
			if (selstorage.attachstatus != "unattached") {
				alert("Storage is not in unattached status");
				return;
			}
			
			$.ajax({
				type: "POST",
				url: "/api/datacenters/" + DEFAULT_DC_ID + "/storagedomains",
				beforeSend : function(xhr) {
					xhr.setRequestHeader("Accept", "application/json");
					xhr.setRequestHeader("Authorization", "Basic " + sessionStorage["auth"]);
					xhr.setRequestHeader("Content-Type", "application/xml");
				},
				data: "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><storage_domain><name>" +
				selstorage.name + "</name></storage_domain>",
				success: function(sdata) {
					setTimeout(reloadData, 3000);
				},
				error: function(err) {
					console.log(err);
					alert(err.responseJSON.detail);
				}
			});
		}
	});
	
	$("#deactivatestoragebutton").on("click", function() {
		if (storagetable.row(".selected") != null) {
			var selstorage = storagetable.row(".selected").data();
			if (selstorage.attachstatus != "Active") {
				alert("Storage is not in active status");
				return;
			}
			
			$.ajax({
				type: "POST",
				url: "/api/datacenters/" + DEFAULT_DC_ID + "/storagedomains/" + selstorage.id + "/deactivate",
				beforeSend : function(xhr) {
					xhr.setRequestHeader("Accept", "application/json");
					xhr.setRequestHeader("Authorization", "Basic " + sessionStorage["auth"]);
					xhr.setRequestHeader("Content-Type", "application/xml");
				},
				data: "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><action></action>",
				success: function(sdata) {
					waitJobAndDelete(sdata.job.href, selstorage.id);
				},
				error: function(err) {
					console.log(err);
					alert(err.responseJSON.detail);
				}
			});
		}
	});
	
	$("#refreshstoragebutton").on("click", function() {
		reloadData();
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