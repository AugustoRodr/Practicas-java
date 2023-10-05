package POO.ejercicio5;

class Serie implements Entregable {
  private String titulo;
  private int numTemporadas;
  private boolean entregado;
  private String genero;
  private String creador;

  // Valores x Defecto
  private final static String tituloDef = "";
  private final static int tempDef = 3;
  private final static boolean entregDef = false;
  private final static String genDef = "";
  private final static String creadDef = "";

  // 3 Constructores
  public Serie(String titulo, int temporadas, String genero, String creador) {
    this.titulo = titulo;
    this.numTemporadas = temporadas;
    this.genero = genero;
    this.creador = creador;
    this.entregado = entregDef;
  }

  public Serie(String titulo, String creador) {
    this(titulo, tempDef, genDef, creador);
  }

  public Serie() {
    this(tituloDef, creadDef);
  }

  // Sobreescribo los metodos
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
    Serie ref = (Serie) obj;
    if (numTemporadas > ref.getTemporadas()) {
      estado = 1;
    } else if (numTemporadas == ref.getTemporadas()) {
      estado = 0;
    }
    return estado;
  }

  // getters
  public String getTitulo() {
    return this.titulo;
  }

  public int getTemporadas() {
    return this.numTemporadas;
  }

  public String getGenero() {
    return this.genero;
  }

  public String getCreador() {
    return this.creador;
  }

  // setters
  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public void setTemporada(int temporadas) {
    this.numTemporadas = temporadas;
  }

  public void setGenero(String gen) {
    this.genero = gen;
  }

  public void setCreador(String creador) {
    this.creador = creador;
  }

  // Metodo toString()
  public String toString() {
    return "Titulo: " + this.titulo
        + " Numero de Temporadas: " + this.numTemporadas
        + " Genero: " + this.genero
        + " Creador: " + this.creador;
  }
}
