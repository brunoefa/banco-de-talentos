package br.com.senai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.senai.model.Curriculo;

public class CurriculoDao {
	
	private Connection connection;

	public CurriculoDao() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void salvar(Curriculo curriculo) {
		String sql = "INSERT INTO curriculo (nome, cidade, estado, resumo, "
										  + "titulo1, instituicao1, conclusao1, "
										  + "titulo2, instituicao2, conclusao2, "
										  + "titulo3, instituicao3, conclusao3, "
										  + "cargo1, empresa1, descricao1, entrada1, saida1, "
										  + "cargo2, empresa2, descricao2, entrada2, saida2, "
										  + "cargo3, empresa3, descricao3, entrada3, saida3 )"
										  + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
										  + "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";
		
		try {
			PreparedStatement stm = connection.prepareStatement(sql);
			stm.setString(1, curriculo.getNome());
			stm.setString(2, curriculo.getCidade());
			stm.setString(3, curriculo.getEstado());
			stm.setString(4, curriculo.getResumo());
			
			stm.setString(5, curriculo.getTitulo1());
			stm.setString(6, curriculo.getInstituicao1());
			stm.setString(7, curriculo.getConclusao1());
			
			stm.setString(8, curriculo.getTitulo2());
			stm.setString(9, curriculo.getInstituicao2());
			stm.setString(10, curriculo.getConclusao2());
			
			stm.setString(11, curriculo.getTitulo3());
			stm.setString(12, curriculo.getInstituicao3());
			stm.setString(13, curriculo.getConclusao3());
			
			stm.setString(14, curriculo.getCargo1());
			stm.setString(15, curriculo.getEmpresa1());
			stm.setString(16, curriculo.getDescricao1());
			stm.setString(17, curriculo.getEntrada1());
			stm.setString(18, curriculo.getSaida1());
			
			stm.setString(19, curriculo.getCargo2());
			stm.setString(20, curriculo.getEmpresa2());
			stm.setString(21, curriculo.getDescricao2());
			stm.setString(22, curriculo.getEntrada2());
			stm.setString(23, curriculo.getSaida2());
			
			stm.setString(24, curriculo.getCargo3());
			stm.setString(25, curriculo.getEmpresa3());
			stm.setString(26, curriculo.getDescricao3());
			stm.setString(27, curriculo.getEntrada3());
			stm.setString(28, curriculo.getSaida3());

			stm.execute();
			stm.close();
			
		} catch (SQLException e) {
			 System.out.println(e.getMessage());
			 throw new RuntimeException();
		}
		
	}

}















