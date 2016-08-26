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
<link rel="stylesheet" type="text/css" href="<c:url value="/style/design.css"/>" />

<title>Resultat d'article Retrouver</title>
</head>
<body>
 <c:import url="/template/enteteAcc.jsp" />
 
 <div class="container">
	<div class="row">
	<c:if test="${empty listart}" >
		<div class="oblig" style="text-align:center"><c:out value="${resultat}"/></div>
	</c:if>
	<c:if test="${!empty listart}">
	
		<c:forEach var="art" items="${listart}">
			<c:if test="${art.quantite > 0}">
				<div class="col-lg-3 col-md-4 col-sm-6 col-xs-12">
					<div id="carousel" class="carousel slide">
						<div class="carousel-inner">
							<div class="thumbnail item active ">
								<span><img  src="<c:out value="${art.imageArticle}" />" width="242" height="200" alt="img articles"></span>
								<div class="caption">
						
								 <h4>
								 <a data-toggle="modal" href="#detail" <c:url value="#detail" ></a><c:param name="action" value="${art.idArticle}"/></c:url> ><c:out value="${art.nomArticle}" /></a>
								 </h4>
								 
								 		<p><c:out value="${art.description}" /></p>
										<p>	 						 							 					
												<input type="button" onclick="ajouter(${art.idArticle});" class="btn btn-info" value="<c:out value="J'ACHETE" />" ><br />	
												<strong class="pull-right"><c:out value="${art.prix} FCFA" />, <em>Qté:<c:out value="${art.quantite}"/></em></strong>				 											 							 											 						
												
											<c:if test="${sessionScope.user ne null} && ${sessionScope.user.idUser lt 4 }">
									
												<a href="<c:url value="#"> <c:param name="action" value="modifier" /> <c:param name="doc" value="${art.idArticle}" /> </c:url>">
												<img src="<c:url value="/module/mesarticles/images/icon-48-edit.png" />" title="Modifier" alt="Modifier"></a>
											
											</c:if>
											<c:if test="${sessionScope.user != null} && ${sessionScope.user.idUser < 2 }">
											
												<a href="<c:url value="/myArticle"> <c:param name="action" value="promotion" /> <c:param name="doc" value="${doc.idDocument}" /> </c:url>">
												<img src="<c:url value="/module/mesarticles/images/publier.png" />" alt="Mettre en Promotion" title="Mettre en Promotion"></a>
										
											</c:if>
										</p>
									</div>
								</div>
							</div>					 									 			
						 </div>	
						 		
				</div>
			
		</c:if>
			</c:forEach>

				</c:if>	
	</div>
</div>
 

<c:import url="/template/footer.jsp" />	
<script type="text/javascript" src="<c:url value="/scriptjs/jquery.js" />"></script>
<script type="text/javascript" src="<c:url value="/bootstrap/js/bootstrap.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/scriptjs/jssor.js" />"></script>
<script type="text/javascript" src="<c:url value="/scriptjs/jssor.slider.js" />" ></script>
<script type="text/javascript" src="<c:url value="/scriptjs/panierScript.js"/> "></script>
</body>
</html>