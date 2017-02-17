package util;

/**
 * Created by Administrator on 2017-02-12.
 */
public class StringUtil {
    public final static String NEWLINE = System.getProperty("line.seperaor");

    private StringUtil() {
    }

    public static String appendNewLine(String input) {
        return input + NEWLINE;
    }
}
