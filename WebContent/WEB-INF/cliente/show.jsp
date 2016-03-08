<div class="container">
	<div class="row">
		<div class="col-sm-offset-2 col-sm-2">
			<p class="text-right text-primary">
				Id <span class="glyphicon glyphicon-option-vertical"></span> :
			</p>
		</div>
		<div class="col-sm-6">${cliente.id}</div>
	</div>

	<div class="row">
		<div class="col-sm-offset-2 col-sm-2">
			<p class="text-right text-primary">
				Nome <span class="glyphicon glyphicon-user"></span> :
			</p>
		</div>
		<div class="col-sm-6">${cliente.nome}</div>
	</div>

	<div class="row">
		<div class="col-sm-offset-2 col-sm-2">
			<p class="text-right text-primary">
				Email <span class="glyphicon glyphicon-envelope"></span> :
			</p>
		</div>
		<div class="col-sm-6">${cliente.email}</div>
	</div>

	<div class="row">
		<div class="col-sm-offset-2 col-sm-2">
			<p class="text-right text-primary">
				Telefone <span class="glyphicon glyphicon-phone-alt"></span> :
			</p>
		</div>
		<div class="col-sm-6">${cliente.telefone}</div>
	</div>
</div>

<div class="btn-group btn-control">
	<a href="/Encomenda/cliente?action=Alterar?id=${cliente.id}"
		class="btn btn-primary">Alterar</a> <a
		href="/Encomenda/cliente?action=Deletar" class="btn btn-primary">Deletar</a>
</div>

