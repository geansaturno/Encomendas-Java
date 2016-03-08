<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<table class="table table-striped well well-lg">
	<thead>
		<tr>
			<th>Id <span class="glyphicon glyphicon-option-vertical"></span></th>
			<th>Nome <span class="glyphicon glyphicon-user"></span></th>
			<th>Email <span class="glyphicon glyphicon-envelope"></span></th>
			<th>Telefone <span class="glyphicon glyphicon-phone-alt"></span></th>
		</tr>
	</thead>
	<tbody>

		<c:forEach var="cliente" items="${clientes}">
			<tr>
				<td><a href="/Encomenda/cliente?action=Mostrar&id=${cliente.id}">${cliente.id}</a></td>
				<td>${cliente.nome }</td>
				<td>${cliente.email }</td>
				<td>${cliente.telefone }</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</div>


















</html>