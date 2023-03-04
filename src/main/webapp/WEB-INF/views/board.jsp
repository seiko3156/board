<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <title>직원 목록</title>
        <link rel="stylesheet" href="css/style.css">
        <script src="js/script.js" type="text/javascript"></script> 
    </head>
    <body>
    				
        <div class="board_list_wrap">
            <table class="board_list">
                <h2>직원목록</h2>
                <thead>
                    <tr>
                        <th>직원번호</th>
                        <th>이름</th>
                        <th>전화번호</th>
                        <th>직급</th>
                        <th>이메일</th>
                        <th>삭제</th>
                        <th>수정</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                    <c:forEach items="${boardList}" var="list" varStatus="status">
                        <td>${list.num}</td>
                        <td>${list.name}</td>
                        <td>${list.phone}</td>
                        <td>${list.position}</td>
                        <td>${list.email}</td>
                        <td><input type="button" value="삭제" onclick="deletelist('${boardnum[status.index].num}')"></td>
                        <td><input type="button" value="수정" onclick="updatelist('${boardnum[status.index].num}')"></td>
                    </tr>                   
                     </c:forEach>   
                </tbody>
            </table>
            <form name="frm" method="post">
						<table class="board_list">
							<tr><td>검색 
								<input type="text" name="key" value="${key}" > 
								    <input type="button" value="검색"   onClick="go_search('/');">
								    <input type="button" name="btn_total" value="전체보기 "  onClick="go_total('/');">
							    </td></tr>
						</table>
					</form>
        <div><input type="button" value="회원입력" onclick="location.href='writeForm'"></div>
        </div>
    </body>
</html>