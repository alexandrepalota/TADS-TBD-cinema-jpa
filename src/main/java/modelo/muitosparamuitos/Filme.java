package modelo.muitosparamuitos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TB_FILME")
public class Filme {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	private Double nota;
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(
			name = "TB_ATORES_FILMES",
			joinColumns = @JoinColumn(name = "FILME_ID", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "ATOR_ID", referencedColumnName = "id"))
	private List<Ator> atores = new ArrayList<>();

	public Filme(String nome, Double nota) {
		this.nome = nome;
		this.nota = nota;
	}

	public Filme() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}

	public List<Ator> getAtores() {
		if (this.atores == null) {
			atores = new ArrayList<>();
		}
		return atores;
	}

	public void adicionarAtor(Ator ator) {
		if (ator != null && !this.getAtores().contains(ator)) {
			this.getAtores().add(ator);
			if (!ator.getFilmes().contains(this))
				ator.getFilmes().add(this);
		}
	}
	
}
