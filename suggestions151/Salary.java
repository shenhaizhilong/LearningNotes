package suggestions151;

import java.io.Serializable;

/**
 * @author: shenhaizhilong
 * @date: 2018/6/25 18:41
 */
public class Salary implements Serializable {
    private static final long serialVersionUID = -3372945315983980202L;
    private int hash;

    private double baseSalary;
    private double bonus;

    public Salary(double baseSalary, double bonus)
    {
        this.baseSalary = baseSalary;
        this.bonus = bonus;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return String.format("{baseSalary: %s, bonus: %s}", this.baseSalary, this.bonus );
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) return true;
        if(!(obj  instanceof Salary)) return false;
        Salary others = (Salary) obj;
        return (this.baseSalary == others.baseSalary) && (this.bonus == others.bonus);
    }

    @Override
    public int hashCode() {
        if(hash == 0)
        {
            long bs = Double.doubleToLongBits(this.baseSalary);
            long bn = Double.doubleToLongBits(this.bonus);


            hash = hash*31 + (int)( bs ^ (bs>>>32));
            hash = hash*31 +(int)(bn ^ (bn >>>32));
        }
        return hash;
    }
}
