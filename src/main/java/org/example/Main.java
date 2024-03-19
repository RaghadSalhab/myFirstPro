package org.example;

import Today.edu.*;
import Today.edu.Package;


import java.sql.Time;

import java.util.Date;
import java.util.Scanner;

import static Today.edu.MyAppT.logger;



//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.










public class Main {



    private static Person user=new Person();
    private static ServiceProvider sp=new ServiceProvider();

    static MyAppT obj = new MyAppT();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        menuForMain o=new menuForMain();
        logger.info(o.LogInSignUp());
        int choice = input.nextInt();



        switch (choice) {
            case 1 -> signUpProcedure(input);
            case 2 -> loginProcedure(input);
            case 3-> forgotPass(input);
            default -> logger.info("Invalid option selected.");
        }


    }

    private static void loginProcedure(Scanner input) {
        String name= getInput(input, "Please enter your Name");
        String password = getInput(input, "Please enter your password");
       user= obj.searchInUser(name);
        sp=obj.searchInServiceProvider(name);
        if(!(user==(null))){
            displayUserMenu(input);
        }
       else if(!(sp==(null))){
            displaySpMenu(input);


        }
       else if(name.equals("toqa")&&password.equals("123")){
            displayAdminMenu(input);

        }

    }

















    private static void displaySpMenu(Scanner input) {
        String s="\n1. add a new service\n2. modify an existing service\n3. delete an existing service\n4. view the list of users\n";
        s+="5. view the list of services\n6. exit";
        logger.info(s);
        int choice = input.nextInt();
        switch (choice) {
            case 1:
                logger.info("Enter service id:");
                int id = input.nextInt();
                String description= getInput(input, "Please enter description");
                logger.info("Enter service cost:");
                int cost = input.nextInt();
                obj.addServiceToSp(description,cost,id,sp.getPerson().getUserName());
                break;


            case 2:
                logger.info(obj.showservicesForSp(sp.getPerson().getUserName()));

                logger.info("Enter service id:");
                 id = input.nextInt();
                 description= getInput(input, "Please enter new description");
                logger.info("Enter new cost:");
                 cost = input.nextInt();
                obj.editServiceForSp(description,cost,id,sp.getPerson().getUserName());

                break;
            case 3:
                logger.info(obj.showservicesForSp(sp.getPerson().getUserName()));
                logger.info("Enter service id:");
                id = input.nextInt();
                obj.deleteServiceForSp(id,sp.getPerson().getUserName());
                break;
            case 4:
                logger.info(obj.showUsersAndEventsForSp(sp.getPerson().getUserName()));
                break;
            case 5:
                logger.info(obj.showservicesForSp(sp.getPerson().getUserName()));

                break;
            case 6:
                logger.info("Logging out as Service provider.");
                System.exit(1);
                break;
            default:
                logger.info("Invalid option selected.");

        }
        displaySpMenu( input);
    }

    private static void addServices(Scanner input,int int1,Event event1){
       String s="\n1. FoodService\n2. isDecorService\n3. PhotoService\n4. EnterService\n5. finish\n";
       logger.info(s);
        Integer serviceChoice = input.nextInt();
        String type="";
        String spList="";
        switch (serviceChoice) {
            case 1:
                type="Food";

                break;
            case 2:
                type="Decoration";

                break;
            case 3:
                type="Entertainment";
                break;
            case 4:
                type="Photographer";
                break;
            default:
                //logger.info("locally cost "+ cost);

                logger.info("create event successfully and its price is "+ int1);


        }
        if(serviceChoice!=5){
        spList= obj.searchInSpAccordingToType(type);
        logger.info(spList);
        String spName= getInput(input, "Please enter service Provider Name: ");
        logger.info(obj.showservicesForSp(spName));
        Integer serviceId = input.nextInt();
        obj.setLocalEvent(event1);


      int t= obj.addFoodService(serviceId, type);

        logger.info("Successful addtion");
        String show=obj.ViewEventsByUser(user.getUserName());
        logger.info(show);

        addServices(input,int1,event1);
        }
    }


