import java.awt.Color;															//import bunch of libraries
import java.awt.Graphics;
import javax.swing.JPanel;


public class PaintSurface extends JPanel {

	private static final long serialVersionUID = 1L;
	
	int x = 0;																	//define variables
	int ovalX;
	int ovalY;
	boolean printedFirstTime = true;
	int ovalXFinal[] = new int[50];
	int ovalYFinal[] = new int[50];
	
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
			ovalXFinal[i] = ovalXFinal[i]+10;									//let stars move 10 in x direction (coordinates are bit different in java, try google to show you)
			ovalYFinal[i] = ovalYFinal[i]-10;									//let stars move up 10 in y direction
			if(ovalXFinal[i]>1000){												//new X variable for star if moved out of surface in X direction
				ovalXFinal[i] = (int) (Math.random()*100);
			}
			if(ovalYFinal[i]<0){												//new X variable for star if moved out of surface in Y direction
				ovalYFinal[i] = (int) (Math.random()*(800-600))+600;			//syntax for math.random: math.random()*(highesValue-lowestValue)+lowestValue to get a range in random numbers
			}
		}																		//Stars Background End
		
		g.drawString(" >===== I am a rocket,someday ===>",x,300);				//draw random string on surface
		if(x < 500){																
			x = x + 10;															//let string move in x direction +10
		}else{																	
			x = 0;																//string starts at x 0 again if moved out of surface
		}
		
		//System.out.println("print");
	}
}
