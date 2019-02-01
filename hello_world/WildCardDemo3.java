package hello_world;
import hello_world.GenericStack;
public class WildCardDemo3 {
	public static void main(String[] args){
		
		GenericStack<String> stack1 = new GenericStack<String>();
		GenericStack<Object> stack2 = new GenericStack<Object>();
		stack1.push("sun1");
		stack1.push("heee");
		stack2.push(10);
		stack2.push("|");
		add(stack1, stack2);
		WildCardDemo2.print(stack2);
		
		
	}
	
	public static  <T> void add(GenericStack<T> stack1, GenericStack<? super T> stack2){
		while(!stack1.isEmpty()){
			stack2.push(stack1.pop());
		}
		
	}


}
