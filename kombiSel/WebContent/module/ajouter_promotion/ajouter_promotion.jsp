<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
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

<div class="container-fluid">
	
	<c:import url="/importFile/enteteAfter.jsp" />
	
		<div class="row-fluid">
		
			
			<div class="span8">		
				
				
				<form method="post" action="<c:url value="/modPromotion"><c:param name="action" value="ajouter_promotion" /></c:url>" class="form-horizontal">
					<p class="${empty rapport ? 'succes':'erreur' }">${rapport}</p>					
						
						<label class="control-label" for="promotion">Promotion<span class="oblig">*</span> </label>
							<div class="controls">
							<select name="promotion">		
									<option><c:out value="Selectionner une Promotion" /></option>																				
									<c:if test="${!empty promotion}">									
										<c:forEach var="promo" items="${promotion}">										
											<option value="${promo.idProduitPromotion}"><c:out value="reduction de ${promo.reduction}%"></c:out></option>											
										</c:forEach>											
									</c:if>								
							</select>
							</div>
						
						<label class="control-label" for="categorie">Catégorie<span class="oblig">*</span> </label>
							<div class="controls">
							<select name="categorie">		
									<option><c:out value="Selectionner une catégorie" /></option>																				
									<c:if test="${!empty categorie}">									
										<c:forEach var="cat" items="${categorie}">										
											<option onclick="getSousCatPromotion(${cat.idCategorie});" value="${cat.idCategorie}"><c:out value="${cat.nomCategorie}"></c:out></option>											
										</c:forEach>											
									</c:if>								
							</select>
							</div>
							
							<div class="control-group">
							<label class="control-label" for="categorie">Sous catégorie<span class="oblig">*</span> </label>
							<div id="sous_catPromotion">
							<select name="sous_categorie">	
									<option><c:out value="Selectionner une Sous catégorie" /></option>													
									<c:if test="${!empty sousCategorie}">									
										<c:forEach var="cat" items="${sousCategorie}">										
											<option  onclick="getArticle(${cat.idSousCategorie});" value="${cat.idSousCategorie}"><c:out value="${cat.nomSousCategorie}"></c:out></option>											
										</c:forEach>											
									</c:if>								
							</select>
							</div>
							
							<div class="control-group">
							<label class="control-label" for="categorie">Article<span class="oblig">*</span> </label>
							<div id="promotioned_article">		
							<select name="article">	
								<option><c:out value="Selectionner un Article" /></option>																																							
								<c:if test="${!empty articles}">									
									<c:forEach var="art" items="${articles}">										
										<option value="${art.idArticle}"><c:out value="${art.nomArticle}"></c:out></option>											
									</c:forEach>											
								</c:if>
							</select>	
																					
							</div><span class="erreur">${verif.erreurs["article"]}</span><br/>							
						
						</div>
						<label class="control-label" for="quantite">Quantité<span class="oblig">*</span> </label>
						<input type="number" name="quantite" min="1">
					</div>
					
					<div class="control-group">
						<div class="controls">
							<button type="submit" class="btn btn-success ">Ajouter<i class="icon-white icon-ok-sign"></i></button><span class="${ !empty rapport ? 'succes':'erreur' }">${verif.resultat}</span>
						</div>
				</div>
				</form>	
				
			</div>		
		</div>
		
	<c:import url="/template/footer.jsp" />
	
</div>
	<script type="text/javascript" src="<c:url value="/scriptjs/jquery.js" />"></script>
	<script type="text/javascript" src="<c:url value="/module/ajouter_promotion/script/ajax.js" />"></script>
	<script type="text/javascript" src="<c:url value="/bootstrap/js/bootstrap.min.js"/>"></script>
</body>
</html>