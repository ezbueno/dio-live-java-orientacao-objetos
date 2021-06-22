package one.digitalinnovation.dominio;

public class Curso extends Conteudo {

	private int cargaHoraria;

	public Curso() {
	}

	public Curso(int cargaHoraria, String titulo, String descricao) {
		super(titulo, descricao);
		this.cargaHoraria = cargaHoraria;
	}

	public int getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	@Override
	public double calcularXP() {
		return XP_PADRAO * cargaHoraria;
	}

	@Override
	public String toString() {
		return "Curso [Carga Horária=" + cargaHoraria + ", Título=" + getTitulo() + ", Descrição="
				+ getDescricao() + "]";
	}

}
