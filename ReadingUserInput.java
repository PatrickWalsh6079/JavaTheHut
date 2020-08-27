// This progam takes user input and prints out the result

import java.io.*;

public class ReadingUserInput{

  public static void main(String[] args) throws IOException{ // this handles input errors
    // initialize variables
    int a;
    double b;

    // connects input to the variable stdin and allows the use of readLine()
    BufferedReader stdin = new BufferedReader(
    new InputStreamReader (System.in));

    System.out.print("Type the value of an integer: ");
    // convert string to integer
    a = Integer.parseInt(stdin.readLine());

    // convert string to double
    System.out.print("Now type the value of a double: ");
    b = Double.parseDouble(stdin.readLine());

    System.out.println("a is: " + a);
    System.out.println("b is: " + b);

  }
}
