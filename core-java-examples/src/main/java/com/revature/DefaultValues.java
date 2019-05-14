package com.revature;

public class DefaultValues {

	boolean myBoolean;
	byte myByte;
	char myChar;
	short myShort;
	int myInt;
	long myLong;
	float myFloat;
	double myDouble;
	Object myObject;
	String myString;
		
		
	public void printValues() {
		StringBuilder builder = new StringBuilder();
		builder.append("Value of myBoolean: ");
		builder.append(myBoolean);
		builder.append("\n");
		builder.append("Value of myByte: ");
		builder.append(myByte);
		builder.append("\n");
		builder.append("Value of myChar: ");
		builder.append(myChar);
		builder.append("\n");
		builder.append("Value of myShort: " );
		builder.append(myShort);
		builder.append("\n");
		builder.append("Value of myInt: " );
		builder.append(myInt);
		builder.append("\n");
		builder.append("Value of myLong: " );
		builder.append(myLong);
		builder.append("\n");
		builder.append("Value of myFloat: " );
		builder.append(myFloat);
		builder.append("\n");
		builder.append("Value of myDouble: " );
		builder.append(myDouble);
		builder.append("\n");
		builder.append("Value of myObject: " );
		builder.append(myObject);
		builder.append("\n");
		builder.append("Value of myString: " );
		builder.append(myString);
		builder.append("\n");
		
		System.out.println(builder);
	}
}





