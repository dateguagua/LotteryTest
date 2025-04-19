<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Coffee Order</title>
</head>
<body>
		<div>
			<fieldset>
					<legend>Coffee Order</legend>
					咖啡：${ coffeOrder.type }<br /> <!-- 背後其實是找 get屬性() 或 is屬性() -->
					容量：${ coffeOrder.sizeText }<br />
					含糖：${ coffeOrder.sugarText }<br />
					${ coffeOrder.info }<br />
			</fieldset>
		</div>
</body>
</html>