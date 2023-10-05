package POO.ejercicio6;

public class Ejercicio6 {
  public static void main(String[] args) {

    Libro libro1 = new Libro("321321321321", "Casa de ensueño", "Mis huevos", 1522);
    Libro libro2 = new Libro("2485786898", "Pensando boberias", "Tu mamá", 1111);

    // Imprecion de Info
    System.out.println(libro1);
    System.out.println(libro2);

    // Indicar mayor numero de paginas
    Libro mayorPagina = libro1;
    if (libro2.compareTo(mayorPagina) == 1) {
      mayorPagina = libro2;
    }
    System.out.println("El libro que tiene mayor numero de paginas es " + mayorPagina.getTitulo());
  }

}
