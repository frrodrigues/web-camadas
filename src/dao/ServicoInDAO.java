package dao;
import java.sql.SQLException;
import java.util.List;


import model.Servico;

public interface ServicoInDAO {
void Inserir(Servico _objeto) throws SQLException;
	
	List<Servico> listarTodos() throws SQLException;
	
	Boolean Excluir(int _id) throws SQLException;
	
	Boolean Atualizar(Servico _objeto) throws SQLException;
	
	Servico buscarPorNum(int _num) throws SQLException;

}
