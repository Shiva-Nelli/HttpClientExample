package Stepdefinations;

import com.pages.LandingPage;
import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Stepdefination {

    LandingPage landingPage = new LandingPage(DriverFactory.getDriver());

    @Given("user launches HTTPClient")
    public void user_launches_http_client() throws Exception {
        DriverFactory.getDriver().get(ConfigReader.getValue("URL"));
    }

    @When("user enters {string} value in the Hero name")
    public void user_enters_value_in_the_hero_name(String string) throws InterruptedException {
        landingPage.enterHeroName(string);
    }

    @When("user clicks on add button")
    public void user_clicks_on_add_button() throws InterruptedException {
        landingPage.clickAddHero();
    }

    @Then("hero will be added")
    public void hero_will_be_added() throws InterruptedException {

        Assert.assertTrue(landingPage.verifyUserIsAdded());

    }

    @Then("user clicks on delete the newly added hero")
    public void user_clicks_on_delete_the_newly_added_hero() throws InterruptedException {
        landingPage.deleteAddedUser();
    }

    @When("user searches newly added heroname")
    public void user_searches_newly_added_heroname() throws InterruptedException {
        landingPage.enterHeroName(LandingPage.hero);
        landingPage.clickSearch();
    }

    @Then("user will be displayed with newly added hero name")
    public void user_will_be_displayed_with_newly_added_hero_name() {
        Assert.assertTrue(landingPage.verifyUserIsAdded());
    }

    @Then("update the hero value {string} by editing")
    public void update_the_hero_value_by_editing(String string) throws InterruptedException {
       landingPage.editHero(string);
       Thread.sleep(2000);
    }


    @When("user deletes all heros")
    public void user_deletes_all_heros() throws InterruptedException {
       landingPage.deleteAllHeros();
    }

    @Then("count should be started with {int}")
    public void count_should_be_started_with(Integer int1) throws InterruptedException{
        Assert.assertTrue(landingPage.getCount().equals(Integer.toString(int1)));
    }




}
