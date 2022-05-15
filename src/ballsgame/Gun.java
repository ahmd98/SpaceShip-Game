
package ballsgame;

import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Gun {
    static int sum=0;
    static String c[]={"Yellow","Blue","Red","Purple","Orange","Green"};
    static boolean isUpdate=false;
     float x,y,z,xspeed,yspeed;
   BufferedImage shotgun;
   ball ball[];
   public Gun(ball[]ball,float x, float y,float xspeed,float yspeed,BufferedImage gun){
   this.shotgun=gun;
   this.x=x;
   this.y=y;
    this.xspeed=xspeed;
    this.yspeed=yspeed;
    this.z=y;
    this.ball=ball;
   }
   
  
  public void update(){
            isUpdate=true;
            if(Ballsgame.Mode==false){
            for(int i=0;i<6;i++)
            {
                if(y==ball[i].y+ball[i].firstball.getHeight()  &&  x+shotgun.getWidth()/2>= ball[i].x && x+shotgun.getWidth()/2<= ball[i].x+ball[i].firstball.getWidth()){
                    y=z;
                    sum+=i+1;
                    frame.label.setText(""+sum);
                     ball[i].isShot=true;
                    isUpdate=false;
                    return;
                }
            }
            y=y-yspeed;
            //Thread.sleep(1000);
            if(y<=0)
                y=z;
               for(int i=0;i<6;i++)
            {
                if(y==ball[i].y+ball[i].firstball.getHeight()  &&  x+shotgun.getWidth()/2>= ball[i].x && x+shotgun.getWidth()/2<= ball[i].x+ball[i].firstball.getWidth()){
                    System.out.println("ballsgame.Gun.update()");
                    ball[i].isShot=true;
                    y=z;
                    sum+=i+1;
                    frame.label.setText(""+sum);
                    isUpdate=false;
                    return;
                }
            }
            }
            else
            {
                if(y==ball[Game.random].y+ball[Game.random].firstball.getHeight()  &&  x+shotgun.getWidth()/2>= ball[Game.random].x && x+shotgun.getWidth()/2<= ball[Game.random].x+ball[Game.random].firstball.getWidth()){
                    y=z;
                    sum+=Game.random+1;
                    frame.label.setText(""+sum);
                     ball[Game.random].isShot=true;
                    isUpdate=false;
                    return;
                }
            y=y-yspeed;
            //Thread.sleep(1000);
            if(y<=0)
                y=z;
                if(y==ball[Game.random].y+ball[Game.random].firstball.getHeight()  &&  x+shotgun.getWidth()/2>= ball[Game.random].x && x+shotgun.getWidth()/2<= ball[Game.random].x+ball[Game.random].firstball.getWidth()){
                    System.out.println("ballsgame.Gun.update()");
                    ball[Game.random].isShot=true;
                    y=z;
                    sum+=Game.random+1;
                    frame.label.setText(""+sum);
                    
                    isUpdate=false;
                    return;
                }
            }
            isUpdate=false;
   }
}
