import java.awt.Color;															//import bunch of libraries
import java.awt.Graphics;
import javax.swing.JPanel;

public class PaintSurface extends JPanel {

	private static final long serialVersionUID = 1L;
	
	int x = Rocket.getX();																	
	int y = Rocket.getY();
	int ovalX;
	int ovalY;
	boolean printedFirstTime = true;
	int ovalXFinal[] = new int[50];
	int ovalYFinal[] = new int[50];
	long fps = Start.getFps();
	
	public PaintSurface(){														//class PaintSurface starts here
		for (int i=0;i<50;i++){													//generate 50 random positions for stars /w arrays
			ovalXFinal[i] = (int) (Math.random()*1000);							//random X coordinate not bigger than 1000
			ovalYFinal[i] = (int) (Math.random()*800);							//random Y coordinate not bigger than 800
		}
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);												//Clear Surface

		g.setColor(Color.BLACK);
		g.fillRect(0,0,1000,800);												//Background Color 
		
		g.setColor(Color.WHITE);
		
		for (int i=0;i<50;i++){													//Stars Background repeat 50x (50 stars at the same time)
			g.fillOval(ovalXFinal[i],ovalYFinal[i],2,2);						//draw 1 star
			ovalXFinal[i] = ovalXFinal[i]+2;									//let stars move 10 in x direction (coordinates are bit different in java, try google to show you)
			ovalYFinal[i] = ovalYFinal[i]-2;									//let stars move up 10 in y direction
			if(ovalXFinal[i]>1000){												//new X variable for star if moved out of surface in X direction
				ovalXFinal[i] = (int) (Math.random()*100);
			}
			if(ovalYFinal[i]<0){												//new X variable for star if moved out of surface in Y direction
				ovalYFinal[i] = (int) (Math.random()*(800-600))+600;			//syntax for math.random: math.random()*(highesValue-lowestValue)+lowestValue to get a range in random numbers
			}
		}																		//Stars Background End
		
		x = Rocket.getX();																	
		y = Rocket.getY();
		g.drawString(" >===== I am a rocket,someday ===>",x,y);				//draw random string on surface
		
		
		g.setColor(Color.RED);
		fps = Start.getFps();
		g.drawString("FPS: "+fps, 940, 10);
		
		//System.out.println("print");
	}
}
