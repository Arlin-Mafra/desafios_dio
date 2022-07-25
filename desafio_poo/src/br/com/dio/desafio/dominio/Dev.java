package br.com.dio.desafio.dominio;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

public class Dev {

    private String nome;
    private boolean planoPro; 
    private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
    private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();

    public void assinarPro(){
        setPlanoPro(true);
    }

    public void inscreverBootcamp(Bootcamp bootcamp ){
       if(getPlanoPro() ==  true || bootcamp.getIsFreePlan() == true){
           this.conteudosInscritos.addAll(bootcamp.getConteudos());
           bootcamp.getDevsInscritos().add(this);
        }else if(bootcamp.getIsFreePlan() == false || planoPro ==  false){
           System.err.println("Este plano é pago, se inscreva em nosso plano Pro!");;
       }else{
        System.out.println("Não foi possível realizar a inscrição");
       }
    }


    public void progredir(){
        Optional<Conteudo> conteudo =  this.conteudosInscritos.stream().findFirst();
        if(conteudo.isPresent()){
            this.conteudosConcluidos.add(conteudo.get());
            this.conteudosInscritos.remove(conteudo.get());

        }else{
            System.err.println("Voce não está matriculado em nenhum conteúdo.");
        }
    }


    public double calcularTotalXP(){
        return this.conteudosConcluidos.stream()
        .mapToDouble(conteudo -> conteudo.calcularXP())
        .sum();
        
    }


    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Set<Conteudo> getConteudosInscritos() {
        return conteudosInscritos;
    }
    public void setConteudosInscritos(Set<Conteudo> conteudosInscritos) {
        this.conteudosInscritos = conteudosInscritos;
    }
    public Set<Conteudo> getConteudosConcluidos() {
        return conteudosConcluidos;
    }
    public void setConteudosConcluidos(Set<Conteudo> conteudosConcluidos) {
        this.conteudosConcluidos = conteudosConcluidos;
    }

    
    public boolean getPlanoPro() {
        return planoPro;
    }

    public void setPlanoPro(boolean planoPro) {
        this.planoPro = planoPro;
    }

    


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((conteudosConcluidos == null) ? 0 : conteudosConcluidos.hashCode());
        result = prime * result + ((conteudosInscritos == null) ? 0 : conteudosInscritos.hashCode());
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Dev other = (Dev) obj;
        if (conteudosConcluidos == null) {
            if (other.conteudosConcluidos != null)
                return false;
        } else if (!conteudosConcluidos.equals(other.conteudosConcluidos))
            return false;
        if (conteudosInscritos == null) {
            if (other.conteudosInscritos != null)
                return false;
        } else if (!conteudosInscritos.equals(other.conteudosInscritos))
            return false;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        return true;
    }  

}
