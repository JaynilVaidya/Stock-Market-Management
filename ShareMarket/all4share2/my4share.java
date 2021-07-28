package all4share2;
import java.io.*;
import java.util.*;

class my4share{
  public static void main(String args[]){

    pattern.logo();
    pattern.stonks();
    Scanner sc=new Scanner(System.in);
	  System.out.println();
    System.out.print("Are you an existing user? [yes/no] - ");
    String yesno=sc.nextLine();
    System.out.println();

    if(yesno.equalsIgnoreCase("no")){
      newUser add=new newUser();
    }

    UserFile me= new UserFile();
    displayMenu disp= new displayMenu(me);
    disp.mainmenu();

  }

}
