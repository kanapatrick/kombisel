<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div id="wrapper">


 <c:choose>
	<c:when test="${sessionScope.user.groupe.idGroupe == 4 }">
	<c:import url="/module/mesarticles/mes_articles.jsp" />	
	<c:import url="/module/mesarticles/detailarticle.jsp" />	
	
	</c:when>
	
	<c:when test="${sessionScope.user.groupe.idGroupe == 3}">
	<div class="container">
	<div class="row">
	<c:if test="${!empty articles}">
		<c:forEach var="art" items="${articles}">
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
											<input type="button" onclick="ajouter(${art.idArticle});" class="btn btn-info" value="<c:out value="J'ACHETE" />" ><br />	
											<strong class="pull-right"><c:out value="${art.prix} FCFA" />, <em>Qté:<c:out value="${art.quantite}"/></em></strong>	<br/>
											<nav class="nave">				 											 							 											 															
												<a href="<c:url value="/artgest"> <c:param name="action" value="modifier" /> <c:param name="doc" value="${art.idArticle}" /> </c:url>">
												<img src="<c:url value="/module/mesarticles/images/modif.jpg" />" title="Modifier" alt="Modifier" width=30 height=30></a>
												<a href="<c:url value="/artgest"> <c:param name="action" value="supprimer" /> <c:param name="doc" value="${art.idArticle}" /> </c:url>">
												<img src="<c:url value="/module/mesarticles/images/sup.jpg" />" alt="supprimer" title="Supprimer" width=30 height=30></a>
												<a href="<c:url value="#"> <c:param name="action" value="promotion" /> <c:param name="doc" value="${doc.idDocument}" /> </c:url>">
												<img src="<c:url value="/module/mesarticles/images/publier.png" />" alt="Mettre en Promotion" title="Mettre en Promotion" width=30 height=30></a>
											</nav>	
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
	
	</c:when>
	
	<c:when test="${sessionScope.user.groupe.idGroupe == 2}">
<div id="page-wrapper">

   <div class="container-fluid">

       <div class="row">
           <div class="col-lg-12">
               <h3 class="page-header">
                Tableau de Bord
               </h3>
           </div>
       </div>
       <div class="row">
           <div class="col-lg-4 col-md-6">
               <div class="panel panel-green">
                   <div class="panel-heading">
                       <div class="row">
                           <div class="col-xs-3">
								<a href="<c:url value="/gestionespace"> <c:param name="action" value="inscrit"/></c:url> "><img src="<c:url value="/img/imgad/userU.jpg"/>" alt="image user"class="img-thumbnail" style="border-radius:100%"></a>
                           </div>
                           <div class="col-xs-9 text-right">
                               <div class="huge">26</div>
                               <div>New user!</div>
                           </div>
                       </div>
                   </div>
                   <a href="<c:url value="/gestionespace"> <c:param name="action" value="inscrit" /> </c:url> ">
                       <div class="panel-footer">
                           <span class="pull-left">Gestions des Users</span>
                           <span><i class="glyphicon glyphicon-circle-arrow-righ pull-right"></i></span>
                           <div class="clearfix"></div>
                       </div>
                   </a>
               </div>
           </div>
           <div class="col-lg-4 col-md-6">
               <div class="panel panel-yellow">
                   <div class="panel-heading">
                       <div class="row">
                           <div class="col-xs-3">
                           	<a href="<c:url value="/gestionespace"> <c:param name="action" value="commu" /></c:url> " style="text-align:center"><img src="<c:url value="/img/imgad/communiquer.jpeg"/>" alt="Communiquer user" class="img-thumbnail" style="border-radius:100%"></a>
                           </div>
                           <div class="col-xs-9 text-right">
                               <div class="huge">124</div>
                               <div>New Communiquer!</div>
                           </div>
                       </div>
                   </div>
                   <a href="<c:url value="/gestionespace"> <c:param name="action" value="commu" /> </c:url> ">
                       <div class="panel-footer">
                           <span class="pull-left">Gestions des Communiques</span>
                           <span class="pull-right"><i class="glyphicon glyphicon-circle-arrow-righ pull-right"></i></span>
                           <div class="clearfix"></div>
                       </div>
                   </a>
               </div>
           </div>
           <div class="col-lg-4 col-md-6">
               <div class="panel panel-red">
                   <div class="panel-heading">
                       <div class="row">
                           <div class="col-xs-3">
								<a href="<c:url value="/gestionespace" > <c:param name="action" value="cate" /> </c:url> " style="text-align:center"><img src="<c:url value="/img/imgad/categorie.jpg"/>" alt="categorie" class="img-thumbnail" style="border-radius:100%"></a>
                           </div>
                           <div class="col-xs-9 text-right">
                           
                            	   		<div class="huge">76</div>
                            	
                               <div>new Categorie!</div>
                           </div>
                       </div>
                   </div>
                   <a href="<c:url value="/gestionespace"> <c:param name="action" value="cate" /> </c:url> ">
                       <div class="panel-footer">
                           <span class="pull-left">Gestions des Categories</span>
                           <span class="pull-right"><i class="glyphicon glyphicon-circle-arrow-righ pull-right"></i></span>
                           <div class="clearfix"></div>
                       </div>
                   </a>
               </div>
           </div>
       </div>
   </div>
   

</div>
     

</c:when>
	
<c:when test="${sessionScope.user.groupe.idGroupe == 1 }">
	<div id="page-wrapper">

   <div class="container-fluid">

       <div class="row">
           <div class="col-lg-12">
               <h3 class="page-header">
                Tableau de Bord
               </h3>
           </div>
       </div>
       <div class="row">
           <div class="col-lg-6 col-md-6">
               <div class="panel panel-primary">
                   <div class="panel-heading">
                       <div class="row">
                           <div class="col-xs-3">
								<a href="<c:url value="/gestionespace"> <c:param name="action" value="inscrit"/></c:url>"><img src="<c:url value="/img/imgad/userU.jpg"/>" alt="image user"class="img-thumbnail" style="border-radius:100%"></a>
                           </div>
                           <div class="col-xs-9 text-right">
                               <div class="huge">26</div>
                               <div>New user!</div>
                           </div>
                       </div>
                   </div>
                   <a href="#">
                       <div class="panel-footer">
                           <span class="pull-left">Gestions des Inscrits</span>
                           <span><i class="glyphicon glyphicon-circle-arrow-righ pull-right"></i></span>
                           <div class="clearfix"></div>
                       </div>
                   </a>
               </div>
           </div>
     
           <div class="col-lg-6 col-md-6">
               <div class="panel panel-yellow">
                   <div class="panel-heading">
                       <div class="row">
                           <div class="col-xs-3">
                           	<a href="#" style="text-align:center"><img src="<c:url value="/img/imgad/communiquer.jpeg"/>" alt="Communiquer user" class="img-thumbnail" style="border-radius:100%"></a>
                           </div>
                           <div class="col-xs-9 text-right">
                               <div class="huge">124</div>
                               <div>New Communiquer!</div>
                           </div>
                       </div>
                   </div>
                   <a href="#">
                       <div class="panel-footer">
                           <span class="pull-left">Gestions des Communiques</span>
                           <span class="pull-right"><i class="glyphicon glyphicon-circle-arrow-righ pull-right"></i></span>
                           <div class="clearfix"></div>
                       </div>
                   </a>
               </div>
           </div>
       </div>
   </div>
   

</div>

</c:when> 
 </c:choose>
</div>