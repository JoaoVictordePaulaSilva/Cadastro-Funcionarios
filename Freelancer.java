import java.util.*;

public class Freelancer extends Funcionario{
    private int qtdProjetos;
    private double salarioProjeto;
    
    public Freelancer(String nome, String cargo, int id_func, int qtdProjetos, double salarioProjeto) {
        super(nome, cargo, id_func);
        this.qtdProjetos = qtdProjetos;
        this.salarioProjeto = salarioProjeto;
    }
    
    public int getQtdProjetos(){
        return qtdProjetos;
    }

    public double getSalarioProjeto(){
        return salarioProjeto;
    }

    public void setQtdProjetos(int qtdProjetos){
        this.qtdProjetos = qtdProjetos;
    }

    public void setSalarioProjeto(double salarioProjeto){
        this.salarioProjeto = salarioProjeto;
    }

     @Override
        public double calcSalario(){
            return qtdProjetos * salarioProjeto;
        }
}
