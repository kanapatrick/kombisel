<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE >
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/> 
<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
<link rel="stylesheet" type="text/css" href="<c:url value="/bootstrap/css/bootstrap.css"/>" />
<link rel="stylesheet" type="text/css" href="<c:url value="/bootstrap/css/bootstrap-responsive.css"/>" />
<link rel="stylesheet" type="text/css" href="<c:url value="/style/designkom.css"/>" />
<link rel="stylesheet" type="text/css" href="<c:url value="/style/overview.css"/>" /> 
<title>Bienvenue dans votre Espace KombiSel</title>

</head>
<body>
	<div class="container-fluid">
	<c:import url="/importFile/enteteAfter.jsp"/>
	<c:import url="/importFile/containAfter.jsp"/>	
	<c:choose>
	<c:when test="${ sessionScope.user.groupe.idGroupe == 4 }">
	<c:import url="/template/footer.jsp"></c:import>
	</c:when>
	</c:choose>
	</div>
	<script type="text/javascript" src="<c:url value="/scriptjs/jquery.js" />"></script>
	<script type="text/javascript" src="<c:url value="/bootstrap/js/bootstrap.min.js"/>"></script>
	
</body>
</html>