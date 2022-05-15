
package ballsgame;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class frame extends JFrame{
    ball Ball[]=new ball[6];
    screen scrn;
    Gun gun;
    BufferedImage base=null;
    BufferedImage q=null;
    BufferedImage c=null;
    BufferedImage result=null;
    static JLabel label;
    static JLabel label2;
    
    
    public frame(ball ball1, ball ball2,ball ball3,ball ball4,ball ball5,ball ball6,Gun gun,BufferedImage b,BufferedImage q,BufferedImage c,BufferedImage r){
    super("ball game");
    setLayout(null);
    setVisible(true);
    setSize(500, 500);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setResizable(false);
    this.Ball[0]=ball1;
    this.Ball[1]=ball2;
    this.Ball[2]=ball3;
    this.Ball[3]=ball4;
    this.Ball[4]=ball5;
    this.Ball[5]=ball6;
    this.gun=gun;
    this.base=b;
    this.q=q;
    this.c=c;
    this.result=r;
    
    scrn=new screen();
    scrn.setOpaque(true);
    scrn.setBounds(0,0,500,500);
    add(scrn);
    Font font=new Font("ttttt",Font.BOLD,30);
    label=new JLabel();
    label.setBounds(55, 385, 100, 50);
    label.setFont(font);
    label.setText("Score");
    label2=new JLabel();
    label2.setBounds(350, 385, 250, 50);
    label2.setFont(font);
    label2.setText("Normal");
   
    scrn.add(label);
    scrn.add(label2);
     label.setVisible(true);
    
    }
    public class screen extends JLabel{
    @Override
    protected void paintComponent(Graphics g){
    super.paintComponent(g);
    scrn.setBackground(Color.lightGray);
    javax.swing.border.Border border = BorderFactory.createLineBorder(Color.GRAY, 5);
 
    // set the border of this component
    scrn.setBorder(border);
    g.drawImage(q, 0, 0, 500, 350, null);
    g.drawImage(c, 175, 330,150, 170, null);
    g.drawImage(result, 330, 370,150, 130, null);
    g.drawImage(result, 20, 370,150, 130, null);
    g.drawImage(Ball[0].firstball, (int)Ball[0].x,(int)Ball[0].y,50,40,null);
    g.drawImage(Ball[1].firstball, (int)Ball[1].x,(int)Ball[1].y,50,40,null);
    g.drawImage(Ball[2].firstball, (int)Ball[2].x,(int)Ball[2].y,50,40,null);
    g.drawImage(Ball[3].firstball, (int)Ball[3].x,(int)Ball[3].y,50,40,null);
    g.drawImage(Ball[4].firstball, (int)Ball[4].x,(int)Ball[4].y,50,40,null);
    g.drawImage(Ball[5].firstball, (int)Ball[5].x,(int)Ball[5].y,50,40,null);
    g.drawImage(gun.shotgun, (int)gun.x,(int)gun.y, null);
    g.drawImage(base,220,400, null);
    
    
    g.setColor(Color.BLACK);
    g.drawLine(0, 350, 500, 350);
    }
    }
    
        
}
