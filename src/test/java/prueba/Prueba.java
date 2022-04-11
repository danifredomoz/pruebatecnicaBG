package prueba;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class Prueba {
    private WebDriver driver;

    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://mercadolibre.com/");
        driver.manage().window().maximize();

        WebElement selectBo = driver.findElement(By.id("BO"));
        selectBo.click();

        WebElement cookies = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/button[1]"));
        cookies.click();

        WebElement closeMessage = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/button"));
        closeMessage.click();

        WebElement search = driver.findElement(By.id("cb1-edit"));
        search.sendKeys("celular samsung");
        search.submit();

        WebElement newProd = driver.findElement(By.className("ui-search-filter-name"));
        newProd.click();

        driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
        boolean product1;
        boolean product2;
        boolean product3;

        try {
            product1 = driver.findElements(By.xpath("//*[@id=\"root-app\"]/div/ol/li[6]/div/div/div/div/div[2]/a/div/div[1]/h2")).size() != 0;
            product2 = driver.findElements(By.xpath("//*[@id=\"root-app\"]/div/ol/li[4]/div/div/div/div/div[2]/a/div/div[1]/h2")).size() != 0;
            product3 = driver.findElements(By.xpath("//*[@id=\"root-app\"]/div/ol/li[3]/div/div/div/div/div[2]/a/div/div[1]")).size() != 0;
        } catch (NoSuchElementException e){

            System.out.println("Error: menos de 3 productos");
        }

        driver.quit();
    }

    public static void main(String arg[]){
        Prueba prueba = new Prueba();
        prueba.setUp();
    }
}
