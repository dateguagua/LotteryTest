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
			<legend>Coffee Maker Page_Result</legend>
				咖啡種類：${CoffeeMaker.type}<p/>
				牛奶量：${CoffeeMaker.milk}(ml)<p/>
				咖啡量：${CoffeeMaker.coffee}(ml)<p/>
				該種類風味描述:${CoffeeMaker.describe}<p/>
				
				<a href="/JavaWeb/user" class="pure-button pure-button-primary">返回</a> <!-- 網址的都是get -->
			</fieldset>
		</body>
</html>