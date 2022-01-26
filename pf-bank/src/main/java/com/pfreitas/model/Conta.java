package com.pfreitas.model;

import java.util.ArrayList;

import lombok.Getter;

@Getter
public abstract class Conta {

    private static final int AGENCIA_PADRAO = 1;
    private static int NUMERACAO_SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo = 0;

    private Cliente titular;
    protected ArrayList<LogTransacao> extrato = new ArrayList<>();

    Conta(Cliente titular){
        this.agencia = AGENCIA_PADRAO;
        this.numero = NUMERACAO_SEQUENCIAL++;
        this.titular = titular;
    }

    protected void aumentarSaldo(double valor) {
        this.saldo += valor;
    }

    protected void diminuirSaldo(double valor) {
        this.saldo -= valor;
    }

    public void depositar(double valor) {
        double novoSaldo = this.saldo + valor;
        extrato.add(new LogTransacao(TipoTransacao.DEPOSITO, valor, this.saldo, novoSaldo));
        aumentarSaldo(valor);
        System.out.println("Deposito efetuado com sucesso. Valor: " + valor);
    }

    public void sacar(double valor) {
        if (saldoInsuficiente(valor)) return; 

        double novoSaldo = this.saldo - valor;
        extrato.add(new LogTransacao(TipoTransacao.SAQUE, valor, this.saldo, novoSaldo));
        diminuirSaldo(valor);
        System.out.println("Saque efetuado com sucesso. Valor: " + valor);
    }

    public void transferir(double valor, Conta contaDestino) {
        if (saldoInsuficiente(valor)) return;        

        double novoSaldoOrigem = this.saldo - valor;
        this.extrato.add(new LogTransacao(TipoTransacao.TRANSFERENCIA, valor, this.saldo, novoSaldoOrigem));

        double novoSaldoDestino = contaDestino.getSaldo()+valor;
        contaDestino.extrato.add(new LogTransacao(TipoTransacao.TRANSFERENCIA, valor, contaDestino.getSaldo(), novoSaldoDestino));

        this.diminuirSaldo(valor);
        contaDestino.aumentarSaldo(valor);

        System.out.println("Transferencia efetuada com sucesso. Valor: " + valor);
    }

    private boolean saldoInsuficiente(double valor) {
        if (this.saldo < valor) {
            System.out.println("Saldo insuficiente para a operacao de transferencia.");
            System.out.println(String.format("Valor da Transacao: R$%7.2f - Saldo Disponivel: R$%7.2f.", valor, this.saldo));
            return true;
        } else {
            return false;
        }
    }

    public void imprimirExtrato() {
        System.out.println("=== Impressao de Extrato ===");
        for(LogTransacao transacao : extrato) {
            System.out.println(transacao);
        }
    }

    public void imprimirStatus() {
        System.out.println();
        System.out.println(String.format("Tipo: %s", this.getClass().getSimpleName()));
        System.out.println(String.format("Agencia: %d", this.getAgencia()));
        System.out.println(String.format("Numero: %d", this.getNumero()));
        System.out.println(String.format("Saldo: R$%7.2f", this.getSaldo()));
    }
}
