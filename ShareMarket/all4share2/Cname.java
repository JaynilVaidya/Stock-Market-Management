package all4share2;
import java.util.Random;

enum Cname{
  Mahindra{
    public void news(){
      Random rand=new Random();
      String[] strs=new String[5];
      strs[0]="HAL,Tech Mahindra sign Rs 400-cr deal for 'Project Privartan'.";
      strs[1]="Mahindra throws a 410-bps margin surprise in Q2FYT1.";
      strs[2]="The company reported a 34 per cent jump in consolidated net profit at Rs 353 crore for the second quarter ended September of this fiscal.";
      strs[3]="Tech Mahindra announces acquisition of 6.03 per cent equity shares in VitalTech Holdings";
      strs[4]="The IT services company had posted a profit of Rs 1,123.9 crore in the year-ago period";
      System.out.println(strs[rand.nextInt(5)]);
      System.out.println(strs[rand.nextInt(5)]);
    }
  },
  Titan{
    public void news(){
      Random rand=new Random();
      String[] strs=new String[5];
      strs[0]="Titan Company consolidated net profit declines 44.44% in the September 2020 quar.";
      strs[1]="Titan Company may report flattish growth in sales; margins likely to be under pressure.";
      strs[2]="Titan Company launches first overseas Tanishq store in Dubai.";
      strs[3]="Titan Company may report flattish growth in sales; margins likely to be under pressure.";
      strs[4]="Rekha Jhunjhunwala sells minor stake in Titan; Should investors buy or sell post Q2?";
      System.out.println(strs[rand.nextInt(5)]);
      System.out.println(strs[rand.nextInt(5)]);
    }
  },
  Reliance{
    public void news(){
      Random rand=new Random();
      String[] strs=new String[5];
      strs[0]="Reliance retail unlisted shares defy gravity, quadruple price in 10 months.";
      strs[1]="Reliance shares trade flat in afternoon session.";
      strs[2]="Reliance CEO Mukesh Ambani loses billions as oil slump hits shares";
      strs[3]="RIL shares rebound after sharp fall over previous two sessions";
      strs[4]="Mukesh Ambani slips to the 9th spot in Forbes billionaires list as he loses $7 billion in a single day";
      System.out.println(strs[rand.nextInt(5)]);
      System.out.println(strs[rand.nextInt(5)]);
    }
  },
  Tata{
    public void news(){
      Random rand=new Random();
      String[] strs=new String[5];
      strs[0]="Tata market climbs 5% as JLR sales jumps 50% sequentially in sept.";
      strs[1]="Tata shares trade flat with a negative bias in early season.";
      strs[2]="Analysys says Tata has a healthy hum in share market.";
      strs[3]="While an acceleration in U.S. economic growth accompanied by recovery in consumer demand and strong industrial growth could be positive for Tata";
      strs[4]="Brokerages bullish on Tata Motors even as Q2 loss widens";
      System.out.println(strs[rand.nextInt(5)]);
      System.out.println(strs[rand.nextInt(5)]);
    }
  },
  Nike{
    public void news(){
      Random rand=new Random();
      String[] strs=new String[5];
      strs[0]="Nike Intends to Terminate 700 Headquarters Personnel During Restructuring.";
      strs[1]="Nike sales increases due to health awareness, shares increases";
      strs[2]="Nike will be looking to display strength as it nears its next earnings release.";
      strs[3]="Nike Stock Is Surging. Co-Founder Phil Knight Sold a Large Block of Shares.";
      strs[4]="The Zacks analyst believes that even as stores reopen, NIKE witnesses strong digital trends.";
      System.out.println(strs[rand.nextInt(5)]);
      System.out.println(strs[rand.nextInt(5)]);
    }
  };
  public abstract void news();
}
