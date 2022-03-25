package com.jordan.enums;

public enum TipoCliente {
    PESSOAFISICA(1, "Pessoa Fisica"),
    PESSOAJURIDICA(2, "Pessoa juridica");

    private Integer codigo;
    private String descricao;

    private TipoCliente(){

    }

    private TipoCliente(Integer codigo, String descricao){
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getDescrição() {
        return descricao;
    }

    public static TipoCliente toEnum(Integer cod){
        if(cod == null){
            return null;
        }

        for( TipoCliente x : TipoCliente.values()){
            if(cod == x.getCodigo()){
                return x;
            }
        }

        throw new IllegalArgumentException("Código inválido" + cod);
    }
}
