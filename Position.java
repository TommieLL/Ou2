/**
 * Created by c15tlg on 2016-04-19.
 */
public class Position {
    private int x;

    private int y;


    /**
     * @param x
     * @param y
     */
    public Position(int x, int y) {
        this.x = x;
        this.y = y;


    }

    /**
     * @return
     */
    public int getX() {
        return x;
    }

    /**
     * @return
     */
    public int getY() {
        return y;
    }

    /**
     * @return
     */
    public Position getPosToSouth() {


        return new Position(x, y+1);
    }

    /**
     * @return
     */
    public Position getPosToNorth() {
        return new Position(x,y-1);
    }

    /**
     * @return
     */
    public Position getPosToWest() {

        return new Position(x-1,y);
    }

    /**
     * @return
     */
    public Position getPosToEast() {

        return new Position(x+1,y);
    }

    /**
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position)) return false;

        Position position = (Position) o;

        if (x != position.x) {
            return false;
        }
        return y == position.y;

    }

    /**
     * @return
     */
    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

}