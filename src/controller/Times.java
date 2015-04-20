package controller;

public enum Times {
	FULL_SECOND(1000),
	LONG(500),
	MEDIUM(250),
	SHORT(100),
	FLEETING(50);
	
	int timePeriod;
	
	private Times(int timePeriod) {
		this.timePeriod = timePeriod;
	}
}