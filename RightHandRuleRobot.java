import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static java.util.Arrays.asList;
/**
 * Created by c15tlg on 2016-04-19.
 */
public class RightHandRuleRobot extends Robot {
    private Position lastPosition = getCurrentPosition();

    /**
     * Instantiates a new RightHandRuleRobot.
     *
     * @param maze the maze
     */
    public RightHandRuleRobot(Maze maze) {
        super(maze);
    }

    /**
     * Moves one step in order:
     * right, forward, left, backward,
     * choosing the first of which is a valid
     * movable position.
     */
    public final void move() {
        for (Position neighbor: getNeighboringPositions()) {
            if (maze.isMovable(neighbor)) {
                lastPosition = getCurrentPosition();
                setCurrentPosition(neighbor);
                return;
            }
        }
    }

    /**
     * Gets neighboring positions.
     *
     * @return neighboring positions
     */
    private List<Position> getNeighboringPositions() {
        Position p = getCurrentPosition();

        // This list and the number of rotations
        // are tightly coupled.
        List<Position> neighbors = new ArrayList<>(asList(p.getPosToEast(), p.getPosToNorth(), p.getPosToWest(),
                p.getPosToSouth()));

        int rotate = 0;
        if (lastPosition.equals(p.getPosToWest()))
        {
            rotate = 1;
        }
        else if (lastPosition.equals(p.getPosToNorth())){
            rotate =  2;
        }
        else if (lastPosition.equals(p.getPosToEast())){
            rotate = 3;
        }

        Collections.rotate(neighbors, rotate);
        return neighbors;
    }
}
