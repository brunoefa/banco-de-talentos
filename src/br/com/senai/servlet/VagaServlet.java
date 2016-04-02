package br.com.senai.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.senai.dao.VagaDao;
import br.com.senai.model.Vaga;

@WebServlet("/vaga")
public class VagaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Vaga vaga;
	private VagaDao dao;
       
    public VagaServlet() {
    	dao = new VagaDao();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String acao = request.getParameter("acao");
		
		if ("salvar".equals(acao)) {
			salvar(request, response);
		} if ("atualizar".equals(acao)) {
			atualizar(request, response);
		} else if ("visualizar".equals(acao)) {
			visualizar(request, response);
		} else if ("editar".equals(acao)) {
			editar(request, response);
		} else if ("excluir".equals(acao)) {
			excluir(request, response);
		} else if ("cadastrar".equals(acao)) {
			cadastrar(request, response);
		} else {
			listar(request, response);
		}
	}
	
	private void listar(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
		ArrayList<Vaga> listaVagas = dao.buscarTodos();
		request.setAttribute("listaVagas", listaVagas);
		encaminharRequisicao(request, response, "vaga-list.jsp");
	}

	private void cadastrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("acao", "salvar");
		encaminharRequisicao(request, response, "vaga-form.jsp");
	}
	
	private void visualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		if (email != null) {
			vaga = dao.buscarPorEmail(email);
		} else {
			vaga = dao.buscarPorEmail(vaga.getEmail());
		}
		request.setAttribute("vaga", vaga);
		encaminharRequisicao(request, response, "vaga-view.jsp");
	}
	
	private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		vaga = dao.buscarPorId(id);
		request.setAttribute("vaga", vaga);
		request.setAttribute("acao", "atualizar");
		encaminharRequisicao(request, response, "vaga-form.jsp");
	}
	
	private void excluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		dao.excluir(id);
		request.setAttribute("mensagem", "Vaga excluída com sucesso.");
		cadastrar(request, response);
	}
	
	private void salvar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		capturarDados(request, response);
		dao.salvar(vaga);
		request.setAttribute("mensagem", "Vaga salva com sucesso!");
		visualizar(request, response);
	}
	
	private void atualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		capturarDados(request, response);
		dao.atualizar(vaga);
		request.setAttribute("mensagem", "Vaga atualizada com sucesso!");
		visualizar(request, response);
	}
	
	private void encaminharRequisicao(HttpServletRequest request, HttpServletResponse response, String destino) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(destino);
		rd.forward(request, response);
	}
	
	private void capturarDados(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
		vaga = new Vaga();

		String sid = request.getParameter("id");
		if (!"".equals(sid) && sid != null) {
			vaga.setId(Integer.parseInt(sid));
		}
		
		vaga.setTitulo(request.getParameter("titulo"));
		vaga.setEmpresa(request.getParameter("empresa"));
		vaga.setEmail(request.getParameter("email"));
		vaga.setDescricao(request.getParameter("descricao"));
		vaga.setFormacao(request.getParameter("formacao"));
		vaga.setCidade(request.getParameter("cidade"));
		vaga.setEstado(request.getParameter("estado"));

		String sremuneracao = request.getParameter("remuneracao");
		if (!"".equals(sremuneracao) && sremuneracao != null) {
			vaga.setRemuneracao(Double.parseDouble(sremuneracao.replace(",", ".")));
		}
	}
}
