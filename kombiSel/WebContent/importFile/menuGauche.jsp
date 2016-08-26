<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:choose>
	<c:when test="${sessionScope.user.groupe.idGroupe == 4 }">
	
	</c:when>
	
	<c:when test="${sessionScope.user.groupe.idGroupe == 3 }">
	
			<c:if test="${!empty categorie}">
						
							<c:forEach var="cat" items="${categorie}">
								<ul class="list-unstyled">
									<li><a><c:out value="${cat.nomCategorie}"/></a></li>
								</ul>
							</c:forEach>	
							
			  </c:if>
	
	</c:when>
	
	<c:when test="${sessionScope.user.groupe.idGroupe == 2 }">
	
			<c:if test="${!empty categorie}">
						
							<c:forEach var="cat" items="${categorie}">
							
							<c:out value="${cat.nomCategorie}"></c:out>
								
							</c:forEach>	
							
			</c:if>
	</c:when>
	
	<c:when test="${sessionScope.user.groupe.idGroupe == 1 }">
	
	</c:when>

</c:choose>
