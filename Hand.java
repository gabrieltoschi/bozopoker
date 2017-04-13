
/**
 * Classe que manipula as 5 cartas da mão.
 * 
 * @author Gabriel Toschi + Marcos Wendell.
 *
 */
public class Hand {
	Deck deck = new Deck();
	Card[] hand = new Card[5];
	
	/**
	 * Inicializa todas as cartas da mão.
	 */
	public void pushCards(){
		for(int i = 0; i < 5; i++)
			hand[i] = deck.pushCard();
	}
	
	/**
	 * Baseado vetor de boolean, vira somente as cartas selecionadas.
	 * 
	 * @param quais - vetor de boolean contendo as cartas que devem ser viradas novamente.
	 */
	public void pushCards(boolean quais[]){
		for(int i = 0; i < 5; i++)
			if(quais[i])
				hand[i] = deck.pushCard();
	}
	
	/**
	 * Transforma a string dada como parametro em um vetor de boolean.
	 * Chama o metodo pushCard(boolean[]) para virar as cartas novamente.
	 * 
	 * @param s - string que contem o numero das cartas que devem ser viradas novamente.
	 */
	public void pushCards(String s){
		int i;
		char ch;
		boolean[] aux = new boolean[5];
		
		for(i = 0; i < s.length(); i++){
			ch = s.charAt(i);
			if(ch > 48 && ch < 54)
				aux[ch - 49] = true;
		}
				
		pushCards(aux);
	}
	
	/**
	 * Retorna as 5 cartas da mão.
	 * 
	 * @return vetor com as 5 cartas da mão.
	 */
	public Card[] getHand(){
		return hand;
	}
	
	@Override
	/**
	 * Concatena a representação em string das cinco cartas da mão e retorna a string concatenada. 
	 * 
	 * @return all_cards - string concatenada com as 5 cartas da mão para impressão.
	 */
	public String toString(){
		String aux;
		String[][] strs = new String[5][7];
		String all_cards = new String();
				
		for(int i = 0; i < 5; i++){
			aux = hand[i].toString();
			strs[i] = aux.split("\n");
		}  
		
		for(int i=0;i<7;i++){
			for(int j=0;j<5;j++)
				all_cards += strs[j][i] + "     ";
			all_cards += "\n";
		}		
				
		return all_cards;
	}
	
}
