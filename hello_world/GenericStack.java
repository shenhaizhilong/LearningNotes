package hello_world;

public class GenericStack<E> {

	private java.util.ArrayList<E> List = new java.util.ArrayList<E>();

	public int getSize() {
		return List.size();
	}

	public E peek() {
		return List.get(List.size() - 1);
	}

	public void push(E o) {
		List.add(o);
	}

	public E pop() {
		E o = List.get(List.size() - 1);
		List.remove(List.size() - 1);
		return o;
	}
	public boolean isEmpty(){
		return List.isEmpty();
	}

}

