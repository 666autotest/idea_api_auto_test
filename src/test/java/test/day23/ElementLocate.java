//
//package test.day23;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import sun.security.util.ByteArrayLexOrder;
//
//import java.util.List;
//
///**
// * @author luxi
// * @date 2021/10/25 0:39
// * 8大元素定位
// * /
//public class ElementLocate {
//    public static void main(String[] args) {
//        WebDriver driver = openBrowser("chrome");
//        driver.get("https://www.baidu.com");
//        //1.id定位
///*      WebElement webElement1 = driver.findElement(By.id("kw"));
//        webElement1.sendKeys("柠檬班");
//        WebElement webElement2 = driver.findElement(By.id("su"));
//        webElement2.click();* /
//        //采用链式调用改进
///*      driver.findElement(By.id("kw")).sendKeys("柠檬班");
//        driver.findElement(By.id("su")).click();* /
//
//        //2.name定位
///*      WebElement webElement1 = driver.findElement(By.name("wd"));
//        webElement1.sendKeys("柠檬班");
//        WebElement webElement2 =driver.findElement(By.id("su"));
//        webElement2.click();* /
//        //driver.findElement(By.name("wd")).sendKeys("宁模班");
//        //driver.findElement(By.id("su")).click();
//
//        //3.tagName:标签名定位(一个页面的标签太多定位不到元素，基本不用)
///*        List<WebElement> allElements = driver.findElements(By.tagName("a"));
//        System.out.println(allElements.size());* /
//
//        //4.className定位
//        //driver.findElement(By.className("s_ipt")).sendKeys("柠檬班");
//
//        //5.linkText 文本定位 根据链接元素的文本值定位.(仅限超链接元素有效)
//        //driver.findElement(By.linkText("更多")).click();
//
//        //6.partialLinkText 超链接文本定位 根据超链接元素的文本值(部分)定位
//        // driver.findElement(By.partialLinkText("hao")).click();
//
//        //=======================css选择器定位============================
//        //7-1.根据标签名定位：By.cssSelector("input");
//        //List<WebElement> allElements = driver.findElements(By.cssSelector("a"));
//
//        //7-2.根据id定位:By.cssSelector("#id");
///*      driver.findElement(By.cssSelector("#kw")).sendKeys("柠檬班");
//        driver.findElement(By.id("su")).click();
//* /
//        //7-3.根据className(样式名)属性，.class形式:By.cssSelector(".样式名");
//        // driver.findElement(By.cssSelector(".s_ipt")).sendKeys("柠檬班");
//
//        //7-4.单属性选择By.cssSelector("标签名[属性名]='属性值'");中括号里的属性内容可通过条件赛选
//        //driver.findElement(By.cssSelector("input[autocomplete=\"off\"]")).sendKeys("java");
//        //driver.findElement(By.cssSelector("input[autocomplete='off']")).sendKeys("java");
//        driver.findElement(By.cssSelector("input[id='kw'][name='wd'][class='s_ipt']")).sendKeys("java");
//
//        //7-5.多元素选择定位
//        driver.findElement(By.cssSelector("input[maxlength='255']")).sendKeys("Hello");
//
//        //8.xpath绝对路径定位：绝对路径以单引号表示，而且是让解析引擎从文档的根节点开始解析，也就是html这个节点下开始解析
//        //样式：/html/body/div/[z]/div/form/div[5]/button
//        //
//        //8-1.xpath定位：相对路径定位：标签名[@属性名='值']
//        driver.findElement(By.xpath("//*[@id=\"kw\"]")).sendKeys("123456");
//
//        //8-2.文本定位：//标签名[@text()='值']
//
//    }
//
//    public static WebDriver openBrowser(String browserName) {
//        WebDriver webDriver = null;
//        if ("chrome".equalsIgnoreCase(browserName)) {
//            System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
//            webDriver = new ChromeDriver();
//        } else if ("ie".equalsIgnoreCase(browserName)) {
//            DesiredCapabilities capabilities = new DesiredCapabilities();
//            capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
//            capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
//            System.setProperty("webdriver.ie.driver", "src\\test\\resources\\IEDriverServer.exe");
//            webDriver = new InternetExplorerDriver(capabilities);
//
//        } else if ("firefox".equalsIgnoreCase(browserName)) {
//            System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\geckodriver.exe");
//            webDriver = new FirefoxDriver();
//        }
//        return webDriver;
//    }
//}
//
