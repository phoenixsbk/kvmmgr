
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

function drag(ele){
  // ele.addEventListener('dragstart', function (e) {
  //   e.dataTransfer.effectAllowed = 'copy'; // only dropEffect='copy' will be dropable
  //   e.dataTransfer.setData('Text', this.id); // required otherwise doesn't work
  // },false);
  // ele.addEventListener('dragover', function (e) {
  //   if (e.preventDefault) e.preventDefault(); // allows us to drop
  //   e.dataTransfer.dropEffect = 'copy';
  //   return false;
  // },false);
  // ele.addEventListener('dragleave', function () {
  //   this.className = '';
  // },false);
  // ele.addEventListener('drop', function (e) {
  //   if (e.stopPropagation) e.stopPropagation();
  //   var el = document.getElementById(e.dataTransfer.getData('Text'));
  //   e.target
  //   el.parentNode.removeChild(el);
  //   // stupid nom text + fade effect
  //   bin.className = '';
  //   yum.innerHTML = eat[parseInt(Math.random() * eat.length)];

  //   var y = yum.cloneNode(true);
  //   bin.appendChild(y);
  //   return false;
  // });
}

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
    // $('.importnet.ui.modal').modal('show');
    // $('.setuphost.ui.modal').modal('show');
    // $('.newdomain.ui.modal').modal('show');
    $('.disk.ui.modal').modal('show');
    drag(document.getElementById('interface'));
    drag(document.getElementById('network'));
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


  var netclm = [{
    data : "name",
    title : "Name",
    type:"string",
    width:"50px",
    orderable:false
  },{
    data : "detail",
    title:" ",
    type:"string",
    width:"50px",
    orderable:false
  },{
    data : "datacenter",
    title:"Data Center",
    type:"string",
    width:"100px"
  },{
    data : "desc",
    title:"Description",
    type : "string",
    width:"100px"
  },{
    data:"role",
    title:"Role",
    type:"string",
     width:"50px"
  },{
    data:"vlan",
    title:"Host Count",
    type:"numeric",
     width:"50px"
  },{
    data:"label",
    title:"VM Count",
    type:"numeric",
     width:"100px"
  },{
    data:"provider",
    title:"VM Count",
    type:"numeric",
     width:"100px"
  }];
  var netdata = [{
    "name":"mgmt",
    "detail":"My Default Management Network",
    "datacenter":"Default",
    "desc":"Management Network",
    "role":"mv",
    "vlan":"-",
    "label":"-",
    "provider":"Company"
  },{
    "name":"mgmt1",
    "detail":"My Default Management Network",
    "datacenter":"Default",
    "desc":"Management Network 1",
    "role":"mv",
    "vlan":"-",
    "label":"-",
    "provider":"Company"
  },{
    "name":"mgmt2",
    "detail":"My Default Management Network",
    "datacenter":"Default",
    "desc":"Management Network 2",
    "role":"mv",
    "vlan":"-",
    "label":"-",
    "provider":"Company"
  },{
    "name":"network3",
    "detail":"My Default Management Network",
    "datacenter":"Default",
    "desc":"Management Network 3",
    "role":"mv",
    "vlan":"-",
    "label":"-",
    "provider":"Company"
  }];
  $("#nettable").dataTable({
    "dom":'<"top"pl>rt<"bottom">',
    "info":false,
    "pageLength" : 7,
    "data":netdata,
    "columns":netclm,
    "bFilter" : false,               
    "bLengthChange": false,
    "oLanguage":{
      "oPaginate":{
        "sPrevious":"<",
        "sNext":">"
      }
    }
  });

  var hostclm = [{
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
    data : "cluster",
    title:"Cluster",
    type:"string",
    width:"100px"
  },{
    data : "datacenter",
    title: "Data Center",
    type:"string",
    width:"100px"
  },{
    data : "ndstate",
    title:"Network Device Status",
    type : "string",
    width:"100px"
  },{
    data : "ndevice",
    title:"Network Device",
    type : "string",
    width:"100px"
  },{
    data : "speed",
    title:"Speed(Mbps)",
    type : "string",
    width:"100px"
  },{
    data : "rx",
    title:"Rx(Mbps)",
    type : "string",
    width:"50px"
  },{
    data : "tx",
    title:"Tx(Mbps)",
    type : "string",
    width:"50px"
  }];
   var hostdata = [{
    "opt":"run",
    "name":"192.168.135.129",
    "cluster":"Cluster",
    "datacenter":"Default",
    "ndstate":"running",
    "ndevice":"eth0",
    "speed":1000,
    "rx":"< 1",
    "tx":"< 1"
  },{
    "opt":"run",
    "name":"192.168.135.134",
    "cluster":"Google",
    "datacenter":"Default",
    "ndstate":"running",
    "ndevice":"eth0",
    "speed":1000,
    "rx":"< 1",
    "tx":"< 1"
  },{
    "opt":"run",
    "name":"192.168.135.135",
    "cluster":"Amazon",
    "datacenter":"Default",
    "ndstate":"running",
    "ndevice":"eth1",
    "speed":500,
    "rx":"< 2",
    "tx":"< 2"
  },];
