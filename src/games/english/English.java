package games.english;

import games.english.utils.EnglishFrame;
import games.english.utils.EnglishTimer;

import java.io.IOException;

public class English {

    /*

        Author: https://github.com/mertks00

    */

    public static void startGame() throws IOException {

        EnglishFrame.getOpenPanel();
        EnglishTimer timer = new EnglishTimer();
        Thread thread = new Thread(timer);
        thread.start();

    }

}
