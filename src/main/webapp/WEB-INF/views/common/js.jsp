<%@ page language="java" pageEncoding="UTF-8" %>
<!-- external javascript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->

<!-- jQuery -->
<script src="${ctx}/static/js/jquery-1.7.2.min.js"></script>
<!-- jQuery UI -->
<script src="${ctx}/static/js/jquery-ui-1.8.21.custom.min.js"></script>
<!-- transition / effect library -->
<script src="${ctx}/static/js/bootstrap-transition.js"></script>
<!-- alert enhancer library -->
<script src="${ctx}/static/js/bootstrap-alert.js"></script>
<!-- modal / dialog library -->
<script src="${ctx}/static/js/bootstrap-modal.js"></script>
<!-- custom dropdown library -->
<script src="${ctx}/static/js/bootstrap-dropdown.js"></script>
<!-- scrolspy library -->
<script src="${ctx}/static/js/bootstrap-scrollspy.js"></script>
<!-- library for creating tabs -->
<script src="${ctx}/static/js/bootstrap-tab.js"></script>
<!-- library for advanced tooltip -->
<script src="${ctx}/static/js/bootstrap-tooltip.js"></script>
<!-- popover effect library -->
<script src="${ctx}/static/js/bootstrap-popover.js"></script>
<!-- button enhancer library -->
<script src="${ctx}/static/js/bootstrap-button.js"></script>
<!-- accordion library (optional, not used in demo) -->
<script src="${ctx}/static/js/bootstrap-collapse.js"></script>
<!-- carousel slideshow library (optional, not used in demo) -->
<script src="${ctx}/static/js/bootstrap-carousel.js"></script>
<!-- autocomplete library -->
<script src="${ctx}/static/js/bootstrap-typeahead.js"></script>
<!-- tour library -->
<script src="${ctx}/static/js/bootstrap-tour.js"></script>
<!-- library for cookie management -->
<script src="${ctx}/static/js/jquery.cookie.js"></script>
<!-- calander plugin -->
<script src='${ctx}/static/js/fullcalendar.min.js'></script>
<!-- data table plugin -->
<script src='${ctx}/static/js/jquery.dataTables.min.js'></script>

<!-- chart libraries start -->
<script src="${ctx}/static/js/excanvas.js"></script>
<script src="${ctx}/static/js/jquery.flot.min.js"></script>
<script src="${ctx}/static/js/jquery.flot.pie.min.js"></script>
<script src="${ctx}/static/js/jquery.flot.stack.js"></script>
<script src="${ctx}/static/js/jquery.flot.resize.min.js"></script>
<!-- chart libraries end -->

<!-- select or dropdown enhancer -->
<script src="${ctx}/static/js/jquery.chosen.min.js"></script>
<!-- checkbox, radio, and file input styler -->
<script src="${ctx}/static/js/jquery.uniform.min.js"></script>
<!-- plugin for gallery image view -->
<script src="${ctx}/static/js/jquery.colorbox.min.js"></script>
<!-- rich text editor library -->
<script src="${ctx}/static/js/jquery.cleditor.min.js"></script>
<!-- notification plugin -->
<script src="${ctx}/static/js/jquery.noty.js"></script>
<!-- file manager library -->
<script src="${ctx}/static/js/jquery.elfinder.min.js"></script>
<!-- star rating plugin -->
<script src="${ctx}/static/js/jquery.raty.min.js"></script>
<!-- for iOS style toggle switch -->
<script src="${ctx}/static/js/jquery.iphone.toggle.js"></script>
<!-- autogrowing textarea plugin -->
<script src="${ctx}/static/js/jquery.autogrow-textarea.js"></script>
<!-- multiple file upload plugin -->
<script src="${ctx}/static/js/jquery.uploadify-3.1.min.js"></script>
<!-- history.js for cross-browser state change on ajax -->
<script src="${ctx}/static/js/jquery.history.js"></script>
<!-- application script for Charisma demo -->
<script src="${ctx}/static/js/charisma.js"></script>

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
