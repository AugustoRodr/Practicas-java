package POO.ejercicio5;

interface Entregable {
  void entregar();// Cambiara el estado del atributo entregado a true

  void devolver();// Cambiara el estado del atributo entregado a false

  boolean esEntregado();// Devuelve el estado actual del atributo entregado

  int compareTo(Object obj);// Compara las horas estimadas devolviendo un int.
}
