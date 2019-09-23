package dao;

import java.sql.SQLException;
import java.util.List;

import model.OrdemServico;

public interface OrdemServicoInDAO {
void Inserir(OrdemServico _objeto) throws SQLException;
	
	List<OrdemServico> listarTodos() throws SQLException;
	
	Boolean Excluir(int _seq) throws SQLException;
	
	Boolean Atualizar(OrdemServico _objeto) throws SQLException;
	
	OrdemServico buscarPorSeq(int _seq) throws SQLException;

}
