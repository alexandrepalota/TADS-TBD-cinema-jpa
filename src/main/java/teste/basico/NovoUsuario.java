package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class NovoUsuario {
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios_jpa");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Usuario novoUsuario = new Usuario("Leonaro", "leonardo@lanche.com.br");
		em.persist(novoUsuario);
		
		em.getTransaction().commit();
		em.close();
		emf.close();
		
		System.out.println("O id gerado foi: " + novoUsuario.getId());
		
	}

}
