// this program uses IF, IF/ELSE, and SWITCH to make logical decisions

import javax.swing.JOptionPane;

public class ConditionalStatements{

  public static void main(String[] args){



    // IF, ELSE IF, ELSE

    // initialize variables
    double rate = 500.00;
    int age = 24;
    boolean noTickets = true;

    System.out.println("Driver has no previous tickets: " + noTickets);
    System.out.println("Driver's age: " + age);
    System.out.println("Current insurance rate: " + rate);

    // see if the driver gets a discount:
    if (age >= 25 && noTickets == true){
      rate = rate * 0.85;
      JOptionPane.showMessageDialog(null, "15% safe driver discount is applied");
      System.out.println("Insurance rate after discount: " + rate);
    }
    else if (noTickets) {
      JOptionPane.showMessageDialog(null, "10% discount for no tickets is applied");
      rate = rate * .90;
    }
    else if (age >= 25) {
       JOptionPane.showMessageDialog(null, "5% older driver discount is applied");
       rate = rate * .95;
    }
    else{
       JOptionPane.showMessageDialog(null, "no safe driver discount is applied");
    }


    // SWITCH statement

    int month = 2, days = 0;

    switch(month) {
       case 1:
          days = 31;
          break;
       case 2:
          days = 28;
          break;
       case 3:
          days = 31;
          break;
       case 4:
          days = 30;
          break;
       case 5:
          days = 31;
          break;
       case 6:
          days = 30;
          break;
       case 7:
          days = 31;
          break;
       case 8:
          days = 31;
          break;
       case 9:
          days = 30;
          break;
       case 10:
          days = 31;
          break;
       case 11:
          days = 30;
          break;
       case 12:
          days = 31;
          break;
       default:
        System.out.println("Month incorrect");
        days = 0;
        break;
    } // end switch
    System.out.println("month = " + month);
    System.out.println("days = " + days);

  }
}
