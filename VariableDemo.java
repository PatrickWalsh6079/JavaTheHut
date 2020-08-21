// EXERCISE 3 - declare, initialize, and use Java primative variables
public class VariableDemo
{
  public static void main(String[] args)
  {
    // Declare and initialize primitive variables
    byte myByte = 20;
    // use short for numbers between -32,768 and 32,767
    short myShort = 2000;
    int myInt = 20000;
    long myLong = 2000000L;
    float myFloat = 32.345f;
    double myDouble = 32.932;
    boolean myBoolean = true;
    // 'char' data type should always use single quotes
    char myChar = 'C';

    // "final" variables are immutable
    final double SPEED_OF_SOUND = 343.6;


    // Print each variable along with the value
    System.out.println("myByte: " + myByte);
    System.out.println("myShort: " + myShort);
    System.out.println("myInt: " + myInt);
    System.out.println("myLong: " + myLong);
    System.out.println("myFloat: " + myFloat);
    System.out.println("myDouble: " + myDouble);
    System.out.println("myBoolean: " + myBoolean);
    System.out.println("myChar: " + myChar);
    System.out.println("SPEED_OF_SOUND: " + SPEED_OF_SOUND);
  }
}
