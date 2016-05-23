import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by Tommie on 2016-05-20.
 */
public class MazeTest {
    private Maze maze;

    /**
     * Sets up.
     */
    @Before
    public void setUp() throws FileNotFoundException {
        String mazeData =
                "*S**********\n" +
                "*          *\n" +
                "* ******** *\n" +
                "*    *   * *\n" +
                "*** ** * * *\n" +
                "*      * * *\n" +
                "********G***\n";

        Reader reader = new StringReader(mazeData);
        maze = new Maze(reader);
    }

    @Test
    public void testIsMovable() throws FileNotFoundException {
        assertTrue(maze.isMovable(new Position(1,1)));
    }

    @Test
    public void testIsGoal(){
        assertTrue(maze.isGoal(new Position(8,6)));
    }

    @Test
    public void testGetStartPosition(){
        assertEquals(maze.getStartPosition(), new Position(1,0));
    }
}
