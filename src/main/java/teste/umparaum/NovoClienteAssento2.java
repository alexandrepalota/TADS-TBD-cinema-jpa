package teste.umparaum;

import infra.DAO;
import modelo.umparaum.Assento;
import modelo.umparaum.Cliente;

public class NovoClienteAssento2 {
	
	public static void main(String[] args) {
		Assento assento = new Assento("4B");
		Cliente cliente = new Cliente("CARLOS", assento);
		
		DAO<Object> dao = new DAO<>();
		
		dao.abrirTransacao()
			.incluir(cliente)
			.fecharTransacao()
			.fechar();
	}

}
