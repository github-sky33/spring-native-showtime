package cn.mindray.showtime.base.util;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @author: heshiye
 * @date 2023年08月27日
 * @email: heshiye@mindray.com
 * @description:
 */
public class ExceptionUtil {

    /**
     * @author: heshiye
     * @description: 获取 exception 的 StackTrace
     */
    public static String stackTrace(Exception e) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        return pw.toString();
    }


}
