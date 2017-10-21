package truco.model;

import java.util.ArrayList;

/**
 *
 * @author Igor
 */
public class Table {

    private ArrayList<Card> table;
    private ArrayList<Card> trash;
    
    public Table(){
        this.table = new ArrayList<Card>();
    }
    
    public void cleanTable(){
        this.trash.addAll(table);
        this.table = new ArrayList<Card>();
    }
    
    public void putCard(Card card){
        table.add(card);
    }
    
    public ArrayList<Card> getCards(){
        return table;
    }
    
    public ArrayList<Card> getTrash(){
        return trash;
    }
}
