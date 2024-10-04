import java.util.*;

public class Horista extends Funcionario{
  private int horasExtras;
  private double taxaHora;
  
    public Horista(String nome, String cargo, int id_func, int horasExtras, double taxaHora) {
      super(nome, cargo, id_func);
      this.horasExtras = horasExtras;
      this.taxaHora = taxaHora;
    }

  public double getTaxaHora(){
    return taxaHora;
  }
  
  public void setTaxaHora(double taxaHora){
    this.taxaHora = taxaHora;
  }

  public int getHorasExtras(){
    return horasExtras;
  }

  public void setHorasExtras(int horasExtras){
    this.horasExtras = horasExtras;
  }
  
  public void aumentoHorasExtra(int horas){
    int novasHoras = getHorasExtras() + horas;
    setHorasExtras(novasHoras);
  }

    @Override
      public double calcSalario(){
      return horasExtras * taxaHora;
      }
}
