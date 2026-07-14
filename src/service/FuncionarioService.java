package service;

import database.DatabaseMock;
import model.Dependente;
import model.Funcionario;
import model.Setor;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FuncionarioService {

    private final DatabaseMock database = DatabaseMock.getInstance();

    public Map<Setor, List<Funcionario>> listarFuncionariosAgrupadosPorSetor() {

        List<Funcionario> funcionarios = database.listarTodos();

        return funcionarios.stream()
                .sorted(Comparator.comparing(
                        Funcionario::getNome,
                        String.CASE_INSENSITIVE_ORDER
                ))
                .collect(Collectors.groupingBy(
                        Funcionario::getSetor
                ));
    }

    public void exibirFuncionariosPorSetor() {

        Map<Setor, List<Funcionario>> funcionariosPorSetor =
                listarFuncionariosAgrupadosPorSetor();

        funcionariosPorSetor.forEach((setor, funcionarios) -> {

            System.out.println("\n==============================");
            System.out.println("SETOR: " + setor);
            System.out.println("==============================");

            funcionarios.forEach(funcionario -> {

                System.out.println("\nFuncionário: " + funcionario.getNome());
                System.out.println("Nascimento: " + funcionario.getDataNascimento());
                System.out.println("Matrícula: " + funcionario.getMatricula());

                List<Dependente> dependentes = funcionario.getDependentes();

                if (dependentes.isEmpty()) {
                    System.out.println("Dependentes: Nenhum");
                } else {
                    System.out.println("Dependentes:");

                    dependentes.forEach(dependente ->
                            System.out.println(
                                    "- " + dependente.getNome()
                                    + " | Nascimento: "
                                    + dependente.getDataNascimento()
                            )
                    );
                }
            });

            System.out.println(
                    "\nTotal de funcionários no setor: "
                    + funcionarios.size()
            );
        });
    }
}