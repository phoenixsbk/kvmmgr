var MENU_NAME = "usershref";

// definition of data center columns
var USERS_COLUMNS = [ {
	data : "name",
	title : "First Name",
	type : "string",
	width : "100px"
}, {
	data : "lastname",
	title : "Last Name",
	type : "string",
	width : "100px"
}, {
	data : "user_name",
	title : "User Name",
	type : "string",
	width : "100px"
}, {
	data : "domain.name",
	title : "Authorization Provider",
	type : "string",
	width : "100px"
}, {
	data : "namespace",
	title : "Namespace",
	type : "string",
	width : "100px"
}, {
	data : "email",
	title : "Email",
	type : "string",
	width : "100px"
} ];

/*
 * Add context menu on the data center item
 */
$(function() {
	$.contextMenu({
		selector : '#userstable td',
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

function loadUsers() {
	if (sessionStorage["auth"] == null || sessionStorage["user"] == null) {
		window.location.href = "login.html";
		return;
	}
	
	$.ajax({
		type : "GET",
		url : "/api/users",
		beforeSend : function(xhr) {
			xhr.setRequestHeader("Accept", "application/json");
			xhr.setRequestHeader("Authorization", "Basic " + sessionStorage["auth"]);
		},
		success : function(data) {
			var alluser = data.user;
			for (var i in alluser) {
				var user = alluser[i];
				if (user.lastname == null) {
					user.lastname = "";
				}
				if (user.email == null) {
					user.email = "";
				}
			}
			$("#userstable").dataTable({
				"dom" : '<"top"p>rt<"bottom">',
				"info" : false,
				"pageLength" : 7,
				"data" : data.user,
				"columns" : USERS_COLUMNS,
				"bFilter" : false,
				"bLengthChange" : false,
				"oLanguage" : {
					"oPaginate" : {
						"sPrevious" : "<",
						"sNext" : ">"
					}
				},
				"columnDefs" : [ {
					"orderable" : false,
					"targets" : [ 0, 1, 2, 3 ]
				} ]
			});
		}
	});
}

/*
 * Document ready function
 */
$(document).ready(function() {
	$("#newdcbutton").on("click", function() {
		$("#newdcmodal").modal('show');
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

	loadUsers();
});