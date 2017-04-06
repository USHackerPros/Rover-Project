import java.util.Scanner;

class Plateau {
private int size;
    public Plateau() {
        Scanner in = new Scanner(System.in);
        System.out.println("Plateau Grid Size Input:");
        size=in.nextInt();
        in.nextLine();
    }
    public Plateau(int sz){
        size=sz;
    }
    public Cell getNeighbour(MarsRover.Direction dir,Cell c){
        Cell neighbour = null;
        switch (dir) {
            case N:
                neighbour=new Cell(c.x,c.y+1);
                break;
            case W:
                neighbour=new Cell(c.x-1,c.y);
                break;
            case S:
                neighbour=new Cell(c.x,c.y-1);
                break;
            case E:
                neighbour=new Cell(c.x+1,c.y);
                break;
        }
        if((neighbour.x>=0)&&(neighbour.y>=0)&&(neighbour.x<size)&&(neighbour.y<size))
            return neighbour;
        return null;
    }
}