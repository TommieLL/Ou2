
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Deque;
import java.util.ArrayDeque;

import static java.util.Arrays.asList;

/**
 * Created by c15tlg on 2016-04-19.
 */
public class MemoryRobot extends Robot {
    private Deque<Position> direction = new ArrayDeque<>();
    private Set<Position> beenBefore = new HashSet<>();

    /**
     * Instantiates a new MemoryRobot.
     *
     * @param maze the maze
     */
    public MemoryRobot(Maze maze) {
        super(maze);
    }

    /**
     * Visit any unvisited neighbor.
     *
     * @return false if there were no unvisited
     *      neighbors
     */
    private boolean visitNeighbors() {
        for (Position neighbor: getNeighboringPositions()) {
            if (!beenBefore.contains(neighbor) && maze.isMovable(neighbor)) {
                beenBefore.add(neighbor);

                // If we find a new unvisited neighbor
                // after a step back, we should add this
                // position to avoid undercounting.
                boolean didStepBack = !getCurrentPosition().equals(direction.peek());
                if (didStepBack) direction.push(getCurrentPosition());

                direction.push(neighbor);
                setCurrentPosition(neighbor);
                return true;
            }
        }
        return false;
    }
    /**
     * Gets neighboring positions.
     *
     * @return neighboring positions
     */
    private List<Position> getNeighboringPositions() {
        Position p = getCurrentPosition();
        return new ArrayList<>(asList(p.getPosToSouth(), p.getPosToEast(), p.getPosToNorth(), p.getPosToWest()));
    }

    /**
     * Step back along the path taken.
     */
    private void goBack() {
        // The top of "path" is the current position when
        // we switch from going forward to going
        // backwards. We should then pop this position
        // to avoid overcounting.

        if (getCurrentPosition().equals(direction.peek())){
            direction.pop();
        }

        if (!direction.isEmpty()){
            setCurrentPosition(direction.pop());
        }
    }


    /**
     * Moves one step in unspecified direction,
     * stepping back once each neighboring position
     * is visited.
     */
    public final void move() {
        if (!visitNeighbors()) {
            goBack();
        }
    }
}