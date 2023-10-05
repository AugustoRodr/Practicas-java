package POO.ejercicio6;

class Libro {
  private String ISBN;
  private String titulo;
  private String autor;
  private int nPaginas;

  public Libro(String isbn, String titulo, String autor, int paginas) {
    this.ISBN = isbn;
    this.titulo = titulo;
    this.autor = autor;
    this.nPaginas = paginas;
  }

  // Getters
  public String getISBN() {
    return this.ISBN;
  }

  public String getTitulo() {
    return this.titulo;
  }

  public String getAutor() {
    return this.autor;
  }

  public int getPaginas() {
    return this.nPaginas;
  }

  // Setters
  public void setISBN(String isbn) {
    this.ISBN = isbn;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public void setAutor(String autor) {
    this.autor = autor;
  }

  public void setPaginas(int paginas) {
    this.nPaginas = paginas;
  }

  public String toString() {
    return "El libro: " + this.titulo +
        " con ISBN: " + this.ISBN +
        " Creado por el autor: " + this.autor +
        " tiene " + this.nPaginas + " paginas";
  }

  // Determinar cual tiene mas paginas
  public int compareTo(Object obj) {
    // -1->menor; 0->igual; 1->mayor
    int comparacion = -1;
    Libro ref = (Libro) obj;
    if (this.nPaginas > ref.getPaginas()) {
      comparacion = 1;
    } else if (this.nPaginas == ref.getPaginas()) {
      comparacion = 0;
    }
    return comparacion;
  }
}
