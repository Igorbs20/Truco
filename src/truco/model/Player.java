package truco.model;

import java.util.ArrayList;

/**
 *
 * @author Igor
 */
public abstract class Player {
    
    protected ArrayList<Card> hand;
    
    public void initialize(){
        this.hand = new ArrayList<Card>();
    }
    
    public void receiveHand(ArrayList<Card> hand){
        this.hand = hand;
    }
    
    public void receiveCard(Card card){
        this.hand.add(card);
    }
    
    public void cleanHand(){
        this.hand = new ArrayList<Card>();
    }
    
    // ========== METODOS DE JOGO ==============
    
    /*
    * Solicita ou não truco
    */
    public abstract boolean requestTruco();
    
    /*
    * Aceita ou não o truco pedido pelo time adversario
    */
    public abstract boolean acceptTruco();
    
    /*
    * Desce uma carta na mesa
    */
    public abstract Card downCard();

    /*
    * Verifica se a mao toda é da familia real e pede para trocar a mao
    */
    public abstract boolean royalFamily();

}
