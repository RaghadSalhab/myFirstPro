package Today.edu;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;


public class MyAppT {
public static int num=0;
     private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private boolean isEventDeleteEventEdit,isEventViewEventsEdit,isEventCancelPackageEdit,isEventRemoveServiceEdit,isEventThemeEdit;
    private boolean isEventNumOfPeopleEdit,isEventTimeEdit,isEventDateEdit;
    private boolean adminMenuFlag;
    private boolean isDeletePackage;
    private boolean isCreatePackage;
    private boolean isSeeEventList;
    private boolean isSeeUserList;
    private boolean showUserListForAdminFlag;
    private boolean showEventForAdminFlag;
    private boolean isSeeSPList;
    private boolean showSPtForAdminFlag;
    private boolean createPackageFlag;
    private boolean deletePackageFlag;
    private boolean showPackageForAdminFlag;
    private boolean isEventNameEdit;
    private boolean isEventLocationEdit;
    private boolean isEventAdditionalServiceEdit;
    private boolean editEventNameByUserFlag;
    private boolean editEventDateByUserFlag;
    private boolean editEventTimeByUserFlag;
    private boolean editEventNumOfPeapleByUserFlag;
    private boolean editEventThemeByUserFlag;
    private boolean editToAddAdditionalServiceByUserFlag;
    private boolean editDeleteServiceFromEventByUserFlag;
    private boolean editDeletePackageFromEventByUserFlag;
    private boolean ViewEventsByUserFlag;
    private boolean DeleteEventByUserFlag;
    private boolean editLocationFlag;
    private boolean editPackageFlag;


    public Event getLocalEvent() {
        return localEvent;
    }

    public void setLocalEvent(Event localEvent) {
        this.localEvent = localEvent;
    }

    public MyAppT() {


        Person u1 = new Person("haya", "123", "7\3\2004", "0599222333","raghadsalhab13@gmail.com");
        addUser(u1);
        Person u2 = new Person("s12112499@stu.najah.edu", "1234", "7\3\2004", "0594507933","raghadsalhab13@gmail.com");
        addUser(u2);
        Time t1 = new Time(5, 0, 0);
        java.sql.Date d1 = new java.sql.Date(2024 - 3 - 25);
        Event e1 = new Event("Laila's Birthday", d1, t1, "home", "unicorn", 20);
        Event e2 = new Event("omar's birthday", d1, t1, "home", "unicorn", 20);
        Location l1=new Location(1,0,"home","in my home free");
        Location l2=new Location(2,100,"ajaa resturent","150 peaple");

        addEvent(e1);
        addEvent(e2);
        Time t = new Time(8, 0, 0);
       d = new Date(2024, 2, 29);


        Event localEvent = new Event("asmaa", d, t, "home", "frozen", 25);
        addEvent(localEvent);
        Person u4 = new Person("ahmad", "1234", "7\3\2004", "0594507933","raghadsalhab13@gmail.com");
        Person u3 = new Person("salma", "1234", "7\3\2004", "0594507933","raghadsalhab13@gmail.com");
        Person PforLogin = new Person("adam", "54321", "7\3\2004", "0594507933","raghadsalhab13@gmail.com");
        Person SpLogin = new Person("eman", "54321", "7\3\2004", "0594507933","eman@gmail.com");
        Person u7 = new Person("ali", "1234", "7\3\2004", "0594507933","raghadsalhab13@gmail.com");
        Person u8 = new Person("tala", "1234", "7\3\2004", "0594507933","raghadsalhab13@gmail.com");

        ServiceProvider eman = new ServiceProvider(SpLogin, "Photographer");
        addServiceProvider(eman);
        addUser(PforLogin);
        addUser(u3);
        addUser(u4);
        u3.getEventList().add(e2);
        ServiceProvider raghad = new ServiceProvider(u8, "Photographer");
        ServiceProvider mira = new ServiceProvider(u1, "Food");
        ServiceProvider asma = new ServiceProvider(u2, "Entertainment");
        ServiceProvider lama = new ServiceProvider(u7, "Decoration");
        addServiceProvider(raghad);
        addServiceProvider(mira);
        addServiceProvider(asma);
        addServiceProvider(lama);


        Service f1 = new Service("cake", 1, 50, mira);
        Service f2 = new Service("flower", 3, 50, lama);
        Service f3 = new Service("photo", 4, 50, raghad);
        Service f4 = new Service("clone", 2, 50, asma);
        lama.addService(f2);
        mira.addService(f1);
        raghad.addService(f3);
        asma.addService(f4);
        e2.setEntertainmentService(f4);
       // e2.setDecorService(f2);

        Package p = new Package("food+photo", 1000.00,1);
        addPackage(p);
        Package p2 = new Package("food+photo+cake", 100.00,2);
        addPackage(p2);
        Person admin=new Person("Fatina","1234","7\3\2004","0598123123");
        Person abd=new Person("abd","1234","7\3\2004","0598123123");
        Event e3 = new Event("abd's Birthday", d1, t1, "home", "unicorn", 20);
        e3.setPack(p2);
        abd.addUserEvent(e3);
        up.add(abd);
        Person p5=new Person("mira","1234","7\3\2004","0598123123");
        addUser(p5);
        Event e5 = new Event("mira's Birthday", d1, t1, "home", "unicorn", 20);
        asma.addEvent(e5);
        e5.setUser(p5);
        e5.setPhotographerService(f4);
p5.addUserEvent(e5);
up.add(p5);
eventList.add(e5);
eventList.add(e3);
Location k1=new Location(1,100,"Resturant","50 people");
Location k2=new Location(2,100,"Park","70 people");
locationList.add(k1);
locationList.add(k2);
        Person pForDelete=new Person("rawand","1234","7\3\2004","0598123123");
        addUser(pForDelete);
        Event e6 = new Event("rawand's Birthday", d1, t1, "home", "unicorn", 20);
        e6.setUser(pForDelete);
        e6.setPhotographerService(f4);
        pForDelete.addUserEvent(e6);


    }

