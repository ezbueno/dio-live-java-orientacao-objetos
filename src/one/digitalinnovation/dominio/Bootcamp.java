package one.digitalinnovation.dominio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Bootcamp {

	private String nome;
	private LocalDate dataInicio;
	private LocalDate dataEncerramento;
	private List<Dev> devs = new ArrayList<>();
	private List<Conteudo> conteudos = new ArrayList<>();

	public Bootcamp() {
	}

	public Bootcamp(String nome, LocalDate dataInicio, LocalDate dataEncerramento) {
		super();
		this.nome = nome;
		this.dataInicio = dataInicio;
		this.dataEncerramento = dataEncerramento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDate getdataEncerramento() {
		return dataEncerramento;
	}

	public void setdataEncerramento(LocalDate dataEncerramento) {
		this.dataEncerramento = dataEncerramento;
	}

	public List<Dev> getDevs() {
		return devs;
	}

	public List<Conteudo> getConteudos() {
		return conteudos;
	}

	@Override
	public String toString() {
		return "Bootcamp [Conteúdos=" + conteudos + "]";
	}

}
