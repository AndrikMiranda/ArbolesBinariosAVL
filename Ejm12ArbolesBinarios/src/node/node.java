package node;

public class node<T> implements Comparable<T> {
	private T       value=null;
	private node<T> left=null;
	private node<T> right=null;
	private long    index =0; 
	
	public long getIndex() {
		return index;
	}
	public void setIndex(long index) {
		this.index = index;
	}
	public node() {
		// TODO Auto-generated constructor stub
		this.value = null;
		
	}
	public node(T value){
		this.value = value;
	}
	
	public T getValue() {
		return value;
	}
	public void setValue(T value) {
		this.value = value;
	}
	
	public node<T> getLeft() {
		return left;
	}
	public void setLeft(node<T> left) {
		this.left = left;
	}
	public node<T> getRight() {
		return right;
	}
	public void setRight(node<T> right) {
		this.right = right;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
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
	
}
