package sis.studentinfo;

/**
 * Created by Administrator on 2017-02-01.
 */
public class Student {
    static final String IN_STATE = "CO";
    static final int CREDITS_REQUIRED_FOR_FULL_TIME = 12;

    private String name;
    private int credits;
    private String state;

    public Student(String name) {
        this.name = name;
        this.credits = 0;
        this.state = "";
    }

    public String getName() {
        return name;
    }

    public boolean isFullTime() {
        return credits >= CREDITS_REQUIRED_FOR_FULL_TIME;
    }

    public int getCredits() {
        return credits;
    }

    public void addCredits(int credits) {
        this.credits += credits;
    }

    public boolean isInState() {
        return state.equals(IN_STATE);
    }

    public void setState(String state) {
        this.state = state;
    }
}
