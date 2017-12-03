package btree;



import javax.swing.plaf.RootPaneUI;

import Queue.Queue;
import mx.maxa.linkedlist.Cola;
import mx.maxa.linkedlist.ColaFullEx;
import node.node;
public class btree<T extends Comparable<T>> implements Comparable<T> {
	private node<T>     root    = null;
	private int         height  = 0; 
    private Queue<node<T>> nodeCola;
	
	public btree() {
		this.root =  new node<>();
	}
	public btree(T value) {
		this.root =  new node<>(value);
	}
	public void add(T value) {
		if (root.getValue()== null)
			root.setValue(value);
		else
			add(value,root);
		
 	}
	private void add (T value,node<T> root) {
		if (root.getValue().compareTo(value) >= 1) {
			if (root.getLeft() == null) {
				root.setLeft(new node<>(value));
				return;
			}else 
				add(value,root.getLeft());
		}else if (root.getValue().compareTo(value) <= -1 
				|| root.getValue().compareTo(value) == 0) {
			if (root.getRight() == null) {
				root.setRight(new node<>(value));
				return;
			}
			else
				add(value, root.getRight());
		} 
	}
	public boolean remove (T value) {
		node<T> tmp =deepSearch(value); //si lo encontro
		if (tmp!= null)
			return remove(value,tmp,isChild(value));
		return false;
	}
	private boolean remove (T value, node<T> root, node<T> imyourfather) {

		if (isChild(value) == null) {
			node<T> miNode = minSearch(root.getRight());
			miNode.setLeft(root.getLeft());
			this.root =root.getRight();
			return true;
		}
		if (root.getLeft() == null && root.getRight() ==null) {
			if (imyourfather.getLeft()!=null && imyourfather.getLeft().equals(root) )
				imyourfather.setLeft(null);
			else if(imyourfather.getRight()!=null)
				imyourfather.setRight(null);
			return true;
		}else if( root.getLeft()!=null && root.getRight() ==null) {
			if (imyourfather.getLeft().equals(root))
				imyourfather.setLeft(root.getLeft());
			else
				imyourfather.setRight(root.getLeft());
			return true;
		}else if( root.getLeft()==null && root.getRight() !=null) {
			if (imyourfather.getLeft().equals(root))
				imyourfather.setLeft(root.getRight());
			else
				imyourfather.setRight(root.getRight());
			return true;
		}else {
			if (imyourfather.getLeft().equals(root)){
				node<T> left = minSearch(root.getRight());
				left.setLeft(root.getLeft());
				imyourfather.setLeft(root.getRight());
			}else {
				node<T> left = minSearch(root.getRight());
				left.setLeft(root.getLeft());
				imyourfather.setRight(root.getRight());
			}
			return true;
		}
		
	}
	
	public void printInorder() {
		printInorder(root);
	}
	
	private void printInorder(node<T> root) {
		if (root == null) {
			System.out.println("El arbol se encuentra vacio");
		}
		if (root.getLeft() != null)
			printInorder(root.getLeft());
		
		System.out.print(" "+root.getValue().toString());
		
		if(root.getRight()!= null)
			printInorder(root.getRight());
	}
	
	public void printPreorder() {
		printPreorder(root);
	}
	
	private void printPreorder(node<T> root) {
		System.out.print(" "+ root.getValue().toString());
		
		if (root.getLeft() != null)
			printPreorder(root.getLeft());
		
		if (root.getRight() != null)
			printPreorder(root.getRight());
	}
	
	public void printPosOrder() {
		printPosOrder(root);
	}
	
	private void printPosOrder(node<T> root) {
		if (root.getLeft() != null)
			printInorder(root.getLeft());
		if(root.getRight()!= null)
			printInorder(root.getRight());
		
		System.out.print(" "+root.getValue().toString());
		
	}
	
	public node<T> isChild(T value){
		if (deepSearch(value)== null)
			return null;
		return isChild(value,root,null);
	}
	
