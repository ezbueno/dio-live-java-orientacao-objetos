package one.digitalinnovation.dominio;

import java.time.LocalDateTime;

public class Mentoria extends Conteudo {

	private LocalDateTime data;

	public Mentoria() {
	}

	public Mentoria(LocalDateTime data, String titulo, String descricao) {
		super(titulo, descricao);
		this.data = data;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	@Override
	public double calcularXP() {
		return XP_PADRAO;
	}

	@Override
	public String toString() {
		return "Mentoria [Data e Hora=" + data + ", Título=" + getTitulo() + ", Descrição=" + getDescricao() + "]";
	}
	
	

}
