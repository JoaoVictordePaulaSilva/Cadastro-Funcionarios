import java.util.*;

public class Funcionario extends Salario {
    private String nome;
    private String cargo;
    private String contratacao;
    private List<String> departamentos;
    private double salario;
    private int id_func;

// metódo construtor

    public Funcionario(String nome, String cargo, int id_func) {
        try {
            validarNome(nome);
            this.nome = nome;

            if (cargo == null || cargo.isEmpty()) {
                throw new IllegalArgumentException("O cargo do funcionário não pode ser nulo ou vazio.");
            }
            this.cargo = cargo;

        } catch (IllegalArgumentException e) {
            System.err.println("Erro ao criar o funcionário: " + e.getMessage());
        }
    }
// metodos gets e sets

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        try {
            validarNome(nome);
            this.nome = nome;
        } catch (IllegalArgumentException e) {
            System.out.println(" " + e.getMessage());
            System.out.println("Exceção:" + e);
            System.err.println("Erro ao definir o nome: " + e.getMessage());
        }
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        if (cargo == null || cargo.isEmpty()) {
            throw new IllegalArgumentException("O cargo do funcionário não pode ser nulo ou vazio.");
        }
        this.cargo = cargo;
    }

    public List<String> getDepartamentos() {
        return departamentos;
    }

    public void addDepartamento(String departamento) {
        try {
            if (departamento == null || departamento.isEmpty()) {
                throw new IllegalArgumentException("O departamento não pode ser nulo ou vazio.");
            }
            this.departamentos.add(departamento);
        } catch (IllegalArgumentException e) {
            System.out.println(" " + e.getMessage());
            System.out.println("Exceção:" + e);
            System.err.println("Erro ao adicionar departamento: " + e.getMessage());
        }
    }

    public void removeDepartamentos(String departamento) {
        departamentos.remove(departamento);
    }

    public double calcSalario() {
        return salario;
    }
    
    public void setSalario(double salario) {
        try {
            if (salario < 0) {
                throw new IllegalArgumentException("O salário do funcionário não pode ser negativo.");
            }
            this.salario = salario;
        } catch (IllegalArgumentException e) {
            System.out.println(" " + e.getMessage());
            System.out.println("Exceção:" + e);
            System.err.println("Erro ao definir o salário: " + e.getMessage());
        }
    }

    public int getId() {
        return id_func;
    }

    public void setId_func(int id_func) {
        try {
            if (id_func < 0) {
                throw new IllegalArgumentException("O ID do funcionário não pode ser negativo.");
            }
            this.id_func = id_func;
        } catch (IllegalArgumentException e) {
            System.out.println(" " + e.getMessage());
            System.out.println("Exceção:" + e);
            System.err.println("Erro ao definir o ID: " + e.getMessage());
        }
    }

    private void validarNome(String nome) {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("O nome do funcionário não pode ser nulo ou vazio.");
        }
        // Verifica se o nome contém apenas letras e espaços
        for (char c : nome.toCharArray()) {
            if (!Character.isLetter(c) && c != ' ') {
                throw new IllegalArgumentException("O nome do funcionário deve conter apenas letras e espaços.");
            }
        }
    }
}
