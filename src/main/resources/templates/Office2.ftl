<!DOCTYPE html>
<html>
<head>
    <title>${title}</title>
    <script src="../static/js/jquery_1.11.0/jquery.min.js" type="text/javascript"></script>
    <script src="../static/js/weboffice.js" type="text/javascript"></script>
    <script src="../static/js/bootstrap_3.1.1/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="../static/js/bootstrap_3.1.1/bootstrap-treeview.js" type="text/javascript"></script>
    <link rel="stylesheet" href="../static/js/bootstrap_3.1.1/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="../static/js/zTree/css/metroStyle/metroStyle.css" type="text/css">
    <link rel="stylesheet" href="../static/js/zTree/css/myTree.css" type="text/css">
    <script type="text/javascript" src="../static/js/zTree/js/jquery.ztree.core.js"></script>
    <script type="text/javascript" src="../static/js/zTree/js/fuzzysearch.js"></script>
<#--    <SCRIPT type="text/javascript">-->

<#--        <!---->
<#--        var locationItem =[];-->
<#--        var crulocationItem;-->
<#--        var IDMark_Switch = "_switch",-->
<#--            IDMark_Icon = "_ico",-->
<#--            IDMark_Span = "_span",-->
<#--            IDMark_Input = "_input",-->
<#--            IDMark_Check = "_check",-->
<#--            IDMark_Edit = "_edit",-->
<#--            IDMark_Remove = "_remove",-->
<#--            IDMark_Ul = "_ul",-->
<#--            IDMark_A = "_a";-->

<#--        // var setting = {-->
<#--        //     view: {-->
<#--        //         // addHoverDom: addHoverDom, //鼠标移上 事件-->
<#--        //         // removeHoverDom: removeHoverDom,-->
<#--        //         selectedMulti: false,-->
<#--        //         showIcon: false,-->
<#--        //         addDiyDom: addDiyDom,-->
<#--        //         showTitle: false,-->
<#--        //     },-->
<#--        //     // check: {-->
<#--        //     //     enable: true-->
<#--        //     // },-->
<#--        //     data: {-->
<#--        //         simpleData: {-->
<#--        //             enable: true-->
<#--        //         }-->
<#--        //     },-->
<#--        //     edit: {-->
<#--        //         // enable: true,-->
<#--        //         editNameSelectAll: true,-->
<#--        //         drag: {-->
<#--        //             isMove: false,-->
<#--        //             isCopy: false-->
<#--        //         }-->
<#--        //     },-->
<#--        //     callback: {-->
<#--        //         onClick: onClick-->
<#--        //     }-->
<#--        // };-->
<#--        &lt;#&ndash;var list = ${upstream}.list;&ndash;&gt;-->


