

/**
 * Classe que contem as definiÃ§Ãµes de uma carta de baralho.
 * 
 * @author Gabriel Toschi + Marcos Wendell
 *
 */
public class Card {
	public int num;
	public int naipe;
	
	/**
	 * Atribui o nÃºmero da carta.
	 * 
	 * @param n - nÃºmero que serÃ¡ atribuido.
	 */
	public void setNumber(int n){
		num = n; 
	}
	
	/**
	 * Atribui o naipe da carta
	 * 
	 * @param n - naipe que serÃ¡ atribuido
	 */
	public void setSuit(int n){
		naipe = n;
	}
	
	/**
	 * Recupera o numero da carta sorteada.
	 * 
	 * @return Numero da carta da classe Carta
	 */
	public int getNumber(){
		return num;
	}
	
	/**
	 * Recupera o naipe da carta sorteada.
	 * 
	 * @return Naipe da carta da classe Carta.
	 */
	public int getSuit(){
		return naipe;
	}
	
	@Override
	/**
	 * Utilizando o numero e o naipe da carta, realiza uma conversao desses dados em string.
	 * 
	 * @return Carta em um formato de string
	 */
	public String toString(){
		String[] str = new String[7]; 
		String ret = new String();
		
		str[0] = "+-------+\n";
		str[6] = "+-------+\n";
		
		switch(naipe){
			case 0:
					str[1] = "|W      |\n"; 
					str[5] = "|      W|\n";
					break;
			case 1:
					str[1] = "|X�     |\n"; 
					str[5] = "|      X|\n"; 
					break;
			case 2:
					str[1] = "|Y      |\n"; 
					str[5] = "|      Y|\n";
					break;
			case 3:
					str[1] = "|Z      |\n"; 
					str[5] = "|      Z|\n";
					break;
		}
		
		if(num == 0){
			str[2] = "|       |\n";
			str[3] = "|  * *  |\n";
			str[4] = "|       |\n";
		}
		
		if(num == 1){
			str[2] = "|  *    |\n";
			str[3] = "|   *   |\n";
			str[4] = "|    *  |\n";
		}
		
		if(num == 2){
			str[2] = "|  * *  |\n";
			str[3] = "|       |\n";
			str[4] = "|  * *  |\n";
		}
		
		if(num == 3){
			str[2] = "|  * *  |\n";
			str[3] = "|   *   |\n";
			str[4] = "|  * *  |\n";
		}
		
		if(num == 4){
			str[2] = "|  * *  |\n";
			str[3] = "|  * *  |\n";
			str[4] = "|  * *  |\n";
		}
		
		if(num == 5){
			str[2] = "|  * *  |\n";
			str[3] = "| * * * |\n";
			str[4] = "|  * *  |\n";
		}
		
		if(num == 6){
			str[2] = "| * * * |\n";
			str[3] = "|  * *  |\n";
			str[4] = "| * * * |\n";
		}
		
		if(num == 7){
			str[2] = "| * * * |\n";
			str[3] = "| * * * |\n";
			str[4] = "| * * * |\n";
		}
		
		if(num == 8){
			str[2] = "| * * * |\n";
			str[3] = "|* * * *|\n";
			str[4] = "| * * * |\n";
		}
		
		if(num == 9){
			str[2] = "|       |\n";
			str[3] = "|   J   |\n";
			str[4] = "|       |\n";
		}
		
		if(num == 10){
			str[2] = "|       |\n";
			str[3] = "|   Q   |\n";
			str[4] = "|       |\n";
		}
		
		if(num == 11){
			str[2] = "|       |\n";
			str[3] = "|   K   |\n";
			str[4] = "|       |\n";
		}
		
		if(num == 12){
			str[2] = "|       |\n";
			str[3] = "|   A   |\n";
			str[4] = "|       |\n";
		}
		
		for(int i = 0; i < 7; i++)
			ret += str[i];
		
		return ret;
	}
	
}
