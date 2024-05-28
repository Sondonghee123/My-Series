<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script>
	function nuboori() {
		var img1 = document.querySelector(".img1");
		if(img1!=null){
			img1.classList.remove("img1");
			setTimeout(() => {
				document.querySelector("#my").classList.add("img1"); // 클래스 하나
			}, 10); 
		}else {
			document.querySelector("#my").classList.add("img1"); // 클래스 하나	
		}
	}
	
	function bonobono1() {
		var img2 = document.querySelector(".img2");
		img2.classList.add("img2move");
	}
	
	function bonobono2() {
		var img2 = document.querySelector(".img3");
		img2.classList.add("img3move");
	}
</script>
<style>
	.img1{
    animation-duration: 0.1s;
    animation-name: rotate;  
    animation-iteration-count: 1;
    }
    #my{
    	transform-origin: 50% 50%;
		display: block;
		margin : 0 auto;
    }
    
	@keyframes rotate {
	  from {
	    -webkit-transform: rotate(0deg);
	    -o-transform: rotate(0deg);
	    transform: rotate(0deg);
	  }
	  to {
	    -webkit-transform: rotate(360deg);
	    -o-transform: rotate(360deg);
	    transform: rotate(360deg);
	  }
	}
	
	.img2 {
    	bottom: 30px;
        left: 350px;
    	width: 200px;
    	position: fixed;
	}
	
	.img2move {
		animation-duration: 2s;
      	animation-name: slidein;
      	animation-iteration-count: infinite;
      }

    @keyframes slidein {
      from {
        left: 350px;
      }
      to {
        left: 25px;
      }
    }
    
	.img3 {
		bottom: 30px;
        right: 350px;
    	width: 200px;
    	position: fixed;
	}
	.img3move {
      animation-duration: 2s;
      animation-name: slidein1;
      animation-iteration-count: infinite;
    }
    @keyframes slidein1 {
      from {
        right: 350px;
      }
      to {
        right: 25px;
      }
    }
</style>
<title>Insert title here</title>
</head>
<style>
body {
	background: linear-gradient(90deg, rgba(251,63,63,1) 0%, rgba(255,143,0,1) 18%, rgba(240,252,70,1) 28%, rgba(70,252,114,1) 41%, rgba(70,188,252,1) 58%, rgba(16,12,193,1) 75%, rgba(236,70,252,1) 95%);
}
</style>
<body>
	<h1>존재하지 않는 페이지입니다</h1>
	<h2>에러 메시지: <%=exception %></h2>
	<img id="my" class="img1" src="./images/11.png" style="cursor:pointer;" onclick = "nuboori()">
	<img src="./images/bonorev.png" class="img2" style="cursor:pointer;" onclick = "bonobono1()">
	<img src="./images/bono.png" class="img3" style="cursor:pointer;" onclick = "bonobono2()">
</body>
</html>