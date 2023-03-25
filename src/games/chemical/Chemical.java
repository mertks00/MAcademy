package games.chemical;

import games.chemical.utils.ChemicalFrame;
import games.chemical.utils.ChemicalTimer;

import java.io.IOException;

public class Chemical {

    /*

        Author: https://github.com/mertks00

    */

    public static void gameStart() throws IOException {

        ChemicalFrame chemicalFrame = new ChemicalFrame();
        chemicalFrame.setVisible(true);

        ChemicalTimer timer = new ChemicalTimer();
        Thread thread = new Thread(timer);
        thread.start();

    }

}
