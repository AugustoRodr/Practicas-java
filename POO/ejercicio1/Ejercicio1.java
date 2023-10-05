package POO.ejercicio1;

import javax.swing.JOptionPane;

/**
 * 1) Crea una clase llamada Cuenta que tendrá los siguientes atributos: titular
 * y cantidad (puede tener decimales).
 * 
 * El titular será obligatorio y la cantidad es opcional. Crea dos constructores
 * que cumpla lo anterior.
 * 
 * Crea sus métodos get, set y toString.
 * 
 * Tendrá dos métodos especiales:
 * -ingresar(double cantidad): se ingresa una cantidad a la cuenta, si la
 * cantidad introducida es negativa, no se hará nada.
 * -retirar(double cantidad): se retira una cantidad a la cuenta, si restando la
 * cantidad actual a la que nos pasan es negativa, la cantidad de la cuenta pasa
 * a ser 0.
 */

public class Ejercicio1 {
  public static void main(String[] args) {

    String titular = JOptionPane.showInputDialog("Ingrese el nombre del titular: ");
    double cantidad = Double.parseDouble(JOptionPane.showInputDialog("Establezca la cantidad de la cuenta: "));
    Cuenta persona1 = new Cuenta(titular, cantidad);

    // System.out.println(persona1.getTitular());
    // System.out.println(persona1.getCantidad());

    // persona1.setCantidad(500);
    // System.out.println("Despues de agregar 500 a la cuenta.");
    // System.out.println(persona1.getCantidad());

    // Ingreso dinero a la cuenta
    persona1.ingresar(Double.parseDouble(JOptionPane.showInputDialog("Ingrese una cantidad a la cuenta: ")));
    // Retirar dinero a la cuenta
    persona1.retirar(Double.parseDouble(JOptionPane.showInputDialog("Indique al cantidad a retirar de la cuenta:")));

    System.out.println(persona1);
  }

}

class Cuenta {

  public Cuenta(String titular, double cantidad) {

    this.titular = titular;

    if (cantidad >= 0) {
      this.cantidad = cantidad;
    } else {
      this.cantidad = 0;
    }
  }

  public Cuenta(String titu) {

    this(titu, 0);
  }

  // Metodos getters
  public String getTitular() {

    return this.titular;
  }

  public double getCantidad() {

    return this.cantidad;
  }

  // Metodos setter
  public void setCantidad(double cantidad) {

    this.cantidad = cantidad;
  }

  public void setTitular(String titular) {

    this.titular = titular;
  }

  public void ingresar(double cant) {

    if (cant >= 0) {
      this.cantidad += cant;
    }
  }

  public void retirar(double cant) {

    if (cant > this.cantidad) {
      this.cantidad = 0;
    } else {
      this.cantidad -= cant;
    }
  }

  @Override
  public String toString() {
    return "El Titular " + this.titular + " tiene " + this.cantidad + " en la cuenta.";
  }

  private String titular;
  private double cantidad;
}