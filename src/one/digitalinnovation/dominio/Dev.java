package one.digitalinnovation.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Dev {

	private String nome;
	private List<Conteudo> conteudosInscritos = new ArrayList<>();
	private List<Conteudo> conteudosConcluidos = new ArrayList<>();

	public Dev() {
	}

	public Dev(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void inscrever(Conteudo conteudo) {
		if (this.conteudosInscritos.contains(conteudo)) {
			System.err.println("Voc� j� se inscreveu neste conte�do!");
		} else {
			this.conteudosInscritos.add(conteudo);
			System.out.println("Inscri��o realizada com sucesso!");
		}
	}

	public void inscrever(Bootcamp bootcamp) {
		/*
		 * Alternativa 1: foreach tradicional for (Conteudo conteudo :
		 * bootcamp.getConteudos()) { this.inscrever(conteudo); }
		 */

		// Alternativa 2: API de Stream
		bootcamp.getConteudos().stream().forEach(this::inscrever);
		bootcamp.getDevs().add(this);
	}

	public void progredir() {
		Optional<Conteudo> conteudo = this.conteudosInscritos.stream().findFirst();
		if (conteudo.isPresent()) {
			this.conteudosConcluidos.add(conteudo.get());
			this.conteudosInscritos.remove(conteudo.get());
		} else {
			System.err.println("Voc� n�o est� mais inscrito em nenhum conte�do!");
		}
	}

	public double calcularTotalXP() {
		return this.conteudosConcluidos.stream().mapToDouble(Conteudo::calcularXP).sum();
	}
	
	

}
