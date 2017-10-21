package truco.model;

/**
 *
 * @author Igor
 */
public class Team {

    private Player player1;
    private Player player2;
    
    private int point;

    public Team(){
       this.point = 0;
    }
    
    /*
    * Escolhe se é Humano ou só AI
    * Define os jogadores
    * usage:
    * team.setPlayers(new HumanPlayer(), new IAPlayer());
    */
    public void setPlayers(Player p1, Player p2){
        this.player1 = p1;
        this.player2 = p2;
    }
    
    public Player getPlayer1(){
        return this.player1;
    }
    
    public Player getPlayer2(){
        return this.player2;
    }
    
    public boolean requestTruco(){
        return (this.player1.requestTruco() || this.player2.requestTruco());
    }
    
    public boolean acceptTruco(){
        return (this.player1.acceptTruco() || this.player2.acceptTruco());
    }
    
   public int getPoint (){
       return this.point;
   }
   
   /*
   * Soma pontos ao time
   * Usage:
   * team.getPoint(); -> 3
   * team.sumPoint(12);
   * team.getPoint(); -> 15
   */
   public void sumPoint(int point ){
       this.point += point;
   }
}
