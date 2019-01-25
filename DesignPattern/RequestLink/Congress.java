package DesignPattern.RequestLink;

public class Congress extends Approver {
    public Congress(String name)
    {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest request) {
        System.out.println("召开董事会审批采购工单：" + request.getNumber()+request.getPurpose());
    }
}
