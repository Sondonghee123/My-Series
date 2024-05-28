<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>나만의 시리즈</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

	<style>
        @import url('https://fonts.googleapis.com/css2?family=Gowun+Dodum&display=swap'); 

        * {
            font-family: 'Gowun Dodum', sans-serif; 
        }

        .main {
            background: linear-gradient(90deg, rgba(3,0,45,1) 0%, rgba(0,0,105,1) 50%, rgba(3,0,45,1) 100%);
            color: white;
            background-position: center;
            background-size: contain;
        }

        body {
            background-color: black;
        }

        .mycards {
            width: 1200px;
            margin: 20px auto 0px auto;
        }
        
        .mybox {
            display: none;
            width: 500px;
            margin: 20px auto 0px auto;
            border: 1px solid white;
            padding: 20px;
            border-radius: 5px;
        }

        .form-floating>input {
            background-color: transparent;
            color: white;
        }

        .form-floating>label {
            color: white;
        }

        .input-group>label {
            background-color: transparent;
            color: white;
        }

        .mypostingbox>button {
            width: 100%;
        }
        
        #topSection {
        	padding-top: 0rem !important;
    		padding-bottom: 0rem !important;
        }
        
        #fle {
        	height: 80px;
        	width: 1600px;
        }
        
        #qq {
        	margin: 0px;
        }
        
        #title1{
        	font-weight: bold;
        	font-size: 35px;
        	color: #dc3545;
        	margin-right: 75px;
        }
        
        .category{
        	font-weight: bold;
        	font-size: 20px;
        	color: #dc3545;
        	background-color: black;
        	border: none;
        }
        
        
        #picmessage {
        	color: white;
        }
        
        #imgheight {
       		object-fit: contain;
    		margin: auto 0;
        }
        
        .card-body {
        	padding: 15px 10px;
        }
        
        .cardImgArea {
        	height: 420px;
        	width: 280px;
        	display: flex;
        }
        
        .card-img-width {
        	width: 100%;
        }
        
        #title_ex{
        	background-color: gray;
        }
        
        .disableBtn {
        	
        }
        
        .carduser {
        	border: none;
        	background-color: white;
        	margin-bottom: 8px;
        }
        
        .card-title {
        	font-weight: bold;
        	height: 47px;
        }
        
        #currentuser {
        	color: #dc3545;
        	font-weight: bold;
        	font-size: 20px;
        	background-color: black;
        	margin: auto 20px auto auto;
 			border: none;
        }
        
        #logoutbtn {
        	color: #dc3545;
        	font-weight: bold;
        	font-size: 20px;
        	background-color: black;
        	margin-right: -50px;
 			border: none;
        }
        
        .categorybox {
        	width: 475px;
        	display: flex;
        	justify-content: space-between;
        	margin: 0 auto;
        }
        
        .card-date_m {
        	margin-top: 7px;
        	float: right;
        }
