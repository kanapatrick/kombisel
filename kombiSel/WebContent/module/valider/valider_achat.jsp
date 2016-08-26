<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/> 
<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
<link rel="stylesheet" type="text/css" href="<c:url value="/bootstrap/css/bootstrap.css"/>" />
<link rel="stylesheet" type="text/css" href="<c:url value="/bootstrap/css/bootstrap-responsive.css"/>" />
<link rel="stylesheet" type="text/css" href="<c:url value="/style/designkomacc.css"/>" /> 
<link rel="stylesheet" type="text/css" media="screen" href="<c:url value="/style/designdoc.css" />" />
<title>Bienvenue sur KombiSell plateforme  e-commerce</title>
<body>
	<div class="rapport">
		<c:out value="${rapport}" />
	</div>
	<c:import url="/template/enteteAcc.jsp"/>
	<div id="validation_achat">
		<c:if test="${!empty sessionScope.listeAchat && sessionScope.listeAchat != null }">
		<div id="validation">
		<form method="post" action="<c:url value="/modPanier"> <c:param name="action" value="commander" /> </c:url>" >
			<table  style="textalign:center"  class="table table-hover">
				<tr>
					<td><c:out value="Article" /></td>
					<td><c:out value="Nom" /></td>
					<td><c:out value="Description" /></td>
					<td><c:out value="Quantité" /></td>
					<td><c:out value="Prix" /></td>					
				</tr>
				<c:forEach var="article" items="${sessionScope.selectedArticle}">
					<tr>
						<td>
							<img src="<c:url value="${article.imageArticle}" />" height="100" width="100">
							<span><input class="btn-success" type="button" style="font-size: 8px; text-decoration:none;" class="remove_article" onclick="remove(${achat.idArticle});" value=<c:out value="Enlever" /> ></span>
						</td>
						<td><c:out value="${article.nomArticle}" /></td>
						<td><c:out value="${article.description}" /></td>
						<td>							
							<input type="number" class="form-control" onkeyup="incrementer(${article.idArticle});" onclick="incrementer(${article.idArticle});" name="${article.idArticle}" value="${sessionScope.listeAchat.get(article)}" max="${article.quantite}" min="1">														
						</td>
						<td><c:out value="${article.prix*sessionScope.listeAchat.get(article)}" /></td>					
					</tr>
				</c:forEach>
			</table>
			<table>
				<c:forEach var="art_promo" items="${sessionScope.selectedPromo}">
					<tr>
						<td>
							<img src="<c:url value="${art_promo.article.imageArticle}" />" height="100" width="100">
							<button class="btn btn-info" onclick="remove(${art_promo.article.idArticle});" ><c:out value="Enlever" /></button>
						</td>
						<td><c:out value="${art_promo.article.nomArticle}" /></td>
						<td><c:out value="${art_promo.article.description}" /></td>
						<td>							
							<!--  <select name="qte_art">
								<c:forEach var="nb_promo" items="${art_promo.quantitePromotion}">
									<option><c:out value="${nb_promo}" /></option>
								</c:forEach>
								
							</select>  -->
							<input type="number" onkeyup="incrementer(${art_promo.article.idArticle});" onclick="incrementer(${art_promo.article.idArticle});" name="${art_promo.article.idArticle}" value="${sessionScope.listeAchat.get(art_promo.article)}" max="${art_promo.quantitePromotion}" min="1"> 														
						</td>
						<td><c:out value="${sessionScope.listeAchat.get(art_promo.article)*(art_promo.article.prix - ( (art_promo.promotion.reduction/100)*art_promo.article.prix))}" /></td>					
					</tr>
				</c:forEach>
			</table>
			<button class="btn btn-primary" type="submit" ><c:out value="Commander"/> </button>
		</form>	
	</div>
		</c:if>
	</div>
	
	<c:import url="/template/footer.jsp" />	
		<script type="text/javascript" src="<c:url value="/scriptjs/jquery.js" />"></script>
		<script type="text/javascript" src="<c:url value="/bootstrap/js/bootstrap.min.js"/>"></script>
		<script type="text/javascript" src="<c:url value="/scriptjs/jssor.js" />"></script>
		<script type="text/javascript" src="<c:url value="/scriptjs/jssor.slider.js" />" ></script>
		<script type="text/javascript" src="<c:url value="/scriptjs/chrono.js" />" ></script>
		<script type="text/javascript" src="<c:url value="/scriptjs/panierScript.js"/> "></script>
</body>
</html>