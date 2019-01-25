package DesignPattern.RequestLink;

public class VicePresident extends Approver {

    public VicePresident(String name)
    {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest request) {
        if(request.getMount() < 100000)
        {
            System.out.println("副董事长：" + this.name + "审批采购工单" +request.getNumber() + request.getPurpose());
        }else {
            this.successor.processRequest(request);
        }
    }
}
