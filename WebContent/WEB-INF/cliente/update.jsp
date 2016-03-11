
<form class="form-horizontal" role="form" action="cliente?action=Save&id=${cliente.id}"
	method="POST">
	<div class="form-group">
		<label class="control-label col-sm-2" for="nome">Nome <span
			class="glyphicon glyphicon-user"></span></label>
		<div class="col-sm-6">
			<input id="nome" class="form-control" name="nome" value="${cliente.nome}">
		</div>
	</div>

	<div class="form-group">
		<label class="control-label col-sm-2" for="email">Email <span
			class="glyphicon glyphicon-envelope"></span></label>
		<div class="col-sm-6">
			<input class="form-control" id="email" type="email" name="email" value="${cliente.email}">
		</div>
	</div>

	<div class="form-group">
		<label class="control-label col-sm-2" for="telefone">Telefone
			<span class="glyphicon glyphicon-phone-alt"></span>
		</label>
		<div class="col-sm-6">
			<input type="tel" class="form-control" id="telefone" name="telefone" value="${cliente.telefone}">
		</div>
	</div>

	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<input type="submit" class="btn-primary btn">
		</div>
	</div>
</form>