<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<jsp:include page="titulo.jsp" >
	<jsp:param name="titulo" value="${vaga.titulo}"/>
	<jsp:param name="descricao" value="${vaga.descricao}"/>
</jsp:include>

    <div class="container">
      <!-- Example row of columns -->
		<div class="row">
			<div class="col-md-12">
				<h1>${vaga.empresa}</h1>
				<div class="col-md-12">
					<h2 class="job-title">${vaga.email}</h2>
					<h2 class="job-title">${vaga.cidade} - ${vaga.estado}</h2>
				</div>
			</div>
		</div>
		<hr>
		<div class="row">
			<div class="col-md-12">
				<h1>Formação acadêmica</h1>
				<div class="col-md-12">
					<h2 class="job-title">${vaga.formacao}</h2>
				</div>
			</div>
			<div class="col-md-12">
				<h1>Remuneração</h1>
				<div class="col-md-12">
					<h2 class="job-title">R$ ${vaga.remuneracao}</h2>
				</div>
			</div>
		</div>
      	<hr>
	<div class="row">
		<div class="col-md-12">
			<a href="vaga?acao=excluir&id=${vaga.id}" class="btn btn-danger btn-lg">Excluir vaga</a>
			<a href="vaga?acao=editar&id=${vaga.id}" class="btn btn-info btn-lg">Editar vaga</a>
		</div>
	</div>
<hr>
</div> <!-- /container -->
    
<jsp:include page="rodape.jsp" />