package midiwar;

import GUI.Dice;
import GUI.MidiwarView;
import GUI.PlayerNamesCapture;
import java.util.ArrayList;

/*
* MAIN CLASS
*/

public class MidiwarGame { 
    
    public static void main (String [] args) {
        // Manages the course of the game
        Midiwar game = Midiwar.getInstance();
        
        // Manages the main window
        MidiwarView midiwarView = new MidiwarView();
        
        // Creates the instance of the graphic dice
        Dice.createInstance(midiwarView);
        
        ArrayList<String> names;
        PlayerNamesCapture namesCapture = 
                new PlayerNamesCapture (midiwarView,true);
        names = namesCapture.getNames();
        
        game.initGame(names);
        
        // Links the model to the view
        midiwarView.setMidiwar(game);
        
        // Shows the window of the application
        midiwarView.setVisible(true);
    }
    
}
