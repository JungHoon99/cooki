package cookirun;

import java.io.IOException;

import javax.swing.JFrame;

public class mainMenu {
	@SuppressWarnings("null")
	public static void main(String[] args) throws InterruptedException, IOException
	{
		JFrame frame = new JFrame();
		
		new img().playing(frame,1,50,40);
	}
}
