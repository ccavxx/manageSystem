<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript" >
function turnPage(pageId){
	var reg=/^[0-9]*[1-9][0-9]*$/;
	if(reg.test($("#jumpPage").val())){
		pageId = $("#jumpPage").val();
	} 
    
    if(!reg.test(pageId)){
		return;
    }
	document.getElementById("toPage").value = pageId;
	var P = P || {};
	if(P.search == undefined){
		P.search = function(){
			 $("#pager-form").submit();
		}
	}
	P.search();
} 
 
function pageKeyPress(event,el){
  var keyCode =  event.keyCode ||event.which; 
  if(keyCode== 13) 
  	turnPage(el.value);
}
</script>


<div class="pagination pagination-centered">
 <ul>
<c:if test="${pager.totalPage >= 1 }">
						<c:if test="${ !empty pager.isFirstPage && pager.isFirstPage==false}"> 
						<li><a href="javascript:;" onclick="javascript:turnPage('1');">首页</a></li>
						<li><a href="javascript:;" onclick="javascript:turnPage('${pager.prevPage}');">上一页</a></li>
						</c:if>
						<c:forEach items="${pager.pageNumList}" var="pageNum" varStatus="num">
				       <c:choose>
					     <c:when test="${pager.toPage == pageNum}">
					      <li class="active">
							<a href="javascript:;">${pageNum}</a>
							</li>
					    </c:when>
					    <c:otherwise>
						<li><a href="javascript:;" onclick="javascript:turnPage(${pageNum})">${pageNum}</a></li>
					   </c:otherwise>
				       </c:choose>
			          </c:forEach>
			<c:if test="${ !empty pager.isLastPage && pager.isLastPage==false }">
				<li><a  href="javascript:;"  onclick="javascript:turnPage('${pager.nextPage}');">下一页</a></li>
				<li><a  href="javascript:;"  onclick="javascript:turnPage('${pager.totalPage}');">尾页</a></li>
			</c:if>
			<li><a>共${pager.totalPage}页&nbsp;-&nbsp; 本页${fn:length(pager.list)}条&nbsp;-&nbsp;（共${pager.totalItem}条）</a> </li>
			<li>&nbsp;&nbsp;<input type="text"  class="" name="jumPage" id="jumpPage"/>
			<button type="" onclick="javascript:turnPage(0)" class="btn_skyblue">跳转<i class="btn_skyblue_i"></i></button></li>
			<!-- foot 结束 -->
			<input type="hidden" id="toPage" name="toPage" value="${pager.toPage}" />
			<input type="hidden" name="totalItem" value="${pager.totalItem}" />
			<input type="hidden" name="pageSize" value="${pager.pageSize}" />
			
    </c:if>
  </ul>
</div>