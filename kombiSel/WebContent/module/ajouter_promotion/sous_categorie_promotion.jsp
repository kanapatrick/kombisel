<select name="sous_categorie">			
	<option><c:out value="Selectionner une Sous cat�gorie" /></option>											
	<c:if test="${!empty sousCategorie}">									
		<c:forEach var="cat" items="${sousCategorie}">										
			<option onclick="getArticle(${cat.idSousCategorie});" value="${cat.idSousCategorie}"><c:out value="${cat.nomSousCategorie}"></c:out></option>											
		</c:forEach>											
	</c:if>	
	<c:if test="${empty sousCategorie || sousCategorie==null}">
	<c:out value="Aucun Sous-cat�gorie pour cette Cat�gorie" />
</c:if>								
</select>