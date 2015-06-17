var MENU_NAME = "vmshref";

var VM_COLUMNS = [ {
	data : "name",
	title : "Name",
	type : "string",
	width : "100px"
}, {
	data : "placement_policy.host.id",
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
	data : "cluster.id",
	title : "Cluster",
	type : "string",
	width : "50px"
}, {
	data : "dc",
	title : "Data Center",
	type : "string",
	width : "100px"
}, {
	data : "mem",
	title : "Memory",
	type : "string",
	width : "100px"
}, {
	data : "cpu",
	title : "CPU",
	type : "string",
	width : "100px"
}, {
	data : "network",
	title : "Network",
	type : "string",
	width : "100px"
}, {
	data : "migration",
	title : "Migration",
	type : "string",
	width : "100px"
}, {
	data : "display",
	title : "Display",
	type : "string",
	width : "100px"
}, {
	data : "status",
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
$(document).ready(
		function() {
			$('.ui.dropdown').dropdown()
			$('.ui.menu .dropdown').dropdown({
				on : 'hover'
			});
			$('.right.menu .dropdown').dropdown({
				on : 'hover'
			});
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

			$.ajax({
				type : "GET",
				url : "/api/vms",
				beforeSend : function(xhr) {
					xhr.setRequestHeader("Accept", "application/json");
				},
				success : function(data) {
					var allvms = data.vm;
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
							"targets" : [4, 5, 6,7,8,9],
							"render" : function(data, x, full, meta) {
								return "";
							}
						}]
					});
				}
			})
		});