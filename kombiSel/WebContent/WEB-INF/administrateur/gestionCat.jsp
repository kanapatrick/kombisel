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
	<c:set var="listeCate" value="${requestScope.listeCategorie }" />

<c:import url="/importFile/enteteAfter.jsp"/>
<div class="container">	
	<div class="row">
		<div class="col-xs-12 col-md-12 col-lg-12">
			
				<ul class="nav nav-tabs" role="tablist">
					<li role="presentation" class="active"><a href="#categorie" data-toggle="tab" role="tab" aria-controls="Categorie">Catégories</a></li>
					<li role="presentation"><a href="#souscategorie" data-toggle="tab" role="tab" aria-controls="sous categorie" >Sous Catégories</a></li>
				</ul>
				
				
		<div class="tab-content">
			<div></div>
	
			<div role="tabpanel" class="tab-pane active" id="categorie">
				
				<form action="" method="get" class="form-search navbar-forme" role="search" >
						<div class="input-group form-group">
						    <input name="recherchecat" class="form-control" type="search"  placeholder="Recherchez une categorie.....">
						 	 <span class="input-group-btn">
			    				<button class="btn btn-success" type="submit"><span class="glyphicon glyphicon-search"></span></button>
			   				</span>
						</div>
				</form>
			
				<div>
					<a href="<c:url value="/addcategorie" /> "   class="btn btn-success" >Ajouter catégorie</a>
					<a href="#"class="btn btn-success">tout cochez</a>
				</div>
				<form action="<c:url value="/modifiercategorie" /> " method="get">
					<button class="pull-right btn btn-success modif" >Modifier categorie</button>
					<input type="hidden" name="choix" value="modif"/>
					<button class="pull-right btn btn-success supri" >supprimer catégorie</button>
					<input type="hidden" name="choix" value="supri" />
				<table class="table table-bordered table-striped table-condensed">
					<caption>Listes des Catégories</caption>
					<thead>
						<tr>
							<th>Nom(s) Catégorie(s)</th>
							<th> choix </th>
						</tr>
					</thead>
					
					<tbody>
					
						<c:choose >
							<c:when test="${!empty listeCategorie}">
								<c:forEach items="${listeCategorie}" var="listeCate">
									<tr>
										<td><c:out value="${listeCate.nomCategorie}" /></td>
										<td><input  type="checkbox"  name="categorie" value="${listeCate.idCategorie}" ></td>													
									
									</tr>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<tr><td>Aucune Catégorie existante</td><td></td></tr>
							</c:otherwise>
						</c:choose>
					</tbody>
				</table>
			</form>
			</div>
							
			<div class="tab-pane" id="souscategorie">
				<div></div>
				<form action="" method="get" class="form-search navbar-forme" role="search" >
						<div class="input-group form-group">
						    <input name="recherchesouscat" class="form-control" type="search"  placeholder="Recherchez une sous categorie.....">
						 	 <span class="input-group-btn">
			    				<button class="btn btn-success" type="submit"><span class="glyphicon glyphicon-search"></span></button>
			   				</span>
						</div>
				</form>
				<div>
					<a href="<c:url value="/creersouscat"> <c:param name="action" value="creercat" /></c:url> " class="btn btn-success" >Ajouter sous catégorie</a>
					<a href="<c:url value="/supprimesouscatego"> <c:param name="idCategorie" value="${cat.idSousCategorie }" /></c:url>" class="btn btn-success" >supprimer sous catégorie</a>
					<a href="<c:url value="/modifiersouscatego"> <c:param name="idCategorie" value="${cat.idSousCategorie }" /></c:url>" class="btn btn-success" >modifier sous catégorie</a>
				
					<a href="#"class="btn btn-success">tout cochez</a>
				</div>
				<div class="row">
					<h4 style="text-align:center">Listes des Sous Catégories</h4>
					
					<c:choose >
					<c:when test="${!empty souscategorie && !empty listeCategorie }">
						<c:forEach items="${listeCategorie}" var="cate">
								<div class="col-lg-6 col-md-6 col-xs-12 col-sm-12">
										<div class="panel panel-green">
											<div class="panel-heading" style="font-size:17px;"><c:out value="${cate.nomCategorie}" /></div>
								
												<div class="panel-body">
													<table class="table table-bordered table-striped table-condensed">
														<thead style="font-size:14px">
															<tr>
																<th>Nom(s) Sous Categorie</th>
																<th>Choix</th>
															</tr>
														</thead>
														<tbody>
															<c:forEach items="${souscategorie.get(cate) }" var="souscat">
																<tr>
																	<td><c:out value="${souscat.nomSousCategorie}" /></td>
																	<td><input type="checkbox" name="choix" value="${souscat.idSousCategorie }"></td>
																</tr>
															</c:forEach>
														</tbody>
													</table>
												</div>
										</div>
								</div>
						</c:forEach>
					</c:when>
				</c:choose>		
			</div>
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