import java.util.*;
import org.junit.After;

public class Temporario extends Funcionario{

  private int horasTrab;
  private double porHora;
  
    public Temporario(String nome, String cargo, int id_func, int horasTrab, double porHora) {
        super(nome, cargo, id_func);
      this.horasTrab = horasTrab;
      this.porHora = porHora;
    }

  //getters e setters
  
  public int getHoras(){
    return horasTrab;
  }

  public void setHoras(int horasTrab){
      this.horasTrab = horasTrab;
    }

  public void setPorHora(double porHora){
      this.porHora = porHora;
  }

  public double getPorHora(){
    return porHora;
  }

  public void aumentoHoras(int horas){
    int novasHoras = getHoras() + horas;
    setHoras(novasHoras);
  }

    @Override
      public double calcSalario(){
        return  horasTrab * porHora;
      }
  }
