package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CadastroAlunos {

    private Scanner teclado = new Scanner(System.in);
    private List<Aluno> alunos = new ArrayList<Aluno>();

    public static void main(String[] args) {
        CadastroAlunos cadastroAlunos = new CadastroAlunos();
        cadastroAlunos.menuInicial();
    }

    private void menuInicial() {
        int opcao = 0;
        do {
            System.out.println("<<<Menu inicial>>>");
            System.out.println("1 - Cadastrar aluno");
            System.out.println("2 - Quanidade alunos cadastrados");
            System.out.println("3 - Remover aluno");
            System.out.println("4 - Ordenar alunos");
            System.out.println("5 - Sair");
            
            System.out.print("Informe a opçao: ");
            opcao = teclado.nextInt();
            teclado.nextLine();
            
            if(opcao==1){
                this.cadastrarAluno();              
            }else if(opcao==2){
                this.totalCadastros();
            }else if(opcao==3){
                this.removerAluno();
            }else if(opcao==4){
                this.ordenarAlunos();
            }

        } while (opcao != 5);
    }

    private void cadastrarAluno() {
        System.out.print("Nome: ");
        String nome = teclado.nextLine();
        System.out.print("Matrícula: ");
        int matricula = teclado.nextInt();
        teclado.nextLine();
        
        Aluno aluno = new Aluno();
        aluno.setMatricula(matricula);
        aluno.setNome(nome);
        
        alunos.add(aluno);
        System.out.println("Aluno cadastrado!");
    }

    private void totalCadastros() {
        System.out.printf("Total alunos: %d\n", alunos.size());
    }

    private void removerAluno() {
        System.out.print("Matrícula do aluno:");
        int matricula = teclado.nextInt();
        teclado.nextLine();
        
        //Disponivel a partir do Java 8, versoes anteriores tem q fazer loop
        Aluno alunosEncontrado = 
                alunos.stream().filter(
                        (p)->p.getMatricula()==matricula).findFirst().get();
        alunos.remove(alunosEncontrado);
    }

    private void ordenarAlunos() {
        Collections.sort(alunos);
        
        for(Aluno aluno : alunos){
            if(aluno!=null){
                System.out.printf("%d - %s\n", aluno.getMatricula(), aluno.getNome());
            }
        }
    }

}
