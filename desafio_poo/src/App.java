import java.time.LocalDate;

import br.com.dio.desafio.modelo.Curso;
import br.com.dio.desafio.modelo.Mentoria;

public class App {
    public static void main(String[] args) throws Exception {

        Curso curso = new Curso();

        Mentoria mentoria = new Mentoria();
        mentoria.setData(LocalDate.now());

        System.out.println(curso);
        System.out.println(mentoria);
    }
}
