package org.projetoverdinho.projetoverdinhoapi.enumerator;

public enum StatusAtivo {
    DESATIVADO(0), ATIVO(1);

    private final int i;

    StatusAtivo(int x) {
        this.i = x;
    }
}