<#--        &lt;#&ndash;var zNodes =[&ndash;&gt;-->
<#--        &lt;#&ndash;    { id:1, pId:0, name:"父节点1", open:true,click:false,t:"id=1"},&ndash;&gt;-->
<#--        &lt;#&ndash;    { id:11, pId:1, name:"父节点11",click:false,t:"id=11"},&ndash;&gt;-->
<#--        &lt;#&ndash;    { id:111, pId:11, name:"叶子节点111",t:"id=111"},&ndash;&gt;-->
<#--        &lt;#&ndash;    { id:112, pId:11, name:"叶子节点112",t:"id=112"},&ndash;&gt;-->
<#--        &lt;#&ndash;    { id:113, pId:11, name:"叶子节点113",t:"id=113"},&ndash;&gt;-->
<#--        &lt;#&ndash;    { id:114, pId:11, name:"叶子节点114",t:"id=114"},&ndash;&gt;-->
<#--        &lt;#&ndash;    { id:12, pId:1, name:"父节点12",click:false,t:"id=12"},&ndash;&gt;-->
<#--        &lt;#&ndash;    { id:121, pId:12, name:"叶子节点121",t:"id=121"},&ndash;&gt;-->
<#--        &lt;#&ndash;    { id:122, pId:12, name:"叶子节点122",t:"id=122"},&ndash;&gt;-->
<#--        &lt;#&ndash;    { id:123, pId:12, name:"叶子节点123",t:"id=123"},&ndash;&gt;-->
<#--        &lt;#&ndash;    { id:124, pId:12, name:"叶子节点124",t:"id=124"},&ndash;&gt;-->
<#--        &lt;#&ndash;    { id:13, pId:1, name:"父节点13", isParent:true,click:false,t:"id=13"},&ndash;&gt;-->
<#--        &lt;#&ndash;    { id:2, pId:0, name:"父节点2",click:false,t:"id=2"},&ndash;&gt;-->
<#--        &lt;#&ndash;    { id:21, pId:2, name:"父节点21", open:true,click:false,t:"id=21"},&ndash;&gt;-->
<#--        &lt;#&ndash;    { id:211, pId:21, name:"叶子节点211",t:"id=211"},&ndash;&gt;-->
<#--        &lt;#&ndash;    { id:212, pId:21, name:"叶子节点212",t:"id=212"},&ndash;&gt;-->
<#--        &lt;#&ndash;    { id:213, pId:21, name:"叶子节点213",t:"id=213"},&ndash;&gt;-->
<#--        &lt;#&ndash;    { id:214, pId:21, name:"叶子节点214",t:"id=214"},&ndash;&gt;-->
<#--        &lt;#&ndash;    { id:22, pId:2, name:"父节点22",click:false,t:"id=22"},&ndash;&gt;-->
<#--        &lt;#&ndash;    { id:221, pId:22, name:"叶子节点221",t:"id=221"},&ndash;&gt;-->
<#--        &lt;#&ndash;    { id:222, pId:22, name:"叶子节点222",t:"id=222"},&ndash;&gt;-->
<#--        &lt;#&ndash;    { id:223, pId:22, name:"叶子节点223",t:"id=223"},&ndash;&gt;-->
<#--        &lt;#&ndash;    { id:224, pId:22, name:"叶子节点224",t:"id=224"},&ndash;&gt;-->
<#--        &lt;#&ndash;    { id:23, pId:2, name:"父节点23",click:false,t:"id=23"},&ndash;&gt;-->
<#--        &lt;#&ndash;    { id:231, pId:23, name:"叶子节点231",t:"id=231"},&ndash;&gt;-->
<#--        &lt;#&ndash;    { id:232, pId:23, name:"叶子节点232",t:"id=232"},&ndash;&gt;-->
<#--        &lt;#&ndash;    { id:233, pId:23, name:"叶子节点233",t:"id=233"},&ndash;&gt;-->
<#--        &lt;#&ndash;    { id:234, pId:23, name:"叶子节点234",t:"id=234"},&ndash;&gt;-->
<#--        &lt;#&ndash;    { id:3, pId:0, name:"父节点3", isParent:true,click:false,t:"id=3"}&ndash;&gt;-->
<#--        &lt;#&ndash;];&ndash;&gt;-->
<#--        &lt;#&ndash;var nodes = [&ndash;&gt;-->
<#--        &lt;#&ndash;    {name: "父节点1", id:1, pId:0, open:true,click:false,t:"id=1",children: [&ndash;&gt;-->
<#--        &lt;#&ndash;            {name: "子节点11",id:11, pId:1,t:"id=11",click:true},&ndash;&gt;-->
<#--        &lt;#&ndash;            {name: "子节点12",id:12, pId:1,t:"id=12",click:true}&ndash;&gt;-->
<#--        &lt;#&ndash;        ]},&ndash;&gt;-->
<#--        &lt;#&ndash;    {name: "父节点2",id:2, pId:0,click:false, t:"id=2",children: [&ndash;&gt;-->
<#--        &lt;#&ndash;            {name: "子节点21",id:21, pId:2,t:"id=21",children: [&ndash;&gt;-->
<#--        &lt;#&ndash;                    {name: "子节点211",id:211, pId:21,t:"id=211",},&ndash;&gt;-->
<#--        &lt;#&ndash;                    {name: "子节点212",id:212, pId:21,t:"id=212",}&ndash;&gt;-->
<#--        &lt;#&ndash;                ]},&ndash;&gt;-->
<#--        &lt;#&ndash;            {name: "子节点22",id:22, pId:2,t:"id=22",}&ndash;&gt;-->
<#--        &lt;#&ndash;        ]},&ndash;&gt;-->
<#--        &lt;#&ndash;    {name: "父节点3", id:3, pId:0,click:false,t:"id=3",children: [&ndash;&gt;-->
<#--        &lt;#&ndash;            {name: "子节点31",id:31, pId:3,t:"id=31",},&ndash;&gt;-->
<#--        &lt;#&ndash;            {name: "子节点32",id:32, pId:3,t:"id=32",}&ndash;&gt;-->
<#--        &lt;#&ndash;        ]}];&ndash;&gt;-->
<#--        &lt;#&ndash;var newCount = 1;&ndash;&gt;-->
<#--        // $(document).ready(function(){-->
<#--        //     $.fn.zTree.init($("#treeDemo"), setting, listNew);-->
<#--        // });-->
<#--        // alert(JSON.stringify(nodes,null,4));-->

