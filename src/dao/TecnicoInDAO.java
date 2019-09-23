package dao;

import java.sql.SQLException;
import java.util.List;

import model.Tecnico;

public interface TecnicoInDAO {

	void Inserir(Tecnico _objeto) throws SQLException;
	
	List<Tecnico> listarTodos() throws SQLException;
	
	Boolean Excluir(int _id) throws SQLException;
	
	Boolean Atualizar(Tecnico _objeto) throws SQLException;
	
	Tecnico buscarPorCod(int _cod) throws SQLException;

}
