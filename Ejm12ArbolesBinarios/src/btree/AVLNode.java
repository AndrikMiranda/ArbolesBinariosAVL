package btree;
/*
 * Basic src.node stored in AVL trees
 */


/**
 *
 * @author fires
 * blog: http://proyectosbeta.blogspot.com/
 */
public class AVLNode<T> implements Comparable<T> {
    public T dato;      	             // el dato del nodo
    public AVLNode<T> izquierdo;            // hijo izquierdo
    public AVLNode<T> derecho;              // hijo derecho
    public int height;                   // altura

    // Constructors
    public AVLNode(T value ){
        this( value, null, null );
    }

    public AVLNode( T value, AVLNode<T> izq, AVLNode<T> der ){
        this.dato = value;
        this.izquierdo = izq;
        this.derecho = der;
        height   = 0;               // altura predeterminada
    }

    /*@Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }*/

    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        return super.equals(obj);
    }
    @Override
    public int compareTo(T o) {
        // TODO Auto-generated method stub
        return 0;
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public AVLNode<T> getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(AVLNode<T> izquierdo) {
        this.izquierdo = izquierdo;
    }

    public AVLNode<T> getDerecho() {
        return derecho;
    }

    public void setDerecho(AVLNode<T> derecho) {
        this.derecho = derecho;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "AVLNode{" +
                "dato=" + dato +
                ", izquierdo=" + izquierdo +
                ", derecho=" + derecho +
                ", height=" + height +
                '}';
    }
}