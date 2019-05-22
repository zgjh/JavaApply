import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class GraphicsDemo extends java.awt.Frame implements AdjustmentListener, ItemListener, MouseListener, MouseMotionListener {
  Choice choice;
 
  Scrollbar scrollbar[] = new Scrollbar[3] ;
 
  String styles[] = {"Draw Line", "Draw Oval", "Draw Rect", 
    "Draw Round Rect", "Fill Oval", "Fill Rect", "Fill Round Rect"};

  int index, x1, x2, y1, y2;

  int red = 0;
  int green = 0;
  int blue = 0;

  boolean mouseUp = false, mouseDrag = false;
  
  public static void main(String args[]){
    new GraphicsDemo();
  }
  
  // �غc�禡
  public GraphicsDemo() {
    super("Graphics Demo");

    // �]�w�I���C��
    setBackground(Color.white);

    setLayout(new BorderLayout());

    index = 0;

    choice = new Choice();
    
    // �]�wChoice�ﶵ����
    for (int i=0; i < styles.length; i++)    
      choice.add(styles[i]);

    // ����ﶵ����
    choice.select(index);
  
    // ���U ItemListener
    choice.addItemListener(this);

    Panel panel1 = new Panel();
    panel1.add(choice);
    
    Panel panel2 = new Panel();
    panel2.setLayout(new GridLayout(3, 1));

    for (int i=0; i < 3; i++) {
      // �]�w�t�m��V���������ʶb
      //     �ثe�Ȭ�0, ���b����j�p�Ȭ�0
      //     �̤p�Ȭ�0, �̤j�Ȭ�256
      scrollbar[i] = new Scrollbar(Scrollbar.HORIZONTAL, 0, 0, 0, 256);

      // ���U AdjustmentListener
      scrollbar[i].addAdjustmentListener(this);

      panel2.add(scrollbar[i]);
    }
  
    this.add(panel1, BorderLayout.NORTH);
    this.add(panel2, BorderLayout.SOUTH);
    
    // ���U MouseListener
    this.addMouseListener(this);    
    // ���U MouseMotionListener
    this.addMouseMotionListener(this);  

    // �]�w�������j�p
    this.setSize(300, 300);

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

  public void paint (Graphics g) {
    if (mouseUp || mouseDrag) {
      int width = x2 - x1;
      int height = y2 - y1; 

      // �]�wGraphics���󤧥ثe�C��
      g.setColor(new Color(red, green, blue)); 

      switch (index) {
        case 0:
          g.drawLine(x1, y1, x2, y2);  
          break;
        case 1:
          g.drawOval(x1, y1, x2-x1, y2-y1); 
          break;
        case 2:
          g.drawRect(x1, y1, x2-x1, y2-y1); 
          break;
        case 3:
          g.drawRoundRect(x1, y1, x2-x1, y2-y1, 10, 10); 
          break;
        case 4:
          g.fillOval(x1, y1, x2-x1, y2-y1); 
          break;
        case 5:
          g.fillRect(x1, y1, x2-x1, y2-y1); 
          break;
        case 6:
          g.fillRoundRect(x1, y1, x2-x1, y2-y1, 10, 10); 
          break;
        default:
          break;
      }
    }
  }

  // ��@AdjustmentListener��������k
  public void adjustmentValueChanged(AdjustmentEvent e) {
    // ���o���ͽծըƥ󤧪��� 
    Scrollbar sb = (Scrollbar)(e.getAdjustable());

    // ���o���ͽծըƥ�ɱ��ʶb���ثe��
    if (sb == scrollbar[0])
      red = sb.getValue();
    else if (sb == scrollbar[1])
      green = sb.getValue();
    else if (sb == scrollbar[2])
      blue = sb.getValue();
  }
  
  // ��@ItemListener��������k
  public void itemStateChanged(ItemEvent e) {
    Choice ch = (Choice)(e.getItemSelectable());
    
    index = ch.getSelectedIndex();
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
    if (index == 0){
      x2 = e.getX();
      y2 = e.getY();
    } 
    else {
      x2 = Math.max(e.getX(), x1);
      y2 = Math.max(e.getY(), y1);
      x1 = Math.min(e.getX(), x1);
      y1 = Math.min(e.getY(), y1);
    }
    mouseDrag = true;
    repaint(); 
  }

  public void mouseMoved(MouseEvent e){}
}
