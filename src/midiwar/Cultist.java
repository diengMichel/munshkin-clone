package midiwar;

/*
* Class that manages each card of the cultist card deck
*/

public class Cultist {
    
    private String name;                // Name of the cultist player
    private int gainedLevels;           // Number the gained levels thanks to
                                        // being cultist player
    
    /**************************************************************************/
    // CONSTRUCTOR
    
    public Cultist (String name, int gainedLevels)
    {
        this.name = name;
        this.gainedLevels = gainedLevels;
    }
    
    /**************************************************************************/
    // GET METHODS
    
    public int getGainedLevels()
    {
        return gainedLevels;
    }
    
}
