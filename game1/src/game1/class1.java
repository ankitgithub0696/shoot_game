package game1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.RenderingHints.Key;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class class1 extends JFrame implements Runnable{
	Image im[]= new Image[5];
	Graphics graphic;
	Image graphicimage;
	int xdirection,ydirection;
	ImageIcon m[]=new ImageIcon[5];
	int x,y;
	JButton b[]=new JButton[6];
	
	public void run() 
	{
		try 
		{
			
			while(true) 
			{
				move();
				Thread.sleep(5);
			}
		}catch (Exception e) {
			System.out.print(""+e);
		}
	}
	
	public void move() 
	{
		x+=xdirection;
		y+=ydirection;
		
		if(x<=0) 
		{
			x=10;
		}
		
		if(x>=915)
		{
			x=915;
		}
		
		if(y<=0) 
		{
			y=20;
		}
		if(y>=660) 
		{
			y=660;
		}
		
	}
	
	public void setxdirection(int xdir) 
	{
		this.xdirection=xdir;
	}
	
	public void setydirection(int ydir) 
	{
		this.ydirection=ydir;
	}
	
	public class1() 
	{
		
		setVisible(true);
		setSize(1024,768);
		setResizable(false);
		setLayout(null);
		
		x=50;
		y=50; 
		
		b[0]=new JButton();
		b[0].setBounds(50,20,100,100);
		add(b[0]);
		
		b[0].addActionListener(new ActionListener() {
				
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"game play");
				
				b[0].setVisible(false);
				m[1]=new ImageIcon("pause.PNG");
				im[0]=m[1].getImage();
				b[1].setVisible(true);
			}
		});
		
		
		b[1]=new JButton();
		b[1].setBounds(50,20,100,100);
		b[1].setVisible(false);
		add(b[1]);
		
		b[1].addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
		
				JOptionPane.showMessageDialog(null,"game pause");
				b[0].setVisible(true);
				//m[0]=new ImageIcon("play.PNG");
				im[0]=m[0].getImage();
				b[1].setVisible(false);
			}
		});
		
		m[0]=new ImageIcon("play.PNG");
		im[0]=m[0].getImage();
		
		
		m[2]=new ImageIcon("ship.png");
		im[2]=m[2].getImage();
		
		
	}
	
	public class AL extends KeyAdapter
	{
		public void keyPressed(KeyEvent ke) 
		{
			
		}
	}
	
	public void paint(Graphics g) 
	{
		graphicimage=createImage(getWidth(),getHeight());
		graphic=graphicimage.getGraphics();
		paintComponents(graphic);
		
		g.drawImage(graphicimage,0,0,this);
	}
	
	public void paintComponents(Graphics ge)
	{
		
		ge.drawImage(im[0],x,y,this);
		ge.drawImage(im[1],x,y,this);
		//ge.drawImage(im[2],x,y,this);
		repaint();
	}
	
	 
	public static void main(String agrs[]) 
	{
		class1 cls=new class1();
	}

}

	