$("#hosttable").dataTable({
    "dom":'<"top">rt<"bottom">',
    "info":false,
    "pageLength" : 7,
    "data":hostdata,
    "columns":hostclm,
    "bFilter" : false,               
    "bLengthChange": false,
    "columnDefs":[{
      "targets":[0],
      "render":function(data,type,full,meta){
        return '<i class="cogs icon"></i>';
      }
    },{
      "targets":[4],
      "render":function(data,type,full,meta){
        return '<i class="triangle up icon"></i>';
      }
    }]
  });
var provclm=[{
  data:"check",
  title : '<input type="checkbox" />',
  type:"string",
  width:"20px",
  orderable:false
},{
  data:"name",
  title : "Name",
  type:"string",
  width:"50px",
  orderable:false
},{
  data:"netid",
  title : "Provider Network ID",
  type:"string",
  width:"100px",
  orderable:false
}];
var provdata = [{
  "check":false,
  "name":"mgmt",
  "netid":"96acde4kodaondn"
},{
  "check":true,
  "name":"mgmt1",
  "netid":"96acde4kodaondn"
},{
  "check":false,
  "name":"mgmt2",
  "netid":"96acde4kodaondn"
}];
$("#provtable").dataTable({
    "dom":'<"top">rt<"bottom">',
    "info":false,
    "pageLength" : 7,
    "data":provdata,
    "columns":provclm,
    "bFilter" : false,               
    "bLengthChange": false,
    "columnDefs":[{
      "targets":[0],
      "render":function(data,type,full,meta){
        return '<input type="checkbox" />';
      }
    }]
  });
var importclm=[{
  data:"check",
  title : '<input type="checkbox"/>',
  type:"string",
  width:"20px",
  orderable:false
},{
  data:"name",
  title : "Name",
  type:"string",
  width:"50px",
  orderable:false
},{
  data:"netid",
  title : "Provider Network ID",
  type:"string",
  width:"100px",
  orderable:false
},{
  data:"dcenter",
  title : "Data Center",
  type:"string",
  width:"50px",
  orderable:false
},{
  data:"all",
  title : '<input type="checkbox">Allow All',
  type:"string",
  width:"50px",
  orderable:false
}];
var importdata=[{
  "check":false,
  "name":"mgmt",
  "netid":"96acde4kodaondn",
  "dcenter":"Default",
  "all":"text1"
},{
  "check":false,
  "name":"mgmt1",
  "netid":"96acde4kodaondn",
  "dcenter":"Default1",
  "all":"text2"
},{
  "check":true,
  "name":"mgmt2",
  "netid":"96acde4kodaondn",
  "dcenter":"Google",
  "all":"text3"
}];
  $("#importtable").dataTable({
    "dom":'<"top">rt<"bottom">',
    "info":false,
    "pageLength" : 7,
    "data":importdata,
    "columns":importclm,
    "bFilter" : false,               
    "bLengthChange": false,
    "columnDefs":[{
      "targets":[0],
      "render":function(data,type,full,meta){
        return '<input type="checkbox" />';
      }
    },{
      "targets":[4],
      "render":function(data,type,full,meta){
        return '<input type="checkbox" />'+data;
      }
    }]
  });
var targetclm=[{
  data:"info",
  title : ' ',
  type:"string",
  width:"20px",
  orderable:false
},{
  data:"name",
  title : "Name",
  type:"string",
  width:"100px",
  orderable:false
},{
  data:"address",
  title : "Provider Network ID",
  type:"string",
  width:"30px",
  orderable:false
},{
  data:"port",
  title : "Port",
  type:"string",
  width:"20px",
  orderable:false
},{
  data:"state",
  title : ' ',
  type:"string",
  width:"20px",
  orderable:false
},{
  data:"opt",
  title : ' ',
  type:"string",
  width:"20px",
  orderable:false
}];

var targetdata = [{
  "info":"1",
  "name":"wlfjStorage1",
  "address":"10.154.62.15",
  "port":"8080",
  "state":"run",
  "opt":"2"
},{
  "info":"2",
  "name":"wlfjStorage2",
  "address":"10.154.62.18",
  "port":"8080",
  "state":"run",
  "opt":"2"
}];
$("#targettable").dataTable({
    "dom":'<"top">rt<"bottom">',
    "info":false,
    "pageLength" : 7,
    "data":targetdata,
    "columns":targetclm,
    "bFilter" : false,               
    "bLengthChange": false
  });
 });