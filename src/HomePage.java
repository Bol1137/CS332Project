import java.util.Scanner;

public class HomePage {
    public static void main(String []args){
        System.out.println("-----------------------------------------");
        System.out.println("-------"+"WELCOME TO BOOKING RIDE "+"-------");
        System.out.println("enjoy safe and beautiful ride");
        System.out.println();
        mainMenu();
    }
    public static void mainMenu(){
        int choice;
        Scanner scan = new Scanner(System.in);
        System.out.println("enter a number of your choice");
        System.out.println("1. SignUp \n"+"2. Login \n"+"3. Exit");
        while(!(scan.hasNextInt())){
            System.out.println("please choose appropriate choice");
            scan.next();
        }
        choice=scan.nextInt();
        switch(choice){
            case 1:
                signUpAs();
                break;
            case 2:
                logInAs();
                break;
            case 3:
                System.exit(1);
                break;
            default:
                System.out.println("choose a action number");
                mainMenu();
        }
    }
    public static void signUpAs(){
        String userName;
        String password;
        int mobileNumber;
        String email;
        String drivingLicense;
        String nationalID;
        System.out.println("sign Up as :");
        int choice;
        Scanner scan = new Scanner(System.in);
        System.out.println("1. Passenger \n"+"2. Driver \n"+"3. Admin \n"+
                "4. back to Home page\n"+"5. Exit");
        while(!(scan.hasNextInt())){
            System.out.println("please enter appropriate choice");
            scan.next();
        }
        choice = scan.nextInt();
        switch (choice){
            case 1:
                System.out.println("Enter your user name");
                userName=scan.next();
                System.out.println("Enter your email");
                email= scan.next();
                System.out.println("Enter your password");
                password=scan.next();
                System.out.println("Enter your mobile number");
                while(!(scan.hasNextInt())){
                    System.out.println("please enter numbers only for mobile number");
                    scan.next();
                }
                mobileNumber= scan.nextInt();
               var passenger=new Passenger(userName,email,password,mobileNumber);
                passenger.signUp();
                mainMenu();
                break;
            case 2:
                System.out.println("Enter your user name");
                userName=scan.next();
                System.out.println("Enter your email");
                email= scan.next();
                System.out.println("Enter your password");
                password=scan.next();
                System.out.println("Enter your mobile number");
                while (!(scan.hasNextInt())){
                    System.out.println("please enter numbers only for mobile number");
                    scan.next();
                }
                mobileNumber=scan.nextInt();

                System.out.println("Enter Driving License");
                drivingLicense=scan.next();
                System.out.println("Enter National ID");
                nationalID= scan.next();
                var driver = new Driver(userName,email,password,mobileNumber,drivingLicense,nationalID);
                driver.signUp();
                mainMenu();
                break;
            case 3:
                System.out.println("Enter your user name");
                userName=scan.next();
                System.out.println("Enter your password");
                password=scan.next();
                var admin = new Admin(userName,password);
                admin.signUp();
                mainMenu();
                break;
            case 4:
                mainMenu();
                break;
            case 5:
                System.exit(1);
                break;
            default:
                System.out.println("please choose a valid number");
                signUpAs();
                break;

        }
    }

