package org.projetoverdinho.projetoverdinhoapi.enumerator;

public enum StatusMulta {
    ATIVA(0), PAGA(1), CANCELADA(2);


    private final int codigo;

    StatusMulta(int codigo) {
        this.codigo = codigo;
    }
}
