package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Tecnico;


public class TecnicoDAO implements TecnicoInDAO{
private Connection conexao = null;
	
	public TecnicoDAO(Connection _conn) {
		this.conexao = _conn;
	}
	
	@Override
	public void  Inserir(Tecnico _objeto) throws SQLException {
		
		String SQL = "INSERT INTO Tecnico (nome, cargo, tel) VALUES (?, ?, ?)";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setString(1, _objeto.getNome());
		ps.setString(2, _objeto.getCargo());
		ps.setString(3, _objeto.getTel());
		
		ps.execute();

	}

	@Override
	public List<Tecnico> listarTodos() throws SQLException {
		
		//System.out.println();
		
		List<Tecnico> Tecnicos = new ArrayList<Tecnico>();
		ResultSet rs = null;
		
		String SQL = "SELECT cod, nome, cargo, tel FROM tecnico";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		rs = ps.executeQuery();
		
		while (rs.next()) {
			
			int cod = rs.getInt(1);
			String nome = rs.getString(2);
			String cargo = rs.getString(3);
			String tel = rs.getString(4);
			
			Tecnico p = new Tecnico(cod, nome, cargo, tel);
			
			Tecnicos.add(p);
		}
		
		return Tecnicos;
	}

	@Override
	public Boolean Excluir(int _cod) throws SQLException {
	
		String SQL = "DELETE FROM tecnico WHERE cod = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _cod);
		
		return ps.execute();
	}

	@Override
	public Boolean Atualizar(Tecnico _objeto) throws SQLException {

		String SQL = "UPDATE tecnico SET nome = ?, cargo = ?, tel = ? WHERE cod = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setString(1, _objeto.getNome());
		ps.setString(2, _objeto.getCargo());
		ps.setString(3, _objeto.getTel());
		
		ps.setInt(4, _objeto.getCod());
		
		return ps.execute();
	}

	@Override
	public Tecnico buscarPorCod(int _cod) throws SQLException {
		
		ResultSet rs = null;
		Tecnico p = null;
		
		String SQL = "SELECT cod, nome, cargo, tel FROM tecnico WHERE cod = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _cod);
		
		rs = ps.executeQuery();
		
		if (rs.next()) {
			
			int cod = rs.getInt(1);
			String nome = rs.getString(2);
			String cargo = rs.getString(3);
			String tel = rs.getString(4);
					
			p = new Tecnico(cod, nome, cargo, tel);
		}
		
		return p;
	}

}

