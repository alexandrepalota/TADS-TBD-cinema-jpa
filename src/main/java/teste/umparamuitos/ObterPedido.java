package teste.umparamuitos;

import infra.DAO;
import modelo.umparamuitos.ItemPedido;
import modelo.umparamuitos.Pedido;

public class ObterPedido {
	
	public static void main(String[] args) {
		
		DAO<Pedido> dao = new DAO<>(Pedido.class);
		
		Pedido pedido = dao.buscarPorId(2L);

		for (ItemPedido item : pedido.getItens()) {
			System.out.println(item.getProduto().getNome());
		}
		
		dao.fechar();
		
	}

}
