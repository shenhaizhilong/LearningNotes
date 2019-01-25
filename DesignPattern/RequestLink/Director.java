package DesignPattern.RequestLink;

public class Director extends Approver {

    public Director(String name)
    {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest request) {
        if(request.getMount() < 50000)
        {
            System.out.println("主任：" + this.name + "审批采购单:" + request.getNumber()+ request.getPurpose());
        }else {
            this.successor.processRequest(request);
        }
    }
}
