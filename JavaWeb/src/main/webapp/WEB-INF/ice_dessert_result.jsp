<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>     
    
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>冰菓店點餐紀錄</title>
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
			<div class ="pure-form">
			<h2>冰菓店點餐紀錄</h2>
			<fieldset>
			
			<legend>Ice Shop_Result</legend>
			<c:set var="totalPriceSum" value="0" /> <!-- 初始化 totalPriceSum -->
			<table class ="pure-table pure-table-bordered">
						<thead>
							<tr>
								<th>No</th>
								<th>主餐</th>
								<th>配料</th>
								<th>價格</th>
								<th>刪除</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach varStatus ="i" var ="iceOrder" items="${iceOrders}"> <!-- 有編碼的排列出來  開始列出每筆訂單-->
								<tr>
									<td>${i.index+1}</td> <%-- ${ } 有空格會被當純文字 EX: $ { }--%> 
									<td>${iceOrder.mainDish.name}</td>
									<td>${iceOrder.topping.toppings}</td>
									<td>
									<!-- 算金額 -->
										<fmt:formatNumber value="${iceOrder.totalPrice}" type="currency" maxFractionDigits="0"/>
									</td>
									<!-- type="currency" → 顯示貨幣符號（NT$）
									maxFractionDigits="0" → 不顯示小數位（整數） -->
									<td title ="按我刪除" style="cursor: pointer;" onclick="deleteOrder(${i.index})">X</td>
									<!-- i.index 會從 0 開始遞增，所以第 1 筆是 0、第 2 筆是 1……這個值就是對應 List<IceOrder> 裡的索引位置 -->
									<!-- 這裡不用+1 -->
								</tr>
								<!-- 累加總價 -->
								<c:set var="totalPriceSum" value="${ totalPriceSum + iceOrder.totalPrice }"/>
							</c:forEach>
						</tbody>
						<tfoot>
							<tr style="background-color: #DDDDDD">
							<td colspan ="4" style="text-align: right;">總金額</td>
								<td>
									<fmt:formatNumber value="${ totalPriceSum }" type="currency" maxFractionDigits="0"/>
								</td>
							</tr>
						</tfoot>
					</table>
							<script>
						function deleteOrder(index) {
							    if (confirm("確定要刪除這筆訂單嗎？")) {
		     					   window.location.href = "${pageContext.request.contextPath}/Ice?index=" + index;
								  	  }
								}
							</script>
							<!-- window.location.href = "..."會直接改變當前網頁的網址 → 重新發出一個 HTTP GET 請求。 -->	
							<!-- 使用者點 X → onclick="deleteOrder(2)" -->
				<a href="/JavaWeb/Ice" class="pure-button pure-button-primary">返回</a> <!-- 網址的都是get -->
			</fieldset>
		</div>
	</body>
</html>