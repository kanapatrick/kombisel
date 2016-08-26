<img src="<c:url value="/template/panier.JPG"  />" id="image_panier" >
<span id="compteur"><c:out value="${sessionScope.listeAchat.size()}" /></span>
<div id="product_list">														
	<c:if test="${!empty sessionScope.listeAchat }">		
		<table>
			<tr>
				<td><c:out value="Nom" /></td>
				<td><c:out value="Quantité" /></td>
				<td><c:out value="Prix" /></td>
			</tr>
			<c:forEach var="achat" items="${sessionScope.selectedArticle}">
				<tr>
					<td>
						<img src="<c:out value="${achat.imageArticle}" />" width="50" height="50">
						<c:out value="${achat.nomArticle}" /><br>
						<button type="button" class="btn btn-info" onclick="remove(${achat.idArticle});"><c:out value="Enlever" /></button>
					</td>
					<td><c:out value="${sessionScope.listeAchat.get(achat)}" /></td>
					<td>				
						<c:out value="${sessionScope.listeAchat.get(achat)*achat.prix}" />								
					</td>									
				</tr>									
			</c:forEach>
			<c:out value="Produit en Promotion" />
			<c:forEach var="promo" items="${sessionScope.selectedPromo}">
				<tr>
					<td>
						<img src="<c:out value="${promo.article.imageArticle}" />" width="50" height="50">
						<c:out value="${promo.article.nomArticle}" /><br>
						<a class="remove js-link">supprimer</a>
						<button type="button" class="btn btn-info" onclick="remove(${promo.article.idArticle});" ><c:out value="Enlever" /></button>
					</td>
					<td><c:out value="${sessionScope.listeAchat.get(promo.article)}" /></td>
					<td>				
						<c:out value="${sessionScope.listeAchat.get(promo.article)*(promo.article.prix - ( (promo.promotion.reduction/100)*promo.article.prix) )}" />								
					</td>									
				</tr>									
			</c:forEach>									
		<tr>
		<td><a href="<c:url value="/modPanier" ><c:param name="action" value="valider" /></c:url>">Valider</a> </td>
		<td> </td>								
		<td><a href="<c:url value="/annuler" ><c:param name="action" value="annuler" /></c:url>">Annuler</a></td>
		</tr>
	</table>	
</c:if>									
<c:if test="${empty sessionScope.listeAchat }">	
	<table>															
	<tr><td><c:out value="Votre panier est vide" /></td></tr>									
</table>
</c:if>
</div>	
