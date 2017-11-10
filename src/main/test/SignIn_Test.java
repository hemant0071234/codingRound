import com.tests.pages.login.SignIn;
import com.tests.setup.Setup;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SignIn_Test {
    @BeforeTest
    public void setupEnvironment(){
        new Setup().startBrowser();
    }

    @Test
    public void signInTestWithoutCrdentials() throws InterruptedException {
        SignIn signIn = new SignIn();

        signIn.signIn("","");



    }

}
