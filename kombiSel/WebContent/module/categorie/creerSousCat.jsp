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
			
			<form action="<c:url value="/creersouscat"/> " method="post" >
				<p class="${empty souscat ? 'alert alert-success':'alert alert-danger' }" ><span class="glyphicon glyphicon-alert"></span> <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>${souscat}</p>
				
				<div class="form-group">
					<label for="nomcat">Nom(s)Catégorie<span class="oblig">*</span></label>
					<select name="choix" class="form-control">
						<c:if test="${!empty listecategorie}">
							<c:forEach items="${listecategorie}" var="catego">
							<option value="<c:out value="${catego.idCategorie}"/>" >
								<c:out value="${catego.nomCategorie}"/>
							</option>
							</c:forEach>
						</c:if>
					</select>
				</div>
				
				<div class="form-group">
					<label class="nomsouscat">Nom Sous Catégorie</label>
					
					<input type="text" class="form-control" name="nomsouscat" placeholder="nom(s) sous categorie"/><span class="erreur"></span>
				</div>
				
				<div class="form-group">
					<input type="submit" value="créer"  class="btn btn-info"/>
				</div>
			</form>
		</div>		
	</div>
</div>		
	<c:import url="/template/footer.jsp"></c:import>
<script type="text/javascript" src="<c:url value="/scriptjs/jquery.js" />"></script>
<script type="text/javascript" src="<c:url value="/bootstrap/js/bootstrap.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/scriptjs/kscript.js"/> "></script>
</body>
</html>