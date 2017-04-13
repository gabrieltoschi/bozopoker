/**
 * O Scoreboard guarda e manipula os cr�ditos de um jogador
 * durante uma partida de Video Poker.
 * @author Gabriel Toschi & Marcos Wendell
 *
 */
public class Scoreboard {
	/**
	 * Os cr�ditos de um jogador.
	 */
	private long credits;
	
	/**
	 * Indica o fim dos cr�ditos e o fim do jogo.
	 */
	private boolean endGame = false;
	
	/**
	 * Constante para colocar os espa�os vazios na fun��o toString.
	 */
	private static final int BOARD_SPACES = 14;
	
	/**
	 * Constr�i um novo Scoreboard com uma quantidade inicial de cr�ditos.
	 * @param startCredits quantidade inicial de cr�ditos
	 */
	public Scoreboard(long startCredits){
		credits = startCredits;
	}
	
	/**
	 * Retorna a quantidade de cr�ditos atual de uma Scoreboard.
	 * @return quantidade atual de cr�ditos
	 */
	public long getCredits(){
		return credits;
	}
	
	/**
	 * Fixa uma nova quantidade de cr�ditos na Scoreboard.
	 * @param credits nova quantidade de cr�ditos
	 */
	public void setCredits(long credits){
		this.credits = credits;
	}
	
	/**
	 * Atualiza a quantidade de cr�ditos somando um n�mero, positivo ou negativo.
	 * @param offset quantidade de cr�ditos a ser adicionada/retirada
	 */
	public void updateCredits(long offset){
		credits += offset;
		
		// caso os cr�ditos tenham zerado
		if (credits <= 0){
			credits = 0;
			endGame = true;
		}
	}
	
	/**
	 * Retorna true caso o jogo tenha terminado (quantidade de cr�ditos igual a 0).
	 * @return true, se o jogo j� terminou
	 */
	public boolean isGameFinished(){
		return endGame;
	}
	
	/**
	 * Transforma a representa��o da Scoreboard em String.
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
