package midiwar;

import java.util.ArrayList;
import java.util.Collections;    // For shuffle function

/*
* Class that manages the decks of cards
*/

// This class is a singleton: it means that there can only be one instance

public class CardDealer {
    
    // Arrays for the treasures (used and unused)
    private ArrayList <Treasure> unusedTreasures = new ArrayList();
    private ArrayList <Treasure> usedTreasures = new ArrayList();
    
    // Arrays for the monsters (used and unused)
    private ArrayList <Monster> usedMonsters = new ArrayList();
    private ArrayList <Monster> unusedMonsters = new ArrayList();
    
    // Array for the unused cultists (a cultist card cannot be given back)
    private ArrayList <Cultist> unusedCultists = new ArrayList();
    
    /**************************************************************************/
    // Code for making this class a singleton
    
    private static final CardDealer instance = new CardDealer();
    
    // The private constructor ensures that this class will not be instanciable
    // from other classes
    private CardDealer() { }
    
    public static CardDealer getInstance() {
        return instance;
    }
    
    /**************************************************************************/
    // PRIVATE METHODS
    
    private void shuffleTreasures ()
    {
        Collections.shuffle(unusedTreasures);
    }
    
    private void shuffleMonsters ()
    {
        Collections.shuffle(unusedMonsters);
    }
    
    private void shuffleCultists ()
    {
        Collections.shuffle(unusedCultists);
    }
    
    ////////////////////////////////////////////////////////////////////////////
    // DEFINITION OF THE TREASURES 
    ////////////////////////////////////////////////////////////////////////////

