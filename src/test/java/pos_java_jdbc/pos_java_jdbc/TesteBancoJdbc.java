package pos_java_jdbc.pos_java_jdbc;

import org.junit.Test;

import conexaojdbc.SingleConnection;
import dao.UserPosDAO;
import model.Userposjava;

public class TesteBancoJdbc {

	@Test
	public void initBanco() {
		UserPosDAO userPosDAO = new UserPosDAO();
		Userposjava userposjava = new Userposjava();
		
		
		userposjava.setId(5L);
		userposjava.setNome("teste 2");
		userposjava.setEmail("teste2@gmail.com");
		
		userPosDAO.salvar(userposjava);
		
	}
}
