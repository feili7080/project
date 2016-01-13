package graphicTrastj;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;


public class MyWindow extends JFrame implements KeyListener{

	/**
	 * @param args
	 */
	int width = 500;
	int height = 500;
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyWindow ();

	}
	public MyWindow(){
		setVisible(true);
		setSize(width,height);
		setLocation(200,150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//static constant reference for special close operation
		
		
	}
	public void paint(Graphics g){
		//Graphics 2d is like a art kit
		
		BufferedImage image= new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);
		
		
		




		Graphics2D g2= (Graphics2D)image.getGraphics();
		g2.setColor(Color.cyan);
		g2.fillRect(0, 0, width,height);
		g2.setColor(Color.pink);
		
		g2.drawOval(0,0,width,height);
		
		g2.fillOval(100,100,150,300);
		g2.fillOval(300,100,150,300);
		g2.drawArc(50,300,200,200,0,90);
		g2.drawString("Strings are drawn i like this",300,300);
//		int sqaureD=20;
//		int margin = 2;
//		int num=0;
//		for(int i =0; i<width;i+=sqaureD + margin){
//			for(int j=0;j<height;j+=sqaureD + margin){
//				if(num == 256){ num=0;}
//				g2.setColor(new Color(0,0,num));
//				g2.fillRect(i, j, sqaureD, sqaureD);
//				num++;
//
//			}	
//
//		}	
		g.drawImage(image,0,0,null);
	}
	public void keyPressed(KeyEvent arg0) {
		int keyevent = arg0.getKeyCode();
		if(keyevent == KeyEvent_VK_UP)
			hero.moveUp();
		
		if(keyevent == keyevent_Vk_RIGHT)		
			x++
		if(keyevent == keyevent_Vk_LEFT)	
			x--
		if(keyevent == keyevent_Vk_DOWN)	
				x--	
	}
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}



