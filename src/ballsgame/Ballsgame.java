
package ballsgame;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.imageio.ImageIO;


public class Ballsgame implements KeyListener  {
    static Game gun1;
    static boolean Mode=false;
    static ExecutorService ball;
    static ExecutorService bullet;
    static boolean shm=false;

    public static void main(String[] args) throws IOException {
BufferedImage[] ballImg=new BufferedImage[6];
   ball Ball[]=new ball[6];
   BufferedImage shgun=null;
   BufferedImage base=null;
   BufferedImage q=null;
   BufferedImage c=null;
   BufferedImage result=null;
   
   Cursor m;
   
  try{
   ballImg[0]=ImageIO.read(Ballsgame.class.getClassLoader().getResourceAsStream("Ballsgame/1.png"));
   ballImg[1]=ImageIO.read(Ballsgame.class.getClassLoader().getResourceAsStream("Ballsgame/2.png"));
   ballImg[2]=ImageIO.read(Ballsgame.class.getClassLoader().getResourceAsStream("Ballsgame/3.png"));
   ballImg[3]=ImageIO.read(Ballsgame.class.getClassLoader().getResourceAsStream("Ballsgame/4.png"));
   ballImg[4]=ImageIO.read(Ballsgame.class.getClassLoader().getResourceAsStream("Ballsgame/5.png"));
   ballImg[5]=ImageIO.read(Ballsgame.class.getClassLoader().getResourceAsStream("Ballsgame/6.png"));
   shgun=ImageIO.read(Ballsgame.class.getClassLoader().getResourceAsStream("Ballsgame/b.png"));
   base=ImageIO.read(Ballsgame.class.getClassLoader().getResourceAsStream("Ballsgame/g.png"));
   q=ImageIO.read(Ballsgame.class.getClassLoader().getResourceAsStream("Ballsgame/q.jpeg"));
   c=ImageIO.read(Ballsgame.class.getClassLoader().getResourceAsStream("Ballsgame/c.png"));
   result=ImageIO.read(Ballsgame.class.getClassLoader().getResourceAsStream("Ballsgame/result.png"));

   }catch(IOException e){
   }    
   Ball[0]=new ball(100,100,3,5,ballImg[0]);
   Ball[1]=new ball(160,56,3,6,ballImg[1]);
   Ball[2]=new ball(200,50,9,7,ballImg[2]);
   Ball[3]=new ball(100,40,4,8,ballImg[3]);
   Ball[4]=new ball(190,50,5,9,ballImg[4]);
   Ball[5]=new ball(175,60,4,10,ballImg[5]);
   Gun gun= new Gun(Ball,230,370,0,1,shgun);
   frame frame1=new frame(Ball[0],Ball[1],Ball[2],Ball[3],Ball[4],Ball[5],gun,base,q,c,result);
   m=new Cursor(Cursor.CROSSHAIR_CURSOR);
   frame1.addKeyListener(new Ballsgame());
   frame1.setCursor(m);
             ball=Executors.newFixedThreadPool(6);
             bullet=Executors.newFixedThreadPool(1);
             
 Game ball1 =new Game(Ball[0],frame1,40);
 Game ball2 =new Game(Ball[1],frame1,40);
 Game ball3 =new Game(Ball[2],frame1,40);
 Game ball4 =new Game(Ball[3],frame1,40);
 Game ball5 =new Game(Ball[4],frame1,40);
 Game ball6 =new Game(Ball[5],frame1,40);
 gun1 =new Game(frame1,gun,2);
 ball.execute(ball1);
 ball.execute(ball2);
 ball.execute(ball3);
 ball.execute(ball4);
 ball.execute(ball5);
 ball.execute(ball6);
 
 ball.shutdown();
    }
     
   

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
       
      
    int keyCode=e.getKeyCode();
    if(keyCode==e.VK_SPACE){
       if(!shm){ shm=true;
        bullet.execute(gun1);}
       
    }
    if(keyCode==e.VK_ESCAPE){
        System.exit(0);
    
    }
    if(keyCode==e.VK_N){
        Mode=false;
        frame.label2.setText("Normal");
    }
    if(keyCode==e.VK_C){
         Mode=true;
         frame.label2.setText(Gun.c[gun1.random]);
        
    }}
    

    @Override
    public void keyReleased(KeyEvent e) {
    }
    
}
