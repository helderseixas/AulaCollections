package collections;

public class Aluno implements Comparable<Aluno>{
    private int matricula;
    private String nome;

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int compareTo(Aluno outro) {
        if(this.matricula > outro.matricula){
            return 1;
        }else if(this.matricula < outro.matricula){
            return -1;
        }else{
            return 0;
        }
    }
}
    