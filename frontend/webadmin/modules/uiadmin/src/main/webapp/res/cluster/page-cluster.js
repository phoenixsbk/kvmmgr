var CLUSTER_COLUMNS = [{
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

    // $('.page.ui.modal').modal('show');
    // $('.mgnet.ui.modal').modal('show');
    // $('.newcluster.ui.modal').modal('show');
    // $('.cpuprofile.ui.modal').modal('show');
    $('.vmiprofile.ui.modal').modal('show');
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


  
  /*var clusterdata = [{
    "name":"Default",
    "detail":"My Default Cluster",
    "datacenter":"Default",
    "version":3.5,
    "desc":"The default server cluster",
    "cpu":"Inter SandyBridge Family",
    "hcount":1,
    "vcount":4
  },{
    "name":"Cluster1",
    "detail":"My Default Cluster",
    "datacenter":"Amazon",
    "version":2.5,
    "desc":"The default server cluster1",
    "cpu":"Inter SandyBridge Family",
    "hcount":2,
    "vcount":3
  },{
    "name":"Cluster2",
    "detail":"My Default Cluster",
    "datacenter":"Google",
    "version":1.1,
    "desc":"The default server cluster2",
    "cpu":"Inter SandyBridge Family",
    "hcount":2,
    "vcount":5
  }];*/
     $.ajax({
    	type: "GET",
    	url: "/api/clusters",
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
    		
    		$("#clustertable").dataTable({
    		    "dom":'<"top"p>rt<"bottom">',
    		    "info":false,
    		    "pageLength" : 7,
    		    "data": allclusters,
    		    "columns": CLUSTER_COLUMNS,
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
  

  var netclm = [{
    data : "opt",
    title : " ",
    type:"string",
    width:"20px",
    orderable:false
  },{
    data : "name",
    title:"Name",
    type:"string",
    width:"100px",
    orderable:false
  },{
    data : "state",
    title:"Status",
    type:"string",
    width:"100px"
  },{
    data : "role",
    title: "Role",
    type:"string",
    width:"100px"
  },{
    data : "desc",
    title:"Description",
    type : "string",
    width:"100px"
  }];
   var netdata = [{
    "opt":"run",
    "name":"mgmt",
    "state":"Operational",
    "role":"dm",
    "desc":"Management Network"
  },{
    "opt":"run",
    "name":"mgmt1",
    "state":"Operational",
    "role":"dm",
    "desc":"Management Network1"
  },{
    "opt":"run",
    "name":"mgmt2",
    "state":"Operational",
    "role":"dm",
    "desc":"Management Network2"
  }];
$("#nettable").dataTable({
    "dom":'<"top">rt<"bottom">',
    "info":false,
    "pageLength" : 7,
    "data":netdata,
    "columns":netclm,
    "bFilter" : false,               
    "bLengthChange": false,
    "columnDefs":[{
      "targets":[0],
      "render":function(data,type,full,meta){
        return '<i class="cogs icon"></i>';
      }
    },{
      "targets":[3],
      "render":function(data,type,full,meta){
        return '<i class="desktop icon"></i><i class="sign in icon"></i>';
      }
    }]
  });
 var mgnetclm = [{
    data : "name",
    title:"Name",
    type:"string",
    width:"100px",
    orderable:false
  },{
    data : "assign",
    title:'<div class="ui checkbox"><input type="checkbox" name="terms" checked><label>Assign All</label></div>',
    type:"string",
    width:"100px"
  },{
    data : "require",
    title:'<div class="ui checkbox"><input type="checkbox" name="terms" checked><label>Required All</label></div>',
    type:"string",
    width:"100px"
  },{
    data : "vmn",
    title:"VM Network",
    type : "string",
    width:"100px"
  },{
    data : "display",
    title:"Display Network",
    type : "string",
    width:"100px"
  },{
    data : "migration",
    title:"Migration Network",
    type : "string",
    width:"100px"
  }];
  var mgnetdata = [{
    "name":"mgmt",
    "assign":"assign",
    "require":"require",
    "vmn":"vm",
    "display":"display",
    "migration":"migration"
  },{
    "name":"mgmt1",
    "assign":"assign",
    "require":"require",
    "vmn":"vm",
    "display":"display",
    "migration":"migration"
  },{
    "name":"mgmt2",
    "assign":"assign",
    "require":"require",
    "vmn":"vm",
    "display":"display",
    "migration":"migration"
  }];
  $("#mgnettable").dataTable({
    "dom":'<"top">rt<"bottom">',
    "info":false,
    "pageLength" : 7,
    "data":mgnetdata,
    "columns":mgnetclm,
    "bFilter" : false,               
    "bLengthChange": false,
    "columnDefs":[{
      "targets":[1,2],
      "render":function(data,type,full,meta){
        return '<div class="ui checkbox"><input type="checkbox" name="terms" checked><label>'+data+'</label></div>';
      }
    },{
      "targets":[3],
      "render":function(data,type,full,meta){
        return '<i class="world icon"></i>';
      }
    },{
      "targets":[4,5],
      "render":function(data,type,full,meta){
        return '<i class="selected radio icon"></i>';
      }
    }]
  });
 });