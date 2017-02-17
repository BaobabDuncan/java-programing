package sis.studentinfo;

import java.util.*;

/**
 * Created by Administrator on 2017-02-17.
 */
abstract public class Session implements Comparable<Session> {
    private static int count;
    private String department;
    private String number;
    private List<Student> students = new ArrayList<Student>();
    protected Date startDate;
    private int numberOfCredits;

    protected Session(String department, String number, Date startDate) {
        this.department = department;
        this.number = number;
        this.startDate = startDate;
    }

    public int compareTo(Session that) {
        int compare = this.getDepartment().compareTo(that.getDepartment());
        if (compare == 0){
            compare = this.getNumber().compareTo(that.getNumber());
        }
        return compare;
    }

    public void setNumberOfCredits(int numberOfCredits) {
        this.numberOfCredits = numberOfCredits;
    }

    public String getDepartment() {
        return department;
    }

    public String getNumber() {
        return number;
    }

    public int getNumberOfStudents() {
        return students.size();
    }

    public void enroll(Student student) {
        student.addCredits(numberOfCredits);
        students.add(student);
    }

    public Student get(int index) {
        return students.get(index);
    }

    protected Date getStartDate() {
        return startDate;
    }

    public List<Student> getAllStudents() {
        return students;
    }

    abstract protected int getSessionLength();

    public Date getEndDate() {
        final int dayInWeek = 7;
        final int dayFromFridayToMonday = 3;
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(getStartDate());
        int numberOfDays = getSessionLength() * dayInWeek - dayFromFridayToMonday;
        calendar.add(Calendar.DAY_OF_YEAR, numberOfDays);
        return calendar.getTime();
    }
}
