<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${list != null}">
<c:forEach items="${list}" var="card">
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
	                        <button class="modifybtn btn btn-primary <c:if test="${loginUser.user_id != card.user_id}">disableBtn</c:if>" type="button" <c:if test="${loginUser.user_id != card.user_id}">disabled</c:if>>수정</button>
	                        <button class="deletebtn btn btn-danger" <c:if test="${loginUser.user_id != card.user_id}">disableBtn</c:if>" type="button" <c:if test="${loginUser.user_id != card.user_id}">disabled</c:if>>삭제</button>
	                    </div>
	                </div>
	            </div>
</c:forEach>
</c:if>