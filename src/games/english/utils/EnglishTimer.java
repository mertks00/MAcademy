package games.english.utils;

import main.utils.Frames;

public class EnglishTimer implements Runnable {

    /*

        Author: https://github.com/mertks00

    */

    int longTime = 300;

    public void run()
    {
        try {
            for (int i = longTime; i > 0; i--) {
                EnglishFrame.time.setText("SÜRE: " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Hata");
        }
        System.exit(0);


    }
}
