package game3;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class shoot extends JFrame implements Runnable ,ActionListener{
	

	
	int SetXDirection, SetYDirection;
	int xloc0,xloc1,xloc2,xloc3,xloc4,xloc5;
	int yloc0,yloc1,yloc2,yloc3,yloc4,yloc5;
	Graphics graphic;
	Image graphicimage;
	Image img[]=new Image[10];
	ImageIcon icon[]=new ImageIcon[10];
	JButton b[]=new JButton[5];
	public void run() 
	{
		try 
		{
			while(true) 
			{
				move();
				Thread.sleep(5);
			}
		}catch (Exception e)
		{
			JOptionPane.showMessageDialog(rootPane, e);
		}
	}
	
	public void move() 
	{
		xloc0+=SetXDirection;
		yloc0+=SetYDirection;
		
		if(xloc0<=0) 
		{
			xloc0=10;
		}
		
		if(xloc0>=915)
		{
			xloc0=915;
		}
		
		if(yloc0<=0) 
		{
			yloc0=20;
		}
		if(yloc0>=660) 
		{
			yloc0=660;
		}
	}
	
	public void XDirection(int xdir) 
	{
		this.SetXDirection=xdir;
	}
	
	
	public void YDirection(int ydir) 
	{
		this.SetYDirection=ydir;
	}
	
	public class AL extends KeyAdapter
	{
		public void keyPressed(KeyEvent ke) 
		{
			int key=ke.getKeyCode();
			
			if(key==ke.VK_LEFT) 
			{
				xloc0-=10;
			}
			
			if(key==ke.VK_RIGHT) 
			{
				xloc0+=10;
			}
			
			if(key==ke.VK_SPACE) 
			{
				
			}
		}
	}
	public shoot() 
	{
		setSize(1024,768);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Space Alien War");
		addKeyListener(new AL());
		setLayout(null);
		
		icon[0]=new ImageIcon("ship.png");
		img[0]=icon[0].getImage();
		
		xloc0=460;
		yloc0=650;
		
		b[0]=new JButton();
		b[0].setBounds(50,20,50,50);
		add(b[0]);
		
		icon[1]=new ImageIcon("play.png");
		img[1]=icon[1].getImage();
		
		xloc1=50;
		yloc1=50;
		
		b[0].addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) 
			{
				JOptionPane.showMessageDialog(rootPane,"hii");
				b[0].setVisible(false);
				b[1].setVisible(true);
				icon[2]=new ImageIcon("pause.png");
				img[2]=icon[2].getImage();
				
			}
		});
		
		b[1]=new JButton();
		b[1].setBounds(50,20,50,50);
		b[1].setVisible(false);
		add(b[1]);
				
		xloc2=50;
		yloc2=50;
			
		b[1].addActionListener(new ActionListener() {
				
			public void actionPerformed(ActionEvent e)
			{
				JOptionPane.showMessageDialog(rootPane,"bye");
				b[0].setVisible(true);
				b[1].setVisible(false);
				
				img[1]=icon[1].getImage();
			}
		});

	}
	
			
	public void actionPerformed(ActionEvent ae) 
	{
			
	}
	
	public void paint(Graphics g) 
	{
		graphicimage=createImage(getWidth(),getHeight());
		graphic=graphicimage.getGraphics();			
		paintComponent(graphic);
		
		g.drawImage(graphicimage,0,0,this);
		 
	}
	
	public void paintComponent(Graphics g) 
	{
		g.drawImage(img[0],xloc0,yloc0,this);
		g.drawImage(img[1],xloc1,yloc1,this);
		g.drawImage(img[2],xloc2,yloc2,this);
		repaint();
	}
	
	public static void main(String[] args) {
		
		shoot s=new shoot();
	 
		Thread t=new Thread();
		t.start();
		
	}

	

}
