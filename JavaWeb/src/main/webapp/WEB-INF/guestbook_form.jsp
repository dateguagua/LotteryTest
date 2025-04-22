<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
			<legend>Guest Book</legend>
					<lable>請輸入留言</lable>
					<textarea name="message" type="text" required /></textarea> 
				
					<button type ="submit" class="pure-form pure-form-primary">送出</button>
					
			</fieldset>
		</body>
</html>