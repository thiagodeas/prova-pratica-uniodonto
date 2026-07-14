package factory;

import model.Dependente;
import model.Funcionario;
import model.Setor;

import java.time.LocalDate;
import java.util.List;

public class MassaDadosFactory {

    public static List<Funcionario> gerarFuncionarios() {

        Setor tecnologia = new Setor(
                "TI",
                "Tecnologia da Informação"
        );

        Setor recursosHumanos = new Setor(
                "RH",
                "Recursos Humanos"
        );

        Setor financeiro = new Setor(
                "FIN",
                "Financeiro"
        );


        Dependente joao = new Dependente(
                "João",
                LocalDate.of(2015, 5, 10)
        );

        Dependente maria = new Dependente(
                "Maria",
                LocalDate.of(2018, 8, 20)
        );

        Dependente lucas = new Dependente(
                "Lucas",
                LocalDate.of(2012, 4, 15)
        );


        Funcionario thiago = new Funcionario(
                "Thiago",
                LocalDate.of(2002, 5, 10),
                "001",
                tecnologia,
                List.of(joao, maria)
        );

        Funcionario amanda = new Funcionario(
                "Amanda",
                LocalDate.of(1995, 3, 15),
                "002",
                tecnologia
        );


        Funcionario ana = new Funcionario(
                "Ana",
                LocalDate.of(1997, 7, 20),
                "003",
                recursosHumanos
        );

        Funcionario bruno = new Funcionario(
                "Bruno",
                LocalDate.of(1990, 2, 25),
                "004",
                recursosHumanos,
                List.of(lucas)
        );


        Funcionario carlos = new Funcionario(
                "Carlos",
                LocalDate.of(1988, 10, 25),
                "005",
                financeiro,
                List.of(joao)
        );


        return List.of(
                thiago,
                amanda,
                ana,
                bruno,
                carlos
        );
    }
}