</style>

    <script>
    $(function() {
    	$("#postingbtn").on("click", posting);
    	$("#selectbtn").on("click", titleselect);
    	$("#idselectbtn").on("click", idselect);
    	$("#scoreselectbtn").on("click", scoreselect);
    	$("#modify").on("click", modify);
    	$(".deletebtn").on("click", deletebytitle);
    	 
    	 $("#category1").on("click", function () {
    		 $('#insertbox').toggle();
             $('#selectbox').css("display", "none");
             $('#idselectbox').css("display", "none");
             $('#scoreselectbox').css("display", "none");
             $('#modifybox').css("display", "none");
         });
    	 
    	 $("#category2").on("click", function () {
    		 $('#insertbox').css("display", "none");
             $('#selectbox').toggle();
             $('#idselectbox').css("display", "none");
             $('#scoreselectbox').css("display", "none");
             $('#modifybox').css("display", "none");
         });
    	 
    	 $("#category3").on("click", function () {
             $('#insertbox').css("display", "none");
             $('#selectbox').css("display", "none");
             $('#idselectbox').toggle();
             $('#scoreselectbox').css("display", "none");
             $('#modifybox').css("display", "none");
         });
    	 
    	 $("#category4").on("click", function () {
             $('#insertbox').css("display", "none");
             $('#selectbox').css("display", "none");
             $('#idselectbox').css("display", "none");
             $('#scoreselectbox').toggle();
             $('#modifybox').css("display", "none");
         });
    	 
    	 $(".modifybtn").on("click", function () {
             $('#insertbox').css("display", "none");
             $('#selectbox').css("display", "none");
             $('#idselectbox').css("display", "none");
             $('#scoreselectbox').css("display", "none");
             $('#modifybox').css("display", "block");
             $("html").scrollTop(340);
             var cardTitle = $(this).parent().children(".card-title").text();
             $("#title_ex").val(cardTitle);
             $("#title_m").val(cardTitle);
             var cardType = $(this).parent().children(".card-type_m").text();
             $("#type_m").val(cardType);
             var cardScore = $(this).parent().children(".card-score_m").text();
             $("#star_m").val(cardScore);
             var cardComments = $(this).parent().children(".card-comment_m").text();
             $("#comment_m").val(cardComments);
         });
    	 
    	 $("#postingclose").on("click", function () {
    		 $('#insertbox').css("display", "none");
         });
    	 
    	 $("#modifyclose").on("click", function () {
    		 $('#modifybox').css("display", "none");
         });
    	 
    	 $("#selectclose").on("click", function () {
    		 $('#selectbox').css("display", "none");
         });
    	 
    	 $("#idselectclose").on("click", function () {
    		 $('#idselectbox').css("display", "none");
         });
    	 
    	 $("#scoreselectclose").on("click", function () {
    		 $('#scoreselectbox').css("display", "none");
         });
    });
    
    function posting() {
    	let image = $('#image').val().split("\\").pop();
        let title = $('#title').val();
        let type = $('#type').val();
        let star = $('#star').val();
        let comment = $('#comment').val();
        
        if (!title) {
            alert('제목을 써주세요!');
            return;
        }
        
        if (image=="" || image==null) {
        	console.log(image);
            alert('이미지를 채워주세요!');
            return;
        }
        
        if (!type) {
            alert('미디어종류를 써주세요!');
            return;
        }

        if (star !== '1' && star !== '2' && star !== '3' && star !== '4' && star !== '5') {
            alert('별점을 선택해주세요!');
            return;
        }
        
        if (!comment || comment.length>=18) {
            alert('코멘트를 17자 이하로 써주세요!');
            return;
        }
        console.log(image);
    	$.ajax({
    		url: "insert.go",
    		type: "get",
    		data: {"image" : image, "type": type, "title": title, "star":star, "comment":comment},
    		success: function(data) {
    			if(data==1){
    				alert('기록 완료!');
    			}else {
    				alert('기록 실패!');
    			}
                window.location.reload();
    		}, error: function(err) {
    			alert(err + '기록 불가 ㅠㅠ');
    		}
    	});
    }
    
    function titleselect(){
    	let titleselect = $('#titleselect').val();
    	
    	if (!titleselect) {
            alert('제목을 써주세요!');
            return;
        }
    	
    	$.ajax({
    		url: "tselect.go",
    		type: "get",
    		data: {"titleselect": titleselect},
    		success: function(data) {
                $("#card").html(data);
    		}, error: function() {
    			alert('조회 불가 ㅠㅠ');
    		}
    	});
    }
    
    function idselect(){
    	let idselect = $('#idselect').val();
    	
    	if (!idselect) {
            alert('사용자 아이디를 써주세요!');
            return;
        }
    	
    	$.ajax({
    		url: "idselect.go",
    		type: "get",
    		data: {"idselect": idselect},
    		success: function(data) {
                $("#card").html(data);
    		}, error: function() {
    			alert('조회 불가 ㅠㅠ');
    		}
    	});
    }
    
    function scoreselect(){
    	let scoreselect = $('#scoreselect').val();
    	
    	if (scoreselect == "0"  || scoreselect == null) {
            alert('별점을 골라주세요!');
            return;
        }
    	
    	$.ajax({
    		url: "scoreselect.go",
    		type: "get",
    		data: {"scoreselect": scoreselect},
    		success: function(data) {
    			$("#card").html(data);
    		}, error: function() {
    			alert('조회 불가ㅠㅠ');
    		}
    	});
    }
    
    function modify(){
    	let image_m = $('#image_m').val().split("\\").pop();
        let title_m = $('#title_m').val();
        let type_m = $('#type_m').val();
        let star_m = $('#star_m').val();
        let comment_m = $('#comment_m').val();
        let originalname = $('#title_ex').val();
        
        if (!title_m) {
            alert('제목을 써주세요!');
            return;
        }
        
    	if (image_m=="" || image_m==null) {
            alert('이미지를 채워주세요!');
            return;
        }
        
        if (!type_m) {
            alert('미디어종류를 써주세요!');
            return;
        }

        if (star_m !== '1' && star_m !== '2' && star_m !== '3' && star_m !== '4' && star_m !== '5') {
            alert('별점을 선택해주세요!');
            return;
        }
        
        if (!comment_m || comment_m>=18) {
            alert('코멘트를 17자 이하로 써주세요!');
            return;
        }
    	
    	$.ajax({
    		url: "modify.go",
    		type: "post",
    		data: {"image_m": image_m, "type_m": type_m, "title_m": title_m, "star_m": star_m, "comment_m": comment_m, "originalName": originalname},
    		success: function(data) {
    			$("#card").html(data);
    			window.location.reload();
    		}, error: function() {
    			alert('수정 불가ㅠㅠ');
    		}
    	});
    }
    
    function deletebytitle() {
		let card_title = $(this).parent().children(".card-title").text();
		if (confirm(card_title + " 정말로 삭제하시겠습니까?")) {
            $.ajax({
        		url: "delete.go",
        		type: "get",
        		data: {"card_title": card_title},
        		success: function(data) {
                    $("#card").html(data);
                    window.location.reload();
        		}, error: function() {
        			alert('삭제 불가 ㅠㅠ');
        		}
        	});
        } else {
        }
    }
    </script>
