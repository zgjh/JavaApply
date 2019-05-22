import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class DrawStringDemo extends java.awt.Frame implements MouseListener, MouseMotionListener {
  String str = "";
  
  int x, y;
  
  public static void main(String args[]){
    new DrawStringDemo();
  }
  
  // �غc�禡
  public DrawStringDemo() {
    super("Draw String Demo");

    // �]�w�I���C��
    setBackground(Color.white);

    // �w�]�ƹ�����
    setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

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
    // �]�wGraphics���󤧥ثe�C��
    g.setColor(Color.white);
    // ø�s�x�ΨåH�ثe���w���C��񺡭��n
    // �h�M���e��
    g.fillRect(0, 0, this.getSize().width, this.getSize().height);

    // �]�wGraphics���󤧥ثe�C��
    g.setColor(Color.RED);

    // �]�wGraphics���󤧤�r�r��
    g.setFont(new Font("dialog", Font.PLAIN, 12));
    
    // ø�s��r
    g.drawString(str, x, y);


    // �]�wGraphics���󤧥ثe�C��
    g.setColor(Color.BLACK);

    g.drawLine(x, 0, x, this.getSize().height);  
    g.drawLine(0, y, this.getSize().width, y);  
  }

  // ��@MouseListener��������k
  public void mousePressed(MouseEvent e){
    x = e.getX();
    y = e.getY();
    
    str = "Mouse Pressed at: " + x + ", " + y;
    repaint();
  }
  
  public void mouseReleased(MouseEvent e){
    x = e.getX();
    y = e.getY();

    str = "Mouse Released at: " + x + ", " + y;
    repaint();
  }

  public void mouseClicked(MouseEvent e){
    x = e.getX();
    y = e.getY();

    str = "Mouse Clicked at: " + x + ", " + y;
    repaint();
  }
  
  public void mouseEntered(MouseEvent e){
    x = e.getX();
    y = e.getY();

    str = "Mouse Entered at: " + x + ", " + y;
    repaint();
  }
  
  public void mouseExited(MouseEvent e){
    x = e.getX();
    y = e.getY();

    str = "Mouse Exited at: " + x + ", " + y;
    repaint();
  }
  
  // ��@MouseMotionListener��������k
  public void mouseDragged(MouseEvent e){
    x = e.getX();
    y = e.getY();

    str = "Mouse Dragged at: " + x + ", " + y;
    repaint();
  }

  public void mouseMoved(MouseEvent e){
    x = e.getX();
    y = e.getY();

    str = "Mouse Moved at: " + x + ", " + y;
    repaint();
  }
}
