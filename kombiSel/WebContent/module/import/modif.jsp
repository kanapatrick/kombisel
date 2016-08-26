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
<link rel="stylesheet" type="text/css" href="<c:url value="/style/design.css"/>" />\
<title>Ajouter un Article</title>
</head>
<body>
<div class="container-fluid">	
	<c:import url="/importFile/enteteAfter.jsp" />
	
	<section class="row-fluid">
		
		<section class="col-md-4 col-md-push-1">
			
			<form method="post" action="<c:url value="/ajouterarticle" />" enctype="multipart/form-data" class="form-horizontal">
					<p class="${empty rapport ? 'succes':'erreur' }">${rapport}</p>
					<c:if test="${!empty art }">
						<div class="form-group">
							<label for="nom" >Nom de l'article<span class="oblig">*</span></label>
							<input type="text" name="nom" class="form-control input_import" placeholder="titre" value="${art.nomArticle}" required/><br/><span class="erreur">${verif.erreurs["nom"]}</span><br/>
						</div>
						<div class="form-group">
							<label for="description" >Description de l'article<span class="oblig">*</span></label>
							<textarea name="description"  placeholder="Description" value="${art.description}" required class="form-control"></textarea><br/><span class="erreur">${verif.erreurs["description"]}</span><br/>
						</div>
						<div class="form-group">
							<label for="qte">Quantité<span class="oblig">*</span></label>
							<input type="number" min="1" name="qte"  placeholder="Quantité d'article" value="${art.quantite}" required class="form-control"/><br/><span class="erreur">${verif.erreurs["quantite"]}</span><br/>
						</div>
						<div class="form-group">
							<label for="prix" >Prix unitaire<span class="oblig">*</span></label>
							<div class="input-append">
							<input type="tel" name="prix"  placeholder="prix d'un article"  class="form-control input-small"  style="text-align:right" value="${art.prix}" required /><span class="add-on">Fcfa</span><br/><span class="erreur">${verif.erreurs["prix"]}</span><br><br>
							</div>
						</div>	
						<div class="form-group">
							<label for="image" >Image de l'article<span class="oblig">*</span></label>
							<input type="file" name="image"  placeholder="Emplacement de l'image" value="${art.imageArticle}" required  class="form-control"/><br/><span class="erreur">${verif.erreurs["image"]}</span><br/>
						</div>
						
						<div class="form-group">
							<label class="control-label" for="categorie">Catégorie<span class="oblig">*</span> </label>
							<div class="form-group">
							<select name="categorie">	
																						
									<c:if test="${!empty categorie}">									
										<c:forEach var="cat" items="${categorie}">										
											<option onclick="getSousCat(${cat.idCategorie});" value="${cat.idCategorie}"><c:out value="${cat.nomCategorie}"></c:out></option>											
										</c:forEach>											
									</c:if>								
							</select>
							</div>
							
							<div class="form-group">
							<label class="control-label" for="categorie">Sous catégorie<span class="oblig">*</span> </label>
							<div id="sous_catAjouter">
							<select name="sous_categorie">														
									<c:if test="${!empty sousCate}">									
										<c:forEach var="cat" items="${sousCate}">										
											<option  value="${cat.idSousCategorie}"><c:out value="${cat.nomSousCategorie}"></c:out></option>											
										</c:forEach>											
									</c:if>								
							</select>
							</div>
							
							<span class="erreur">${verif.erreurs["categorie"]}</span><br/>
						</div>
						<div class="form-group">
							<button type="submit" class="btn btn-success ">Modifier<i class="icon-white icon-ok-sign"></i></button><span class="${ !empty rapport ? 'succes':'erreur' }">${verif.resultat}</span>
						</div>
					</div>
					</c:if>
				</form>	
			
		</section>
		
		<section class="col-md-8 col-md-push-1">
		
			<div class="row-fluid">
			
				<div class="col-md-6">
					ici nous avons la premier promo
				</div>
				
				<div class="col-md-6">
					ici nous avons la promo 2
				</div>
				
			</div>
			
		</section>
		
	</section>
</div>
		
	<c:import url="/template/footer.jsp" />

	<script type="text/javascript" src="<c:url value="/scriptjs/jquery.js" />"></script>
	<script type="text/javascript" src="<c:url value="/scriptjs/panierScript.js" />"></script>
	<script type="text/javascript" src="<c:url value="/bootstrap/js/bootstrap.min.js"/>"></script>
</body>
</html>