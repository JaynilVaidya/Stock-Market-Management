package all4share2;
import java.util.Scanner;
import java.util.Date;

class displayMenu{

  Scanner scanit=new Scanner(System.in);
  UserFile mine;

  displayMenu(UserFile m){
    this.mine=m;
  }

 void mainmenu(){
	 pattern.mainmenu();
    System.out.printf("\n1.Market Status\n2.Invest in a company\n3.My Investments\n4.Sell shares\n5.My Profile\n6.Log Out\n");
    System.out.print("Option: ");
    int n=scanit.nextInt(); scanit.nextLine();
    switch(n){
      case 1:
      marketStatus();
      break;
      case 2:
      investnow();
      break;
      case 3:
      myInvestmentsProfile();
      break;
      case 4:
      selling();
      break;
      case 5:
      mine.viewme();
      pattern.delay(1500);
      mainmenu();
      break;
      case 6:
	pattern.end();
      System.exit(0);
      break;
      default:
      System.out.println("Plase Enter a valid response!");
      mainmenu();
    }

  }

  void marketStatus(){
    pattern.market();
    pattern.line('-');
    for(Cname c: Cname.values()){
      pattern.delay(1500);
      Company current = Companies.getCompany(c);
    System.out.printf("Company Name :%s \n",current.name);
		System.out.printf("Company Code : %s\n",current.code);
		System.out.printf("Company Headquarters : %s\n\n",current.HQ);
    System.out.printf("Current price : %.2f\n",current.getCurrentPrice());
		System.out.printf("Percentage : %.2f%%\n",current.percentage);
    System.out.printf("High : %.2f\nLow : %.2f\n\n",current.gethigh(),current.getlow());
    System.out.print("News : ");
    c.news();
    pattern.line('-');
	System.out.println();
    }
    Task:{
		System.out.println();
		System.out.println();
    System.out.printf("1.Get full details of any selected company\n2.Invest in a company\n3.Refresh page\n4.Go Back\n");
    System.out.print("Option: ");
    int n=scanit.nextInt(); scanit.nextLine();
    switch(n){
      case 1:
      fullDetails();
      break;
      case 2:
      investnow();
      break;
      case 3:
      marketStatus();
      break;
      case 4:
      mainmenu();
      break;
      default:
      System.out.println("Plase Enter a valid response!");
      break Task;
      }
    }
  }

  void fullDetails(){
    int flag=0;
    System.out.print("Enter the name of the company of which you want the details : ");
    String c=scanit.nextLine();
	System.out.println();
    pattern.line('~');
    for(Cname cmp:Cname.values())
      if(c.equalsIgnoreCase(cmp.name())){
        flag=1;
	pattern.company(cmp);
      Company current = Companies.getCompany(cmp);
	  pattern.line('%');
	  System.out.println();
      System.out.printf("Company Name :%s \n",current.name);
      System.out.printf("Company Code : %s\n",current.code);
      System.out.printf("Company Headquarters : %s\n\n",current.HQ);
      System.out.printf("Current price : %.2f\n",current.getCurrentPrice());
      System.out.printf("Percentage : %.2f%%\n\n",current.percentage);
      System.out.printf("Statistics :-\n");
	  System.out.println();
      System.out.printf("High : %.2f\nLow : %.2f\n",current.gethigh(),current.getlow());
      System.out.printf("3D High : %.2f\n3D Low : %.2f\n",current.gethigh3d(),current.getlow3d());
      System.out.printf("1M High : %.2f\n1M Low : %.2f\n",current.gethigh1m(),current.getlow1m());
      System.out.printf("6M High : %.2f\n6M Low : %.2f\n",current.gethigh6m(),current.getlow6m());
      System.out.printf("(D:Day   M: Month)\n\n");
      System.out.printf("News:-\n");
      cmp.news();
    }
      pattern.line('%');

      if(flag==0){
        System.out.println("Sorry! No such company exists. Try again[yes/no]:-");
        String yesno=scanit.nextLine();
        if(yesno.equalsIgnoreCase("yes")) fullDetails();
        else mainmenu();
      }
	  System.out.println();
      System.out.print("Would you like to invest in this company[yes/no]: ");
      String yesno=scanit.nextLine();
      if(yesno.equalsIgnoreCase("yes")) investnow();
      else mainmenu();

  }

  void fullDetails(Cname cmp){
    pattern.line('-');
	pattern.company(cmp);
      Company current = Companies.getCompany(cmp);
	  pattern.line('%');
	  System.out.println();
      System.out.printf("Company Name :%s \n",current.name);
      System.out.printf("Company Code : %s\n",current.code);
      System.out.printf("Company Headquarters : %s\n\n",current.HQ);
      System.out.printf("Current price : %.2f\n",current.getCurrentPrice());
      System.out.printf("Percentage : %.2f%%\n\n",current.percentage);
      System.out.printf("Statistics :-\n");
	  System.out.println();
      System.out.printf("High : %.2f\nLow : %.2f\n",current.gethigh(),current.getlow());
      System.out.printf("3D High : %.2f\n3D Low : %.2f\n",current.gethigh3d(),current.getlow3d());
      System.out.printf("1M High : %.2f\n1M Low : %.2f\n",current.gethigh1m(),current.getlow1m());
      System.out.printf("6M High : %.2f\n6M Low : %.2f\n",current.gethigh6m(),current.getlow6m());
      System.out.printf("(D:Day   M: Month)\n\n");
      System.out.printf("News:-\n");
      cmp.news();
      pattern.line('%');

  }

