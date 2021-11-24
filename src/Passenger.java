import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Passenger extends User{
    private String source;
    private String destination;
    Area area = new Area();
    Tables t = new Tables();
    Rating rating = new Rating();

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    Passenger(){
        setUserName("");
        setPassword("");
        setEmail("");

    }
    Passenger(String userName, String email,String password, int mobileNumber){
        setUserName(userName);
        setPassword(password);
        setEmail(email);
        setMobileNumber(mobileNumber);
    }
    @Override
    public void setUserName(String userName) {
        super.setUserName(userName);
    }
    @Override
    public String getUserName() {
        return super.getUserName();
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public void setPassword(String password) {
        super.setPassword(password);
    }

    @Override
    public void setEmail(String email) {
        super.setEmail(email);
    }

    @Override
    public String getEmail() {
        return super.getEmail();
    }

    @Override
    public void setMobileNumber(int mobileNumber) {
        super.setMobileNumber(mobileNumber);
    }

    @Override
    public int getMobileNumber() {
        return super.getMobileNumber();
    }

    @Override
    public void login() {
        if(t.isRegistered(getUserName(),getPassword())){
            System.out.println("successfully login");
            HomePage.passengerDuties();
        }else{
            System.out.println("wrong username or password");
            HomePage.logInAs();
        }



    }

    @Override
    public void signUp() {
        if(t.isRegistered(getUserName(),getPassword())){
            System.out.println("Account already exist");
        }

        t.addPassengerAccount(this);
        System.out.println("congratulation registration completed !!!");

    }
    public void confirmOffer(int ubberfare){
        System.out.println(" you will pay "+ubberfare+"L.E for the ride");
        Scanner scanner = new Scanner(System.in);
        System.out.println("click \n"+"1. confirm \n"+"2. reject");
        String choice = scanner.next();
        double rate;
        while (true){
            if(choice.equalsIgnoreCase("1")){
                System.out.println("thanks, I will be there in a minute");
                System.out.println("do you want to rate this driver? \n"+
                "1. yes \n"+"2. no \n");
                String c;
                c=scanner.next();
                if(c.equalsIgnoreCase("1")){
                    System.out.println("enter rate");
                    while(!(scanner.hasNextInt())){
                        System.out.println("please enter number");
                        scanner.next();
                    }
                    rate= scanner.nextDouble();
                    addRating(rate);
                }else{
                    break;
                }

                break;
            }
            else if(choice.equalsIgnoreCase("2"))
                break;
            else
                System.out.println("choose appropriate number from above");
        }

    }

    public void showAverageDriverRating(){
        rating.averageRating();
    }
    public void addRating(double rate){
        rating.addRating(rate);

    }
}
