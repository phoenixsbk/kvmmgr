var MENU_NAME = "hostshref";

var DEFAULT_CLUSTER_ID = "";
var hosttable = null;

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
		return
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
				cl.vmcount = 0;
			}
			
			if (hosttable != null) {
				hosttable.clearTable();
				hosttable.destroy();
			}
			
			hosttable = $("#hosttable").DataTable({
				"dom" : '<"top"p>rt<"bottom">',
				"info" : false,
				"pageLength" : 7,
				"data" : allhosts,
				"columns" : HOST_COLUMNS,
				"filter" : false,
				"lengthChange" : false,
				"select": {
					"style": "single"
				},
				"language" : {
					"Paginate" : {
						"Previous" : "<",
						"Next" : ">"
					}
				},
				"columnDefs" : [ {
					"targets" : [ 3 ],
					"render" : function(data, type, full, meta) {
						if (full.version != null && full.version.major != null && full.version.minor != null) {
							return full.version.major + "." + full.version.minor;
						} else {
							return "UNKNOWN";
						}
					}
				},	{
					"targets": [4],
					"render": function(data, type, full, meta) {
						if (full.cpu != null && full.cpu.name != null) {
							return full.cpu.name;
						} else {
							return "UNKNOWN";
						}
					}
				}]
			});
		}
	});
}


$(document).ready(function() {
	$("#newhostbutton").on("click", function() {
		$("#newhostmodal").modal("show");
	});
	
	$("#edithostbutton").on("click", function() {
		if (hosttable.rows(".selected") != null) {
			var selhost = hosttable.rows(".selected").data()[0];
			$("#ehname").val(selhost.name);
			$("#ehcomment").val(selhost.comment);
			$("#ehaddress").val(selhost.address);
			$("#ehport").val(selhost.ssh.port);
			$("#edithostmodal").modal("show");
		} else {
			alert("No Row Selected");
		}
	});
	
	$("#rmhostbutton").on("click", function() {
		if (hosttable.rows(".selected") != null) {
			var selhost = hosttable.rows(".selected").data()[0];
			$.ajax({
				type: "DELETE",
				url: "/api/hosts/" + selhost.id,
				beforeSend: function(xhr) {
					xhr.setRequestHeader("Authorization", "Basic " + sessionStorage["auth"]);
				},
				success: function(scs) {
					setTimeout(reloadData, 1000);
				},
				error: function(error) {
					alert(error);
				}
			});
		} else {
			alert("No Row Selected");
		}
	});
	
	$("#refreshbutton").on("click", function() {
		reloadData();
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
			$("#hname").val() + "</name><address>" + $("#haddress").val() + "</address><comment>" + $("#hcomment").val() + "</comment><root_password>" +
			$("#hpwd").val() + "</root_password><cluster id=\"" + DEFAULT_CLUSTER_ID + "\" /></host>",
			success : function(scs) {
				reloadData();
			},
			error : function(err) {
				console.log(err);
			}
		});
	});
	
	$("#editButton").on("click", function() {
		var selhost = hosttable.rows(".selected").data()[0];
		var selhostid = selhost.id;
		$.ajax({
			type : "PUT",
			url : "/api/hosts/" + selhostid,
			beforeSend : function(xhr) {
				xhr.setRequestHeader("Content-Type", "application/xml");
				xhr.setRequestHeader("Authorization", "Basic " + sessionStorage["auth"]);
			},
			data : "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><host><name>" +
			$("#ehname").val() + "</name><comment>" + $("#ehcomment").val() + "</comment></host>",
			success : function(scs) {
				reloadData();
			},
			error : function(err) {
				console.log(err);
			}
		});
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