    private boolean editServiceForSpFlag;
    private boolean providerhasservice;
    private boolean showservicesForSpFlag;
    private boolean isEditService;
    private boolean isDeleteService;
    private boolean showUsersAndEventsForSpFlag;
    private boolean serviceaddedsucc;
    private boolean isShoweventsAnduser;
    private boolean deleteServiceForSpFlag;
    private boolean isShowService;
    private boolean serviceproviderMenuFlag;
    private boolean isAddService;
    private boolean isAdminFlag;
    private boolean isUserFlag;
    private boolean eventfoundflag;
    private boolean isServiceProviderFlag;
    private boolean userhasevent;
    private boolean serviceOrPackage;
    private boolean serviceMenuFlag;
    private boolean isPackageFlag;
    private boolean isServiceFlag;
    private boolean isDecorService;
    private boolean isFoodService;
    private boolean isPhotoService;
    private boolean isEnterService;
    private boolean addLocalEventFoodFlag;
    private boolean addLocalEventDecorFlag;
    private boolean addLocalEventEnterFlag;
    private boolean addLocalEventPhotoFlag;

    private boolean addPackageFlag;


    private boolean isLogged;
    private boolean localEventFlag = false;
    private boolean inUserPage = false;
    private boolean isInCreationPage;
    private boolean validation;
    Time t = new Time(8, 0, 0);
    Date d = new Date(2024, 2, 29);
    private Event localEvent = new Event("asmaa", d, t, "home", "frozen", 25);


    private List<Person> up = new ArrayList<>();
    private List<ServiceProvider> providerList = new ArrayList<>();

    private List<Event> eventList = new ArrayList<>();

    public List<Event> getEventList() {
        return eventList;
    }

    private List<Package> packageList = new ArrayList<>();
    private List<Location>locationList=new ArrayList<>();

    public List<Location> getLocationList() {
        return locationList;
    }

    public void addUser(Person user) {
        up.add(user);
    }

    public void addEvent(Event e) {
        eventList.add(e);
    }

    public void addServiceProvider(ServiceProvider user) {
        providerList.add(user);
    }

    public void addPackage(Package pack) {
        packageList.add(pack);
    }

    public static final Logger logger = Logger.getLogger(MyAppT.class.getName());

    public void setLogged(boolean isLogged) {
        this.isLogged = isLogged;
    }

    public boolean getValidation() {
        return validation;
    }


    public void setUsernameAndPassAndPassFromSystem(String name, String pass) {

        for (Person u : up) {

            if (name.equals(u.getUserName()) && u.getPass().equals(pass)) {
                validation = true;

                logger.info("hi");
                break;

            }
        }
    }

    public void setInvalidUsernameAndPass(String name, String pass) {
        // Write code here that turns the phrase above into concrete actions
        validation = false;
        for (Person u : up) {
            if (name.equals(u.getUserName()) && u.getPass().equals(pass)) {
                logger.info("hiu");
                validation = true;
                break;
            }
        }
    }

    public void setValidUsernameAndInvalidPass(String name, String pass) {
        validation = false;
        for (Person u : up) {
            if (name.equals(u.getUserName()) && u.getPass().equals(pass)) {
                logger.info("hip");
                validation = true;
                break;
            }
        }
    }

