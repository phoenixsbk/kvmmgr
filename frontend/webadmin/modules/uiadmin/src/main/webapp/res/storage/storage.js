var MENU_NAME = "storagehref";

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
	data : "cross_dc_status",
	title : "Cross Datacenter Status",
	type : "string",
	width : "50px"
}, {
	data : "total_space",
	title : "Total Space",
	type : "string",
	width : "100px"
}, {
	data : "free_space",
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
				url : "/api/storagedomains",
				beforeSend : function(xhr) {
					xhr.setRequestHeader("Accept", "application/json");
				},
				success : function(data) {
					var alldisks = data.storage_domain;
					$("#storagetable").dataTable({
						"dom" : '<"top"p>rt<"bottom">',
						"info" : false,
						"pageLength" : 10,
						"data" : alldisks,
						"columns" : STORAGE_COLUMNS,
						"filter" : false,
						"lengthChange" : false,
						"language" : {
							"paginate" : {
								"previous" : "<",
								"next" : ">"
							}
						},
						"columnDefs" : [{
							"targets" : [4, 5, 6],
							"render" : function(data, x, full, meta) {
								return "";
							}
						}]
					});
				}
			})
		});