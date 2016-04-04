<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="titulo.jsp" >
	<jsp:param name="titulo" value="Cadastro de Vaga"/>
	<jsp:param name="descricao" value="Não perca tempo, cadastre sua vaga e tenha acesso aos melhores candidatos para sua empresa.<br />Faça parte de um banco talentos de verdade."/>
</jsp:include>

    <div class="container">
      <!-- Example row of columns -->
      <form action="vaga" method="post" >
      <input type="hidden" name="acao" value="${acao}">
      <input type="hidden" name="id" value="${vaga.id}">
			<div class="row">
				<div class="col-md-12">
					<h2>Informações sobre a vaga</h2>
					<div class="form-group col-md-12" >
						<label for="titulo">Título</label>
						<input type="text" name="titulo" class="form-control" id="titulo" placeholder="Título da vaga" value="${vaga.titulo}">
					</div>
					<div class="form-group col-md-12" >
						<label for="nome">Descricao</label>
						<input type="text" name="descricao" class="form-control" id="descricao" placeholder="Dê mais informações sobre a vaga" value="${vaga.descricao}">
					</div>
					<div class="form-group col-md-6" >
						<label for="nome">Cidade</label>
						<input type="text" name="cidade" class="form-control" id="cidade" placeholder="Cidade onde o trabalho será realizado" value="${vaga.cidade}">
					</div>
					<div class="form-group col-md-6" >
						<label for="nome">Estado</label>
						<input type="text" name="estado" class="form-control" id="estado" placeholder="Estado onde o trabalho será realizado" value="${vaga.estado}">
					</div>
					<div class="form-group col-md-6" >
						<label for="nome">Empresa</label>
						<input type="text" name="empresa" class="form-control" id="empresa" placeholder="Empresa que oferece a vaga" value="${vaga.empresa}">
					</div>
					<div class="form-group col-md-6" >
						<label for="nome">Formação</label>
						<input type="text" name="formacao" class="form-control" id="formacao" placeholder="Formação acadêmica desejada" value="${vaga.formacao}">
					</div>
					<div class="form-group col-md-6" >
						<label for="nome">E-mail</label>
						<input type="text" name="email" class="form-control" id="nome" placeholder="E-mail para contato" value="${vaga.email}">
					</div>
					<div class="form-group col-md-6" >
						<label for="nome">Remuneração</label>
						<input type="text" name="remuneracao" class="form-control" id="remuneracao" placeholder="Remuneração da vaga" value="${vaga.remuneracao}">
					</div>
				</div>
			</div>
			<hr>
			<div class="row">
				<div class="col-md-12">
				<input type="submit" class="btn btn-success btn-lg" value="Salvar vaga">
				<a href="vaga" class="btn btn-default btn-lg">Cancelar</a>
				</div>
			</div>
		</form>
      <hr>
<jsp:include page="rodape.jsp" />    
    </div>