    public void searchUser(){

    }


    public void setEmptyUsernameAndPass(String name, String pass) {
        if (name.isEmpty() && !pass.isEmpty())
            validation = false;
    }

    public void setValidUsernameAndEmptyPass(String name, String pass) {
        if (pass.isEmpty() && !name.isEmpty())
            validation = false;
    }

    public boolean isEditPackageFlag() {
        return editPackageFlag;
    }

    public void iAmNotInSystem(MyAppT obj) {
        obj.isLogged = false;
    }


    private boolean forget = false;

    public void setForget(boolean forget) {
        this.forget = forget;
    }

    public boolean getForget() {
        return forget;
    }

    private String enteredUsername;

    public String getEnteredUsername() {
        return enteredUsername;
    }

    private boolean passwordUpdated = false;

    public boolean getPasswordUpdated() {
        return passwordUpdated;
    }

    private boolean userCreated = false;

    public boolean getUserCreated() {
        return userCreated;
    }

    public void validUserPass(String userName, String pass) {
        setForget(false);
        for (Person u : up) {
            if (userName.equals(u.getUserName()) && pass.equals("Forget")) {
                setForget(true);
                enteredUsername = userName;
                break;

            }
        }
    }

    public void createAcc(String enteredUsernam, String enteredPasswor) {
        for (Person user : up) {
            if (user.getUserName().equals(enteredUsernam) && user.getPass().equals(enteredPasswor)) {
                userCreated = true;
                break;
            }

        }

        for (ServiceProvider user : providerList) {
            if (user.getPerson().getUserName().equals(enteredUsernam) && user.getPerson().getPass().equals(enteredPasswor)) {
                userCreated = true;
                break;
            }
        }
    }

    public void takePass(String newPass) {
        for (Person user : up) {

            if (user.getUserName().equals(enteredUsername)) {
                user.setPass(newPass);
                passwordUpdated = true;
                System.out.println(user.getPass());
            }
        }
        for (ServiceProvider sp : providerList) {

            if (sp.getPerson().getUserName().equals(enteredUsername)) {
                sp.getPerson().setPass(newPass);
                System.out.println( sp.getPerson().getPass());
                passwordUpdated = true;
            }

        }



    }
    public void setEnteredUsername(String s){

        enteredUsername=s;
    }

    public void iAmNotINCreationPage(MyAppT obj) {
        isInCreationPage = false;
    }

    public void chooseFromUserPage(Integer int1) {
        switch (int1) {
            case 1:
                isInCreationPage = true;
                break;

        }

    }

    public boolean checkPastDate(Integer int1, Integer int2, Integer int3) {
        LocalDate d = LocalDate.of(int1, int2, int3);


        LocalDate currentDate = LocalDate.now();
        if (d.isBefore(currentDate))
            return true;
        else
            return false;


    }

    public boolean isInCreationPage() {
        return isInCreationPage;
    }

    public void setInCreationPage(boolean inCreationPage) {
        isInCreationPage = inCreationPage;
    }

    public void iAmInUserPage(MyAppT obj) {
        inUserPage = true;
    }

    public void iAmINCreationPage(MyAppT obj) {
        isInCreationPage = true;
    }

    public void createEventWithBasicInfo(String s, String string, Integer int4, Integer int5, Integer int6, Integer int1, Integer int2, Integer int3, String string2, String string3, Integer int7) {
        Person n = searchInUser(s);
   Date date=new Date(int4,int5,int6);
        Time t = new Time(int1, int2, int3);


int temp=0;


        for (Event e : eventList) {
            if (e.getDate().equals(d) && e.getTime().equals(t) && e.getLocation().equals(string2)) {
                localEventFlag = false;
                temp = 1;
                System.out.println("in");
            }

        }
        if (temp == 0) {
            localEvent = new Event(string, date, t, string2, string3, int7);
            localEvent.setUser(n);
            n.getEventList().add(localEvent);
            eventList.add(localEvent);
            System.out.println("out");
            localEventFlag = true;

        }


    }

    public boolean isLocalEventFlag() {
        return localEventFlag;
    }

    public void setLocalEventFlag(boolean localEventFlag) {
        this.localEventFlag = localEventFlag;
    }


    public void chooseServiceOrPackageFlag(MyAppT obj) {
        serviceOrPackage = false;
    }

    public void chooseServiceOrPackage(Integer int1) {
        serviceOrPackage = true;
        switch (int1) {
            case 1:
                isServiceFlag = true;
                break;
            case 2:
                isPackageFlag = true;
                break;
            default:
                serviceOrPackage = false;

        }
    }

    public boolean isServiceOrPackage() {
        return serviceOrPackage;
    }

