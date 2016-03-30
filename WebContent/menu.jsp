<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<nav class="navbar navbar-inverse navbar-fixed-top"><div class="container"> <div class="navbar-header">
  <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
    <span class="sr-only">Toggle navigation</span>
    <span class="icon-bar"></span>
    <span class="icon-bar"></span>
    <span class="icon-bar"></span>
  </button>
     <a class="navbar-brand">Banco de Talenos</a>
   </div>
   <span class="navbar-user navbar-right">${sessionScope.usuario.email} <a href="usuario?acao=sair" id="navbar-logout">(sair)</a></span>
   <div id="navbar" class="navbar-collapse collapse">
     <form class="navbar-form navbar-right" action="usuario" method="post">
       <input type="hidden" name="acao" value="logar">
       <div class="form-group">
         <input type="text" name="email" placeholder="Email" class="form-control">
       </div>
       <div class="form-group">
         <input type="password" name="senha" placeholder="Senha" class="form-control">
       </div>
       <button type="submit" class="btn btn-success">Entrar</button>
     </form></div></div></nav>