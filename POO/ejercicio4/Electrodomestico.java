package POO.ejercicio4;

//SUPERCLASE
class Electrodomestico {

  protected double precioBase;// en euros
  protected String color;
  protected char consEnergectico;
  protected double peso;// en kg
  protected final static String colorDef = "blanco";
  protected final static double precioDef = 100;
  protected final static char consEnergDef = 'F';
  protected final static double pesoDef = 5;

  // Constructores
  public Electrodomestico(String color, char consumo, double precioBase, double peso) {
    this.precioBase = precioBase;
    this.peso = peso;
    comprobarConsumoEnergetico(consumo);
    comprobarColor(color);
  }

  public Electrodomestico(double precioBase, double peso) {
    this(colorDef, consEnergDef, precioBase, peso);
  }

  public Electrodomestico() {
    this(precioDef, pesoDef);
  }

  // getters
  public String getColor() {
    return this.color;
  }

  public char getConsumo() {
    return this.consEnergectico;
  }

  public double getPeso() {
    return this.peso;
  }

  public double getPrecio() {
    return precioBase;
  }

  private void comprobarConsumoEnergetico(char letra) {
    if (!"ABCDEF".contains(String.valueOf(letra))) {
      this.consEnergectico = consEnergDef;
    } else {
      this.consEnergectico = letra;
    }
  }

  private void comprobarColor(String c) {
    if (!"blanco,negro,rojo,azul,gris".contains(c)) {
      this.color = colorDef;
    } else {
      this.color = c;
    }
  }

  public void precioFinal() {
    switch (this.consEnergectico) {
      case 'A':
        this.precioBase += 100;
        break;
      case 'B':
        this.precioBase += 80;
        break;
      case 'C':
        this.precioBase += 60;
        break;
      case 'D':
        this.precioBase += 50;
        break;
      case 'E':
        this.precioBase += 30;
        break;
      case 'F':
        this.precioBase += 10;
        break;
    }
    if (this.peso > 0 && this.peso <= 19) {
      this.precioBase += 10;
    } else if (this.peso > 19 && this.peso <= 49) {
      this.precioBase += 50;
    } else if (this.peso > 49 && this.peso <= 79) {
      this.precioBase += 80;
    } else if (this.peso > 79) {
      this.precioBase += 100;
    }
  }

}
