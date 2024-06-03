package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverFactory {


        private static AppiumDriver<MobileElement> driver = null;
        private static final Logger logger = Logger.getLogger(DriverFactory.class.getName());
        private static WebDriverWait wait;


        public static AppiumDriver<MobileElement> initializeDriver() {
            if (driver == null) {
                DesiredCapabilities caps = new DesiredCapabilities();
                caps.setCapability("platformName", "Android");
                caps.setCapability("deviceName", "Pixel 7 API 30");
                caps.setCapability("platformVersion", "11.0");
                caps.setCapability("app", "C:\\Users\\DELL\\Downloads\\Android-MyDemoAppRN.1.3.0.build-244.apk");
                caps.setCapability("automationName", "UiAutomator2");
                caps.setCapability("fullReset", true);

                try {
                    driver = new AppiumDriver(new URL("http://0.0.0.0:4723/wd/hub"), caps);
                } catch (MalformedURLException var2) {
                    throw new RuntimeException(var2);
                }

                driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
                System.out.println(driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS));
                logger.info("Appium driver initialized successfully");
            }

            return driver;
        }

        public static void quit() {
            if (driver != null) {
                driver.closeApp();
                driver = null;
                logger.info("Appium driver quit successfully");
            }

        }

        public static AppiumDriver<MobileElement> getDriver() {
            if (driver == null) {
                driver = initializeDriver();
            }

            return driver;
        }

        public static void restartApp() {
            driver.closeApp();
            driver.launchApp();
        }
    }




