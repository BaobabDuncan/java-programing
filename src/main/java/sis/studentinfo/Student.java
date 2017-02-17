package sis.studentinfo;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017-02-01.
 */
public class Student {
    static final String IN_STATE = "CO";
    static final int CREDITS_REQUIRED_FOR_FULL_TIME = 12;
    private GradingStrategy gradingStrategy = new BasicGradingStrategy() {};

    public void setGradingStrategy(GradingStrategy gradingStrategy) {
        this.gradingStrategy = gradingStrategy;
    }

    public enum Grade {
        A(4), B(3), C(2), D(1), F(0);
        private int points;

        Grade(int points) {
            this.points = points;
        }

        int getPoints(){
            return points;
        }
    }

    private ArrayList<Grade> grades = new ArrayList<Grade>();
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

    public double getGpa() {
        if (grades.isEmpty()){
            return 0.0;
        }
        double total = 0.0;
        for (Grade grade: grades){
            total += gradingStrategy.getGradePointsFor(grade);

        }
        return total / grades.size();
    }

    public void addGrade(Grade grade) {
        grades.add(grade);
    }
}
