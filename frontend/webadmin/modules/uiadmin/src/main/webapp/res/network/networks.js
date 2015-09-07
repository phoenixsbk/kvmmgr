var MENU_NAME = "networkshref";

var DEFAULT_CLUSTER_ID = "";
var ndatatable = null;

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
				
				if (n.description == null) {
					n.description = "";
				}
				
				if (n.vlan == null) {
					n.vlantag = "-";
				} else {
					n.vlantag = n.vlan.id;
				}
			}
			
			if (ndatatable != null) {
				ndatatable.clear();
				ndatatable.destroy();
			}
			
			ndatatable = $("#networktable").DataTable({
				"dom" : '<"top"p>rt<"bottom">',
				"info" : false,
				"pageLength" : 10,
				"data" : allnets,
				"columns" : NETWORK_COLUMNS,
				"filter" : false,
				"lengthChange" : false,
				"select": {
					"style": "single"
				},
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

$(document).ready(function() {
	$("#newnetbutton").on("click", function() {
		$("#nname").val("");
		$("#ndesc").val("");
		$("#ncomment").val("");
		$("#nmtucustomval").val("");
		$("#ntag").val("");
		$("#newnetmodal").modal("show");
	});
	
	$("#editnetbutton").on("click", function() {
		if (ndatatable.rows(".selected") != null) {
			var selnet = ndatatable.rows(".selected").data()[0];
			
			$("#enname").val(selnet.name);
			$("#endesc").val(selnet.description);
			$("#encomment").val(selnet.comment);
			if (selnet.label != null) {
				$("#elabel").val(selnet.label);
			}
			var mtu = selnet.mtu;
			if (mtu == "0") {
				$("#enmtudefault").prop("checked", true);
			} else {
				$("#entmtucustom").prop("checked", true);
				$("#enmtucustomval").val(mtu);
			}
			
			var allusg = selnet.usages;
			if (allusg != null && allusg.usage != null) {
				for (var i in allusg.usage) {
					if (allusg.usage[i] == "vm") {
						$("#envmnet").prop("checked", true);
						break;
					}
				}
			}
			
			if (selnet.vlan != null && selnet.vlan.id != null) {
				$("#entag").val(selnet.vlan.id);
				$("#entagcheck").prop("checked", true);
			}
			
			$("#enetmodal").modal("show");
		} else {
			alert("No Row Selected.");
		}
	});
	
	$("#rmnetbutton").on("click", function() {
		if (ndatatable.rows(".selected") != null) {
			var selnet = ndatatable.rows(".selected").data()[0];
			$.ajax({
				type: "DELETE",
				url: selnet.href,
				beforeSend : function(xhr) {
					xhr.setRequestHeader("Accept", "application/json");
					xhr.setRequestHeader("Authorization", "Basic " + sessionStorage["auth"]);
				},
				success: function(data) {
					reloadData();
				},
				error: function(err) {
					alert(err.responseJSON.detail);
				}
			});
		}
	});
	
	$("#refreshbutton").on("click", function() {
		reloadData();
	});
	
	$("#addnetbutton").on("click", function() {
		var mtu = "1500";
		if ($("#nmtucustom").prop("checked")) {
			mtu = $("#nmtucustomval").val();
			if (mtu == null) {
				mtu = "1500";
			}
		}
		
		var vlanxml = "";
		if ($("#ntagcheck").prop("checked")) {
			var vlantag = $("#ntag").val();
			if (vlantag != null && vlantag != "") {
				vlanxml = "<vlan id=\"" + vlantag + "\" />";
			}
		}
		
		$.ajax({
			type: "POST",
			url: "/api/networks",
			beforeSend : function(xhr) {
				xhr.setRequestHeader("Accept", "application/json");
				xhr.setRequestHeader("Content-Type", "application/xml");
				xhr.setRequestHeader("Authorization", "Basic " + sessionStorage["auth"]);
			},
			data: "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><network><data_center><name>Default</name></data_center><name>" +
			$("#nname").val() + "</name><description>" + $("#ndesc").val() + "</description><comment>" + $("#ncomment").val() + "</comment><mtu>" +
			mtu + "</mtu>" + vlanxml + "<usages><usage>vm</usage></usages><cluster id=\"" + DEFAULT_CLUSTER_ID + "\" /></network>",
			success: function(data) {
				reloadData();
			},
			error: function(err) {
				alert(err.responseJSON.detail);
			}
		});
	});
	
	$("#ednetbutton").on("click", function() {
		var selnet = ndatatable.rows(".selected").data()[0];
		var selnetid = selnet.id;
		
		var mtu = "1500";
		if ($("#enmtucustom").prop("checked")) {
			mtu = $("#enmtucustomval").val();
			if (mtu == null) {
				mtu = "1500";
			}
		}
		
		var vlanxml = "";
		if ($("#entagcheck").prop("checked")) {
			var vlantag = $("#entag").val();
			if (vlantag != null && vlantag != "") {
				vlanxml = "<vlan id=\"" + vlantag + "\" />";
			}
		}
		
		$.ajax({
			type : "PUT",
			url : "/api/networks/" + selnetid,
			beforeSend : function(xhr) {
				xhr.setRequestHeader("Content-Type", "application/xml");
				xhr.setRequestHeader("Authorization", "Basic " + sessionStorage["auth"]);
			},
			data : "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><network><name>" + $("#enname").val() +
			"</name><description>" + $("#endesc").val() + "</description><comment>" + $("#encomment").val() + "</comment><mtu>" +
			mtu + "</mtu>" + vlanxml + "<usages><usage>vm</usage></usages></network>",
			success: function(data) {
				reloadData();
			},
			error: function(err) {
				alert(err.detail);
			}
		});
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