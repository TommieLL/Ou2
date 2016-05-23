/**
 * Created by c15tlg on 2016-04-19.
 */
public abstract class Robot{
    private Position position;
    public Maze maze;

    /**
     * @param maze
     */
    public Robot(Maze maze)
    {
        this.maze = maze;

        this.position = maze.getStartPosition();

    }

    public abstract void move();


    /**
     * @return
     */
    public Position getCurrentPosition()
    {
        return position;
    }

    /**
     * @param newPosition
     */
    protected void setCurrentPosition(Position newPosition)
    {
        position = newPosition;
    }

    /**
     * @return
     */
    public boolean hasReachedGoal()
    {
        return maze.isGoal(position);
    }

}

