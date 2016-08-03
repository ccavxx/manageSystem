<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="../common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<!--
		Charisma v1.0.0

		Copyright 2012 Muhammad Usman
		Licensed under the Apache License v2.0
		http://www.apache.org/licenses/LICENSE-2.0

		http://usman.it
		http://twitter.com/halalit_usman
	-->
	<meta charset="utf-8">
	<title>Free HTML5 Bootstrap Admin Template</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="Charisma, a fully featured, responsive, HTML5, Bootstrap admin template.">
	<meta name="author" content="Muhammad Usman">
	
	<!-- The styles -->
	<link id="bs-css" href="${ctx }/static/css/bootstrap-cerulean.css" rel="stylesheet">
	<style type="text/css">
	  body {
		padding-bottom: 40px;
	  }
	  .sidebar-nav {
		padding: 9px 0;
	  }
	</style>
	<%@ include file="../common/css.jsp"%>
	<%@ include file="../common/js.jsp"%> 
	

	<!-- The HTML5 shim, for IE6-8 support of HTML5 elements -->
	<!--[if lt IE 9]>
	  <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
	<![endif]-->

	<!-- The fav icon -->
	<link rel="shortcut icon" href="img/favicon.ico">
	
	<script src="${ctx}/static/js/ajaxfileupload.js"></script>
	<script type="text/javascript">
		
	
		$(document).ready(function(){
			//默认装载的新闻类型
			var newsType = "${news.newsType}";
			$("#selectError3").val(newsType); 
			
			
		});
	
		function save(id){
			var title = $("#title").val();
			var newsType = $("#selectError3").val();
			//获取编辑器的内容
			var editor = UE.getEditor('container');	
			var content = editor.getContent();
			var url;
			if(id == undefined){
				url = "${ctx}/news/add";
			}else{
				url = "${ctx}/news/update"
			}
			$.ajax({
				  type: 'POST',
				  url: url,
				  data:{id:id,title:title,newsType:newsType,content:content},
				  async:false,
				  dataType:"text",
				  success:function(data){
					 if(data == "true"){
						 alert("保存成功");
						 window.location.href = "${ctx}/news/list";
					 }else{
						 alert("保存失败");
					 }
			      }
			});
		}
		
		function uploadImages(type) {
			$.ajaxFileUpload({
		        url:'${ctx}/ajaxUpload/'+type+'?popup=true',             //需要链接到服务器地址
		        secureuri:false,
		        fileElementId:''+type+'',                         //文件选择框的id属性（必须）
		        dataType: 'JSON',  
		        success: function (data){
		        	$("div#"+type).empty();
		        	$("<img/>",{"src":"${ctx}"+data}).appendTo($("div#"+type));
					$("<input/>",{"type":"hidden","value":data,"name":type}).appendTo($("div#"+type));
		        }
		      });
		  }
	</script>
	
</head>

<body>
		<%@ include file="../common/header.jsp"%>
		<div class="container-fluid">
		<div class="row-fluid">
				
			<!-- left menu starts -->
			<%@ include file="../common/left.jsp"%>
			<!-- left menu ends -->
			
			<noscript>
				<div class="alert alert-block span10">
					<h4 class="alert-heading">Warning!</h4>
					<p>You need to have <a href="http://en.wikipedia.org/wiki/JavaScript" target="_blank">JavaScript</a> enabled to use this site.</p>
				</div>
			</noscript>
			
			<div id="content" class="span10">
			<!-- content starts -->
			

			<div>
				<ul class="breadcrumb">
					<li>
						<a href="#">Home</a> <span class="divider">/</span>
					</li>
					<li>
						<a href="#">Forms</a>
					</li>
				</ul>
			</div>
			
			<div class="row-fluid sortable">
				<div class="box span12">
					<div class="box-header well" data-original-title>
						<h2><i class="icon-edit"></i> Form Elements</h2>
						<div class="box-icon">
							<a href="#" class="btn btn-setting btn-round"><i class="icon-cog"></i></a>
							<a href="#" class="btn btn-minimize btn-round"><i class="icon-chevron-up"></i></a>
							<a href="#" class="btn btn-close btn-round"><i class="icon-remove"></i></a>
						</div>
					</div>
					<div class="box-content">
						<form class="form-horizontal">
						  <fieldset>
							<legend>Datepicker, Autocomplete, WYSIWYG</legend>
							<div class="control-group">
								<label class="control-label" for="selectError3">新闻分类</label>
								<div class="controls">
								  <select id="selectError3">
									<option value="1">公司新闻</option>
									<option value="2">行业动态</option>
								  </select>
								</div>
							  </div>
							<div class="control-group">
								<label class="control-label" for="focusedInput">标题</label>
								<div class="controls">
								  <input class="input-xlarge focused" id="title" type="text" value="<c:out value="${news.title }" />">
								</div>
							</div>
							<div class="control-group">
							  <label class="control-label" for="textarea2">新闻内容</label>
							  <div class="controls">
								<!--自带的编辑器
								<textarea class="cleditor" id="textarea2" rows="3">${news.content }</textarea>
							  	-->
							  	
							  	<!-- 加载编辑器的容器（百度UEditor）start -->
							    <script id="container" name="content" type="text/plain">
       								 ${news.content }
    							</script>
							    <!-- 配置文件 -->
							    <script type="text/javascript" src="${ctx}/ueditor/ueditor.config.js"></script>
							    <!-- 编辑器源码文件 -->
							    <script type="text/javascript" src="${ctx}/ueditor/ueditor.all.js"></script>
							    <!-- 实例化编辑器 -->
							    <script type="text/javascript">
							        var ue = UE.getEditor('container');
							    </script>
							    <!-- 加载编辑器的容器（百度UEditor）end -->
							    
							  </div>
							</div>
							<div class="control-group">
								<label class="control-label">新闻图片</label>
								<div class="controls">
								<input  name="iconBig" type="file" id="iconBig" onchange="uploadImages(this.id)"/>
								</div>
								<div id="iconBig" class="controls">
			                    	 <img src=""/>
			                         <input type="hidden" name="iconBig" value=""/>
			                     </div>
							</div>
							<div class="form-actions">
							  <button type="button" class="btn btn-primary" onclick="save(${news.id});">Save changes</button>
							  <button type="reset" class="btn">Cancel</button>
							</div>
						  </fieldset>
						</form>   

					</div>
				</div><!--/span-->

			</div><!--/row-->
					<!-- content ends -->
			</div><!--/#content.span10-->
				</div><!--/fluid-row-->
				
		<hr>

		<div class="modal hide fade" id="myModal">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">×</button>
				<h3>Settings</h3>
			</div>
			<div class="modal-body">
				<p>Here settings can be configured...</p>
			</div>
			<div class="modal-footer">
				<a href="#" class="btn" data-dismiss="modal">Close</a>
				<a href="#" class="btn btn-primary">Save changes</a>
			</div>
		</div>

		<footer>
			<p class="pull-left">&copy; <a href="http://usman.it" target="_blank">Muhammad Usman</a> 2012</p>
			<p class="pull-right">Powered by: <a href="http://usman.it/free-responsive-admin-template">Charisma</a></p>
		</footer>
		
	</div><!--/.fluid-container-->
	
</body>
</html>
<%@ include file="../common/pager.jsp"%>



