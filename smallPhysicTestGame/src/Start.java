import java.awt.Color;													//import some java libraries to get the window and colors
import javax.swing.JFrame;

public class Start implements Runnable {
	
	boolean frameCreated = false;										//define variables
	PaintSurface paintSurface = new PaintSurface();
	JFrame f;
	
	public static void main (String[] args){							//Main, this is where it all begins!
		System.out.println("Starting...");								//print that everything began
		Start s = new Start();											
		s.start();														//start start()
		
	}
	public void start(){												//start()
		frameCreated = createFrame();									//launch createFrame() which creates the Window
		System.out.println("Frame up? : " + frameCreated);				//Says if Window is up or not
	}
	
	@SuppressWarnings("static-access")									//with this the error at f.setDefaultCloseOperation(f.EXIT_ON_CLOSE); Disappears
	public boolean createFrame(){										//here is the window created
		f = new JFrame("Testi");										//define the frame, name window "Testi"
		f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);					//let the window be able to close for user
		f.setSize(1000,800);											//set the window size
		f.setBackground(Color.BLACK);									//set the background color of the window (pretty useless)
		f.pack();														//"pack" the window to let the paint surface work, don't understand why this is needed but it is
		f.add(paintSurface);											//add paint surface on window
		f.setVisible(true);												//make the window visible
		
		Thread thread = new Thread(this);								//start a new Thread 
		thread.start();													//launch run() with  the Thread
		
		return true;													//tell user that the window works
	}
	
	@Override
	public void run() {													//loop to repaint every 100ms
		while(f.isVisible()) {											//only start loop if window is visible
			paintSurface.repaint();										//repaint the paint surface
		try {																			
			Thread.sleep(100);											//wait 100ms so the computer doesn't have too much work to do
		} catch (InterruptedException e) {
			System.out.println("Something went horribly wrong :(");		//print sad face if loop doesnt work
		}
		}
		
	}
	
}
