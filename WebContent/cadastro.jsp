<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="titulo.jsp" >
	<jsp:param name="titulo" value="Seja bem-vindo"/>
	<jsp:param name="descricao" value="Não perca tempo, faça seu cadastro agora.<br />Faça parte de um banco talentos de verdade."/>
</jsp:include>

    <div class="container">
	
	<!-- alert-danger / success / hide -->
	
	<div class="alert alert-${status} alert-dismissible fade in" role="alert">
		<button type="button" class="close" data-dismiss="alert" aria-label="Close"> <span aria-hidden="true">×</span>
		</button>
		${mensagem}
	</div>

	<c:if test="${sessionScope.usuario != null}">
		<h2> Você está logado como ${sessionScope.usuario.email}.</h2>
		<a href="usuario?acao=sair" class="btn btn-danger btn-lg" id="navbar-logout">Clique para sair</a>
	</c:if>

	<c:if test="${sessionScope.usuario == null}">
		<!-- Example row of columns -->
      	<form action="usuario" method="post" >
      		<input type="hidden" name="acao" value="salvar">
			<div class="row">
				<div class="form-group col-md-6" >
					<label for="nome">Nome</label>
					<input required="required" type="text" name="nome" class="form-control" id="nome" placeholder="informe seu nome">
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-6" >
					<label for="email">E-mail</label>
					<input required="required" type="text" name="email" class="form-control" id="email" placeholder="informe seu e-mail">
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-6">
					<label for="senha">Senha</label>
					<input required="required" type="password" name="senha" class="form-control" id="senha" placeholder="Informe sua senha">
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-12 form-inline">
					<div class="radio">
						<label> <input type="radio" name="tipo" value="candidato" checked> Sou um candidato</label>
					</div>
					<span>&nbsp;</span>
					<div class="radio">
						<label> <input type="radio" name="tipo" value="empresa"> Sou uma empresa </label>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<a href="usuario?acao=login" >Já possui usuário, faça login!</a><br />
				</div>
			</div>
			<hr>
			<div class="row">
				<div class="col-md-12">
					<input type="submit" class="btn btn-success btn-lg" value="Cadastrar">
					<a href="curriculo" class="btn btn-default btn-lg">Cancelar</a>
				</div>
			</div>
		</form>
		</c:if>
      <hr>
    </div>
<jsp:include page="rodape.jsp" />    