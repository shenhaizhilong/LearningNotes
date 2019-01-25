package DesignPattern.RequestLink;

public class Manager extends Approver {

    public Manager(String name)
    {
       super(name);
    }

    @Override
    public void processRequest(PurchaseRequest request) {
        if(request.getMount()<80000)
        {
            System.out.println("经理：" + this.name + "审批采购订单" + request.getNumber() + request.getPurpose());
        }else {
            this.successor.processRequest(request);
        }
    }
}
