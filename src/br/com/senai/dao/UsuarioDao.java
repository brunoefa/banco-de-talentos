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
	
	public void salvar(Usuario usuario) throws SQLException {
		String sql = "INSERT INTO usuario (nome, email, senha, tipo) VALUES (?, ?, ?, ?)";

		try {
			PreparedStatement stm = connection.prepareStatement(sql);
			stm = preencherPreparedStatement(stm, usuario);
			stm.execute();
			stm.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw e;
		}
	}
	
	private PreparedStatement preencherPreparedStatement(PreparedStatement stm, Usuario usuario) throws SQLException {
		stm.setString(1, usuario.getNome());
		stm.setString(2, usuario.getEmail());
		stm.setString(3, usuario.getSenha());
		stm.setString(4, usuario.getTipo());
		return stm;
	}
	
	private Usuario preencherUsuario(ResultSet rs) throws SQLException {
		Usuario u = new Usuario();
		u.setId(rs.getInt("id"));
		u.setNome(rs.getString("nome"));
		u.setEmail(rs.getString("email"));
		u.setSenha(rs.getString("senha"));
		u.setTipo(rs.getString("tipo"));
		return u;
	}

}
