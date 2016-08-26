<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<c:choose>
<c:when test="${ sessionScope.user.groupe.idGroupe == 4 }">

<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<div  class="container">
		<div class="navbar-header">
           <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand col-lg-4" href="#"><img src="<c:url value="img/profil/logo.png" />" width=150 height=30/></a>
		</div>
		
		<div class="collapse navbar-collapse col-lg-8" id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav navbar-right">
				<li>
					<form action="<c:url value="/search"/>" method="get" role="search" >
						<div class="input-group form-group">
						    <input name="recherchearticle" class="form-control" required type="search"  placeholder="Recherchez des Artilcles.....">
						 	 <span class="input-group-btn">
			    				<button class="btn btn-success" type="submit"><span class="glyphicon glyphicon-search"></span></button>
			   				</span>
						</div>
					</form>
				</li>
				<li><a href="<c:url value="/accueil" /> "><span class="glyphicon glyphicon-home"></span>Home</a></li>
				<li>
					<a href="#">About</a>
				</li>
				<li>
					<a href="#">Contact</a>
				</li>
			
				<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown" ><span id="compteur"><c:out value="${sessionScope.listeAchat.size()}" /></span><span class="glyphicon glyphicon-shopping-cart"></span>Panier<b class="caret"></b></a>
						<ul class="dropdown-menu dropdown-panier pull-right">
						<c:choose>
							<c:when test="${!empty sessionScope.listeAchat }">
								
		 							<li>
			 							<div>
			 								<strong class="block-left">Article</strong> 
			 								<strong class="block-center"> Quandité</strong>  
			 								<strong class="block-right">Prix</strong> 
			 							</div>
		 							</li>
		 							<li class="content-article">
		 						<c:forEach items="${sessionScope.selectedArticle}" var="achat">
		 							
		 								<span class="block-left">
		 									<img alt="image article" src="<c:out value="${achat.imageArticle }" />" width="50" height="50">
		 									<span><c:out value="${achat.nomArticle}" /></span>
		 								</span>
		 								<span class="block-center">
		 									<c:out value="${sessionScope.listeAchat.get(achat)}" />
		 								</span>
		 								
		 								<span class="block-right">
		 									<c:out value="${sessionScope.listeAchat.get(achat)*achat.prix}" />
		 								</span>
		 								<a href="#"  onclick="remove(${achat.idArticle});" ><c:out value="Enlever" /></a>
								</c:forEach>
								</li>
								<li class="content-article">
								<c:forEach items="${sessionScope.selectedPromo }" var="promo">
									
										<span class="block-left">
											<img alt="image article" src="${promo.article.imageArticle }" width="50" height="50"><br/>
											<span><c:out value="${promo.article.nomArticle}" /></span>
											
										</span>
										<span class="block-center">
											<c:out value="${sessionScope.listeAchat.get(promo.article)}" />
										</span>
										<span class="block-right">
											<c:out value="${sessionScope.listeAchat.get(promo.article)*(promo.article.prix - ( (promo.promotion.reduction/100)*promo.article.prix) )}" />
										</span>
										<a href="#"  onclick="remove(${achat.idArticle});" ><c:out value="Enlever" /></a>	
									
								</c:forEach>
								</li>
							
								<li>
									<span class="block-left">
										<a class="btn btn-info" href="<c:url value="/modPanier" ><c:param name="action" value="valider" /></c:url>">Valider</a>
									</span>
									<span class="block-center">
									
									</span>
									<span class="block-right">
										<a class="btn btn-info" href="<c:url value="/annuler" ><c:param name="action" value="annuler" /></c:url>">Annuler</a>
									</span>
								</li>
							</c:when>
								<c:otherwise>
									<li style="text-align:center"><em>Votre Panier est Vide</em></li>
								</c:otherwise>
							</c:choose>
						</ul>
				</li>		
			       <li class="dropdown">
           				 <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="glyphicon glyphicon-user"></i><i> Hi </i>  ${sessionScope.pseudo }  <b class="caret"></b></a>
			           	 <ul class="dropdown-menu">
			                <li>
			                    <a href="<c:url value="/profiluser" /> "><i class="glyphicon glyphicon-user"></i> Profile</a>
			                </li>
			                <li>
			                    <a href="<c:url value="/paramuser" /> " ><i class="glyphicon glyphicon-cog"></i>Paramettre</a>
			                </li>
			                <li class="divider"></li>
			                <li>
			                    <a href="<c:url value="/deconnexion" /> "><i class="glyphicon glyphicon-off"></i> Log Out</a>
			                </li>
			            </ul>
      			  </li>
			</ul>
		</div>
	</div>

</nav>
</c:when>

