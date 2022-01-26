package com.pfreitas;

import com.pfreitas.model.Cliente;

public class App 
{
    public static void main( String[] args )
    {
        Cliente pedro = new Cliente("Pedro");
        Cliente thais = new Cliente("Thais");

        pedro.criarContaCorrente();
        pedro.criarContaPoupanca();

        thais.criarContaCorrente();
        thais.criarContaPoupanca();

        pedro.getCc().depositar(100);
        pedro.getCc().depositar(100);
        pedro.getCc().depositar(100);
        pedro.getCc().sacar(50);
        pedro.getCc().transferir(50, thais.getCc());

        pedro.getCc().imprimirStatus();
        pedro.getCc().imprimirExtrato();

        thais.getCc().imprimirStatus();
        thais.getCc().imprimirExtrato();

        thais.getCc().sacar(100);
    }
}