	private node<T> isChild(T value,node<T>root,node<T> imyourfather ) {
		if (root != null) {
			if (root.getValue().equals(value)) 
				return imyourfather;
			if (root.getValue().compareTo(value)<=-1)
				return isChild(value,root.getRight(),root);
			else
				return isChild(value,root.getLeft(),root);
		}else 
			return null;
	}
	private boolean isEmpty() {
		if (root.getValue() == null) {
			return true;
		}
		return false;
	}
	
	public node<T> deepSearch(T value){
		return deepSearch(value,root);
	}
	
	private node<T> deepSearch(T value, node<T> root){
		if (root != null) {
			if (root.getValue().equals(value)) 
				return root;
			if (root.getValue().compareTo(value)<=-1)
				return deepSearch(value,root.getRight());
			else
				return deepSearch(value,root.getLeft());
		}else 
			return null;
	}
    public node<T> breadthSearch(T value) {
        
        int haltura = height(root);
        nodeCola = new Cola<>(size);
        for (int i = 1; i < haltura; i++) {
            breadthSearch(root, i);

        }
        return null;
    }

    private void breadthSearch(node<T> root, int depth) {
        if (root == null)
            return;
        if (depth == 1) {
            try {
                nodeCola.enQueue(root);
            } catch (ColaFullEx colaFullEx) {
                colaFullEx.printStackTrace();
            }
        } else if (depth > 1) {
            breadthSearch(root.getLeft(), depth - 1);
            breadthSearch(root.getRight(), depth - 1);
        }
    }
	
	private node<T> minSearch(node<T> root){
		while(root.getLeft()!=null) 
			root = root.getLeft();
		return root;
	}
	private node<T> maxSearch(node<T> root){
		while(root.getRight()!=null) 
			root = root.getRight();
		return root;
	}
	public int maxDepth() {
		int countR = 0;
		int countL = 0;
		if (root == null) {
			return 0;
		}
		while(root.getRight()!=null) { 
			root = root.getRight();
			countR++;
		}
		while(root.getLeft()!=null) { 
			root = root.getLeft();
			countL++;
		}
		if (countL > countR) {
			return countL;
		}else
		return countR;
		
	}
	public void clear() {
		root = null;	
		
	}
	private boolean exists(T value) {
		if (isEmpty()) {
			if (value == root) {
				return true;
			}
		}
		return false;
	}
	
	public void Anchura (Nodo Nodo) /* El metodo "Anchura" solicita un parametro "Nodo"(raiz) de tipo "Nodo".*/
	{
	Queue<T> cola= new Queue<>(); /* Se declara una variable "cola" de tipo "Cola" y se crea la instancia por default.*/
	node<T> tmp = null; /* Se declara una variable "T"(temporal) de tipo "Nodo" con valor inicial de "null".*/
	System.out.print("\n\nEl recorrido en Anchura es:\n\n"); /*Se imprime en pantalla.*/
	if(Nodo != null) /* Si el parametro "Nodo" es diferente de "null"...*/
	{
	cola.InsertaFinal (Nodo); /* Se hace una llamada al método "InsertarFinal" pasando como parámetro, el parámetro "Nodo"(RAIZ), como primer nodo en la cola.*/
	while(!(cola.isEmpty())) /* Mientras haya eleentos en la cola ...*/
	{
	tmp = cola.PrimerNodo.datos; /* Se le asigna a "T" el elemento extraído de la cola.*/
	cola.EliminaInicio(); /* Se elimina de cola el elemento.*/
	System.out.println(tmp.dato + " "); /* Se imprime en pantalla.*/
	if (tmp.izq != null) /* Si el nodo izquierdo existe...*/
	cola.InsertaFinal (tmp.izq); /* se inserta el nodo izquierdo como elemento siguiente en la cola.*/
	if (tmp.der != null) /* Si el nodo derecho existe...*/
	cola.InsertaFinal (tmp.der); /* se inserta el nodo derecho como elemento siguiente en la cola.*/
	}
	}
	System.out.println(); /* Se imprime un enter en pantalla.*/
	}

	
	@Override
	public int compareTo(T o) {
		// TODO Auto-generated method stub
		return 0;
	}

}





