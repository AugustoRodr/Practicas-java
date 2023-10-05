package POO.ejercicio2;

import javax.swing.JOptionPane;

/**
 * 2) Haz una clase llamada Persona que siga las siguientes condiciones:
 * -Sus atributos son: nombre, edad, DNI, sexo (H hombre, M mujer), peso y
 * altura. No queremos que se accedan directamente a ellos. Piensa que
 * modificador de acceso es el más adecuado, también su tipo. Si quieres añadir
 * algún atributo puedes hacerlo.
 * -Por defecto, todos los atributos menos el DNI serán valores por defecto
 * según su tipo (0 números, cadena vacía para String, etc.). Sexo sera hombre
 * por defecto, usa una constante para ello.
 * 
 * -Se implantaran varios constructores:
 * +Un constructor por defecto.
 * +Un constructor con el nombre, edad y sexo, el resto por defecto.
 * +Un constructor con todos los atributos como parámetro.
 * 
 * -Los métodos que se implementaran son:
 * +calcularIMC(): calculara si la persona esta en su peso ideal (peso en
 * kg/(altura^2 en m)), si esta fórmula devuelve un valor menor que 20, la
 * función devuelve un -1, si devuelve un número entre 20 y 25 (incluidos),
 * significa que esta por debajo de su peso ideal la función devuelve
 * un 0 y si devuelve un valor mayor que 25 significa que tiene sobrepeso, la
 * función devuelve un 1. Te recomiendo que uses constantes para
 * devolver estos valores.
 * +esMayorDeEdad(): indica si es mayor de edad, devuelve un booleano.
 * +comprobarSexo(char sexo): comprueba que el sexo introducido es correcto. Si
 * no es correcto, sera H. No sera visible al exterior.
 * +toString(): devuelve toda la información del objeto.
 * +generaDNI(): genera un número aleatorio de 8 cifras, genera a partir de este
 * su número su letra correspondiente. Este método sera invocado
 * cuando se construya el objeto. Puedes dividir el método para que te sea más
 * fácil. No será visible al exterior.
 * +Métodos set de cada parámetro, excepto de DNI.
 * 
 * Ahora, crea una clase ejecutable que haga lo siguiente:
 * -Pide por teclado el nombre, la edad, sexo, peso y altura.
 * -Crea 3 objetos de la clase anterior, el primer objeto obtendrá las
 * anteriores variables pedidas por teclado, el segundo objeto obtendrá todos
 * los anteriores menos el peso y la altura y el último por defecto, para este
 * último utiliza los métodos set para darle a los atributos un
 * valor.
 * -Para cada objeto, deberá comprobar si esta en su peso ideal, tiene sobrepeso
 * o por debajo de su peso ideal con un mensaje.
 * -Indicar para cada objeto si es mayor de edad.
 * -Por último, mostrar la información de cada objeto.
 */

public class Ejercicio2 {

  public static void main(String[] args) {

    String nombre = JOptionPane.showInputDialog("Ingrese un nombre: ");
    int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad de la persona: "));
    char sexo = JOptionPane.showInputDialog("Ingrese su sexo hombre(H) o mujer(M):").toUpperCase().charAt(0);
    double altura = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la altura"));
    double peso = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el peso"));

    Persona[] personas = new Persona[3];
    personas[0] = new Persona(nombre, edad, sexo, altura, peso);
    personas[1] = new Persona(nombre, edad, sexo);
    personas[2] = new Persona();

    // Seteo de valores faltantes.
    // persona 3
    personas[2].setNombre("carlos");
    personas[2].setEdad(44);
    personas[2].setAltura(1.78);
    personas[2].setPeso(88);

    // persona 2
    personas[1].setAltura(1.90);
    personas[1].setPeso(99);

    for (Persona p : personas) {
      mensajePeso(p);
      mensajeMayorEdad(p);
      System.out.println(p);
    }

  }