</head>

<body>



    <header id="categorybox" class="p-3 text-bg-dark">
        <div id="qq" class="container">
            <div id="fle" class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
                <a href="/" class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none">
                    <svg class="bi me-2" width="40" height="32" role="img" aria-label="Bootstrap">
                        <use xlink:href="#bootstrap"></use>
                    </svg>
                </a>
                
				<ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                    <li><a onClick="window.location.reload()" style="cursor: pointer;" id="title1">Media Archives</a></li>
                </ul>
                <div class="categorybox">
                <button id="category1" class="category">작품 추가</button>
                <button id="category2" class="category">제목 검색</button>
                <button id="category3" class="category">아이디 검색</button>
                <button id="category4" class="category">별점 검색</button>
                </div>
                    
                <p id="currentuser">${loginUser.user_id}님 환영합니다.</p>
                <button id="logoutbtn" onclick="location.href='logout.do'">로그아웃</button>
                
            </div>
        </div>
    </header>
    <div class="main">
        <div class="p-5 mb-4 bg-body-tertiary rounded-3">
            <div id= "topSection" class="container-fluid py-5">
                <h1 class="display-5 fw-bold">미디어 저장소</h1>
                <p class="col-md-8 fs-4">잊고싶지 않은 작품들 기록해두기!</p>
                <!-- <button id="savebtn" type="button" class="btn btn-outline-light">기록하기</button> -->
            </div>
        </div>
    </div>

    <div class="mybox" id="insertbox">
    	<div class="form-floating mb-3">
            <input type="text" class="form-control" id="title" placeholder="제목">
            <label for="floatingInput">제목</label>
        </div>
        <div class="form-floating mb-3">
			<a id="picmessage">사진 선택: <input id="image" type="file" name="image"></a>
        </div>
        <div class="form-floating mb-3">
            <input type="text" class="form-control" id="type" placeholder="미디어종류">
            <label for="floatingInput">미디어종류</label>
        </div>
        <div class="input-group mb-3">
            <label class="input-group-text" for="inputGroupSelect01">별점</label>
            <select class="form-select" id="star">
                <option selected>별점 선택</option>
                <option value="1">⭐</option>
                <option value="2">⭐⭐</option>
                <option value="3">⭐⭐⭐</option>
                <option value="4">⭐⭐⭐⭐</option>
                <option value="5">⭐⭐⭐⭐⭐</option>
            </select>
        </div>
        <div class="form-floating mb-3">
            <input type="text" class="form-control" id="comment" placeholder="코멘트">
            <label for="floatingInput">코멘트</label>
        </div>
        <button id="postingbtn" type="button" class="btn btn-danger">저장</button>
        <button id="postingclose" type="button" class="btn btn-secondary">닫기</button>
    </div>
    
    <div class="mybox" id="selectbox">
        <div class="form-floating mb-3">
            <input type="text" class="form-control" id="titleselect" placeholder="제목(해당 문자 포함)">
            <label for="floatingInput">제목(해당 문자 포함)</label>
        </div>
        <button id="selectbtn" type="button" class="btn btn-danger">조회</button>
        <button id="selectclose" type="button" class="btn btn-secondary">닫기</button>
    </div>
    
    <div class="mybox" id="idselectbox">
        <div class="form-floating mb-3">
            <input type="text" class="form-control" id="idselect" placeholder="사용자 아이디">
            <label for="floatingInput">사용자 아이디</label>
        </div>
        <button id="idselectbtn" type="button" class="btn btn-danger">조회</button>
        <button id="idselectclose" type="button" class="btn btn-secondary">닫기</button>
    </div>
    
    <div class="mybox" id="scoreselectbox">
        <div class="input-group mb-3">
            <label class="input-group-text" for="inputGroupSelect01">별점</label>
            <select class="form-select" id="scoreselect">
                <option selected value="0">별점 선택</option>
                <option value="1">⭐</option>
                <option value="2">⭐⭐</option>
                <option value="3">⭐⭐⭐</option>
                <option value="4">⭐⭐⭐⭐</option>
                <option value="5">⭐⭐⭐⭐⭐</option>
            </select>
        </div>
        <button id="scoreselectbtn" type="button" class="btn btn-danger">조회</button>
        <button id="scoreselectclose" type="button" class="btn btn-secondary">닫기</button>
    </div>
    
    <div class="mybox" id="modifybox">
    	<div class="form-floating mb-3">
            <input type="text" class="form-control" id="title_ex" placeholder="수정하려는 미디어의 제목" disabled="disabled">
            <label for="floatingInput"></label>
        </div>
        <div class="form-floating mb-3">
            <input type="text" class="form-control" id="title_m" placeholder="제목">
            <label for="floatingInput">제목</label>
        </div>
        <div class="form-floating mb-3">
			<a id="picmessage">사진 선택: <input id="image_m" type="file" name="image"></a>
        </div>
        <div class="form-floating mb-3">
            <input type="text" class="form-control" id="type_m" placeholder="미디어종류">
            <label for="floatingInput">미디어종류</label>
        </div>
        <div class="input-group mb-3">
            <label class="input-group-text" for="inputGroupSelect01">별점</label>
            <select class="form-select" id="star_m">
                <option selected>별점 선택</option>
                <option value="1">⭐</option>
                <option value="2">⭐⭐</option>
                <option value="3">⭐⭐⭐</option>
                <option value="4">⭐⭐⭐⭐</option>
                <option value="5">⭐⭐⭐⭐⭐</option>
            </select>
        </div>
        <div class="form-floating mb-3">
            <input type="text" class="form-control" id="comment_m" placeholder="코멘트">
            <label for="floatingInput">코멘트</label>
        </div>
        <button id="modify" type="button" class="btn btn-primary">수정</button>
        <button id="modifyclose" type="button" class="btn btn-secondary">닫기</button>
    </div>

    <div class="mycards">
        <div id="card" class="row row-cols-1 row-cols-md-4 g-4">
        <c:forEach items="${all}" var="card">
	        <div class="col">
	                <div class="card h-100">
	                	<div class="cardImgArea">
	                		
		                    <img id="imgheight" src="./images/${card.getImages()}"
		                        class="card-img-top card-img-width" alt="${card.getImages()}">
	                    </div>
	                    <div class="card-body">
	                    	<h5 class="card-score_m" hidden="">${card.getScore()}</h5>
	                    	<h5 class="card-comment_m" hidden="">${card.getComments()}</h5>
	                        <h5 class="card-title">${card.getName()}</h5>
	                        <h5 class="card-type_m">${card.getTypes()}</h5>
	                        올린사람: <input class="carduser" disabled="disabled" value="${card.user_id}">
	                        	<p class="card-text">
	                        	<c:forEach begin="1" end="${card.getScore()}">
	                        		⭐
	                        	</c:forEach>
	                        	</p>
	                        <p class="card-text">${card.getComments()}</p>
	                        <p class="card-date_m">${card.getSave()}</p>
	                        <button class="modifybtn btn btn-primary <c:if test="${loginUser.user_id != card.user_id}">disableBtn</c:if>" type="button" <c:if test="${loginUser.user_id != card.user_id}">disabled</c:if>>수정</button>
	                        <button class="deletebtn btn btn-danger" <c:if test="${loginUser.user_id != card.user_id}">disableBtn</c:if>" type="button" <c:if test="${loginUser.user_id != card.user_id}">disabled</c:if>>삭제</button>
	                    </div>
	                </div>
	            </div>
            </c:forEach>
        </div>
    </div>
</body>
</html>