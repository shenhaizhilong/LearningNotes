package hello_world;
import hello_world.GenericStack;
import hello_world.WildCardDemo3;
public class WildCardDemo4 {
	public static void main(String[] args){
		
		GenericStack<String> stack1 = new GenericStack<String>();
		GenericStack<Object> stack2 = new GenericStack<Object>();
		stack1.push("sun1");
		stack1.push("heee");
		stack2.push(10);
		stack2.push("|");
		WildCardDemo3.add(stack1, stack2);
		WildCardDemo2.print(stack2);
		
		
	}


}
