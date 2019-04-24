import java.awt.*;
import java.awt.event.*;

public class MenuDemo extends java.awt.Frame {

  public static void main(String args[]){
    new MenuDemo();
  }
  
  // �غc�禡
  public MenuDemo() {
    super("Menu Demo");

    // �إ߿��C
    MenuBar menuBar = new MenuBar();

    // �w�q���������C
    setMenuBar(menuBar);

    Menu menu[] = new Menu[2];
    
    // �إ�File���
    menu[0] = new Menu("File");
    // �s�W���ܿ��C
    menuBar.add(menu[0]);

    // �إߤl���
    Menu submenu = new Menu("Sub Menu");
    // �s�W�l���ܿ�椤
    menu[0].add(submenu);
    menu[0].addSeparator();
	
    // �إ�Help���
    menu[1] = new Menu("Help");
    // �s�W���j�u�]�t�@�ؤ覡�^
    menu[1].add("-");

    // �]�w���C�������U�������]Help Menu�^
    menuBar.setHelpMenu(menu[1]);

    // ���o���C�Ҧ���檺�ƥ�
    for (int i=0; i<menuBar.getMenuCount(); i++) {
      // ���o���C�����windex�����
      System.out.println("Menu " + i + ": " + menuBar.getMenu(i).getLabel());
    }

    // ���o�U���Ҧ���涵�ت��ƥ�
    for (int i=0; i<menu.length; i++) {
      for (int j=0; j<menu[i].getItemCount(); j++) {
        // ���o�U�����windex����涵��
        System.out.println("Menu Item " + j + " at " + menu[i].getLabel() + " menu: " + menu[i].getItem(j).getLabel());
      }
    }

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
}