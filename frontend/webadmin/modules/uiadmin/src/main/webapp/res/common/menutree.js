var MENU_ITEMS = ["datacentershref","clustershref","hostshref","networkshref","storagehref","diskshref",
                  "vmshref","poolshref","templateshref","volumeshref","usershref","eventshref"];
var MENU_LINKS = ["datacenters.html","clusters.html","hosts.html","networks.html","storage.html","disks.html",
                  "vms.html","pools.html","templates.html","volumes.html","users.html","events.html"];

$(document).ready(function() {
	$("#menucontainer").load("menutree.inc", function() {
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
});