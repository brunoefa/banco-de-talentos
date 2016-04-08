package br.com.senai.servlet;

import java.io.IOException;
import java.sql.SQLException;

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
		} else if ("cadastrar".equals(acao)) {
			cadastrar(request, response);
		} else if ("salvar".equals(acao)) {
			salvar(request, response);
		} else {
			mostrarLogin(request, response);
		}
	}
	
	private void cadastrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("status", "hide");
		encaminharRequisicao(request, response, "cadastro.jsp");
	}
	
	private void salvar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			Usuario usuario = capturarDados(request, response);
			dao.salvar(usuario);
			request.getSession().setAttribute("usuario", usuario);
			String destino = "candidato".equals(usuario.getTipo()) ? "vaga" : "curriculo";
			response.sendRedirect(destino);
		} catch (SQLException e) {
			if (e.getMessage().contains("email_UNIQUE")) {
				request.setAttribute("mensagem", "Ops! Este e-mail já está sendo usado no sistema.");
				request.setAttribute("status", "danger");
				encaminharRequisicao(request, response, "cadastro.jsp");
			} else {
				System.out.println(e.getMessage());
				throw new RuntimeException();
			}
		}
	}

	private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().invalidate();
		encaminharRequisicao(request, response, "login.jsp");
	}

	private void logar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario u = capturarDados(request, response);
		
		Usuario usuario = dao.buscarPorEmail(u.getEmail());
		String destino = "login.jsp";
		
		if (usuario.getSenha() != null) {
			if (usuario.getSenha().equals(u.getSenha())) {
				request.getSession().setAttribute("usuario", usuario);
				destino = "candidato".equals(usuario.getTipo()) ? "vaga" : "curriculo";
				response.sendRedirect(destino);
				return;
			}
		} else {
			request.setAttribute("mensagem", "Login ou senha inválidos!");
			request.setAttribute("status", "danger");
			encaminharRequisicao(request, response, "login.jsp");
		}
	}

	private void mostrarLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("status", "hide");
		encaminharRequisicao(request, response, "login.jsp");
	}
	
	private void encaminharRequisicao(HttpServletRequest request, HttpServletResponse response, String destino) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(destino);
		rd.forward(request, response);
	}
	
	private Usuario capturarDados(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
		Usuario usuario = new Usuario();

		usuario.setNome(request.getParameter("nome"));
		usuario.setEmail(request.getParameter("email"));
		usuario.setSenha(request.getParameter("senha"));
		usuario.setTipo(request.getParameter("tipo"));
		
		return usuario;
	}
}