<c:when test="${sessionScope.user.groupe.idGroupe == 3 }">
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="#"><img src="<c:url value="img/profil/logo.png" />" width=150 height=35/></a>
    </div>
    <ul class="nav navbar-right top-nav">
        <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="glyphicon glyphicon-user"></i><i> Hi </i>  ${sessionScope.pseudo }  <b class="caret"></b></a>
            <ul class="dropdown-menu">
                <li>
                    <a href="<c:url value="/profiluser" /> "><i class="glyphicon glyphicon-user"></i> Profile</a>
                </li>
                <li>
                    <a href="<c:url value="/paramuser" /> " ><i class="glyphicon glyphicon-cog"></i>Paramettre</a>
                </li>
                <li class="divider"></li>
                <li>
                    <a href="<c:url value="/deconnexion" /> "><i class="glyphicon glyphicon-off"></i> Log Out</a>
                </li>
            </ul>
        </li>
    </ul>  
      <div class="collapse navbar-collapse navbar-ex1-collapse">
      <ul class="nav navbar-nav side-nav">
      	
         
   		  <li class="active" ><a href="<c:url value="/accueil" /> "><span class="glyphicon glyphicon-home"></span>&nbspHome</a></li>
          
          <li>
             <a href="<c:url value="/ajouterarticle" /> ">Add Article</a>
          </li>
          <li>
              <a href="#"><i class=""></i>Liste de commande</a>
          </li>
          <li>
          	<form action="<c:url value="/search"/>" method="get" role="search" >
						<div class="">
						    <input name="recherchearticle" class="form-control" required type="search"  placeholder="Recherchez des Artilcles.....">
						</div>
			</form>
          </li>
      </ul>
    </div>    
 </nav>


</c:when>
<c:when test="${sessionScope.user.groupe.idGroupe == 2 }">

<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
   <div class="navbar-header">
       <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
           <span class="sr-only">Toggle navigation</span>
           <span class="icon-bar"></span>
           <span class="icon-bar"></span>
           <span class="icon-bar"></span>
       </button>
       <a class="navbar-brand" href="#"><img src="<c:url value="img/profil/logo.png" />" width=150 height=35/></a>
   </div>
   <ul class="nav navbar-right top-nav">
       <li class="dropdown">
           <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="glyphicon glyphicon-user"></i><i> Hi </i>  ${sessionScope.pseudo }  <b class="caret"></b></a>
           <ul class="dropdown-menu">
               <li>
                   <a href="<c:url value="/profiluser" /> "><i class="glyphicon glyphicon-user"></i> Profile</a>
               </li>
               <li>
                   <a href="<c:url value="/paramuser" /> " ><i class="glyphicon glyphicon-cog"></i>Paramettre</a>
               </li>
               <li class="divider"></li>
               <li>
                   <a href="<c:url value="/deconnexion" /> "><i class="glyphicon glyphicon-off"></i> Log Out</a>
               </li>
           </ul>
       </li>
   </ul>
   <div class="collapse navbar-collapse navbar-ex1-collapse">
      <ul class="nav navbar-nav side-nav">
      	
         
   		  <li class="active" ><a href="<c:url value="/accueil" /> "><span class="glyphicon glyphicon-home"></span>&nbspHome</a></li>
          
          <li>
              <a href="#" ><i class=""></i>link en cour</a>
          </li>
          <li>
              <a href="#"><i class=""></i>Link en cour</a>
          </li>
      </ul>
    </div>
         
 </nav>

</c:when>
 <c:when test="${sessionScope.user.groupe.idGroupe == 1 }">
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
   <div class="navbar-header">
       <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
           <span class="sr-only">Toggle navigation</span>
           <span class="icon-bar"></span>
           <span class="icon-bar"></span>
           <span class="icon-bar"></span>
       </button>
       <a class="navbar-brand" href="#"><img src="<c:url value="img/profil/logo.png" />" width=150 height=35/></a>
   </div>
   <ul class="nav navbar-right top-nav">
       <li class="dropdown">
           <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="glyphicon glyphicon-user"></i><i> Hi </i>  ${sessionScope.pseudo }  <b class="caret"></b></a>
           <ul class="dropdown-menu">
               <li>
                   <a href="<c:url value="/profiluser" /> "><i class="glyphicon glyphicon-user"></i>&nbsp Profile</a>
               </li>
               <li>
                   <a href="<c:url value="/paramuser" /> " ><i class="glyphicon glyphicon-cog"></i> &nbsp Paramettre</a>
               </li>
               <li class="divider"></li>
               <li>
                   <a href="<c:url value="/deconnexion" /> "><i class="glyphicon glyphicon-off"></i> &nbsp Log Out</a>
               </li>
           </ul>
       </li>
   </ul>
   <div class="collapse navbar-collapse navbar-ex1-collapse">
      <ul class="nav navbar-nav side-nav">
      	
         
   		  <li class="active" ><a href="<c:url value="/accueil" /> "><span class="glyphicon glyphicon-home"></span>&nbsp Home</a></li>
          
          <li>
              <a href="#" ><i class=""></i>link en cour</a>
          </li>
          <li>
              <a href="#"><i class=""></i>Link en cour</a>
          </li>
      </ul>
    </div>
         
 </nav>

</c:when>
</c:choose>