package com.pfreitas.model;

import lombok.Getter;

@Getter
public class Cliente {

    private String nome;

    private ContaCorrente cc;
    private ContaPoupanca cp;

    public Cliente(String nome) {
        this.nome = nome;
    }

    public void criarContaCorrente() {
        if (cc != null) {
            System.out.println("O cliente ja possui uma conta corrente.");
        } else {
            this.cc = new ContaCorrente(this);
            System.out.println("Conta corrente criada com sucesso. Numero: " + this.cc.getNumero());
        }
    }

    public void criarContaPoupanca() {
        if (cp != null) {
            System.out.println("O cliente ja possui uma conta poupanca.");
        } else {
            this.cp = new ContaPoupanca(this);
            System.out.println("Conta poupanca criada com sucesso. Numero: " + this.cp.getNumero());
        }
    }
    
}
