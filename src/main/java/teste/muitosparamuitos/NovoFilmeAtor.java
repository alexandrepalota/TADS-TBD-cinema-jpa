package teste.muitosparamuitos;

import infra.DAO;
import modelo.muitosparamuitos.Ator;
import modelo.muitosparamuitos.Filme;

public class NovoFilmeAtor {
	
	public static void main(String[] args) {
		
		Filme filmeA = new Filme("Star Wars Ep.4", 8.9);
		Ator atorA = new Ator("Harrison Ford");
		Ator atrizB = new Ator("Carrie Fisher");
		
		Filme filmeB = new Filme("O Fugitivo", 8.1);
		filmeB.adicionarAtor(atorA);
		
		filmeA.adicionarAtor(atorA);
		filmeA.adicionarAtor(atrizB);
		
		DAO<Filme> dao = new DAO<>();
		dao.incluirAtomico(filmeA);
	}

}
