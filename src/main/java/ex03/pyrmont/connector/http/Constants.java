package ex03.pyrmont.connector.http;

import java.io.File;

public final class Constants {
    public static final String WEB_ROOT = getWebRoot();
    public static final String Package = "ex03.pyrmont.connector.http";
    // variables below are not used in chapter 3
    public static final int DEFAULT_CONNECTION_TIMEOUT = 60000;
    public static final int PROCESSOR_IDLE = 0;
    public static final int PROCESSOR_ACTIVE = 1;

//    public static void main(String[] args) {
//        System.out.println(getWebRoot());
//    }

    private static String getWebRoot() {
        // maven build directory name
        final String classes = "classes";
        String absolutePath = Constants.class.getResource("").getPath().replace("/", File.separator);
        // on Windows
        if (absolutePath.contains(":")) {
            absolutePath = absolutePath.substring(1);
        }
        absolutePath = absolutePath.substring(0, absolutePath.indexOf(classes) + classes.length() + 1);
        return absolutePath + "webroot";
    }
}
