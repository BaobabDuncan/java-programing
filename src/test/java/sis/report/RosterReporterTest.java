package sis.report;

import junit.framework.TestCase;
import sis.studentinfo.CourseSession;
import sis.studentinfo.DateUtil;
import sis.studentinfo.Student;
import static sis.report.ReportConstant.NEWLINE;

/**
 * Created by Administrator on 2017-02-02.
 */
public class RosterReporterTest extends TestCase {
    public void testRosterReport() {
        CourseSession session = CourseSession.create("ENGL", "101", DateUtil.createDate(2003, 1, 6));
        session.enroll(new Student("A"));
        session.enroll(new Student("B"));

        String rosterReport = new RosterReporter(session).getReport();

        assertEquals(
                RosterReporter.ROSTER_REPORT_HEADER +
                        "A" + NEWLINE +
                        "B" + NEWLINE +
                        RosterReporter.ROSTER_REPORT_FOOTER +
                        "2" + NEWLINE, rosterReport
        );
    }
}
