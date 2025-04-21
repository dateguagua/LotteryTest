
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>User Form</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css" >
	</head>
		<body style="padding :20px"> 
			<div class ="form-container">
			<h2>使用者資料結果</h2>
			<fieldset>
				<legend>User Result</legend>
				姓名：${user.userName}<p/>
				性別：${user.gender}<p/>
				年齡：${user.age}<p/>
				身高(cm):${user.height}<p/>
				體重(kg):${user.weight}<p/>
				BMI值：${user.bMIValue}<p/>
				診斷：${user.result}<p/>
				<a href="/JavaWeb/user" class="pure-button pure-button-primary">返回</a> <!-- 網址的都是get -->
			</fieldset>
		
		</body>
			</div>
</html>