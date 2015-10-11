
$(document).ready(function() {
	$.ajax({
		type: "GET",
		url: "/api/license/machinecode",
		success: function(data) {
			$("#mcode").html(data);
		},
		error: function(err) {
			alert(err);
		}
	});
	
	$.ajax({
		type: "GET",
		url: "/api/license/all",
		success: function(alldata) {
			console.log(alldata);
			$("#clicense").html(alldata);
		},
		error: function(allerr) {
			console.log(allerr);
			alert(allerr);
		}
	});
	
    $('#inputkey').on("click", function(){
    	$('.inputkey.ui.modal').modal('show');
    });
    
    $("#keysubmitbutton").on("click", function() {
    	if ($("#licensetext").val() != "") {
    		$.ajax({
    			type: "POST",
    			url: "/api/license",
    			data: $("#licensetext").val(),
    			success: function(data) {
    				console.log(data);
    				alert("License Update Successfully.");
    			},
    			error: function(err) {
    				console.log(err);
    				alert(err);
    			}
    		});
    	}
    });
    
	$('.selection.dropdown').dropdown();
	$('.ui.checkbox').checkbox();
	$("#LoginButton").on("click", function(event) {
		if ($("#userName").val() == "" || $("#userPwd").val() == "") {
			alert("Please input valid username and passowrd.");
			return;
		}
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
				alert(err);
			}
		});
	});
});