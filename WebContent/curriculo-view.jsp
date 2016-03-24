<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<jsp:include page="titulo.jsp" >
	<jsp:param name="titulo" value="${curriculo.nome}"/>
	<jsp:param name="descricao" value="${curriculo.resumo}"/>
</jsp:include>

    <div class="container">
      <!-- Example row of columns -->
		<div class="row">
			<div class="col-md-12">
				<h1>Informações Pessoais</h1>
				<div class="col-md-12">
					<h2 class="job-title">${curriculo.email}</h2>
					<h3 class="subtitle">${curriculo.cidade} - ${curriculo.estado}</h3>
				</div>
			</div>
		</div>
		<hr>
		<div class="row">
			<div class="col-md-12">
				<h1>Formação Acadêmica</h1>
				<div class="col-md-12">
					<h2 class="job-title">${curriculo.titulo1}</h2>
					<h3 class="subtitle">${curriculo.instituicao1} - Concluido em ${curriculo.conclusao1}</h3>
					<hr>
					
					<h2 class="job-title">${curriculo.titulo2}</h2>
					<h3 class="subtitle">${curriculo.instituicao2} - Concluido em ${curriculo.conclusao2}</h3>
					<hr>
					
					<h2 class="job-title">${curriculo.titulo3}</h2>
					<h3 class="subtitle">${curriculo.instituicao3} - Concluido em ${curriculo.conclusao3}</h3>
				</div>
			</div>
		</div>
		<hr>
		<div class="row">
			<div class="col-md-12">
				<h1>Experiência Profissional</h1>
				<div class="col-md-12">
					<h2 class="job-title">${curriculo.cargo1}</h2>
					<h3 class="subtitle">${curriculo.empresa1} - De ${curriculo.entrada1} a ${curriculo.saida1}</h3>
					<p class="job-desc">${curriculo.descricao1}</p>
					<hr>
									
					<h2 class="job-title">${curriculo.cargo2}</h2>
					<h3 class="subtitle">${curriculo.empresa2} - De ${curriculo.entrada2} a ${curriculo.saida2}</h3>
					<p class="job-desc">${curriculo.descricao2}</p>
					<hr>
					
					<h2 class="job-title">${curriculo.cargo3}</h2>
					<h3 class="subtitle">${curriculo.empresa3} - De ${curriculo.entrada3} a ${curriculo.saida3}</h3>
					<p class="job-desc">${curriculo.descricao3}</p>

				</div>
			</div>
		</div>
      	<hr>
	<div class="row">
		<div class="col-md-12">
			<a href="curriculo?acao=excluir&id=${curriculo.id}" class="btn btn-danger btn-lg">Excluir Curriculo</a>
			<a href="curriculo?acao=editar&id=${curriculo.id}" class="btn btn-info btn-lg">Editar Curriculo</a>
		</div>
	</div>
<hr>
</div> <!-- /container -->
    
<jsp:include page="rodape.jsp" />