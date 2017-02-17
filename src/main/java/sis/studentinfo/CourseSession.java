package sis.studentinfo;

import java.util.*;

/**
 * Created by Administrator on 2017-02-01.
 */
public class CourseSession extends Session {

    private static int count;

    public static CourseSession create(String department, String number, Date startDate){
        return new CourseSession(department, number, startDate);
    }

    protected CourseSession(String department, String number, Date startDate){
        super(department, number, startDate);
        CourseSession.incrementCount();
    }

    protected int getSessionLength() {
        return 16;
    }

    private static void incrementCount() {
        ++count;
    }

    static void resetCount(){
        count = 0;
    }

    static int getCount(){
        return count;
    }

}
