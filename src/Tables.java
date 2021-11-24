
import java.util.*;

public class Tables {
    static ArrayList<Passenger> passengers = new ArrayList<>();
    static ArrayList<Driver> drivers = new ArrayList<>();
    static ArrayList<Admin> admins = new ArrayList<>();

    public void addPassengerAccount(Passenger p) {
        passengers.add(p);
    }

    public void displayAllPassenger() {
        for (int i = 0; i < passengers.size(); i++) {
            System.out.println("passenger " + i + "\n" + "Username: " + passengers.get(i) + "\n" +
                    "Email: " + passengers.get(i).getEmail() + "\n" +
                    "Password: " + passengers.get(i).getPassword() + "\n" +
                    "Mobile Number: " + passengers.get(i).getMobileNumber());
        }
    }

    public void deletePassengerAccount(Passenger p) {
        for (int i = 0; i < passengers.size(); i++) {
            if (p == passengers.get(i))
                passengers.remove(p);
            else
                System.out.println("can't delete unexisting account");
        }

    }

    public boolean isRegistered(String userName, String password) {
        boolean isValidAccount = false;
        System.out.println(drivers.size());
        for (int i = 0; i < passengers.size(); i++) {
            if (userName.matches(passengers.get(i).getUserName()) && password.matches(passengers.get(i).getPassword()))
                isValidAccount = true;
        }
        return isValidAccount;
    }



    public void driverTable(Driver d){
        drivers.add(d);
    }
    public boolean isActivated(String userName, String password){
       boolean confirm = false;
        for (int i = 0; i < drivers.size() ; i++) {
            if(userName.matches(drivers.get(i).getUserName())&&password.matches(drivers.get(i).getPassword()))
                confirm=true;
        }
        return confirm;
    }
    public void displayDrivers(){
        for(int i =0; i< drivers.size(); i++){
            System.out.println("Driver "+ i + "Username: "+drivers.get(i).getUserName()+"\n" +
                    "Email: "+ drivers.get(i).getEmail()+"\n"+
                    "Password: "+ drivers.get(i)+"\n" +
                    "Mobile Number: "+drivers.get(i).getMobileNumber() + "\n"+
                    "Driving License: "+ drivers.get(i).getDrivingLicense()+"\n"+
                    "National ID"+ drivers.get(i).getNationalID());
        }
    }
    public void addUserAsAdmin(Admin admin){
        admins.add(admin);

    }
    public void showAdmins(){
        for(int i=0; i< admins.size(); i++){
            System.out.println("Admin: "+ i +"\n"+ "Name: "+admins.get(i).getUserName() + "\n"+
                    "Password: "+admins.get(i).getPassword());
        }
    }
    public boolean isAdmin(String userName, String password) {
        boolean isAdminUser=false;
        for (int i = 0; i < admins.size(); i++) {
            if(userName.matches(admins.get(i).getUserName())&&password.matches(admins.get(i).getPassword()))
                isAdminUser=true;
            else
                isAdminUser=false;

        }
        return isAdminUser;
    }
    public void removeDriver(Driver d){
        drivers.remove(d);
    }
}
