package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class AlterarUsuario1 {
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios_jpa");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Usuario usuario = em.find(Usuario.class, 3L);
		System.out.println("Nome antes de alterar: " + usuario.getNome());
		
		usuario.setNome("Alexandre");
		usuario.setEmail("alexandre@gmail.com");
		
		em.merge(usuario);
		
		em.getTransaction().commit();
		em.close();
		emf.close();
		
		System.out.println("Nome antes de alterar: " + usuario.getNome());
		
	}

}
