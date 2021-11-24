import java.util.ArrayList;

public class Admin extends User {
   static ArrayList<Driver> driversRequest = new ArrayList<>();
    private Tables tables=new Tables();
    private String driverName;

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }
    Admin(){
        setDriverName("");
        setUserName("");
        setPassword("");
    }
    Admin(String userName, String password){
        setUserName(userName);
        setPassword(password);
    }
    @Override
    public void setUserName(String userName) {
        super.setUserName(userName);
    }

    @Override
    public void login() {
        if(tables.isAdmin(getUserName(), getPassword())){
            System.out.println("successfully signed in");
            HomePage.adminDuties();

        }
        else {
            System.out.println("the user is not recognized as admin");
            HomePage.mainMenu();
        }


    }

    @Override
    public void signUp() {
        if(tables.isAdmin(getUserName(), getPassword())){
            System.out.println("account already exist");
            return;
        }
        var admin = new Admin(getUserName(),getPassword());
        tables= new Tables();
        tables.addUserAsAdmin(admin);
        System.out.println("Account registered as Admin");
        HomePage.mainMenu();
    }

    @Override
    public String getUserName() {
        return super.getUserName();
    }

    @Override
    public void setPassword(String password) {
        super.setPassword(password);
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }
    public void pendingDriverRequest(Driver d){
        driversRequest.add(d);
        System.out.println("your request has been received, please wait until your account "
        +"is activated");
        HomePage.mainMenu();

    }
    public void activate(){
        for (int i=0; i<driversRequest.size(); i++) {
            if(getDriverName().matches(driversRequest.get(i).getUserName())) {
                tables.driverTable(driversRequest.get(i));
                driversRequest.remove(driversRequest.get(i));
            }

            System.out.println("driver account successfully activated");


        }

    }
    public void isSuspended(){
        for (int i=0; i<Tables.drivers.size();i++){
            if(getDriverName().equalsIgnoreCase(Tables.drivers.get(i).getUserName())){
                System.out.println(Tables.drivers.get(i).getUserName()+" is suspended");
                tables.removeDriver(Tables.drivers.get(i));
                break;
            }
        }
    }

    public void displayAllPendingRequest(){
        for (int i=0; i<driversRequest.size(); i++)
            System.out.println("Request "+i+"\n"+
                    "username:"+driversRequest.get(i).getUserName()+"\n"+
                    "Email: "+driversRequest.get(i).getEmail()+"\n"+
                    "password: "+driversRequest.get(i).getPassword()+"\n"+
                    "mobile number: "+driversRequest.get(i).getMobileNumber()+"\n"+
                    "driving license: "+driversRequest.get(i).getDrivingLicense()+"\n"+
                    "national ID: "+driversRequest.get(i).getNationalID());
        System.out.println();
    }
    public void displayAllDriver(){
        tables.displayDrivers();
    }
    public void displayAllPassenger(){
        tables.displayAllPassenger();
    }
    public void  removePassenger(){
        tables.displayAllPassenger();
    }
    public void seeAllAdmin(){
        tables.showAdmins();
    }
}
