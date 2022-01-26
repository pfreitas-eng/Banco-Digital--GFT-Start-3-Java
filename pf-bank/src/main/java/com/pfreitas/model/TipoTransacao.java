package com.pfreitas.model;

public enum TipoTransacao {
    SAQUE("Saque"),
    DEPOSITO("Deposito"),
    TRANSFERENCIA("Transferencia");

    private String descricao;

    TipoTransacao(String descricao){
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return this.descricao;
    }
}
