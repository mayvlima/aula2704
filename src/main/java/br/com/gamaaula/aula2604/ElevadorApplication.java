package br.com.gamaaula.aula2604;

import br.com.gamaaula.aula2604.exercicio3.Elevador;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.ParseException;
import java.util.Scanner;

@SpringBootApplication
public class ElevadorApplication {

	public static void main(String[] args) throws ParseException {
		SpringApplication.run(ElevadorApplication.class, args);

		Scanner sc = new Scanner(System.in);

		Elevador[] elev = new Elevador[1];

		elev[0] = new Elevador();

		System.out.println("Bem vindo ao ELEVADOR");
		System.out.println("Qual a capacidade total de pessoas?");
		int capacidade = sc.nextInt();
		System.out.println("Quantos andares tem o prédio?");
		int andares = sc.nextInt();

		int continuar = 1;

		elev[0].inicializa(capacidade, andares);

		do{

			System.out.println("O que você deseja fazer?");
			System.out.println("1 - Entrar uma pessoa");
			System.out.println("2 - Sair uma pessoa");
			System.out.println("3 - Subir um andar");
			System.out.println("4 - Descer um andar");
			System.out.println("5 - Mostrar dados atuais");
			int resposta = sc.nextInt();

			switch (resposta){
				case  1:
					elev[0].entra();
					break;
				case 2:
					elev[0].sai();
					break;
				case 3:
					elev[0].sobe();
					break;
				case 4:
					elev[0].desce();
					break;
				case 5:
					System.out.println("Pessoas dentro do elevador: " + elev[0].getTotalPessoas());
					System.out.println("Andar Atual: " + elev[0].getAndarAtual());
					System.out.println("Capacidade: " + elev[0].getCapacidade());
					System.out.println("Total de andares: " + elev[0].getTotalAndares());
					break;
				default:
					System.out.println("ESCOLHA UMA OPÇÃO VÁLIDA!");
			}

			System.out.println("\nDeseja retornar ao menu? (1)SIM (2)NÃO");
			continuar = sc.nextInt();

		}while (continuar == 1);

		System.out.println("Até a próxima!");

		sc.close();

	}

}
