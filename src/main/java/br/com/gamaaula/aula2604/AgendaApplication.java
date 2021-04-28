package br.com.gamaaula.aula2604;

import br.com.gamaaula.aula2604.exercicio2.Agenda;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

@SpringBootApplication
public class AgendaApplication {

    public static void main(String[] args) throws ParseException {
        SpringApplication.run(ElevadorApplication.class, args);

        Agenda agenda = new Agenda();

        Scanner scan = new Scanner(System.in);

        int continuar = 1;

        agenda.armazenarPessoa("Fabiana", new SimpleDateFormat("dd/MM/yyyy").parse("16/12/1944"), 195f);
        agenda.armazenarPessoa("Mariana", new SimpleDateFormat("dd/MM/yyyy").parse("06/01/1974"), 165f);
        agenda.armazenarPessoa("Ana", new SimpleDateFormat("dd/MM/yyyy").parse("15/05/1984"), 165f);


        do {
            System.out.println("Olá, bem vindo a sua AGENDA");
            System.out.println("O que você deseja fazer?");
            System.out.println("1 - Adicionar contato");
            System.out.println("2 - Apagar um contato");
            System.out.println("3 - Procurar um contato por nome");
            System.out.println("4 - Procurar um contato por ID");
            System.out.println("5 - Ver todos os contato");
            Integer escolha = scan.nextInt();

            switch (escolha) {
                case 1:
                    System.out.println("Digite o nome: ");
                    String nome = scan.next();
                    System.out.println("Digite a data de nascimento (dd/MM/aaaa): ");
                    String dataDeNascimento = scan.next();
                    System.out.println("Digite o peso: ");
                    Float peso = scan.nextFloat();

                    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                    try {
                        Date data = df.parse(dataDeNascimento);
                        agenda.armazenarPessoa(nome, data, peso);
                    } catch (
                            ParseException e) {
                        e.printStackTrace();
                    }

                    break;
                case 2:
                    System.out.println("Digite o nome do contato que deseja apagar: ");
                    nome = scan.next();
                    agenda.removePessoa(nome);
                    break;

                case 3:
                    System.out.println("Digite o nome do contato que deseja buscar: ");
                    nome = scan.next();
                    int retorno = agenda.buscaPessoa(nome);
                    if (retorno != -1) {
                        agenda.imprimirPessoa(retorno);
                    }else{
                        System.out.println("CONTATO NÃO ENCONTRADO");
                    }
                    break;

                case 4:
                    System.out.println("Digite o ID do contato que deseja buscar: ");
                    int id = scan.nextInt();
                    agenda.imprimirPessoa(id);
                    break;

                case 5:
                    agenda.imprimirAgenda();
                    break;

                default:
                    System.out.println("ESCOLHA UMA OPÇÃO VÁLIDA!");

            }

            System.out.println("\nDeseja retornar ao menu? (1)SIM (2)NÃO");
            continuar = scan.nextInt();
        }while (continuar == 1);

        System.out.println("Até a próxima!");

        scan.close();
    }
}
