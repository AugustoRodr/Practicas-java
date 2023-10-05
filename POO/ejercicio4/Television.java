package POO.ejercicio4;

//SUBCLASE
class Television extends Electrodomestico {
  private int resolucion;// en pulgadas
  private boolean TDT;
  private final static int resolDef = 20;
  private final static boolean tdtDef = false;

  public Television(int resol, boolean tdt, String color, char consumo, double precio, double peso) {
    super(color, consumo, precio, peso);
    this.resolucion = resol;
    this.TDT = tdt;
  }

  public Television(double precio, double peso) {
    this(resolDef, tdtDef, colorDef, consEnergDef, precio, peso);
  }

  public Television() {
    this(precioDef, pesoDef);
  }

  // getters
  public int getResolucion() {
    return this.resolucion;
  }

  public boolean getTdt() {
    return this.TDT;
  }

  // Metodos propios de la clase
  public void precioFinal() {
    // NOTA: si ejecuto la funcion de precioFinal antes del if, el 30% se aplica al
    // precio donde ya se evaluo el peso y el consumo. De lo contrario, a mi parecer
    // la mejor opcion, si uso la funcion de la clase padre despues del if el 30% se
    // aplica al precio base que se ingresa al ser creado el objeto.
    // super.precioFinal();

    if (this.resolucion > 40 && this.TDT) {
      precioBase += 50 + (precioBase * 0.3);
    } else if (this.resolucion > 40) {
      precioBase += (precioBase * 0.3);
    } else if (this.TDT) {
      precioBase += 50;
    }
    super.precioFinal();
  }
}
