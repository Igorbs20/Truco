package truco.controller;

import java.util.HashMap;
import truco.Enums.NAIPE_CARD;
import truco.Enums.NAME_CARD;
import truco.model.Card;

/**
 *Serve para Ditar as Regras do Jogo - Prioridades de cartas, zaps e trunfos.
 * @author Igor
 */
public class Ruller {
    
    private static HashMap<NAME_CARD, Integer> cardPriority;
    private static HashMap<String,Integer> zap;
    private static NAME_CARD trunfo;
    
    public Ruller(){
        initializePriority();
        initializeZap();
    }
    
    private void initializeZap(){
        zap = new HashMap<String,Integer>();
        
        zap.put(makeZapName(NAME_CARD.C7,NAIPE_CARD.DIAMONDS), 11);
        zap.put(makeZapName(NAME_CARD.CA,NAIPE_CARD.SPADES), 12);
        zap.put(makeZapName(NAME_CARD.C7,NAIPE_CARD.HEARTS), 13);
        zap.put(makeZapName(NAME_CARD.C4,NAIPE_CARD.CLUBS), 14);
    }
    
    private void initializePriority(){
        cardPriority = new HashMap<NAME_CARD,Integer>();
        
        cardPriority.put(NAME_CARD.C4, 0);
        cardPriority.put(NAME_CARD.C5, 1);
        cardPriority.put(NAME_CARD.C6, 2);
        cardPriority.put(NAME_CARD.C7, 3);
        cardPriority.put(NAME_CARD.CJ, 4);
        cardPriority.put(NAME_CARD.CQ, 5);
        cardPriority.put(NAME_CARD.CK, 6);
        cardPriority.put(NAME_CARD.CA, 7);
        cardPriority.put(NAME_CARD.C2, 8);
        cardPriority.put(NAME_CARD.C3, 9);
    }
    
    /*
    * Gambiarra para usar zap
    */
    private static String makeZapName(NAME_CARD name,NAIPE_CARD naipe){
        return String.format("%s-%s",name.toString(),naipe.toString());
    }
    
    /*
    * Defino carta como trunfo
    */
    public void setTrunfo(NAME_CARD trunfo){
        this.trunfo = trunfo;
    }
    
    /*
    * Verifica se a carta é um zap
    */
    public static boolean isZap(Card card){
        return zap.containsKey(makeZapName(card.getName(),card.getNaipe()));
    }
    
    /*
    * Verifica se a carta é trunfo
    */
    public static boolean isTrunfo(Card card){
        return (card.getName() == trunfo);
    }
    
    /*
    * Recupera a prioridade da carta
    */
    public static int getCardPriority(Card card){
        int priority = 0;
        if(isZap(card)){
            priority =  zap.get(makeZapName(card.getName(),card.getNaipe()));
        }else if(isTrunfo(card)){
            priority = 10;
        }
        else{
            priority =  cardPriority.get(card.getName());
        }
        
        return priority;
    }
    
    public static boolean isRoyal(Card card){
        return (card.getName() == NAME_CARD.CJ || card.getName() == NAME_CARD.CQ ||  card.getName() == NAME_CARD.CK );
    }
}
