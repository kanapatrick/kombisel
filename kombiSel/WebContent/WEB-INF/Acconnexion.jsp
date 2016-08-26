<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE >
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/> 
<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
<link rel="stylesheet" type="text/css" href="<c:url value="/bootstrap/css/bootstrap.css"/>" />
<link rel="stylesheet" type="text/css" href="<c:url value="/bootstrap/css/bootstrap-responsive.css"/>" />
<link rel="stylesheet" type="text/css" href="<c:url value="/style/designkomacc.css"/>" /> 
	
</head>
<body>
	<c:import url="/template/enteteAcc.jsp"/>
	<div class="container">		
		<div  class="row">
			<div class="col-lg-6 ">
			      <div class="row"> 
			      	<div class="col-lg-12">
			      		<p class="alert alert-danger alert-dismissible"><span class="glyphicon glyphicon-alert"></span> <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>${resultat} </p>
					     <form action="<c:url value="/index"/> " method="post" class="form-group">
							 	<div class="form-group">
						            <label for="un">Username:</label>
						            <input name="pseudo" id="un" value="" class="form-control" placeholder="pseudo" data-theme="a" type="text">
						        </div>
						        <div class="form-group">
						            <label for="pw" >Password:</label>
						            <input name="motpasse" id="pw" value="" class="form-control" placeholder="mot de passe " data-theme="a" type="password">
						        </div>
						         <div class="form-group">
						        	<input type="submit" class="btn btn-info" value="connexion" >
						        </div>
						  </form>
					</div>
					
					<div class="col-lg-12" >
						<span><a href="#" >Mot de passe oublié? </a></span>&nbsp&nbsp<span><a href="<c:url value="/inscription" /> ">Inscription</a></span>
					</div>
				  </div>
			</div>
			
			<section class="col-lg-6">
				<div class="row">
					<div class="col-lg-6">
					    ici impeut de la promo
					</div>
					
					<div class="col-lg-6">
						meme ici aussi impeut de promoto
					</div>
				</div>	
			</section>    
			
		</div>
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