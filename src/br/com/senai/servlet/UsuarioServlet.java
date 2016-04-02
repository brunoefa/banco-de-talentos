package br.com.senai.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.senai.dao.UsuarioDao;
import br.com.senai.model.Usuario;

@WebServlet("/usuario")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	UsuarioDao dao;
       
    public UsuarioServlet() {
        dao = new UsuarioDao();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String acao = request.getParameter("acao");
		
		if ("logar".equals(acao)) {
			logar(request, response);
		} else if ("sair".equals(acao)) {
			logout(request, response);
		} else {
			mostrarLogin(request, response);
		}
	}

	private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().invalidate();
		encaminharRequisicao(request, response, "login.jsp");
	}

	private void logar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		
		Usuario usuario = dao.buscarPorEmail(email);
		String mensagem = "";
		String status = "hide";
		
		if (usuario.getSenha() != null) {
			if (usuario.getSenha().equals(senha)) {
				mensagem = "Login efetuado com sucesso!";
				status = "success";
				request.getSession().setAttribute("usuario", usuario);
			}
		} else {
			mensagem = "Login ou senha inválidos!";
			status = "danger";
		}
		request.setAttribute("mensagem", mensagem);
		request.setAttribute("status", status);

		encaminharRequisicao(request, response, "login.jsp");
	}

	private void mostrarLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("status", "hide");
		encaminharRequisicao(request, response, "login.jsp");
	}
	
	private void encaminharRequisicao(HttpServletRequest request, HttpServletResponse response, String destino) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(destino);
		rd.forward(request, response);
	}
}
