<select name="article">	
	<option><c:out value="Selectionner un Article" /></option>																																							
	<c:if test="${!empty articles}">									
		<c:forEach var="art" items="${articles}">										
			<option value="${art.idArticle}"><c:out value="${art.nomArticle}"></c:out></option>											
		</c:forEach>											
	</c:if>
	<c:if test="${empty articles || articles==null}">
		<c:out value="Aucun article disponible pour cette Sous-catégorie" />
	</c:if>	
</select>								
	