    public void setServiceOrPackage(boolean serviceOrPackage) {
        this.serviceOrPackage = serviceOrPackage;
    }

    public boolean isPackageFlag() {
        return isPackageFlag;
    }

    public void setPackageFlag(boolean packageFlag) {
        isPackageFlag = packageFlag;
    }

    public boolean isServiceFlag() {
        return isServiceFlag;
    }

    public void setServiceFlag(boolean serviceFlag) {
        isServiceFlag = serviceFlag;
    }

    public void chooseService(Integer int1) {
        serviceMenuFlag = true;
        switch (int1) {
            case 1:
                isFoodService = true;
                break;
            case 2:
                isDecorService = true;
                break;
            case 3:
                isPhotoService = true;
                break;
            case 4:
                isEnterService = true;
                break;
            case 5:
                eventList.add(localEvent);
                break;
            default:
                serviceMenuFlag = false;
        }
    }
    public void addLocalEventToEventList() {
        eventList.add(localEvent);
    }

    public void isMenuServiceFlag() {
        serviceMenuFlag = false;
    }

    public boolean isServiceMenuFlag() {
        return serviceMenuFlag;
    }

    public void setServiceMenuFlag(boolean serviceMenuFlag) {
        this.serviceMenuFlag = serviceMenuFlag;
    }

    public boolean isFoodService() {
        return isFoodService;
    }

    public boolean isDecorService() {
        return isDecorService;
    }

    public boolean isPhotoService() {
        return isPhotoService;
    }

    public boolean isEnterService() {
        return isEnterService;
    }

    public int addFoodService(Integer int1, String str) {


        for (ServiceProvider sp : providerList) {
            if (sp.getServiceType().equals(str)) {
                for (Service s : sp.getOfferList()) {


                        System.out.println(" dfhkjshfjks:::"+s.getSp().getPerson().getUserName());


                        if (s.getId() == int1) {
                            sendEmailTo(s.getSp().getPerson().getEmail());

                            sp.addEvent(localEvent);

                            switch (str) {
                                case "Food":
                                    localEvent.setFoodService(s);
                                    addLocalEventFoodFlag = true;

                                    break;
                                case "Decoration":
                                    localEvent.setDecorService(s);
                                    addLocalEventDecorFlag = true;

                                    break;
                                case "Entertainment":
                                    localEvent.setEntertainmentService(s);
                                    addLocalEventEnterFlag = true;
                                    break;
                                case "Photographer":
                                    localEvent.setPhotographerService(s);
                                    addLocalEventPhotoFlag = true;

                                    break;
                            }
                            return s.getCost();

                        }

                }
            }

        }
      return 0;
    }

    public boolean isAddLocalEventFoodFlag() {
        return addLocalEventFoodFlag;
    }

    public boolean isAddLocalEventDecorFlag() {
        return addLocalEventDecorFlag;
    }

    public boolean isAddLocalEventEnterFlag() {
        return addLocalEventEnterFlag;
    }

    public boolean isAddLocalEventPhotoFlag() {
        return addLocalEventPhotoFlag;
    }

    public boolean addPackageToEvent(Integer int1) {
        for (Package p : packageList) {
            if (p.getNumber() == int1) {
                localEvent.setPack(p);
                addPackageFlag = true;
                return true;
            }
        }
        return false;
    }

    public boolean isAddPackageFlag() {
        return addPackageFlag;
    }

    public void openRoleMenu(Integer int1) {
        switch (int1) {
            case 1:
                isAdminFlag = true;
                break;
            case 2:
                isUserFlag = true;
                break;
            case 3:
                isServiceProviderFlag = true;
                break;

            default:
                serviceMenuFlag = false;
        }
    }

    public boolean isAdminFlag() {
        return isAdminFlag;
    }

    public boolean isUserFlag() {
        return isUserFlag;
    }

    public boolean isServiceProviderFlag() {
        return isServiceProviderFlag;
    }


    public Person searchInUser(String string1) {
        for (Person p : up) {
            if (p.getUserName().equals(string1)) {
                return p;
            }
        }
        return null;
    }


    public String searchInSpAccordingToType(String string) {
        String s="Service providers:\n";
        for (ServiceProvider p : providerList) {
            if (p.getServiceType().equals(string)) {
              s+=p.getPerson().getUserName()+"\t"+p.getPerson().getPhoneNum()+"\n";
            }
        }
        return s;
    }



    public ServiceProvider searchInServiceProvider(String string) {
        for (ServiceProvider p : providerList) {
            if (p.getPerson().getUserName().equals(string)) {
                return p;
            }
        }
        return null;
    }

