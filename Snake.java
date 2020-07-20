package snake;

import java.awt.Graphics;
import java.io.File; 
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Snake extends JPanel
{
	JFrame window = new JFrame();
	public Snake() 
	{
		window.add(this);
		window.setUndecorated(true);
		window.setSize(1920,1030);
		window.setVisible(true);
		
		try
		{
			Thread.sleep(3000);
			window.dispose();
			Menu m=new Menu();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	
	}
	public void paint(Graphics g)
	{
		ImageIcon background = new ImageIcon("images//Snake.jpg");
		g.drawImage(background.getImage(),0,0,null);
		
	}
	
	
	
	public static void main(String[] args)
	{
	Snake s=new Snake();

	}

}
