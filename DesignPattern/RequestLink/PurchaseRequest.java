package DesignPattern.RequestLink;

public class PurchaseRequest {
    private double mount;
    private int number;
    private String purpose;

    public PurchaseRequest(double mount, int number, String purpose)
    {
        this.mount = mount;
        this.number = number;
        this.purpose = purpose;
    }

    public void setMount(double mount) {
        this.mount = mount;
    }

    public double getMount() {
        return mount;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getPurpose() {
        return purpose;
    }
}
