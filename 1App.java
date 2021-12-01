projeto.java

package projetoJava;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int loop = 1;
        int idVaga = -1;
        int vagasTotais = 4;
        int id = 100;
        ArrayList<Usuario> usua = new ArrayList<Usuario>();
        ArrayList<Veiculo> veic = new ArrayList<Veiculo>();

        while(loop !=0){
            System.out.println();
            System.out.println("Bem vindo!, Solução para Estacionamento 1.0");
            System.out.println();
            System.out.println("Quantidade de vagas totais: "+(vagasTotais+1));
            int vagasDisponiveis = vagasTotais-idVaga;
            System.out.println("Quantidade de vagas disponiveis: "+vagasDisponiveis);
            System.out.println();
            System.out.println("Opções: ");
            System.out.println();
            System.out.println("1 - Cadastrar Vaga.");
            System.out.println("2 - Pesquisar Vaga.");
            System.out.println("3 - Opções de administrador.");
            System.out.println("0 - Encerrar.");
            System.out.println();

            System.out.printf("Digite a opção desejada para continuar: ");
            loop = sc.nextInt();
            System.out.println();
            
            if(loop == 1){
                
                if(idVaga<vagasTotais){
                    idVaga++;
                    System.out.println("Nesse caso vou precisar de algumas informações para continuar.");
                    System.out.printf("Nome completo: ");
                    sc.nextLine();
                    String nome = sc.nextLine().toUpperCase();
                    System.out.printf("Função(Estudante/Funcionário/Visitante): ");
                    String funcao = sc.nextLine().toUpperCase();
                    System.out.printf("CPF(Apenas Números): ");
                    Long CPF = sc.nextLong();

                    usua.add(new Usuario(nome, funcao, CPF));
                
                    System.out.println();
                    System.out.println("Ótimo, agora vou precisar de alguns dados do veiculo.");
                    System.out.printf("Placa(LLL-NNNN): ");
                    sc.nextLine();
                    String placa = sc.nextLine().toUpperCase();
                    System.out.printf("Marca: ");
                    String marca = sc.nextLine().toUpperCase();
                
                    veic.add(new Veiculo(usua.get(idVaga), placa, marca,id));
                    id++;

                    System.out.println();
                    System.out.println("Ótimo, foi cadastrado com sucesso, ID da sua vaga: "+veic.get(idVaga).getId());

                }else{

                    System.out.println("Infelizmente estamos lotados.");

                }

            }else if(loop == 2){

                if(vagasDisponiveis!=vagasTotais+1){
                    System.out.println("Ótimo, agora vou precisar do ID da sua vaga. ");
                    System.out.println();
                    System.out.printf("Id da vaga: ");
                    int pesquisar = sc.nextInt();
            
                    boolean achou = false;
                    for(int i = 0;i<veic.size();i++){
                        if(veic.get(i).getId()==pesquisar){
                            achou = true;
                            pesquisar = i;
                            break;
                        }
                    }

                    if(achou){

                        System.out.println(veic.get(pesquisar).toString());
                        System.out.println();

                        System.out.printf("Deseja liberar essa vaga?(1-Sim/2-Não):");
                        int liberarVaga = sc.nextInt();
                        if(liberarVaga == 1){
                            idVaga--;
                            vagasDisponiveis--;
                            veic.remove(pesquisar);
                            System.out.println();
                            System.out.println("Ótimo, vaga liberada!");
                        }else if(liberarVaga != 2){
                            System.out.printf("Preciso que digite uma opção válida!(1-Sim/2-Não): ");
                            liberarVaga = sc.nextInt();
                        }else{
                            System.out.println();
                            System.out.println("Tudo bem, voltando a tela inical....");
                        }
                
                    }else{
                        
                        System.out.println("Ops, não consegui localizar nenhuma vaga com esse ID.");
                        System.out.println("Voltando a tela inical....");
                    }

                    
                }else{
                    System.out.println("Não há vagas para liberar!");
                }
                
            }else if(loop == 3){
                System.out.printf("Atenção!, Local reservado apenas para administrador!, por favor, digite a palavra para liberar o acesso(Palavra:'freefire'): ");
                sc.nextLine();
                String palavraReservada = sc.nextLine();
                if(palavraReservada.equalsIgnoreCase("freefire")){
                    System.out.println();
                    System.out.println("Opções de administrador: ");
                    System.out.println("1 - Listar todas as vagas ocupadas.");
                    System.out.println("2 - Mudar quantidade de vagas totais.");
                    System.out.println("3 - Remover vaga.");

                    System.out.println();
                    System.out.printf("Digite a opção desejada: ");
                    int opcaoAdministrador = sc.nextInt();

                    if(opcaoAdministrador == 1){
                        if(veic.size() == 0){
                            System.out.println();
                            System.out.println("Não há vagas para listar!");
                            System.out.println("Voltando a tela inical....");
                        }
                        for(int i =0;i<veic.size();i++){
                            System.out.println("Vaga "+i+"= "+veic.get(i).resultadoConsulta());
                        }
                    }else if(opcaoAdministrador == 2){
                        System.out.printf("Digite a nova quantidade de vagas totais: ");
                        vagasTotais = sc.nextInt()-1;
                        System.out.println("Atualizado com sucesso.");
                    }else if(opcaoAdministrador == 3){
                        System.out.printf("Preciso que digite o ID da vaga que deseja remover: ");
                        int removerVagaAdm = sc.nextInt();

                        boolean achou = false;
                        for(int i = 0;i<veic.size();i++){
                            if(veic.get(i).getId()==removerVagaAdm){
                                achou = true;
                                removerVagaAdm = i;
                                break;
                            }
                        }

                        if(achou){
                            veic.remove(removerVagaAdm);
                            idVaga--;
                            vagasDisponiveis--;
                            System.out.println();
                            System.out.println("Vaga removida com sucesso.");
                        }else{
                            System.out.println("Ops, não consegui localizar nenhuma vaga com esse ID.");
                            System.out.println("Voltando a tela inical....");
                        }

                    }
                }else{
                    System.out.println("Palavra incorreta.");
                    System.out.println("Voltando a tela inical....");
                    System.out.println();
                    loop = 1;
                }
            }else if(loop!=0){
                System.out.printf("Opção Inválida, digite uma opção válida! ");
                System.out.println("Voltando a tela inical....");
                System.out.println();
                loop = 1;
            }
        }

        System.out.println("Obrigado por utilizar nossa solução.");

        sc.close();
    }
}
