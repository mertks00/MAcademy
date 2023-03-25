package games.chemical.utils;

public class ChemicalPoint {

        /*

            Author: https://github.com/mertks00

        */

    private static int point = 1;
    private static int false_point = 1;

    public static void addPoint() {

        ChemicalFrame.dogru.setText("DOĞRU: " + point++);

    }

    public static void removePoint() {

        ChemicalFrame.yanlis.setText("YANLIŞ: " + false_point++);

    }

}
