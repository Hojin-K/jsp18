<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="customer.vo.Notice"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script>
 function clearVal(){
	 var inputVal=document.getElementByID("q");
	 inputVal.value='';	 
 }
</script>
</head>
<body>
<h3>Notice.jsp</h3>

<c:if test="${empty sessionScope.uid }"> <!-- session에  uid가 없을때 빈값일때-->
	<a href="../login/login.do">login</a> 
</c:if>
|
<c:if test="${not empty sessionScope.uid }"> <!-- session에  uid가 있을때-->
	<a href="../login/logoutProc.do">logout</a>
</c:if>
<br />
<c:if test="${not empty uid }"> <!-- 비어있지 않느냐? -->
${uid }님 반갑습니다.
</c:if>

<br />
<hr />
<!-- 로그인을 누르면 마이 디스패쳐로 감. 거기서 로그인 컨트롤러로 이동해서 execute로 이동 그래서 loginForm으로 이동해서
아이디와 패스워드 입력 후 로그인 버튼을 누르면 로그인 proc로 간다. 그럼 디스패쳐를 다시 통해 로그인 proc컨트롤러로 가서 
멤버 dao의 m을 가져감. 그리고 멤버dao로 가서 getmember에서 sql을 실행해서 리절트셋으로 받아 멤버에 담고 m으로 간다
그리고 프락컨트롤러에서 Member m에 담는다. -->

<form action="notice.do" method="get">
	<select name="f">
		<option ${param.f=="title"?"selected":"" } value="title">제목</option>
		<option ${param.f=="content"?"selected":"" }  value="content">내용</option>			
	</select>
	<input type="text" name="q" value="${query }"/>
	<input type="submit" value="검색 " />
</form>

<table width="500" border="1">
	<tr>
		<td>번호</td>
		<td>제목</td>
		<td>작성자</td>
		<td>작성일</td>
		<td>조회수</td>
	</tr>

<c:forEach items="${list }" var="n"> 
<!-- NoticeController의 "list"이다. 그 데이터 한개를 뽑아서 넣은것이 "n"이다.-->
	<tr>
		<td>${n.seq }</td>
		<td><a href="noticeDetail.do?c=${n.seq }&h=${n.hit }">${n.title }</a></td>
		<!-- 조회수 hit을 h로 받기 위해 & 뒤에 추가 해줌  여기를 누르면 디테일 페이지로 감. & 이건 여러개 표현 가능
		이 방법 외에도 sql 디비에서 값을 가져와서 표현 해도 된다.-->
		<td>${n.writer }</td>
		<td>${n.regdate }</td>
		<td>${n.hit }</td>
	</tr>
</c:forEach>

</table>

<c:if test="${not empty sessionScope.uid }"> <!-- session에  uid가 있을때만 표현해라-->
	<a href="noticeReg.do">write</a> 
</c:if>


</body>
</html>
