// definition of data center columns
var DATACENTER_COLUMNS = [{
    data : "name",
    title:"Name",
    type:"string",
    width:"100px"
  },{
	data : "local",
	title : "Storage Type",
	type : "string",
	width : "100px"
  },{
    data : "status.state",
    title:"Status",
    type : "string",
    width:"100px"
  },{
    data:"version.major",
    title:"Compatibility Version",
    type:"string",
     width:"100px"
  },{
    data:"description",
    title:"Description",
    type:"string",
     width:"100px"
  }];

/*
 * Add context menu on the data center item
 */
$(function(){
    $.contextMenu({
        selector: '#dctable td', 
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
                    "edit": {name: "New", icon: "edit"},
                    "cut": {name: "Edit", icon: "cut"},
                    "copy": {name: "Remove", icon: "copy"},
                    "paste": {name: "Force Remove", icon: "paste"},
                    "delete": {name: "Guide Me", icon: "delete"},
                    "quit": {name: "Re-Initialize Data Center", icon: "quit"}
                }
            };
        }
    });
});

function loadDatacenters() {
	$.ajax({
		  type: "GET",
		  url: "/api/datacenters",
		  beforeSend: function(xhr) {
			  xhr.setRequestHeader("Accept", "application/json");
		  },
		  success: function(data) {
			  $("#dctable").dataTable({
				    "dom":'<"top"p>rt<"bottom">',
				    "info":false,
				    "pageLength" : 7,
				    "data": data.data_center,
				    "columns": DATACENTER_COLUMNS,
				    "bFilter" : false,
				    "bLengthChange": false,
				    "oLanguage":{
				      "oPaginate":{
				        "sPrevious":"<",
				        "sNext":">"
				      }
				    },
				    "columnDefs":[{
				      "orderable":false,
				      "targets":[0,1,2,3]
				    },{
				      "targets" : [1],
				      "render" : function(data, type, full, meta) {
				    	  if (full.local == "false") {
				    		  return "Shared";
				    	  } else {
				    		  return "Local";
				    	  }
				      }
				    },{
				      "targets" : [3],
				      "render" : function(data, type, full, meta) {
				    	  return full.version.major + "." + full.version.minor;
				      }
				    }]
				  });
		  }
	  });
}

/*
 * Document ready function
 */
