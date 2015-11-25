<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD  HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'user-form.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="${ctx}/js/jquery-1.11.1.min.js"></script>

  </head>
  
  <body>
  	
  	<h2>Ȩ���б�</h2>  
    <shiro:authenticated>�û��Ѿ���¼��ʾ������</shiro:authenticated>
    <br/>
    <shiro:user>
		��ӭ[${ user.username}]��¼
	</shiro:user> 
	<br/>
    <shiro:hasRole name="role:manager">manager��ɫ��¼��ʾ������</shiro:hasRole>   
    <shiro:hasRole name="role:admin">admin��ɫ��¼��ʾ������</shiro:hasRole>   
    <shiro:hasRole name="role:normal">normal��ɫ��¼��ʾ������</shiro:hasRole> 
    <br/>  
    <shiro:hasAnyRoles name="role:manager,role:admin,role:normal">**manager or admin or normal ��ɫ�û���¼��ʾ������**</shiro:hasAnyRoles>
    <br/>
    <br/>
    <shiro:hasPermission name="perms:admin">adminȨ���û���ʾ������</shiro:hasPermission>  
    <br/>
    <shiro:lacksPermission name="perms:admin"> ������adminȨ�޵��û���ʾ������ </shiro:lacksPermission>   
  	<br/>
  
   	<table>
   		<tr>
   			<td>id</td>
   			<td>username</td>
   			<td>password</td>
   			<td>status</td>
   			<td>����</td>
   		</tr>
   		<c:forEach var="user" items="${userList}">
   			<tr>
   				<td>${user.id}</td>
   				<td>${user.username}</td>
   				<td>${user.password}</td>
   				<td>${user.status}</td>
   				<td>
   					<a href="${ctx}/user/update/${user.id}">�޸�</a>
   					<a href="javascript:remove(${user.id})">ɾ��</a>
   				</td>
   			</tr>
   		</c:forEach>
   	</table>
   	
   	<script type="text/javascript">
   		function remove(id){
   			$.get("${ctx}/user/delete/"+id,function(msg){
   				if(msg){
   					alert('ɾ���ɹ�');
   				}else{
   					alert('ɾ��ʧ��');
   				}
   				location.reload();
   			});
   		}
   	</script>
   	
  </body>
</html>
