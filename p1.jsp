<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>안녕하세요</h1>

	<form action="p2" method="post">
		<input type="text" name="name"><br> <input type="text"
			name="id"><br> <input type="submit" name="전송">
	</form>
	<hr>
	<form action="p3" method="post">
		<input type="text" name="name"><br> <input type="text"
			name="sno"><br> <input type="text" name="mathScore"><br>
		<input type="submit" name="전송">
	</form>
	<hr>
	<a href="p4/aaa/2/70">p4</a>

	<hr>
	<div>
		<button onclick="f()">실행</button>
	</div>
	<div id="demo">------</div>
	<script>
	function f(){
		const xhr = new XMLHttpRequest(); 
		xhr.onload = function(){
			
			const obj = JSON.parse(xhr.responseText); 
			document.getElementById("demo").innerHTML = obj.name+","+obj.sno+","+obj.mathScore;	
			
		
		};
		xhr.open('GET','p5'); //타겟 설정
		xhr.send(); //실행
		
		
	}
	

</script>
</body>
</html>