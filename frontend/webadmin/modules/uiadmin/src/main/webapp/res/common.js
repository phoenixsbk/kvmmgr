var MENU_ITEMS = ["hostshref","networkshref","storagehref",
                  "vmshref","templateshref","volumeshref","usershref"];
var MENU_LINKS = ["hosts.html","networks.html","storage.html",
                  "vms.html","templates.html","volumes.html","users.html"];

$(document).ready(function() {
	$("#menucontainer").load("left.html", function() {
		$("#" + MENU_NAME).addClass("active");
		
		for (var i in MENU_ITEMS) {
			var menuid = MENU_ITEMS[i];
			$("#" + menuid).on("click", function(evt) {
				var linkhref = evt.currentTarget.id;
				for (var j in MENU_ITEMS) {
					if (MENU_ITEMS[j] == linkhref) {
						window.location.href = MENU_LINKS[j];
						return;
					}
				}
			});
		}
	});
	
	$("#topmenucontainer").load("top.html", function() {
		
	});
});