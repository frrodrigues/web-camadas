package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Cliente;
import model.Endereco;

public class EnderecoDAO implements EnderecoInDAO {

	private Connection conexao = null;
	
	public EnderecoDAO(Connection _conexao) {
		this.conexao = _conexao;
	}
	
	@Override
	public void Inserir(Endereco _objeto) throws SQLException {
		
		String SQL = "INSERT INTO endereco (logradouro, numero, bairro, cidade, estado) VALUES (?, ?, ?, ?, ?)";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setString(1, _objeto.getLogradouro());
		ps.setInt(2, _objeto.getNumero());
		ps.setString(3, _objeto.getBairro());
		ps.setString(4, _objeto.getCidade());
		ps.setString(5, _objeto.getEstado());
		
		ps.execute();

	}

	@Override
	public List<Endereco> listarTodos() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean Excluir(int _id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean Atualizar(Endereco _objeto) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Endereco buscarPorId(int _id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Endereco> listarEnderecosPorCliente(int _idCliente) throws SQLException {
		
		List<Endereco> enderecos = new ArrayList<Endereco>();
		ResultSet rs = null;
		
		String SQL = "SELECT id, logradouro, numero, bairro, cidade, estado FROM endereco WHERE cliente_id = ?";
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _idCliente);
		
		rs = ps.executeQuery();
		
		while (rs.next()) {
			
			int id_cli = rs.getInt(1);
			String logradouro = rs.getString(2);
			int numero = rs.getInt(3);
			String bairro = rs.getString(4);
			String cidade = rs.getString(5);
			String estado = rs.getString(6);
			
			ClienteDAO daoCli= new ClienteDAO(conexao);
			Cliente cli =daoCli.buscarPorId(id_cli);
			
			Endereco end = new Endereco(cli , logradouro, numero, bairro, cidade, estado);
			
			enderecos.add(end);
		}
		
		return enderecos;
	}

}
