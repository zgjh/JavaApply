import java.awt.*;
import java.awt.event.*;

public class TextFieldEventDemo extends java.awt.Frame implements FocusListener {

  public static void main(String args[]){
    new TextFieldEventDemo();
  }
  
  // �غc�禡
  public TextFieldEventDemo() {
    super("TextField Event Demo");

    // �w�q Layout Manager �� FlowLayout
    setLayout(new FlowLayout());

    TextField[] textfield = new TextField[4];

    // �غc�禡 1
    textfield[0] = new TextField();
    // �]�w��r��쪺��ܤ�r
    textfield[0].setText("TextField 1");
    // �]�w��r��쪺��ܤ�r�r��
    textfield[0].setColumns(6);
    // �]�w�I���C��
    textfield[0].setBackground(Color.PINK);
    // �]�w�e���C��
    textfield[0].setForeground(Color.CYAN);
    // ����Ҧ�����r���e
    textfield[0].selectAll();
    // ���U FocusListener
    textfield[0].addFocusListener(this);
    add(textfield[0]);

    // �غc�禡 2
    textfield[1] = new TextField("TextField 2");
    // �]�w�^���r��
    textfield[1].setEchoChar('*');
    // ���U FocusListener
    textfield[1].addFocusListener(this);
    add(textfield[1]);

    // �غc�禡 3
    textfield[2] = new TextField(8);
    // �]�w��r��쪺��ܤ�r
    textfield[2].setText("TextField 3");
    // �]�w�O�_���\�s��
    textfield[2].setEditable(false);
    // ���U FocusListener
    textfield[2].addFocusListener(this);
    add(textfield[2]);

    // �غc�禡 4
    textfield[3] = new TextField("TextField 4", 8);
    // �����selectionStart�ҩl��m
    // ��selectionEnd������m����r���e
    textfield[3].select(3, 8);
    // ���U FocusListener
    textfield[3].addFocusListener(this);
    add(textfield[3]);

    // �]�w�������j�p
    this.setSize(200, 100);

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

  // ���o��J�J�I��
  public void focusGained(FocusEvent e) {
    Component com = e.getComponent();

    if (com instanceof TextField) {
      TextField textfield = (TextField) com;

      //����Ҧ�����r���e
      textfield.selectAll();
    } 
  }

  // ���h��J�J�I��
  public void focusLost(FocusEvent e) {} 
}
