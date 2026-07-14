package model;

import java.util.Objects;

public class Setor {

    private final String codigo;
    private final String descricao;

    public Setor(String codigo, String descricao) {

        this.codigo = Objects.requireNonNull(codigo, "Código é obrigatório");
        this.descricao = Objects.requireNonNull(descricao, "Descrição é obrigatória");

        if (this.codigo.isBlank()) {
            throw new IllegalArgumentException("Código não pode ser vazio");
        }

        if (this.descricao.isBlank()) {
            throw new IllegalArgumentException("Descrição não pode ser vazia");
        }
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return descricao + " (" + codigo + ")";
    }
}