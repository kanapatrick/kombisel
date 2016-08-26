<c:import url="/template/enteteAcc.jsp" />
<body>
	<form method="post" action="<c:url value="/index" /> ">
		<label for="pseudo"><c:out value="Pseudo" /></label>
		<input type="text" name="pseudo" required>
		<label for="passwd"><c:out value="Password" /></label>
		<input type="password" name="passwd" required>
		
		<input type="submit" value="Se connecter" required>			
	</form>
	<a href="<c:url value="/inscription" />">Creer Compte</a>
	
<c:import url="/template/footer.jsp" />
</body>
</html>