<#--        function addHoverDom(treeId, treeNode) {-->
<#--            var sObj = $("#" + treeNode.tId + "_span");-->
<#--            if (treeNode.editNameFlag || $("#addBtn_"+treeNode.tId).length>0) return;-->
<#--            var addStr = "<span class='button add' id='addBtn_" + treeNode.tId-->
<#--                + "' title='add node' onfocus='this.blur();'></span>";-->
<#--            sObj.after(addStr);-->
<#--            var btn = $("#addBtn_"+treeNode.tId);-->
<#--            if (btn) btn.bind("click", function(){-->
<#--                var zTree = $.fn.zTree.getZTreeObj("treeDemo");-->
<#--                zTree.addNodes(treeNode, {id:(100 + newCount), pId:treeNode.id, name:"new node" + (newCount++)});-->
<#--                return false;-->
<#--            });-->
<#--        };-->

<#--        function removeHoverDom(treeId, treeNode) {-->
<#--            $("#addBtn_"+treeNode.tId).unbind().remove();-->
<#--        };-->

<#--        function addDiyDom(treeId, treeNode) {-->
<#--            if (treeNode.parentNode && treeNode.parentNode.id!=2) return;-->
<#--            var aObj = $("#" + treeNode.tId + IDMark_A);-->
<#--            var treeNodeName = treeNode.old ? treeNode.oldname : treeNode.name;-->

<#--            if (!((treeNode.children && treeNode.children.length>0) ||  treeNode.isParent)) {-->
<#--                var editStr = "<span class='demoIcon ' id='locationBtn_" +treeNode.id+ "' title='"+treeNodeName+"'  onfocus='this.blur();'><span class='button icon01'></span>" +-->
<#--                    "<span class='currentItem hiddenItem'  id='currentItem_" +treeNode.id+ "' style='height:20px;flex-flow: nowrap;display: none'>当前第：<a id ='clicks'> <span id='click_" +treeNode.id+ "''>0</span> /<span id='HighlightLength_" +treeNode.id+ "''>0</span></a></span>\n" +-->
<#--                    "</span>";-->
<#--                aObj.after(editStr);-->
<#--                var btn = $("#locationBtn_"+treeNode.id);-->
<#--                if (btn) btn.bind("click", function(){-->
<#--                    var item1 = treeNode.id!==locationItem[0]&&locationItem.length == 1;-->
<#--                    var item2 = locationItem[1]&&treeNode.id!==locationItem[1]&&locationItem.length == 2&&locationItem[0]!=locationItem[1];-->

<#--                    if(locationItem.length==0||item1||item2){-->
<#--                        locationItem.push(treeNode.id)-->
<#--                    }-->
<#--                    // alert("diy Button for "  +"id="+treeNode.id+"locationItem="+locationItem);-->
<#--                    locationSearch(treeNode,locationItem[0],locationItem[1]); //定位-->
<#--                    findNextClick(treeNode);//查找下一项-->
<#--                });-->
<#--            }-->
<#--        }-->
<#--        -->
<#--        function onClick(event, treeId, treeNode, clickFlag) {-->
<#--            if(treeNode.click !== false){-->
<#--                // alert(treeNode);-->
<#--                // alert("clickFlag = " + clickFlag + " (" + (clickFlag===1 ? "普通选中": (clickFlag===0 ? "<b>取消选中</b>" : "<b>追加选中</b>")) + ")");-->
<#--                var obj = document.getElementById("PageOfficeCtrl").Document;-->
<#--                var name = treeNode.oldname? treeNode.oldname : treeNode.name;-->
<#--                obj.Application.Selection.Font.Shading.BackgroundPatternColorIndex=7;-->
<#--                obj.Application.Selection = '['+name+']';-->
<#--            };-->
<#--        }-->

