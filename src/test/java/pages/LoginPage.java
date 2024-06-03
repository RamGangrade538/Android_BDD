package pages;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import utils.DriverFactory;
public class LoginPage {

        @AndroidFindBy(
                xpath = "//android.widget.EditText[@content-desc='Username input field']"
        )
        private MobileElement usernameField;
        @AndroidFindBy(
                accessibility = "Password input field"
        )
        private MobileElement passwordField;
        @AndroidFindBy(
                accessibility = "Login button"
        )
        private MobileElement loginButton;
        @AndroidFindBy(
                xpath = "//android.widget.TextView[@text='Sorry, this user has been locked out.']"
        )
        private MobileElement LockedUserText;
        @AndroidFindBy(
                xpath = "//android.widget.TextView[@text='Password is required']"
        )
        private MobileElement passwordRequiredText;
        @AndroidFindBy(
                xpath = "//android.widget.TextView[@text='Provided credentials do not match any user in this service.']"
        )
        private MobileElement NO_MATCH;
        @AndroidFindBy(
                xpath = "//android.widget.TextView[@text='Username is required']"
        )
        private MobileElement NO_USER_DETAILS;
        @AndroidFindBy(
                xpath = "//android.widget.TextView[@text='Products']"
        )
        private MobileElement product;
        @AndroidFindBy(
                xpath = "//android.view.ViewGroup[@content-desc='open menu']/android.widget.ImageView"
        )
        private MobileElement Menu;
        @AndroidFindBy(
                xpath = "//android.view.ViewGroup[@content-desc='menu item log in']"
        )
        private MobileElement clickonLogin;

        public LoginPage() {
            PageFactory.initElements(new AppiumFieldDecorator(DriverFactory.getDriver()), this);
        }

        public void loginDash() {
            Menu.click();
            clickonLogin.click();
        }

        public void enterUsername(String username) {
            try {
                Thread.sleep(3000L);
            } catch (InterruptedException var3) {
                throw new RuntimeException(var3);
            }

            this.usernameField.sendKeys(new CharSequence[]{username});
        }

        public void enterPassword(String password) {
            this.passwordField.sendKeys(new CharSequence[]{password});
        }

        public void clickLoginButton() {
            this.loginButton.click();
        }

        public boolean isUserLoggedIn() {
            return this.product.isDisplayed();
        }

        public String getErrorMessage() {
            if (this.isElementDisplayed(this.LockedUserText)) {
                return this.getErrorMessageText(this.LockedUserText);
            } else if (this.isElementDisplayed(this.NO_MATCH)) {
                return this.getErrorMessageText(this.NO_MATCH);
            } else if (this.isElementDisplayed(this.NO_USER_DETAILS)) {
                return this.getErrorMessageText(this.NO_USER_DETAILS);
            } else {
                return this.isElementDisplayed(this.passwordRequiredText) ? this.getErrorMessageText(this.passwordRequiredText) : "";
            }
        }

        private boolean isElementDisplayed(MobileElement element) {
            try {
                return element.isDisplayed();
            } catch (Exception var3) {
                return false;
            }
        }

        private String getErrorMessageText(MobileElement element) {
            String message = element.getText();
            System.out.println("Error: " + message);
            return message;
        }

        public void clearUsername() {
            this.usernameField.clear();
        }

        public void clearPassword() {
            this.passwordField.clear();
        }

        public void clearLoginDetails() {
            this.clearUsername();
            this.clearPassword();
        }

        public void reset() {
            DriverFactory.restartApp();
        }
    }


