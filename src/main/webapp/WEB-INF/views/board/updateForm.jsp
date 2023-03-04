<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <title>직원 목록 수정</title>
        <link rel="stylesheet" href="css/style.css">
        <script src="js/script.js" type="text/javascript"></script> 
    </head>
    <body>
        <div class="board_form_wrap">
            <form action="update" method="post" name="updateForm">  
            <input type="hidden" name="num" value="${boardnum}">
            <h2>직원목록 수정</h2><br>
            <div class="boardForm"><br>                
                       <div><label for="name">이름:</label><br>
                         <input type="text" id="name" name="name" value="${boardList.name}"></div>
                       <div><label for="phone">전화번호:</label><br>
                         <input type="text" id="phone" name="phone" value="${boardList.phone}"></div>
                       <div><label for="position">직급:</label><br>
                         <input type="text" id="position" name="position" value="${boardList.position}"></div>
                       <div><label for="email">이메일:</label><br>
                         <input type="email" id="email" name="email" value="${boardList.email}"></div>     
            </div><br>
            <div><input type="button" value="등록" onclick="updateAction()"></div> 
            <p id="checkBrnMessage">${message}</p>   
            </form>
        </div>
    </body>
</html>