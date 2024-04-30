package midiwar;

/*
* This class manages the cards of type Treasure and their attributes
*/

public class Treasure {
    
    private TreasureKind type;      // Type of the treasure
    
    private String name;            // Name of the treasure 
    private int bonus;              // Bonus that the treasure can give
    
    /**************************************************************************/
    // CONSTRUCTOR
    
    public Treasure(String n, int bonus, TreasureKind t)
    {
        this.name = n;
        this.bonus = bonus;
        this.type = t;
    }
    
    /**************************************************************************/
    // GET METHODS
    
    public TreasureKind getType()
    {
        return type;
    }

    public String getName()
    {
        return name;
    }

    public int getBonus()
    {
        return bonus;
    }
    
    /**************************************************************************/
    // TO STRING
    
    @Override
    public String toString()
    {
        return ("\nName: " + name + "\nBonus: " + bonus + "\nType: " + type);
    }
    
}
