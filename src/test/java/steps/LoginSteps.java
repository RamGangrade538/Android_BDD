package steps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.LoginPage;

public class LoginSteps {

    private LoginPage loginPage;


        public LoginSteps() {
             loginPage = new LoginPage();

        }

        @Given("Goto the Login page invalid")
        public void goto_the_login_page_invalid() {
            this.loginPage.loginDash();
        }

        @When("I enter username {string} and password {string} invalid")
        public void i_enter_username_and_password(String username, String password) {
            this.loginPage.enterUsername(username);
            this.loginPage.enterPassword(password);
        }

        @And("I click on the login button invalid")
        public void i_click_on_the_login_button() {
            this.loginPage.clickLoginButton();
        }

        @Then("Verify Error message invalid")
        public void Verify_Error_Message() {
            String errorMessage = this.loginPage.getErrorMessage();
            Assert.assertNotNull(errorMessage, "No error message is displayed.");
            Assert.assertFalse(errorMessage.isEmpty(), "Error message is empty.");
            System.out.println("Error message displayed: " + errorMessage);
            this.loginPage.clearLoginDetails();
            this.loginPage.reset();
        }

        @Given("Goto the Login page")
        public void goto_the_login_page() {
            this.loginPage.loginDash();
        }

        @When("I enter username {string} and password {string}")
        public void i_enter_username_and_password2(String username, String password) {
            this.loginPage.enterUsername(username);
            this.loginPage.enterPassword(password);
        }

        @And("I click on the login button")
        public void i_click_on_the_login_button2() {
            this.loginPage.clickLoginButton();
        }

        @Then("Verify login successfully")
        public void Verify_login_successfully() {
            Assert.assertTrue(this.loginPage.isUserLoggedIn(), "successfully login");
            System.out.println("Verifying product screen with product tag.");
        }
    }


