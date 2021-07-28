package all4share2;

class Companies{

  static Company first=new Company(Cname.Mahindra); //static variable, so accessible by everyone
  static Company second=new Company(Cname.Titan);
  static Company third=new Company(Cname.Reliance);
  static Company fourth=new Company(Cname.Tata);
  static Company fifth=new Company(Cname.Nike);

  static Company getCompany(Cname c){
    switch(c){
      case Mahindra:
      return first;
      case Titan:
      return second;
      case Reliance:
      return third;
      case Tata:
      return fourth;
      case Nike:
      return fifth;
      default:
      return null;
    }

  }//gives the object of the class companys(selected)

}
