
<%@ include file="/static/base/header.jsp"%>

<nav class="navbar navbar-expand-lg navbar-dark fixed-top bg-dark">
	<a class="navbar-brand" href="#">Banco Sham</a>
</nav>
<br>
<br>
<br>

<div class="container text-center">
	<div class="jumbotron jumbotron-fluid bg-dark text-light">
		<div class="container">
			<h1 class="display-4">Bem Vindo ao Banco Sham</h1>
			<p class="lead">O banco te fornece uma conta para gerenciar seus
				recursos financeiros. Para entrar na conta relize o login, se não
				possui uma conta ainda crie agora mesmo!</p>
		</div>
	</div>
</div>

<a href="/login" class="text-center"><h1>LOGIN</h1></a>

<form action="/execute?task=Home" method="post">
	<input type="submit" value="Home">
</form>

<%@ include file="/static/base/footer.jsp"%>