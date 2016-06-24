<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="../common/taglibs.jsp"%>

<link rel="stylesheet" type="text/css" href="${ctx }/diff/css/diffview.css"/>
<div class="wrap">
	<div id="diffoutput" style="clear:both;width:100%;"></div>
	<div style="clear:both;">&nbsp;</div>
</div>
<!-- 后端传值比较 -->
<%-- <input id="str1_h" type="hidden" value="${str2}"/>
<input id="str2_h" type="hidden" value="${str1}"/>
<input id="verson1_h" type="hidden" value="${version2}"/>
<input id="verson2_h" type="hidden" value="${version1}"/> --%>

<!-- 前端写死内容比较 -->
<input id="str1_h" type="hidden" 
	value="ab
			++cd
				boy
			2016年6月24日
			123456789"
/>
<input id="str2_h" type="hidden" 
	value="ab
			++cd
				girl
			2016年6月24日		
			123456789"
/>
<input id="verson1_h" type="hidden" value="2016年6月24日14:47:42"/>
<input id="verson2_h" type="hidden" value="2016年6月24日14:47:48"/>

<div style="clear:both;">&nbsp;</div>							

<script type="text/javascript" src="${ctx }/static/js/jquery.js"></script>
<script type="text/javascript" src="${ctx }/diff/js/diffview.js"></script>
<script type="text/javascript" src="${ctx }/diff/js/jsdiff.js"></script>
<script type="text/javascript" src="${ctx }/diff/js/difflib.js"></script>
<script type="text/javascript">
var BCompareHandle = {
		diffUsingJS:function(parameter){
			if(null != parameter && parameter.length>0){
				var base = difflib.stringAsLines(parameter[0]);
				var newtxt = difflib.stringAsLines(parameter[1]);
				var baseName = parameter[2] == null ? "版本一" : parameter[2];
				var newName = parameter[3] == null ? "版本二" : parameter[3];
				var sm = new difflib.SequenceMatcher(base, newtxt);
				var opcodes = sm.get_opcodes();
				var diffoutputdiv = document.getElementById("diffoutput");
				while (diffoutputdiv.firstChild){
					diffoutputdiv.removeChild(diffoutputdiv.firstChild);
				}
				var contextSize = 0;
				contextSize = contextSize ? contextSize : null;
				diffoutputdiv.appendChild(diffview.buildView({ baseTextLines:base,
															   newTextLines:newtxt,
															   opcodes:opcodes,
															   baseTextName:baseName,
															   newTextName:newName,
															   contextSize:contextSize,
															   viewType: 0}));
			}else{
				return false;
			}
		}
}

//渲染完成后
//获取数据的过程的词的
var str1 = $("#str1_h").val();
var str2 = $("#str2_h").val();
var verson1 = "version:"+$("#verson1_h").val();
var verson2 = "version:"+$("#verson2_h").val();
var temp = [str1,str2,verson1,verson2];
BCompareHandle.diffUsingJS(temp);

</script>