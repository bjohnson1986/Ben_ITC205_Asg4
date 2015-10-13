import java.util.List;

public class Main {
	
	public static void main(String[] args) throws Exception {

        Dice die1 = new Dice();
        Dice die2 = new Dice();
        Dice die3 = new Dice();

        Player player = new Player("Fred", 100);
        Game game = new Game(die1, die2, die3);
        List<DiceValue> diceValueList = game.getDiceValues();

        int winCount = 0;
        int loseCount = 0;
             
        for (int i = 0; i < 1; i++)
        {
        	String name = "Fred";
        	int balance = 100;
        	int limit = 0;
            int bet = 100;
            int turn = 0;
            
            player = new Player(name, balance);
            player.setLimit(limit);
            

            System.out.println(String.format("Start Game %d: ", i));
            System.out.println(String.format("%s starts with balance %d, limit %d", 
            		player.getName(), player.getBalance(), player.getLimit()));

            while (player.balanceExceedsLimitBy(bet) && player.getBalance() < 200)
            {
                turn++;
                
            	DiceValue pick = DiceValue.getRandom();
               
            	System.out.printf("Turn %d: %s bet %d on %s\n",
            			turn, player.getName(), bet, pick); 
            	
            	int winnings = game.playRound(player, pick, bet);
            	
            	diceValueList = game.getDiceValues();
            	DiceValue dieValue1 = diceValueList.get(0);
            	DiceValue dieValue2 = diceValueList.get(1);
            	DiceValue dieValue3 = diceValueList.get(2);
            	
                System.out.printf("Rolled %s, %s, %s\n", dieValue1, dieValue2, dieValue3);
                
                if (winnings > 0) {
                    System.out.printf("%s won %d, balance now %d\n\n", player.getName(), winnings, player.getBalance());
                	winCount++; 
                }
                else {
                    System.out.printf("%s lost, balance now %d\n\n", player.getName(), player.getBalance());
                	loseCount++;
                }
                
            }

            System.out.print(String.format("%d turns later.\nEnd Game %d: ", turn, i));
            System.out.println(String.format("%s now has balance %d\n", player.getName(), player.getBalance()));
            
        }
        
        System.out.println(String.format("Win count = %d, Lose Count = %d, %.2f", winCount, loseCount, (float) winCount/(winCount+loseCount)));
        System.out.println(String.format("Overall win rate = %.1f%%", (float)(winCount * 100) / (winCount + loseCount)));
	}

}
