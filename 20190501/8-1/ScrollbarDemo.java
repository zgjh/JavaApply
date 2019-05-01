import java.awt.*;
import java.awt.event.*;

public class ScrollbarDemo extends java.awt.Frame {

  public static void main(String args[]){
    new ScrollbarDemo();
  }
  
  // �غc�禡
  public ScrollbarDemo() {
    super("Scrollbar Demo");

    // �w�q Layout Manager �� BorderLayout
    setLayout(new BorderLayout());

    java.awt.Scrollbar scrollbar;

    // �غc�禡 1
    scrollbar = new Scrollbar();
    // �]�w���b�̤j��
    scrollbar.setMaximum(300);
    // �]�w���b�̤p��
    scrollbar.setMinimum(0);
    // �]�w���b���t�m��V���������b
    scrollbar.setOrientation(Scrollbar.HORIZONTAL);
    // �]�w���b������j�p��
    scrollbar.setVisibleAmount(5);
    // �]�w���b���ثe��
    scrollbar.setValue(50);
    add(scrollbar, BorderLayout.SOUTH);

    // �غc�禡 3
    // �]�w�t�m��V���������b
    //     �ثe�Ȭ�100
    //     ���b����j�p�Ȭ�60
    //     �̤p�Ȭ�0
    //     �̤j�Ȭ�300
    scrollbar = new Scrollbar(Scrollbar.VERTICAL, 100, 60, 0, 300);
    add(scrollbar, BorderLayout.EAST);

    // �]�w�������j�p
    this.setSize(200, 200);

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
}
