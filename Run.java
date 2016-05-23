import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by Tommie on 2016-05-23.
 */
public class Run {
    public static void main(String[] args) throws FileNotFoundException {
        Maze maze = new Maze(new FileReader(args[0]));
        MemoryRobot memRobot = new MemoryRobot(maze);

        RightHandRuleRobot rightRobot = new RightHandRuleRobot(maze);


        System.out.println(maze);
        while(!rightRobot.hasReachedGoal()){
            rightRobot.move();

        }
        System.out.println("yey");


        while(!memRobot.hasReachedGoal()){
            memRobot.move();
        }
        System.out.println("hurray");

        }

    }

