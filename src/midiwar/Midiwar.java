package midiwar;

import java.util.ArrayList;
import java.util.Random;

/*
* Class that manages the correct development of the game
*/

// This class is a singleton: it means that there can only be one instance

public class Midiwar {
    
    // Stores the person who is currently playing
    private Player currentPlayer;
    
    // Stores the total of the players playing the game
    private ArrayList<Player> players = new ArrayList();
    
    // Stores the monster which is currently fighting against the player
    Monster currentMonster;
    
    // Instance of Card Dealer class
    CardDealer dealer;
    
    /**************************************************************************/
    // Code for making this class a singleton
    
    private static final Midiwar instance = new Midiwar();
    
    // The private constructor ensures that this class will not be instanciable
    // from other classes
    private Midiwar() { }
    
    public static Midiwar getInstance() {
        return instance;
    }
    
    /**************************************************************************/
    // PRIVATE METHODS
    
    /*
    Initializes the 'players' array, adding as many players as they are
    on the 'names' string, which contains the names of the players
    */
    private void initPlayers (ArrayList<String> names)
    {
        for (String a_name : names)
        {
            Player a_player = new Player (a_name);
            players.add(a_player);
        }
    }
    
    /*
    Decides who is the next player to play.
    First, it calculates the index of the next player in the array of players
    Then, if this is the first move, it generates a random number between
    0 and the number of players minus 1
    */
    private Player nextPlayer ()
    {
        int posToReturn;
        Player playerRet;
        
        if (currentPlayer == null)
        {
            Random r = new Random();
            posToReturn = r.nextInt(players.size());
        }
        else
        {
            int count = 0;
            
            while (currentPlayer != players.get(count))
                count++;
            
            count = count + 1;
            
            posToReturn = count;
            
            if (posToReturn == players.size())
                posToReturn = 0;
        }
        
        playerRet = players.get(posToReturn);
        
        return(playerRet);
    }
    
    /*
    Checks if the current player fulfills the rules of the game to end up
    its turn making use of the 'validState' method of the Player class
    */
    private boolean nextTurnIsAllowed()
    {
        boolean retValue = false;
        
        if ((currentPlayer == null) || (currentPlayer.validState()))
        {
            retValue = true;
        }
        
        return (retValue);
    }
    
    /*
    Assignation of enemies between the players. This method has been made to
    use with n players
    */
    private void setEnemies()
    {   
        Random r = new Random();
        
        // Assigns a random position of the list to the enemy attribute of 
        // another player
        for (int i = 0; i < players.size(); i++)
        {
            int randomPos = r.nextInt(players.size());
            
            while (i == randomPos)
                randomPos = r.nextInt(players.size());
            
            players.get(i).setEnemy(players.get(randomPos));
        }
    }
    
    /**************************************************************************/
    // GET METHODS
    
    public Player getCurrentPlayer ()
    {
        return currentPlayer;
    }
    
    public Monster getCurrentMonster ()
    {
        return currentMonster;
    }
    
    /**************************************************************************/
    // METHODS FOR DISCARDING TREASURES
    
    /*
    Erases all the visible treasures, and if the player has a pending bad
    consequence, the treasures are deleted from the pending bad consequence too.
    Eventually the player will die if he has no treasures (dieOfNoTreasures
    method) and the deleted treasures will be returned to the card dealer
    */
    public void discardVisibleTreasures (ArrayList <Treasure> treasures)
    {
        for (int i = 0; i < treasures.size(); i++)
        {
            Treasure a_treasure = treasures.get(i);
            currentPlayer.discardVisibleTreasure(a_treasure);
            dealer.giveTreasureBack(a_treasure);
        }
    }
    
    public void discardHiddenTreasures (ArrayList <Treasure> treasures)
    {
        for (int i = 0; i < treasures.size(); i++)
        {
            Treasure a_treasure = treasures.get(i);
            currentPlayer.discardHiddenTreasure(a_treasure);
            dealer.giveTreasureBack(a_treasure);
        }
    }
    
    /**************************************************************************/
    // OTHER METHODS
    
    /*
    If the combat level of the current player is above the level of the monster
    he will fight against, the prize is applied to him. Otherwise, the player
    loses the combat and has to suffer the bad consequence
    */
    public CombatResult developCombat ()
    {
        CombatResult combatResult = currentPlayer.combat(currentMonster);
        
        // Replaces the current player with the respective cultist one
        if (combatResult == CombatResult.LOSEANDCONVERT)
        {
            CardDealer cardDealer = CardDealer.getInstance();
            Cultist nextCultistCard = cardDealer.nextCultist();
            
            Player newCultistPlayer = 
                    new CultistPlayer(currentPlayer, nextCultistCard);
            
            int index = players.indexOf(currentPlayer);
            players.add(index, newCultistPlayer);
            players.remove(index + 1);
            
            // Checks the enemies on the other players, and if one of them is 
            // the current one, exchanges the new cultist player for it
            for (Player a_player : players)
            {
                if (a_player != newCultistPlayer)
                {
                    if (a_player.enemy == currentPlayer)
                        a_player.enemy = newCultistPlayer;
                }
            }
            
            currentPlayer = newCultistPlayer;
        }
        
        dealer.giveMonsterBack(currentMonster);
        
        return combatResult;
    }
    
    /*
    For the current player, this array makes visible the desired array of
    treasures if the player, for each one, is able to do so
    */
    public void makeTreasuresVisible (ArrayList <Treasure> treasures)
    {
        for (int i = 0; i < treasures.size(); i++)
        {
            Treasure t = treasures.get(i);
            currentPlayer.makeTreasureVisible(t);
        }
    }
    
    /*
    Initializes the game by requesting CardDealer class to initialize both 
    card decks, initializing the players assigning them a name and a enemy,
    and calling nextTurn method to begin the first turn
    */
    public void initGame (ArrayList<String> players)
    {
        dealer = CardDealer.getInstance();
        
        // Initializes the players on the game
        initPlayers(players);
        
        // Assigns the enemies between the players
        setEnemies();
        
        // Initializes the decks of cards
        dealer.initCards();
        
        // Initializes the first turn
        nextTurn();
    }
    
    /*
    Sets the next player and the next monster on the game and if the next player
    is dead, brings him to life and initializes his treasures
    */
    public boolean nextTurn ()
    {
        boolean stateOK = nextTurnIsAllowed();
        
        if (stateOK)
        {
            currentMonster = dealer.nextMonster();
            currentPlayer = nextPlayer();
            boolean dead = currentPlayer.isDead();
            
            if (dead)
            {
                currentPlayer.initTreasures();
            }
        }
        
        return stateOK;
    }
    
    /*
    Returns 'true' if the result paratemer is WINGAME
    */
    public boolean endOfGame (CombatResult result)
    {
        boolean ret_result = false;
        
        if (result == CombatResult.WINGAME)
            ret_result = true;
        
        return ret_result;
    }
}
