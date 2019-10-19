<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="container">
  <h2>conversion</h2>
  <p>
  	* URL로 html을 읽어와서 문자열을 추출/정렬/조합/분할 합니다.<br/>
  	URL : https://okky.kr/article/639505<br/>
  	Type : INCLUDE_ALL_TEXT<br/>
  	출력묶음단위(자연수) : 5
  </p>
  <form class="form-inline" action="" method="get" id="conversionForm">
	<table class="table table-bordered">
	  <colgroup>
		<col width="25%" />
		<col width="75%" />
	  </colgroup>
	  <tbody>
	    <tr>
	      <th class="active">URL</th>
	      <td>
			<div class="form-group has-feedback">
			  <input class="form-control required url" name="targetUrl" id="targetUrl" type="url" value="" placeholder="https://air.wonders.app/" />
			</div>
		  </td>
	    </tr>
	    <tr>
	      <th class="active">Type</th>
	      <td>
			<div class="form-group has-feedback">
              <select class="form-control required" id="filterCondition" name="filterCondition">
                  <option value="EXCLUDE_HTML_TAG">HTML 태그제외</option>
                  <option value="INCLUDE_ALL_TEXT">Text 전체</option>
              </select>
			</div>
		  </td>
	    </tr>
	    <tr>
	      <th class="active">출력묶음단위(자연수)</th>
	      <td>
			<div class="form-group has-feedback">
			  <input class="form-control required" min="1" name="splitUnitAmount" id="splitUnitAmount" type="number" value="" placeholder="5" />
			</div>
		  </td>
	    </tr>
	    <tr><td colspan="2"><button type="button" id="conversionSubmit">출력</button></td></tr>
	  </tbody>
	  </table>
  </form>
  <h2>결과</h2>
  <div id="message" style="color:red"></div>
  <div id="result">
	<table class="table table-bordered">
	  <colgroup>
		<col width="25%" />
		<col width="75%" />
	  </colgroup>
	  <tbody>
	    <tr>
	      <th class="active">몫</th>
	      <td>
			<div class="form-group has-feedback">
			  <textarea class="text-area form-control" style="height: 150px" id="quotientDiv"></textarea>
			</div>
		  </td>
	    </tr>
	    <tr>
	      <th class="active">나머지</th>
	      <td>
			<div class="form-group has-feedback">
			  <textarea class="text-area form-control" style="height: 150px" id="remainDiv"></textarea>
			</div>
		  </td>
	    </tr>
	  </tbody>
	</table>
  </div>
</div>
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