    public void searchInEventUser(String string) {
        Person pp = searchInUser(string);
        userhasevent = !(pp.getEventList().isEmpty());
    }







    public boolean isUserhasevent() {
        return userhasevent;
    }

    public Event searchInEvent(Integer int1) {
        for (Event e : eventList) {
            if (e.getIndex() == int1) {
                return e;
            }
        }
        return null;
    }

    public Event searchInEventByName(String str) {
        for (Event e : eventList) {
            if (e.getEventName().equals(str)) {
                return e;
            }
        }
        return null;
    }



    public Location searchInLocation(Integer int1) {
        for (Location e : locationList) {
            if (e.getId() == int1) {
                 return e;
            }
        }
        return null;
    }



    public void serchforevent(Integer int1) {

        Event ev = searchInEvent(int1);

        if (ev.equals(null)) {
            eventfoundflag = false;
        } else {
            eventfoundflag = true;
        }


    }

    public boolean isEventfoundflag() {
        return eventfoundflag;
    }

    public void selectServiceProviderMenu(Integer int1) {
        serviceproviderMenuFlag = true;
        switch (int1) {
            case 1:
                isAddService = true;
                break;
            case 2:
                isEditService = true;
                break;
            case 3:
                isDeleteService = true;
                break;
            case 4:
                isShoweventsAnduser = true;
                break;
            case 5:
                isShowService = true;

                break;
            default:
                serviceproviderMenuFlag = false;
        }

    }


    public boolean isEditService() {
        return isEditService;
    }

    public boolean isDeleteService() {
        return isDeleteService;
    }

    public boolean isShoweventsAnduser() {
        return isShoweventsAnduser;
    }

    public boolean isShowService() {
        return isShowService;
    }

    public boolean isServiceproviderMenuFlag() {
        return serviceproviderMenuFlag;
    }

    public boolean isAddService() {
        return isAddService;
    }

    public void addServiceToSp(String string, Integer double1, Integer int1, String string1) {

        Service s = new Service(string, int1, double1, searchInServiceProvider(string1));
        searchInServiceProvider(string1).addService(s);
        serviceaddedsucc = true;

        logger.info("Added successfully");

    }

    public boolean isServiceaddedsucc() {
        return serviceaddedsucc;
    }

    public void searchInServicesForSp(String string) {
        ServiceProvider pp = searchInServiceProvider(string);

        providerhasservice = !(pp.getOfferList().isEmpty());
    }

    public void editServiceForSp(String string, Integer double1, Integer int1, String string2) {
        Service s = searchInServiceProvider(string2).searchForServiceId(int1);
        if(s==null){
            logger.info("the service doesn't existing");
        }
        else {
            s.setCost(double1);
            s.setDiscription(string);
        }editServiceForSpFlag = true;




    }




    public boolean isEditServiceForSpFlag() {
        return editServiceForSpFlag;
    }

    public void deleteServiceForSp(Integer int1, String string) {
        ServiceProvider p = searchInServiceProvider(string);
        Service s = p.searchForServiceId(int1);
        p.getOfferList().remove(s);

        deleteServiceForSpFlag = true;
        if(s==null){
            logger.info("The service doesn't exist");
        }
        else{
        logger.info("deleted successfully");}

    }

    public boolean isDeleteServiceForSpFlag() {
        return deleteServiceForSpFlag;
    }

    public String showservicesForSp(String string) {
        ServiceProvider p = searchInServiceProvider(string);
        String format = "ID" + "\t" + "Discription" + "\t" + "Cost" + "\n";
        for (Service s : p.getOfferList()) {
            format += s.getId() + "\t" + s.getDiscription() + "\t" + s.getCost() + "\n";

        }
        showservicesForSpFlag = true;

        return format;


    }






    public String showUsersAndEventsForSp(String string) {






        ServiceProvider p = searchInServiceProvider(string);


        String format = "User Name" + "\t" + "Phone Number" + "\t" + "Event Name" + "\t" + "Theme" + "\t" + "Location" + "\t" + "Date" + "\t" + "Time" + "\n";
        for (Event e : p.getEventList()) {
            format += "t"+e.getUser().getUserName() + "\t" + e.getUser().getPhoneNum() + "\t" + e.getEventName() + "\t" + e.getTheme() + "\t" + e.getLocation() + "\t" + dateFormat.format(e.getDate()) + "\t" + e.getTime() + "\n";
        }
        showUsersAndEventsForSpFlag = true;
        System.out.println(format);
        return format;


    }

    public boolean isShowservicesForSpFlag() {
        return showservicesForSpFlag;
    }

    public boolean isShowUsersAndEventsForSpFlag() {
        return showUsersAndEventsForSpFlag;
    }

