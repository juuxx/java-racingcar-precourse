package domain;

public class Car {

	private final String name;
	private final Position position;

	public Car(String name) {
		this.name = name;
		this.position = new Position();
	}

	public String getName() {
		return name;
	}

	public int getPosition() {
		return position.getPosition();
	}

	public void go(int num) {
		if(num >= 4){
			this.position.add();
		}
	}

	public void print(){
		ResultMessage.print(this);
	}

}