    private void initTreasureCardDeck ()
    {
        /**********************************************************************/
        // Grincheux Glouton
        unusedTreasures.add(new Treasure("Grincheux Glouton", 4,
                TreasureKind.HELMET));
        
        /**********************************************************************/
        // Frimousse Foudroyantetas de investigacion
        unusedTreasures.add(new Treasure("Frimousse Foudroyante", 3,
                TreasureKind.SHOES));
        
        /**********************************************************************/
        // Marmite Maléfique
        unusedTreasures.add(new Treasure("Marmite Maléfique", 3,
                TreasureKind.HELMET));
        
        /**********************************************************************/
        // Vortex Vélociraptor
        unusedTreasures.add(new Treasure("Vortex Vélociraptor", 2, 
                TreasureKind.ARMOR));
        
        /**********************************************************************/
        // Zinzin Zombie
        unusedTreasures.add(new Treasure("Zinzin Zombie", 1,
                TreasureKind.BOTHHANDS));
        
        /**********************************************************************/
        // Siffleur Spongieux
        unusedTreasures.add(new Treasure("Siffleur Spongieux", 2,
                TreasureKind.HELMET));
        
        /**********************************************************************/
        // Éclat Élastique
        unusedTreasures.add(new Treasure("Éclat Élastique", 4,
                TreasureKind.BOTHHANDS));
        
        /**********************************************************************/
        // Pétard Pantouflard
        unusedTreasures.add(new Treasure("Pétard Pantouflard", 1,
                TreasureKind.ARMOR));
        
        /**********************************************************************/
        // Gargouille Gluante
        unusedTreasures.add(new Treasure("Gargouille Gluante", 3,
                TreasureKind.ONEHAND));
        
        /**********************************************************************/
        // Fouet Fouineur
        unusedTreasures.add(new Treasure("Fouet Fouineur", 2,
                TreasureKind.ONEHAND));
        
        /**********************************************************************/
        // Lampion Lévitant
        unusedTreasures.add(new Treasure("Lampion Lévitant", 3,
                TreasureKind.HELMET));
        
        /**********************************************************************/
        // Bulle Bourrue
        unusedTreasures.add(new Treasure("Bulle Bourrue", 2,
                TreasureKind.ONEHAND));
         
        /**********************************************************************/
        // Tintamarre Tourniquet
        unusedTreasures.add(new Treasure("Tintamarre Tourniquet", 4,
                TreasureKind.ARMOR));
        
        /**********************************************************************/
        // Tournesol Troublant
        unusedTreasures.add(new Treasure("Tournesol Troublant", 4, TreasureKind.BOTHHANDS));
        
        /**********************************************************************/
        // Roulade Rigolote
        unusedTreasures.add(new Treasure("Roulade Rigolote", 2,
                TreasureKind.ONEHAND));
        
        /**********************************************************************/
        // Moustique Mélodique
        unusedTreasures.add(new Treasure("Moustique Mélodique", 4,
                TreasureKind.BOTHHANDS));
        
        /**********************************************************************/
        // Sauterelle Sifflante
        unusedTreasures.add(new Treasure("Sauterelle Sifflante", 2,
                TreasureKind.ONEHAND));
        
        /**********************************************************************/
        // Gribouilleur Grinçant
        unusedTreasures.add(new Treasure("Gribouilleur Grinçant", 2,
                TreasureKind.ARMOR));
        /**********************************************************************/
        // Poireau Péteur
        unusedTreasures.add(new Treasure("Poireau Péteur", 4,
                TreasureKind.BOTHHANDS));
        
        /**********************************************************************/
        // Serpentins Sautillants
        unusedTreasures.add(new Treasure("Serpentins Sautillants", 1,
                TreasureKind.ONEHAND));
        
        /**********************************************************************/
        // Chamallow Chapardeur
        unusedTreasures.add(new Treasure("Chamallow Chapardeur", 5,
                TreasureKind.BOTHHANDS));
        
        /**********************************************************************/
        // Sursaut Soufflé
        unusedTreasures.add(new Treasure("Sursaut Soufflé", 3,
                TreasureKind.BOTHHANDS));
        
        /**********************************************************************/
        // Narcoleptique Nargueur
        unusedTreasures.add(new Treasure("Narcoleptique Nargueur", 2,
                TreasureKind.ONEHAND));
        
        /**********************************************************************/
        // Fouine Fanfaronne
        unusedTreasures.add(new Treasure("Fouine Fanfaronne", 2,
                TreasureKind.HELMET));
        
        /**********************************************************************/
        // Tintinnabule Tordu
        unusedTreasures.add(new Treasure("Tintinnabule Tordu", 3,
                TreasureKind.ONEHAND));
        
        /**********************************************************************/
        // Trampoline Turbulent
        unusedTreasures.add(new Treasure("Trampoline Turbulent", 3,
                TreasureKind.ONEHAND));
        
        /**********************************************************************/
        // Siphon Sérénade
        unusedTreasures.add(new Treasure("Siphon Sérénade", 2,
                TreasureKind.ONEHAND));
        
        /**********************************************************************/
        // Tic-Tac
        unusedTreasures.add(new Treasure("Tic-Tac", 1,
                TreasureKind.BOTHHANDS));
        
        /**********************************************************************/
        // Bouillotte Barbouillée
        unusedTreasures.add(new Treasure("Bouillotte Barbouillée", 3,
                TreasureKind.ONEHAND));
        
        /**********************************************************************/
        // Chamboule Toutou
        unusedTreasures.add(new Treasure("Chamboule Toutou", 2,
                TreasureKind.HELMET));
        
        /**********************************************************************/
        // Toc-Toc
        unusedTreasures.add(new Treasure("Toc-Toc", 1,
                TreasureKind.SHOES));
        
        // Shuffle the added treasures
        shuffleTreasures();
    }
    
    ////////////////////////////////////////////////////////////////////////////
    // DEFINITION OF THE MONSTERS
    ////////////////////////////////////////////////////////////////////////////
    
