package br.com.senai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.senai.model.Usuario;

public class UsuarioDao {
	
	private Connection connection;

	public UsuarioDao() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public Usuario buscarPorEmail(String email) {
		Usuario usuario = new Usuario();
		String sql = "SELECT * FROM usuario where LCASE(email) = ?";
		try {
			PreparedStatement stm = connection.prepareStatement(sql);
			stm.setString(1, email.toLowerCase());
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				usuario = preencherUsuario(rs);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException();
		}
		return usuario;
	}
	
	private Usuario preencherUsuario(ResultSet rs) throws SQLException {
		Usuario u = new Usuario();
		u.setId(rs.getInt("id"));
		u.setEmail(rs.getString("email"));
		u.setSenha(rs.getString("senha"));
		return u;
	}

}
