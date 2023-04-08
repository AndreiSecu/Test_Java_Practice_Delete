package md.tekwill;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;


public class BookTests {

    String URL = "https://demoqa.com/books";
    static WebDriver nightWorkerDriver;


    @BeforeAll
    public static void executeOnceBeforeAllTests(){
        WebDriverManager.edgedriver().setup();

    }

    @BeforeEach
    public void beforeEachTest(){
        nightWorkerDriver = new EdgeDriver();
        nightWorkerDriver.manage().window().maximize();
    }

    @Test
    @DisplayName("Books page is accessed and displayed")
    public void booksPageIsAccessed() throws InterruptedException {


        nightWorkerDriver.get(URL);

        String currentUrl = nightWorkerDriver.getCurrentUrl();

        Assertions.assertEquals(URL, currentUrl);

        WebElement searchInput = nightWorkerDriver.findElement(By.id("searchBox"));

        Assertions.assertTrue(searchInput.isDisplayed(), "Search Input lipseste");

    }

    @Test
    @DisplayName("Particular book page")
    public void GitPageIsAccessed() {

        nightWorkerDriver.manage().window().maximize();

        nightWorkerDriver.get(URL);

        String currentUrl = nightWorkerDriver.getCurrentUrl();

        Assertions.assertEquals(URL, currentUrl);

        WebElement searchInput = nightWorkerDriver.findElement(By.id("searchBox"));

        searchInput.sendKeys("Git");

        WebElement gitBook = nightWorkerDriver.findElement(By.id("see-book-Git Pocket Guide"));
        gitBook.click();

        Assertions.assertFalse(nightWorkerDriver.getCurrentUrl().equals(URL), "Search Input lipseste");
    }

    @AfterEach
    public void afterEachProcedure(){
        nightWorkerDriver.close();
    }

    @AfterAll
    public static void executeOnceAfterAll(){
        nightWorkerDriver.quit();
    }
}
