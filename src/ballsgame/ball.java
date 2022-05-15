
package ballsgame;

import java.awt.image.BufferedImage;


public class ball {
   float x,y,xspeed,yspeed;
   boolean isShot=false;
   BufferedImage firstball;
   public ball(float x, float y,float xspeed,float yspeed,BufferedImage firstball){
   this.firstball=firstball;
   this.x=x;
   this.y=y;
   this.xspeed=xspeed;          //move horizontally
   this.yspeed=yspeed; 
   //move vertically
   }
   public void update(){
       if(Gun.isUpdate==false)
       {
       x=x+xspeed;
       y=y+yspeed;
       if (x<0){
           xspeed*=-1;}
          if (x+firstball.getWidth()>480){
           xspeed*=-1;}
           if (y<0){
           yspeed*=-1;}
          if (y+firstball.getHeight()>340){
           yspeed*=-1;}
       }

   }
}
