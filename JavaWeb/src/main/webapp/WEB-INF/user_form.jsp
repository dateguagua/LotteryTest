<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>User Form</title>
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
			<h2>使用者資料表單</h2>
			<form class="pure-form pure-form-stacked" method="post" action"/JavaWeb/user">
				<fieldset>
					<legend>User Form</legend>
					<lable>姓名：</lable>
					<input id = "userName" name="userName" type="text" required/>
					
					<lable>性別：</lable>
					<lable class="pure-radio"/>
						<input name="gender" type="radio" value="male" checked>&nbsp;男
					</lable>
					<lable class="pure-radio"/>
						<input name="gender" type="radio" value="male">&nbsp;女
					</lable>
					
					<lable>年齡</lable>
					<input name="age" type="number" min="1" max="150" required />
					
					<lable>身高(cm)</lable>
					<input name="height" type="number" min="1" max="300" step="0.1" required />
					
					<lable>體重(kg)</lable>
					<input name="weight" type="number" min="0.1" max="1000" step="0.1" required />
					
					<button type ="submit" class="pure-form pure-form-primary">送出</button>
				</fieldset>
			</form>
			</div>
		</body>
</html>
