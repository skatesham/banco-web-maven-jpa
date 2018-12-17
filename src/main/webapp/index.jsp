
<%@ include file="/static/base/header.jsp"%>

<%@ include file="/static/base/navbar.jsp"%>

<div class="container text-center">
	<div class="jumbotron jumbotron-fluid">
		<div class="container">
			<h1 class="display-4">Bem Vindo ao Web APP</h1>
			<p class="lead">Esse é um servidor web com Jetty que utiliza o
				maven para como Controle de dependencias e automatizador de
				contrução</p>
		</div>
	</div>
</div>

<form action="/execute?task=Home" method="post">
	<input type="submit" value="Home">
</form>

<%@ include file="/static/base/footer.jsp"%>