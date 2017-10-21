package truco.model;

import truco.Enums.NAIPE_CARD;
import truco.Enums.NAME_CARD;

/**
 * Carta do baralho
 * @author Igor
 */
public class Card {
   private NAME_CARD name;
   private NAIPE_CARD naipe;
   private boolean flipped;
   
   public Card(NAME_CARD name, NAIPE_CARD naipe){
       this.name = name;
       this.naipe = naipe;
       //Normalmente de face para cima
       this.flipped = false;
   }
   
   //Getters
   public NAME_CARD getName(){
    return this.name;
   }
   
   public NAIPE_CARD getNaipe(){
    return this.naipe;
   }
   
   public boolean isFlipped(){
       return this.flipped;
   }
   
   //Setters
   public void setName(NAME_CARD name){
       this.name = name;
   }
   
   public void setNaipe(NAIPE_CARD naipe){
       this.naipe = naipe;
   }
   
   public void flip(){
      this.flipped = true;
   }
}
