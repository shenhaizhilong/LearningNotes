package DesignPattern.RequestLink;

public class Client {
    public static void main(String[] args) {
        Approver wjzhang,gyang, longnvxiao,yideng,congress;
        wjzhang = new Director("张无忌");
        gyang = new Manager("杨过");
        longnvxiao = new VicePresident("小龙女");
        yideng = new President("一灯大师");
        congress = new Congress("武林大会");
        wjzhang.setSuccessor(gyang);
        gyang.setSuccessor(longnvxiao);
        longnvxiao.setSuccessor(yideng);
        yideng.setSuccessor(congress);

        PurchaseRequest pr1 = new PurchaseRequest(40000, 100,"购买桌子");
        PurchaseRequest pr2 = new PurchaseRequest(55555, 101,"购买被子" );
        PurchaseRequest pr3 = new PurchaseRequest(70000, 102, "购买杯子");
        PurchaseRequest pr4 = new PurchaseRequest(90000, 103, "购买宝剑");
        PurchaseRequest pr5 = new PurchaseRequest(110000, 104, "购买桃花岛");

        wjzhang.processRequest(pr1);
        wjzhang.processRequest(pr2);
        wjzhang.processRequest(pr3);
        wjzhang.processRequest(pr4);
        wjzhang.processRequest(pr5);


    }
}
