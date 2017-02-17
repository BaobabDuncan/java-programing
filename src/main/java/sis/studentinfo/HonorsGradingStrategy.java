package sis.studentinfo;

/**
 * Created by Administrator on 2017-02-14.
 */
public class HonorsGradingStrategy extends BasicGradingStrategy{

    public int getGradePointsFor(Student.Grade grade) {
        int points = super.getGradePointsFor(grade);
        if (points > 0)
            points +=1;
        return points;
    }
}
