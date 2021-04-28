package br.com.gamaaula.aula2604.exercicio3;

import br.com.gamaaula.aula2604.exercicio1.Pessoa;

public class Elevador extends Pessoa implements InterfaceElevador {
    private int andarAtual;
    private int totalAndares;
    private int capacidade;
    private int totalPessoas;

    public Elevador(){
        this.andarAtual = 0;
        this.totalAndares = 0;
        this.capacidade = 0;
        this.totalPessoas = 0;
    }

    public int getAndarAtual() {
        return andarAtual;
    }

    public void setAndarAtual(int andarAtual) {
        this.andarAtual = andarAtual;
    }

    public int getTotalAndares() {
        return totalAndares;
    }

    public void setTotalAndares(int totalAndares) {
        this.totalAndares = totalAndares;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public int getTotalPessoas() {
        return totalPessoas;
    }

    public void setTotalPessoas(int totalPessoas) {
        this.totalPessoas = totalPessoas;
    }

    @Override
    public void inicializa(int capacidade, int totalAndares) {
        this.capacidade = capacidade;
        this.totalAndares = totalAndares;
        this.andarAtual = 0;
        this.totalPessoas = 0;
    }

    @Override
    public void entra() {
        if(this.capacidade > totalPessoas){
            totalPessoas = totalPessoas + 1;
            System.out.println("Quantidade atual de pessoas: " + totalPessoas);
            System.out.println("Vagas restantes: " + (capacidade - totalPessoas));
        }else{
            System.out.println("NÃO HÁ MAIS VAGAS NO ELEVADOR!");
        }
    }

    @Override
    public void sai() {
        if(this.totalPessoas > 0){
            totalPessoas = totalPessoas - 1;
            System.out.println("Quantidade atual de pessoas: " + totalPessoas);
            System.out.println("Vagas restantes: " + (capacidade - totalPessoas));
        }else{
            System.out.println("NÃO HÁ PESSOAS PARA SAIR DO ELEVADOR!");
        }
    }

    @Override
    public void sobe() {
        if(this.totalAndares > andarAtual){
            andarAtual = andarAtual + 1;
            System.out.println("Andar atual: " + andarAtual);
        }else{
            System.out.println("O ELEVADOR JÁ ESTÁ NO ÚLTIMO ANDAR!");
        }
    }

    @Override
    public void desce() {
        if(this.andarAtual > 0){
            andarAtual = andarAtual - 1;
            System.out.println("Andar atual: " + andarAtual);
        }else{
            System.out.println("O ELEVADOR JÁ ESTÁ NO ÚLTIMO ANDAR");
        }
    }

}
