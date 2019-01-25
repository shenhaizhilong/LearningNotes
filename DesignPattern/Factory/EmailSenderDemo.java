package DesignPattern.Factory;

import DesignPattern.AbstractFactory.AbstractCustomer;
import DesignPattern.AbstractFactory.CommonCustomer;
import DesignPattern.AbstractFactory.VipCustomer;

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
