package teste.basico;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import modelo.basico.Usuario;

public class ObterUsuarios {
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios_jpa");
		EntityManager em = emf.createEntityManager();
		
		// Forma "passo a passo"
		String jpql = "select u from Usuario u"; // Define a consulta
		TypedQuery<Usuario> query = em.createQuery(jpql, Usuario.class); // Cria a query
		query.setMaxResults(3); // Define o número máximo de resultados (parâmetro limit do sql)
		List<Usuario> usuariosFormaPassoAPasso = query.getResultList(); // Armazena o resultado em uma lista
		
		// Forma "reduzida"
		List<Usuario> usuarios = em
				.createQuery("select u from Usuario u", Usuario.class)
				.setMaxResults(3)
				.getResultList();
		
		em.close();
		emf.close();
		
		for (Usuario usuario : usuarios) {
			System.out.println("ID: " + usuario.getId() + " - Nome: " + usuario.getNome());
		}
		
	}

}
