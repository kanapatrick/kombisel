<div id="panier">
							<div id="loader"> &nbsp</div>
							<a href="<c:url value="/ModAddArticle" />"><img src="<c:url value="/template/panier.JPG"  />" id="image_panier" ></a>
							<span id="compteur"><c:out value="${sessionScope.listeAchat.size()}" /></span>
							<div id="product_list">
							<c:if test="${!empty sessionScope.listeAchat }">
								<table>
									<thead>
										<tr>
										<th><c:out value="Nom" /></th>
										<th><c:out value="Quantité" /></th>
										<th><c:out value="Prix" /></th>
										</tr>
									</thead>
									<tbody>
								<c:forEach var="achat" items="${sessionScope.selectedArticle}">
									
										<tr>
										<td>
											<img src="<c:out value="${achat.imageArticle}" />" width="50" height="50">
											<c:out value="${achat.nomArticle}" />
										</td>
										<td><c:out value="${sessionScope.listeAchat.get(achat)}" /></td>
										<td><c:out value="${sessionScope.listeAchat.get(achat)*achat.prix}" /></td>
										</tr>									
																		
								</c:forEach>
								
								<tr>
								<td><a href="<c:url value="/modPanier" ><c:param name="action" value="valider" /></c:url>">Valider</a> </td>
								<td> </td>								
								<td><a href="<c:url value="/annuler" ><c:param name="action" value="annuler" /></c:url>">Annuler</a></td>
								</tr>
								</tbody>
								</table>
							</c:if>										
							<c:if test="${empty sessionScope.listeAchat }">	
								<table>															
								<tr><td><c:out value="Votre panier est vide" /></td></tr>									
							</table>
							</c:if>	
						</div>																						
						</div>						