
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

    $('.page.ui.modal').modal('show');
    // $('.warn.ui.modal').modal('show');
    $dropdownItem = $('.menu .dropdown .item'),
    $menuItem     = $('.menu a.item').not($dropdownItem),
    $('.ui.checkbox').checkbox();
    $('.ui.radio.checkbox').checkbox();
    // $('.demo.sidebar').sidebar('toggle');
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
    $('.newvm.menu .item').tab({history:false});
     $menuItem.on('click', handler.activate);
     $('.menu .item').tab();

     $('.selection.dropdown')
        .dropdown('setting', 'transition', 'vertical flip')
        .dropdown('set selected');


  var vmsclm = [{
    data : "opt",
    title : "",
    type:"string",
    width:"35px",
    orderable:false
  },{
    data : "mark",
    title:"",
    type:"string",
    width:"35px",
    orderable:false
  },{
    data : "name",
    title:"name",
    type:"string",
    width:"50px"
  },{
    data : "host",
    title: "Host",
    type:"string",
    width:"100px"
  },{
    data : "ip",
    title:"IP Address",
    type : "string",
    width:"100px"
  },{
    data:"fqdn",
    title:"FQDN",
    type:"string",
     width:"100px"
  },{
    data:"cluster",
    title:"Cluster",
    type:"string",
     width:"50px"
  },{
    data : "datacenter",
    title : "Data Center",
    type:"string",
     width:"50px"
  },{
    data : "memery",
    title:"Memery",
    type:"numeric",
     width:"100px"
  },{
    data:"cpu",
    title:"CPU",
    type:"numeric",
     width:"100px"
  },{
    data:"network",
    title:"Network",
    type:"numeric",
     width:"100px"
  },{
    data:"migration",
    title:"Migration",
    type:"numeric",
     width:"100px"
  },{
    data :"display",
    title:"Display",
    type:"string",
     width:"100px"
  },{
    data:"status",
    title:"Status",
    type:"string",
    width:"100px"
  }];
  var vmsdata = [{
    "opt":"run",
    "mark":"many",
    "name":"cimi_machine1",
    "host":"192.168.135.129",
    "ip":"192.168.1.154",
    "fqdn":"fn.wlfj.com",
    "cluster":"Default",
    "datacenter":"Default",
    "memery":24,
    "cpu":54,
    "network":20,
    "migration":67,
    "display":"SPICE",
    "status":"Down"
  },{
    "opt":"run",
    "mark":"many",
    "name":"cimi_machine3",
    "host":"192.168.135.129",
    "ip":"192.168.1.156",
    "fqdn":"fn.wlfj.com",
    "cluster":"Default",
    "datacenter":"Default",
    "memery":10,
    "cpu":32,
    "network":40,
    "migration":37,
    "display":"SPICE",
    "status":"Up"
  },{
     "opt":"run",
    "mark":"many",
    "name":"cimi_machine5",
    "host":"192.168.135.129",
    "ip":"192.168.1.157",
    "fqdn":"fn.wlfj.com",
    "cluster":"Default",
    "datacenter":"Default",
    "memery":80,
    "cpu":65,
    "network":10,
    "migration":77,
    "display":"SPICE",
    "status":"Up"
  },{
    "opt":"run",
    "mark":"many",
    "name":"vm_mini1",
    "host":"192.168.135.129",
    "ip":"192.168.2.4",
    "fqdn":"fn.wlfj.com",
    "cluster":"Default",
    "datacenter":"Default",
    "memery":62,
    "cpu":78,
    "network":46,
    "migration":27,
    "display":"SPICE",
    "status":"Up"
  },{
    "opt":"run",
    "mark":"many",
    "name":"vm_mini2",
    "host":"192.168.135.129",
    "ip":"192.168.2.8",
    "fqdn":"fn.wlfj.com",
    "cluster":"Default",
    "datacenter":"Default",
    "memery":32,
    "cpu":58,
    "network":36,
    "migration":17,
    "display":"SPICE",
    "status":"Up"
  },{
    "opt":"run",
    "mark":"many",
    "name":"myvm",
    "host":"192.168.135.129",
    "ip":"192.168.2.10",
    "fqdn":"fn.wlfj.com",
    "cluster":"Default",
    "datacenter":"Default",
    "memery":22,
    "cpu":84,
    "network":60,
    "migration":65,
    "display":"SPICE",
    "status":"Up"
  },{
    "opt":"run",
    "mark":"many",
    "name":"myvm_1",
    "host":"192.168.135.129",
    "ip":"192.168.2.11",
    "fqdn":"fn.wlfj.com",
    "cluster":"Default",
    "datacenter":"Default",
    "memery":16,
    "cpu":74,
    "network":54,
    "migration":65,
    "display":"SPICE",
    "status":"Up"
  },{
    "opt":"run",
    "mark":"many",
    "name":"myvm2",
    "host":"192.168.135.129",
    "ip":"192.168.2.13",
    "fqdn":"fn.wlfj.com",
    "cluster":"Default",
    "datacenter":"Default",
    "memery":90,
    "cpu":74,
    "network":55,
    "migration":100,
    "display":"SPICE",
    "status":"Up"
  },{
    "opt":"run",
    "mark":"many",
    "name":"myvm3",
    "host":"192.168.135.129",
    "ip":"192.168.2.14",
    "fqdn":"fn.wlfj.com",
    "cluster":"Default",
    "datacenter":"Default",
    "memery":92,
    "cpu":33,
    "network":35,
    "migration":98,
    "display":"SPICE",
    "status":"Up"
  }];
  $("#vmstable").dataTable({
    "dom":'<"top"p>rt<"bottom">',
    "info":false,
    "pageLength" : 7,
    "data":vmsdata,
    "columns":vmsclm,
    "bFilter" : false,               
    "bLengthChange": false,
    "scrollX":true,
    "oLanguage":{
      "oPaginate":{
        "sPrevious":"<",
        "sNext":">"
      }
    },
    "columnDefs":[{
      "targets":[8,9,10,11],
      "render":function(data,type,full,meta){
        return '<div class="ui small orange progress" data-percent="'+data+'"><div class="bar"></div><span class="barnum">'+data+'%</span></div>';
      }
    },{
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
      "targets":[0,1,2,5,6,7,12,13]
    }],
    "drawCallback":function(oSetting){
      $('.ui.progress').progress();
    }
  });
 });