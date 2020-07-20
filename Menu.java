package snake;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Menu extends JPanel implements ActionListener,KeyListener
{
	
	JFrame window =new JFrame();
	JButton play =new JButton();
	JButton exit =new JButton();
	
	
	JLabel image = new JLabel();
	public Menu() 
	{
		window.add(this);
		
		play.setIcon(new ImageIcon("images//play2.png"));
		play.addActionListener(this);
		play.addKeyListener(this);
		window.add(play,BorderLayout.PAGE_START);
		
		exit.setIcon(new ImageIcon("images//exit3.jpg"));
		exit.addActionListener(this);
		exit.addKeyListener(this);
		window.add(exit,BorderLayout.PAGE_END);
		
		
		image.setIcon(new ImageIcon("images//center8.jpeg"));
		window.add(image,BorderLayout.CENTER);
	
		
		
		window.setUndecorated(true);
		window.setSize(1920,1030);
		window.setVisible(true);
	}
	
	public void keyPressed(KeyEvent kp)
	{
		if(kp.getKeyCode()==KeyEvent.VK_ESCAPE)
		{
			window.dispose();
		}
		if(kp.getKeyCode()==KeyEvent.VK_ENTER)
		{
			Play p=new Play();
		}
		
	}

	public void keyReleased(KeyEvent arg0)
	{
	
		
	}
	
	public void keyTyped(KeyEvent arg0) 
	{

		
	}

	public void actionPerformed(ActionEvent ae) 
	{
		if(ae.getSource()==exit)
		{
			window.dispose();
		}
		if(ae.getSource()==play)
		{
			Play p=new Play();
		}
		
	}
	

}
