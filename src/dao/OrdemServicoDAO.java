package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;

import model.OrdemServico;
import model.Servico;
import model.Tecnico;

public class OrdemServicoDAO  implements OrdemServicoInDAO{

private Connection conexao = null;
	
	public OrdemServicoDAO(Connection _conn) {
		this.conexao = _conn;
	}
	
	@Override
	public void Inserir(OrdemServico _objeto) throws SQLException {
		
		String SQL = "INSERT INTO OrdemServico (data_ini, sla, data_fim, status, id_cli, cod_tec,num_serv) VALUES"
				+ " (?, ?, ?, ?, ?, ?, ?)";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setString(1, _objeto.getData_ini());
		ps.setInt(2, _objeto.getSla());
		ps.setString(3, _objeto.getData_fim());
		ps.setString(4, _objeto.getStatus());
		ps.setInt(5, _objeto.getCli().getId());
		ps.setInt(6, _objeto.getCod_tec().getCod());
		ps.setInt(7, _objeto.getNum_serv().getNum());
		
		ps.execute();

	}

	@Override
	public List<OrdemServico> listarTodos() throws SQLException {
		
		//System.out.println();
		
		List<OrdemServico> OrdemServicos = new ArrayList<OrdemServico>();
		ResultSet rs = null;
		
		String SQL = "SELECT  seq, data_ini, sla, data_fim, status, id_cli, cod_tec,num_serv FROM ordemservico";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		rs = ps.executeQuery();
		
		while (rs.next()) {
			
			int seq = rs.getInt(1);
			String data_ini = rs.getString(2);
			int sla = rs.getInt(3);
			String data_fim = rs.getString(4);
			String status = rs.getString(5);
			int id_cli = rs.getInt(6);
			int cod_tec = rs.getInt(7);
			int num_serv = rs.getInt(8);
			
			// Mostrar thiag
			
			ClienteDAO daoCli= new ClienteDAO(conexao);
			Cliente cli =daoCli.buscarPorId(id_cli);
			
			TecnicoDAO daoTec= new TecnicoDAO(conexao);
			Tecnico tec =daoTec.buscarPorCod(cod_tec);
			
			ServicoDAO daoServ= new ServicoDAO(conexao);
			Servico serv =daoServ.buscarPorNum(num_serv);
			
			OrdemServico p = new OrdemServico (seq, data_ini, sla, data_fim, status,cli, tec, serv);
			
			OrdemServicos.add(p);
		}
		
		return OrdemServicos;
	}

	@Override
	public Boolean Excluir(int _seq) throws SQLException {
	
		String SQL = "DELETE FROM ordemservico WHERE seq = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _seq);
		
		return ps.execute();
	}

	@Override
	public Boolean Atualizar(OrdemServico _objeto) throws SQLException {

		String SQL = "UPDATE ordemservico SET data_ini= ? sla = ? data_fim =? status =? , id_cli =?, cod_tec=? ,num_serv=?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setString(1, _objeto.getData_ini());
		ps.setInt(2, _objeto.getSla());
		ps.setString(3, _objeto.getData_fim());
		ps.setString(4, _objeto.getStatus());
		ps.setInt(5, _objeto.getCli().getId());
		ps.setInt(6, _objeto.getCod_tec().getCod());
		ps.setInt(7, _objeto.getNum_serv().getNum());
		
		ps.setInt(4, _objeto.getSeq());
		
		return ps.execute();
	}

	@Override
	public OrdemServico buscarPorSeq(int _seq) throws SQLException {
		
		ResultSet rs = null;
		OrdemServico p = null;
		
		String SQL = "SELECT seq, data_ini, sla, data_fim, status, id_cli, cod_tec,num_serv FROM ordemservico WHERE seq = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _seq);
		
		rs = ps.executeQuery();
		
		if (rs.next()) {
			
			int seq = rs.getInt(1);
			String data_ini = rs.getString(2);
			int sla = rs.getInt(3);
			String data_fim = rs.getString(4);
			String status = rs.getString(5);
			int id_cli = rs.getInt(6);
			int cod_tec = rs.getInt(7);
			int num_serv = rs.getInt(8);
			
			ClienteDAO daoCli= new ClienteDAO(conexao);
			Cliente cli =daoCli.buscarPorId(id_cli);
			
			TecnicoDAO daoTec= new TecnicoDAO(conexao);
			Tecnico tec =daoTec.buscarPorCod(cod_tec);
			
			ServicoDAO daoServ= new ServicoDAO(conexao);
			Servico serv =daoServ.buscarPorNum(num_serv);
			
			OrdemServico p = new OrdemServico (seq, data_ini, sla, data_fim, status,cli, tec, serv);
		
				
		}
		
		return p;
	}

}
