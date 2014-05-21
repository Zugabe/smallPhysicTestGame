
public class Rocket {
	
	static int x = -300;
	static int y = 300;
	
	public Rocket(){
		
	}

	public static int getX() {
		return x;
	}

	public void setX(int x) {
		Rocket.x = x;
	}

	public static int getY() {
		return y;
	}

	public void setY(int y) {
		Rocket.y = y;
	}

	public static void move() {
		if(x < 1000){																
			x = x + 3;															//let string move in x direction +10
		}else{																	
			x = -300;																//string starts at x 0 again if moved out of surface
		}
	}
	

}
