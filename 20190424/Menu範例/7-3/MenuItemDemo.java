import java.awt.*;
import java.awt.event.*;

// ��@ActionListener����
public class MenuItemDemo extends java.awt.Frame implements ActionListener {

  Menu menu[] = new Menu[2];
  MenuItem menuitem[] = new MenuItem[8];

  // Demo only
  Label label;

  public static void main(String args[]){
    new MenuItemDemo();
  }
  
  // �غc�禡
  public MenuItemDemo() {
    super("Menu Item Demo");

    // �w�q Layout Manager �� BorderLayout
    setLayout(new BorderLayout());
    
    // Demo only
    label = new Label();
    add(label, BorderLayout.SOUTH);

    // �إ߿��C
    MenuBar menuBar = createMenuBar();

    // �w�q�����ϥΪ̤��������C
    setMenuBar(menuBar);

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

  private MenuBar createMenuBar() {
    // �إ߿��C
    MenuBar menuBar = new MenuBar();

    // �إ߿��
    menu[0] = new Menu("File");

    // �إ߿�涵��
    menuitem[0] = new MenuItem("New");
    // ���U ActionListener
    menuitem[0].addActionListener(this);

    menuitem[1] = new MenuItem("Open");
    // ���U ActionListener
    menuitem[1].addActionListener(this);

    menuitem[2] = new MenuItem("Save");
    // ���U ActionListener
    menuitem[2].addActionListener(this);

    menuitem[3] = new MenuItem("Save As...");
    // ���U ActionListener
    menuitem[3].addActionListener(this);

    menuitem[4] = new MenuItem("Exit");
    // ���U ActionListener
    menuitem[4].addActionListener(this);

    // �s�W��涵��
    menu[0].add(menuitem[0]);
    menu[0].add(menuitem[1]);
    // �s�W���j�u�]�t�@�ؤ覡�^
    menu[0].add("-");
    menu[0].add(menuitem[2]);
    menu[0].add(menuitem[3]);
    // �s�W���j�u
    menu[0].addSeparator();
    menu[0].add(menuitem[4]);
    
    // �s�W���ܿ��C
    menuBar.add(menu[0]);

    // �إ�Help���
    menu[1] = new Menu("Help");

    menuitem[5] = new MenuItem("Index");
    // ���U ActionListener
    menuitem[5].addActionListener(this);

    menuitem[6] = new MenuItem("Use Help");
    // ���U ActionListener
    menuitem[6].addActionListener(this);

    menuitem[7] = new MenuItem("About");
    // ���U ActionListener
    menuitem[7].addActionListener(this);

    menu[1].add(menuitem[5]);
    menu[1].add(menuitem[6]);
    menu[1].add("-");
    menu[1].add(menuitem[7]);

    // �]�w���C�������U�������]Help Menu�^
    menuBar.setHelpMenu(menu[1]);

    return menuBar;
  }

  // ��@ActionListener��������k
  public void actionPerformed(ActionEvent e) {
    if (e.getSource().equals(menuitem[4])) { // Exit
      System.exit(0);
    }
    else {
      // ���o���Ͱʧ@�ƥ󪺿�涵��
      MenuItem menuitem = (MenuItem)e.getSource();
      label.setText("Select "  + menuitem.getLabel() + " Menu Item.");
    }
  }
}