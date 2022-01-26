package com.pfreitas.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import lombok.Getter;

@Getter
public class LogTransacao {

    private LocalDateTime dataHora;
    private TipoTransacao tipoTransacao;
    private double valor;
    private double saldoAnterior;
    private double saldoNovo;

    

    public LogTransacao(TipoTransacao tipoTransacao, double valor, double saldoAnterior,
            double saldoNovo) {
        this.dataHora = LocalDateTime.now();
        this.tipoTransacao = tipoTransacao;
        this.valor = valor;
        this.saldoAnterior = saldoAnterior;
        this.saldoNovo = saldoNovo;
    }



    @Override
    public String toString() {
        return String.format(
                "%20s - %15s - Valor: R$%7.2f - Saldo Anterior: R$%7.2f - Novo Saldo: R$%7.2f",
                dataHora.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")),
                this.tipoTransacao,
                this.valor,
                this.saldoAnterior,
                this.saldoNovo);
    }

}
