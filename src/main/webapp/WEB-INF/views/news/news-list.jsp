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
	
	
	<!-- The HTML5 shim, for IE6-8 support of HTML5 elements -->
	<!--[if lt IE 9]>
	  <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
	<![endif]-->

	<!-- The fav icon -->
	<link rel="shortcut icon" href="img/favicon.ico">
	
	<script type="text/javascript">
		function deleteById(id){
			$.ajax({
				  type: 'POST',
				  url: "${ctx}/news/delete",
				  data:{id:id},
				  async:false,
				  dataType:"text",
				  success:function(data){
					 if(data == "true"){
						 alert("删除成功");
						 $("#tr_"+id).remove();
					 }else{
						 alert("删除失败");
					 }
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
						<a href="#">Tables</a>
					</li>
				</ul>
			</div>
			
			<div class="row-fluid sortable">		
				<div class="box span12">
					<div class="box-header well" data-original-title>
						<h2><i class="icon-user"></i> 新闻列表</h2>
						<div class="box-icon">
							<a href="${ctx}/news/add" class="btn"><i class="icon-plus"></i></a>
						</div>
					</div>
					<div class="box-content">
						<form action="${ctx}/news/list" method="post" id="pager-form">
						<table class="table ">
						  <thead>
							  <tr>
								  <th>id</th>
								  <th>title</th>
								  <th>author</th>
								  <th>createDate</th>
								  <th>newsType</th>
								  <th>操作</th>
							  </tr>
						  </thead>   
						  <tbody>
						  	<c:forEach items="${pager.list}" var="news">
						  		<tr id="tr_${news.id}">
									<td>${news.id }</td>
									<td class="center"><c:out value="${news.title }"/></td>
									<td class="center">${news.author }</td>
									<td class="center"><fmt:formatDate value="${news.createTime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
									<td class="center">
										<c:if test="${news.newsType == 1 }">公司新闻</c:if>
										<c:if test="${news.newsType == 2 }">行业动态</c:if>
									</td>
									<td class="center">
										<a class="btn btn-info" href="${ctx}/news/updatePage?id=${news.id}">
											<i class="icon-edit icon-white"></i>  
											Edit                                            
										</a>
										<a class="btn btn-danger" href="#" onclick="deleteById(${news.id });">
											<i class="icon-trash icon-white"></i> 
											Delete
										</a>
									</td>
								</tr>
						  	</c:forEach>
						  </tbody>
					  </table>  
					  <%@ include file="../common/pager.jsp"%>
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
				<button type="button" class="close" data-dismiss="modal">Ã</button>
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

	<%@ include file="../common/js.jsp"%>
	
</body>
</html>

