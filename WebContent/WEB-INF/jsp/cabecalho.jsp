<nav class="navbar navbar-default">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#main-navbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="/Encomenda">Encomenda-Web</a>
		</div>

		<div class="collapse navbar-collapse" id="main-navbar">
			<ul class="nav navbar-nav navbar-right">
				<li
					class="dropdown ${pageConfig.activeMenu eq 'cliente' ? 'active': ''}"><a
					href="#" class="dropdown-toggle" data-toggle="dropdown">
						Clientes <span class="glyphicon glyphicon-user"></span> <span
						class="caret"></span>
				</a>
					<ul class="dropdown-menu dropdown-menu-right">
						<li><a href="/Encomenda/cliente?action=Lista"><span
								class="glyphicon glyphicon-th-list"></span> Lista de Clientes</a></li>
						<li><a href="/Encomenda/cliente?action=Novo"><span
								class="glyphicon glyphicon-certificate"></span> Novo Cliente</a></li>
					</ul></li>

				<li
					class="dropdown ${pageConfig.activeMenu eq 'encomenda' ? 'active': ''}"><a
					href="#" class="dropdown-toggle" data-toggle="dropdown">Encomendas
						<span class="glyphicon glyphicon-shopping-cart"></span> <span
						class="caret"></span>
				</a>
					<ul class="dropdown-menu dropdown-menu-right">
						<li><a href="/encomenda"><span
								class="glyphicon glyphicon-th-list"></span> Lista de Encomenda</a></li>
						<li><a href="/encomenda?logica=new"><span
								class="glyphicon glyphicon-certificate"></span> Nova Encomenda</a></li>
					</ul></li>

				<li
					class="dropdown ${pageConfig.activeMenu eq 'produto' ? 'active': ''}"><a
					href="#" class="dropdown-toggle" data-toggle="dropdown">Produtos
						<span class="glyphicon glyphicon-barcode"> <span
							class="caret"></span></span>
				</a>
					<ul class="dropdown-menu dropdown-menu-right">
						<li><a href="/produto"><span
								class="glyphicon glyphicon-th-list"></span> Lista de Produto</a></li>
						<li><a href="/produto?logic=new"><span
								class="glyphicon glyphicon-certificate"></span> Novo Produto</a>
					</ul></li>
			</ul>
		</div>
	</div>
</nav>