import java.util.*;

public class Departamentos {
    private List<Funcionario> lista;
    private String nomeDepartamento;
//método construtor
    public Departamentos(String nomeDepartamento, List<Funcionario> lista) {
        if (nomeDepartamento == null || nomeDepartamento.isEmpty()) {
            throw new IllegalArgumentException("O nome do departamento não pode ser nulo ou vazio.");
        }
        if (lista == null) {
            throw new IllegalArgumentException("A lista de funcionários não pode ser nula.");
        }
        this.nomeDepartamento = nomeDepartamento;
        this.lista = new ArrayList<Funcionario>(lista);
    }
// gets e sets 
    public String getNomeDepartamento() {
        return nomeDepartamento;
    }

    public void setNomeDepartamento(String nomeDepartamento) {
        this.nomeDepartamento = nomeDepartamento;
    }

    public List<Funcionario> getLista() {
        return lista;
    }

    public void setLista(List<Funcionario> lista) {
        this.lista = lista;
    }

    // Método para adicionar um funcionário à lista do departamento
    public void adicionarFuncionario(Funcionario funcionario) {
        if (funcionario == null) {
            throw new IllegalArgumentException("O funcionário não pode ser nulo.");
        }
        lista.add(funcionario);
    }

// Método para criar um novo departamento
    public static Departamentos criarDepartamento(Scanner input) {
        System.out.println("Informe o nome do departamento:");
        String nome = input.nextLine();
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("O nome do departamento não pode ser nulo ou vazio.");
        }
        return new Departamentos(nome, new ArrayList<Funcionario>());
    }

// Método para mostrar todos os departamentos cadastrados
    public static void mostrarDepartamentos(List<Departamentos> departamentos) {
        System.out.println("=== Lista de Departamentos ===");
        if (departamentos.isEmpty()) {
            System.out.println("Nenhum departamento cadastrado.");
        } else {
            for (Departamentos departamento : departamentos) {
                if (departamento == null) {
                    throw new IllegalArgumentException("Departamento inválido encontrado na lista.");
                }
                System.out.println("Nome: " + departamento.getNomeDepartamento());
            }
        }
    }
    public static void mostrarDepartamentoEFuncionarios(List<Departamentos> departamentos, String nomeDepartamento) {
        boolean encontrado = false;
        for (Departamentos departamento : departamentos) {
            if (departamento.getNomeDepartamento().equalsIgnoreCase(nomeDepartamento)) {
                encontrado = true;
                System.out.println("=== Departamento: " + departamento.getNomeDepartamento() + " ===");
                List<Funcionario> funcionarios = departamento.getLista();
                if (funcionarios.isEmpty()) {
                    System.out.println("Nenhum funcionário cadastrado neste departamento.");
                } else {
                    for (Funcionario funcionario : funcionarios) {
                        System.out.println("Nome do Funcionário: " + funcionario.getNome());

                    }
                }
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Departamento não encontrado.");
        }
    }

    

    public void incluirFuncionarioDepartamento(Funcionario funcionario) {
        if (funcionario == null) {
            throw new IllegalArgumentException("O funcionário não pode ser nulo.");
        }
        lista.add(funcionario);
    }

}    
