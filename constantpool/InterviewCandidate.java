package constantpool;

/**
 * @author: shenhaizhilong
 * @date: 2018/6/24 16:52
 */
public class InterviewCandidate {

    private String candidateName;
    private Boolean isSelected;
    private int hash = 0;

    public InterviewCandidate(String candidateName, Boolean isSelected)
    {
        this.candidateName = candidateName;
        this.isSelected = isSelected;
    }

    @Override
    public String toString() {
        return "{name: " + candidateName + ", isSelected: " + isSelected + "}";
    }

    @Override
    public int hashCode() {

        /*
        https://stackoverflow.com/questions/3912303/boolean-hashcode
        So the hashcode for Boolean also impacts the hashcode for InterviewCandidate.
        Now if hashcode for boolean is 0/1 then the boolean value true/false doesnt impact
        the hashcode of the InterviewCandidate significantly - possibly leading to an
        uneven distribution of hashcodes across objects. So 1237/1231 are much better choices
         */
        if(hash == 0)
        {
            hash = hash*31 + candidateName.hashCode();
            hash = hash*31 + isSelected.hashCode();

        }

        return hash;
    }

    public static void main(String[] args) {
        InterviewCandidate interviewCandidate = new InterviewCandidate("tom", true);
        System.out.println(interviewCandidate);
        System.out.println(interviewCandidate.hashCode());

    }
}
