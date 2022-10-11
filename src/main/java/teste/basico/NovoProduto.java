package teste.basico;

import infra.ProdutoDAO;
import modelo.basico.Produto;

public class NovoProduto {
	
	public static void main(String[] args) {
		
		ProdutoDAO dao = new ProdutoDAO();
		
		Produto produto = new Produto("Notebook", 2799.45);
		
		dao.abrirTransacao().incluir(produto).fecharTransacao().fechar();
		
		
	}

}
