package br.com.senai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.senai.model.Curriculo;

public class CurriculoDao {
	
	private Connection connection;

	public CurriculoDao() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public Curriculo buscarPorEmail(String email) {
		Curriculo curriculo = new Curriculo();
		String sql = "SELECT * FROM curriculo where email = ?";
		try {
			PreparedStatement stm = connection.prepareStatement(sql);
			stm.setString(1, email);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				curriculo = preencherCurriculo(rs);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException();
		}
		return curriculo;
	}
	
	private Curriculo preencherCurriculo(ResultSet rs) throws SQLException {
		Curriculo c = new Curriculo();
		c.setId(rs.getInt("id"));
		c.setNome(rs.getString("nome"));
		c.setEmail(rs.getString("email"));
		c.setCidade(rs.getString("cidade"));
		c.setEstado(rs.getString("estado"));
		
		c.setTitulo1(rs.getString("titulo1"));
		c.setInstituicao1(rs.getString("instituicao1"));
		c.setConclusao1(rs.getString("conclusao1"));

		c.setTitulo2(rs.getString("titulo2"));
		c.setInstituicao2(rs.getString("instituicao2"));
		c.setConclusao2(rs.getString("conclusao2"));
		
		c.setTitulo3(rs.getString("titulo3"));
		c.setInstituicao3(rs.getString("instituicao3"));
		c.setConclusao3(rs.getString("conclusao3"));
		
		c.setCargo1(rs.getString("cargo1"));
		c.setEmpresa1(rs.getString("empresa1"));
		c.setDescricao1(rs.getString("descricao1"));
		c.setEntrada1(rs.getString("entrada1"));
		c.setSaida1(rs.getString("saida1"));
		
		c.setCargo2(rs.getString("cargo2"));
		c.setEmpresa2(rs.getString("empresa2"));
		c.setDescricao2(rs.getString("descricao2"));
		c.setEntrada2(rs.getString("entrada2"));
		c.setSaida2(rs.getString("saida2"));
		
		c.setCargo3(rs.getString("cargo3"));
		c.setEmpresa3(rs.getString("empresa3"));
		c.setDescricao3(rs.getString("descricao3"));
		c.setEntrada3(rs.getString("entrada3"));
		c.setSaida3(rs.getString("saida3"));
		
		return c;
	}

	public void salvar(Curriculo curriculo) {
		String sql = "INSERT INTO curriculo (nome, email, cidade, estado, resumo, "
										  + "titulo1, instituicao1, conclusao1, "
										  + "titulo2, instituicao2, conclusao2, "
										  + "titulo3, instituicao3, conclusao3, "
										  + "cargo1, empresa1, descricao1, entrada1, saida1, "
										  + "cargo2, empresa2, descricao2, entrada2, saida2, "
										  + "cargo3, empresa3, descricao3, entrada3, saida3 )"
										  + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
										  + "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";
		
		try {
			PreparedStatement stm = connection.prepareStatement(sql);
			stm.setString(1, curriculo.getNome());
			stm.setString(2, curriculo.getEmail());
			stm.setString(3, curriculo.getCidade());
			stm.setString(4, curriculo.getEstado());
			stm.setString(5, curriculo.getResumo());
			
			stm.setString(6, curriculo.getTitulo1());
			stm.setString(7, curriculo.getInstituicao1());
			stm.setString(8, curriculo.getConclusao1());
			
			stm.setString(9, curriculo.getTitulo2());
			stm.setString(10, curriculo.getInstituicao2());
			stm.setString(11, curriculo.getConclusao2());
			
			stm.setString(12, curriculo.getTitulo3());
			stm.setString(13, curriculo.getInstituicao3());
			stm.setString(14, curriculo.getConclusao3());
		
			stm.setString(15, curriculo.getCargo1());
			stm.setString(16, curriculo.getEmpresa1());
			stm.setString(17, curriculo.getDescricao1());
			stm.setString(18, curriculo.getEntrada1());
			stm.setString(19, curriculo.getSaida1());
			
			stm.setString(20, curriculo.getCargo2());
			stm.setString(21, curriculo.getEmpresa2());
			stm.setString(22, curriculo.getDescricao2());
			stm.setString(23, curriculo.getEntrada2());
			stm.setString(24, curriculo.getSaida2());
		
			stm.setString(25, curriculo.getCargo3());
			stm.setString(26, curriculo.getEmpresa3());
			stm.setString(27, curriculo.getDescricao3());
			stm.setString(28, curriculo.getEntrada3());
			stm.setString(29, curriculo.getSaida3());

			stm.execute();
			stm.close();
			
		} catch (SQLException e) {
			 System.out.println(e.getMessage());
			 throw new RuntimeException();
		}
		
	}
}















