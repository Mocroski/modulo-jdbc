package pos_java_jdbc.pos_java_jdbc;

import java.util.List;

import org.junit.Test;

import dao.UserPosDAO;
import model.Telefone;
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
	
	@Test
	public void initDeketar() {
		
		try {
			
			UserPosDAO dao = new UserPosDAO();
			dao.deletar(5L);
			System.out.println("Deleto com sucesso");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void testeInsertTelefone() {
		
		Telefone telefone = new Telefone();
		telefone.setNumeroString("(99)999999");
		telefone.setTipo("casa");
		telefone.setUsuario(2L);
		
		UserPosDAO dao = new UserPosDAO();
		dao.salvarTelefone(telefone);
		
	}
}
