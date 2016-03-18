<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<jsp:include page="titulo.jsp" >
	<jsp:param name="titulo" value="Cadastro de Curriculo"/>
	<jsp:param name="descricao" value="Não perca tempo, cadastre seu currículo e mostre ao mercado de trabalho seu potencial.<br />Faça parte de um banco talentos de verdade."/>
</jsp:include>

    <div class="container">
      <!-- Example row of columns -->
      <form action="curriculo" method="post" >
      <input type="hidden" name="acao" value="salvar">
			<div class="row">
				<div class="col-md-12">
					<h2>Informações Básicas</h2>
					<div class="form-group col-md-12" >
						<label for="nome">Nome completo</label>
						<input type="text" name="nome" class="form-control" id="nome" placeholder="Nome">
					</div>
				</div>
				<div class="col-md-12">
					<div class="form-group col-md-6">
						<label for="cidade">Cidade</label>
						<input type="text" name="cidade" class="form-control" id="cidade" placeholder="Cidade">
					</div>
					<div class="form-group col-md-6">
						<label for="estado">Estado</label>
						<input type="text" name="estado" class="form-control" id="estado" placeholder="Estado">
					</div>
				</div>
				<div class="col-md-12">
					<div class="form-group col-md-12">
						<label for="resumo">Resumo</label> 
						<input type="text" name="resumo" class="form-control" id="resumo" placeholder="Resuma seu perfil profissional em uma frase">
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-md-12">
					<h2>Formação Acadêmica</h2>
					<div class="form-group col-md-5">
						<label for="titulo1">Formação 1</label>
						<input type="text" name="titulo1" class="form-control" id="titulo1" placeholder="Título">
					</div>
					<div class="form-group col-md-5">
						<label for="instituicao1">Instituição</label>
						<input type="text" name="instituicao1" class="form-control" id="instituicao1" placeholder="Onde você estudou?">
					</div>
					<div class="form-group col-md-2">
						<label for="conclusao1">Conclusão</label>
						<input type="text" name="conclusao1" class="form-control" id="conclusao1" placeholder="Informe o ano">
					</div>
				</div>
				<div class="col-md-12">
					<div class="form-group col-md-5">
						<label for="titulo2">Formação 2</label>
						<input type="text" name="titulo2" class="form-control" id="titulo2" placeholder="Título">
					</div>
					<div class="form-group col-md-5">
						<label for="instituicao2">Instituição</label>
						<input type="text" name="instituicao2" class="form-control" id="instituicao2" placeholder="Onde você estudou?">
					</div>
					<div class="form-group col-md-2">
						<label for="conclusao2">Conclusão</label>
						<input type="text" name="conclusao2" class="form-control" id="conclusao2" placeholder="Informe o ano">
					</div>
				</div>
				<div class="col-md-12">
					<div class="form-group col-md-5">
						<label for="titulo3">Formação 3</label>
						<input type="text" name="titulo3" class="form-control" id="titulo3" placeholder="Título">
					</div>
					<div class="form-group col-md-5">
						<label for="instituicao3">Instituição</label>
						<input type="text" name="instituicao3" class="form-control" id="instituicao3" placeholder="Onde você estudou?">
					</div>
					<div class="form-group col-md-2">
						<label for="conclusao3">Conclusão</label>
						<input type="text" name="conclusao3" class="form-control" id="conclusao3" placeholder="Informe o ano">
					</div>
				</div>
			</div>
			
			<div class="row">
				<div class="col-md-12">
					<h2>Experiência Profissional</h2>
					<div class="form-group col-md-6">
						<label for="cargo1">Experiência 1</label>
						<input type="text" name="cargo1" class="form-control" id="cargo1" placeholder="Cargo">
					</div>
					<div class="form-group col-md-6">
						<label for="empresa1">Empresa</label>
						<input type="text" name="empresa1" class="form-control" id="empresa1" placeholder="Empresa">
					</div>
				</div>
				<div class="col-md-12">
					<div class="form-group col-md-8">
						<label for="descricao1">Descrição</label>
						<input type="text" name="descricao1" class="form-control" id="descricao1" placeholder="Descrição">
					</div>
					<div class="form-group col-md-2">
						<label for="entrada1">Entrada</label>
						<input type="text" name="entrada1" class="form-control" id="entrada1" placeholder="Entrada">
					</div>
					<div class="form-group col-md-2">
						<label for="saida1">Saída</label>
						<input type="text" name="saida1" class="form-control" id="saida1" placeholder="Saída">
					</div>
				</div>
				<div class="col-md-12">
					<div class="form-group col-md-6">
						<label for="cargo2">Experiência 2</label>
						<input type="text" name="cargo2" class="form-control" id="cargo2" placeholder="Cargo">
					</div>
					<div class="form-group col-md-6">
						<label for="empresa2">Empresa</label>
						<input type="text" name="empresa2" class="form-control" id="empresa2" placeholder="Empresa">
					</div>
				</div>
				<div class="col-md-12">
					<div class="form-group col-md-8">
						<label for="descricao2">Descrição</label>
						<input type="text" name="descricao2" class="form-control" id="descricao2" placeholder="Descrição">
					</div>
					<div class="form-group col-md-2">
						<label for="entrada2">Entrada</label>
						<input type="text" name="entrada2" class="form-control" id="entrada2" placeholder="Entrada">
					</div>
					<div class="form-group col-md-2">
						<label for="saida2">Saída</label>
						<input type="text" name="saida2" class="form-control" id="saida2" placeholder="Saída">
					</div>
				</div>
				<div class="col-md-12">
					<div class="form-group col-md-6">
						<label for="cargo3">Experiência 3</label>
						<input type="text"  name="cargo3"  class="form-control" id="cargo3" placeholder="Cargo">
					</div>
					<div class="form-group col-md-6">
						<label for="empresa3">Empresa</label>
						<input type="text" name="empresa3" class="form-control" id="empresa3" placeholder="Empresa">
					</div>
				</div>
				<div class="col-md-12">
					<div class="form-group col-md-8">
						<label for="descricao3">Descrição</label>
						<input type="text" name="descricao3" class="form-control" id="descricao3" placeholder="Descrição">
					</div>
					<div class="form-group col-md-2">
						<label for="entrada3">Entrada</label>
						<input type="text" name="entrada3" class="form-control" id="entrada3" placeholder="Entrada">
					</div>
					<div class="form-group col-md-2">
						<label for="saida3">Saída</label>
						<input type="text" name="saida3" class="form-control" id="saida3" placeholder="Saída">
					</div>
				</div>
			</div>
			<hr>
			<div class="row">
				<div class="col-md-12">
				<input type="submit" class="btn btn-success btn-lg" value="Salvar currículo">
				<a href="#" class="btn btn-default btn-lg">Cancelar</a>
				</div>
			</div>
		</form>
      <hr>
    </div> <!-- /container -->
<jsp:include page="rodape.jsp" />    