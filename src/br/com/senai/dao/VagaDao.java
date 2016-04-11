package br.com.senai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.senai.filter.VagaFilter;
import br.com.senai.model.Vaga;

public class VagaDao {
	
	private Connection connection;

	public VagaDao() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public ArrayList<Vaga> buscarTodos() {
		ArrayList<Vaga> listaVagas = new ArrayList<Vaga>();
				
		String sql = "SELECT * FROM vaga";
		try {
			PreparedStatement stm = connection.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				Vaga vaga = new Vaga();
				vaga = preencherVaga(rs);
				listaVagas.add(vaga);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException();
		}
		return listaVagas;
	}
	
	public ArrayList<Vaga> buscar(VagaFilter filtro) {
		ArrayList<Vaga> listaVagas = new ArrayList<Vaga>();
		
		String sql = montarQuery(filtro);
		try {
			PreparedStatement stm = connection.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				Vaga vaga = new Vaga();
				vaga = preencherVaga(rs);
				listaVagas.add(vaga);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException();
		}
		return listaVagas;
	}
	
	public Vaga buscarPorEmail(String email) {
		Vaga vaga = new Vaga();
		
		String sql = "SELECT * FROM vaga where email = ?";
		try {
			PreparedStatement stm = connection.prepareStatement(sql);
			stm.setString(1, email);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				vaga = preencherVaga(rs);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException();
		}
		return vaga;
	}
	
	public Vaga buscarPorId(String id) {
		Vaga vaga = new Vaga();
		String sql = "SELECT * FROM vaga where id = ?";
		try {
			PreparedStatement stm = connection.prepareStatement(sql);
			stm.setString(1, id);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				vaga = preencherVaga(rs);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException();
		}
		return vaga;
	}
	
	public void excluir(String id) {
		String sql = "DELETE FROM vaga where id = ?";
		try {
			PreparedStatement stm = connection.prepareStatement(sql);
			stm.setString(1, id);
			stm.execute();
			stm.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException();
		}
	}
	
	public void curtir(String id) {
		String sql = "UPDATE vaga SET vaga.like = vaga.like + 1 where id = ?";
		try {
			PreparedStatement stm = connection.prepareStatement(sql);
			stm.setString(1, id);
			stm.execute();
			stm.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException();
		}
	}
	
	private String montarQuery(VagaFilter filtro) {
		String sql = "select * from vaga where id > 0";
		
		if (!"".equals(filtro.getTitulo())) sql += " and titulo like '%" + filtro.getTitulo() + "%'";
		if (!"".equals(filtro.getEmpresa())) sql += " and empresa like '%" + filtro.getEmpresa() + "%'";
		if (!"".equals(filtro.getCidade())) sql += " and cidade like '%" + filtro.getCidade() + "%'";
		if (!"".equals(filtro.getEstado())) sql += " and estado like '%" + filtro.getEstado() + "%'";
		if (filtro.getRemuneracaoMinima() != null) sql += " and remuneracao >= " + filtro.getRemuneracaoMinima();
		if (filtro.getRemuneracaoMaxima() != null) sql += " and remuneracao <= " + filtro.getRemuneracaoMaxima();
		sql += " order by remuneracao " + filtro.getOrder();
		
		return sql;
	}
	
	private Vaga preencherVaga(ResultSet rs) throws SQLException {
		Vaga v = new Vaga();

		v.setId(rs.getInt("id"));
		v.setTitulo(rs.getString("titulo"));
		v.setEmpresa(rs.getString("empresa"));
		v.setEmail(rs.getString("email"));
		v.setDescricao(rs.getString("descricao"));
		v.setFormacao(rs.getString("formacao"));
		v.setCidade(rs.getString("cidade"));
		v.setEstado(rs.getString("estado"));
		v.setRemuneracao(rs.getDouble("remuneracao"));
		v.setLike(rs.getInt("like"));
		
		return v;
	}

	public void salvar(Vaga vaga) {
		String sql = "INSERT INTO vaga (titulo, empresa, email, descricao, formacao, cidade, estado, remuneracao)"
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			PreparedStatement stm = connection.prepareStatement(sql);
			stm = preencherPreparedStatement(stm, vaga);
			stm.execute();
			stm.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException();
		}
	}
	
	public void atualizar(Vaga vaga) {
		String sql = "UPDATE vaga set titulo = ?, empresa = ?, email = ?, descricao = ?, formacao = ?, "
				+ "cidade = ?, estado = ?, remuneracao = ? WHERE id = ?";
		
		try {
			PreparedStatement stm = connection.prepareStatement(sql);
			stm = preencherPreparedStatement(stm, vaga);
			stm.execute();
			stm.close();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException();
		}
	}
	
	private PreparedStatement preencherPreparedStatement(PreparedStatement stm, Vaga vaga) throws SQLException {
		stm.setString(1, vaga.getTitulo());
		stm.setString(2, vaga.getEmpresa());
		stm.setString(3, vaga.getEmail());
		stm.setString(4, vaga.getDescricao());
		stm.setString(5, vaga.getFormacao());
		stm.setString(6, vaga.getCidade());
		stm.setString(7, vaga.getEstado());
		stm.setDouble(8, vaga.getRemuneracao());
		
		if (vaga.getId() != null) {
			stm.setInt(9, vaga.getId());
		}
		return stm;
	}
}
