package truco.IA;

import java.util.ArrayList;
import java.util.Random;
import truco.controller.Ruller;
import truco.model.Card;
import truco.model.Player;
import truco.model.Table;

/**
 *
 * @author Igor
 */
public class IAPlayer extends Player {
    private Random rand;
    protected Table table;
    
    private ArrayList<Card> tableCards;
    private ArrayList<Card> trashCards;

    /*
    * Usage:
    * player = new IAPlayer(table);
    */
    public IAPlayer(Table table){
        initialize();
        this.table = table;
        this.rand = new Random();
    }

    @Override
    public boolean requestTruco() {
        //TODO: IMPLEMENTAR
       return false;
    }

    @Override
    public boolean acceptTruco() {
        //TODO: IMPLEMENTAR
      return false;
    }

    /*
    * Recebe cartas e ordena
    */
    @Override
    public void receiveCard(Card card){
        Card minusCard;
        int lenHand = hand.size();
        int aux = 0;
        
        for(int i = 0; i< lenHand ; i++){
            minusCard = hand.get(i);
            if(minusCard != null){
                aux = Ruller.getCardPriority(card);
                if(aux <= Ruller.getCardPriority(minusCard)){
                    this.hand.add(i, card);
                    break;
                }
            }
            else{
                this.hand.add(card);
                break;
            }
        }
    }
    
    @Override
    public Card downCard() {
     Card card = null;

     int maior,menor,i,handCardPos;
     int maiorPos, menorPos;
     boolean maxEnemy, minusEnemy;
     maior = 0;
     menor = 19;
     maiorPos = menorPos = handCardPos = 0;
     maxEnemy = minusEnemy = false;
     
     //Faz leitura de mesa e jogo
     tableCards = table.getCards();
     trashCards = table.getTrash();
     
     //Escolhe card para descer
     
     //Maior e menor carta da mesa
     i = 0;
     for(Card auxCard: tableCards){
         int aux = Ruller.getCardPriority(auxCard);
         
         if(aux > maior){
             maior = aux;
             maiorPos = i;
         }
         
         if(aux < menor){
             menor = aux;
             menorPos = i;
         } 
         i++;
     }
     
     //Checar se a maior carta e amiga
     boolean enemy = false;
     int lenTable = tableCards.size();
     for(int j = lenTable -1 ; j >= lenTable; j--){
         enemy = !enemy;
         if(maiorPos == j){
             maxEnemy = enemy;
         }
         
         if(menorPos == j){
            minusEnemy = enemy;
         }
     }
     
     //Sabemos qual é a maior e menor carta e se é amiga ou inimiga
     if(maxEnemy){ //maior da mesa é meu inimigo?
        card = this.hand.get(this.hand.size()-1); //Peguei a minha maior carta
        handCardPos = this.hand.size()-1;
        
        if (Ruller.getCardPriority(card) < maior){
          card = this.hand.get(0); //Pego minha mais fraca
          handCardPos = 0;
          card.flip();
        }
        
     }else{
         //Jogo minha menor carta
          card = this.hand.get(0); //Pego minha mais fraca
          handCardPos = 0;
     }
     
     //Remove da mão e desce card
     hand.remove(handCardPos);
     return card;
    }
    
    /*
    * Pede ou nao a troca das cartas
    */
    @Override
    public boolean royalFamily() {
      boolean royal = true;
      int randval = 0;
      //Verifico se é mao real
      for(Card card : hand){
          royal = royal && Ruller.isRoyal(card);
      }
      
      //Tomo decisao / 95% de probabilidade de troca
      if(royal){
          randval = rand.nextInt(101);
          royal = (randval > 95);
      }
      
      return royal;
    }
}