    public void selectFromAdminMenu(Integer int1) {
        adminMenuFlag = true;
        switch (int1) {
            case 1:
                isSeeUserList = true;
                break;
            case 2:

                isSeeSPList = true;
                break;
            case 3:

                isSeeEventList = true;
                break;

            case 4:
                isCreatePackage = true;
                break;
            case 5:
                isDeletePackage = true;
                break;

            default:
                adminMenuFlag = false;
        }
    }

    public String showUserListForAdmin() {
        String s = "";

        s = "UserName" + "\t" + "Phone Number" + "\t" + "Birth Date" + "\n";
        for (Person p : up) {
            s += p.getUserName() + "\t" + p.getPhoneNum() + "\t" + p.getB() + "\n";
        }
        showUserListForAdminFlag = true;
        return s;
    }

    public String showEventForAdmin() {

        String format = "Event Name" + "\t" + "Theme" + "\t" + "Location" + "\t" + "Date" + "\t" + "Time" + "\n";
        for (Event e : eventList) {
            format += e.getEventName() + "\t" + e.getTheme() + "\t" + e.getLocation() + "\t" + dateFormat.format(e.getDate()) + "\t" + e.getTime() + "\n";
        }
        showEventForAdminFlag = true;
        return format;

    }

    public String showSPtForAdmin() {


        String s = "UserName" + "\t" + "Phone Number" + "\t" + "Birth Date" + "\t" + " Service Type" + "\n";
        for (ServiceProvider e : providerList) {
            s += e.getPerson().getUserName() + "\t" + e.getPerson().getPhoneNum() + "\t" + e.getPerson().getB() + "\t" + e.getServiceType() + "\n";
        }
        showSPtForAdminFlag = true;
        return s;

    }

    public boolean isAdminMenuFlag() {
        return adminMenuFlag;
    }

    public boolean isShowUserListForAdminFlag() {
        return showUserListForAdminFlag;
    }

    public boolean isShowEventForAdminFlag() {
        return showEventForAdminFlag;
    }

    public boolean isShowSPtForAdminFlag() {
        return showSPtForAdminFlag;
    }

    public void createPackage(String string, Double double1,Integer int1) {
        Package p = new Package(string, double1,int1);
        packageList.add(p);

        createPackageFlag = true;
        logger.info("Package added successfully");


    }

    public boolean isCreatePackageFlag() {
        return createPackageFlag;
    }

    public void deletePackage(Integer int1) {

        for(Package p:packageList)
        {
            if(p.getNumber()==int1) {

                packageList.remove(p);
                deletePackageFlag=true;
                break;



            }

        }
    }

    public boolean isDeletePackageFlag() {
        return deletePackageFlag;
    }

    public boolean checkPackageList() {
     return !(packageList.isEmpty());

    }

    public String showPackageForAdmin() {

        String format = "ID" + "\t" + "Discription" + "\t" + "Cost" + "\n";
        for (Package p : packageList) {
            format += p.getNumber() + "\t" + p.getDescription() + "\t" + p.getTotalPrice() + "\n";

        }
        showPackageForAdminFlag = true;

        return format;

    }

    public boolean isShowPackageForAdminFlag() {
        return showPackageForAdminFlag;
    }


    public void editEventForUserMenu(Integer int1) {
        adminMenuFlag = true;
        switch (int1) {
            case 1:
                isEventNameEdit = true;
                break;
            case 2:

                isEventLocationEdit = true;
                break;
            case 3:
                isEventDateEdit = true;
                break;

            case 4:
                isEventTimeEdit = true;
                break;
            case 5:
                isEventNumOfPeopleEdit = true;
                break;
            case 6:
                isEventThemeEdit = true;
                break;
            case 7:
                isEventAdditionalServiceEdit = true;
                break;
            case 8:
                isEventRemoveServiceEdit = true;
                break;
            case 9:
                isEventCancelPackageEdit = true;
                break;
            case 10:
                isEventViewEventsEdit = true;
                break;
            case 11:
                isEventDeleteEventEdit = true;
                break;
           
            default:
                adminMenuFlag = false;
        }
    }

    public boolean isEventDeleteEventEdit() {
        return isEventDeleteEventEdit;
    }

    public boolean isEventViewEventsEdit() {
        return isEventViewEventsEdit;
    }

    public boolean isEventCancelPackageEdit() {
        return isEventCancelPackageEdit;
    }

    public boolean isEventRemoveServiceEdit() {
        return isEventRemoveServiceEdit;
    }

    public boolean isEventThemeEdit() {
        return isEventThemeEdit;
    }

