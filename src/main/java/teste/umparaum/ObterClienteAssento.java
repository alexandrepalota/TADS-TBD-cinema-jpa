package teste.umparaum;

import infra.DAO;
import modelo.umparaum.Cliente;

public class ObterClienteAssento {
	
	public static void main(String[] args) {
		
		DAO<Cliente> dao = new DAO<>(Cliente.class);
		
		Cliente cliente = dao.buscarPorId(4L);
		System.out.println(cliente.getAssento().getNome());
		
		dao.fechar();
	}

}
