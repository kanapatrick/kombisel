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
<title>Toutes les categories</title>
</head>

<body class="bg-success">
<c:import url="/template/enteteAcc.jsp" />
<div class="container">
	<div class="row"> 
			<c:if test="${!empty souscatlist && !empty categorie }">
						<c:forEach items="${categorie}" var="cate">
								<div class="col-lg-6 col-md-6 col-xs-12 col-sm-12">
										<div class="panel panel-default">
											<div class="panel-heading" style="font-size:17px;"><c:out value="${cate.nomCategorie}" /></div>
								
												<div class="panel-body">
													<c:forEach items="${souscatlist.get(cate) }" var="souscat">
														<ul class="list-unstyled">
															<li><a href="<c:url value="/consultearticle"> <c:param  name="action" value="${soutcat.idSousCategorie}"/> </c:url>" ><c:out value="${souscat.nomSousCategorie}" /></a></li>
														</ul>
													</c:forEach>
												</div>
										</div>
								</div>
						</c:forEach>
					</c:if>
	</div>
</div>
	
	<div id="login" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header"><a class="close" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span></a>
					<h3 class="modal-title">Connectez-vous !!!</h3>
				</div>
				<div class="modal-body">
				
					 <form action="<c:url value="/index"/> " method="post" class="form-group">
					 	<div class="form-group">
				            <label for="un">Username:</label>
				            <input name="pseudo" id="un" value="" class="form-control" placeholder="pseudo" data-theme="a" type="text">
				        </div>
				        <div class="form-group">
				            <label for="pw" >Password:</label>
				            <input name="motpasse" id="pw" value="" class="form-control" placeholder="mot de passe " data-theme="a" type="password">
				        </div>
				         <div class="modal-footer">
				        	<input type="submit" class="btn btn-info" value="connexion" >
				        	<button class="btn btn-info" data-dismiss="modal">cancel</button>
				        </div>
				    </form>
				</div>
			</div>
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