/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructurasdatos;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author warriorminds
 */
public class Cola<Elemento> implements Iterable {
    
    private int N;
    private Nodo<Elemento> primero;
    private Nodo<Elemento> ultimo;
    
    public void enqueue(Elemento elemento) {
        Nodo anteriorUltimo = ultimo;
        ultimo = new Nodo();
        ultimo.elemento = elemento;
        ultimo.siguiente = null;
        
        if (isEmpty()) {
            primero = ultimo;
        } else {
            anteriorUltimo.siguiente = ultimo;
        }
        N++;
    }
    
    public Elemento dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        
        Elemento elemento = primero.elemento;
        primero = primero.siguiente;
        
        if (isEmpty()) {
            ultimo = null;
        }
        
        N--;
        return elemento;
    }
    
    public boolean isEmpty() {
        return primero == null;
    }
    
    public int size() {
        return N;
    }
    
    public Elemento peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return primero.elemento;
    }

    @Override
    public Iterator iterator() {
        return new Iterador();
    }
    
    private class Nodo<Elemento> {
        Elemento elemento;
        Nodo siguiente;
    }
    
    private class Iterador implements Iterator<Elemento>{
        
        private Nodo<Elemento> actual = primero;
        
        @Override
        public boolean hasNext() {
            return actual.siguiente != null;
        }

        @Override
        public Elemento next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Elemento siguiente = actual.elemento;
            actual = actual.siguiente;
            return siguiente;
        }
    }
}