    public boolean isEventNumOfPeopleEdit() {
        return isEventNumOfPeopleEdit;
    }

    public boolean isEventTimeEdit() {
        return isEventTimeEdit;
    }

    public boolean isEventDateEdit() {
        return isEventDateEdit;
    }

    public boolean isEventNameEdit() {
        return isEventNameEdit;
    }

    public boolean isEventLocationEdit() {
        return isEventLocationEdit;
    }

    public void editEventNameByUser(String string, String string2, String string3) {
        Person p=searchInUser(string);

       Event e= p.searchInUserEvents(string2);


            for (Event o : p.getEventList()) {

                    System.out.println("in side user event list "+o.getEventName()+"\n");

            }




       if(e==null){
           System.out.println("its nullllll");
       }
       else{
       e.setEventName(string3);}
        editEventNameByUserFlag=true;

    }

    public boolean isEditEventNameByUserFlag() {
        return editEventNameByUserFlag;
    }

    public void editEventDateByUser(String string, String string2, Integer int1, Integer int2, Integer int3) {
        Person p=searchInUser(string);
        Event e= p.searchInUserEvents(string2);
        Date d=new Date(int1,int2,int3);
        e.setDate(d);
        editEventDateByUserFlag=true;

    }

    public boolean isEditEventDateByUserFlag() {
        return editEventDateByUserFlag;
    }

    public void editEventTimeByUser(String string, String string2, Integer int1, Integer int2, Integer int3) {
        Person p=searchInUser(string);
        Event e= p.searchInUserEvents(string2);
        Time d=new Time(int1,int2,int3);
        e.setTime(d);
        editEventTimeByUserFlag=true;
    }

    public boolean isEditLocationFlag() {
        return editLocationFlag;
    }

    public boolean isEditEventTimeByUserFlag() {
        return editEventTimeByUserFlag;
    }

    public void editEventNumOfPeapleByUser(String string, String string2, Integer int1) {
        Person p=searchInUser(string);
        Event e= p.searchInUserEvents(string2);
        e.setNumGuests(int1);
        editEventNumOfPeapleByUserFlag=true;
    }

    public boolean isEditEventNumOfPeapleByUserFlag() {
        return editEventNumOfPeapleByUserFlag;
    }

    public void editEventThemeByUser(String string, String string2, String string3) {
        Person p=searchInUser(string);
        Event e= p.searchInUserEvents(string2);
        e.setTheme(string3);
        editEventThemeByUserFlag=true;
    }

    public boolean isEditEventThemeByUserFlag() {
        return editEventThemeByUserFlag;
    }

    public ArrayList<String> editToAddAdditionalServiceByUser(String string, String string2) {
        ArrayList<String> S;
        S = new ArrayList<>();

        Person p=searchInUser(string);
        Event e= p.searchInUserEvents(string2);
        if(e.getDecorService()==null){
            S.add("Decoration");
        }
        if(e.getEntertainmentService()==null){
            S.add("Entertainment");
        }
        if(e.getFoodService()==null){
            S.add("Food");
        }
        if(e.getPhotographerService()==null){
            S.add("Photographer");
        }
        editToAddAdditionalServiceByUserFlag=true;
        return S;
    }

    public boolean isEditToAddAdditionalServiceByUserFlag() {
        return editToAddAdditionalServiceByUserFlag;
    }

    public void editDeleteServiceFromEventByUser(String username, String eventName, Integer serviceId) {
         editDeleteServiceFromEventByUserFlag = true;
        Person p = searchInUser(username);
        Event e = p.searchInUserEvents(eventName);
        System.out.println(e.getEventName());
             if (e.getEntertainmentService() != null) {
            if( e.getEntertainmentService().getId()==serviceId)
                e.setEntertainmentService(null);
        }
           else if (e.getDecorService() != null) {
                 if( e.getDecorService().getId()==serviceId)
               e.setDecorService(null);

            }

            else if (e.getFoodService() == null ) {
              if(e.getFoodService().getId()==(serviceId))
                e.setFoodService(null);
            }

            else if (e.getPhotographerService() != null ) {
                if(e.getPhotographerService().getId()==(serviceId))
                e.setPhotographerService(null);
            }
            else {
                System.out.println("in else");
                editDeleteServiceFromEventByUserFlag = false;
            }

    }


    public boolean isEditDeleteServiceFromEventByUserFlag() {
        return editDeleteServiceFromEventByUserFlag;
    }

    public void editDeletePackageFromEventByUser(String string, String string2) {

        Person p=searchInUser(string);
        Event e= p.searchInUserEvents(string2);
        e.setPack(null);
        editDeletePackageFromEventByUserFlag=true;
        System.out.println(editDeletePackageFromEventByUserFlag);
        logger.info("deleted successfully");

    }

