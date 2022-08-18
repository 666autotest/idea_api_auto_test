package api_auto_test_java41.day06;

/**
 * @author qq音乐
 * @date 2022/6/28 - 17:37
 */
public class EmployeeTest {
    public static void main(String[] args) {

        Coder coder = new Coder();
        coder.work();
        coder.sleep();
        Tester tester = new Tester();
        tester.work();
        tester.sleep();
        Manager manager = new Manager();
        manager.work();
        manager.sleep();



        method(coder);
        method(tester);
        method(manager);

        //Employee employee = coder;
        //Employee employee = tester;
        //Employee employee = manager;

    }

    public static void method(Employee employee) {
        employee.work();
        employee.sleep();
    }
}
