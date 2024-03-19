package Today.edu;

import java.util.ArrayList;

public class Person
{
    private  String userName;
    private  String pass;
    private  String birthDate;
    private String phoneNum;

    private ArrayList<Event> eventList =new ArrayList<>();
     private String email;

    public Person(String un, String pa, String bd, String pn,String em) {
        userName =un;
        pass=pa;
        birthDate =bd;
        phoneNum=pn;
        email=em;
    }

    public Person(String un, String pa, String bd, String pn) {
        userName =un;
        pass=pa;
        birthDate =bd;
        phoneNum=pn;
    }
    public String getUserName() {
        return userName;
    }
    public String getPass() {
        return pass;
    }
    public String getB(){return birthDate;}
    public String getPhoneNum(){return phoneNum;}


    public String getEmail() {
        return email;
    }

    public Person() {

    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    public void setPhoneNum(String pn) {
        this.phoneNum=pn;
    }

    public ArrayList<Event> getEventList() {
        return eventList;
    }

    public void setEventList(ArrayList<Event> eventList) {
        this.eventList = eventList;
    }
    public void addUserEvent(Event e){
        eventList.add(e);
    }
    public Event searchInUserEvents(String e1){
        for (Event e:eventList){
            if(e.getEventName().equals(e1)){

                return e;
            }
        }
        return null;
    }
}
