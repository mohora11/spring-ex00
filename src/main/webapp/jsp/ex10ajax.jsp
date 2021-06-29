<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>

<%@ include file="/WEB-INF/subModules/bootstrapHeader.jsp" %>

<title>Insert title here</title>
<script>
$(function() {
	$("#submit1").click(function(e) {
		e.preventDefault(); // e가 재발생 안하도록
		$(this).attr("disabled", "disabled"); // 연속적으로 누르지 못하게 비활성화 
		$(this).html('<i class="fas fa-spinner fa-spin"></i>');
		
		var id = $("#input1").val();
		var age = $("#input2").val();
		
		var data = {id: id, age: age};
		
		$.post({
			url: "${appRoot}/rest10/add",
			data: data,
			success: function (data) {
				console.log(data);
				alert(data.id+ "가 등록되었습니다.");
				$("#submit1")
				.removeAttr("disabled") // 16행
				.html("전송");
			}
		});
	});
	
	// button2
	$("#button2").click(function() {
		$.get({
			url : "${appRoot}/rest10/list",
			success : function(list) {
				console.log(list);
				var t1body = $("#table1 tbody");
				t1body.empty();
				for (var i = 0; i < list.length; i++) {
					var tr = $(generateTableRow(list[i]));
					t1body.append(tr);
				}
			} 
		});
	});
	
	function generateTableRow(d) {
		return "<tr><td>" + d.id + "</td><td>" + d.age + "</td></tr>"
	}
	$("#like-button1").click(function() {
		var operation = $(this).attr("data-operation");
		
		var url = "${appRoot}/rest10/" + operation;
		
		$.post({
			url : url,
			success : function(data) {
				$("#like-cnt1").text(data);
				
				if (operation === "like") {
					$("#like-button1").attr("data-operation", "dislike");
					$("#like-icon1").removeClass("far").addClass("fas");
				} else {
					$("#like-button1").attr("data-operation", "like");
					$("#like-icon1").removeClass("fas").addClass("far");
				}
			}
		});
	});
})
</script>
</head>
<body>
<div class="container">
	<%= Math.random() %>
	<hr>
	<div id="like-button1" data-operation="like">
		<i id="like-icon1" class="far fa-thumbs-up"></i>
		<span id="like-cnt1">10</span>
	</div>
	
	<hr>
		<input id="input1" name="id" placeholder="id">
		<input id="input2" name="age" type="number" placeholder="age">
		<!--<input id="submit1" type="submit" value="전송">-->
		<button id="submit1">전송</button>
		
		<hr>
		
		<button id="button2">목록보기</button>
		
		<table class="table" id="table1">
			<thead>
			<tr>
				<th>ID</th>
				<th>AGE</th>
				</tr>
			</thead>
			<tbody>
			<script>
				
			</script>
			</tbody>
		</table>
</div>
</body>
</html>