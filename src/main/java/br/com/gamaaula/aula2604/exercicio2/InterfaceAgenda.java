package br.com.gamaaula.aula2604.exercicio2;

import java.util.Date;

public interface InterfaceAgenda {

    void armazenarPessoa(String nome, Date dataDeNascimento, Float altura);
    void removePessoa(String nome);
    int buscaPessoa(String nome);
    void imprimirAgenda();
    void imprimirPessoa(int index);

}
