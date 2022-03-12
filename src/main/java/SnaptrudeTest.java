import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;


public class SnaptrudeTest {
       public static WebDriver driver;

        @BeforeTest
        public void loadChromeBroswer(){
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver 2");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }

        @Test(priority = 1)
        public void loadurl(){

            //Load the URL https://app.snaptrude.com
            driver.get("https://app.snaptrude.com");

            String url = driver.getCurrentUrl();
            //Assert and check if the url is https(secure)
            try {
                Assert.assertTrue(url.contains("https://"));
            } catch (Throwable e) {
                System.out.println("The site is not HTTP secure");
            }
            System.out.println("The Site is HTTPS secure");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        }

            @Test(priority = 2)
            public void signup() throws InterruptedException {
                //click on Sign Up
                long startsignup = System.currentTimeMillis();
                driver.findElement(By.xpath("//p[contains(text(),'Sign Up here')]")).click();
                long finishpagesignup = System.currentTimeMillis();
                long timeToLoadSignUpPage = finishpagesignup - startsignup;
                System.out.println("Time Taken to Load Sign Up Page : "+timeToLoadSignUpPage+" Milliseconds");

                Thread.sleep(2000);

                //Enter FirstName, Email & Password and click on SignUp
                driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Test QA");
                driver.findElement(By.xpath("//input[@type='email']")).sendKeys("testQA@TestQAmail.com");
                driver.findElement(By.xpath("//input[@type='password']")).sendKeys("testpassword");
                long startprofessionpage = System.currentTimeMillis();
                driver.findElement(By.xpath("//p[contains(text(),'Sign Up')]")).click();
                //Wait implicitly to load the Select Profession
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                long finishprofessionPage = System.currentTimeMillis();
                long timetoloadprofessionpage = finishprofessionPage-startprofessionpage;
                System.out.println("Time Taken to Select Profession Page : "+timetoloadprofessionpage+" Milliseconds");

                //Click on Industry as Other,Role as Designer , Select all options that apply and click on Get Started
                driver.findElement(By.xpath("//span[contains(text(),'Other')]")).click();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
                driver.findElement(By.xpath("//span[contains(text(),'Designer')]")).click();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
                driver.findElement(By.xpath("//span[contains(text(),'Quick modelling with data & BIM')]")).click();
                driver.findElement(By.xpath("//span[contains(text(),'Design collaboratively with remote teams')]")).click();
                driver.findElement(By.xpath("//span[contains(text(),'Improve design communication with clients')]")).click();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
                long startHomepage = System.currentTimeMillis();
                driver.findElement(By.xpath("//p[contains(text(),'Get Started')]")).click();

                //Wait implicitly to load the Snaptrude home page
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                long finishhomepage = System.currentTimeMillis();
                long timetoloadHomepage = finishhomepage-startHomepage;
                System.out.println("Time taken to load Home Page : "+timetoloadHomepage+" Milliseconds");
                Thread.sleep(2000);
            }

            @Test(priority= 3)
            public void Uploadprofilepic() throws InterruptedException, AWTException {
                //Click on Profile icon at the bottom and then click on Account
                driver.findElement(By.cssSelector(".row > *:nth-child(2)")).click();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
                driver.findElement(By.xpath("//div[contains(text(),'Account')]")).click();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


                //Click on Edit profile picture and upload image from my local driver
                driver.findElement(By.xpath("//p[contains(text(),'Edit Profile Picture')]")).click();



                //Copy to clipboard the path of the image on my memory
                StringSelection s = new StringSelection("/Users/jonaksindhudas/Desktop/Screenshots/Screenshot 2022-03-10 at 12.59.02 PM.png");
                Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s,null);

                Robot robot = new Robot();
                //We press command + tab to sent controls to the java app that opens
                Thread.sleep(1000);
                robot.keyPress(KeyEvent.VK_META);
                robot.keyPress(KeyEvent.VK_TAB);
                robot.keyRelease(KeyEvent.VK_META);
                robot.keyRelease(KeyEvent.VK_TAB);


                //Open Goto(Command+shift+G) window in mac using Robot api
                robot.keyPress(KeyEvent.VK_META);
                robot.keyPress(KeyEvent.VK_SHIFT);
                robot.keyPress(KeyEvent.VK_G);
                robot.keyRelease(KeyEvent.VK_META);
                robot.keyRelease(KeyEvent.VK_SHIFT);
                robot.keyRelease(KeyEvent.VK_G);

                //Paste clipboard copied path
                robot.keyPress(KeyEvent.VK_META);
                robot.keyPress(KeyEvent.VK_V);
                robot.keyRelease(KeyEvent.VK_META);
                robot.keyRelease(KeyEvent.VK_V);



                //Press enter in Goto Window and then enter to upload
                robot.keyPress(KeyEvent.VK_ENTER);
                robot.keyRelease(KeyEvent.VK_ENTER);
                robot.keyPress(KeyEvent.VK_ENTER);
                robot.keyRelease(KeyEvent.VK_ENTER);



            }

