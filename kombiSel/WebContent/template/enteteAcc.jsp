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
				<li><a href="<c:url value="/index" /> " class="acc">Accueil</a></li>
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
										<a class="btn btn-info" href="<c:url value="#" ><c:param name="action" value="annuler" /></c:url>">Annuler</a>
									</span>
								</li>
							</c:when>
								<c:otherwise>
									<li style="text-align:center"><em>Votre Panier est Vide</em></li>
								</c:otherwise>
							</c:choose>
						</ul>
				</li>		
				<li>
					<a href="<c:url value="/inscription" /> ">Inscription</a>
				</li>
				
				<li>
					<button data-toggle="modal" href="#login" class="btn btn-success sign"><span class=" glyphicon glyphicon-user"></span>Sign in</button>
				</li>
			</ul>
		</div>
	</div>

</nav>















