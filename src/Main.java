import database.DatabaseMock;
import factory.MassaDadosFactory;
import model.Funcionario;
import service.FuncionarioService;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        DatabaseMock database = DatabaseMock.getInstance();

        List<Funcionario> funcionarios = MassaDadosFactory.gerarFuncionarios();

        funcionarios.forEach(database::salvar);

        FuncionarioService service = new FuncionarioService();

        service.exibirFuncionariosPorSetor();
    }
}