static int cost;


    private static void location(Scanner input,int year,int month,int day,Time time){

        logger.info("locations: ");
        int temp=0;
        for (Location l : obj.getLocationList()) {

            for (Event e : obj.getEventList()) {


                if (e.getDate().getYear()==year && e.getDate().getMonth()==month && e.getDate().getDate()==day && e.getTime().equals(time)&& e.getLocation().equals(l.getLocationName())) {
                    temp=1;
                    break;
                }
            }
            if(temp==0){
                logger.info(l.getId()+"\t"+l.getLocationName()+"\t"+l.getCost()+"\n");


            }
            else {
                temp=0;
            }

        }
        logger.info("Please enter location ID: ");

    }




    private static void creatBasicEvent(Scanner input){
         cost=0;

        Date date= new Date(2003, 2, 13);
        Time time= new Time(1, 2, 3);
        String eventName= getInput(input, "Please enter event name: ");
        String dates= getInput(input, "Please enter event date(yyyy-MM-dd): ");
        String times= getInput(input, "Please enter event time: ");

        String[] dateComponents = dates.split("-");



           int year = Integer.parseInt(dateComponents[0]);
        int month = Integer.parseInt(dateComponents[1]);
        int day = Integer.parseInt(dateComponents[2]);


        dateComponents = times.split(":");
        int hour = Integer.parseInt(dateComponents[0]);
        int min= Integer.parseInt(dateComponents[1]);
        int sec = Integer.parseInt(dateComponents[2]);
        time = new Time(hour,min,sec);



        location( input, year, month, day, time);
/*
        logger.info("locations: ");
        int temp=0;
        for (Location l : obj.getLocationList()) {

            for (Event e : obj.getEventList()) {


                if (e.getDate().getYear()==year && e.getDate().getMonth()==month && e.getDate().getDate()==day && e.getTime().equals(time)&& e.getLocation().equals(l.getLocationName())) {
                    temp=1;
                    break;
                }
            }
            if(temp==0){
                logger.info(l.getId()+"\t"+l.getLocationName()+"\t"+l.getCost()+"\n");


            }
            else {
                temp=0;
            }

        }
        logger.info("Please enter location ID: ");
        */
        Integer id = input.nextInt();

        String theme= getInput(input, "Please enter theme: ");
        logger.info("Please enter number of attend people: ");
        Integer number = input.nextInt();
        Location L=obj.searchInLocation(id);
        cost+=L.getCost();
        String locationName=L.getLocationName();

        obj.createEventWithBasicInfo(user.getUserName(),eventName,year,month, day, time.getHours(), time.getMinutes(), time.getSeconds(), locationName, theme, number);
        String s="\n1.choose from existing package\n2. choose your own services\n3. exit\n";
        logger.info(s);
        int choice = input.nextInt();
        int PackId;
        switch (choice) {
            case 1:
              String pack= obj.showPackageForAdmin();
              logger.info(pack);
                 PackId = input.nextInt();
                 boolean b=obj.addPackageToEvent(PackId);
                 obj.addLocalEventToEventList();

                Package P;
                P=obj.searchInPackage(PackId);
                logger.info("create event successfully and its price is "+ obj.getLocalEvent().eventCost(cost));

            //    logger.info("Finish successfully it cost: "+cost);
                 String show=obj.ViewEventsByUser(user.getUserName());
                 logger.info(show);
                displayUserMenu(input);
                break;

            case 2:
               addServices(input,obj.getLocalEvent().eventCost(cost),obj.getLocalEvent());
               break;
            case 3:
                logger.info("create event successfully and its price is "+cost);
                //setCost(cost);







        }

    }



    private static void displayUserMenu(Scanner input) {
        String s="\n1.  create an event\n" +
                "2. edit the event\n" +
                "3. delete an existing event\n" +
                "4.  view events\n" +
                "5. exit\n";
        logger.info(s);
        int choice = input.nextInt();
        switch (choice) {
            case 1:
                creatBasicEvent(input);
                break;


            case 2:

               editEvent(input);
                break;
            case 3:
                String show=obj.ViewEventsByUser(user.getUserName());
                logger.info(show+"\n Please enter eventName:\n");
                String EventName= input.next();
                System.out.println("event name to delete: "+EventName+"\n\n");
                obj.DeleteEventByUser(user.getUserName(), EventName);

                break;

            case 4:
                 show=obj.ViewEventsByUser(user.getUserName());
                logger.info(show);

                break;

            case 5:
                loginProcedure(input);
                break;


            default:
                logger.info("Invalid option selected.");
                signUpProcedure(input);
        }
        displayUserMenu( input);




    }

    private static void editEvent(Scanner input) {
        String show=obj.ViewEventsByUser(user.getUserName());
        logger.info(show);
        String eventName= getInput(input, "Please enter Event name: ");


        String s="\n1. edits the event name\n" +
                "2.  changes the event location\n" +
                "3. updates the event date\n" +
                "4. User updates the event time\n" +
                "5.  number of attendees for the event\n" +
                "6. changes the theme of the event\n" +
                "7. adds additional services to the event\n" +
                "8. removes a service from the event\n" +
                "9. cancels the selected package\n" +
                "10. User edit the selected package\n11. exit";
        logger.info(s);
        int choice = input.nextInt();



        switch (choice) {
            case 1:
                String NewEventName= getInput(input, "Please enter Event name: ");

                obj.editEventNameByUser(user.getUserName(),eventName,NewEventName);
                show=obj.ViewEventsByUser(user.getUserName());
                logger.info(show);
                eventName=NewEventName;

                break;

            case 2:
                location( input,  obj.searchInEventByName(eventName).getDate().getYear(), obj.searchInEventByName(eventName).getDate().getMonth(),obj.searchInEventByName(eventName).getDate().getDate(), obj.searchInEventByName(eventName).getTime());
                int locationId = input.nextInt();
                obj.editLocation(user.getUserName(),eventName, locationId);
                show=obj.ViewEventsByUser(user.getUserName());
                logger.info(show);
                break;
            case 3:
                String dates= getInput(input, "Please enter event date(yyyy-MM-dd): ");

                String[] dateComponents = dates.split("-");

                int year = Integer.parseInt(dateComponents[0]);
                int month = Integer.parseInt(dateComponents[1]);
                int day = Integer.parseInt(dateComponents[2]);

               int temp=0;

                    for (Event e : obj.getEventList()) {

                        if (e.getDate().getYear()==year && e.getDate().getMonth()==month && e.getDate().getDate()==day && e.getTime().equals(obj.searchInEventByName(eventName).getTime()) && e.getLocation().equals(obj.searchInEventByName(eventName).getLocation())) {
                            logger.info("you cant choose this date because location is booked to another event\n" );
                            temp=1;
                            editEvent(input);
                            break;
                        }
                    }
                    if(temp==0){
                       obj.editEventDateByUser(user.getUserName(), eventName,year, month, day);

                    }

                show=obj.ViewEventsByUser(user.getUserName());
                logger.info(show);

                break;

            case 4:
                String times= getInput(input, "Please enter event time: ");

                dateComponents = times.split(":");
                int hour = Integer.parseInt(dateComponents[0]);
                int min= Integer.parseInt(dateComponents[1]);
                int sec = Integer.parseInt(dateComponents[2]);
                Time time = new Time(hour,min,sec);

                 temp=0;

                for (Event e : obj.getEventList()) {


                    if (e.getDate().getYear()==obj.searchInEventByName(eventName).getDate().getYear() && e.getDate().getMonth()==obj.searchInEventByName(eventName).getDate().getMonth() && e.getDate().getDate()== obj.searchInEventByName(eventName).getDate().getDate() && e.getTime().equals(time)&& e.getLocation().equals(obj.searchInEventByName(eventName).getLocation())) {
                        logger.info("you cant choose this time because location is booked to another event\n" );
                        temp=1;
                        editEvent(input);
                        break;
                    }
                }
                if(temp==0){
                    obj.editEventTimeByUser(user.getUserName(), eventName, hour, min, sec) ;
                }
                show=obj.ViewEventsByUser(user.getUserName());
                logger.info(show);
                break;

            case 5:
                logger.info("number of attendees for the event ");
                int num = input.nextInt();
                obj.editEventNumOfPeapleByUser(user.getUserName(), eventName, num);
                show=obj.ViewEventsByUser(user.getUserName());
                logger.info(show);
                break;

            case 6:
                String theme= getInput(input, "Please enter Event new theme: ");
                obj.editEventThemeByUser(user.getUserName(), eventName, theme);
                show=obj.ViewEventsByUser(user.getUserName());
                logger.info(show);
                break;
            case 7:
                addServices( input,obj.searchInEventByName(eventName).getOverallCost(),obj.searchInEventByName(eventName));
                show=obj.ViewEventsByUser(user.getUserName());
                logger.info(show);
            case 8:
                s="";
                if(obj.searchInEventByName(eventName).getFoodService()!=null){
                    s+=obj.searchInEventByName(eventName).getFoodService().getId()+"\t"+obj.searchInEventByName(eventName).getFoodService().getDiscription()+"\n";
                }




                if(obj.searchInEventByName(eventName).getDecorService()!=null){
                    s+=obj.searchInEventByName(eventName).getDecorService().getId()+"\t"+obj.searchInEventByName(eventName).getDecorService().getDiscription()+"\n";
                }



                if(obj.searchInEventByName(eventName).getEntertainmentService()!=null){
                    s+=obj.searchInEventByName(eventName).getEntertainmentService().getId()+"\t"+obj.searchInEventByName(eventName).getEntertainmentService().getDiscription()+"\n";
                }

                if(obj.searchInEventByName(eventName).getPhotographerService()!=null){
                    s+=obj.searchInEventByName(eventName).getPhotographerService().getId()+"\t"+obj.searchInEventByName(eventName).getPhotographerService().getDiscription()+"\n";
                }

                logger.info(s);
                Integer serviceToDelete = input.nextInt();
                obj.editDeleteServiceFromEventByUser(user.getUserName(), eventName, serviceToDelete);
                break;
            case 9:
                obj.editDeletePackageFromEventByUser(user.getUserName(), eventName);
                break;
            case 10:
                String pack= obj.showPackageForAdmin();
                logger.info(pack);
               int  PackId = input.nextInt();
               obj.setLocalEvent(obj.searchInEventByName(eventName));
                boolean b=obj.addPackageToEvent(PackId);

                logger.info("create event successfully and its price is "+ obj.getLocalEvent().eventCost(cost));
                break;


            default:
                logger.info("Invalid option selected.");
                signUpProcedure(input);
        }
        editEvent( input);
    }

    private static void displayAdminMenu(Scanner input) {
        String s="\n1. view list of all registered users\n2. view list of all service providers\n3. view list of all event\n4. create a new ready-made package\n";
        s+="5. deletes an existing ready-made package\n6. view list of all packages\n7. exit";
        logger.info(s);
        int choice = input.nextInt();
        switch (choice) {
            case 1:
                logger.info(obj.showUserListForAdmin());

                break;


            case 2:
                logger.info(obj.showSPtForAdmin());

                break;
            case 3:
                logger.info(obj.showEventForAdmin());break;
            case 4:
                logger.info("Please enter package ID: ");
                Integer id = input.nextInt();
                String description= getInput(input, "Please enter package description: ");
                logger.info("Please enter package cost: ");
                Double cost = input.nextDouble();
                obj.createPackage(description,cost,id);break;
            case 5:
                logger.info(obj.showPackageForAdmin());
                logger.info("Please enter package ID: ");
                 id = input.nextInt();
                obj.deletePackage(id);
                break;
            case 6:
                logger.info(obj.showPackageForAdmin());break;
            case 7:
                logger.info("Logging out as Admin.");
                System.exit(1);

            default:
                logger.info("Invalid option selected.");
                signUpProcedure(input);
        }
        displayAdminMenu( input);
    }

    private static void forgotPass(Scanner input) {
        String name = getInput(input, "Enter the name for your account");
        String pass = getInput(input, "Enter the new password for your account");
        obj.setEnteredUsername(name);
        obj.takePass(pass);
        logger.info("successfully Update");
    }

    private static void signUpProcedure(Scanner input) {
        logger.info("\n1.Service provider \n2.User\n Enter the Number:");
        int choice = input.nextInt();


        switch (choice) {
            case 1 :
                logger.info("\nIn order to make a new account you have to enter your information\n");
                String name= getInput(input, "Please enter your Name");
                String phone= getInput(input, "Please enter your phone");
                String email = getInput(input, "Please enter your Gmail");
                String password = getInput(input, "Please enter your password");
                String birthDate = getInput(input, "Please enter your BirthDate");
                String type= getInput(input, "\nPlease enter your type(Food,Decoration,Entertainment,Photographer)-->");
                obj.createAccountForSp(name,password,birthDate,phone,type,email);
                break;


            case 2 :
                logger.info("\nIn order to make a new account you have to enter your information\n");
                 name= getInput(input, "Please enter your Name");
                 phone= getInput(input, "Please enter your phone");
                 email = getInput(input, "Please enter your Gmail");
                 password = getInput(input, "Please enter your password");
                 birthDate = getInput(input, "Please enter your BirthDate");
                obj.createAccountForUser(name,password,birthDate,phone,email);
                break;
            default :
                logger.info("Invalid option selected.");
                signUpProcedure(input);

        }



    }




    private static String getInput(Scanner input, String prompt) {
        logger.info(prompt);
        return input.next();
    }

}