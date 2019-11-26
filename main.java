package project;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.util.*;

public class main {
	static int set=0;
	static int sec=0;
	static int labelc=0;
	private static ArrayList<dn> myArrayList;
    public static void main(String[] args) throws InterruptedException {
	JFrame f = new JFrame("준's 게임 ");
	ImageIcon p =new ImageIcon("C:/Users/user/Desktop/grr.png");
	JLabel player =  new JLabel(p);
	ArrayList<JLabel> bulJ = new ArrayList<>(); // label 정보를
	ArrayList<bullet> bulI = new ArrayList<>();  //bullet 을 arraylist로 쓴 이유: 랜덤을로 총알이 떨어지니까 가변적으로  배열에 넣기 위해서
	ArrayList<dn> d =new ArrayList<>();
	
	int px=300;
	int py=500;
	
	player.setSize(p.getIconWidth(), p.getIconHeight());
	player.setBounds(px, py, p.getIconWidth(), p.getIconHeight());
	
	f.setLayout(null);
	f.setSize(600,600); //크기
	f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
	f.setVisible(true);//생성
	
	myArrayList=new ArrayList<dn>();
	
	
	while(true) {
		if(sec==5)
		{
			bulI.add((new bullet((int)(Math.random()*600),0,((int)(Math.random()*10)+12))));
			sec=0;
		}
		f.addKeyListener(new KeyListener()
        {
           @Override
           public void keyPressed(KeyEvent e) {
        	   if(e.getKeyCode() ==KeyEvent.VK_RIGHT)
               {
             	  set=+10;
               }
               else if(e.getKeyCode() ==KeyEvent.VK_LEFT)
               {
             	  set=-10;
               }
           }
           @Override
           public void keyReleased(KeyEvent e) {
        	   if(e.getKeyCode() ==KeyEvent.VK_RIGHT)
               {
             	  set=0;
               }
               else if(e.getKeyCode() ==KeyEvent.VK_LEFT)
               {
             	  set=0;
               }
           }
           @Override
           public void keyTyped(KeyEvent e) {
        	   
           }
        });
		
		px+=set;
		bulJ.clear();
		labelc=0;
	for(bullet k : bulI) //BulI에 있는  값들을 하나씩 bullet k에 대입
	{
            if((player.getX()<k.getPx()&& k.getPx()<player.getX()+player.getIcon().getIconWidth()) && (k.getPy()>player.getY()&&player.getY()+player.getIcon().getIconHeight()>k.getPy()))
            {
                f.setVisible(true);//생성
		        f.revalidate();
                f.repaint();
                JLabel a =new JLabel();
                a.setSize(100,100);
                a.setBounds(250,250,300,300);
                a.setText("GAME OVER");
                f.add(a);
                f.setVisible(true);//생성
		        f.revalidate();
                f.repaint();
                Thread.sleep(100000); //종료문으로 바꾸기
            }
		if(k.getPy()>550) {
			bulI.remove(k);
			break;
		}
	}
		
		for(bullet k : bulI)
		{
			bulJ.add(new JLabel(k.getImg()));
			bulJ.get(labelc).setSize(k.getImg().getIconWidth(),k.getImg().getIconHeight());
			bulJ.get(labelc).setBounds(k.getPx(), k.getPy(), k.getImg().getIconWidth(),k.getImg().getIconHeight());
			f.add(bulJ.get(labelc));
			labelc++;
			k.setPy(k.getPy()+k.getSpeed());
		}
		player.setSize(p.getIconWidth(), p.getIconHeight());
		player.setBounds(px, py, p.getIconWidth(), p.getIconHeight());
		f.add(player);
		f.setVisible(true);//생성
		f.revalidate();
		f.repaint();
		Thread.sleep(50);
		sec++;
		for(JLabel k : bulJ)
		{
			f.remove(k);
		}
		f.remove(player);
	}
    }
}
