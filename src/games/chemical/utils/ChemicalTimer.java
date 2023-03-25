package games.chemical.utils;

import games.english.utils.EnglishFrame;

public class ChemicalTimer implements Runnable {

    /*

        Author: https://github.com/mertks00

    */
    private volatile boolean running = true;
    int longTime = 480;

    public boolean isRunning() {
        return running;
    }

    public void stopThread(boolean running) {
        this.running = running;
    }

    public void run() {

        while (isRunning()) {
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

}
