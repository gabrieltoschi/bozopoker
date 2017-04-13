import java.util.Arrays;

/**
 * O Hand Checker checa as combina��es do jogo a partir de um vetor de cartas
 * e retorna para o programa principal se elas aparecem em uma m�o ou n�o.
 * @author Gabriel Toschi
 * @author Marcos Wendell
 *
 */
public class HandChecker {
	/**
	 * C�digo da primeira carta de um Royal Straight Flush (carta 10)
	 */
	private static final int ROYAL_START = 8;
	
	public static final int TWOPAIRS = 1;
	public static final int THREEOFAKIND = 2;
	public static final int STRAIGHT = 5;
	public static final int FLUSH = 10;
	public static final int FULLHOUSE = 20;
	public static final int FOUROFAKIND = 50;
	public static final int STRAIGHTFLUSH = 100;
	public static final int ROYALSTRAIGHTFLUSH = 200;
	
	/**
	 * Testa a combina��o "Dois Pares": retorna verdadeiro caso existam,
	 * pelo menos, dois n�meros que se repetem, pelo menos, duas vezes
	 * em uma m�o.
	 * @param cards vetor com as cartas da m�o a ser checada
	 * @return true, caso a combina��o exista naquela m�o
	 */
	public static boolean checkTwoPairs(Card[] cards){
		int[] counter = new int[Deck.SUIT_SIZE];
		Arrays.fill(counter, 0);
		
		// marque quantas cartas de cada tipo est�o na m�o e conte-as
		for (int i = 0; i < cards.length; i++){
			counter[cards[i].getNumber()]++;
		}
		
		// ordene o vetor de contadores
		Arrays.sort(counter);
			
		// se existe, pelo menos, dois numeros que se repetem,
		// pelo menos, duas vezes, a combina��o existe
		if (counter[Deck.SUIT_SIZE - 1] >= 2 && counter[Deck.SUIT_SIZE - 2] >= 2){
			return true;
		} else return false;
	}
	
	/**
	 * Testa a condi��o "Trinca": retorna verdadeiro caso exista
	 * um n�mero que se repete, pelo menos, tr�s vezes, em uma m�o.
	 * @param cards vetor com as cartas da m�o a ser checada
	 * @return true, caso a combina��o exista naquela m�o
	 */
	public static boolean checkThreeOfAKind(Card[] cards){
		int[] counter = new int[Deck.SUIT_SIZE];
		Arrays.fill(counter, 0);
		
		// marque quantas cartas de cada tipo est�o na m�o e conte-as
		for (int i = 0; i < cards.length; i++){
			counter[cards[i].getNumber()]++;
		}
		
		// ordene o vetor de contadores
		Arrays.sort(counter);
		
		// se existe, pelo menos, um numero que se repete,
		// pelo menos, tr�s vezes, a combina��o existe
		if (counter[Deck.SUIT_SIZE - 1] >= 3){
			return true;
		} else return false;
	}
	
	/**
	 * Testa a condi��o "Quadra": retorna verdadeiro caso exista
	 * um n�mero que se repete, pelo menos, quatro vezes, em uma m�o.
	 * @param cards vetor com as cartas da m�o a ser checada
	 * @return true, caso a combina��o exista naquela m�o
	 */
	public static boolean checkFourOfAKind(Card[] cards){
		int[] counter = new int[Deck.SUIT_SIZE];
		Arrays.fill(counter, 0);
		
		// marque quantas cartas de cada tipo est�o na m�o e conte-as
		for (int i = 0; i < cards.length; i++){
			counter[cards[i].getNumber()]++;
		}
		
		// ordene o vetor de contadores
		Arrays.sort(counter);
		
		// se existe, pelo menos, um numero que se repete,
		// pelo menos, quatro vezes, a combina��o existe
		if (counter[Deck.SUIT_SIZE - 1] >= 4){
			return true;
		} else return false;
	}
	
