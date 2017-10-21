package truco.controller;

import java.util.ArrayList;
import java.util.Random;
import truco.IA.IAPlayer;
import truco.model.Card;
import truco.model.Deck;
import truco.model.HumanPlayer;
import truco.model.Player;
import truco.model.Table;
import truco.model.Team;

/**
 *
 * @author Igor
 */
public class Game {
       
    Deck deck;
    Team enemy;
    Team alied;
    Ruller ruller;
    Table table;
   
    ArrayList<Player> orderPlayer;
    
    boolean enemyTruco;
    boolean aliedTruco;
    
    public Game(){
     deck = new Deck();
     ruller = new Ruller();
     table = new Table();
     initializeTeams();
    }
    
    public void initializeTeams(){
        this.enemy = new Team();
        this.alied = new Team();
        
        //Montar os times
        enemy.setPlayers(new IAPlayer(table), new IAPlayer(table));
        alied.setPlayers(new HumanPlayer(), new IAPlayer(table));
    }
    
   
    
    /*
    * Pergunta aos jogadores se alguem quer truco.
    */
    public boolean getTruco(){
        enemyTruco = (enemy.getPlayer1().requestTruco() || enemy.getPlayer2().requestTruco());
        aliedTruco = (alied.getPlayer1().requestTruco() || alied.getPlayer2().requestTruco());
        
        return enemyTruco || aliedTruco;
    }
    
    public boolean acceptTruco(){
        //TODO: IMPLEMENTAR
       return false;
    }
    
    public void BeginGame(){
        OrderPlayer();
        
    }
    
    /*
    * Vai orderna o inicio da jogadas.
    */
    public void OrderPlayer(){
        Random rand = new Random();
        orderPlayer = new ArrayList<Player>();
        switch(rand.nextInt(5)){
            case 1:
                orderPlayer.add(alied.getPlayer1());
                orderPlayer.add(enemy.getPlayer1());
                orderPlayer.add(alied.getPlayer2());
                orderPlayer.add(enemy.getPlayer2());
                break;
            case 2:
                orderPlayer.add(enemy.getPlayer1());
                orderPlayer.add(alied.getPlayer2());
                orderPlayer.add(enemy.getPlayer2());
                orderPlayer.add(alied.getPlayer1());
                break;
            case 3: 
                orderPlayer.add(alied.getPlayer2());
                orderPlayer.add(enemy.getPlayer2());
                orderPlayer.add(alied.getPlayer1());
                orderPlayer.add(enemy.getPlayer1());
                break;
            default:
                orderPlayer.add(enemy.getPlayer2());
                orderPlayer.add(alied.getPlayer1());
                orderPlayer.add(enemy.getPlayer1());
                orderPlayer.add(alied.getPlayer2());
        }
        
    }
    
    
    public void distributeCards(){
        for(int i = 0 ; i< 3; i++){
            enemy.getPlayer1().receiveCard(deck.buyCard());
            alied.getPlayer1().receiveCard(deck.buyCard());
            enemy.getPlayer2().receiveCard(deck.buyCard());
            alied.getPlayer2().receiveCard(deck.buyCard());
        }
    }
    
    
    /*
    *Para embaralhar e dar as cartas aos jogadores
    */
    public void beginRound(){
        deck.shuffleCards();
        distributeCards();
        aliedTruco = false;
        enemyTruco = false;
    }
    
    /*
    *Para jogar a rodada.
    */
    public void Round(){
                
    }
}
