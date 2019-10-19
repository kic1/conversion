<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="container">
  <h2>conversion</h2>
  <p>* URL로 html을 읽어와서 문자열을 추출/정렬/조합/분할 합니다.</p>
  <form class="form-inline" action="" method="get" id="conversionForm">
	<table class="table table-bordered">
	  <colgroup>
		<col width="25%" />
		<col width="75%" />
	  </colgroup>
	  <tbody class="thead-dark">
	    <tr>
	      <th class="">URL</th>
	      <td>
			<div class="form-group has-feedback">
			  <input class="form-control required url" name="targetUrl" id="targetUrl" type="url" value="" placeholder="https://air.wonders.app/" style="width:350px" />
			</div>
		  </td>
	    </tr>
	    <tr>
	      <th class="thead-dark">Type</th>
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
	      <th class="thead-dark">출력묶음단위 (자연수)</th>
	      <td>
			<div class="form-group has-feedback">
			  <input class="form-control required" min="1" name="splitUnitAmount" id="splitUnitAmount" type="number" value="" placeholder="5" />
			</div>
		  </td>
	    </tr>
	    <tr><td colspan="2" class="text-center"><button type="button" class="btn btn-info" id="conversionSubmit">출력</button></td></tr>
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
	  <tbody class="thead-dark">
	    <tr>
	      <th class="">몫</th>
	      <td>
			<div class="form-group has-feedback">
			  <textarea class="text-area form-control" style="height: 150px" id="quotientDiv"></textarea>
			</div>
		  </td>
	    </tr>
	    <tr>
	      <th class="thead-dark">나머지</th>
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