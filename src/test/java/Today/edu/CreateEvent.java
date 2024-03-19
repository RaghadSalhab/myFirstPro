package Today.edu;

import io.cucumber.java.an.Dada;
import io.cucumber.java.en.*;
import org.junit.Before;

import java.sql.Date;
import java.sql.Time;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CreateEvent {

    public MyAppT obj;
    private boolean pastDateFlag;

    public CreateEvent(MyAppT iobj) {
        super();
        this.obj = iobj;

    }

    @Given("the user in user page")
    public void the_user_in_user_page() {
        obj.iAmInUserPage(obj);
    }

    @When("the user enters the {int}")
    public void the_user_enters_the(Integer int1) {
        obj.chooseFromUserPage(int1);
    }

    @Then("the user enters the creation page")
    public void the_user_enters_the_creation_page() {
        assertTrue("succeed", obj.isInCreationPage());
    }

    @Given("the user is on the event creation page")
    public void the_user_is_on_the_event_creation_page() {
        obj.iAmINCreationPage(obj);
    }


    @When("the user fills in the event details with a past date {int}-{int}-{int}")
    public void the_user_fills_in_the_event_details_with_a_past_date(Integer int1, Integer int2, Integer int3) {
        pastDateFlag = obj.checkPastDate(int1, int2, int3);
    }


    @Then("the user receives an error message")
    public void the_user_receives_an_error_message() {
        assertTrue(pastDateFlag);
    }


    @When("the user {string} fills in the event details including name {string}, place {string}, time {int}:{int}:{int}, date {int}-{int}-{int}, number of attendees {int}, and theme {string}")
    public void the_user_fills_in_the_event_details_including_name_place_time_date_number_of_attendees_and_theme(String string, String string2, String string3, Integer int1, Integer int2, Integer int3, Integer int4, Integer int5, Integer int6, Integer int7, String string4) {
        obj.createEventWithBasicInfo(string,string2, int4, int5, int6, int1, int2, int3, string3, string4, int7);

    }



    @Then("the event is created successfully")
    public void the_event_is_created_successfully() {
        assertTrue(obj.isLocalEventFlag());
    }

    @Given("the user is presented with a choice between individual services and ready-made packages")
    public void the_user_is_presented_with_a_choice_between_individual_services_and_ready_made_packages() {
        obj.chooseServiceOrPackageFlag(obj);
    }

    @When("the user selects an option by entering {int} for individual services and other for ready-made packages")
    public void the_user_selects_an_option_by_entering_for_individual_services_and_other_for_ready_made_packages(Integer int1) {
        obj.chooseServiceOrPackage(int1);
    }

    @Then("the user's choice is captured")
    public void the_user_s_choice_is_captured() {
        assertTrue(obj.isServiceOrPackage());
    }

    @Given("the user chooses to select individual services")
    public void the_user_chooses_to_select_individual_services() {
        obj.isMenuServiceFlag();
    }


    @When("the user selects {int} choice from the menu")
    public void the_user_selects_choice_from_the_menu(Integer int1) {
        obj.chooseService(int1);
    }

    @Then("the user's choice is token")
    public void the_user_s_choice_is_token() {
        assertTrue(obj.isServiceMenuFlag());

    }

    @Given("the user selects the food service")
    public void theUserSelectsTheFoodService() {
        boolean f = obj.isFoodService();
    }


    @When("the user selects {int} choice from the  food menu")
    public void the_user_selects_choice_from_the_food_menu(Integer int1) {

        obj.addFoodService(int1, "Food");
    }

    @Then("Add the selected food service provider details to the event")
    public void addTheSelectedFoodServiceProviderDetailsToTheEvent() {
        assertTrue(obj.isAddLocalEventFoodFlag());
    }


    @Given("the user selects the entertainment service")
    public void theUserSelectsTheEntertainmentService() {
        boolean e = obj.isEnterService();
    }


    @Given("the user selects the decoration service")
    public void theUserSelectsTheDecorationService() {
        boolean d= obj.isDecorService();
    }

    @Given("the user selects the photographer service")
    public void theUserSelectsThePhotographerService() {
        boolean p = obj.isPhotoService();
    }



    @When("the user selects {int} choice from the  entertainment menu")
    public void the_user_selects_choice_from_the_entertainment_menu(Integer int1) {
        obj.addFoodService(int1, "Entertainment");
    }

    @Then("Add the selected entertainment service provider details to the event")
    public void add_the_selected_entertainment_service_provider_details_to_the_event() {
        assertTrue(obj.isAddLocalEventEnterFlag());
    }

    @When("the user selects {int} choice from the  decoration menu")
    public void the_user_selects_choice_from_the_decoration_menu(Integer int1) {
        obj.addFoodService(int1, "Decoration");

    }

    @Then("Add the selected decoration service provider details to the event")
    public void add_the_selected_decoration_service_provider_details_to_the_event() {
        assertTrue(obj.isAddLocalEventDecorFlag());

    }

    @When("the user selects {int} choice from the  photographer menu")
    public void the_user_selects_choice_from_the_photographer_menu(Integer int1) {
        obj.addFoodService(int1, "Photographer");

    }

    @Then("Add the selected photographer service provider details to the event")
    public void add_the_selected_photographer_service_provider_details_to_the_event() {
        assertTrue(obj.isAddLocalEventPhotoFlag());

    }


    @When("the user selects to choose a ready-made package")
    public void the_user_selects_to_choose_a_ready_made_package() {
       boolean p= obj.isPackageFlag();
    }



    @When("the user selects  {int} package")
    public void the_user_selects_package(Integer int1) {
        boolean b=obj.addPackageToEvent(int1);
    }



    @Then("the selected package details are added to the event")
    public void the_selected_package_details_are_added_to_the_event() {
       assertTrue(obj.isAddPackageFlag());
    }

    @When("the user {string} fills in the event details including name {string}, place {string}, time {int}:{int}:{int}, date {int}-{int}-{int}, number of attendees {int}, and theme {string} and there is no conflict between time and location and place")
    public void the_user_fills_in_the_event_details_including_name_place_time_date_number_of_attendees_and_theme_and_there_is_no_conflict_between_time_and_location_and_place(String string, String string2, String string3, Integer int1, Integer int2, Integer int3, Integer int4, Integer int5, Integer int6, Integer int7, String string4) {
        obj.createEventWithBasicInfo(string,string2, int4, int5, int6, int1, int2, int3, string3, string4, int7);

    }


    @Then("reject event creation")
    public void reject_event_creation() {
      assertFalse(obj.isLocalEventFlag());
    }



}
