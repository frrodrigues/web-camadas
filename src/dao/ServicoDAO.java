package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Servico;


public class ServicoDAO implements ServicoInDAO  {
private Connection conexao = null;
	
	public ServicoDAO(Connection _conn) {
		this.conexao = _conn;
	}
	
	@Override
	public void Inserir(Servico _objeto) throws SQLException {
		
		String SQL = "INSERT INTO servico (valor, descricao, tipo) VALUES (?, ?, ?)";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _objeto.getValor());
		ps.setString(2, _objeto.getDescricao());
		ps.setString(3, _objeto.getTipo());
		
		ps.execute();

	}

	@Override
	public List<Servico> listarTodos() throws SQLException {
		
		//System.out.println();
		
		List<Servico> Servicos = new ArrayList<Servico>();
		ResultSet rs = null;
		
		String SQL = "SELECT num, valor, descricao, tipo FROM servico";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		rs = ps.executeQuery();
		
		while (rs.next()) {
			
			int num = rs.getInt(1);
			int valor = rs.getInt(2);
			String descricao = rs.getString(3);
			String tipo = rs.getString(4);
			
			Servico p = new Servico(num, valor, descricao, tipo);
			
			Servicos.add(p);
		}
		
		return Servicos;
	}

	@Override
	public Boolean Excluir(int _num) throws SQLException {
	
		String SQL = "DELETE FROM servico WHERE num = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _num);
		
		return ps.execute();
	}

	@Override
	public Boolean Atualizar(Servico _objeto) throws SQLException {

		String SQL = "UPDATE servico SET valor = ?, descricao = ?, tipo = ? WHERE num = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _objeto.getValor());
		ps.setString(2, _objeto.getDescricao());
		ps.setString(3, _objeto.getTipo());
		
		ps.setInt(4, _objeto.getNum());
		
		return ps.execute();
	}

	@Override
	public Servico buscarPorNum(int _num) throws SQLException {
		
		ResultSet rs = null;
		Servico p = null;
		
		String SQL = "SELECT num, valor, descricao, tipo FROM servico WHERE num = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _num);
		
		rs = ps.executeQuery();
		
		if (rs.next()) {
			
			int num = rs.getInt(1);
			int valor = rs.getInt(2);
			String descricao = rs.getString(3);
			String tipo = rs.getString(4);
			
						
			p = new Servico(num, valor, descricao, tipo);
		}
		
		return p;
	}

}