            @Test(priority = 4)
            public void createaproject() throws InterruptedException {
                Thread.sleep(15000);
                long startnewprojectpage = System.currentTimeMillis();
                //creat a project
                driver.findElement(By.xpath("//p[contains(text(),'Create a Project')]")).click();
                long finishnewprojectpage = System.currentTimeMillis();
                long timetakentoloadnewproject = finishnewprojectpage-startnewprojectpage;
                System.out.println("Time Taken to load New Project : "+timetakentoloadnewproject+" Milliseconds");
                Thread.sleep(4000);

                //Create project by entering Name and measurement as Inches from Dropdown
                driver.findElement(By.xpath("//input[@placeholder='Enter new project name']")).sendKeys("QA Interview");
                driver.findElement(By.cssSelector("div:nth-child(2) > div > div > img")).click();
                List<WebElement> options = driver.findElements(By.cssSelector("div:nth-child(2) > div > div > img"));
                String Units = "Inches";
                for (WebElement option : options) {
                    if (option.getText().equals(Units)) {
                        option.click();
                        return;
                    }
                }
                //click on create
                driver.findElement(By.cssSelector("div:nth-child(3) > div p")).click();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
                Thread.sleep(6000);
            }

            @Test(priority = 5)
            public void drawImage() throws InterruptedException, AWTException {

                //Wait for the 'Show you around' Sreen to appear
                WebDriverWait wait = new WebDriverWait(driver, 30);
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".chmln-action > strong")));
                driver.findElement(By.cssSelector(".chmln-action > strong")).click();
                //Close the tutorial
                driver.findElement(By.cssSelector(".chmln-close")).click();

                //Click on draw and select pencil
                driver.findElement(By.xpath("//span[contains(text(),'Draw')]")).click();
                driver.findElement(By.cssSelector("*:nth-child(1) > .sc-uojGG > .topMenuIcon")).click();


                Robot robot = new Robot();
                //Draw a triangle
                robot.mouseMove(200, 200);
                robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                robot.mouseMove(400, 200);
                robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
                robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                robot.mouseMove(400, 400);
                robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
                robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                robot.mouseMove(200, 400);
                robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
                robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                robot.mouseMove(200, 200);
                robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
                robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                robot.keyRelease(InputEvent.BUTTON1_DOWN_MASK);
                robot.delay(2000);
                Thread.sleep(2000);

                //Press L to exit draw tool
                robot.keyPress(KeyEvent.VK_L);
                robot.keyRelease(KeyEvent.VK_L);

                Thread.sleep(2000);

                //Press L again to draw
                robot.keyPress(KeyEvent.VK_L);
                robot.keyRelease(KeyEvent.VK_L);

                Thread.sleep(5000);

                //To draw a quadrilateral
                robot.mouseMove(420, 420);
                robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                robot.mouseMove(700, 400);
                robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
                robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                robot.mouseMove(500, 700);
                robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
                robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                robot.mouseMove(300, 700);
                robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
                robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                robot.mouseMove(420, 420);
                robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
                robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                robot.keyRelease(InputEvent.BUTTON1_DOWN_MASK);
                Thread.sleep(4000);

                //Click on Snaptrude Icon
                driver.findElement(By.xpath("//a[@href ='/dashboard']")).click();

                Thread.sleep(7000);
            }

            @Test(priority = 6)
            public void calculateStaticSourceInCanvas() throws InterruptedException {

                    driver.findElement(By.xpath("//p[contains(text(),'Create a Project')]")).click();
                    driver.findElement(By.xpath("//input[@placeholder='Enter new project name']")).sendKeys("Check Sources");
                    driver.findElement(By.cssSelector("div:nth-child(2) > div > div > img")).click();
                    List<WebElement> options = driver.findElements(By.cssSelector("div:nth-child(2) > div > div > img"));
                    String Units = "Inches";
                    for (WebElement option : options) {
                        if (option.getText().equals(Units)) {
                            option.click();
                            return;
                        }
                    }
                    driver.findElement(By.cssSelector("div:nth-child(3) > div p")).click();
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
                    Thread.sleep(2000);

                    List <WebElement> elements =driver.findElements(By.xpath("//*[contains(@src,'/static/')]"));
                    System.out.println("The Number of Static Sources in the draw page is : "+elements.size());
                    driver.findElement(By.xpath("//a[@href ='/dashboard']")).click();
                    Thread.sleep(5000);

            }


            @AfterTest
            public void closeBrowser()
            {
                driver.quit();
            }
        }


