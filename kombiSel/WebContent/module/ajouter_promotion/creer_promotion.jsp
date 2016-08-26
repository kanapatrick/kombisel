<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="<c:url value="/modPromotion"><c:param name="action" value="creer_promo" /></c:url>">
	<div class="controls">
		<label for="date" >Date de Fin Promotion : <span class="oblig">*</span></label>
		<input type="date" name="dateFin"  placeholder="yyyy-mm-dd" value="${pro.dateFin}" required /><br/><span class="erreur">${verif.erreurs["dateFin"]}</span><br/>
	</div>	
	<div class="controls">
		<label for="qte" >Réduction : <span class="oblig">*</span></label>
		<input type="number" name="reduction" min="1" max="99" value="${pro.reduction}" placeholder="Pourcentage de réduction" required /><br/><span class="erreur">${verif.erreurs["reduction"]}</span><br/>
	</div>	
	<div class="controls">
		<button type="submit" class="btn btn-success ">Creer<i class="icon-white icon-ok-sign"></i></button><span class="${ !empty rapport ? 'succes':'erreur' }">${verif.resultat}</span>
	</div>		
	</form>																													
</body>
</html>