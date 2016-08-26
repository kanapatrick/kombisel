<select name="sous_categorie">														
	<c:if test="${!empty sousCate}">									
		<c:forEach var="cat" items="${sousCate}">										
			<option value="${cat.idSousCategorie}"><c:out value="${cat.nomSousCategorie}"></c:out></option>											
		</c:forEach>											
	</c:if>								
</select>