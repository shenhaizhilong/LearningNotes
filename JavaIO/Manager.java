package JavaIO;

public class Manager extends Employee {

    private Employee secretary;

    public void setSecretary(Employee secretary) {
        this.secretary = secretary;
    }

    public Employee getSecretary() {
        return secretary;
    }



    public Manager(int ID, String name, double salary, int year, int month, int day)
    {
        super(ID, name, salary, year, month, day);
    }

}
