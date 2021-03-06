<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />

<c:set var="contextRoot" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Online Shopping ${title}</title>

<script type="text/javascript">
	window.menu = '${title}';
	
	window.contextRoot = '${contextRoot}'
</script>

<!-- Bootstrap core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">

<!-- Bootstrap Readable theme -->
<link href="${css}/bootstrap-readable-theme.css" rel="stylesheet">

<!-- Bootstrap DataTables -->
<link href="${css}/dataTables.bootstrap4.css" rel="stylesheet">


<!-- Custom styles for this template -->
<link href="${css}/myapp.css" rel="stylesheet">

</head>

<body>

	<div class="wrapper">

		<!-- Navigation -->

		<%@include file="./shared/navbar.jsp"%>

		<!-- Page Content -->
		<!-- Loading the home content -->

		<div class="content">
			<c:if test="${userClickHome ==true}">
				<%@include file="home.jsp"%>
			</c:if>

			<!-- Load when user click contact -->
			<c:if test="${userClickContact ==true}">
				<%@include file="contact.jsp"%>
			</c:if>

			<!-- Load when user click about -->
			<c:if test="${userClickAbout ==true}">
				<%@include file="about.jsp"%>
			</c:if>

			<!-- Load when user click Category Products or All Products -->
			<c:if
				test="${userClickCategoryProducts ==true or userClickAllProducts==true}">
				<%@include file="listProducts.jsp"%>
			</c:if>
			
			
			<!-- Load when user click Show Product -->
			<c:if
				test="${userClickShowProduct ==true}">
				<%@include file="singleProduct.jsp"%>
			</c:if>
			
			<!-- Load when user click Manage Products -->
			<c:if
				test="${userClickManageProducts ==true}">
				<%@include file="manageProducts.jsp"%>
			</c:if>
			

		</div>

		<!-- Footer -->
		<%@include file="./shared/footer.jsp"%>

		<!-- jquery -->
		<script src="${js}/jquery.min.js"></script>
		
		<!-- jquery Validator -->
		<script src="${js}/jquery.validate.js"></script>
		

		<!-- Bootstrap core JavaScript -->
		<script src="${js}/bootstrap.bundle.min.js"></script>

		<!-- Data table Plugin -->
		<script src="${js}/jquery.dataTables.js"></script>

		<!-- Data table Bootstrap script -->
		<script src="${js}/dataTables.bootstrap4.js"></script>
		
		<!-- BootBox -->
		<script src="${js}/bootbox.min.js"></script>

		<!-- Self loaded js file -->
		<script src="${js}/myapp.js"></script>
	</div>
</body>

</html>