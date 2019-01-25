package DesignPattern.RequestLink;

public class President extends Approver {

    public President(String name)
    {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest request) {
        if(request.getMount() <500000)
        {
            System.out.println("董事长：" + this.name + "审批采购工单" + request.getNumber() + request.getPurpose());
        }else {
            this.successor.processRequest(request);
        }
    }
}
