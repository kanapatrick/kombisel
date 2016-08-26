<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/> 
<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
<link rel="stylesheet" type="text/css" href="<c:url value="/bootstrap/css/bootstrap.css"/>" />
<link rel="stylesheet" type="text/css" href="<c:url value="/style/designkomacc.css"/>" /> 
<link rel="stylesheet" type="text/css" href="<c:url value="/style/design.css"/>" />

<title>Inscription </title>
</head>
<body>
<div class="container-fluid">	
	<c:import url="/template/enteteAcc.jsp" />
	
	<section class="row-fluid">
		
		<section class="col-md-4 col-md-push-1">
			
			<form action="<c:url value="/inscription"/>" method="post">	
					<p class="${empty form.erreurs ? 'alert alert-success':'alert alert-danger' }" ><span class="glyphicon glyphicon-alert"></span> <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>${form.resultat}</p>
					
					<div class="form-group">
					
						<label for="nomuser">Nom<span class="oblig">*</span></label>
						<input type="text" name="nomuser" value="<c:out value="${user.nomUser }"/>" class="form-control" aria-describedby="basic-addon1" placeholder="ex: nom" /> <span class="erreur">${form.erreurs["nomuser"] }</span>
						
					</div>
					<div class="form-group">
						<label for="prenomuser">Prenom</label>
						<input type="text" name="prenomuser" class="form-control"  placeholder="ex : Prenom " value="<c:out value="${user.prenomUser }"/>"  /><span class="erreur">${form.erreurs["prenomuser"] }</span> 
					</div>
					<div class="form-group">
						<label for="emailuser">Email<span class="oblig">*</span></label>
						<input type="email" class="form-control" placeholder="ex: example@example.com" name="emailuser" value="<c:out value="${user.emailUser }"/>" /><span class="erreur">${form.erreurs["emailuser"] }</span>	
					</div>		
					<div class="form-group">			
						<label for="adresse">Adresse <span class="oblig">*</span></label>
						<input type="text" name="adresse" class="form-control" placeholder =" ex: BP 67  Dschang carefour yves" />
					</div>
					<div class="form-group">
						<label for="pseudo">Pseudo<span class="oblig">*</span></label>
						<input type="text" class="form-control" placeholder="ex: Pseudo " name="pseudo" value="<c:out value="${user.pseudo }"/>"/><span class="erreur">${form.erreurs["pseudo"] }</span>
					</div>
					<div class="form-group">
						<label for="motpasse">Mot de passse<span class="oblig">*</span></label>
						<input type="password" class="form-control" name="motpasse" placeholder="***********"  /><span class="erreur">${form.erreurs["motpasse"] }</span>
					</div>
					<div class="form-group">
						<label for="confmotpasse">Confirmez mot de passe<span class="oblig">*</span></label>
						<input type="password" class="form-control" name="confmotpasse"  placeholder="***********"/><span class="erreur">${form.erreurs["confmotpasse"] }</span>
					</div>
					<div class="form-group">
						<label for="telephoneuser">Numero de Telephone<span class="oblig">*</span></label>
						<input type="text" class="form-control" name="telephoneuser" value="<c:out value="${user.telephoneUser }"/>" placeholder="ex : 67342390000" /><span class="erreur">${form.erreurs["telephoneuser"] }</span><br/>
					</div>
					<div class="form-group">
						<input type="submit" value="Inscrire" class="btn btn-info form-control" />
					</div>		
		
			</form>
			
		</section>
		
		<section class="col-md-8 col-md-push-1">
		
			<div class="row-fluid">
			
				<div class="col-md-6">
					ici nous avons la premier promo
				</div>
				
				<div class="col-md-6">
					ici nous avons la promo 2
				</div>
				
			</div>
			
		</section>
		
	</section>
</div>	
	<c:import url="/template/footer.jsp" />
	
	
	<script type="text/javascript" src="<c:url value="/scriptjs/jquery.js" />"></script>
	<script type="text/javascript" src="<c:url value="/bootstrap/js/bootstrap.min.js"/>"></script>
	<script type="text/javascript">
			$(function(){
				
				$('.sign').hide();
			});
		</script>

</body>
</html>