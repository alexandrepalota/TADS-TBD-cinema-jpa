package modelo.umparamuitos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import modelo.basico.Produto;

@Entity
@Table(name = "TB_ITEM_PEDIDO")
public class ItemPedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ITEM_PEDIDO")
	private Long id;
	
	@Column(nullable = false)
	private Integer quantidade;
	
	@Column(nullable = false, precision = 11, scale = 2)
	private Double preco;
	
	@ManyToOne
	@JoinColumn(name = "PEDIDO_ID")
	private Pedido pedido;
	
	@ManyToOne
	@JoinColumn(name = "PRODUTO_ID", nullable = false)
	private Produto produto;
	
	public ItemPedido() {
	}

	public ItemPedido(Integer quantidade, Pedido pedido, Produto produto) {
		this.setQuantidade(quantidade);
		this.setPedido(pedido);
		this.setProduto(produto);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		if (produto != null && this.preco == null) {
			this.setPreco(produto.getPreco());
		}
		this.produto = produto;
	}

}
