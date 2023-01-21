<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css'>
<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js'></script>
<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js'></script>
</head>
<body>
	<div class="container">
	  <h2>업로드가 완료 되었습니다.</h2>
	  <div class="panel panel-default">
	    <div class="panel-heading">스프링을 이용한 다중 파일 업로드 구현</div>
	    <div class="panel-body">
	    	<table class="table table-bordered table-hover">
	    		<tr>
	    			<td>아이디</td>
	    			<td>${map.id}</td>
	    		</tr>
   		   		<tr>
	    			<td>이름</td>
	    			<td>${map.name}</td>
	    		</tr>
	    		<c:forEach var="fName" items="${map.fileList }">
		    		<tr>
		    			<td>${fName}</td>
		    			<td>다운로드</td>
		    		</tr>
	    		</c:forEach>
	    	</table>
	    </div>
	  </div>
	</div>
</body>
</html>