package all4share2;
import java.io.*;
import java.util.Scanner;

public class Checker{

  public static boolean detailsCheck(String name){
  try{
    File grahak=new File("grahak.txt");
    Scanner reader=new Scanner(grahak);
    String str;
    while(reader.hasNextLine()){
      str=reader.nextLine();
      if(!str.startsWith("Username:")) continue;
      else{
        String[] strs=str.split("[|]");
        if(name.equals(strs[1].trim())) return true;
      }
    }

    return false;
  }catch (FileNotFoundException e) {
      return false;
    }

  }

  public static boolean detailsCheck(String name,String pass){
  try{
    File grahak=new File("grahak.txt");
    Scanner reader=new Scanner(grahak);
    String str;
    while(reader.hasNextLine()){
      str=reader.nextLine();
      if(!str.startsWith("Username:")) continue;
      else{
        String[] strs=str.split("[|]");
        if(name.equals(strs[1].trim()) && pass.equals(strs[2].trim())) return true;
      }
    }
    return false;
  }catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      return false;
    }

  }

  public static int getShare(String cname,String uname){
  try{
    File temp=new File(uname+".txt");
    Scanner reader=new Scanner(temp);
    String str;
    while(reader.hasNextLine()){
      str=reader.nextLine();
      if(str.startsWith("Company:")){
        String[] strs=str.split("[|]");
        if(cname.equalsIgnoreCase(strs[1].trim())) return Integer.parseInt(strs[3].trim());
      }
  }
  return -1;

  }catch (FileNotFoundException e) {
    System.out.println("An error occurred.");
    return -1;
  }

}

public static String getFullLine(String cname,String uname){
  try{
    File temp=new File(uname+".txt");
    Scanner reader=new Scanner(temp);
    String str;
    while(reader.hasNextLine()){
      str=reader.nextLine();
      if(str.startsWith("Company:")){
        String[] strs=str.split("[|]");
        if(cname.equalsIgnoreCase(strs[1].trim())) return str;
      }
  }
  return null;

  }catch (FileNotFoundException e) {
    System.out.println("An error occurred.");
    return null;
  }

  }

  public static String getme(String uname){
    try{
      File temp=new File(uname+".txt");
      Scanner reader=new Scanner(temp);
      String str;
      while(reader.hasNextLine()){
        str=reader.nextLine();
        if(str.startsWith("Details:")) return str;
    }
    return null;

    }catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      return null;
    }

    }

}
