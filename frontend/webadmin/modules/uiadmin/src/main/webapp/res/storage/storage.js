var MENU_NAME = "storagehref";
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
	width : "200px"
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
					console.log(DEFAULT_DC_ID);
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
			}
			$("#storagetable").dataTable({
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
				var allhosts = data.host;
				for (var i in allhosts) {
					$("#shost").append(new Option(allhosts[i].name, allhosts[i].name, false));
				}
				$("#newstoragemodal").modal("show");
			}
		});
	});
	
	$("#submitButton").on("click", function() {
		
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