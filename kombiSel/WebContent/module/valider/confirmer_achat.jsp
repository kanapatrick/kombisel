<c:import url="/template/enteteAcc.jsp" />
<body>
<div id="validation_achat">
		<c:if test="${!empty sessionScope.listeAchat && sessionScope.listeAchat != null }">
		<form method="post" action="<c:url value="/modPanier"><c:param name="action" value="validerCommande" /> </c:url>" >
			<table  style="textalign:center" >
				<tr>
					<td><c:out value="Article" /></td>
					<td><c:out value="Nom" /></td>					
					<td><c:out value="Quantité" /></td>
					<td><c:out value="Prix" /></td>
					<td><c:out value="PrixTotal" /></td>					
				</tr>
				<c:forEach var="article" items="${sessionScope.selectedArticle}">
					<tr>
						<td>
							<img src="<c:url value="${article.imageArticle}" />" height="100" width="100">							
						</td>
						<td><c:out value="${article.nomArticle}" /></td>
						
						<td><c:out value="${sessionScope.listeAchat.get(article)}" /></td>
						<td><c:out value="${article.prix}" /></td>	
						<td><c:out value="${article.prix*sessionScope.listeAchat.get(article)}" /></td>					
					</tr>
				</c:forEach>
				<tr>
					<td><c:out value="" /></td>
					<td><c:out value="Total : " /></td>					
					<td><c:out value="" /></td>
					<td><c:out value="" /></td>
					<td><c:out value="${prixTotalArticle}" /></td>					
				</tr>
				<c:forEach var="art_promo" items="${sessionScope.selectedPromo}">
					<tr>
						<td>
							<img src="<c:url value="${art_promo.article.imageArticle}" />" height="100" width="100">							
						</td>
						<td><c:out value="${art_promo.article.nomArticle}" /></td>
						
						<td><c:out value="${sessionScope.listeAchat.get(art_promo.article)}" /></td>
						<td><c:out value="${art_promo.article.prix - ( (art_promo.promotion.reduction/100)*art_promo.article.prix)}" /></td>	
						<td><c:out value="${sessionScope.listeAchat.get(art_promo.article)*(art_promo.article.prix - ( (art_promo.promotion.reduction/100)*art_promo.article.prix) )}" /></td>					
					</tr>
				</c:forEach>
				<tr>
					<td><c:out value="" /></td>
					<td><c:out value="Total Promotion : " /></td>					
					<td><c:out value="" /></td>
					<td><c:out value="" /></td>
					<td><c:out value="${prixTotalPromo}" /></td>					
				</tr>
			</table>
			<input type="submit" value="Ok">
		</form>	
		</c:if>
	</div>
</body>
</html>