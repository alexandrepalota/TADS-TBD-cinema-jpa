package teste.umparamuitos;

import infra.DAO;
import modelo.basico.Produto;
import modelo.umparamuitos.ItemPedido;
import modelo.umparamuitos.Pedido;

public class NovoPedido {
	
	public static void main(String[] args) {
		
		DAO<Object> dao = new DAO<>();
		
		Produto p1 = new Produto("PLAYSTATION 5", 7499.99);
		Produto p2 = new Produto("CONTROLE DUAL SENSE", 599.99);
		Produto p3 = new Produto("DEMONS SOULS REMASTER", 249.99);
		Produto p4 = new Produto("Spiderman Miles Morales", 219.99);
		Pedido pedido = new Pedido();
		ItemPedido item1 = new ItemPedido(1, pedido, p1);
		ItemPedido item2 = new ItemPedido(2, pedido, p2);
		ItemPedido item3 = new ItemPedido(1, pedido, p3);
		ItemPedido item4 = new ItemPedido(1, pedido, p4);
		
		dao.abrirTransacao()
			.incluir(p1)
			.incluir(p2)
			.incluir(p3)
			.incluir(p4)
			.incluir(pedido)
			.incluir(item1)
			.incluir(item2)
			.incluir(item3)
			.incluir(item4)
			.fecharTransacao()
			.fechar();
	}

}
