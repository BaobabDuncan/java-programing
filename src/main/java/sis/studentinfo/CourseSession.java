package sis.studentinfo;

import java.util.*;

/**
 * Created by Administrator on 2017-02-01.
 */
public class CourseSession {
    private Date startDate;
    private String department;
    private String number;
    private ArrayList<Student> students = new ArrayList<Student>();
    private int numberOfCredits;

    private CourseSession(String department, String number, Date startDate) {
        this.department = department;
        this.number = number;
        this.startDate = startDate;
    }

    public static CourseSession create(String department, String number, Date startDate){
        return new CourseSession(department, number, startDate);
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

    public Date getEndDate() {
        final int sessionLength = 16;
        final int dayInWeek = 7;
        final int dayFromFridayToMonday = 3;
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(startDate);
        int numberOfDays = sessionLength * dayInWeek - dayFromFridayToMonday;
        calendar.add(Calendar.DAY_OF_YEAR, numberOfDays);
        return calendar.getTime();
    }

    public Date getStartDate() {
        return startDate;
    }

    public ArrayList<Student> getAllStudents() {
        return students;
    }

    public void setNumberOfCredits(int numberOfCredits) {
        this.numberOfCredits = numberOfCredits;
    }
}
