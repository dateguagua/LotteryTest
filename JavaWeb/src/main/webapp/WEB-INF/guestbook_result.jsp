<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>     
    
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>留言板</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css" >
		<style>
				.form_container{
					max-width: 500px;
					margin: 50px auto;
					padding:20px;
				}
				h2{
				text-align:center;
				}
		</style>
	</head>
		<body style="padding :20px"> 
			<div class ="form-container">
			<h2>留言板</h2>
			<form class="pure-form pure-form-stacked" method="post" action="/JavaWeb/guestbook">
			<fieldset>
			<legend>GuestBook_Result</legend>
				留言：${message}<p/>  <!-- 因為是字串 前面不用xxx. -->
				留言紀錄：${guestbooks}<p/>   <!-- 因為是陣列 前面不用xxx. -->
				<ol>
					<c:forEach var ="no" items="${guestbooks}">
						<li>${ no.message } ${ no.date }</li>
					</c:forEach>
				</ol>
				
				<a href="/JavaWeb/guestbook" class="pure-button pure-button-primary">返回</a> <!-- 網址的都是get -->
			</fieldset>
		</body>
</html>