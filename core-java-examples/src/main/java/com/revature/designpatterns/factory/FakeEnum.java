package com.revature.designpatterns.factory;

// For demonstration and understanding how enums work
public class FakeEnum {

	private final String direction;
	
	// Think of these as the enum values
	public static final FakeEnum NORTH = new FakeEnum("North");
	public static final FakeEnum SOUTH = new FakeEnum("South");
	public static final FakeEnum EAST = new FakeEnum("East");
	public static final FakeEnum WEST = new FakeEnum("West");
	
	// private constructor to restrict instantiation
	private FakeEnum(String direction) {
		this.direction = direction;
	}

	public String getDirection() {
		return direction;
	}
	
}

class FakeEnumDriver {

	public static void main(String... args) {
		String north = FakeEnum.NORTH.getDirection();
		String south = FakeEnum.SOUTH.getDirection();
	}
	
}





