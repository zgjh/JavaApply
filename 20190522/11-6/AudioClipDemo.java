import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class AudioClipDemo extends java.applet.Applet implements Runnable, MouseListener {
  int width, height;

  int x = 0, y = 0;  
  int dx = 1, dy = 1;  

  boolean horizontal = true;
  
  Image image;
  AudioClip clip;

  // �����
  Thread thread;

  // �غc�禡
  public AudioClipDemo() {
  }
  
  public void init(){
    setBackground(Color.white);

    // Applet Size
    width = this.getSize().height;
    height = this.getSize().width;

    // Ū��Java Archive�ɮפ����Ϲ��ɮ�
    ClassLoader cl = this.getClass().getClassLoader();
    Toolkit tk = Toolkit.getDefaultToolkit();

    // ���o�Ϲ�
    image = tk.createImage(cl.getResource("images/duke.gif"));

    // ���o�����ɮ�
    clip = getAudioClip(cl.getResource("audio/sound.au"));       
    
    // ���U MouseListener
    this.addMouseListener(this);    
  }

  public void start() {
    thread = new Thread(this);
    // �}�l�����
    thread.start();
  }

  public void stop() {
    // ��������
    thread.yield();
  }

  public void destroy()  {
    // ��������
    thread.yield();
  }

  public void run() {
    while (true) {
      if (horizontal) {
        if (x > width - 50)  {
          dx = -1;
  
          // ���񭵮�
          clip.play();
        }
        else if (x < 0) {
          dx = +1;
  
          // ���񭵮�
          clip.play();
        }
  
        x = x + dx;
      }
      else {
        if (y > height - 55)  {
          dy = -1;
  
          // ���񭵮�
          clip.play();
        }
        else if (y < 0) {
          dy = +1;
  
          // ���񭵮�
          clip.play();
        }
  
        y = y + dy;
      }

      repaint();

      try {
        // �Ȱ������
        Thread.sleep(20);
      }
      catch (InterruptedException ex) { }
    }
  }

  public void update(Graphics g) {
    paint(g);
  }

  public void paint(Graphics g) {
    // Applet Size
    width = this.getSize().height;
    height = this.getSize().width;

    // �]�wGraphics���󤧥ثe�C��
    g.setColor(Color.white);
    // ø�s�x�ΨåH�ثe���w���C��񺡭��n
    // �h�M���e��
    g.fillRect(0, 0, width, height);
    
    // ø�s�Ϲ�
    g.drawImage(image, x, y, null);
  }

  // ��@MouseListener��������k
  public void mousePressed(MouseEvent e) {}
  public void mouseReleased(MouseEvent e) {}
  public void mouseClicked(MouseEvent e){
    if (horizontal)
      horizontal = false;
    else
      horizontal = true;

    repaint(); 
  }
  
  public void mouseEntered(MouseEvent e){}
  public void mouseExited(MouseEvent e){}
}
