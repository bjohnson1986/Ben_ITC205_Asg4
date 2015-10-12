public class Dice {
			
	private DiceValue value;
	
	public Dice() {
		value =  DiceValue.getRandom();
	}
	
	public DiceValue getValue() {
		return value;
	}

	public DiceValue roll() {
		DiceValue d = DiceValue.getRandom();
		value = d;
		return d;
	}		
	
	public String toString() {
		return value.toString();
	}
}
