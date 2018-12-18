<%@page import="br.sham.web.banco.api.model.Conta"%>
<%@page import="br.sham.web.banco.api.model.Usuario"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="/static/base/header.jsp"%>

<%@ include file="/static/base/navbar.jsp"%>

<%
	Usuario usuario = (Usuario) request.getAttribute("usuario");
	Conta conta = usuario.getConta();
%>

<div class="container">
	<h1 class="text-center card m-2">Minha Conta</h1>
	<div class="mt-2 mb-2">
		<table class="table text-light bg-dark">
			<thead>
				<tr>
					<td>Banco</td>
					<td>Agencia</td>
					<td>Conta</td>
					<td>Saldo</td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th><%=conta.getBanco()%></th>
					<th><%=conta.getAgencia()%></th>
					<th><%=conta.getNumero()+"-0"%></th>
					<th><%=String.format("R$ %,.2f", conta.getSaldo())%></th>
				</tr>
			</tbody>
		</table>
	</div>

	<div class="row text-light">
		<div class="col-sm-6 text-center">
			<h3>Depósito</h3>
			<form>
				<div class="form-group">
					<input class="form-control" type="number">
				</div>
				<input class="btn btn-lg" type="submit" value="Depositar">
			</form>

		</div>

		<div class="col-sm-6 text-center">
			<h3>Saque</h3>
			<form>
				<div class="form-group">
					<input class="form-control" type="number">
				</div>
				<input class="btn btn-lg" type="submit" value="Movimentar">
			</form>




		</div>

	</div>

</div>


<%@ include file="/static/base/footer.jsp"%>