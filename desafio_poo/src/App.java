import java.time.LocalDate;

import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;

public class App {
    public static void main(String[] args) throws Exception {

     Curso curso1 = new Curso();
     curso1.setTitulo("Java basico");
     curso1.setDescricao("basico");
     curso1.setCargaHoraria(8);

     Curso curso2 = new Curso();
     curso2.setTitulo("Java intermediário");
     curso2.setDescricao("intermediário");
     curso2.setCargaHoraria(10);


     Mentoria mentoria = new Mentoria();
     mentoria.setTitulo("Mentoria de java");
     mentoria.setDescricao("Mentoria basica");
     mentoria.setData(LocalDate.now());

     Bootcamp bootcamp = new Bootcamp();
     bootcamp.setNome("Java developer");
     bootcamp.setDescricao("Bootcamp java");
     bootcamp.setIsFreePlane(false);
     bootcamp.getConteudos().add(curso1);
     bootcamp.getConteudos().add(curso2);
     bootcamp.getConteudos().add(mentoria);

     Dev devArlin = new Dev();
     devArlin.setNome("Arlin");
     devArlin.assinarPro();
     devArlin.inscreverBootcamp(bootcamp);
     System.out.println("Conteúdos inscritos arlin: " + devArlin.getConteudosInscritos());
     System.out.println("=======================");
     devArlin.progredir();
     devArlin.progredir();
     System.out.println("========");
     System.out.println("Conteúdos inscritos arlin: " + devArlin.getConteudosInscritos());
     System.out.println("========");
     System.out.println("Conteúdos concluídos arlin: " + devArlin.getConteudosConcluidos());
     System.out.println("=");
     System.out.println("XP >> " + devArlin.calcularTotalXP());   
     

     Dev devFulano = new Dev();
     devFulano.setNome("Fulano");
     devFulano.inscreverBootcamp(bootcamp);
     System.out.println("Conteúdos inscritos fulano: " + devFulano.getConteudosInscritos());
     System.out.println("=======================");
     devFulano.progredir();
     devFulano.progredir();
     devFulano.progredir();
     System.out.println("Conteúdos inscritos fulano: " + devFulano.getConteudosInscritos());
     System.out.println("========");
     System.out.println("Conteúdos conclídos fulano: " + devFulano.getConteudosConcluidos());
     System.out.println("=");
     System.out.println("XP >> " + devFulano.calcularTotalXP());
    }
}
