package one.digitalinnovation;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import one.digitalinnovation.dominio.Bootcamp;
import one.digitalinnovation.dominio.Curso;
import one.digitalinnovation.dominio.Dev;
import one.digitalinnovation.dominio.Mentoria;

public class Main {

	public static final String CARGA_HORARIA = "Carga Horária: ";
	public static final String TITULO = "Título: ";
	public static final String DESCRICAO = "Descrição: ";
	public static final String DATA_HORA = "Data e Hora: ";
	public static final String NOME_BOOTCAMP = "Nome do Bootcamp: ";
	public static final String DATA_INICIO = "Data de início: ";
	public static final String DATA_ENCERRAMENTO = "Data de encerramento: ";
	public static final String CONTEUDO = "Conteúdos do Bootcamp:";

	public static void main(String[] args) {
		var cursoJava = new Curso(8, "Java Básico", "Aprenda os conceitos básicos sobre Java");
		System.out.println(CARGA_HORARIA + cursoJava.getCargaHoraria() + "\n" + TITULO + cursoJava.getTitulo() + "\n"
				+ DESCRICAO + cursoJava.getDescricao() + "\n");

		var cursoDotNet = new Curso(10, ".NET", "Aprenda os conceitos básicos sobre .NET");
		System.out.println(CARGA_HORARIA + cursoDotNet.getCargaHoraria() + "\n" + TITULO + cursoDotNet.getTitulo()
				+ "\n" + DESCRICAO + cursoDotNet.getDescricao() + "\n");

		var cursoJavaScript = new Curso(6, "JavaScript", "Aprenda os conceitos básicos sobre JavaScript");
		System.out.println(CARGA_HORARIA + cursoJavaScript.getCargaHoraria() + "\n" + TITULO
				+ cursoJavaScript.getTitulo() + "\n" + DESCRICAO + cursoJavaScript.getDescricao() + "\n");

		var mentoria = new Mentoria(LocalDateTime.now(), "Aprendendo Orientação a Objetos com Java",
				"Imersão sobre os pilares da Orientação a Objetos");
		System.out.println(DATA_HORA + mentoria.getData() + "\n" + TITULO + mentoria.getTitulo() + "\n" + DESCRICAO
				+ mentoria.getDescricao() + "\n");

		var bootcamp = new Bootcamp("GFT START # 2 Java", LocalDate.now(), LocalDate.now().plusDays(45));
		System.out.println(NOME_BOOTCAMP + bootcamp.getNome() + "\n" + DATA_INICIO + bootcamp.getDataInicio() + "\n"
				+ DATA_ENCERRAMENTO + bootcamp.getdataEncerramento() + "\n");

		System.out.println(CONTEUDO);
		bootcamp.getConteudos().addAll(Arrays.asList(cursoJava, cursoDotNet, cursoJavaScript, mentoria));
		bootcamp.getConteudos().forEach(System.out::println);

		System.out.println();

		var dev = new Dev("Ezandro");
		dev.inscrever(cursoJava);
		dev.inscrever(bootcamp);
		dev.progredir();

		System.out.println(String.format("Ezandro - XP: %.2f", dev.calcularTotalXP()));

		System.out.println();

		var dev2 = new Dev("Bueno");
		dev2.inscrever(cursoDotNet);
		dev2.inscrever(bootcamp);
		dev2.progredir();

		System.out.println(String.format("Bueno - XP: %.2f", dev2.calcularTotalXP()));

		System.out.println();

//		List<Dev> ranking = Arrays.asList(dev, dev2).stream()
//				.sorted(dev, dev2 -> Double.compare(dev.calcularTotalXP(), dev2.calcularTotalXP()))
//				.collect(Collectors.toList());
		
		List<Dev> ranking = Arrays.asList(dev, dev2).stream()
				  .sorted((d1, d2) -> Double.compare(d1.calcularTotalXP(), d2.calcularTotalXP()))
				  .collect(Collectors.toList());
		
		System.out.println("Ranking dos Devs:");
		for (Dev d : ranking) {
			System.out.println(d.getNome());
		}

	}

}
