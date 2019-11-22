package project;

import javax.swing.ImageIcon;

public class bullet {
	ImageIcon img =new ImageIcon("C:/Users/user/Desktop/bullet.png");
	private int px = 0;
	private int py=0;
	private int speed;
	
	bullet(int x, int y,int speed)
	{
		this.px=x;
		this.py=y;
		this.speed=speed;
	}
	
	public int getSpeed()
	{
		return this.speed;
	}
	
	public void setPx(int x)
	{
		this.px=x;
	}
	public void setPy(int y)
	{
		this.py=y;
	}
	public int getPx()
	{
		return this.px;
	}
	public int getPy()
	{
		return this.py;
	}
	
	public ImageIcon getImg()
	{
		return this.img;
	}
}
