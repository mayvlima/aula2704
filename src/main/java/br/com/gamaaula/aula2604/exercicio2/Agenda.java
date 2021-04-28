package br.com.gamaaula.aula2604.exercicio2;

import br.com.gamaaula.aula2604.exercicio1.Pessoa;

import java.util.Date;

public class Agenda extends Pessoa implements InterfaceAgenda{
    Pessoa[] agenda = new Pessoa[10];

    public void armazenarPessoa(String nome, Date dataDeNascimento, Float altura){

       int posicaoVazia = -1;

        for (int i = 0; agenda.length > i; i++) {
            if (agenda[i] == null) {
                posicaoVazia = i;
                break;
            }
        }

       if(posicaoVazia == -1){
           System.out.println("AGENDA LOTADA! APAGUE UM CONTATO!");
        }else{
           agenda[posicaoVazia] = new Pessoa(nome, dataDeNascimento, altura);
           System.out.println("CADASTRO SALVO COM SUCESSO!");
        }


    }

    public void removePessoa(String nome){
       /* for (int i = 0; agenda.length > i; i++) {
            if (agenda[i] != null && agenda[i].getNome().equals(nome)){
                agenda[i] = null;
                break;
            }
        }*/
        int resultado = buscaPessoa(nome);
        if(resultado != -1){
            agenda[resultado] = null;
            System.out.println("CONTATO APAGADO COM SUCESSO!");
        }else{
            System.out.println("CONTATO NÃO ENCONTRADO!");
        }
    }

    public int buscaPessoa(String nome){
        for (int i = 0; agenda.length > i; i++) {
            if (agenda[i] != null && agenda[i].getNome().equals(nome)){
                return i;
            }
        }
        return -1;
    }


    public void imprimirAgenda(){
       for(Pessoa p : agenda){
           if(p != null) {
               p.imprimir();
               System.out.println("---------------------");
           }
        }
    }

    public void imprimirPessoa(int index){
      if(index >= 0 && index <= 9){
            if(agenda[index] != null){
                agenda[index].imprimir();
            }else{
                System.out.println("Cadastro vazio ou não encontrado!");
            }
        }else{
            System.out.println("Digite um valor válido!");
        }

    }
}
