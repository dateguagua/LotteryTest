<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>飲料點餐明細</title>
	</head>
		<body>
			<div>
			<legend> 飲料點餐明細	</legend>	
			飲料：${drinkOrder.type} <br/>
			尺寸：${drinkOrder.sizeText}  <br/>
			冰塊：${drinkOrder.iceText}  <br/>
			甜度：${drinkOrder.sugarText} <br/>
			${drinkOrder.info}  <br/>
			</div>
		</body>
</html>