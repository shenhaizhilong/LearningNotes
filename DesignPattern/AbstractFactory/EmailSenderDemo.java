package DesignPattern.AbstractFactory;

public class EmailSenderDemo {
    public static void main(String[] args) {
        AbstractCustomer customer = new CommonCustomer();
        customer.setName("Tom");
        EmailSender emailSender = new EmailSender();
        emailSender.send(customer);
        customer = new VipCustomer();
        customer.setName("Bob");
        emailSender.send(customer);
    }
}
