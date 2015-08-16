var MENU_NAME = "hostshref";

var DEFAULT_CLUSTER_ID = "";

var HOST_COLUMNS = [ {
	data : "name",
	title : "Name",
	type : "string",
	width : "50px"
}, {
	data : "cluster.name",
	title : "Cluster",
	type : "string",
	width : "100px"
}, {
	data : "status.state",
	title : "Status",
	type : "string",
	width : "100px"
}, {
	data : "version",
	title : "Compatibility Version",
	type : "numeric",
	width : "100px"
}, {
	data : "cpu.name",
	title : "Cluster CPU Type",
	type : "string",
	width : "100px"
}, {
	data : "hostcount",
	title : "Host Count",
	type : "numeric",
	width : "100px"
}, {
	data : "vmcount",
	title : "VM Count",
	type : "numeric",
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
						name : "Edit",
						icon : "edit"
					},
					"cut" : {
						name : "Cut",
						icon : "cut"
					},
					"copy" : {
						name : "Copy",
						icon : "copy"
					},
					"paste" : {
						name : "Paste",
						icon : "paste"
					},
					"delete" : {
						name : "Delete",
						icon : "delete"
					},
					"sep1" : "---------",
					"quit" : {
						name : "Quit",
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
	}
	
	$.ajax({
		type : "GET",
		url : "/api/hosts",
		beforeSend : function(xhr) {
			xhr.setRequestHeader("Accept", "application/json");
			xhr.setRequestHeader("Authorization", "Basic " + sessionStorage["auth"]);
		},
		success : function(data) {
			var allhosts = data.host;
			for ( var i in allhosts) {
				var cl = allhosts[i];
				var dcjson = $.ajax({
					type : "GET",
					url : cl.cluster.href,
					beforeSend : function(xhr) {
						xhr.setRequestHeader("Accept", "application/json");
						xhr.setRequestHeader("Authorization", "Basic " + sessionStorage["auth"]);
					},
					async : false
				});
				cl.cluster.name = dcjson.responseJSON.name;
				cl.hostcount = 0;
				cl.vmcount = 0;
				DEFAULT_CLUSTER_ID = cl.cluster.id;
			}
			
			$("#hosttable").dataTable({
				"dom" : '<"top"p>rt<"bottom">',
				"info" : false,
				"pageLength" : 7,
				"data" : allhosts,
				"columns" : HOST_COLUMNS,
				"filter" : false,
				"lengthChange" : false,
				"language" : {
					"Paginate" : {
						"Previous" : "<",
						"Next" : ">"
					}
				},
				"columnDefs" : [ {
					"targets" : [ 3 ],
					"render" : function(data, type, full, meta) {
						return full.version.major + "." + full.version.minor;
					}
				} ]
			});
		}
	});
}


$(document).ready(function() {
	$('.ui.dropdown').dropdown()
	$('.ui.menu .dropdown').dropdown({
		on : 'hover'
	});
	$('.right.menu .dropdown').dropdown({
		on : 'hover'
	});

	$("#newhostbutton").on("click", function() {
		$("#newhostmodal").modal("show");
	});
	
	$("#submitButton").on("click", function() {
		$.ajax({
			type : "POST",
			url : "/api/hosts",
			beforeSend : function(xhr) {
				xhr.setRequestHeader("Content-Type", "application/xml");
				xhr.setRequestHeader("Authorization", "Basic " + sessionStorage["auth"]);
			},
			data : "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><host><name>" +
			$("#hname").val() + "</name><address>" + $("#haddress").val() + "</address><root_password>" +
			$("#hpwd").val() + "</root_password><cluster id=\"" + DEFAULT_CLUSTER_ID + "\" /></host>",
			success : function(data) {
				reloadData();
			},
			error : function(err) {
				console.log(err);
			}
		})
	});

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