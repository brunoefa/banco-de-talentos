<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="titulo.jsp" >
	<jsp:param name="titulo" value="Listagem de vagas"/>
	<jsp:param name="descricao" value="Encontre a vaga certa para seu futuro profissional."/>
</jsp:include>

<div class="container">
	<div class="row">
		<div class="col-md-12">
			<a href="vaga?acao=cadastrar" class="btn btn-success btn-lg btn-new"><span class="glyphicon glyphicon-plus-sign" aria-hidden="true"></span> Cadastrar nova vaga</a> 
			<button class="btn btn-info btn-lg btn-new" id="filter"><span class="glyphicon glyphicon-filter" aria-hidden="true"></span> Filtrar vagas</button>
			<div class="dropdown order">
				<button class="btn-lg btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true"> Ordenar por <span class="caret"></span> </button>
				<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
					<li><a href="#" class="desc">Maior salário</a></li>
					<li><a href="#" class="asc">Menor salário</a></li>
				</ul>
			</div>
		</div>
		<div class="filter-box">
			<jsp:include page="vaga-filter.jsp" />		
		</div>
	</div>
	<hr />
	<div class="row">
		<div class="col-md-12">
			<c:forEach items="${listaVagas}" var="vaga">
				<h1>${vaga.titulo}</h1>
				<div class="action">
				<a href="vaga?acao=editar&id=${vaga.id}"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a>
				<a href="vaga?acao=excluir&id=${vaga.id}"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a>
				<a href="vaga?acao=visualizar&id=${vaga.id}"><span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span></a>
				</div>
				<h3 class="subtitle">${vaga.empresa} - ${vaga.cidade} - ${vaga.estado}</h3>
				<h3 class="subtitle"><fmt:formatNumber value="${vaga.remuneracao}" type="currency" /></h3>
				<hr>
			</c:forEach>
		</div>
	</div>    


</div>   
<jsp:include page="rodape.jsp" />
  