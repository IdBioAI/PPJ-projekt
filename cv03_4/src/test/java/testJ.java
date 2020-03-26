import app.assignments.message.PingMessage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class testJ {

    private PingMessage ping;

    @Before
    public void setUp() {
        ping = new PingMessage();
    }

    @Test
    public void Test1() {
        Assert.assertEquals("ping", ping.getSender());
    }

    @Test
    public void Test2() {
        Assert.assertEquals("pong", ping.getRecipient());
    }

    @Test
    public void Test3() {
        Assert.assertEquals("priklad chyby", ping.getText());
    }

}
