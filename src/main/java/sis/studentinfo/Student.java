package sis.studentinfo;

import sis.report.CourseReport;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2017-02-01.
 */
public class Student {
    static final String IN_STATE = "CO";
    static final int CREDITS_REQUIRED_FOR_FULL_TIME = 12;
    private GradingStrategy gradingStrategy = new BasicGradingStrategy() {};
    private String firstName = "";
    private String lastName = "";
    private String middleName = "";
    private List<Integer> charges = new ArrayList<Integer>();

    public void setGradingStrategy(GradingStrategy gradingStrategy) {
        this.gradingStrategy = gradingStrategy;
    }

    public void addCharge(int charge) {
        charges.add(new Integer(charge));
    }

    public int totalCharges() {
        int total = 0;
        for (Integer charge: charges)
            total += charge.intValue();
        return total;
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

    public Student(String fullName) {
        this.name = fullName;
        this.credits = 0;
        this.state = "";
        List<String> nameParts = split(fullName);
        setName(nameParts);
    }

    private void setName(List<String> nameParts) {
        this.lastName = removeLast(nameParts);
        String name = removeLast(nameParts);
        if (nameParts.isEmpty()){
            this.firstName = name;
        } else{
            this.middleName = name;
            this.firstName = removeLast(nameParts);
        }
    }

    private String removeLast(List<String> list) {
        if (list.isEmpty()) return "";
        return list.remove(list.size()-1);
    }

    private List<String> split(String fullName) {
        List<String> results = new ArrayList<String>();
        for (String name: fullName.split(" "))
            results.add(name);
        return results;
//        return Arrays.asList(name.split(" "));
//        List<String> results = new ArrayList<String>();
//        StringBuffer word = new StringBuffer();
//        for (int index = 0; index < name.length(); index++){
//            char ch = name.charAt(index);
//            if (!Character.isWhitespace(ch))
//                word.append(ch);
//            else
//                if (word.length() > 0){
//                    results.add(word.toString());
//                    word = new StringBuffer();
//                }
//        }
//        if (word.length() > 0)
//            results.add(word.toString());
//        return results;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
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
