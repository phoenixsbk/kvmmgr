
$(document).ready(function() {
	$('.selection.dropdown').dropdown();
	$('.ui.checkbox').checkbox();
	$("#LoginButton").on("click", function(event) {
		var uname = $("#userName").val() + "@internal";
		var upwd = $("#userPwd").val();
		$.ajax({
			type : "GET",
			url : "/api/users",
			beforeSend : function(xhr) {
				xhr.setRequestHeader("Accept", "application/json");
				xhr.setRequestHeader("Authorization", "Basic " + btoa(uname + ":" + upwd));
			},
			success : function(data) {
				var allUser = data.user;
				for (var i in allUser) {
					if (allUser[i].user_name === uname) {
						sessionStorage["user"] = allUser[i];
						sessionStorage["auth"] = btoa(uname + ":" + upwd);
						
						window.location.href = "hosts.html";
					}
				}
			},
			error : function (err) {
				console.log(err);
			}
		});
	});
});