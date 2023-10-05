package POO.ejercicio4;

//SUBCLASE
class Lavadora extends Electrodomestico {
  private double carga;// en kg
  private final static double cargaDef = 5;

  // Constructores
  public Lavadora(double carga, String color, char consumo, double peso, double precioBase) {
    super(color, consumo, precioBase, peso);
    this.carga = carga;
  }

  public Lavadora(double precioBase, double peso) {
    this(cargaDef, colorDef, consEnergDef, peso, precioBase);
  }

  public Lavadora() {
    this(precioDef, pesoDef);
  }

  // getters
  public double getCarga() {
    return this.carga;
  }

  // Metodos propias de la Clase
  public void precioFinal() {
    super.precioFinal();
    if (this.carga > 30) {
      precioBase += 50;
    }
  }

}
