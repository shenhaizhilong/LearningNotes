package DesignPattern.RequestLink;

public abstract class Approver {
    protected Approver successor;
    protected String name;

    public Approver(String name)
    {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Approver getSuccessor() {
        return successor;
    }

    public void setSuccessor(Approver successor) {
        this.successor = successor;
    }

    public abstract void processRequest(PurchaseRequest request);
}
