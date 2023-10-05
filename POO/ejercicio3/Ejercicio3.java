package POO.ejercicio3;

import java.security.SecureRandom;

import javax.swing.JOptionPane;

public class Ejercicio3 {
  public static void main(String[] args) {

    Password[] contrasenias = new Password[Integer.parseInt(JOptionPane.showInputDialog("Tamaño del array"))];
    int longPassword = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la longitud del password"));

    boolean[] evalPassword = new boolean[contrasenias.length];

    for (int i = 0; i < contrasenias.length; i++) {
      contrasenias[i] = new Password(longPassword);
      evalPassword[i] = contrasenias[i].esFuerte();
      System.out.println(contrasenias[i].getContrasenia() + " " + evalPassword[i]);
    }

  }

}

class Password {
  private String contraseña;
  private int longitud;
  private final static int longDef = 8;

  public Password(int longitud) {
    this.longitud = longitud;
    generarPassword(longitud);
  }

  public Password() {
    this(longDef);
  }

  private void generarPassword(int len) {
    String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    SecureRandom random = new SecureRandom();
    String contr = "";

    for (int i = 0; i < len; i++) {
      int randomIndex = random.nextInt(chars.length());
      contr += chars.charAt(randomIndex);
    }
    this.contraseña = contr;
  }

  public boolean esFuerte() {

    char[] contra = this.contraseña.toCharArray();
    int cantMay = 0, cantMin = 0, cantNum = 0;

    for (int i = 0; i < contra.length; i++) {
      if ("ABCDEFGHIJKLMNOPQRSTUVWXYZ".contains(String.valueOf(contra[i]))) {
        cantMay += 1;
      }
      if ("abcdefghijklmnopqrstuvwxyz".contains(String.valueOf(contra[i]))) {
        cantMin += 1;
      }
      if ("0123456789".contains(String.valueOf(contra[i]))) {
        cantNum += 1;
      }
    }

    if (cantMay > 2 && cantMin > 1 && cantNum > 5) {
      return true;
    } else {
      return false;
    }
  }

  public String getContrasenia() {
    return contraseña;
  }

  public int getLongitud() {
    return longitud;
  }

  public void setLongitud(int len) {
    longitud = len;
  }

}
