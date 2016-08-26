<div class="container">
	<div class="row">
	<c:if test="${!empty articles}">
			<div class="row">
				<div class="col-lg-12">
					<div class="btn-group" data-toggle="buttons">
			
						<label class="btn btn-success" id="previous">
						<span class="glyphicon glyphicon-step-backward pull-right"></span>
						</label>
						
						<label class="btn btn-success" id="next">
						<span class="glyphicon glyphicon-step-forward pull-left"></span>
						</label>
					</div>
				</div>
			</div>
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
										<p>	 						 							 					
												<input type="button" onclick="ajouter(${art.idArticle});" class="btn btn-info" value="<c:out value="J'ACHETE" />" ><br />	
												<strong class="pull-right"><c:out value="${art.prix} FCFA" />, <em>Qté:<c:out value="${art.quantite}"/></em></strong>				 											 							 											 															
												<a href="<c:url value="#"> <c:param name="action" value="modifier" /> <c:param name="doc" value="${art.idArticle}" /> </c:url>">
												<img src="<c:url value="/module/mesarticles/images/icon-48-edit.png" />" title="Modifier" alt="Modifier"></a>
												<a href="<c:url value="/myArticle"> <c:param name="action" value="promotion" /> <c:param name="doc" value="${doc.idDocument}" /> </c:url>">
												<img src="<c:url value="/module/mesarticles/images/publier.png" />" alt="Mettre en Promotion" title="Mettre en Promotion"></a>
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