package snake;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.Timer;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Play extends JPanel implements ActionListener, KeyListener
{
	JFrame window= new JFrame();
	
	private int[] snakexlength = new int[750];
	private int[] snakeylength = new int[750];
	
	private int moves=0, score=0;	
	
	private boolean left = false;
	private boolean right = false;
	private boolean up = false;
	private boolean down = false;
	
	private ImageIcon rightmouth;
	private ImageIcon leftmouth;
	private ImageIcon upmouth;
	private ImageIcon downmouth;
	
	private Timer timer;
	private int delay=200;
	
	private int lengthofsnake = 3;
	
	private ImageIcon snakeimage,title2;
	
	private int[] enemyxpos={45,90,135,180,225,270,315,360,405,450,495,540,585,630,675,720,765,855,900,945,990,1035,
							1080,1125,1170,1215,1260,1305,1350,1395,1440,1485,1530,1575,1620,1665,1710,1755,1800,1845};
	
	private int[] enemyypos={135,180,225,270,315,360,405,450,495,540,585,630,675,720,765,855,900,945};
	
	private ImageIcon enemyimage;
	private Random random=new Random();
	
	private int xpos=random.nextInt(41);
	private int ypos=random.nextInt(17);
							
	
	public Play()
	{
		window.add(this);
		
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(delay,this);
		timer.start();
		
		
		window.setUndecorated(true);
		window.setSize(1920,1030);
		window.setVisible(true);
	}
	public void paint(Graphics g)
	{
		if(moves==0)
		{
			snakexlength[2]=45;
			snakexlength[1]=90;
			snakexlength[0]=135;
			
			snakeylength[2]=135;
			snakeylength[1]=135;
			snakeylength[0]=135;
			
		}
		
		g.setColor(Color.BLACK);
		g.drawRect(14,14,1891,90);
		
		title2=new ImageIcon("BG_89px.png");
		title2.paintIcon(this, g, 15, 15);
		
		g.setColor(Color.BLACK);
		g.drawRect(14,105,1891,914);
		
		g.setColor(Color.DARK_GRAY);
		g.fillRect(15,106,1890,913);
		
		g.setColor(Color.BLACK);
		g.setFont(new Font("arial", Font.PLAIN, 40 ));
		g.drawString("SCORES : "+score,1180,70);
		
		g.setColor(Color.BLACK);
		g.setFont(new Font("arial", Font.PLAIN, 40 ));
		g.drawString("LENGTH : "+lengthofsnake,1580,70);
		
		
		rightmouth = new ImageIcon("rightmouth1.png");
		rightmouth.paintIcon(this, g, snakexlength[0], snakeylength[0]);
		
		for(int a=0;a<lengthofsnake;a++)
		{
			if(a==0 && right)
			{
				rightmouth = new ImageIcon("rightmouth1.png");
				rightmouth.paintIcon(this, g, snakexlength[a], snakeylength[a]);
			}
			if(a==0 && left)
			{
				leftmouth = new ImageIcon("leftmouth1.png");
				leftmouth.paintIcon(this, g, snakexlength[a], snakeylength[a]);
			}
			if(a==0 && up)
			{
				upmouth = new ImageIcon("upmouth1.png");
				upmouth.paintIcon(this, g, snakexlength[a], snakeylength[a]);
			}
			if(a==0 && down)
			{
				downmouth = new ImageIcon("downmouth1.png");
				downmouth.paintIcon(this, g, snakexlength[a], snakeylength[a]);
			}
			if(a!=0)
			{
				snakeimage = new ImageIcon("snakeimage1.png");
				snakeimage.paintIcon(this, g, snakexlength[a], snakeylength[a]);
				
			}
		}
		enemyimage = new ImageIcon("enemyimage1.png");
		if(enemyxpos[xpos]==snakexlength[0] && enemyypos[ypos]==snakeylength[0] )
		{
			score++;
			lengthofsnake++;
			xpos=random.nextInt(41);
			ypos=random.nextInt(17);
		}
		enemyimage.paintIcon(this,g,enemyxpos[xpos],enemyypos[ypos]);
		
		for(int b=1;b<lengthofsnake;b++)
		{
			if(snakexlength[b]==snakexlength[0] && snakeylength[b]==snakeylength[0])
			{
				right=false;
				left=false;
				down=false;
				up=false;
				g.setColor(Color.white);
				g.setFont(new Font("arial",Font.BOLD, 100));
				g.drawString("GAME OVER",650,450);
				
				g.setFont(new Font("arial",Font.BOLD, 70));
				g.drawString("SPACE  to  RESTART",600,650);
			}
		}
		g.dispose();
	
	
	}
	public void actionPerformed(ActionEvent e) 
	{
		timer.start();
		if(right)
		{
			for(int r=lengthofsnake-1;r>=0;r--)
			{
				snakeylength[r+1]=snakeylength[r];
			}
			for(int r=lengthofsnake;r>=0;r--)
			{
				if(r==0)
				{
					snakexlength[r]=snakexlength[r]+45;
				}
				else
				{
					snakexlength[r]=snakexlength[r-1];
				}
				if(snakexlength[r]>1845)
				{
					snakexlength[r]=45;
				}
			}
			repaint();
				
		}
		if(left)
		{
			for(int r=lengthofsnake-1;r>=0;r--)
			{
				snakeylength[r+1]=snakeylength[r];
			}
			for(int r=lengthofsnake;r>=0;r--)
			{
				if(r==0)
				{
					snakexlength[r]=snakexlength[r]-45;
				}
				else
				{
					snakexlength[r]=snakexlength[r-1];
				}
				if(snakexlength[r]<45)
				{
					snakexlength[r]=1845;
				}
			}
			repaint();
		}
		if(up)
		{
			for(int r=lengthofsnake-1;r>=0;r--)
			{
				snakexlength[r+1]=snakexlength[r];
			}
			for(int r=lengthofsnake;r>=0;r--)
			{
				if(r==0)
				{
					snakeylength[r]=snakeylength[r]-45;
				}
				else
				{
					snakeylength[r]=snakeylength[r-1];
				}
				if(snakeylength[r]<135)
				{
					snakeylength[r]=945;
				}
			}
			repaint();
		}
		if(down)
		{
			for(int r=lengthofsnake-1;r>=0;r--)
			{
				snakexlength[r+1]=snakexlength[r];
			}
			for(int r=lengthofsnake;r>=0;r--)
			{
				if(r==0)
				{
					snakeylength[r]=snakeylength[r]+45;
				}
				else
				{
					snakeylength[r]=snakeylength[r-1];
				}
				if(snakeylength[r]>945)
				{
					snakeylength[r]=135;
				}
			}
			repaint();
		}
		
	}
	public void keyPressed(KeyEvent e) 
	{
		if(e.getKeyCode()== KeyEvent.VK_SPACE)
		{
			moves=0;
			score=0;
			lengthofsnake=3;
			repaint();
		}
		
		
		
		if(e.getKeyCode()== KeyEvent.VK_LEFT)
		{
			moves++;
			left = true;
			if(!right)
			{
				left = true;
			}
			else
			{
				left = false;
				right = true;
			}
				
			up = false;
			down = false;
		}
		if(e.getKeyCode()== KeyEvent.VK_UP)
		{
			moves++;
			up = true;
			if(!down)
			{
				up = true;
			}
			else
			{
				up = false;
				down = true;
			}
				
			right = false;
			left = false;
		}
		if(e.getKeyCode()== KeyEvent.VK_RIGHT)
		{
			moves++;
			right = true;
			if(!left)
			{
				right = true;
			}
			else
			{
				right = false;
				left = true;
			}
				
			up = false;
			down = false;
		}
		if(e.getKeyCode()== KeyEvent.VK_DOWN)
		{
			moves++;
			down = true;
			if(!up)
			{
				down = true;
			}
			else
			{
				down = false;
				up = true;
			}
				
			right = false;
			left = false;
		}
		
	}
	public void keyReleased(KeyEvent e)
	{
	
		
	}
	public void keyTyped(KeyEvent e)
	{
	
		
	}

}
