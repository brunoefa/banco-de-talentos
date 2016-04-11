<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  
<form action="vaga" name="formfilter" id="formfilter">
	<input type="hidden" name="acao" value="filtrar">
	<input type="hidden" id="order" name="order" value="${filtro.order}">
	<div class="form-group col-md-6" >
		<label for="titulo">Título</label>
		<input type="text" name="titulo" class="form-control" id="titulo" placeholder="Título da vaga" value="${filtro.titulo}">
	</div>
	<div class="form-group col-md-6" >
		<label for="nome">Empresa</label>
		<input type="text" name="empresa" class="form-control" id="empresa" placeholder="Empresa que oferece a vaga" value="${filtro.empresa}">
	</div>
	
	<div class="form-group col-md-3" >
		<label for="nome">Cidade</label>
		<input type="text" name="cidade" class="form-control" id="cidade" placeholder="Cidade onde o trabalho será realizado" value="${filtro.cidade}">
	</div>
	
	<div class="form-group col-md-3" >
		<label for="nome">Estado</label>
		<input type="text" name="estado" class="form-control" id="estado" placeholder="Estado onde o trabalho será realizado" value="${filtro.estado}">
	</div>
	<div class="form-group col-md-3" >
		<label for="nome">Remuneração</label>
		<div class="input-group">
	      <div class="input-group-addon">R$</div>
	      <input type="text" name="remuneracao-minima" class="form-control" placeholder="Valor mínimo" value="${filtro.remuneracaoMinima}">
	      <div class="input-group-addon">,00</div>
	    </div>
	</div>
	<div class="form-group col-md-3" >
		<label for="nome">&nbsp;</label>
		<div class="input-group">
	      <div class="input-group-addon">R$</div>
	      <input type="text" name="remuneracao-maxima" class="form-control" placeholder="Valor máximo" value="${filtro.remuneracaoMaxima}">
	      <div class="input-group-addon">,00</div>
	    </div>
	</div>
	<div class="col-md-12">
		<button type="submit" class="btn btn-info btn-lg btn-new">Filtrar vagas</button>
		<a href="#" class="btn btn-default btn-lg btn-new" id="btn-close">Cancelar</a>
	</div>	
</form>