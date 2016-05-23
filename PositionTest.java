import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Tommie on 2016-05-20.
 */

public class PositionTest {

    @Test
    public void testGetX(){
        Position pos = new Position(8,8);
        assertEquals(8,pos.getX());
    }


    @Test
    public  void testGetY(){
        Position pos = new Position(8,8);

        assertEquals(pos.getPosToSouth(), 8);

    }

    @Test
    public void testGetPositionToSouth(){
        Position pos = new Position(8,8);
        Position temp = new Position(8,9);
        assertEquals(pos.getPosToSouth(), temp);
    }

    @Test
    public void testGetPositionToNorth(){
        Position pos = new Position(8,8);
        Position temp = new Position(8,7);
        assertEquals(pos.getPosToNorth(), temp);

    }

    @Test
    public void testGetPositionToWest(){
        Position pos = new Position(8,8);
        Position temp = new Position(7,8);
        assertEquals(pos.getPosToWest(),temp);
    }

    @Test
    public void testGetPositionToEast(){
        Position pos = new Position(8,8);
        Position temp = new Position(9,8);
        assertEquals(pos.getPosToEast(), temp);

    }

}