    private void initMonsterCardDeck ()
    {
        // Array which will store the monsters
        ArrayList<Monster> monstruos = new ArrayList();
        
        // Array which will store the visible and hidden treasures
        // that the player can obtain by killing a monster 
        ArrayList<TreasureKind> tVisible = new ArrayList();
        ArrayList<TreasureKind> tHidden = new ArrayList();
        
        /**********************************************************************/
        // Grognon
        
        tVisible.add(TreasureKind.ARMOR);
        tHidden.add(TreasureKind.ARMOR);
        
        BadConsequence badConsequence = new SpecificBadConsequence 
        ("Tu perds ton armure visible et une autre cachée.", 0, tVisible, tHidden);
        
        Prize prize = new Prize(2, 1);
        
        monstruos.add(new Monster("Grognon", 8, badConsequence, 
                prize));
        
        tVisible = new ArrayList();
        tHidden = new ArrayList();
        
        /**********************************************************************/
        // Gribouille
        
        tVisible.add(TreasureKind.HELMET);
        
        badConsequence = new SpecificBadConsequence ("Tu es fasciné par le mignon " +
                "primordial, tu te débarrasses de ton casque visible.", 0, tVisible, 
                tHidden);
        
        prize = new Prize(1, 1);
        
        monstruos.add(new Monster("Gribouille", 2, badConsequence, prize));
        
        tVisible = new ArrayList();
        
        /**********************************************************************/
        // El sopor de Dunwich
        
        tVisible.add(TreasureKind.SHOES);
        
        badConsequence = new SpecificBadConsequence ("Le bâillement primordial" 
                + " contagieux. Tu perds tes chaussures visibles.", 0, tVisible, 
                tHidden);
        
        prize = new Prize(1, 1);
        
        monstruos.add(new Monster ("Sifflard", 2, badConsequence, 
                prize));
        
        tVisible = new ArrayList();
        
        /**********************************************************************/
        // Frimousse
        
        tVisible.add(TreasureKind.ONEHAND);
        tHidden.add(TreasureKind.ONEHAND);
        
        badConsequence = new SpecificBadConsequence ("Ils t'attrapent pour t'emmener faire"
                + " la fête et te laissent tomber en plein vol. Défausse 1"
                + " main visible et une main cachée.", 0, tVisible, tHidden);
        
        prize = new Prize(4, 1);
        
        monstruos.add(new Monster("Frimousse", 14,
                badConsequence, prize));
        
        tVisible = new ArrayList();
        tHidden = new ArrayList();
        
        /**********************************************************************/
        // Grincheux
        //
        // We have assigned a large amount of visible treasures to lose in
        // order to make the player lose all of them
        
        badConsequence = new NumericBadConsequence ("Tu perds tous tes trésors "
                + "visibles.", 0, 10, 0);
        
        prize = new Prize(3, 1);
        
        monstruos.add(new Monster("Grincheux", 10, badConsequence,
                prize));
        
        /**********************************************************************/
        // Froussard
        
        tVisible.add(TreasureKind.ARMOR);
        
        badConsequence = new SpecificBadConsequence ("Tu perds ton armure"
                + " visible.", 0, tVisible, tHidden);
        
        prize = new Prize(2, 1);
        
        monstruos.add(new Monster("Froussard", 6, badConsequence, prize));
        
        tVisible = new ArrayList();
        
        /**********************************************************************/
        // Chuchoteur
        
        tVisible.add(TreasureKind.ARMOR);
        
        badConsequence = new SpecificBadConsequence ("Tu sens des insectes sous "
                + "tes vêtements. Défausse l'armure visible.", 0, tVisible, tHidden);
        
        prize = new Prize(1, 1);
        
        monstruos.add(new Monster("Chuchoteur", 2, badConsequence, prize));
        
        tVisible = new ArrayList();
        
        /**********************************************************************/
        // Gluant
        
        badConsequence = new NumericBadConsequence ("Tu perds 5 niveaux et 3 "
                + "trésors visibles.", 5, 3, 0);
        
        prize = new Prize(4, 2);
        
        monstruos.add(new Monster("Gluant", 13, badConsequence, prize));
        
        /**********************************************************************/
        // Ronfleur
        
        badConsequence = new NumericBadConsequence ("Tu touses violemment "
                + "et tu perds 2 niveaux.", 2, 0, 0);
        
        prize = new Prize(1, 1);
        
        monstruos.add(new Monster("Ronfleur", 2, 
                badConsequence, prize));
        
        /**********************************************************************/
        // Tournicoteur
        
        badConsequence = new DeathBadConsequence ("Ces monstres sont assez superficiels"
                + " et te rendent mortellement ennuyeux."
                + " Tu es mort.", true);
        
        prize = new Prize(2, 1);
        
        monstruos.add(new Monster("Tournicoteur", 8, badConsequence, prize));
        
        /**********************************************************************/
        // Babouin
        
        badConsequence = new NumericBadConsequence ("Tu perds 2 niveaux et 2"
                + " trésors cachés.", 2, 0, 2);
        
        prize = new Prize(2, 1);
        
        monstruos.add(new Monster("Babouin", 4, badConsequence, 
                prize));
        
        /**********************************************************************/
        // Pimprenelle
        
        tVisible.add(TreasureKind.ONEHAND);
        
        badConsequence = new SpecificBadConsequence ("Tu essaies de te faufiler."
                + " Tu perds une main visible.", 0, tVisible, tHidden);
        
        prize = new Prize(2, 1);
        
        monstruos.add(new Monster("Pimprenelle", 1, badConsequence, prize));
        
        tVisible = new ArrayList();
        
        /**********************************************************************/
        // Gobeur
        
        badConsequence = new NumericBadConsequence ("C'est vraiment dégoûtant."
                + " Tu perds 3 niveaux.", 3, 0, 0);
        
        prize = new Prize(1, 1);
        
        monstruos.add(new Monster("Gobeur", 3, badConsequence, 
                prize));
        
        /**********************************************************************/
        // Zigzag
        
        badConsequence = new DeathBadConsequence ("Il n'apprécie pas qu'on"
                + " prononce mal son nom. Tu es mort.", true);
        
        prize = new Prize(3, 1);
        
        monstruos.add(new Monster("Zigzag", 12, badConsequence, 
                prize));
        
        /**********************************************************************/
        // Foutriquet
        
        badConsequence = new DeathBadConsequence ("La famille t'attrape. "
                + "Tu es mort.", true);
        
        prize = new Prize(4, 1);
        
        monstruos.add(new Monster("Foutriquet", 1, badConsequence, prize));
        
        /**********************************************************************/
        // Barbotin
        
        tVisible.add(TreasureKind.BOTHHANDS);
        
        badConsequence = new SpecificBadConsequence ("La cinquième directive "
                + "t'oblige à perdre 2 niveaux et un trésor à deux mains visibles.", 
                2, tVisible, tHidden);
        
        prize = new Prize (2, 1);
        
        monstruos.add(new Monster("Barbotin", 8, badConsequence, prize));
        
        tVisible = new ArrayList();
        
        /**********************************************************************/
        // Cabriole
        
        tVisible.add(TreasureKind.HELMET);
        
        badConsequence = new SpecificBadConsequence ("Il te fait peur la nuit."
                + " Tu perds un casque visible.", 0, tVisible, tHidden);
        
        prize = new Prize (1, 1);
        
        monstruos.add(new Monster("Cabriole", 5, badConsequence, prize));
        
        tVisible = new ArrayList();
        
        /**********************************************************************/
        // Frétillant
        
        badConsequence = new NumericBadConsequence ("Quelle frayeur !"
                + " Tu perds 2 niveaux et 5 trésors visibles.", 2, 5, 0);
        
        prize = new Prize (1, 1);
        
        monstruos.add(new Monster("Frétillant", 20, badConsequence, prize));
        
        /**********************************************************************/
        // Ébouriffant
        
        tHidden = new ArrayList();
        tVisible.add(TreasureKind.ONEHAND);
        tVisible.add(TreasureKind.ONEHAND);
        tVisible.add(TreasureKind.BOTHHANDS);
        
        badConsequence = new SpecificBadConsequence ("Te manquent de mains"
                + " pour autant de têtes. Tu perds 3 niveaux et tes trésors"
                + " visibles tenus par tes mains.", 3, tVisible, tHidden);
        
        prize = new Prize (1, 1);
        
        monstruos.add(new Monster("Ébouriffant", 20, badConsequence, prize));
        
        tVisible = new ArrayList();
        tHidden = new ArrayList();
        
        ////////////////////////////////////////////////////////////////////////
        // MONSTERS WITH MODIFICATIONS FOR SECTARIAN PLAYERS
        
        /**********************************************************************/
        // Papouille
        
        tVisible.add(TreasureKind.ONEHAND);
        
        badConsequence = new SpecificBadConsequence ("Tu perds une main visible.",
                0, tVisible, tHidden);
        
        prize = new Prize (3, 1);
        
        monstruos.add(new Monster("Papouille", 10,
                badConsequence, prize, -2));
        
        tVisible = new ArrayList();
        
        /**********************************************************************/
        // Mimique
        
        badConsequence = new NumericBadConsequence ("Tu perds tes trésors "
                + "visibles. Hahaha.", 0, 10, 0);
        
        prize = new Prize (2, 1);
        
        monstruos.add(new Monster("Mimique", 6, badConsequence,
                prize, 2));
        
        /**********************************************************************/
        // Truculent
        
        badConsequence = new DeathBadConsequence ("Aujourd'hui n'est pas ton" 
                + " jour de chance. Tu meurs.", true);
        
        prize = new Prize (2, 5);
        
        monstruos.add(new Monster("Truculent", 20,
                badConsequence, prize, 4));
        
        /**********************************************************************/
        // Tapoteur
        
        badConsequence = new NumericBadConsequence ("Ton gouvernement te réduit"
                + " de 2 niveaux.", 2, 0, 0);
        
        prize = new Prize (2, 1);
        
        monstruos.add(new Monster("Tapoteur", 8, badConsequence,
                prize, -2));
        
        /**********************************************************************/
        // Felpuggoth
        
        tVisible.add(TreasureKind.ARMOR);
        tVisible.add(TreasureKind.HELMET);
        tHidden.add(TreasureKind.ONEHAND);
        tHidden.add(TreasureKind.ONEHAND);
        tHidden.add(TreasureKind.BOTHHANDS);
        
        badConsequence = new SpecificBadConsequence ("Tu perds ton casque et ton"
                + " armure visible. Tu perds tes mains cachées.", 0, tVisible,
                tHidden);
        
        prize = new Prize (1, 1);
        
        monstruos.add(new Monster("Felpuggoth", 2, badConsequence, prize, +5));
        
        tVisible = new ArrayList();
        tHidden = new ArrayList();
        
        /**********************************************************************/
        // Shoggoth
        
        badConsequence = new NumericBadConsequence ("Tu perds 2 niveaux.", 2, 
                0, 0);
        
        prize = new Prize (4, 2);
        
        monstruos.add(new Monster("Shoggoth", 16, badConsequence, prize, -4));
        
        /**********************************************************************/
        // Lolitagooth
        
        badConsequence = new NumericBadConsequence ("Black Lipstick."
                + " Tu perds 2 niveaux.", 2, 0, 0);
        
        prize = new Prize (1, 1);
        
        monstruos.add(new Monster("Lolitagooth", 2, badConsequence, prize, +3));
        
        
        // Assigns the filled array of monsters to the unused monsters array
        unusedMonsters = monstruos;
        
        // Shuffle the added monsters
        shuffleMonsters();
    }
    
