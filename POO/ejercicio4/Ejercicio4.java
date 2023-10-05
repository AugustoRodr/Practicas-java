package POO.ejercicio4;

public class Ejercicio4 {
  public static void main(String[] args) {

    Electrodomestico[] electrodomesticos = new Electrodomestico[10];
    electrodomesticos[0] = new Electrodomestico("rojo", 'B', 150, 60);
    electrodomesticos[1] = new Electrodomestico("azul", 'A', 500, 30);
    electrodomesticos[2] = new Electrodomestico(300, 30);
    electrodomesticos[3] = new Electrodomestico();
    electrodomesticos[4] = new Lavadora();
    electrodomesticos[5] = new Lavadora(400, 60);
    electrodomesticos[6] = new Lavadora(50, "blanco", 'A', 60, 800);
    electrodomesticos[7] = new Television();
    electrodomesticos[8] = new Television(230, 50);
    electrodomesticos[9] = new Television(41, true, "negro", 'B', 350, 50);

    // Muestro el precio final de todos los Electrodomesticos y su suma
    double sumaFinal = 0;
    for (Electrodomestico e : electrodomesticos) {
      if (e instanceof Lavadora) {
        Lavadora temp = (Lavadora) e;
        temp.precioFinal();
        System.out.println(temp.getPrecio());
        sumaFinal += temp.getPrecio();
      } else if (e instanceof Television) {
        Television temp = (Television) e;
        temp.precioFinal();
        System.out.println(temp.getPrecio());
        sumaFinal += temp.getPrecio();
      } else {
        e.precioFinal();
        System.out.println(e.getPrecio());
        sumaFinal += e.getPrecio();
      }
    }

    System.out.println("Total de precio: " + sumaFinal);

  }
}
