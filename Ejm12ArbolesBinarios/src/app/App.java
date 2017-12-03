package app;

import btree.btree;


public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		btree<Integer> numeritos = new btree<Integer>();
		btree<String> names = new btree<String>();
		numeritos.add(0);
		numeritos.add(2);
		numeritos.add(-4);
		numeritos.add(3);
		numeritos.add(-50);
		numeritos.add(10);
		numeritos.add(11);
		numeritos.add(12);
		
		/*numeritos.add(0);
		numeritos.add(0);
	/*	int i=0,value = (int)Math.random()*100;
		
		while (i<10000) {
			numeritos.add((int)Math.random()*100);
			i++;
		}*/
		//numeritos.remove(0);
		numeritos.clear();
		
		//System.out.println("La profundidad es: " + numeritos.maxDepth()); 
		numeritos.printInorder();
		System.out.println("\n---------------");
		//numeritos.printPosOrder();
		System.out.println("\n---------------");
		//numeritos.printPreorder();
	//	while (numeritos.remove(0));
		//System.out.println("");
		//System.out.println("--------------------------------------");
		//numeritos.printInorder();
		
		/*
		node<Integer> tmp = numeritos.isChild(9);
		if (tmp!=null )System.out.println("Padre del 9 es "+tmp.getValue());
		
		
		names.add("Fernando");
		names.add("Rotzana");
		names.add("Jalil");
		names.add("Milton");
		names.add("Chardo");
		names.printInorder();
		*/
		
		
		
	}

}