    ////////////////////////////////////////////////////////////////////////////
    // DEFINITION OF THE CULTISTS
    ////////////////////////////////////////////////////////////////////////////
    
    private void initCultistCardDeck ()
    {
        /**********************************************************************/
        // Sectario (1)
        unusedCultists.add(new Cultist("Cultist", 1));
        
        /**********************************************************************/
        // Sectario (2)
        unusedCultists.add(new Cultist("Cultist", 2));
        
        /**********************************************************************/
        // Sectario (3)
        unusedCultists.add(new Cultist("Cultist", 1));
        
        /**********************************************************************/
        // Sectario (4)
        unusedCultists.add(new Cultist("Cultist", 2));
        
        /**********************************************************************/
        // Sectario (5)
        unusedCultists.add(new Cultist("Cultist", 1));
        
        /**********************************************************************/
        // Sectario (6)
        unusedCultists.add(new Cultist("Cultist", 1));
        
        // Shuffle the added cultists
        shuffleCultists();
    }
    
    /**************************************************************************/
    // OTHER METHODS
    
    public void initCards()
    {
        initTreasureCardDeck();
        initMonsterCardDeck();
        initCultistCardDeck();
    }
    
    // Returns the next treasure of the unused treasures card deck
    // If it was empty, it would shuffle the used ones and introduce them again
    // into the unused ones
    
