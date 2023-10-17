package athleticli.commands.diet;

import athleticli.data.Data;
import athleticli.data.diet.DietGoal;
import athleticli.exceptions.AthletiException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DeleteDietGoalCommandTest {

    private Data data;
    private DietGoal dietGoalFats;
    private ArrayList<DietGoal> filledInputDietGoals;


    @BeforeEach
    void setUp() {
        data = new Data();

        dietGoalFats = new DietGoal("fats", 10000);

        filledInputDietGoals = new ArrayList<>();
        filledInputDietGoals.add(dietGoalFats);
    }

    @Test
    void execute_deleteOneItemFromFilledDietGoalList_expectCorrectMessage() {
        try {
            SetDietGoalCommand setDietGoalCommand = new SetDietGoalCommand(filledInputDietGoals);
            setDietGoalCommand.execute(data);
            System.out.println(data.getDietGoals());
            DeleteDietGoalCommand deleteDietGoalCommand = new DeleteDietGoalCommand(1);
            String[] expectedString = new String[]{"The following goal has been deleted:\n", "fats intake progress: " +
                    "(0/10000)\n",};
            assertArrayEquals(expectedString, deleteDietGoalCommand.execute(data));
        } catch (AthletiException e) {
            fail(e);
        }
    }

    @Test
    void execute_deleteOneItemFromEmptyDietGoalList_expectAthletiException() {
        DeleteDietGoalCommand deleteDietGoalCommand = new DeleteDietGoalCommand(100);
        assertThrows(AthletiException.class, () -> deleteDietGoalCommand.execute(data));
    }
}