$(document).ready(function(){
    $('.ui.dropdown').dropdown()
    $('.ui.menu .dropdown').dropdown({
        on: 'hover'
    });
    $('.right.menu .dropdown').dropdown({
    	on:'hover'
    });
    $("#newdcbutton").on("click", function() {
    	$("#newdcmodal").modal('show');
    });

    // $('.page.ui.modal').modal('show');
    
    // $('.newnet.ui.modal').modal('show');
    // $('.newuser.ui.modal').modal('show');
    // $('.attachiso.ui.modal').modal('show');
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
     
  loadDatacenters();

  var storeclm = [{
    data : "opt",
    title : " ",
    type:"string",
    width:"50px",
    orderable:false
  },{
    data : "name",
    title:"Domain Name",
    type:"string",
    width:"100px",
    orderable:false
  },{
    data : "type",
    title:"Domain Type",
    type:"string",
    width:"100px"
  },{
    data : "state",
    title: "Status",
    type:"string",
    width:"100px"
  },{
    data : "free",
    title:"Free Space",
    type : "string",
    width:"100px"
  },{
    data:"used",
    title:"Used Space",
    type:"string",
     width:"100px"
  },{
    data:"total",
    title:"Total Space",
    type:"string",
     width:"100px"
  },{
    data:"desc",
    title:"Description",
    type:"string",
     width:"100px"
  }];
   var storedata = [{
    "opt":"run",
    "name":"192-168-135-129-Local",
    "type":"Data(Master)",
    "state":"Active",
    "free":"120GB",
    "used":"500GB",
    "total":"620GB",
    "desc":"Local Storage"
  },{
    "opt":"run",
    "name":"192-168-135-135-Local",
    "type":"Data(Slave)",
    "state":"Active",
    "free":"100GB",
    "used":"300GB",
    "total":"400GB",
    "desc":"Remote Storage 1"
  },{
    "opt":"run",
    "name":"192-168-135-147-Local",
    "type":"Data(Slave)",
    "state":"Active",
    "free":"80GB",
    "used":"100GB",
    "total":"180GB",
    "desc":"Remote Storage 2"
  }];
$("#storetable").dataTable({
    "dom":'<"top">rt<"bottom">',
    "info":false,
    "pageLength" : 7,
    "data":storedata,
    "columns":storeclm,
    "bFilter" : false,               
    "bLengthChange": false,
    "columnDefs":[{
      "targets":[0],
      "render":function(data,type,full,meta){
        return '<i class="cogs icon"></i>';
      }
    },{
      "targets":[1],
      "render":function(data,type,full,meta){
        return '<i class="server list icon"></i>';
      }
    },{
      "orderable":false,
      "targets":[0,1,2,5,6]
    }]
  });
var netclm = [{
    data : "name",
    title : "Name",
    type:"string",
    width:"100px",
    orderable:false
  },{
    data : "desc",
    title:"Description",
    type:"string",
    width:"100px",
    orderable:false
  }];
var netdata = [{
  "name":"mgmt",
  "desc":"Management NetWork"
},{
  "name":"sevl",
  "desc":"south east vip line"
}];
$("#nettable").dataTable({
    "dom":'<"top">rt<"bottom">',
    "info":false,
    "pageLength" : 7,
    "data":netdata,
    "columns":netclm,
    "bFilter" : false,               
    "bLengthChange": false
  });
var permclm=[{
    data : "mark",
    title : " ",
    type:"string",
    width:"20px",
    orderable:false
  },{
    data : "name",
    title:"User",
    type:"string",
    width:"100px",
    orderable:false
  },{
    data : "auth",
    title:"Authorization provider",
    type:"string",
    width:"100px",
    orderable:false
  },{
    data : "namespace",
    title:"Namespace",
    type:"string",
    width:"100px",
    orderable:false
  },{
    data:"role",
    title:"Role",
    type:"string",
    width:"100px",
    orderable:false
  }];
var permdata=[{
    "mark":"1",
    "name":"admin(admin@internal)",
    "auth":"internal",
    "namespace":"*",
    "role":"SuperUser"
  },{
    "mark":"1",
    "name":"admin(admin@external)",
    "auth":"internal",
    "namespace":"*",
    "role":"SuperUser"
  },{
    "mark":"1",
    "name":"user1@internal",
    "auth":"internal",
    "namespace":"/datacenter",
    "role":"Management"
  },{
    "mark":"1",
    "name":"user2@internal",
    "auth":"internal",
    "namespace":"/network",
    "role":"Management"
  },{
    "mark":"1",
    "name":"user3@internal",
    "auth":"internal",
    "namespace":"/vms",
    "role":"Management"
  }];
  $("#permtable").dataTable({
    "dom":'<"top">rt<"bottom">',
    "info":false,
    "pageLength" : 7,
    "data":permdata,
    "columns":permclm,
    "bFilter" : false,               
    "bLengthChange": false,
    "columnDefs":[{
      "targets":[0],
       "render":function(data,type,full,meta){
        return '<i class="doctor icon"></i>';
      }
    }]
  });

  var userclm=[{
    data : "mark",
    title : " ",
    type:"string",
    width:"20px",
    orderable:false
  },{
    data : "fname",
    title:"First Name",
    type:"string",
    width:"100px",
    orderable:false
  },{
    data : "lname",
    title:"Last Name",
    type:"string",
    width:"100px",
    orderable:false
  },{
    data : "uname",
    title:"User Name",
    type:"string",
    width:"100px",
    orderable:false
  }];
  var userdata=[{
    "mark":"1",
    "fname":"Mike",
    "lname":"Green",
    "uname":"admin@internal"
  },{
    "mark":"2",
    "fname":"John",
    "lname":"Gods",
    "uname":"admin@internal"
  },{
    "mark":"3",
    "fname":"Peter",
    "lname":"Starks",
    "uname":"admin@internal"
  },{
    "mark":"4",
    "fname":"Noodle",
    "lname":"Ailin",
    "uname":"admin@internal"
  }];
  $("#usertable").dataTable({
    "dom":'<"top">rt<"bottom">',
    "info":false,
    "pageLength" : 7,
    "data":userdata,
    "columns":userclm,
    "bFilter" : false,               
    "bLengthChange": false,
    "columnDefs":[{
      "targets":[0],
       "render":function(data,type,full,meta){
        return '<i class="doctor icon"></i>';
      }
    }]
  });

var isoclm=[{
    data : "mark",
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
    data : "type",
    title:"Type",
    type:"string",
    width:"100px",
    orderable:false
  },{
    data : "free",
    title:"Free Space",
    type:"string",
    width:"100px",
    orderable:false
  }];
var isodata=[{
  "mark":"1",
  "name":"ISO_DOMAIN",
  "type":"ISO",
  "free":"<1 GB"
},{
  "mark":"1",
  "name":"ISO_DOMAIN1",
  "type":"ISO",
  "free":"<10 GB"
},{
  "mark":"1",
  "name":"ISO_DOMAIN3",
  "type":"ISO",
  "free":"<10 GB"
}];
  $("#isotable").dataTable({
    "dom":'<"top">rt<"bottom">',
    "info":false,
    "pageLength" : 7,
    "data":isodata,
    "columns":isoclm,
    "bFilter" : false,               
    "bLengthChange": false,
    "columnDefs":[{
      "targets":[0],
       "render":function(data,type,full,meta){
        return '<input type="radio" name="fruit">';
      }
    }]
  });
 });