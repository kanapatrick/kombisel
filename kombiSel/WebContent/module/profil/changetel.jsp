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
			<div class="col-lg-3">
        		<div class="row">
        			<div class="col-lg-12 thumbnail">
        				<span class="glyphicon glyphicon-user"></span>&nbsp<strong>${kombi.prenomUser}&nbsp${kombi.nomUser}</strong>
        			</div>
        		</div>
        		
        		<div class="row">
        			<div class="col-lg-12">
        				<c:import url="/module/profil/listmenu.jsp" />
        			</div>
        		</div>
			
			</div>
			
			<div class="col-lg-6">		
				
					<div class="list-group">
						<span class="list-group-item"> <h3>Numero de Telephone </h3> <br/>Modifiez votre Numero de telephone</span>
							<p class="${empty form.erreur ? 'alert alert-success alert-dismiss':'alert alert-danger alert-dismiss' }" ><span class="glyphicon glyphicon-alert"></span> <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>${form.resultat}</p>
							<span>Votre Numero Actuel est : &nbsp <c:out value="${user1.telephoneUser }" /></span>
							<form  action="<c:url value="/controlparam" />"  method="post"  class="list-group-item">
								<div class="form-group">
									<label for="newtel">Nouveau Numero de télèphone</label>
									<span class="input-group">
										<span class="input-group-addon" id="basic-addon1">+237</span>
										<input type="tel" name="newtel" class="form-control" placeholder="entrez le new number" /><span class="erreur">${form.erreur['newtel']}</span>
									</span>
								</div>
								<div class="form-group">
									<input  class="btn btn-info clic" type="submit" value="Enregistrer les modifications" />
									<input type="hidden" name="mobile" value="mobil" />
								</div>
							</form>
						
					</div>
			
			
			</div>
		
			<div class="col-lg-3">
			
			</div>
				
		</div>
</div>		
	<c:import url="/template/footer.jsp" />
	<script type="text/javascript" src="<c:url value="/scriptjs/jquery.js" />"></script>
	<script type="text/javascript" src="<c:url value="/bootstrap/js/bootstrap.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/scriptjs/panierScript.js" />"></script>
	<script type="text/javascript" src="<c:url value="/scriptjs/kscript.js" />"></script>
</body>
</html>