import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.*;

class RobotTest {

    Robot buddy = new Robot("buddy");

    @Test
    public void getNameTest() {
        assertEquals("buddy", buddy.getName());
    }

    @Test
    public void isNotWorkingTest() {
        assertFalse(buddy.isWorking());
    }

    @Test
    public void isWorkingTest() {
        buddy.talktoRobot();
        assertTrue(buddy.isWorking());
    }

    @Test
    public void getWorkingMsgTest() {
        buddy.talktoRobot();
        assertEquals("I am in working mode", buddy.getWorkingMsg());
    }

    @Test
    @DisplayName("getWorkingMsgFail Catch the exception")
    public void getWorkingMsgFail() {
        assertThrows(IllegalStateException.class, () ->
                buddy.getWorkingMsg());
    }

    @Test
    public void testName_Fail() {
        assertThrows(IllegalArgumentException.class, () -> {
            Robot chuck = new Robot("");
        });


    }

    @Test
    void timeoutExceeded() {
        assertTimeout(ofMillis(1000), () -> {
            buddy.waitTillWorking();
        });
    }
}