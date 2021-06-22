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
			System.err.println("Você já se inscreveu neste conteúdo!");
		} else {
			this.conteudosInscritos.add(conteudo);
			System.out.println("Inscrição realizada com sucesso!");
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
			System.err.println("Você não está mais inscrito em nenhum conteúdo!");
		}
	}

	public double calcularTotalXP() {
		return this.conteudosConcluidos.stream().mapToDouble(Conteudo::calcularXP).sum();
	}
	
	

}
