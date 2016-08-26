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
<link rel="stylesheet" type="text/css" href="<c:url value="/style/design.css"/>" />
</head>
<body>
<c:import url="/importFile/enteteAfter.jsp"/>
<div class="container">
	<div class="row">
		<div class="span8">
			<form action="<c:url value="/addcategorie"/> " method="post">
				<p class="${empty form ? 'alert alert-success':'alert alert-danger' }" ><span class="glyphicon glyphicon-alert"></span> <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>${form.resultat}</p>
				<div class="form-group">
					<label for="nomcat">Nom Catégorie</label>
					<input type="text" name="nomcat" class="form-control" value="<c:out value="${cat.nomCategorie }" /> "/><span class="erreur">${ form.erreur['nomcat'] }</span>
				</div>
				<div class="controls">
					<input type="submit" value="Ajouter" class="envo btn btn-success" />
				</div>
			</form>
		
		</div>
		<div class="span2">
			<c:import url="/importFile/menuDroite.jsp"/>
		</div>
		
	</div>
		
	<c:import url="/template/footer.jsp"></c:import>

</div>
	
	<script type="text/javascript" src="<c:url value="/scriptjs/jquery.js" />"></script>
	<script type="text/javascript" src="<c:url value="/bootstrap/js/bootstrap.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/scriptjs/kscript.js"/> "></script>
</body>
</html>