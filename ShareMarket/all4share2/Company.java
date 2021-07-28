package all4share2;
import java.util.*;

class Company{

  String name;
  String code;
  float price=0;
  private int central;
  private float range;
  String HQ;
  float percentage;
  private float high;
  private float low;
  private float high3d;
  private float low3d;
  private float high1m;
  private float low1m;
  private float high6m;
  private float low6m;
  Random rand=new Random();

Company(Cname c){
  name=c.name();
  code=name.substring(0,2)+String.valueOf(12*(int)name.charAt(0));
  switch(c){
    case Mahindra:
    central=310;
    range=1.4f;
    HQ="New Delhi,IN";
    break;
    case Titan:
    central=360;
    range=2f;
    HQ="Bangalore,IN";
    break;
    case Reliance:
    central=225;
    range=0.8f;
    HQ="Mumbai,IN";
    break;
    case Tata:
    central=420;
    range=2.6f;
    HQ="Mumbai,IN";
    break;
    case Nike:
    central=650;
    range=4f;
    HQ="Oregon,USA";
    break;
  }
   this.high=(central-range)+rand.nextFloat()*range;
   this.low=(central-range)+rand.nextFloat()*range;
   this.high3d=(central-range)+rand.nextFloat()*range;
   this.low3d=(central-range)+rand.nextFloat()*range;
   this.high1m=(central-range*1.5f)+rand.nextFloat()*(range*1.5f);
   this.low1m=(central-range*1.5f)+rand.nextFloat()*(range*1.5f);
   this.high6m=(central-range*3f)+rand.nextFloat()*(range*3f);
   this.low6m=(central-range*3f)+rand.nextFloat()*(range*3f);
}

float getCurrentPrice(){
  float p=(central-range)+rand.nextFloat()*range;
  if(price==0f) percentage=rand.nextFloat();
  else{
    percentage=(float)((p-price)/price)*100;
  }
  price=p;
  return price;
}

float gethigh(){
  this.high=(central-range)+rand.nextFloat()*range;
  if(this.high>price){
      return this.high;
    }
  else{
    this.high=price;
    return this.high;
  }
}

float getlow(){
  this.low=(central-range)+rand.nextFloat()*range;
  if(this.low>price){
      this.low=price;
      return this.low;
    }
  else{
    return this.low;
  }
}

float gethigh3d(){
   this.high3d=(central-range)+rand.nextFloat()*range;
  if(this.high3d>this.high) return this.high3d;
  else{
    this.high3d=this.high;
    return this.high3d;
  }
}

float getlow3d(){
  this.low3d=(central-range)+rand.nextFloat()*range;
  if(this.low3d>this.low){
      this.low3d=this.low;
      return this.low;
    }
  else{
    return this.low3d;
  }
}

float gethigh1m(){
  this.high1m=(central-range*1.5f)+rand.nextFloat()*(range*1.5f);
  if(this.high1m>this.high3d)
      return this.high1m;
  else{
    this.high1m=this.high3d;
    return this.high1m;
  }
}

float getlow1m(){
  this.low1m=(central-range*1.5f)+rand.nextFloat()*(range*1.5f);
  if(this.low1m<this.low3d)
      return this.low1m;
  else{
    this.low1m=this.low3d;
    return this.low1m;
  }
}

float gethigh6m(){
  this.high6m=(central-range*3f)+rand.nextFloat()*(range*3f);
  if(this.high6m>this.high1m)
      return this.high6m;
  else{
    this.high6m=this.high1m;
    return this.high6m;
  }
}

float getlow6m(){
  this.low6m=(central-range*3f)+rand.nextFloat()*(range*3f);
  if(this.low6m<this.low1m)
      return this.low6m;
  else{
    this.low6m=this.low1m;
    return this.low6m;
  }
}

}
