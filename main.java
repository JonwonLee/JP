package 플젝;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileOutputStream;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class main {
   static int set=0;
   static int sec=0;
   static int labelc=0;
   static int nscore=0;
   static int lives1=5;
   
   private static ArrayList<dn> myArrayList;
   
   public static void main(String[] args) throws InterruptedException {
   JFrame f = new JFrame("준's 게임 ");
   f.getContentPane().setBackground(Color.YELLOW);
   ImageIcon p =new ImageIcon("C:/Users/이준원/Desktop/grr.png");
   
   JLabel player =  new JLabel(p);
   JLabel score= new JLabel("Score:"+Integer.toString(nscore));// bullet 이라는 클래스저장한것을 JLabel로 표현하기 위해서 생성
   JLabel lives= new JLabel("lives:"+Integer.toString(lives1)); //bullet 을 arraylist로 쓴 이유: 랜덤을로 총알이 떨어지니까 가변적으로  배열에 넣기 위해서
   score.setBounds(0, 0, 100, 100);
   f.add(score);
   
   lives.setBounds(0, 200, 350, 350);
   f.add(lives);
   f.setSize(900, 900);
   f.setVisible(true);
   
   ArrayList<JLabel> bulJ = new ArrayList<>(); 
   ArrayList<bullet> bulI = new ArrayList<>();  
   ArrayList<dn> d =new ArrayList<>();
   
   int px=300;
   int py=500;
   
   player.setSize(p.getIconWidth(), p.getIconHeight());
   player.setBounds(px, py, p.getIconWidth(), p.getIconHeight());
   
   f.setLayout(null);
   f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);  
   f.setVisible(true);//생성
   
   myArrayList=new ArrayList<dn>();
   
   
   while(true) {
      if(sec==5)
      {
    	  //랜덤으로 x, y=0,speed는 랜덤 추가
         bulI.add((new bullet((int)(Math.random()*600),0,((int)(Math.random()*10)+12))));
         sec=0;
      }
      
      //키입력
      f.addKeyListener(new KeyListener()
        {
           @Override
           public void keyPressed(KeyEvent e) 
           {
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
      
   for(bullet k : bulI)  //BulI에 있는  값들을 하나씩 bullet k에 대입
   {
	   
	 //사람하고 총알이 부딛쳤을때 
            if((player.getX()<k.getPx()&& k.getPx()<player.getX()+player.getIcon().getIconWidth()) && 
            		(k.getPy()>player.getY()&&player.getY()+player.getIcon().getIconHeight()>k.getPy()))
            {
                lives1--;
                
            if (lives1==0) 
            {
            	//파일 저장
                   try 
                   {
                      FileOutputStream output = new FileOutputStream("JAVASCORE.txt");
                      String str = Integer.toString(nscore);
                      byte[] by = str.getBytes();
                      output.write(by);
                      output.close();
                   }
                   
                   catch(Exception e)
                   {
                      e.getStackTrace();
                   }
                   
               JLabel a=new JLabel();
             //종료문으로 바꾸기
                   a.setSize(100,100);
                   a.setBounds(250,250,300,300);
                   a.setText("GAME OVER");
                   f.add(a);
                   f.setVisible(true);
                   f.revalidate();
                   f.repaint();
                   Thread.sleep(100000); 
            }
            //닿으면 총알 사라지게
            bulI.remove(k);
            break;
            }
            
       //점수 증가시키기
      if(k.getPy()>550) 
      {
         bulI.remove(k);
         nscore++;
         score.setText("score : "+Integer.toString(nscore));
         break;
      }

   }
      
   	   //라벨 리스트에 라벨 생성
      for(bullet k : bulI)//BulI에 있는 값들을 하나식 bullet k에 대입
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
      
      lives.setText("life : "+Integer.toString(lives1));
      lives.setBounds(530,-190,350,500);
      f.add(lives);
      f.add(player);
      f.setVisible(true);//생성
      
      //화면 더러워서 지우기
      f.revalidate();
      f.repaint();
      //0.05초 잠시 대기
      Thread.sleep(50);
      sec++;
      
      for(JLabel k : bulJ)
      {
         f.remove(k);
      }
      f.remove(player);
   }
   
    }
    
   private static String integerate(int nscore2) {
      // TODO Auto-generated method stub
      return null;
   }
   
   private static String string(int nscore2) {
      // TODO Auto-generated method stub
      return null;
   }
}
