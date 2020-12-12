<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/view/user/template" var="url" />

<!DOCTYPE html>
<html>

<head>

<title>Error</title>
<meta charset="UTF-8">
<meta name="description" content="Fashi Template">
<meta name="keywords" content="Fashi, unica, creative, html">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link
	href="https://fonts.googleapis.com/css?family=Muli:300,400,500,600,700,800,900&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
<link rel="stylesheet" href="css/font-awesome.min.css" type="text/css">
<link rel="stylesheet" href="css/themify-icons.css" type="text/css">
<link rel="stylesheet" href="css/elegant-icons.css" type="text/css">
<link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css">
<link rel="stylesheet" href="css/nice-select.css" type="text/css">
<link rel="stylesheet" href="css/jquery-ui.min.css" type="text/css">
<link rel="stylesheet" href="css/slicknav.min.css" type="text/css">
<link rel="stylesheet" href="css/style.css" type="text/css">


<style type="text/css">
body {
	margin: 0;
	background-color: white;
}

#image {
	background-image: url("${pageContext.request.contextPath}/view/user/template/image/404_page_cover.jpg");
	background-size: cover;
	border-style: outset;
	border-width: 4px;
	border-color: cornsilk;
	margin-right: 10%;
	margin-left: 10%;
	margin-top: 5%;
	margin-bottom: 5%;
	margin-left: auto;
	margin-right: auto;
	height: 500px;
	width: 60%;
}

#Back {
	margin-left: 40%;
	padding-top: 450px;
}

#backButton {
	background-color: rgb(11, 134, 241);
	height: 30px;
	border-radius: 20px;
	color: white;
}

@media all and (max-width: 700px) {
	#image {
		max-width: max-content;
		margin-top: 5%;
		margin-bottom: 5%;
	}
}
</style>

</head>

<body>
	<jsp:include page="/view/user/template/header/header.jsp" flush="true" />

	<div id="image">
		<form id="Back">

			<button id="backButton">
				<a href="${pageContext.request.contextPath}/view/user/homepage">Come
					Back</a>
			</button>

		</form>
	</div>
	<jsp:include page="/view/user/template/footer/footer.jsp" flush="true" />
</body>

</html>