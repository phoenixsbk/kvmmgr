var MENU_NAME = "networkshref";

var NETWORK_COLUMNS = [ {
	data : "name",
	title : "Name",
	type : "string",
	width : "100px"
}, {
	data : "dcname",
	title : "Datacenter",
	type : "string",
	width : "100px"
}, {
	data : "description",
	title : "Description",
	type : "string",
	width : "200px"
}, {
	data : "usages.usage",
	title : "Role",
	type : "string",
	width : "100px"
}, {
	data : "vlantag",
	title : "VLan Tag",
	type : "string",
	width : "50px"
}, {
	data : "netlabels",
	title : "Label",
	type : "string",
	width : "100px"
}, {
	data : "provider",
	title : "Provider",
	type : "string",
	width : "100px"
} ];
$(function() {
	$.contextMenu({
		selector : '#networktable td',
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
		url : "/api/networks",
		beforeSend : function(xhr) {
			xhr.setRequestHeader("Accept", "application/json");
			xhr.setRequestHeader("Authorization", "Basic " + sessionStorage["auth"]);
		},
		success : function(data) {
			var allnets = data.network;
			for (var i in allnets) {
				var n = allnets[i];
				var dcname = $.ajax({
					type : "GET",
					url : n.data_center.href,
					beforeSend : function(xhr) {
						xhr.setRequestHeader("Accept", "application/json");
						xhr.setRequestHeader("Authorization", "Basic " + sessionStorage["auth"]);
					},
					async : false
				});
				n.dcname = dcname.responseJSON.name;
				
				var netlink = n.link;
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
				
				if (n.vlan == null) {
					n.vlantag = "-";
				} else {
					n.vlantag = n.vlan.id;
				}
				
				if (n.provider == null) {
					n.provider = "-";
				}
			}
			
			$("#networktable").dataTable({
				"dom" : '<"top"p>rt<"bottom">',
				"info" : false,
				"pageLength" : 10,
				"data" : allnets,
				"columns" : NETWORK_COLUMNS,
				"filter" : false,
				"lengthChange" : false,
				"language" : {
					"paginate" : {
						"previous" : "<",
						"next" : ">"
					}
				}
			});
		}
	})
};

$(document).ready(
		function() {
			$("#newnetbutton").on("click", function() {
				$("newnetmodal").modal("show");
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