<#--        $(document).ready(function(){-->
<#--            $.fn.zTree.init($("#treeDemo"), setting, list); //listNew ;zNodes-->
<#--            fuzzySearch('treeDemo','#searchInput',null,true); //初始化模糊搜索方法-->
<#--        });-->
<#--        //&ndash;&gt;-->
<#--    </SCRIPT>-->

    <style type="text/css">
		/**{margin:0;padding:0}*/
		html{width:100%;height:100%}
		body{width:100%;height:100%}
		.po-editor
        {
            margin-left: -200px;
            width:1200px;
            min-width: 1200px;
            height:1000px;
            overflow:hidden;
        }
		object{width:100%;height:100%}
		.container {
		    display: flex;
		}
        .left{
            width: 500px;
            margin-right:-200px ;
        }
        .leftTop{
            height: 500px;
            /*min-height: 500px;*/
        }
        .leftDown{
            overflow: auto;
            height: 500px;
            min-height: 500px;
        }
        .tab-content{
            overflow: auto;
            height: 400px;
            min-height: 400px;
        }
        .ztree li span.demoIcon{padding:0 2px 0 10px;display: none;}
        .ztree li span.button.icon01{margin:0; background: url('${ctxPath}/images/right.png') no-repeat scroll 0 0 transparent; vertical-align:top; *vertical-align:middle;margin-top: 6px;}
        .ztree li span.button.icon01:hover{background:url('${ctxPath}/images/right-blue.png') no-repeat scroll 0 0 transparent;}

    </style>
</head>
<body>
    <div class="container" >
        <form id="PageOfficeForm" class="po-editor">${pageOfficeHtml}</form>
        <div class="left">
            <div class="leftTop">
                <ul id="myTab" class="nav nav-tabs">
                    <li><a href="#upstream" data-toggle="tab">上游系统填充</a></li>
                    <li><a href="#default" data-toggle="tab">默认值</a></li>
                    <li><a href="#formula" data-toggle="tab">公式</a></li>
                </ul>
                <div class="input-group" style="height:20px">
                    <input type="text" class="form-control input-lg" id="searchInput" style="height:30px">
                    <span class="input-group-addon btn btn-primary" style="height:20px" onclick="search()">搜索</span>
                </div>
                <div id="myTabContent" class="tab-content">
                    <div class="tab-pane fade" id="upstream">
                        <div id ="tree-upstream">
                            <ul id="treeDemo" class="ztree"></ul>
                        </div>
                    </div>
                    <div class="tab-pane fade " id="default">
                        <div id ="tree-default"></div>
                    </div>
                    <div class="tab-pane fade" id="formula">
                        <div id ="tree-formula"></div>
                    </div>
                </div>
            </div>
            <div class="leftDown">
            <ul  id="tab-construction" class="nav nav-tabs">
                <li ><a href="#construction" data-toggle="tab">结构标签</a>
                </li>
            </ul>
                <div class="input-group" style="height:20px">
                    <span class="button icon01"></span>
                    <input type="text" class="form-control input-lg" id="constructionInput" style="height:30px">
                    <span class="input-group-addon btn btn-primary" style="height:20px" onclick="constructionSearch()">搜索</span>
                </div>
                <div class="tab-content">
                <div class="tab-pane fade" id="construction">
                    <div id ="tree-construction"></div>
                </div>
                </div>
            </div>
        </div>
    </div>

</body>
</html>

