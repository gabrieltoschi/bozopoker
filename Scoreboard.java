/**
 * O Scoreboard guarda e manipula os créditos de um jogador
 * durante uma partida de Video Poker.
 * @author Gabriel Toschi & Marcos Wendell
 *
 */
public class Scoreboard {
	/**
	 * Os créditos de um jogador.
	 */
	private long credits;
	
	/**
	 * Indica o fim dos créditos e o fim do jogo.
	 */
	private boolean endGame = false;
	
	/**
	 * Constante para colocar os espaços vazios na função toString.
	 */
	private static final int BOARD_SPACES = 14;
	
	/**
	 * Constrói um novo Scoreboard com uma quantidade inicial de créditos.
	 * @param startCredits quantidade inicial de créditos
	 */
	public Scoreboard(long startCredits){
		credits = startCredits;
	}
	
	/**
	 * Retorna a quantidade de créditos atual de uma Scoreboard.
	 * @return quantidade atual de créditos
	 */
	public long getCredits(){
		return credits;
	}
	
	/**
	 * Fixa uma nova quantidade de créditos na Scoreboard.
	 * @param credits nova quantidade de créditos
	 */
	public void setCredits(long credits){
		this.credits = credits;
	}
	
	/**
	 * Atualiza a quantidade de créditos somando um número, positivo ou negativo.
	 * @param offset quantidade de créditos a ser adicionada/retirada
	 */
	public void updateCredits(long offset){
		credits += offset;
		
		// caso os créditos tenham zerado
		if (credits <= 0){
			credits = 0;
			endGame = true;
		}
	}
	
	/**
	 * Retorna true caso o jogo tenha terminado (quantidade de créditos igual a 0).
	 * @return true, se o jogo já terminou
	 */
	public boolean isGameFinished(){
		return endGame;
	}
	
	/**
	 * Transforma a representação da Scoreboard em String.
	 */
	@Override
	public String toString(){
		String scoreboard = "+-------------------------+\n| CREDITS: ";
		scoreboard += credits;
		
		int spaces = BOARD_SPACES - Long.toString(credits).length();
		while (spaces >= 0){
			scoreboard += " ";
			spaces--;
		}
		
		scoreboard += "|\n+-------------------------+\n";
		
		return scoreboard;
	}

}
