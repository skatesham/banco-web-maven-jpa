
<%@ include file="/static/base/header.jsp"%>

<nav class="navbar navbar-expand-lg navbar-dark fixed-top bg-dark">
	<a class="navbar-brand" href="/cadastro">Banco Sham</a>
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

<!--  LOGIN -->
<div class='my-login-page text-center'>
	<div class='container h-100'>
		<div class='row justify-content-center h-100'>
			<div class='card-wrapper'>
				<div class='card fat'>
					<div class='card-body'>
						<h4 class='card-title'>Login</h4>
						<form action="/login" method="post">

							<div class='form-group'>
								<label for='email'>Nome de Usuário</label> <input id='usuario'
									type='text' class='form-control' name='usuario' value=''
									required autofocus>
							</div>

							<div class='form-group'>
								<label for='password'>Senha <br>
								</label> <input id='password' type='password' class='form-control'
									name='password' required data-eye>
							</div>
							<c:if test="${erro}">
								<div class="alert alert-danger">Erro ao tentar fazer login</div>
							</c:if>
							<div class='form-group no-margin'>
								<button type='submit' class='btn btn-primary btn-block'>
									Login</button>
							</div>
							<div class='margin-top20 text-center'>
								Não possui uma conta? <a href="/cadastro">Criar uma conta</a>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<br>
</div>
<br>
<!--  Login Close -->

<%@ include file="/static/base/footer.jsp"%>