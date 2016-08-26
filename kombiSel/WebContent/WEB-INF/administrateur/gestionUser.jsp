<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
		<div class="col-xs-12 col-md-12 col-lg-12">
			
				<ul class="nav nav-tabs" role="tablist">
					<li role="presentation" class="active"><a href="#inscrit" data-toggle="tab" role="tab" aria-controls="Categorie">Inscrit(s)</a></li>
					<li role="presentation"><a href="#moderateur" data-toggle="tab" role="tab" aria-controls="sous categorie" >Moderateur(s)</a></li>
				</ul>
				
				
		<div class="tab-content">
			<div></div>
	
			<div role="tabpanel" class="tab-pane active" id="categorie">
				
				<form action="" method="get" class="form-search navbar-forme" role="search" >
						<div class="input-group form-group">
						    <input name="rechercheuse" class="form-control" type="search"  placeholder="Recherchez une use.....">
						 	 <span class="input-group-btn">
			    				<button class="btn btn-success" type="submit"><span class="glyphicon glyphicon-search"></span></button>
			   				</span>
						</div>
				</form>
			
				<div>
					<a href="<c:url value="#" /> "  class="btn btn-success" >Ajouter Utilisateur</a>
					<a href="#"class="btn btn-success">tout cochez</a>
				</div>
				<form action="<c:url value="#" /> " method="get">
					<button class="pull-right btn btn-success modif" >Modifier user</button>
					<input type="hidden" name="choix" value="modif"/>
					<button class="pull-right btn btn-success supri" >supprimer user</button>
					<input type="hidden" name="choix" value="supri" />
				<table class="table table-bordered table-striped table-condensed">
					<caption>Listes des Utilisateur(s)</caption>
					<thead>
						<tr>
							<th>Nom(s)</th>
							<th>Prenom(s)</th>
							<th>Email</th>
							<th>Adresse</th>
							<th>Téléphone</th>
							<th> choix </th>
						</tr>
					</thead>
					
					<tbody>
					
						<c:choose >
							<c:when test="${!empty inscrit}">
								<c:forEach items="${inscrit}" var="inscrit">
									<tr>
										<td><c:out value="${inscrit.nomUser}" /></td>
										<td><c:out value="${inscrit.prenomUser}"></c:out></td>
										<td><c:out value="${inscrit.emailUser }"></c:out></td>
										<td><c:out value="${inscrit.addresse }"></c:out></td>
										<td><c:out value="${inscrit.telephoneUser}"></c:out></td>
										<td><input  type="checkbox"  name="categorie" value="${inscrit.idUser}" ></td>													
									
									</tr>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<ul class="list-unstyled" style="text-align:center">
									<li>Aucune Utilisateurs</li>
								</ul>
							</c:otherwise>
						</c:choose>
					</tbody>
				</table>
			</form>
			</div>
							
			<div class="tab-pane" id="moderateur">
				<div></div>
				<form action="" method="get" class="form-search navbar-forme" role="search" >
						<div class="input-group form-group">
						    <input name="recherchemod" class="form-control" type="search"  placeholder="Recherchez un moderateur.....">
						 	 <span class="input-group-btn">
			    				<button class="btn btn-success" type="submit"><span class="glyphicon glyphicon-search"></span></button>
			   				</span>
						</div>
				</form>
				<div>
					<a href="<c:url value="#"> <c:param name="action" value="creercat" /></c:url> " class="btn btn-success" >Desactiver</a>
					<a href="#"class="btn btn-success">tout cochez</a>
				</div>
				<form action="<c:url value="#" /> " method="get">
					<button class="pull-right btn btn-success modif" >Modifier categorie</button>
					<input type="hidden" name="choix" value="modif"/>
					<button class="pull-right btn btn-success supri" >supprimer catégorie</button>
					<input type="hidden" name="choix" value="supri" />
				<table class="table table-bordered table-striped table-condensed">
					<caption>Listes des Utilisateur(s)</caption>
					<thead>
						<tr>
							<th>Nom(s)</th>
							<th>Prenom(s)</th>
							<th>Email</th>
							<th>Adresse</th>
							<th>Téléphone</th>
							<th> choix </th>
						</tr>
					</thead>
					
					<tbody>
					
						<c:choose >
							<c:when test="${!empty moderateur}">
								<c:forEach items="${moderateur}" var="mode">
									<tr>
										<td><c:out value="${mode.nomUser}" /></td>
										<td><c:out value="${mode.prenomUser}"></c:out></td>
										<td><c:out value="${mode.emailUser }"></c:out></td>
										<td><c:out value="${mode.addresse }"></c:out></td>
										<td><c:out value="${mode.telephoneUser}"></c:out></td>
										<td><input  type="checkbox"  name="categorie" value="${mode.idUser}" ></td>													
									
									</tr>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<ul class="list-unstyled" style="text-align:center">
									<li>Aucune Utilisateurs</li>
								</ul>
							</c:otherwise>
						</c:choose>
					</tbody>
				</table>
			</form>
			</div>
		</div>
	</div>
   </div>
</div>
<c:import url="/template/footer.jsp"></c:import>
<script type="text/javascript" src="<c:url value="/scriptjs/jquery.js" />"></script>
<script type="text/javascript" src="<c:url value="/bootstrap/js/bootstrap.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/scriptjs/kscript.js"/> "></script>
</body>
</html>