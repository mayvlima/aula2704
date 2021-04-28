package br.com.gamaaula.aula2604.exercicio1;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Pessoa implements InterfacePessoa {
    private String nome;
    private Date dataDeNascimento;
    private Float altura;

    public Pessoa(){

    }

    public Pessoa(String nome, Date dataDeNascimento, Float altura){
        this.nome = nome;
        this.dataDeNascimento = dataDeNascimento;
        this.altura = altura;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(Date dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public Float getAltura() {
        return altura;
    }

    public void setAltura(Float altura) {
        this.altura = altura;
    }


    public void imprimir() {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Nome: " + this.nome);
        System.out.println("Data de Nascimento: " + df.format(this.dataDeNascimento));
        System.out.println("Altura: " + this.altura);
    }

    public int calcularIdade() throws ParseException {
        Calendar dataAtual = Calendar.getInstance();

        int anoAtual = dataAtual.get(Calendar.YEAR);
        int mesAtual = dataAtual.get(Calendar.MONTH);
        int diaAtual = dataAtual.get(Calendar.DATE);

        Calendar dataNascimento = Calendar.getInstance();

        dataNascimento.setTime(this.dataDeNascimento);

        int anoDeNascimento = dataNascimento.get(Calendar.YEAR);
        int mesDeNascimento = dataNascimento.get(Calendar.MONTH);
        int diaDeNascimento = dataNascimento.get(Calendar.DATE);

        int idade = anoAtual - anoDeNascimento;

        if (mesDeNascimento > mesAtual && diaDeNascimento < diaAtual) {
            idade = idade - 1;
        } else {
            idade = idade;
        }
        return idade;
    }
}
