package model;

import java.time.LocalDate;
import java.util.Objects;

public class Dependente {
    private final String nome;
    private final LocalDate dataNascimento;

    public Dependente(String nome, LocalDate dataNascimento) {
        this.nome = Objects.requireNonNull(nome, "Nome é obrigatório");

        if (this.nome.isBlank()) {
            throw new IllegalArgumentException("Nome não pode ser vazio");
        }

        this.dataNascimento = Objects.requireNonNull(dataNascimento, "Data de nascimento é obrigatória");

        if (this.dataNascimento.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Data de nascimento não pode ser futura");
        }
    }

    public String getNome() { return nome; }
    public LocalDate getDataNascimento() { return dataNascimento; }
}