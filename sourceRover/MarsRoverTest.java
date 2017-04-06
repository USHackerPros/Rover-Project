import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MarsRoverTest {
    MarsRover.Direction DirIp;
    Plateau p = new Plateau(5);
    MarsRover m = new MarsRover();
    @Test
    public void testRotation() {
        //Assertion For LeftRotation.
        DirIp= MarsRover.Direction.N;
        assertEquals(MarsRover.Direction.W, m.setDirection(DirIp, 'L'));

        DirIp= MarsRover.Direction.W;
        assertEquals(MarsRover.Direction.S, m.setDirection(DirIp, 'L'));

        DirIp= MarsRover.Direction.S;
        assertEquals(MarsRover.Direction.E, m.setDirection(DirIp, 'L'));

        DirIp= MarsRover.Direction.E;
        assertEquals(MarsRover.Direction.N, m.setDirection(DirIp, 'L'));

        //Assertion for RightRotation

        DirIp= MarsRover.Direction.N;
        assertEquals(MarsRover.Direction.E, m.setDirection(DirIp, 'R'));

        DirIp= MarsRover.Direction.W;
        assertEquals(MarsRover.Direction.N, m.setDirection(DirIp, 'R'));

        DirIp= MarsRover.Direction.S;
        assertEquals(MarsRover.Direction.W, m.setDirection(DirIp, 'R'));

        DirIp= MarsRover.Direction.E;
        assertEquals(MarsRover.Direction.S, m.setDirection(DirIp, 'R'));

    }
    @Test
    public void testCheckMovement(){
        //Impossible Moves
        for(int i=0;i<5;i++) {
            DirIp = MarsRover.Direction.W;
            assertEquals(null,p.getNeighbour(DirIp, new Cell(0,i)));
            DirIp=MarsRover.Direction.S;
            assertEquals(null,p.getNeighbour(DirIp,new Cell(i,0)));
        }
        for(int i=0;i<5;i++){
            DirIp=MarsRover.Direction.N;
            assertEquals(null,p.getNeighbour(DirIp,new Cell(i,4)));
            DirIp=MarsRover.Direction.E;
            assertEquals(null,p.getNeighbour(DirIp,new Cell(4,i)));
        }
        //Take a cell from the center and check its moves

        Cell centerCell= new Cell(2,3);
        DirIp=MarsRover.Direction.E;

        Cell next=p.getNeighbour(DirIp,centerCell);
        assertEquals(3,next.x);
        assertEquals(3,next.y);

        DirIp=MarsRover.Direction.N;
        next=p.getNeighbour(DirIp,centerCell);
        assertEquals(2,next.x);
        assertEquals(4,next.y);

        DirIp=MarsRover.Direction.W;
        next=p.getNeighbour(DirIp,centerCell);
        assertEquals(1,next.x);
        assertEquals(3,next.y);

        DirIp=MarsRover.Direction.S;
        next=p.getNeighbour(DirIp,centerCell);
        assertEquals(2,next.x);
        assertEquals(2,next.y);
    }
}