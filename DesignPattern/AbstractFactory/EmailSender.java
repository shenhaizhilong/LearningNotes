package DesignPattern.AbstractFactory;



public class EmailSender {

    public void send(AbstractCustomer customer)
    {
        System.out.println("send email to customer " + customer.getName() + " Customer's type: " + customer.getClass().getSimpleName());
    }
}
