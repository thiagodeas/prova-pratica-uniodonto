package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Funcionario {

    private final String nome;
    private final LocalDate dataNascimento;
    private final String matricula;
    private Setor setor;
    private final List<Dependente> dependentes;

    public Funcionario(String nome,
                       LocalDate dataNascimento,
                       String matricula,
                       Setor setor) {

        this(nome, dataNascimento, matricula, setor, new ArrayList<>());
    }

    public Funcionario(String nome,
                       LocalDate dataNascimento,
                       String matricula,
                       Setor setor,
                       List<Dependente> dependentes) {

        Objects.requireNonNull(nome, "Nome é obrigatório");
        Objects.requireNonNull(dataNascimento, "Data de nascimento é obrigatória");
        Objects.requireNonNull(matricula, "Matrícula é obrigatória");
        Objects.requireNonNull(setor, "Setor é obrigatório");
        Objects.requireNonNull(dependentes, "Lista de dependentes não pode ser nula");

        if (nome.isBlank()) {
            throw new IllegalArgumentException("Nome não pode ser vazio");
        }

        if (matricula.isBlank()) {
            throw new IllegalArgumentException("Matrícula não pode ser vazia");
        }

        if (dataNascimento.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Data de nascimento não pode ser futura");
        }

        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.matricula = matricula;
        this.setor = setor;
        this.dependentes = new ArrayList<>(dependentes);
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getMatricula() {
        return matricula;
    }

    public Setor getSetor() {
        return setor;
    }

    public List<Dependente> getDependentes() {
        return dependentes;
    }

    public void alterarSetor(Setor setor) {
        this.setor = Objects.requireNonNull(setor, "Setor é obrigatório");
    }

    public void adicionarDependente(Dependente dependente) {
        dependentes.add(Objects.requireNonNull(dependente, "Dependente é obrigatório"));
    }
}