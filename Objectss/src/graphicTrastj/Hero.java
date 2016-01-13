package graphicTrastj;

import java.awt.image.BufferedImage;
import java.net.URL;

public class Hero {
	
	BufferedImage sprite;
	String name;
	int locationx;
	int locationy;
	int x;
	int y;
	Hero heropengu;
	public Hero(String name, String imageLocation, int locationx ,int locationy){
		this.name = name;
		int width= 100;
		int height =200;
		x= locationx;
		y=locationy;
		
		
		
		
		sprite = new BufferedImage (width,height,BufferedImage.TYPE_INT_ARGB);
		
	)
		
		
		g2.drawImage()
		
		
		URL url=getClass().getResource(imageLocation);
		BufferedImage original =ImagesIO.read(url);
		
	}
	public BufferedImage getImage(){
		return sprite;
	}
	public String getName(){
		return name;
	}
	
	public int getLocationx(){
		return locationx;
	}
	
	public int getLocationy(){
		return locationy;
	}

	g.drawImage(herox.getImage()

			

//	/**
//	 * @param args
//	 */
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}

}
