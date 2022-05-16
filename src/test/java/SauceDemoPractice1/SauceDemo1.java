package SauceDemoPractice1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.*;

public class SauceDemo1 {

    static WebDriver driver;

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        try {
            driver = new ChromeDriver();
            driver.navigate().to("https://www.saucedemo.com/");
            driver.manage().window().maximize();
            SauceDemo1 sauceDemoPractice = new SauceDemo1();
           /* sauceDemoPractice.testCaseOne();
            Thread.sleep(500);
            sauceDemoPractice.testcaseTwo();
            Thread.sleep(500);
            sauceDemoPractice.testCaseThree();
            Thread.sleep(500);
            sauceDemoPractice.testCaseFour();*/
            Thread.sleep(500);
            sauceDemoPractice.testCaseFive("Fleece Jacket"); //Send a name of Product to be search
            Thread.sleep(500);


        }
        catch (Exception e ){
           e.printStackTrace();
       driver.quit();
        }
        finally {
          driver.quit();
        }
    }


    public void testCaseOne() throws InterruptedException {

        System.out.println("******************************");
        System.out.println("UserName" + getuserName(1)); //standard_user
        System.out.println("data type : " + getPassword(1).getClass().getSimpleName());
        System.out.println("Userpass" + getPassword(1)); // secret_sauce
        System.out.println("******************************");
        Thread.sleep(500);
        String username = getuserName(1);
        driver.findElement(By.xpath("//input[@data-test='username']")).sendKeys(username);//
        Thread.sleep(500);

        driver.findElement(By.xpath("//input[@data-test='password']")).sendKeys("secret_sauce");//getuserName(1)

        Thread.sleep(500);

        driver.findElement(By.xpath("//input[@id='login-button']")).click();

        System.out.println("******************************************");

        System.out.println("Title" + driver.getTitle());

        Thread.sleep(500);

        Assert.assertEquals("**********Login Fail ********************", "Swag Labs", driver.getTitle());
        System.out.println("********************** Page Login Successfully********************");

/*          Select following index for filter in getFilter();
            1.  Name (A to Z)
            2.  Name (Z to A)
            3.  Price (low to high)
            4.  Price (high to low)
 */
        getFilter(4);

        Thread.sleep(500);


        driver.findElement(By.xpath("//*/div[text()='" + sortPrice() + "']//parent::div/button")).click();
        System.out.println("**************************Item is  successfully added to cart ****************************");
        driver.findElement(By.xpath("//*/div[@class='shopping_cart_container']")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//button[@id='checkout']")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//input[@id='first-name']")).sendKeys(dataProvider().get("first-name"));
        driver.findElement(By.xpath("//input[@id='last-name']")).sendKeys(dataProvider().get("last-name"));
        driver.findElement(By.xpath("//input[@id='postal-code']")).sendKeys(dataProvider().get("postal-code"));
        System.out.println("**************************user Details entered successfully  ****************************");
        Thread.sleep(500);
        driver.findElement(By.xpath("//input[@id='continue']")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//button[@id='finish']")).click();
        String successfullMsg = driver.findElement(By.xpath("//h2[@class='complete-header']")).getText();
        System.out.println("*******" + "last page message :" + "*********** :" + successfullMsg + ": *********");
        Thread.sleep(500);
        System.out.println("**************************Product ordered  successfully for user :" + username + ": ****************************");
        driver.findElement(By.xpath("//button[@name='back-to-products']")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//a[@id='logout_sidebar_link']")).click();
        System.out.println("**********************Test Case 1 Pass ********************************** ");
        Thread.sleep(500);

    }


    public void testcaseTwo() throws InterruptedException {
        System.out.println("******************************");
        System.out.println("UserName" + getuserName(2)); //standard_user
        System.out.println("data type : " + getPassword(1).getClass().getSimpleName());
        System.out.println("Userpass" + getPassword(1)); // secret_sauce
        System.out.println("******************************");
        Thread.sleep(500);
        String username = getuserName(2);
        String password = getPassword(1);
        driver.findElement(By.xpath("//input[@data-test='username']")).sendKeys(username);//
        Thread.sleep(500);
        driver.findElement(By.xpath("//input[@data-test='password']")).sendKeys(password);//getuserName(1)
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
        String errorMsg = driver.findElement(By.xpath("//div[@class='error-message-container error']")).getText();

        if (errorMsg.contains("Username and password do not match any user in this service"))
            System.out.println("****Username and password do not match any user in this service**");
        else
            System.out.println("Error : " + driver.findElement(By.xpath("//div[@class='error-message-container error']")).getText());

        System.out.println("*****************Test case Two pass ************************************");


    }


    public void testCaseThree() throws InterruptedException {

        System.out.println("******************************");
        System.out.println("UserName" + getuserName(3)); //standard_user
        System.out.println("data type : " + getPassword(1).getClass().getSimpleName());
        System.out.println("Userpass" + getPassword(1)); // secret_sauce
        System.out.println("******************************");
        Thread.sleep(200);
        String username = getuserName(3);
        Thread.sleep(200);
        String password = getPassword(1);
        driver.findElement(By.xpath("//input[@data-test='username']")).clear();
        Thread.sleep(300);
        driver.findElement(By.xpath("//input[@data-test='username']")).sendKeys(username);//
        Thread.sleep(500);
        driver.findElement(By.xpath("//input[@data-test='password']")).clear();
        Thread.sleep(300);
        driver.findElement(By.xpath("//input[@data-test='password']")).sendKeys(password);//getuserName(1)

        Thread.sleep(500);

        driver.findElement(By.xpath("//input[@id='login-button']")).click();

        System.out.println("******************************************");

        System.out.println("Title" + driver.getTitle());

        Thread.sleep(500);

        Assert.assertEquals("**********Login Fail ********************", "Swag Labs", driver.getTitle());
        System.out.println("********************** Page Login Successfully********************");
        System.out.println("*****************Product Images are same ***********************************");

        driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//a[@id='logout_sidebar_link']")).click();
        System.out.println("**********************Test Case 3 Pass ********************************** ");
        Thread.sleep(500);

    }


    public void testCaseFour() throws InterruptedException {

        System.out.println("******************************");
        System.out.println("UserName" + getuserName(4)); //standard_user
        System.out.println("data type : " + getPassword(1).getClass().getSimpleName());
        System.out.println("Userpass" + getPassword(1)); // secret_sauce
        System.out.println("******************************");
        Thread.sleep(500);
        String username = getuserName(4);
        String password = getPassword(1);
        Thread.sleep(500);
        driver.findElement(By.xpath("//input[@data-test='username']")).sendKeys(username);//
        Thread.sleep(500);

        driver.findElement(By.xpath("//input[@data-test='password']")).sendKeys(password);//getuserName(1)

        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@id='login-button']")).click();

        Thread.sleep(3000);
        System.out.println("***************** Error in login **********************");

        System.out.println("Title" + driver.getTitle());

        Thread.sleep(500);

        Assert.assertEquals("**********Login Fail ********************", "Swag Labs", driver.getTitle());
        System.out.println("********************** Page Login Successfully********************");

/*          Select following index for filter in getFilter();
            1.  Name (A to Z)
            2.  Name (Z to A)
            3.  Price (low to high)
            4.  Price (high to low)
 */
        getFilter(3);

        Thread.sleep(500);

        driver.findElement(By.xpath("//*/div[text()='" + sortPrice() + "']//parent::div/button")).click();
        System.out.println("**************************Item is  successfully added to cart ****************************");
        driver.findElement(By.xpath("//*/div[@class='shopping_cart_container']")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//button[@id='checkout']")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//input[@id='first-name']")).sendKeys(dataProvider().get("first-name"));
        driver.findElement(By.xpath("//input[@id='last-name']")).sendKeys(dataProvider().get("last-name"));
        driver.findElement(By.xpath("//input[@id='postal-code']")).sendKeys(dataProvider().get("postal-code"));
        System.out.println("**************************user Details entered successfully  ****************************");
        Thread.sleep(500);
        driver.findElement(By.xpath("//input[@id='continue']")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//button[@id='finish']")).click();
        String successfullMsg = driver.findElement(By.xpath("//h2[@class='complete-header']")).getText();
        System.out.println("*******" + "last page message :" + "*********** :" + successfullMsg + ": *********");
        Thread.sleep(500);
        System.out.println("**************************Product ordered  successfully for user :" + username + ": ****************************");
        driver.findElement(By.xpath("//button[@name='back-to-products']")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//a[@id='logout_sidebar_link']")).click();
        System.out.println("**********************Test Case 4 Pass ********************************** ");
        Thread.sleep(500);

    }




    public void testCaseFive(String  product ) throws InterruptedException {

        System.out.println("******************************");
        System.out.println("UserName" + getuserName(1)); //standard_user
        System.out.println("data type : " + getPassword(1).getClass().getSimpleName());
        System.out.println("Userpass" + getPassword(1)); // secret_sauce
        System.out.println("******************************");
        Thread.sleep(500);
        String username = getuserName(1);
        String password = getPassword(1);
        driver.findElement(By.xpath("//input[@data-test='username']")).sendKeys(username);//
        Thread.sleep(500);

        driver.findElement(By.xpath("//input[@data-test='password']")).sendKeys(password);//getuserName(1)

        Thread.sleep(500);

        driver.findElement(By.xpath("//input[@id='login-button']")).click();

        System.out.println("******************************************");

        System.out.println("Title" + driver.getTitle());

        Thread.sleep(500);

        Assert.assertEquals("**********Login Fail ********************", "Swag Labs", driver.getTitle());
        System.out.println("********************** Page Login Successfully********************");

        Thread.sleep(500);



        driver.findElement(By.xpath("//div[contains(text(), '"+product+"')]//ancestor::div[@class=\"inventory_item\"]//button")).click();
        System.out.println("**************************Item is  successfully added to cart ****************************");
        driver.findElement(By.xpath("//*/div[@class='shopping_cart_container']")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//button[@id='checkout']")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//input[@id='first-name']")).sendKeys(dataProvider().get("first-name"));
        driver.findElement(By.xpath("//input[@id='last-name']")).sendKeys(dataProvider().get("last-name"));
        driver.findElement(By.xpath("//input[@id='postal-code']")).sendKeys(dataProvider().get("postal-code"));
        System.out.println("**************************user Details entered successfully  ****************************");
        Thread.sleep(500);
        driver.findElement(By.xpath("//input[@id='continue']")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//button[@id='finish']")).click();
        String successfullMsg = driver.findElement(By.xpath("//h2[@class='complete-header']")).getText();
        System.out.println("*******" + "last page message :" + "*********** :" + successfullMsg + ": *********");
        Thread.sleep(500);
        System.out.println("**************************Product ordered  successfully for user :" + username + ": ****************************");
        driver.findElement(By.xpath("//button[@name='back-to-products']")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//a[@id='logout_sidebar_link']")).click();
        System.out.println("**********************Test Case 1 Pass ********************************** ");
        Thread.sleep(500);

    }



    public String getuserName(int userNumber) {

        List<String> userCredntls;

        userCredntls = List.of(driver.findElement(By.id("login_credentials")).getText().split("\\s"));
        System.out.println("*****************************************");
        System.out.println("UserName" + userCredntls.get(userNumber + 2));
        return String.valueOf(userCredntls.get(userNumber + 2));
    }

    public String getPassword(int passNumber) {
        List<String> userCredntls;
        userCredntls = List.of(driver.findElement(By.xpath("//div[@class='login_password']")).getText().split("\\s"));
        System.out.println("*************************************************");
        System.out.println("List " + userCredntls);
        System.out.println("Password" + userCredntls.get(passNumber + userCredntls.size()-2));

        return String.valueOf(userCredntls.get(passNumber + userCredntls.size()-2));
    }

    public String sortPrice() {


        List<WebElement> webelements;
        List<Float> price = new ArrayList<>();
        webelements = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
        webelements.forEach(webElement -> price.add(Float.parseFloat(webElement.getText().replace("$", ""))));

        System.out.println("*****************************************");
        System.out.println("price List " + price);

        //noinspection ResultOfMethodCallIgnored
        price.stream().sorted();

        System.out.println("Selected price " + price.get(0).toString());
        return price.get(0).toString();

    }

    public Map<String, String> dataProvider() {

        Map<String, String> dataProvider = new HashMap<>();

        dataProvider.put("first-name", "abc");
        dataProvider.put("last-name", "xyz");
        dataProvider.put("postal-code", "411046");
        return dataProvider;

    }

    public void getFilter(int index) throws InterruptedException {


        Map<Integer, String> filterValue = new HashMap<>();

        filterValue.put(1, "Name (A to Z)");
        filterValue.put(2, "Name (Z to A)");
        filterValue.put(3, "Price (low to high)");
        filterValue.put(4, "Price (high to low)");
        Thread.sleep(500);


        filterValue.forEach((k, v) -> {
            Select select1 = new Select(driver.findElement(By.xpath("//select[@class='product_sort_container']")));
            select1.selectByVisibleText(filterValue.get(k));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread.sleep(2000);
        Select select = new Select(driver.findElement(By.xpath("//select[@class='product_sort_container']")));
        select.selectByVisibleText(filterValue.get(index));
    }

}