    public static void logInAs(){
        String userName;
        String password;
        int choice;
        System.out.println("log in as\n"+"1. passenger\n"+"2. driver\n"+"3. admin\n"+
                "4. back to home page\n"+"5. exit");
        Scanner scan = new Scanner(System.in);
        while(!(scan.hasNextInt())){
            System.out.println("please enter numbers only for mobile number");
            scan.next();
        }
        choice= scan.nextInt();
        switch (choice){
            case 1:
                System.out.println("Enter username");
                userName = scan.next();
                System.out.println("Enter password");
                password=scan.next();
                var passenger = new Passenger();
                passenger.setUserName(userName);
                passenger.setPassword(password);
                passenger.login();
                break;
            case 2:
                System.out.println("Enter username");
                userName = scan.next();
                System.out.println("Enter password");
                password=scan.next();
                var driving = new Driver();
                driving.setUserName(userName);
                driving.setPassword(password);
                driving.login();
                break;
            case 3:
                System.out.println("Enter username");
                userName = scan.next();
                System.out.println("Enter password");
                password=scan.next();
                var admin= new Admin();
                admin.setUserName(userName);
                admin.setPassword(password);
                admin.login();
                break;
            case 4:
                mainMenu();
                break;
            case 5:
                System.exit(1);
                break;
            default:
                System.out.println("choose appropriate choice");
                logInAs();
                break;
        }

    }
    public static void adminDuties(){
        Scanner scanner = new Scanner(System.in);
        int choice;
        String userName;
        var admin = new Admin();
        System.out.println("1. display all pending drivers request\n"+
                "2. verify driver account\n"+"3. see all drivers\n"+
                "4. see all passengers\n"+"5. remove driver\n"+"6. remove passenger\n"+
                "7. suspend driver account\n"+
                "8. back to home\n"+"5. exit");
        while(!(scanner.hasNextInt())){
            System.out.println("please enter appropriate choice");
            scanner.next();
        }
        choice= scanner.nextInt();
        switch (choice){
            case 1:
                admin.displayAllPendingRequest();
                adminDuties();
                break;
            case 2:
                System.out.println("Enter driver user name");
                userName=scanner.next();
                admin.setDriverName(userName);
                admin.activate();
                adminDuties();
                break;
            case 3:
                admin.displayAllDriver();
                adminDuties();
                break;
            case 4:
                admin.displayAllPassenger();
                adminDuties();
                break;
            case 5:
                adminDuties();
                break;
            case 6:
                admin.getUserName();
                adminDuties();
                break;
            case 7:
                System.out.println("Enter driver user name");
                userName=scanner.next();
                admin.setDriverName(userName);
                admin.isSuspended();
                adminDuties();
            case 8:
                mainMenu();
                break;
            case 9:
                System.exit(1);
            default:
                System.out.println("enter appropriate choice");
                adminDuties();
                break;
        }
    }
    public static void passengerDuties(){
        String source;
        String destination;
        int choice;
        var passenger= new Passenger();
        System.out.println("1. request a ride \n"+"2. see driver average rating \n"+"" +
                "3. back to log in page\n"+
                "4. back to home page\n"+"5. exit");
        Scanner scanner= new Scanner(System.in);
        while(!(scanner.hasNextInt())){
            System.out.println("please enter appropriate choice");
            scanner.next();
        }
        choice = scanner.nextInt();
        switch (choice){
            case 1:
                System.out.println("enter your source area");
                source=scanner.next();
                System.out.println("enter your destination");
                destination=scanner.next();
                passenger.setSource(source);
                passenger.setDestination(destination);
                var area = new Area();
                area.setSource(passenger.getSource());
                area.setSource(passenger.getDestination());
                mainMenu();
                break;
            case 2:
                passenger.showAverageDriverRating();
                break;
            case 3:
                logInAs();
                break;
            case 4:
                mainMenu();
                break;
            case 5:
                System.exit(1);
                break;
            default:
                System.out.println("select appropriate choice");
                passengerDuties();
        }

    }
    public static void driverDuties(){
        int choice;
        String source;
        var driver = new Driver();
        System.out.println("1. add favorite Area\n"+
                "2. see all user rating\n"+"3. back to log in page\n"+"4. back to home page\n"+"5. exit");
        Scanner scanner= new Scanner(System.in);
        while(!(scanner.hasNextInt())){
            System.out.println("please enter appropriate choice");
            scanner.next();
        }
        choice = scanner.nextInt();
        switch (choice){
            case 1:
                System.out.println("add your favorite area");
                source=scanner.next();
                driver.addFavoriteAreas(source);
                driverDuties();
                break;
            case 2:
                driver.seeAllUserRating();
                logInAs();
                break;
            case 3:
                logInAs();
                break;
            case 4:
                mainMenu();
                break;
            case 5:
                System.exit(1);
                break;
            default:
                System.out.println("enter appropriate choice");
                driverDuties();
                break;
        }

    }
}
