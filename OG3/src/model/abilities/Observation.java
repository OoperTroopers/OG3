package model.abilities;

public class Observation extends ExplicitAbility {
	public Observation() {
		super();
		setName("Observation");
		//setEffect(new Observation());
	}
	
	public Observation(char keyToBind) {
		super(keyToBind);
		setName("Observation");
		//setEffect(new Observation());
	}
	
	public void perform() {
		System.out.println("ALLAHU ACKBAR");
		//Do ping
	}
}
