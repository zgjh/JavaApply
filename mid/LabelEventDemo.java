import java.awt.*;
import java.awt.event.*;

public class LabelEventDemo extends java.awt.Frame implements ActionListener{
	Button button = new Button();
  public static void main(String args[]){
    new LabelEventDemo();
  }
  
  // �غc�禡
  public LabelEventDemo() {
    super("Label Demo");

    final int row = 2;    // �C
    final int column = 3; // ��

    // �w�q Layout Manager �� GridLayout
    setLayout(new GridLayout(row, column));

    java.awt.Label label;
    
    // �غc�禡 1
    label = new Label();
    // �]�wLabel���O����ܤ�r
    label.setText("�V�����");
    // �]�wLabel���O������覡�A�V�����
    label.setAlignment(Label.LEFT);
    add(label);

    // �غc�禡 2
    label = new Label("�V�������");
    // �]�wLabel���O������覡�A�V�������
    label.setAlignment(Label.CENTER);
    add(label);
	label.addMouseMotionListener(new MouseMotionListener(){ 
			public void mouseMoved( MouseEvent e)
			{
				System.out.println("X=" + e.getX() + "\tY=" + e.getY()); 
			}
			public void mouseDragged( MouseEvent e)
			{
				System.out.println("X=" + e.getX() + "\tY=" + e.getY()); 
			}
			});

    // �غc�禡 3
    // �]�wLabel���O������覡�A�V�k���
    label = new Label("�V�k���", Label.RIGHT);
    add(label);
    // �ϥ�Component��H���O�Ҵ��Ѫ���k
    // �]�w�r�� - �ʱ���r��
    label = new Label("Font Demo", Label.LEFT);
    label.setFont(new Font("dialog", Font.BOLD | Font.ITALIC, 10));
    add(label);

    // �]�w�C��
    label = new Label("Color Demo", Label.CENTER);
    // �]�w�I���C��
    label.setBackground(new Color(120,50,0));
    // �]�w�e���C��
    label.setForeground(new Color(245,185,60));
    add(label);
	
	button = new Button("Type me");
	button.addActionListener(this);
	add(button);

    // �]�w�������j�p
    this.setSize(250, 200);

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
  public void actionPerformed(ActionEvent e)
	{
		String source = e.getActionCommand();
		switch(source){
			case "Type me":
				System.out.println("����");
				break;
		}
	}
}
