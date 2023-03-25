package games.chemical.utils;

import games.english.utils.EnglishFrame;

public class ChemicalTimer implements Runnable {

    /*

        Author: https://github.com/mertks00

    */

    int longTime = 480;

    public void run() {

            try {
                for (int i = longTime; i > 0; i--) {
                    ChemicalFrame.time.setText("SÜRE: " + i);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                System.out.println("Hata");
            }
            System.exit(0);
        
    }

}
