package hello_world;

import hello_world.GenericStack;

public class WildCardDemo2 {
	public static void main(String[] args){
		
		GenericStack<Integer> stack1 = new GenericStack<Integer>();
		stack1.push(1);
		stack1.push(2);
		print(stack1);
	}
	
	public static void print(GenericStack<?> stack){
		while(!stack.isEmpty()){
			System.out.println(stack.pop());
		}
	}

}
