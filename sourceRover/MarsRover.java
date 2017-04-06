import java.util.Scanner;

public class MarsRover {
private String inst_set;
private Plateau p;
private Cell currentLocation;
public enum Direction{N,S,E,W}
    Direction dir;
    public MarsRover(Plateau p1, int x, int y, Direction dir, String instSet) {
        p=p1;
        inst_set=instSet;
        this.dir=dir;
        currentLocation=new Cell(x, y);
    }
public MarsRover(){}
	private void executeInst() {
        int i = 0;
        while (i < inst_set.length()) {
            char inst = inst_set.charAt(i++); //get each inst separately as a character
            if (inst == 'M') {
                Cell nextCell = p.getNeighbour(dir, currentLocation);
                if (nextCell != null)
                    currentLocation = nextCell;
                else
                    System.out.println("In-valid Bearing Input");
            }
            if (inst == 'L' || inst == 'R') {
                dir = setDirection(dir, inst);
            }
        }
    }
public void showCurrentLocation(){
System.out.println("Current Cell is:");
System.out.print(currentLocation.x);
System.out.print("\t"+currentLocation.y);
System.out.print("\t"+dir+"\n");
    }
public Direction setDirection(Direction dir, char inst) {
        if(inst=='L') {
            switch (dir) {
                case N:
                    dir = Direction.W;
                    break;
                case W:
                    dir = Direction.S;
                    break;
                case S:
                    dir = Direction.E;
                    break;
                case E:
                    dir = Direction.N;
                    break;
            }
        }
        else if(inst=='R'){
            switch (dir) {
                case N:
                    dir = Direction.E;
                    break;
                case W:
                    dir = Direction.N;
                    break;
                case S:
                    dir = Direction.W;
                    break;
                case E:
                    dir = Direction.S;
                    break;
            }
        }
        return dir;
    }
public static void main(String... a){
        Plateau p1=new Plateau();
        Scanner in = new Scanner(System.in);
        int x,y;
        String instSet;
        String dir;
        System.out.println("Rover Heading Input:");
        dir=in.nextLine();
        System.out.println("Rover X-Axis Location Input:");
        x=in.nextInt();
        in.nextLine();
        System.out.println("Rover Y-Axis Location Input:");
        y=in.nextInt();
        in.nextLine();
        System.out.println("Enter the Instructions\t");
        instSet=in.nextLine();
        MarsRover mr1=new MarsRover(p1,x,y,Direction.valueOf(dir),instSet);
        mr1.executeInst();
        mr1.showCurrentLocation();
    }
}