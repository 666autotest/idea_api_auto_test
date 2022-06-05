//
//package test.day22;
//
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;
//import org.openqa.selenium.remote.DesiredCapabilities;
//
///**
// * @author luxi
// * @date 2021/10/25 0:39
// * /
//public class FirstWebAuto {
//    public static void main(String[] args) {
//        //openChrome();
//        //openFirefox();
//        openIE();
//
//    }
//
//    public static void openChrome() {
//        /*报错(找不到驱动位置)：The path to the driver executable must be set by the webdriver.chrome.driver system property;* /
//        //1.设置驱动位置，让代码知道你的驱动在哪里(报错解决方案)
//        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
//        //2.打开浏览器
//        ChromeDriver driver = new ChromeDriver();
//        //3.输入对应的网址
//        driver.get("https://www.baidu.com");
//    }
//
//    public static void openFirefox() {
//        //异常二： The path to the driver executable must be set by the webdriver.gecko.driver system property;
//        //解决方案：
//        System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\geckodriver.exe");
//        //1、打开浏览器
//        FirefoxDriver firefoxDriver = new FirefoxDriver();
//        //2、访问对应的网址
//        firefoxDriver.get("https://www.baidu.com");
//    }
//
//    public static void openIE() {
//        //取消IE安全设置（忽略IE的Protected Mode的设置）
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
//        //忽略浏览器缩放设置
//        capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
//        //异常一：The path to the driver executable must be set by the webdriver.ie.driver system property
//        //解决方案：
//        System.setProperty("webdriver.ie.driver", "src\\test\\resources\\IEDriverServer.exe");
//        //1、打开浏览器
//        InternetExplorerDriver ieDriver = new InternetExplorerDriver(capabilities);
//        //2、访问对应的网址
//        ieDriver.get("https://www.baidu.com");
//
//    }
//}
//
