/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package truco.gui;

import java.util.ArrayList;
import truco.model.Card;

/**
 *
 * @author Igor
 */
public class CLI {
    
    public static String getUserResponse(String message){
        String result = "";
        
        System.out.println(message);
        //Ler teclado
        //result = leitura teclado
        
        return result;
    }
    
    public static void showHand(ArrayList<Card> hand){
        System.out.println("==== CARTAS DA MAO =====");
        for(Card card: hand){
            System.out.println(String.format("- Carta: %s %s",card.getName().toString(),card.getNaipe().toString()));
        }
        System.out.println("=======================");
    }
    
    public static void showTable(ArrayList<Card> table){
        System.out.println("======CARTAS DA MESA==========");
        for(Card card: table){
            System.out.println(String.format("- Carta: %s %s",card.getName().toString(),card.getNaipe().toString()));
        }
        System.out.println("=======================");
    }
    
}
