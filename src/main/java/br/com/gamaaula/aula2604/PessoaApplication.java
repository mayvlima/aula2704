package br.com.gamaaula.aula2604;

import br.com.gamaaula.aula2604.exercicio1.Pessoa;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

@SpringBootApplication
public class PessoaApplication {

    public static void main(String[] args){
        SpringApplication.run(ElevadorApplication.class, args);

        Scanner sc = new Scanner(System.in);

        Pessoa pessoa = new Pessoa();

		System.out.println("Digite o nome: ");
		String nome = sc.next();

		System.out.println("Digite a data de nascimento (dd/MM/aaaa): ");
		String dataNascimento = sc.next();

        System.out.println("Digite sua altura: ");
        Float altura = sc.nextFloat();

		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");


		try {
			Date data = df.parse(dataNascimento);
			pessoa.setDataDeNascimento(data);

			pessoa.setNome(nome);
			pessoa.setAltura(altura);

			pessoa.imprimir();
			System.out.println("Você tem " + pessoa.calcularIdade() + " anos!");

		} catch (ParseException e) {
            //e.printStackTrace();
            System.out.println("Digite uma data de nascimento válida!");
        }


    }
}
