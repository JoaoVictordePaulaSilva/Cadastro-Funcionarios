import java.util.*;

public class Permanente extends Funcionario{
    public Permanente(String nome, String cargo, int id_func) {
        super(nome, cargo, id_func);
    }

  public void aumentoSalario(double aumento){
    double novoSalario = calcSalario() + aumento;
    setSalario(novoSalario);
  }
}