  void investnow(){
    int flag=0;
	System.out.println();
    System.out.print("Enter the name of the company in which you want to invest or Enter 'b' to go back : ");
    String c=scanit.nextLine();
	if(c.equalsIgnoreCase("b"))
	mainmenu();
    for(Cname cmp:Cname.values())
      if(c.equalsIgnoreCase(cmp.name())){
        fullDetails(cmp);
		System.out.println();
        System.out.print("Enter the number of shares you would like to buy:-");
        int amt=Integer.parseInt(scanit.nextLine());
        if(amt==0){
          System.out.println("Sorry! The response cannot be zero.");
          mainmenu();
          return;
        }
        System.out.println();
        mine.Invest(cmp,amt);
        flag=1;
        break;
      }
      if(flag==0) System.out.println("Sorry! No such company exists. Please try again:-");
	  System.out.println();
      System.out.println("Would you like to invest in another company? [yes/no]:");
      String yesno=scanit.nextLine();
      if(yesno.equalsIgnoreCase("yes")) investnow();
      else {
		  System.out.println();
        System.out.println("Moving to main menu.");
		System.out.println();
        mainmenu();
      }
  }

  void myInvestmentsProfile(){
	pattern.myinvestment();
    int flag=0;
    for(Cname c: Cname.values()){
      pattern.delay(500);
      Company current = Companies.getCompany(c);
    String profile=mine.getInvestments(c);
    if(profile==null) continue;
    flag=1;
    String strs[]=profile.split("[|]");
      pattern.line('^');
      System.out.printf("Company : %s\nCode : %s\n",strs[1],strs[2]);
      System.out.printf("Shares Bought : %s\nBought At : %s\n",strs[3],strs[4]);
      System.out.printf("Current Price : %.2f\n",current.getCurrentPrice());
      System.out.printf("Profit (if all sold) : %.2f\n",(Float.parseFloat(strs[3]))*(current.price-Float.parseFloat(strs[4])));
    }
    pattern.line('^');

    if(flag==0){
      System.out.println("You currently have no invesments!");
      System.out.print("Want to Invest now ? [yes/no]:");
      String yesno=scanit.nextLine();
      if(yesno.equalsIgnoreCase("yes")){
        System.out.println();
        marketStatus();
        return;
      }
      else mainmenu();
}
	System.out.println();
    System.out.println("1.Sell Shares\n2.Go Back");
    int n=scanit.nextInt(); scanit.nextLine();
    if(n==1) selling();
    mainmenu();
  }

String myInvestmentsProfile(Cname name){
  Company current = Companies.getCompany(name);
  String profile=mine.getInvestments(name);
  if(profile==null){
    System.out.println("You currently have no investments in the company: "+name.name());
    return null;
  }
  String strs[]=profile.split("[|]");
    pattern.line('^');
    System.out.printf("Company : %s\nCode : %s\n",strs[1],strs[2]);
    System.out.printf("Shares Bought : %s\nBought At : %s\n",strs[3],strs[4]);
    System.out.printf("Current Price : %.2f\n",current.price);
    System.out.printf("Profit (if all sold) : %.2f\n",(Float.parseFloat(strs[3]))*(current.price-Float.parseFloat(strs[4])));
    System.out.println("(All amounts in rupees)");
    System.out.println();
    return profile;
}

void selling(){
  int flag=0;
  String holding;
  System.out.print("Enter the name of the company whose shares you want to sell : ");
  String c=scanit.nextLine();
  for(Cname cmp:Cname.values())
    if(c.equalsIgnoreCase(cmp.name())){
      if((holding=myInvestmentsProfile(cmp))==null) return;
      String[] strs=holding.split("[|]");
	  System.out.println();
      System.out.print("Enter the number of shares you would like to sell:-");
      int amt=Integer.parseInt(scanit.nextLine());
      if(amt==0){
        System.out.println("Sorry! The response cannot be zero.");
        mainmenu();
        return;
      }
      System.out.println();
      if(amt > Integer.parseInt(strs[3])){
        System.out.printf("\nSorry! cannot sell more shares than you have.\n\n");
        return;
      }
      Company comp=Companies.getCompany(cmp);
      if(Float.parseFloat(strs[4]) > comp.price){
        System.out.printf("Selling these shares now would incure a loss of : Rs %.2f\n",amt*(Float.parseFloat(strs[4])-comp.price));
        System.out.print("Would you like to proceed?[yes/no]: ");
        String yesno=scanit.nextLine();
        if(!yesno.equalsIgnoreCase("yes")) return;
      }
      mine.updateinvest(cmp,-amt);
      flag=1;
      break;
    }
    if(flag==0) System.out.println("Sorry! No such company exists. Please try again:-");
	mainmenu();

  }

}
