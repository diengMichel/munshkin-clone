package midiwar;

/*
This enum specifies all the possible results in a fight:
    * WINGAME: the player wins the previous combat and reaches the level 10
    * WIN: the player wins the previous combat
    * LOSE: the player loses the previous combat
    * LOSEANDCONVERT: the player loses the previous combat and gets the number 1
      when throwing again the dice, so he has to convert to cultist
*/
public enum CombatResult {
    WINGAME, WIN, LOSE, LOSEANDCONVERT
}
