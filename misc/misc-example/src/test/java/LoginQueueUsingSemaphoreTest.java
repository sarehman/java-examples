import org.example.LoginQueueUsingSemaphore;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

public class LoginQueueUsingSemaphoreTest {
    @Test
    public void givenLoginQueue_whenReachLimit_thenBlocked() {
        int slots = 10;
        LoginQueueUsingSemaphore loginQueue;
        try (ExecutorService executorService = Executors.newFixedThreadPool(slots)) {
            loginQueue = new LoginQueueUsingSemaphore(slots);
            IntStream.range(0, slots).parallel()
                    .forEach(user -> executorService.execute(loginQueue::tryLogin));
            executorService.shutdown();
        }

        assertEquals(0, loginQueue.availableSlots());
        assertFalse(loginQueue.tryLogin());
    }

    @Test
    public void givenLoginQueue_whenLogout_thenSlotsAvailable() {
        int slots = 10;
        LoginQueueUsingSemaphore loginQueue;
        try (ExecutorService executorService = Executors.newFixedThreadPool(slots)) {
            loginQueue = new LoginQueueUsingSemaphore(slots);
            IntStream.range(0, slots)
                    .forEach(user -> executorService.execute(loginQueue::tryLogin));
            executorService.shutdown();
        }
        assertEquals(0, loginQueue.availableSlots());
        loginQueue.logout();
        loginQueue.logout();

        assertTrue(loginQueue.availableSlots() > 0);
        assertTrue(loginQueue.tryLogin());
    }
}
