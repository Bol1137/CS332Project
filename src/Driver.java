import java.util.ArrayList;
import java.util.Scanner;

public class Driver extends User {
    private String nationalID;
    private String drivingLicense;
    private Admin sendRequest=new Admin();
    private static ArrayList<String>favoriteAreas=new ArrayList<>();
    Tables t = new Tables();
    Area area = new Area();
    Rating rating= new Rating();

    Driver(){
        setDrivingLicense("");
        setEmail("");
        setMobileNumber(0);
        setEmail("");
        setNationalID("");
        setPassword("");
    }
    Driver(String userName, String email, String password, int mobileNumber, String drivingLicense, String nationalID){
        setUserName(userName);
        setEmail(email);
        setPassword(password);
        setMobileNumber(mobileNumber);
        setDrivingLicense(drivingLicense);
        setNationalID(nationalID);
    }

    public String getDrivingLicense() {
        return drivingLicense;
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
    public void setUserName(String userName) {
        super.setUserName(userName);
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
    public int getMobileNumber() {
        return super.getMobileNumber();
    }

    @Override
    public void setMobileNumber(int mobileNumber) {
        super.setMobileNumber(mobileNumber);
    }

    public void setDrivingLicense(String drivingLicense) {
        this.drivingLicense = drivingLicense;
    }

    public String getNationalID() {
        return nationalID;
    }

    public void setNationalID(String nationalID) {
        this.nationalID = nationalID;
    }


    @Override
    public void login() {
        if(t.isActivated(getUserName(),getPassword())){
            System.out.println("successfully login");
            System.out.println();
        }else{
            System.out.println("account may not be activated or suspended, " +
                        "please contact your admin");
            System.out.println();
            HomePage.logInAs();
            }
        HomePage.driverDuties();

    }

    @Override
    public void signUp() {
        Driver d= new Driver(getUserName(), getEmail(),
                getPassword(),getMobileNumber()
                ,getDrivingLicense(), getNationalID());
        sendRequest.pendingDriverRequest(d);

    }

    public void addFavoriteAreas(String source){
        favoriteAreas.add(source);

    }
    public void getNotified(String myFavoriteArea){
        String choice;
        Scanner scanner = new Scanner(System.in);
        for (int i=0; i<favoriteAreas.size(); i++){
            if(myFavoriteArea.matches(favoriteAreas.get(i))){
                System.out.println(Tables.drivers.get(i).getUserName()+" you have new ride request");
                System.out.println("press \n"+"1. to send offer \n"+"2. to reject");
                choice=scanner.next();
                while (true){
                    if (choice.equalsIgnoreCase(choice)){
                        sendOffer();
                        break;
                    }else if(choice.equalsIgnoreCase(choice)){
                        System.out.println("passenger rejected!!");
                        break;
                    }else {
                        System.out.println("enter appropriate choice");
                    }
                }


            }
        }
    }
    public void sendOffer(){
        int offer;
        System.out.println("please suggest offer");
        Scanner scanner = new Scanner(System.in);
        while(!(scanner.hasNextInt())){
            System.out.println("please enter valid figure");
            scanner.next();
        }
        offer= scanner.nextInt();
        System.out.print("suggest that");
        area.forwardOffer(offer);
    }
    public void seeAllUserRating(){
        rating.listOfUserRating();
    }
}