<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/> 
<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
<link rel="stylesheet" type="text/css" href="<c:url value="/bootstrap/css/bootstrap.css"/>" />
<link rel="stylesheet" type="text/css" href="<c:url value="/bootstrap/css/bootstrap-responsive.css"/>" />
<link rel="stylesheet" type="text/css" href="<c:url value="/style/designkom.css"/>" /> 
<link rel="stylesheet" type="text/css" href="<c:url value="/style/design.css"/>" />
</head>
<body>

<div class="container-fluid">
	
	<c:import url="/importFile/enteteAfter.jsp" />
	
		<div class="row">
			
			<div class=" col-lg-pull-2 col-lg-12 col-lg-push-1">		
				
				<div class="row-fluid">
					<div class="col-lg-2">
						<img alt="" src="<c:url value="/img/profil/avatar.jpg" /> " style="border-radius:100%" class="thumbnail">
					</div>
					
					<div class="col-lg-10">
						<p><b>Etat actuel: </b>   <i class="${empty etat ? 'succes' : 'erreur' }"><c:out value="${resultat}"/></i> </p>
						
						<ul class="list-unstyled">
							<li><b>Nom :</b>      <c:out value="${kombi.nomUser }"/></li><br/>
							<li><b>Prenom :</b>   <c:out value="${kombi.prenomUser }"/></li><br/>
							<li><b>Email :</b>   <c:out value="${kombi.emailUser }"/></li><br/>
							
							<li><b>Télèphone :</b> 	<c:out value="${kombi.telephoneUser }" /></li><br/>
							
							<li><b>Adresse :</b>	<c:out value="${kombi.addresse }"/></li><br/>
							
						</ul>
						
						<p style="text-align: center;"><a href="<c:url value="/profiluser"> <c:param name="action" value="modif"/></c:url>" class="btn btn-danger">désactiver</a></p>
					</div>
				</div>	
						
			
				
			</div>
		
				
		</div>
		
	<c:import url="/template/footer.jsp" />
	
</div>
	<script type="text/javascript" src="<c:url value="/scriptjs/jquery.js" />"></script>
	<script type="text/javascript" src="<c:url value="/bootstrap/js/bootstrap.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/scriptjs/panierScript.js" />"></script>
	<script type="text/javascript" src="<c:url value="/scriptjs/kscript.js" />"></script>
</body>
</html>