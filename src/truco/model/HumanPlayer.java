package truco.model;

import truco.gui.CLI;

/**
 *
 * @author Igor
 */
public class HumanPlayer extends Player{

    @Override
    public boolean requestTruco() {
     //Pergunta ao usuario se ele quer pedi truco
     String response = CLI.getUserResponse("VAI PEDI TRUCO? (s/n)");
     if(response.equals("s")){
         return true;
     }
     else
         return false;
    }

    @Override
    public boolean acceptTruco() {
     //Pergunta ao usuario se ele quer aceita o truco
     String response = CLI.getUserResponse("VAI ACEITAR O TRUCO? (s/n)");
     if(response.equals("s")){
         return true;
     }
     else
         return false;

    }

    @Override
    public Card downCard() {
        Card card;
        int selecionada = 0;
        
        // mostra a mao para o usuario
        CLI.showHand(hand);
        //pergunta qual ele quer descer
        String response = CLI.getUserResponse("QUAL CARTA DESEJA ESCOLHER ");
        int resp = Integer.parseInt(response);

        card = hand.get(selecionada);
        hand.remove(selecionada);
        return card;
    }

    @Override
    public boolean royalFamily() {
        String response = CLI.getUserResponse("DESEJA TROCAR CARTAS? (s/n)");
        if(response.equals("s")){
            return true;
        }
        else
            return false;
    }
 
    
}