  public static void mensajePeso(Persona objPersona) {
    switch (objPersona.calcularIMC()) {
      case Persona.pesoBajo:// Si o si tengo que acceder a los valores usando la clase y no el objeto
                            // instanciado.
        System.out.println("La persona " + objPersona.getNombre() + " esta por debajo de su peso ideal.");
        break;
      case Persona.pesoIdeal:
        System.out.println("La persona " + objPersona.getNombre() + " esta en su peso ideal.");
        break;
      case Persona.pesoAlto:
        System.out.println("La persona " + objPersona.getNombre() + " tiene sobre peso.");
        break;
    }
  }

  public static void mensajeMayorEdad(Persona objPersona) {
    if (objPersona.esMayorDeEdad()) {
      System.out.println("La persona es mayor de edad.");
    } else {
      System.out.println("La persona no es mayor de edad.");
    }
  }

}

class Persona {

  public Persona(String nom, int edad, char sexo, double alt, double peso) {// Constructor completo
    this.nombre = nom;
    this.edad = edad;
    this.altura = alt;
    this.peso = peso;
    generarDni();
    this.sexo = sexo;
    comprobarSexo();
  }

  public Persona(String nom, int edad, char sex) {// Constructor semi-completo
    this(nom, edad, sex, 0, 0);
  }

  public Persona() {// Constructor por defecto
    this("", 0, sexoDef, 0, 0);
  }

  // funciones para generar DNI--------------------------------
  private void generarDni() {
    final int divisor = 23;

    // Genero el numero de DNI de 8 digitos
    int numDni = ((int) Math.floor(Math.random() * (100000000 - 10000000) + 10000000));
    int res = numDni - (numDni / divisor * divisor);

    // Calculamos la letra dni
    char letraDni = generaLetraDni(res);

    // Pasamos el DNI a String
    this.dni = Integer.toString(numDni) + letraDni;

  }

  private char generaLetraDni(int res) {
    char[] letras = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y',
        'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z',
        'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E' };
    return letras[res];
  }
  // ----------------------------------------------------------

  public int calcularIMC() {
    double calculo = peso / (Math.pow(altura, 2));
    if (calculo < 20) {
      return pesoBajo;
    } else if (calculo >= 20 && calculo <= 25) {
      return pesoIdeal;
    } else {
      return pesoAlto;
    }
  }

  public boolean esMayorDeEdad() {

    if (this.edad > 17) {
      return true;
    }
    return false;
  }

  // Si ingresa cualquier otro valor se le asigna 'H'
  private void comprobarSexo() {
    if (sexo != 'M' && sexo != 'H') {
      this.sexo = sexoDef;
    }
  }

  public String toString() {
    String sexo;
    if (this.sexo == 'H') {
      sexo = "Hombre";
    } else {
      sexo = "Mujer";
    }

    return "Informacion de la persona: \n"
        + "Nombre: " + nombre
        + "\nEdad: " + edad + " años\n"
        + "Sexo: " + sexo
        + "\nDNI: " + dni
        + "\nPeso: " + peso + " kg"
        + "\nAltura: " + altura + " Metros";
  }

  // getters
  public String getNombre() {
    return nombre;
  }

  public int getEdad() {
    return edad;
  }

  public char getSexo() {
    return sexo;
  }

  public double getAltura() {
    return altura;
  }

  public double getPeso() {
    return peso;
  }

  // setters
  public void setNombre(String nom) {
    this.nombre = nom;
  }

  public void setEdad(int edad) {
    this.edad = edad;
  }

  public void setSexo(char sexo) {
    this.sexo = sexo;
  }

  public void setAltura(double alt) {
    this.altura = alt;
  }

  public void setPeso(double peso) {
    this.peso = peso;
  }

  private String nombre;
  private int edad;
  private String dni;
  private char sexo;
  private double altura;
  private double peso;
  public static final int pesoIdeal = 0;
  public static final int pesoAlto = 1;
  public static final int pesoBajo = -1;
  private final static char sexoDef = 'H';
}
