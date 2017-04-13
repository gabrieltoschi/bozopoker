
public class VideoPoker {
	
	public static void main(String[] args) throws Exception{
		Hand playerHand = new Hand();
		Scoreboard playerScore = new Scoreboard(200);
		int playerBet;
		int changeCards = 1;
		int changes = 0;
		String toChange;
		
		// enquanto os creditos nao acabaram
		while (!playerScore.isGameFinished()){
			// reseta mudan�as de cartas
			changeCards = 1;
			changes = 0;
			
			// mostre o placar do jogador
			System.out.printf(playerScore.toString());
			
			// pe�a uma aposta ao jogador
			System.out.printf("Digite sua aposta: ");
			playerBet = EntradaTeclado.leInt();
			
			// pe�a uma nova aposta caso o jogador nao tenha creditos 
			if (playerBet > playerScore.getCredits())
				continue;
			
			// sorteia cinco novas cartas do deck
			playerHand.pushCards();
			
			while (changeCards == 1 && changes < 2){
				// imprime cartas atuais da mao
				System.out.printf(playerHand.toString());
				
				if (changes < 2){
					// pergunte ao jogador se ele quer trocar cartas
					System.out.println("Digite 1 para trocar cartas, 2 para continuar");
					changeCards = EntradaTeclado.leInt();
					
					if (changeCards == 1){
						System.out.println("Quais cartas deseja trocar?");
						toChange = EntradaTeclado.leString();
						
						// troca as cartas indicadas pelo usuario
						playerHand.pushCards(toChange);
						changes++;
					}
				}		
			}
			
			// imprime cartas atuais da mao
			System.out.printf(playerHand.toString());
			
			// checagem das combinacoes
			if (HandChecker.checkRoyalStraightFlush(playerHand.getHand())){
				System.out.println("Voc� fez um Royal Straight Flush e ganhou "
						+ HandChecker.ROYALSTRAIGHTFLUSH * playerBet + "  cr�ditos!");
				playerScore.updateCredits(playerBet * HandChecker.ROYALSTRAIGHTFLUSH);
			} else if (HandChecker.checkStraightFlush(playerHand.getHand())){
				System.out.println("Voc� fez um Straight Flush e ganhou "
						+ HandChecker.STRAIGHTFLUSH * playerBet + " cr�ditos!");
				playerScore.updateCredits(playerBet * HandChecker.STRAIGHTFLUSH);
			} else if (HandChecker.checkFourOfAKind(playerHand.getHand())){
				System.out.println("Voc� fez uma Quadra e ganhou "
						+ HandChecker.FOUROFAKIND * playerBet + " cr�ditos!");
				playerScore.updateCredits(playerBet * HandChecker.FOUROFAKIND);
			} else if (HandChecker.checkFullHouse(playerHand.getHand())){
				System.out.println("Voc� fez um Full House e ganhou "
						+ HandChecker.FULLHOUSE * playerBet + " cr�ditos!");
				playerScore.updateCredits(playerBet * HandChecker.FULLHOUSE);
			} else if (HandChecker.checkFlush(playerHand.getHand())){
				System.out.println("Voc� fez um Flush e ganhou "
						+ HandChecker.FLUSH * playerBet + " cr�ditos!");
				playerScore.updateCredits(playerBet * HandChecker.FLUSH);
			} else if (HandChecker.checkStraight(playerHand.getHand())){
				System.out.println("Voc� fez um Straight e ganhou "
						+ HandChecker.STRAIGHT * playerBet + " cr�ditos!");
				playerScore.updateCredits(playerBet * HandChecker.STRAIGHT);
			} else if (HandChecker.checkThreeOfAKind(playerHand.getHand())){
				System.out.println("Voc� fez uma Trinca e ganhou "
						+ HandChecker.THREEOFAKIND * playerBet + " cr�ditos!");
				playerScore.updateCredits(playerBet * HandChecker.THREEOFAKIND);
			} else if (HandChecker.checkTwoPairs(playerHand.getHand())){
				System.out.println("Voc� fez Dois Pares e ganhou "
						+ HandChecker.TWOPAIRS * playerBet + " cr�ditos!");
				playerScore.updateCredits(playerBet * HandChecker.TWOPAIRS);
			} else {
				System.out.println("Voc� n�o fez nenhuma combina��o e perdeu a aposta de "
						+ playerBet + " cr�ditos. :(");
				playerScore.updateCredits(-playerBet);
			}
			
		}
		
		
	}
}
