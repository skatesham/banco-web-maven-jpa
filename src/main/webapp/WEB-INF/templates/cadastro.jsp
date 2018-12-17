
<%@ include file="/static/base/header.jsp"%>

<nav class="navbar navbar-expand-lg navbar-dark fixed-top bg-dark">
	<a class="navbar-brand" href="/login">Banco Sham</a>
</nav>
<br>
<br>
<br>

<div class="container text-center">
	<div class="jumbotron jumbotron-fluid bg-dark text-light">
		<div class="container">
			<h1 class="display-4">Cadastro de Conta</h1>
			<p class="lead">Ao cadastrar uma Conta no Banco Sham é criada
				automaticamente.</p>
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
						<h4 class='card-title'>Cadastro</h4>
						<form action="/cadastro" method="post">

							<div class='form-group'>
								<label for='usuario'>Nome de Usuário</label> <input id='usuario'
									type='text' class='form-control' name='usuario' value=''
									required autofocus>
							</div>

							<div class='form-group'>
								<label for='email'>Email</label> <input id='email'
									type='email' class='form-control' name='email' value=''
									required>
							</div>

							<div class='form-group'>
								<label for='endereco'>Endereço</label> <input id='endereco'
									type='text' class='form-control' name='endereco' value=''
									required>
							</div>

							<div class='form-group'>
								<label for='password'>Senha <br>
								</label> <input id='password' type='password' class='form-control'
									name='password' required data-eye>
							</div>

							<c:if test="${erro == true}">
								<div class="alert alert-danger">Erro ao tentar fazer cadastro</div>
							</c:if>
							<div class='form-group no-margin'>
								<button type='submit' class='btn btn-primary btn-block'>
									Cadastrar</button>
							</div>
							<div class='margin-top20 text-center'>
								Já possui uma conta? <a href="/login">Login</a>
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