package hello_world;

public class TestReference {  
    public static void main(String[] args) {  
        String b = "hi";    
        String a = "hello";    
        a = b;    
        b = "love";  
        System.out.println("a: " + a);  

//        ==========================================================  
        Test1 test = new Test1();
        test.setId(1);  
        Test1 test2 = new Test1();
        test2.setId(2);  
          
        System.out.println("before swap");  
        System.out.println(test);  
        System.out.println(test2);  
          
        swap(test, test2);  
          
//        Test test3 = null;  
//        test3 = test;  
//        test = test2;  
//        test2 = test3;  
          
        

        System.out.println("after swap");  
        System.out.println(test);  
        System.out.println(test2);  
          
    }  
      
    public static void swap(Test1 a , Test1 b) {
        Test1 temp;
        temp = a;  
        a = b;  
        b = temp;  
    }  
}  
  
class Test1{
    private int id;  
    public void setId(int id) {  
        this.id = id;  
    }  
    public int getId(){  
        return id;  
    }  
//  public String toString(){  
//      return id + "";  
//  }  
}  