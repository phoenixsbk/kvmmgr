var MENU_NAME = "hostshref";

var HOST_COLUMNS = [{
    data : "name",
    title : "Name",
    type:"string",
    width:"50px"
  },{
    data : "data_center.name",
    title:"Data Center",
    type:"string",
    width:"100px"
  },{
    data : "version",
    title: "Compatibility Version",
    type:"numeric",
    width:"100px"
  },{
    data : "description",
    title:"Description",
    type : "string",
    width:"100px"
  },{
    data:"cpu",
    title:"Cluster CPU Type",
    type:"string",
     width:"100px"
  },{
    data:"hostcount",
    title:"Host Count",
    type:"numeric",
     width:"100px"
  },{
    data:"vmcount",
    title:"VM Count",
    type:"numeric",
     width:"100px"
  }];

$(function(){
    $.contextMenu({
        selector: '#vmstable td', 
        build: function($trigger, e) {
            // this callback is executed every time the menu is to be shown
            // its results are destroyed every time the menu is hidden
            // e is the original contextmenu event, containing e.pageX and e.pageY (amongst other data)
            return {
                callback: function(key, options) {
                    var m = "clicked: " + key;
                    window.console && console.log(m) || alert(m); 
                },
                items: {
                    "edit": {name: "Edit", icon: "edit"},
                    "cut": {name: "Cut", icon: "cut"},
                    "copy": {name: "Copy", icon: "copy"},
                    "paste": {name: "Paste", icon: "paste"},
                    "delete": {name: "Delete", icon: "delete"},
                    "sep1": "---------",
                    "quit": {name: "Quit", icon: "quit"}
                }
            };
        }
    });
});
$(document)
  .ready(function(){
    $('.ui.dropdown')
      .dropdown()
    $('.ui.menu .dropdown')
      .dropdown({
        on: 'hover'
      });
    $('.right.menu .dropdown').dropdown({on:'hover'});
    
    $("#newhostbutton").on("click", function() {
    	$("#newhostmodal").modal("show");
    });

    // $('.page.ui.modal').modal('show');
    // $('.mgnet.ui.modal').modal('show');
    // $('.newcluster.ui.modal').modal('show');
    // $('.cpuprofile.ui.modal').modal('show');
    $dropdownItem = $('.menu .dropdown .item'),
    $menuItem     = $('.menu a.item').not($dropdownItem),
    $('.ui.checkbox').checkbox();
      $('.ui.radio.checkbox').checkbox();
     handler = {

      activate: function() {
        if(!$(this).hasClass('dropdown')) {
          $(this)
            .addClass('active')
            .closest('.ui.menu')
            .find('.item')
              .not($(this))
              .removeClass('active')
          ;
        }
      }

    };
     $menuItem.on('click', handler.activate);
     $('.menu .item').tab();

     $('.selection.dropdown')
        .dropdown('setting', 'transition', 'vertical flip')
        .dropdown('set selected');
     $.ajax({
    	type: "GET",
    	url: "/api/hosts",
    	beforeSend: function(xhr) {
    		xhr.setRequestHeader("Accept", "application/json");
    	},
    	success: function(data) {
    		var allclusters = data.cluster;
    		for (var i in allclusters) {
    			var cl = allclusters[i];
    			var dcid = cl.data_center.id;
    			var dcjson = $.ajax({
    				type: "GET",
    				url: "/api/datacenters/" + dcid,
    				beforeSend: function(xhr) {
    					xhr.setRequestHeader("Accept", "application/json");
    				},
    				async: false
    			});
    			cl.data_center.name = dcjson.responseJSON.name;
    			cl.cpu = "";
    			cl.hostcount = 0;
    			cl.vmcount = 0;
    		}
    		
    		$("#hosttable").dataTable({
    		    "dom":'<"top"p>rt<"bottom">',
    		    "info":false,
    		    "pageLength" : 7,
    		    "data": allclusters,
    		    "columns": HOST_COLUMNS,
    		    "filter" : false,               
    		    "lengthChange": false,
    		    "language":{
    		      "oPaginate":{
    		        "sPrevious":"<",
    		        "sNext":">"
    		      }
    		    },
    		    "columnDefs":[{
    		    	"targets": [2],
    		    	"render": function(data, type, full, meta) {
    		    		return full.version.major + "." + full.version.minor;
    		    	}
    		    }]
    		  });
    	}
     });
 });