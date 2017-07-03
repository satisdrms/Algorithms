package pack1;

//Design the data structures for a generic deck of cards. Explain how you would subclass it to implement particular card games.
enum cardFlavours {
	HEART(1), SPADE(2), CLUB(3), DIAMONDS(4);
	int value;

	private cardFlavours(int value) {
		this.value = value;
	}
}

class Cards {
	int number;
	cardFlavours flavour;

	Cards(int number, cardFlavours flavour) {
		this.number = number;
		this.flavour = flavour;
	}

	public int getNumber() {
		return number;
	}

	public cardFlavours getFlavour() {
		return flavour;
	}
}

class CardBlackJack extends Cards {
	

	CardBlackJack(int number, cardFlavours flavour) {
		super(number, flavour);
	}
	public int getNumber(){
		int m=super.getNumber();
		if(m==1) return 11;
		else if(m<10) return m;
		else return 10;
				
	}
	public cardFlavours getFlavour(){
		return super.getFlavour();
	}
	
	public boolean isAce(){
		return super.getNumber()==1;
	}
	

}

public class Topic_19_OOD_EX1 {

	public static void main(String[] args) {
		CardBlackJack card=new CardBlackJack(1, cardFlavours.CLUB);
		System.out.println();

	}

}