<script type="text/javascript">


    var officeObject = WebOffice.createAt('PageOfficeForm','PageOfficeCtrl');
    // document.getElementById("PageOfficeCtrl").JsFunction_AfterDocumentOpened = "showTree()";
    officeObject.addDataItem('banner','${banner}');
    var HighlightValue;
    var locationItem;
    var activeTab;
    var findIndex=0;
    var serchIndex=0;
    var HighlightList = [];
    var data = [{
        "id":"1",
        "name":"客户标签",
        "data":[
            {"id":'1',"label":"客户名称","value":"中诚信国际信用评级有限责任公司"},
            {"id":'2',"label":"纸质押人1","value":"郑州中原万达有限责任公司"},
            {"id":'3',"label":"纸质押人2","value":"湖北宜昌万达有限责任公司"}
        ]
    },{
        "id":"2",
        "name":"项目标签",
        "data":[
            {"id":'1',"label":"客户名称","value":"中诚信国际信用评级有限责任公司"},
            {"id":'2',"label":"公司1","value":"郑州中原万达有限责任公司"},
            {"id":'3',"label":"公司2","value":"湖北宜昌万达有限责任公司"}
        ]
    },{
        "id":"3",
        "name":"财务标签",
        "data":[
            {"id":'1',"label":"客户名称","value":"中诚信国际信用评级有限责任公司"},
            {"id":'2',"label":"开户行1","value":"郑州中原万达有限责任公司"},
            {"id":'3',"label":"地址2","value":"湖北宜昌万达有限责任公司"}
        ]
    },{
        "id":"4",
        "name":"数据标签4",
        "data":[{"id":'1',"label":"客户名称","value":"中诚信国际信用评级有限责任公司"}]
    },{
        "id":"5",
        "name":"数据标签5",
        "data":[{"id":'1',"label":"客户名称","value":"中诚信国际信用评级有限责任公司"}]
    },{
        "id":"6",
        "name":"数据标签6",
        "data":[{"id":'1',"label":"客户名称","value":"中诚信国际信用评级有限责任公司"}]
    }];
    var shoWData;
    showTree('#tree-default',${default});
    showTree('#tree-formula',${formula});
    showTree('#tree-construction',${construction});
    // setDefaultValue(data[0].data);
    $('.hiddenItem').css("display","none");
    $(function () {
        $('#myTab li:eq(0) a').tab('show');
        $('#tab-construction li:eq(0) a').tab('show');
        activeTab = '#upstream';
    });
    $(function(){
        $('a[data-toggle="tab"]').on('shown.bs.tab', function (e) {
            // 获取已激活的标签页的名称
            activeTab =  $(e.target)[0].hash;
        });
    });
    var appSlt = document.getElementById("treeDemo");

<#--//设置 默认值-->
<#--function setDefaultValue(shoWData){-->
<#--    var divDom = document.createElement('div');-->
<#--    divDom.style = 'margin-bottom: 20px;'-->
<#--    shoWData.map(item=>{-->
<#--        const newDiv = document.getElementById("tree-default") ;-->
<#--        var a = `<div style="margin-bottom: 20px;" ><span style="margin-right: 5px;">[${item.label}]:</span><a>${item.value}</a></div>`-->
<#--        $('#tree-default').append($(a))-->
<#--    });-->

<#--    $('#myTab li:eq(1) a').tab('show');-->
<#--    activeTab =$('#myTab li:eq(1) a')[0].id;-->

<#--};-->
function save(){
	officeObject.save();
}

function preview(){
    //关闭当前pageoffice页面
    // window.external.close();
    alert("预览");
    // $.ajax({
    //     url: pa +'/show',
    //     cache: false,
    //     type: 'get',
    //     error: function(data) {
    //         alert(data);
    //     },
    //     success: function(data) {
    //         alert(data);
    //     }
    // });
}

function constructionSearch1() {
    var tree = ${construction}.list;
    var textList = ${construction}.listSearch;
    var textListNew = textList.filter(isConstructionValue)
    var value = $('#constructionInput').val();
    if (value) {
        $('#construction').treeview({data: textListNew,
            collapseIcon: "fa fa-minus-square-o", //节点被折叠时显示的图标        String
            expandIcon: "fa fa-plus-square-o", //节点展开时显示的图标        String
        });
        $('#construction').on('nodeSelected', function (event, data) {
            var obj = document.getElementById("PageOfficeCtrl").Document;
            obj.Application.Selection.Font.Shading.BackgroundPatternColorIndex = 7;
            // obj.Application.Selection.Font.Color =_RGB(255,0,0);
            obj.Application.Selection = '[' + data.text + ']';
        });
    } else {
        $('#construction').treeview({data: tree,
            collapseIcon: "fa fa-minus-square-o", //节点被折叠时显示的图标        String
            expandIcon: "fa fa-plus-square-o", //节点展开时显示的图标        String
        });
        $('#construction').on('nodeSelected', function (event, data) {
            var obj = document.getElementById("PageOfficeCtrl").Document;
            obj.Application.Selection.Font.Shading.BackgroundPatternColorIndex = 7;
            obj.Application.Selection = '[' + data.text + ']';
        });
    }
}

function search(){
    $('.demoIcon').show();
};

