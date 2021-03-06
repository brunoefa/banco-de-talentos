package br.com.senai.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.senai.dao.CurriculoDao;
import br.com.senai.filter.CurriculoFilter;
import br.com.senai.model.Curriculo;

@WebServlet("/curriculo")
public class CurriculoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Curriculo curriculo;
	private CurriculoDao dao;
       
    public CurriculoServlet() {
    	dao = new CurriculoDao();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String acao = request.getParameter("acao");
		
		if ("salvar".equals(acao)) {
			salvar(request, response);
		} else if ("cadastrar".equals(acao)) {
			cadastrar(request, response);
		} if ("atualizar".equals(acao)) {
			atualizar(request, response);
		} else if ("visualizar".equals(acao)) {
			visualizar(request, response);
		} else if ("editar".equals(acao)) {
			editar(request, response);
		} else if ("excluir".equals(acao)) {
			excluir(request, response);
		} else if ("filtrar".equals(acao)) {
			filtrar(request, response);
		} else {
			listar(request, response);
		}
	}
	
	private void listar(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
		ArrayList<Curriculo> listaCurriculos = dao.buscarTodos();
		request.setAttribute("listaCurriculos", listaCurriculos);
		encaminharRequisicao(request, response, "curriculo-list.jsp");
	}
	
	private void filtrar(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
		CurriculoFilter filtro = capturarFiltros(request, response);
		ArrayList<Curriculo> listaCurriculos = dao.buscar(filtro);
		request.setAttribute("listaCurriculos", listaCurriculos);
		request.setAttribute("filtro", filtro);
		encaminharRequisicao(request, response, "curriculo-list.jsp");
	}
	
	private void cadastrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("acao", "salvar");
		encaminharRequisicao(request, response, "curriculo-form.jsp");
	}
	
	private void visualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String email = request.getParameter("email");
		if (!"".equals(id) && id != null) {
			curriculo = dao.buscarPorId(id);
		} else if (!"".equals(email) && email != null) {
			curriculo = dao.buscarPorEmail(email);
		} else {
			curriculo = dao.buscarPorEmail(curriculo.getEmail());
		}
		request.setAttribute("curriculo", curriculo);
		encaminharRequisicao(request, response, "curriculo-view.jsp");
	}
	
	private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		curriculo = dao.buscarPorId(id);
		request.setAttribute("curriculo", curriculo);
		request.setAttribute("acao", "atualizar");
		encaminharRequisicao(request, response, "curriculo-form.jsp");
	}
	
	private void excluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		dao.excluir(id);
		request.setAttribute("mensagem", "Curriculo exclu�do com sucesso.");
		listar(request, response);
	}
	
	private void salvar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		capturarDados(request, response);
		dao.salvar(curriculo);
		request.setAttribute("mensagem", "Curriculo salvo com sucesso!");
		visualizar(request, response);
	}
	
	private void atualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		capturarDados(request, response);
		dao.atualizar(curriculo);
		request.setAttribute("mensagem", "Curriculo atualizado com sucesso!");
		visualizar(request, response);
	}
	
	private void encaminharRequisicao(HttpServletRequest request, HttpServletResponse response, String destino) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(destino);
		rd.forward(request, response);
	}
	
	private CurriculoFilter capturarFiltros(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
		CurriculoFilter filtro = new CurriculoFilter();
		
		filtro.setNome(request.getParameter("nome"));
		filtro.setEmail(request.getParameter("email"));
		filtro.setCidade(request.getParameter("cidade"));
		filtro.setEstado(request.getParameter("estado"));
		filtro.setOrder(request.getParameter("order"));
		
		return filtro;
	}
	
	private void capturarDados(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
		curriculo = new Curriculo();

		String sid = request.getParameter("id");
		if (!"".equals(sid) && sid != null) {
			curriculo.setId(Integer.parseInt(sid));
		}
		
		curriculo.setNome(request.getParameter("nome"));
		curriculo.setEmail(request.getParameter("email"));
		curriculo.setCidade(request.getParameter("cidade"));
		curriculo.setEstado(request.getParameter("estado"));
		curriculo.setResumo(request.getParameter("resumo"));
		
		curriculo.setTitulo1(request.getParameter("titulo1"));
		curriculo.setInstituicao1(request.getParameter("instituicao1"));
		curriculo.setConclusao1(request.getParameter("conclusao1"));
		
		curriculo.setTitulo2(request.getParameter("titulo2"));
		curriculo.setInstituicao2(request.getParameter("instituicao2"));
		curriculo.setConclusao2(request.getParameter("conclusao2"));
		
		curriculo.setTitulo3(request.getParameter("titulo3"));
		curriculo.setInstituicao3(request.getParameter("instituicao3"));
		curriculo.setConclusao3(request.getParameter("conclusao3"));
		
		curriculo.setCargo1(request.getParameter("cargo1"));
		curriculo.setEmpresa1(request.getParameter("empresa1"));
		curriculo.setEntrada1(request.getParameter("entrada1"));
		curriculo.setSaida1(request.getParameter("saida1"));
		curriculo.setDescricao1(request.getParameter("descricao1"));
		
		curriculo.setCargo2(request.getParameter("cargo2"));
		curriculo.setEmpresa2(request.getParameter("empresa2"));
		curriculo.setEntrada2(request.getParameter("entrada2"));
		curriculo.setSaida2(request.getParameter("saida2"));
		curriculo.setDescricao2(request.getParameter("descricao2"));
		
		curriculo.setCargo3(request.getParameter("cargo3"));
		curriculo.setEmpresa3(request.getParameter("empresa3"));
		curriculo.setEntrada3(request.getParameter("entrada3"));
		curriculo.setSaida3(request.getParameter("saida3"));
		curriculo.setDescricao3(request.getParameter("descricao3"));
	}
}
