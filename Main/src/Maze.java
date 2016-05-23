import java.io.File;
import java.io.FileNotFoundException;
import java.io.Reader;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Collection;

/**
 * Created by c15tlg on 2016-04-19.
 */
public class Maze
{
    private Position start;
    private Set<Position> goal = new HashSet<>();
    private Set<Position> movable = new HashSet<>();
    private String displayString;
    private final static char START = 'S', GOAL = 'G', MOVABLE = ' ';


    /**
     * @
     */
    public Maze(Reader input) throws FileNotFoundException {
        StringBuilder maze = new StringBuilder();
        Scanner scanner = new Scanner(input);
        List<Position> startPositions = new ArrayList<>();

        // Add each line to displayString and
        // parse each char into appropriate type.
        for (int y = 0; scanner.hasNextLine(); y++) {
            String line = scanner.nextLine().toUpperCase();
            maze.append(line).append(System.lineSeparator());

            for (int x = 0; x < line.length(); x++) {
                Collection<Position> c = null;

                switch (line.charAt(x)) {
                    case START: c = startPositions; break;
                    case GOAL: c = goal; break;
                    case MOVABLE: c = movable; break;
                }

                if (c != null){
                    c.add(new Position(x, y));
                }
            }
        }

        scanner.close();

        if (startPositions.size() !=1){
            throw new IllegalArgumentException("Maze can only have one start position!");
        }
        if (goal.isEmpty()){
            throw new IllegalArgumentException("Maze must have at least one goal position!");
        }

        displayString = maze.toString();
        start = startPositions.get(0);
        movable.addAll(goal);
    }



    /*
     * @param p
     * @return
     */
    public boolean isMovable(Position p)
    {
       return movable.contains(p);
    }


    /**
     * @param p
     * @return
     */
    public boolean isGoal(Position p) {

       return goal.contains(p);

    }

    /**
     * @return
     */
    public Position getStartPosition() {
        return start;
    }

    @Override
    public String toString(){
        return displayString;
    }
}

