//
//package test.day22;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;
//import org.openqa.selenium.remote.DesiredCapabilities;
//
///**
// * @author luxi
// * @date 2021/10/25 0:39
// *
// *面试题：1.selenium webdriver 的通讯原理
// *          2.http通讯协议
// *
// *      封装打开所有浏览器的方法
// *      browserName 浏览器名
// *
// * /
//public class FirstWebAutoTest {
//    public static void main(String[] args) {
//    WebDriver driver1 = openBrowser("Chrome");
//    //WebDriver driver2 = openBrowser("firefox");
//    //WebDriver driver3 = openBrowser("ie");
//    driver1.get("https://www.baidu.com");
//    }
///*   chromeDriver,FirefoxDriver,都是WebDriver的子类
//    所以这里通过WebDriver接受* /
//    public static WebDriver openBrowser(String browserName) {
//        WebDriver webDriver = null;
//        if ("chrome".equalsIgnoreCase(browserName)) {
//            System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
//            webDriver = new ChromeDriver();
//        }else if("ie".equalsIgnoreCase(browserName)){
//            DesiredCapabilities capabilities = new DesiredCapabilities();
//            capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
//            capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
//            System.setProperty("webdriver.ie.driver", "src\\test\\resources\\IEDriverServer.exe");
//            webDriver = new InternetExplorerDriver(capabilities);
//
//        }else if("firefox".equalsIgnoreCase(browserName)){
//            System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\geckodriver.exe");
//            webDriver = new FirefoxDriver();
//        }
//        return webDriver;
//    }
//}
//
