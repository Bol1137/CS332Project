import java.util.ArrayList;

public class Rating {
   static ArrayList<Double>rating=new ArrayList<>();
    double sum=0;
    double averageRate;
    public void addRating(double rate){
        rating.add(rate);
    }
    public void listOfUserRating(){
        for (int i = 0; i < rating.size(); i++) {
            System.out.println(rating.get(i));

        }
    }
    public void averageRating(){
        for (int i = 0; i < rating.size(); i++) {
            sum=sum+rating.get(i);
        }
        averageRate=sum/rating.size();
        if(averageRate>=1.0 && averageRate<2.0 )
            System.out.println("*.... "+ averageRate + " worst");
        else if(averageRate>=2.0 && averageRate<3.0)
            System.out.println("**... "+ averageRate + " fair");
        else if(averageRate>=3.0 && averageRate<4.0)
            System.out.println("***.. "+ averageRate + " good");
        else if(averageRate>=4.0 && averageRate<5.0)
            System.out.println("****. "+ averageRate + " better");
        else if(averageRate>=5)
            System.out.println("***** "+ averageRate + " best");
        else
            System.out.println("this driver is not rating");
    }
}
