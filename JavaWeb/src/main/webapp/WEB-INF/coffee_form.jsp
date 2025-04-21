<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Coffee Make</title>
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
			<h2>Coffee Make</h2>
			<form class="pure-form pure-form-stacked" method="post" action="/JavaWeb/CoffeeMaker">
			<fieldset>
			<legend>Coffee Maker Page</legend>
					<lable>請輸入牛奶毫升數</lable>(ml)
					<input name="milk" type="number" min="10" max="3000" required />
					
					<lable>請輸入咖啡毫升數</lable>(ml)
					<input name="coffee" type="number" min="10" max="3000" required />
					
					<button type ="submit" class="pure-form pure-form-primary">送出</button>
					
			</fieldset>
		</body>
</html>