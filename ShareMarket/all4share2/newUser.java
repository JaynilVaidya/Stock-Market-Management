package all4share2;
import java.io.*;
import java.util.Scanner;

class newUser{

  String Uname;
  String pass;

  newUser(){
    boolean created=false;
    Scanner sc =new Scanner(System.in);
    do{
    System.out.println("Let's create a new account : ");
	System.out.println();
    System.out.println("Enter the Username: (Do not use space!)");
    Uname=sc.nextLine();
    System.out.println("Enter Password: (Do not use space!)");
    pass=sc.nextLine();

    created=newGrahak();
  }while(!created);

  }

  boolean newGrahak(){
    Checker check=new Checker();
    if(!check.detailsCheck(Uname)){//
      try{
      FileWriter writer=new FileWriter("grahak.txt",true);
      writer.write("Username: |"+Uname+"|"+pass+"\n");

      writer.close();
      addnew();

      return true;
    }catch (IOException e) {
          return false;
    }

  }else {
    System.out.println("This Username already exists!");
    return false;
  }

  }

  void addnew(){
    File newFile=new File(Uname+".txt");
    try{
      newFile.createNewFile();
    } catch (IOException e) {
      System.out.println("Error in createing file.");
    }
    Scanner sc=new Scanner(System.in);
    String data;

    try{
    FileWriter writer=new FileWriter(newFile,true);
	System.out.println();
	System.out.println("Enter full details.");
    System.out.println();
	System.out.print("Enter your full name: ");
    data=sc.nextLine();
    writer.write("Details: |"+data+"|");
    System.out.print("Enter age: ");
    data=sc.nextLine();
    writer.write(data+"|");
    System.out.print("Enter gender[male/female]: ");
    data=sc.nextLine();
    writer.write(data+"\n");

    writer.close();
  }catch (IOException e) {
        System.out.println("An error occurred.");
  }

  }

  protected String getuname(){
    return Uname;
  }

  protected String getpass(){
    return pass;
  }

}
