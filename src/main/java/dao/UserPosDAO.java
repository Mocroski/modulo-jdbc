package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import conexaojdbc.SingleConnection;
import model.Userposjava;

public class UserPosDAO {
	
	private Connection connection;
	
	public  UserPosDAO() {
		connection = SingleConnection.getConnection();
		
		
	}
	
	public void salvar(Userposjava userposjava) {
		try {
		String sql = "insert into userposjava (id, nome, email) values (?,?,?)";
		PreparedStatement insert = connection.prepareStatement(sql);
		insert.setLong(1, userposjava.getId());
		insert.setString(2,userposjava.getNome() );
		insert.setString(3, userposjava.getEmail());
		insert.execute();
		connection.commit(); //salva no banco de dados
		
		
		}catch (Exception e) {
			try {
				connection.rollback(); //reverte operaçao
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			e.printStackTrace();
		}
	}
	
	public List<Userposjava> listar () throws Exception{ //metodo para retorna uma lista
		List<Userposjava> list = new ArrayList<>();
		
		String sql = "select * from userposjava"; //comandos sql
		
		PreparedStatement statement = connection.prepareStatement(sql);//prepara o sql
		ResultSet resultado = statement.executeQuery();//executa no banco de dados
		
		while (resultado.next()) { //enquanto for true ira percorrer a lista setando novos objetos
			Userposjava userposjava = new Userposjava();
			userposjava.setId(resultado.getLong("id"));
			userposjava.setNome(resultado.getNString("nome"));
			userposjava.setEmail(resultado.getNString("email"));
			
			
			list.add(userposjava);
		}
		
		return list;
	}
	
	public Userposjava buscar (Long id) throws Exception{ //metodo para retorna uma lista
		Userposjava retorno = new Userposjava();
		
		String sql = "select * from userposjava where id = " + id; //comandos sql
		
		PreparedStatement statement = connection.prepareStatement(sql);//prepara o sql
		ResultSet resultado = statement.executeQuery();//executa no banco de dados
		
		while (resultado.next()) { //retorna apenas 1 ou nenhum
			
			retorno.setId(resultado.getLong("id"));
			retorno.setNome(resultado.getNString("nome"));
			retorno.setEmail(resultado.getNString("email"));
			
		}
		
		return retorno;
	}




}


