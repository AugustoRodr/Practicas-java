package POO.ejercicio5;

class Videojuegos implements Entregable {
  private String titulo;
  private int hEstimadas;
  private boolean entregado;
  private String genero;
  private String compania;

  // Valores por default
  private final static int hEstimadasDef = 10;
  private final static boolean entregadoDef = false;
  private final static String tituloDef = "";
  private final static String genDef = "";
  private final static String companiaDef = "";

  // Constructores
  public Videojuegos(String titulo, int horas, String genero, String compania) {
    this.titulo = titulo;
    this.hEstimadas = horas;
    this.genero = genero;
    this.compania = compania;
    this.entregado = entregadoDef;
  }

  public Videojuegos(String titulo, int horas) {
    this(titulo, horas, genDef, companiaDef);
  }

  public Videojuegos() {
    this(tituloDef, hEstimadasDef);
  }

  // Soobreescribo los metodos de la interfaz
  public void entregar() {
    this.entregado = true;
  }

  public void devolver() {
    this.entregado = false;
  }

  public boolean esEntregado() {
    return this.entregado;
  }

  public int compareTo(Object obj) {
    int estado = -1;
    Videojuegos ref = (Videojuegos) obj;
    if (this.hEstimadas > ref.getHoras()) {
      estado = 1;
    } else if (this.hEstimadas == ref.getHoras()) {
      estado = 0;
    }
    return estado;
  }

  // getters

  public String getTitulo() {
    return this.titulo;
  }

  public int getHoras() {
    return this.hEstimadas;
  }

  public String getGenero() {
    return this.genero;
  }

  public String getCompania() {
    return this.compania;
  }

  // setters
  public void setTitulo(String tituloNew) {
    this.titulo = tituloNew;
  }

  public void setHoras(int horas) {
    this.hEstimadas = horas;
  }

  public void setGenero(String generoNew) {
    this.genero = generoNew;
  }

  public void setCompania(String companiaNew) {
    this.compania = companiaNew;
  }

  public String toString() {
    return "Titulo: " + this.titulo
        + " Horas estimadas: " + this.hEstimadas
        + " Genero: " + this.genero
        + " Compania: " + this.compania;
  }
}
