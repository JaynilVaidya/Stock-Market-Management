package all4share2;
import java.io.*;
import java.util.Scanner;

class UserFile extends User{

  File mydata=new File(super.username+".txt");

  UserFile(){
    try{
      mydata.createNewFile();
    } catch (IOException e) {
      System.out.println("Error in creating file");
    }

  }

  String getInvestments(Cname name){
    String n=Checker.getFullLine(name.name(),username);
    if(n !=null)return n;
    else return null;
  }

  void Invest(Cname name, int amount){
    int n = Checker.getShare(name.name(),username);
    if(n==-1) addinvest(name,amount);
    else{
      String s=getInvestments(name);
      String[] strs=s.split("[|]");
      System.out.printf("You already have %s shares in the company.\nWould you like to buy more shares?[yes/no]\n",strs[3]);
      s=sc.nextLine();
       if(s.equalsIgnoreCase("yes")) updateinvest(name,amount);
       else return;
    }
  }


  void addinvest(Cname name,int amount){
    Company cmp= Companies.getCompany(name);
	System.out.printf("/\\/\\/\\/\\/\\/\\/\\/\\/\\ Bill \\/\\/\\/\\/\\/\\/\\/\\/\\/\\");
	System.out.println();
    System.out.printf("Total shares : %d\n",amount);
    System.out.printf("Current price : %.2f\n",cmp.price);
    System.out.printf("Total amount : %.2f\n",Math.abs(cmp.price*amount));
    System.out.printf("Brokerage(5%%) : %.2f\n",0.05*cmp.price*amount);
    System.out.printf("Grand Total : %.2f\n",1.05*cmp.price*amount);
    System.out.println("(All amounts in rupees)");
	System.out.println();
	pattern.line('~');
	System.out.println();
    System.out.print("Would you like to proceed to pay[yes/no]: ");
    String yesno=sc.nextLine();
    System.out.println();
    if(!yesno.equalsIgnoreCase("yes")) return;

    File current =new File(username+".txt");
    try{
      current.createNewFile();
    FileWriter writer=new FileWriter(current,true);
    writer.write("Company: |"+cmp.name+"|"+cmp.code+"|"+(int)amount+"|"+cmp.price+"\n");
    writer.close();
    System.out.println("Transaction Successfull!");
  }catch (IOException e) {
        System.out.println("An error occurred.");
  }

  }

void updateinvest(Cname name,int amount){
  try{
    Company comp=Companies.getCompany(name);
	System.out.printf("/\\/\\/\\/\\/\\/\\/\\/\\/\\ Bill \\/\\/\\/\\/\\/\\/\\/\\/\\/\\");
	System.out.println();
    System.out.printf("Total shares: %d\n",Math.abs(amount));
    System.out.printf("Current price: %.2f\n",comp.price);
    System.out.printf("Total amount: %.2f\n",Math.abs(comp.price*amount));
    System.out.printf("Brokerage(5%%): %.2f\n",Math.abs(0.05*comp.price*amount));
    System.out.printf("Grand Total: %.2f\n",Math.abs(comp.price*amount)+0.05*comp.price*amount);
    System.out.println("(All amounts in rupees)");
	System.out.println();
	pattern.line('~');
	System.out.println();
    if(amount>0) System.out.print("\nWould you like to proceed to pay[yes/no]: ");
    else System.out.print("\nWould you like to proceed to recieve payment[yes/no]: ");
    String yesno=sc.nextLine();
    System.out.println();
    if(!yesno.equalsIgnoreCase("yes")) return;

  String old=getInvestments(name);
  String[] strs=old.split("[|]");
  strs[3]=String.valueOf(Integer.parseInt(strs[3])+(int)amount);

  StringBuffer updated =new StringBuffer();
  for(String s:strs){
  updated.append(s);
  updated.append("|");
}
  Scanner reader = new Scanner(new File(username+".txt"));
      StringBuffer buffer = new StringBuffer();
      String temp;
      while (reader.hasNextLine()) {
         if((temp=reader.nextLine().trim()).equals(old)) temp=updated.toString();
         buffer.append(temp+System.lineSeparator());
      }
      String fileContents = buffer.toString();
      FileWriter writer = new FileWriter(username+".txt");
      writer.append(fileContents);
      reader.close();
      writer.flush();
      System.out.println("Transaction Successfull!");
    }catch (IOException e) {
          System.out.println("An error occurred.");
    }

}

  void viewme(){
    String profile=Checker.getme(username);
    if(profile==null){
      System.out.println("Sorry! Something went wrong :(");
      return;
    }
    String strs[]=profile.split("[|]");

    System.out.println();
    pattern.line('~');
	System.out.println();
    System.out.printf("Name: %s\n",strs[1]);
    System.out.printf("Age: %s\n",strs[2]);
    System.out.printf("Gender: %s\n",strs[3]);
	System.out.println();
    pattern.line('~');

  }

}
