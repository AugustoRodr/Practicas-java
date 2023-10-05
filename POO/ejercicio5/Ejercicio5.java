package POO.ejercicio5;

public class Ejercicio5 {
  public static void main(String[] args) {
    Serie[] series = new Serie[5];
    Videojuegos[] juegos = new Videojuegos[5];

    series[0] = new Serie("Casados con hijos", 3, "Comedia", "No tendo idea");
    series[1] = new Serie("Los Simpsons", "Mat Groening");
    series[2] = new Serie();
    series[3] = new Serie("Casi Angeles", "Cris Morena");
    series[4] = new Serie("Dragon Ball Z", 9, "Anime", "Akira Toriyama");

    juegos[0] = new Videojuegos();
    juegos[1] = new Videojuegos("Crash Bandicoot", 150, "Accion", "Naughty Dog");
    juegos[2] = new Videojuegos("Dark Souls", 300);
    juegos[3] = new Videojuegos("Mario Bros", 125);
    juegos[4] = new Videojuegos("Budokai Tenkaichi 3", 106, "Accion", "Bandai Namco");

    int[] decision = { 1, 0, 1, 1, 0 };

    // Entrego algunas series y videojuegos
    for (int i = 0; i < decision.length; i++) {
      if (decision[i] == 1) {
        series[i].entregar();
        juegos[i].entregar();
      }
    }

    // Contar los entregados y devolverlos.
    int contJuegos = 0;
    int contSeries = 0;
    for (int i = 0; i < juegos.length; i++) {
      if (juegos[i].esEntregado()) {
        contJuegos += 1;
        juegos[i].devolver();
      }
      if (series[i].esEntregado()) {
        contSeries += 1;
        series[i].devolver();
      }
    }
    System.out.println("Cantidad de juegos entregados: " + contJuegos);
    System.out.println("Cantidad de series entregados: " + contSeries);

    // Mostrar el juego con mas horas y la seria con mas temporadas
    Serie mayorSerie = series[0];
    Videojuegos mayorJuegos = juegos[0];

    for (int i = 0; i < series.length; i++) {
      if (series[i].compareTo(mayorSerie) == 1) {
        mayorSerie = series[i];
      }
      if (juegos[i].compareTo(mayorJuegos) == 1) {
        mayorJuegos = juegos[i];
      }
    }
    System.out.println("El video juego con mas horas:\n" + mayorJuegos.toString());
    System.out.println("La serie con mas temporadas:\n" + mayorSerie.toString());

  }

}
