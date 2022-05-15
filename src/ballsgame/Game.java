
package ballsgame;

import static ballsgame.Ballsgame.gun1;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Level;
import java.util.logging.Logger;

public  class Game implements Runnable{
ball ball1=null;
frame frame1;
Gun gun=null;
int i;
static int random=0;

public Game(ball ball1,frame frame1,int i){
this.ball1=ball1;
this.frame1=frame1;
this.i=i;
}
public Game(frame frame1,Gun gun,int i){
this.frame1=frame1;
this.gun=gun;
this.i=i;
}

    @Override
    public void run() {
        
  while (true){
      
      if(Gun.sum<30){
       if(ball1!=null){
          ball1.update();
          if(ball1.isShot)
          {
              ball1.x=0;
              ball1.y=0;
              ball1.isShot=false;
              try {
                  Thread.sleep(1000);
              } catch (InterruptedException ex) {
                  Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
              }
          }
       }
      if(gun!=null)
      {
          gun.update();
          if(gun.y==gun.z)
          {
              Ballsgame.shm=false;
              break;
          }
      }

  
  
      frame1.scrn.repaint();

      try {
          Thread.sleep(i);
      } catch (InterruptedException ex) {
          Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
      }
  }
    }
  if(Ballsgame.Mode==true){
  gun1.random=(int) (6*Math.random());
        frame.label2.setText(Gun.c[gun1.random]);
  }

    }
}