    public boolean isEditDeletePackageFromEventByUserFlag() {
        return editDeletePackageFromEventByUserFlag;
    }

    public String ViewEventsByUser(String string) {
        Person p=searchInUser(string);
        String format = "Event Name" + "\t" + "Theme" + "\t" + "Location" + "\t" + "Date" + "\t" + "Time" +"\t"+"Number of peaple"+ "\t"+"Decoration Service"+"\t"+"Entertainment Service"+"\t"+"Food Service"+"\t"+"Photographer Service"+"\n";
        for (Event e : p.getEventList()) {
            format += e.getEventName() + "\t" + e.getTheme() + "\t" + e.getLocation() + "\t" + e.getDate().getYear()+"\\"+ e.getDate().getMonth() +"\\"+ e.getDate().getDate()+ "\t" + e.getTime()+"\t"+e.getNumGuests()+"\t";
            if(!(e.getDecorService()==null)){
               format+=e.getDecorService().getDiscription();
            }
            else{
                format+="\t\t";
            }
            if(!(e.getEntertainmentService()==null)){
                format+=e.getEntertainmentService().getDiscription();

            }
            else{
                format+="\t\t";
            }
            if(!(e.getFoodService()==null)){
                format+=e.getFoodService().getDiscription();

            }
            else{
                format+="\t\t";
            }
            if(!(e.getPhotographerService()==null)){
                format+=e.getPhotographerService().getDiscription();

            }
            if(!(e.getPack()==null)){
                format+=e.getPack().getNumber()+"    "+e.getPack().getDescription();
            }
            else{
                format+="\t\t";
            }

        format+="\n";
        }
        ViewEventsByUserFlag = true;
        return format;

    }

    public boolean isViewEventsByUserFlag() {
        return ViewEventsByUserFlag;
    }

    public void DeleteEventByUser(String string, String string2) {
        Person p=searchInUser(string);
        Event e= p.searchInUserEvents(string2);
        p.getEventList().remove(e);
        eventList.remove(e);
        DeleteEventByUserFlag=true;
        for(ServiceProvider S:providerList){
            for(Event E:S.getEventList()){
                if(E.getEventName().equals(string2)){
                    S.getEventList().remove(E);

                }
            }
        }


    }

    public boolean isDeleteEventByUserFlag() {
        return DeleteEventByUserFlag;
    }


    public void editLocation(String string, String string2, Integer int1) {
        Person p=searchInUser(string);
        Event e= p.searchInUserEvents(string2);
        for(Location l:locationList)
        {
            if (l.getId()==int1) {
                e.setLocation(l.getLocationName());
                editLocationFlag=true;
            }
        }


    }

    public void editPackage(String string, String string2, Integer int1) {
        Person p=searchInUser(string);
        Event e= p.searchInUserEvents(string2);
        for(Package j :packageList)
        {
            if (j.getNumber()==int1) {
                e.setPack(j);

                editPackageFlag=true;            }

        }

    }
    public void sendEmailTo(String recipient) {
        try {
            Properties properties = System.getProperties();
            properties.put("mail.smtp.host", "smtp.gmail.com");
            properties.put("mail.smtp.port", "587");
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.starttls.enable", "true");

            Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("caraccessories1224@gmail.com\n", "lprr ivue vbtg rwpk");
                }
            });
            session.setDebug(true);
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("caraccessories1224@gmail.com\n"));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient, false));
            message.setSubject("Software Engineer");
            message.setText("Car accessories project");
            Transport.send(message);
        } catch (MessagingException m) {
            m.printStackTrace();
        }
    }

    public void createAccountForSp(String string, String string2, String string3, String string5, String string4, String string6) {
       int temp=0;
        for (ServiceProvider user : providerList) {
            if (user.getPerson().getUserName().equals(string) && user.getPerson().getPass().equals(string2)) {
                temp=1;
                userCreated = true;
                break;
            }
        }
        if(temp==0){
            addServiceProvider(new ServiceProvider(string, string2,string3,string5,string4,string6));
        }
    }
    public void createAccountForUser(String string, String string2, String string3, String string5, String string4) {
    int temp=0;
        for (Person user : up) {
            if (user.getUserName().equals(string) && user.getPass().equals(string2)) {
                temp=1;
                userCreated = true;
                break;
            }


        }
        if(temp==0)

        {
            addUser(new Person(string, string2,string3,string4,string5));

        }
    }

    public Package searchInPackage(int packId) {
        for(Package j :packageList)
        {
            if (j.getNumber()==packId) {
              return j;
                       }

        }
        return null;
    }
}


