<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  
<form action="curriculo" name="formfilter" id="formfilter">
	<input type="hidden" name="acao" value="filtrar">
	<input type="hidden" name="order" id="order" value="${filtro.order}">
	<div class="form-group col-md-6" >
		<label for="nome">Nome</label>
		<input type="text" name="nome" class="form-control" id="nome" placeholder="Nome do candidato" value="${filtro.nome}">
	</div>
	<div class="form-group col-md-6" >
		<label for="email">E-mail</label>
		<input type="text" name="email" class="form-control" id="email" placeholder="E-mail do candidato" value="${filtro.email}">
	</div>
	
	<div class="form-group col-md-6" >
		<label for="nome">Cidade</label>
		<input type="text" name="cidade" class="form-control" id="cidade" placeholder="Cidade onde o trabalho será realizado" value="${filtro.cidade}">
	</div>
	
	<div class="form-group col-md-6" >
		<label for="nome">Estado</label>
		<input type="text" name="estado" class="form-control" id="estado" placeholder="Estado onde o trabalho será realizado" value="${filtro.estado}">
	</div>
	<div class="col-md-12">
		<button type="submit" class="btn btn-info btn-lg btn-new">Filtrar curriculos</button>
		<a href="#" class="btn btn-default btn-lg btn-new" id="btn-close">Cancelar</a>
	</div>	
</form>