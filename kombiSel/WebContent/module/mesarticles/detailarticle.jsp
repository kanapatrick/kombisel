
<div id="detail" class="modal fade">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header"><a class="close" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span></a>
					<h3 class="modal-title">Détail Article</h3>
			</div>
			<div class="modal-body">
				<c:if test="${!empty articlecourant }">
					<div class="thumbnail item active ">
								<span><img  src="<c:out value="${articlecourant.imageArticle}" />" width="242" height="200" alt="img articles"></span>
								<div class="caption">
								 <h4><a href="<c:url value="/index" > <c:param name="action" value="${articlecourant.idArticle}" /> </c:url> "> <c:out value="${articlecourant.nomArticle}" /></a></h4><br />
								 		<p><c:out value="${articlecourant.description}" /></p>
										<p>	 						 							 					
												<input type="button" onclick="ajouter(${articlecourant.idArticle});" class="btn btn-info" value="<c:out value="J'ACHETE" />" ><br />	
												<strong class="pull-right"><c:out value="${articlecourant.prix} FCFA" /></strong>				 											 							 											 						
											
											<c:if test="${sessionScope.user != null} && ${sessionScope.user.idUser < 4 }">
									
												<a href="<c:url value="/editerDoc"> <c:param name="action" value="modifier" /> <c:param name="doc" value="${doc.idDocument}" /> </c:url>">
												<img src="<c:url value="/module/mesarticles/images/icon-48-edit.png" />" title="Modifier" alt="Modifier"></a>
											
											</c:if>
											<c:if test="${sessionScope.user != null} && ${sessionScope.user.idUser < 2 }">
											
												<a href="<c:url value="/myArticle"> <c:param name="action" value="promotion" /> <c:param name="doc" value="${doc.idDocument}" /> </c:url>">
												<img src="<c:url value="/module/mesarticles/images/publier.png" />" alt="Mettre en Promotion" title="Mettre en Promotion"></a>
										
											</c:if>
										</p>
									</div>
								</div>
				</c:if>
			</div>
		
		</div>
	</div>

</div>