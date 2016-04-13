package vetor;

import java.util.Scanner;

public class CadastroAlunos {

    private Scanner teclado = new Scanner(System.in);
    private Aluno[] alunos = new Aluno[1000];

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
        
        int i = 0;
        while(alunos[i]!=null){
            i++;
        }
        
        alunos[i] = aluno;
        System.out.println("Aluno cadastrado!");
    }

    private void totalCadastros() {
        int totalCadastrados = 0;
        for(Aluno aluno : alunos){
            if(aluno!=null){
                totalCadastrados++;
            }
        }
        System.out.printf("Total alunos: %d\n", totalCadastrados);
    }

    private void removerAluno() {
        System.out.print("Matrícula do aluno:");
        int matricula = teclado.nextInt();
        teclado.nextLine();
        
        int posicaoEncontrada = alunos.length;
        for(int i=0; i<alunos.length; i++){
            if(matricula == alunos[i].getMatricula()){
                posicaoEncontrada = i;
                break;
            }
        }        
        if(posicaoEncontrada == alunos.length){
            System.out.println("Aluno não encontrado!");
        }else{
            alunos[posicaoEncontrada] = null;
            System.out.println("Aluno removido!");
        }
    }

    private void ordenarAlunos() {
        //Ordenaçao pelo metodo bolha
        //A cada iteraçao posiciona o maior valor no final do vetor
        //Valores null ficarão no final do vetor
        Aluno alunoTemp = null;
        for(int i=0; i<alunos.length; i++){
            for(int j=0; j<alunos.length-i-1; j++){
                if(alunos[j+1]==null){
                    continue;
                }if(alunos[j]==null ||
                        alunos[j].getMatricula()>alunos[j+1].getMatricula()){
                    alunoTemp = alunos[j+1];
                    alunos[j+1] = alunos[j];
                    alunos[j] = alunoTemp;
                }
            }
        }
        
        for(Aluno aluno : alunos){
            if(aluno!=null){
                System.out.printf("%d - %s\n", aluno.getMatricula(), aluno.getNome());
            }
        }
    }

}
