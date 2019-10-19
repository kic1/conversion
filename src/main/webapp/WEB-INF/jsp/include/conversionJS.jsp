<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><!-- 자바스크립트 jsp -->
<script type="text/javascript">
//<![CDATA[
$(document).ready(function(){

	$("#conversionForm").validate();

	$("#conversionSubmit").click(function(){

		initialResultArea();
		
		var params = {
			targetUrl       : $("#targetUrl").val(),
			filterCondition : $("#filterCondition").val(),
			splitUnitAmount : $("#splitUnitAmount").val()
		};
		
		$.ajax({
	      type        : "GET",
	      url         : "/api/conversion",
	      dataType    : "json",
		  contentType : "application/json; charset=utf-8",
		  data        : params
		})
		.done(function(resultJson) {
			$("#quotientDiv").text(resultJson.quotientText);
			$("#remainDiv").text(resultJson.remainText);
		})
		.fail(function (XMLHttpRequest, textStatus, errorThrown) {
	  		console.log('errorThrown:'+errorThrown);
	  		messagePrint(XMLHttpRequest.status);
		})
	});
});

function messagePrint(status) {
	switch (status) {
		case 204:
			$("#message").text("데이터가 없습니다.");
			break;
		case 400:
			$("#message").text("잘못된 요청입니다.");
			break;
		case 401:
			$("#message").text("권한이 없습니다.");
			break;
		case 410:
			$("#message").text("서버가 존재하지 않거나 유효한 데이터가 없습니다.");
			break;
		case 500:
			$("#message").text("처리중 오류가 발생하였습니다.");
			break;
 		}
}

function initialResultArea() {
	$("#message").text("");
	$("#quotientDiv").text("");
	$("#remainDiv").text("");
}

//]]>
</script>