	/**
	 * Testa a condi��o "Full House": retorna verdadeiro caso exista
	 * um n�mero que se repete, pelo menos, tr�s vezes, e outro que se
	 * repete, pelo menos, duas vezes, em uma m�o.
	 * @param cards vetor com as cartas da m�o a ser checada
	 * @return true, caso a combina��o exista naquela m�o
	 */
	public static boolean checkFullHouse(Card[] cards){
		int[] counter = new int[Deck.SUIT_SIZE];
		Arrays.fill(counter, 0);
		
		// marque quantas cartas de cada tipo est�o na m�o e conte-as
		for (int i = 0; i < cards.length; i++){
			counter[cards[i].getNumber()]++;
		}
		
		// ordene o vetor de contadores
		Arrays.sort(counter);
		
		// se existe, pelo menos, um numero que se repete,
		// pelo menos, tr�s vezes, e outro numero que se repete,
		// pelo menos, duas vezes, a combina��o existe
		if (counter[Deck.SUIT_SIZE - 1] >= 3 && counter[Deck.SUIT_SIZE - 2] >= 2){
			return true;
		} else return false;
	}
	
	/**
	 * Testa a condi��o "Flush": retorna verdadeiro caso exista
	 * um naipe que se repete cinco vezes em uma m�o.
	 * @param cards vetor com as cartas da m�o a ser checada
	 * @return true, caso a combina��o exista naquela m�o
	 */
	public static boolean checkFlush(Card[] cards){
		int[] counter = new int[Deck.QUANT_SUIT];
		Arrays.fill(counter, 0);
		
		// marque quantas cartas de cada naipe est�o na m�o e conte-as
		for (int i = 0; i < cards.length; i++){
			counter[cards[i].getSuit()]++;
		}
		
		// ordene o vetor de contadores
		Arrays.sort(counter);
		
		// se existe um naipe que se repete cinco vezes,
		// a combinacao existe
		if (counter[Deck.QUANT_SUIT - 1] >= 5){
			return true;
		} else return false;
	}
	
	/**
	 * Testa a condi��o "Straight": retorna verdadeiro caso exista
	 * uma sequ�ncia de cinco cartas na m�o.
	 * @param cards vetor com as cartas da m�o a ser checada
	 * @return true, caso a combina��o exista naquela m�o
	 */
	public static boolean checkStraight(Card[] cards){
		int[] counter = new int[Deck.SUIT_SIZE];
		int sequence = 0;
		Arrays.fill(counter, 0);
		
		// marque quantas cartas de cada tipo est�o na m�o e conte-as
		for (int i = 0; i < cards.length; i++){
			counter[cards[i].getNumber()]++;
		}
		
		// verifique se h� uma sequencia
		for (int i = 0; i < Deck.SUIT_SIZE; i++){
			if (sequence == 5) break;
			
			if (counter[i] >= 1) sequence++;
			else sequence = 0;
		}
		
		// se existe uma sequencia, a combinacao existe
		if (sequence == 5) return true;
		else return false;
	}
	
	/**
	 * Testa a condi��o "Straight Flush": retorna verdadeiro caso
	 * exista uma sequ�ncia de cinco cartas, do mesmo naipe. Usa as
	 * fun��es checkStraight e checkFlush.
	 * @param cards vetor com as cartas da m�o a ser checada
	 * @return true, caso a combina��o exista naquela m�o
	 */
	public static boolean checkStraightFlush(Card[] cards){
		return checkStraight(cards) && checkFlush(cards);
	}
	
	/**
	 * Testa a condi��o "Royal Straight Flush": retorna verdadeiro caso
	 * exista a sequ�ncia 10-J-Q-K-A, do mesmo naipe. Usa a fun��o checkFlush
	 * para checar a existencia dos naipes iguais.
	 * @param cards vetor com as cartas da m�o a ser checada
	 * @return true, caso a combina��o exista naquela m�o
	 */
	public static boolean checkRoyalStraightFlush(Card[] cards){
		// a combina��o deve ser um flush
		if (checkFlush(cards)){
			boolean[] royalCheckers = new boolean[5];
			boolean[] royalTest = {true, true, true, true, true};
			Arrays.fill(royalCheckers, false);
			
			// marque se existe as cartas da combina��o
			for (int i = 0; i < cards.length; i++){
				if (cards[i].getNumber() >= ROYAL_START){
					royalCheckers[cards[i].getNumber() - ROYAL_START] = true;
				}
			}
			
			// caso todas as posicoes sejam verdadeiras,
			// a combinacao existe
			return Arrays.equals(royalCheckers, royalTest);
		} else return false;
	}
}
