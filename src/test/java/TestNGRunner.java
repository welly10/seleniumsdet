import org.testng.TestNG;
import java.util.List;

public class TestNGRunner {
    public static void main(String[] args) {
        TestNG testng = new TestNG();
        testng.setTestSuites(List.of("testng.xml")   // relative to project root
        );
        testng.run();
    }
}