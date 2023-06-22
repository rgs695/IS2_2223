package es.unican.is2.Lista;

import java.util.ArrayList;

public class ListaOrdenadaAcotada<E extends Comparable<E>> implements IListaOrdenadaAcotada<E> {

    private ArrayList<E> lista = new ArrayList<>();
    private int capacidad; //Porque es acotada

    //Constructor
    public ListaOrdenadaAcotada(int capacidad) {
        this.capacidad = capacidad;
    }

    public E get(int indice) throws IndexOutOfBoundsException {
        if (indice < 0 || indice >= lista.size()) {
            throw new IndexOutOfBoundsException();
        }
        return lista.get(indice);
    }

    public void add(E elemento) {
        if (elemento == null) {
            throw new NullPointerException();
        }
        if (lista.size() >= capacidad) {
            throw new IllegalStateException("La lista está llena. No se puede agregar más elementos.");
        }
        int indice = 0;
        if (lista.size() != 0) {
            while (indice < lista.size() && elemento.compareTo(lista.get(indice)) > 0) {
                indice++;
            }
        }
        lista.add(indice, elemento);
    }

    public E remove(int indice) throws IndexOutOfBoundsException {
        if (indice < 0 || indice >= lista.size()) {
            throw new IndexOutOfBoundsException();
        }
        E borrado = lista.remove(indice);
        return borrado;
    }

    public int size() {
        return lista.size();
    }

    public void clear() {
        lista.clear();
    }
}
