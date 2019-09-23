package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Endereco;
import model.Cliente;

public class ClienteDAO implements ClienteInDAO {

	private Connection conexao = null;
	
	public ClienteDAO(Connection _conn) {
		this.conexao = _conn;
	}
	
	@Override
	public void Inserir(Cliente _objeto) throws SQLException {
		
		String SQL = "INSERT INTO cliente (nome, email, tel) VALUES (?, ?, ?)";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setString(1, _objeto.getNome());
		ps.setString(2, _objeto.getEmail());
		ps.setString(3, _objeto.getTelefone());
		
		ps.execute();

	}

	@Override
	public List<Cliente> listarTodos() throws SQLException {
		
		//System.out.println();
		
		List<Cliente> clientes = new ArrayList<Cliente>();
		ResultSet rs = null;
		
		String SQL = "SELECT id, nome, email, tel FROM pessoa";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		rs = ps.executeQuery();
		
		while (rs.next()) {
			
			int id = rs.getInt(1);
			String nome = rs.getString(2);
			String email = rs.getString(3);
			String telefone = rs.getString(4);
			
			EnderecoDAO daoEnd = new EnderecoDAO(this.conexao);
			List<Endereco> enderecos = daoEnd.listarEnderecosPorPessoa(id);
			
			Cliente p = new Cliente(id, nome, email, telefone, enderecos);
			
			clientes.add(p);
		}
		
		return clientes;
	}

	@Override
	public Boolean Excluir(int _id) throws SQLException {
	
		String SQL = "DELETE FROM pessoa WHERE id = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _id);
		
		return ps.execute();
	}

	@Override
	public Boolean Atualizar(Cliente _objeto) throws SQLException {

		String SQL = "UPDATE pessoa SET nome = ?, email = ?, tel = ? WHERE id = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setString(1, _objeto.getNome());
		ps.setString(2, _objeto.getEmail());
		ps.setString(3, _objeto.getTelefone());
		
		ps.setInt(4, _objeto.getId());
		
		return ps.execute();
	}

	@Override
	public Cliente buscarPorId(int _id) throws SQLException {
		
		ResultSet rs = null;
		Cliente p = null;
		
		String SQL = "SELECT id, nome, email, tel FROM pessoa WHERE id = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _id);
		
		rs = ps.executeQuery();
		
		if (rs.next()) {
			
			int id = rs.getInt(1);
			String nome = rs.getString(2);
			String email = rs.getString(3);
			String telefone = rs.getString(4);
			
			EnderecoDAO daoEnd = new EnderecoDAO(this.conexao);
			List<Endereco> enderecos = daoEnd.listarEnderecosPorPessoa(id);
			
			p = new Cliente(id, nome, email, telefone, enderecos);
		}
		
		return p;
	}

}
