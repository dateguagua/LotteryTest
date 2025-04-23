<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>冰菓店的點餐系統</title>
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
			<div>
			<h2>冰菓店的點餐系統</h2>
			<!-- 單選 Servelet後台用req.getParameter("mainDish")會得到String -->
			<form class="pure-form" method="post" action="/JavaWeb/Ice">
			<fieldset>
			<legend>選擇主餐</legend>
					<input type="radio" name="mainDish" value="挫冰" required />挫冰 (＄50)<p/> 
					<input type="radio" name="mainDish" value="豆花" required />豆花 (＄40)<p/> 
			</fieldset>
			<fieldset>
			
			<legend>選擇加料(每樣10元)</legend>
			<!-- 單選 Servelet後台用req.getValue("toppings")會得到String[] -->
					<input type="checkbox" name="toppings" value="花生" >花生<p/> 
					<input type="checkbox" name="toppings" value="綠豆" >綠豆<p/> 
					<input type="checkbox" name="toppings" value="紅豆" >紅豆<p/> 
					<input type="checkbox" name="toppings" value="芋圓" >芋圓<p/> 
					<input type="checkbox" name="toppings" value="粉圓" >粉圓<p/> 
					<input type="checkbox" name="toppings" value="煉乳" >煉乳<p/>
			</fieldset>
			<button type ="submit" class="pure-button pure-form-primary">結帳</button>
			</form>
		</div>
	</body>
</html>