package athleticli.data.activity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CycleTest {

    private static final String CAPTION = "Cycling in the afternoon";
    private static final int DURATION = 133;
    private static final int DISTANCE = 40460;
    private static final int ELEVATION = 101;
    private static final LocalDateTime DATE = LocalDateTime.of(2023, 10, 7, 14, 0);
    private Cycle cycle;

    @BeforeEach
    public void setUp() {
        cycle = new Cycle(CAPTION, DURATION, DISTANCE, DATE, ELEVATION);
    }

    @Test
    public void calculateAverageSpeed() {
        double expected = 18.25;
        double actual = cycle.calculateAverageSpeed();
        assertEquals(expected, actual, 0.005);
    }

    @Test
    public void testToString() {
        String expected = "[Cycle] Cycling in the afternoon | Distance: 40.46 km | Speed: 18.25 km/h | Time: 2h 13m | "
                + "\"October 7, 2023 at 2:00 PM\"";
        assertEquals(expected, cycle.toString());
    }
}