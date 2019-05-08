import java.awt.*;
import java.awt.event.*;

public class TextAreaEventDemo extends java.awt.Frame {

  java.awt.TextArea textarea;

  public static void main(String args[]){
    new TextAreaEventDemo();
  }
  
  // �غc�禡
  public TextAreaEventDemo() {
    super("TextArea Event Demo");

    textarea = new TextArea();
    // �]�w��ܤ�r
    textarea.setText("TextArea Event Demo");
    // �]�wTextArea����ܦC��
    textarea.setRows(10);
    // �]�wTextArea����ܦ��
    textarea.setColumns(30);

    // �HInner Class���覡�ϥ�TextListener����
    textarea.addTextListener(new TextListener() {
      public void textValueChanged(TextEvent e) {
        if (e.getID() == TextEvent.TEXT_VALUE_CHANGED)
          System.out.println("��r�ϰ줺�e����");
      }
    });

    java.awt.Panel panel1 = new Panel();
    panel1.add(textarea);
    add(panel1);

    // �]�w�������j�p
    this.setSize(250, 220);

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
