
package estructurasdatos;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author warriorminds
 */
public class Pila<Elemento> implements Iterable {
    
    private int N;
    private Nodo<Elemento> primero;
    
    
    public void push(Elemento elemento) {
        Nodo primeroViejo = primero;
        primero = new Nodo();
        primero.elemento = elemento;
        primero.siguiente = primeroViejo;
        N++;
    }
    
    public Elemento pop() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        
        Elemento elemento = primero.elemento;
        primero = primero.siguiente;  
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

        Nodo<Elemento> actual = primero;
        
        @Override
        public boolean hasNext() {
            return actual != null;
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
