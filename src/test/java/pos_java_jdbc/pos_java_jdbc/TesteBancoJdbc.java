package pos_java_jdbc.pos_java_jdbc;

import java.util.List;

import org.junit.Test;

import dao.UserPosDAO;
import model.Userposjava;

public class TesteBancoJdbc {

	@Test
	public void initBanco() {
		UserPosDAO userPosDAO = new UserPosDAO();
		Userposjava userposjava = new Userposjava();
		
		
		userposjava.setNome("teste 2");
		userposjava.setEmail("teste2@gmail.com");
		
		userPosDAO.salvar(userposjava);
		
	}
	
	@Test
	public void initListar () {
		UserPosDAO dao = new UserPosDAO();
		try {
			List<Userposjava> list = dao.listar();
			
			for (Userposjava userposjava : list) {
				System.out.println(userposjava.getNome());
				System.out.println("----------");
			}
		} catch (Exception e) { 
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void initBuscar() {
		
		UserPosDAO dao = new UserPosDAO();
		
		try {
			Userposjava userposjava = dao.buscar(6L);
			
			System.out.println(userposjava);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void initAtualizar() {
		try {
		
		UserPosDAO dao = new UserPosDAO();
		
		Userposjava objetoBanco = dao.buscar(5L);
		
		objetoBanco.setNome("Noome mudado com o meodo atualizar");
		dao.atualizar(objetoBanco);
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	}
}
