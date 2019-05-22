import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class DrawImageDemo extends java.awt.Frame implements MouseListener, MouseMotionListener {
  int x, y, x1, x2, y1, y2;

  Image image;
  
  boolean mouseUp = false, mouseDrag = false;
  
  public static void main(String args[]){
    new DrawImageDemo();
  }
  
  // �غc�禡
  public DrawImageDemo() {
    super("Draw Image Demo");

    // �]�w�I���C��
    setBackground(Color.white);

    // Ū��Java Archive�ɮפ����Ϲ��ɮ�
    ClassLoader cl = this.getClass().getClassLoader();
    Toolkit tk = Toolkit.getDefaultToolkit();

    // ���o�Ϲ�
    image = tk.createImage(cl.getResource("images/SuperDuke.gif"));

    // ���U MouseListener
    this.addMouseListener(this);    
    // ���U MouseMotionListener
    this.addMouseMotionListener(this);    

    // �]�w�������j�p
    this.setSize(250, 250);

    // Center the frame
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    Dimension frameSize = this.getSize();

    if (frameSize.height > screenSize.height)
      frameSize.height = screenSize.height;

    if (frameSize.width > screenSize.width)
      frameSize.width = screenSize.width;

    this.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);

    // ��ܵ���
    this.setVisible(true);

    this.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
  }

  public void update(Graphics g) {
    paint(g);
  }

  public void paint (Graphics g) {
    if (mouseUp || mouseDrag) {
      int imgWidth = x2 - x1;
      int imgHeight = y2 - y1; 
      
      // �]�wGraphics���󤧥ثe�C��
      g.setColor(Color.white);
      // ø�s�x�ΨåH�ثe���w���C��񺡭��n
      // �h�M���e��
      g.fillRect(0, 0, this.getSize().width, this.getSize().height);
      
      // ø�s�Ϲ����Y��Ϲ��ܫ��w���e�׻P����  
      g.drawImage(image, x1, y1, imgWidth, imgHeight, null);
    }
  }

  // ��@MouseListener��������k
  public void mousePressed(MouseEvent e) {
    x1 = e.getX();
    y1 = e.getY();
    mouseUp = false;
    mouseDrag = false;
  }

  public void mouseReleased(MouseEvent e) {
    mouseUp = true;
    repaint(); 
  }
  public void mouseClicked(MouseEvent e){}
  public void mouseEntered(MouseEvent e){}
  public void mouseExited(MouseEvent e){}

  // ��@MouseMotionListener��������k
  public void mouseDragged(MouseEvent e) {
    x2 = Math.max(e.getX(), x1);
    y2 = Math.max(e.getY(), y1);
    x1 = Math.min(e.getX(), x1);
    y1 = Math.min(e.getY(), y1);

    mouseDrag = true;
    repaint(); 
  }

  public void mouseMoved(MouseEvent e){}
}