//定位 ,点击节点查找
function locationSearch(treeNode,preItem,cruItem){
    var value = treeNode.oldname ? treeNode.oldname : treeNode.name;
    var btn = $("#currentItem_"+treeNode.id);

    if(value){
        $(activeTab).on('nodeSelected',function(event, data) {
            var obj = document.getElementById("PageOfficeCtrl").Document;
            obj.Application.Selection.Font.Shading.BackgroundPatternColorIndex=7;
            obj.Application.Selection = '['+data.text+']';
        });
        HighlightValue = value;
        if(cruItem && preItem !== cruItem){
            locationItem = [];
            locationItem[0] = cruItem;
            serchIndex = 0;
            findIndex = 0;
            HighlightList = [];
            $("#currentItem_"+preItem).css("display","none");
        }
        MarkKeyWord(value,true);
        serchIndex+=1;
        var btnShow =  !(findIndex== 0 &&  HighlightList.length=== 0); //
        if(btn&&btnShow){
            btn.show()
        }
        document.getElementById("HighlightLength_"+treeNode.id).innerHTML = HighlightList.length;
    }else{
        $(activeTab).on('nodeSelected',function(event, data) {
            var obj = document.getElementById("PageOfficeCtrl").Document;
            obj.Application.Selection.Font.Shading.BackgroundPatternColorIndex=7;
            obj.Application.Selection = '['+data.text+']';
        });
        MarkKeyWord(HighlightValue,false);
        HighlightValue = value;
    }

}

function isValue(element) {
    var value = $('#searchInput').val();
    return element.text.indexOf(value) != -1
} ;

function isConstructionValue(element) {
    var value = $('#constructionInput').val();
    return element.text.indexOf(value) != -1
} ;

function showTree(treeName,tree){
    $(treeName).treeview({data: tree.list,
        collapseIcon: "fa fa-minus-square-o", //节点被折叠时显示的图标        String
        expandIcon: "fa fa-plus-square-o", //节点展开时显示的图标        String
    });
    $(treeName).on('nodeSelected',function(event, data) {
        var obj = document.getElementById("PageOfficeCtrl").Document;
        // obj.Application.Selection.Font.ColorIndex =6;
        obj.Application.Selection.Font.Shading.BackgroundPatternColorIndex=7;
        obj.Application.Selection = '['+data.text+']';
        $( treeName).treeview('unselectNode', [data.nodeId, { silent: true }]);
    });
}

    //找出文档中的关键字
    function MarkKeyWord(value,visible) {
        var appSlt = document.getElementById("PageOfficeCtrl").Document.Application.Selection;
        appSlt.HomeKey(6);
        appSlt.Find.ClearFormatting();
        appSlt.Find.Replacement.ClearFormatting();
        appSlt.Find.Text = value;
        while (appSlt.Find.Execute())
        {
            if ( visible ) {
                if(serchIndex===0){
                    HighlightList.push(value)
                }
                // appSlt.Range.HighlightColorIndex = 7; //关键字高亮
            }else{
                // appSlt.Range.HighlightColorIndex = 0;
            }
        }
        appSlt.HomeKey(6);
    }

    //查找下一项
    function findNextClick(treeNode) {
        var appSlt = document.getElementById("PageOfficeCtrl").Document.Application.Selection;
        if(findIndex<HighlightList.length){
            findIndex +=1;
        }else{
            findIndex =HighlightList.length;
        }
        appSlt.HomeKey(6);
        appSlt.Find.ClearFormatting();
        appSlt.Find.Replacement.ClearFormatting();
        appSlt.Find.Text = HighlightValue;
        for(var i = 0;i<HighlightList.length;i++){
            if(i==findIndex){
                break;
            }
            appSlt.Find.Execute();
        }
        document.getElementById("click_"+treeNode.id).innerHTML = findIndex;
        if(findIndex===HighlightList.length && findIndex== 0 && HighlightList.length== 0){
            confirm("该文档未使用当前标签!");
        }
        if(findIndex===HighlightList.length && findIndex!== 0){
            var mymessage=confirm("当前已是最后一项，是否要返回首页？");
            if(mymessage==true) {
                findIndex = 0;
                serchIndex = 1;
                document.getElementById("click_"+treeNode.id).innerHTML = findIndex;
                appSlt.HomeKey(6);
            }
        }
    }
</script>