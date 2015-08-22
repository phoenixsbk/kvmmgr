var MENU_NAME = "vmshref";

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
				var hostjson = $.ajax({
					type : "GET",
					url : allvms[i].placement_policy.host.href,
					beforeSend : function(xhr) {
						xhr.setRequestHeader("Accept", "application/json");
						xhr.setRequestHeader("Authorization", "Basic " + sessionStorage["auth"]);
					},
					async : false
				});
				allvms[i].host_name = hostjson.responseJSON.name;
				
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
			$("#vmstable").dataTable({
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
	$("#newstoragebutton").on("click", function() {
		$("newstoragemodal").modal("show");
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