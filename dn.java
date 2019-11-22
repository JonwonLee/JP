package project;

import javax.swing.ImageIcon;

public class dn {
	ImageIcon img =new ImageIcon("C:/Users/user/Desktop/dn.png");
	int px = 0;
	int py=0;
	
	dn(int x, int y)
	{
		this.px=x;
		this.py=y;
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