    public Treasure nextTreasure ()
    {
        // Checks if the unused_treasures array is empty and, if so, shuffle 
        // the used ones and introduce them again into the unused ones
        
        if(unusedTreasures.isEmpty())
        {
            unusedTreasures = usedTreasures;
            usedTreasures = new ArrayList();
            shuffleTreasures();
        }
        
        Treasure trs = unusedTreasures.get(0);
        unusedTreasures.remove(trs);
        usedTreasures.add(trs);
        
        return trs;     
    }
    
    // Returns the next monster of the unused monsters card deck
    // If it was empty, it would shuffle the used ones and introduce them again
    // into the unused ones
    
    public Monster nextMonster ()
    {
        // Checks if the unused_monsters array is empty and, if so, shuffle 
        // the used ones and introduce them again into the unused ones
        
        if(unusedMonsters.isEmpty())
        {
            unusedMonsters = usedMonsters;
            usedMonsters = new ArrayList();
            shuffleMonsters();    
        }
        
        Monster mst = unusedMonsters.get(0);
        unusedMonsters.remove(mst);
        
        return mst;
    }
    
    // Returns the next cultist of the unused cultists card deck
    
    public Cultist nextCultist ()
    {
        Cultist clt = unusedCultists.get(0);
        unusedCultists.remove(clt);
        
        return clt;
    }
    
    public void giveTreasureBack (Treasure t)
    {
        usedTreasures.add(t);
    }
    
    public void giveMonsterBack (Monster m)
    {
        usedMonsters.add(m);
    }
    
}
