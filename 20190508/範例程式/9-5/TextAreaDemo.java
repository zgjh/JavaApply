import java.awt.*;
import java.awt.event.*;

public class TextAreaDemo extends java.awt.Frame {

  public static void main(String args[]){
    new TextAreaDemo();
  }
  
  // �غc�禡
  public TextAreaDemo() {
    super("TextArea Demo");

    final int row = 2;    // �C
    final int column = 2; // ��

    // �w�q Layout Manager �� GridLayout
    setLayout(new GridLayout(row, column));

    java.awt.TextArea textarea;

    // �غc�禡 1
    textarea = new TextArea();
    // �]�w��ܤ�r
    textarea.setText("TextArea 1");
    // �]�wTextArea����ܦC��
    textarea.setRows(5);
    // �]�wTextArea����ܦ��
    textarea.setColumns(20);

    java.awt.Panel panel1 = new Panel();
    panel1.add(textarea);
    add(panel1);

    // �غc�禡 2
    textarea = new TextArea(8,12);
    // �]�w��ܤ�r
    textarea.setText("TextArea 2");
    // ���[��r�r���TextArea����
    textarea.append(" append text");
    // ����Ҧ�����r���e
    textarea.selectAll();

    java.awt.Panel panel2 = new Panel();
    panel2.add(textarea);
    add(panel2);

    // �غc�禡 3
    textarea = new TextArea("TextArea 3");
    // �]�wTextArea����ܦC��
    textarea.setRows(6);
    // �]�wTextArea����ܦ��
    textarea.setColumns(15);
    // �۲�pos��m����A���J��r�r��
    textarea.insert("insert text", 5);
    // �����selectionStart�ҩl��m
    // ��selectionEnd������m����r���e
    textarea.select(3, 8);

    java.awt.Panel panel3 = new Panel();
    panel3.add(textarea);
    add(panel3);

    // �غc�禡 5
    textarea = new TextArea("TextArea with only vertical scrollbar", 8, 15, TextArea.SCROLLBARS_VERTICAL_ONLY);
    // �]�w�I���C��
    textarea.setBackground(new Color(120,50,0));
    // �]�w�e���C��
    textarea.setForeground(new Color(245,185,60));

    java.awt.Panel panel4 = new Panel();
    panel4.add(textarea);
    add(panel4);

    // �]�w�������j�p
    this.setSize(320, 320);

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
