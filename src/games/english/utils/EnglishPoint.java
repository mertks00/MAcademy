package games.english.utils;

public class EnglishPoint {

    /*

        Author: https://github.com/mertks00

    */

    public static int point = 1;
    public static int false_point = 1;

    public static void addPoint() {

        EnglishFrame.dogru.setText("DOĞRU: " + point++);

    }

    public static void removePoint() {

        EnglishFrame.yanlis.setText("YANLIŞ: " + false_point++);

    }

}
