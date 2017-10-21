package truco.model;

import truco.Enums.NAIPE_CARD;
import truco.Enums.NAME_CARD;
import java.util.ArrayList;

/**
 * BARALHO DO JOGO
 * @author Igor
 */
public class Deck {
    private ArrayList<Card> cards;
    
    /*
    * Inicializa o baralho
    */
    public Deck(){
        //FODA-SE ESSE WARNING BITCH
        reloadDeck();
    }
    /*
    * Adiciona os naipes relativos ao tipo da carta
    */
    private void addNaipeCards(ArrayList<Card> cards,NAME_CARD name){
        cards.add(new Card(name,NAIPE_CARD.CLUBS));
        cards.add(new Card(name,NAIPE_CARD.DIAMONDS));
        cards.add(new Card(name,NAIPE_CARD.HEARTS));
        cards.add(new Card(name,NAIPE_CARD.SPADES));
    }
    
    /*
    * Reiniciar Baralho
    */
    public void reloadDeck(){
        this.cards = new ArrayList<Card>();
        
        addNaipeCards(cards,NAME_CARD.C2);
        addNaipeCards(cards,NAME_CARD.C3);
        addNaipeCards(cards,NAME_CARD.C4);
        addNaipeCards(cards,NAME_CARD.C5);
        addNaipeCards(cards,NAME_CARD.C6);
        addNaipeCards(cards,NAME_CARD.C7);
        addNaipeCards(cards,NAME_CARD.CJ);
        addNaipeCards(cards,NAME_CARD.CQ);
        addNaipeCards(cards,NAME_CARD.CK);
        addNaipeCards(cards,NAME_CARD.CA);
    }
    
    /*
    * Embaralhar as cartas
    */
    public void shuffleCards(){
        //TODO: IMPLEMENTAR
    }
    
    /*
    * Retorna o trunfo selecionado
    */
    public Card getTrunfo(){
       //TODO: IMPLEMENTAR
        return null;
    }
    
    /*
    * Retorna as cartas para os jogadores
    */
    public Card buyCard(){
        //TODO: IMPLEMENTAR
        return null;
        
    }
    
}
