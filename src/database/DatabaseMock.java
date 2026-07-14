package database;

import model.Funcionario;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DatabaseMock {
    private static final DatabaseMock INSTANCE = new DatabaseMock();
    
    private final List<Funcionario> funcionarios = new ArrayList<>();

    private DatabaseMock() {}

    public static DatabaseMock getInstance() {
        return INSTANCE;
    }

    public void salvar(Funcionario funcionario) {
        this.funcionarios.add(Objects.requireNonNull(funcionario, "Funcionário é obrigatório"));
    }

    public List<Funcionario> listarTodos() {
        return new ArrayList<>(funcionarios);
    }
}