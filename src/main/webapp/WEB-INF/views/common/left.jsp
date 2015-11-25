<%@ page language="java" pageEncoding="UTF-8" %>
<div class="span2 main-menu-span">
	<div class="well nav-collapse sidebar-nav">
		<ul class="nav nav-tabs nav-stacked main-menu">
			<li class="nav-header hidden-tablet">Main</li>
			<li><a class="ajax-link" href="${ctx}/news/list"><i class="icon-home"></i><span class="hidden-tablet"> 新闻管理</span></a></li>
			<li><a class="ajax-link" href="${ctx}/news/list1"><i class="icon-eye-open"></i><span class="hidden-tablet"> 留言管理</span></a></li>
		</ul>
		<label id="for-is-ajax" class="hidden-tablet" for="is-ajax"><input id="is-ajax" type="checkbox"> Ajax on menu</label>
	</div><!--/.well -->
</div><!--/span-->
