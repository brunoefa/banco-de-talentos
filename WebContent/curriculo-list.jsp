<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="titulo.jsp" >
	<jsp:param name="titulo" value="Listagem de curriculos"/>
	<jsp:param name="descricao" value="Encontre o curriculo ideal para sua vaga."/>
</jsp:include>

<div class="container">
	<div class="row">
		<div class="col-md-12">
		<a href="curriculo?acao=cadastrar" class="btn btn-success btn-lg btn-new"><span class="glyphicon glyphicon-plus-sign" aria-hidden="true"></span> Cadastrar novo curriculo</a> 
		<button class="btn btn-info btn-lg btn-new" id="filter"><span class="glyphicon glyphicon-filter" aria-hidden="true"></span> Filtrar curriculos</button>
		<div class="dropdown order">
			<button class="btn-lg btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true"> Ordenar por <span class="caret"></span> </button>
			<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
				<li><a href="#" class="asc">Nome de A-Z</a></li>
				<li><a href="#" class="desc">Nome de Z-A</a></li>
			</ul>
		</div>
		</div>
		<div class="filter-box">
			<jsp:include page="curriculo-filter.jsp" />		
		</div>
	</div>
	<hr />
	<div class="row">
		<div class="col-md-12">
			<c:forEach items="${listaCurriculos}" var="curriculo">
				<h1>${curriculo.nome}</h1>
				<div class="action">
				<a href="curriculo?acao=editar&id=${curriculo.id}"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a>
				<a href="curriculo?acao=excluir&id=${curriculo.id}"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a>
				<a href="curriculo?acao=visualizar&id=${curriculo.id}"><span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span></a>
				</div>
				<h3 class="subtitle">${curriculo.resumo}</h3>
				<h3 class="subtitle">${curriculo.cidade} - ${curriculo.estado}</h3>
				<hr>
			</c:forEach>
		</div>
	</div>    


</div>   
<jsp:include page="rodape.jsp" />
  