
package BaseClass;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class Base {

    protected WebDriver driver;

    @Parameters("browser")
    @BeforeMethod(alwaysRun = true)
    public void launchBrowser(String browser) throws Exception {

        Properties p = new Properties();

        try (FileInputStream fis = new FileInputStream(
                "src/main/resources/DDT/CommonData.properties")) {
            p.load(fis);
        }

        String url = p.getProperty("url");

        if (url == null || url.trim().isEmpty()) {
            throw new RuntimeException(
                    "URL is missing in CommonData.properties");
        }

        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito");
            driver = new ChromeDriver(options);

        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();

        } else {
            throw new RuntimeException("Invalid browser: " + browser);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(30));

        driver.get(url);

        System.out.println("Browser = " + browser);
        System.out.println("Browser launched");
        System.out.println("Application opened");
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        System.out.println("Closing browser");

        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
