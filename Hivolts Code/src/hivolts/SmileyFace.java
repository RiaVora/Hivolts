package hivolts;
import java.util.Random;

public class SmileyFace {
	
	//Holds the user's y and x coordinates
	static int x;
	static int y;
	
	//Sets the position of the user at the beginning of the game 
	public static void set(String[][] ps) {
		
		//Random row array number
		int r = randInt(1, 10);
		
		//Random column array number
		int c = randInt(1, 10);
		
		//Runs again if the position is taken, adds S to the position array
		if (ps[r][c].equals("x")) {
			ps[r][c] = "S";
			y = r;
			x = c;
		} else {
			set(ps);
		}
	}
	
	//Used in the jump() method, resets position of SmileyFace in random location
	//But if lands on a fence or Mho, SmileyFace dies = game is over
	public static boolean reset(String[][] ps) {

		//Random row array number
		int r = randInt(1, 10);

		//Random column array number
		int c = randInt(1, 10);

		//Checks the new random position of the user to ensure it is either empty or an Mho. If not, it runs the method again
		if (ps[r][c].equals("x")) {
			ps[y][x] = "x";
			y = r;
			x = c;
			ps[y][x] = "S";
			return true;
		} else if (ps[r][c].equals("F")) {
			return reset(ps);
		} else {
			return false;
		}
	}
	

	//returns a random value between specified bounds
	private static int randInt(int min, int max) {
		Random rand = new Random();
		int retval = rand.nextInt((max - min) + 1) + min;
		return retval;
	}
	
	public static void swap(int ymove, int xmove, String [][] ps) {
		ps[y][x] = "x";
		y += ymove;
		x += xmove;
		ps[y][x] = "S";
	}
	
	public static boolean move(int ymove, int xmove, String [][] ps) {
		boolean result = true;
		if (ps[y+ymove][x+xmove].equals("x")) {
			swap(ymove, xmove, ps);
			result = true;							
		} else {
			result = false;
		}
		
		return result;
	}
}