

/**
 * Classe que contem todas as cartas do baralho.
 * 
 * 
 * @author Gabriel Toschi + Marcos Wendell.
 *
 */
public class Deck {
	Random rand = new Random();
	private Card[] cartas = new Card[52];
	boolean[] pushed = new boolean[52];
	
	/**
	 * Quantidade de cartas por deck de cartas.
	 */
	public static final int DECK_SIZE = 52;
	
	/**
	 * Quantidade de cartas por naipe.
	 */
	public static final int SUIT_SIZE = 13;
	
	/**
	 * Quantidade de naipes por deck de cartas.
	 */
	public static final int QUANT_SUIT = 4;
	
	/**
	 * Constructor que inicializa todas as cartas e também o vetor de boolean que verifica as cartas já puxadas.
	 */
	public Deck(){
		for(int i = 0; i < 4; i++){
			for(int j = 0; j < 13; j++){
				cartas[i*13 + j] = new Card();
				cartas[i*13 + j].setNumber(j);
				cartas[i*13 + j].setSuit(i);
				pushed[i*13 + j] = false;
			}
		}
	}
	
	/**
	 * Puxa uma carta do barulho.
	 * 
	 * @return Card - uma carta do baralho.
	 */
	public Card pushCard(){
		int aux;
		do{
			aux = rand.getIntRand(52);
		} while(checkCard(aux));
		pushed[aux] = true;
		return cartas[aux];		
	}
	
	/**
	 * Verifica se a carta já foi puxada.
	 * 
	 * @param i - índice da carta que queremos verificar. 
	 * @return boolean - se a carta já foi puxada ou não.
	 */
	public boolean checkCard(int i){
		return pushed[i];
	}
}
