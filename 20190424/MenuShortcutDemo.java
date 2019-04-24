import java.awt.*;
import java.awt.event.*;

public class MenuShortcutDemo extends java.awt.Frame implements ActionListener, ItemListener {

  String menulabel[]={"File", "Edit", "Draw", "Help"};

  String menuitemlabel[][]={
    {"New", "-", "Open", "Save", "Save As...", "-", "Exit"},
    {"Copy", "Cut", "Paste"},
	{"Shape", "Line", "Pot"},
	{"Help"},
  };
  
  String cbmenuitemlabel[]={"Circle", "Rectangle"};
  
  int menuShortCut[][]={
    {KeyEvent.VK_N, 0, KeyEvent.VK_O, KeyEvent.VK_S, KeyEvent.VK_A, 0,KeyEvent.VK_E},
    {KeyEvent.VK_C, KeyEvent.VK_X, KeyEvent.VK_V},
	{0, KeyEvent.VK_L, KeyEvent.VK_P},
	{KeyEvent.VK_H}
  };

  int cbmenuShortCut[]={KeyEvent.VK_R, KeyEvent.VK_T};

  Menu menu[] = new Menu[4];
  MenuItem menuitem[][] = new MenuItem[4][12];
  CheckboxMenuItem checkboxmenuitem[] = new CheckboxMenuItem[2];

  // Demo only
  Label label;

  public static void main(String args[]){
    new MenuShortcutDemo();
  }
  
  // �غc�禡
  public MenuShortcutDemo() {
    super("Menu Shortcut Demo");

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
    for (int i=0; i<menulabel.length; i++){
      // �إ߿��
      menu[i] = new Menu(menulabel[i]);
      menu[i].setFont(new Font("dialog", Font.PLAIN, 11));

      // �s�W���ܿ��C
      menuBar.add(menu[i]);
    }

    for(int i=0; i<menulabel.length; i++){
      for(int j=0; j<menuitemlabel[i].length; j++){
        if (i==2 && j==0) { // �l���
          // �إߤl���
          Menu submenu = new Menu(menuitemlabel[i][j]);
          submenu.setFont(new Font("dialog", Font.PLAIN, 11));
          
          // �إ߮֨������涵��
          for (int k=0; k<cbmenuitemlabel.length; k++){
            checkboxmenuitem[k] = new CheckboxMenuItem(cbmenuitemlabel[k]);
            
            // �]�w�֨������涵�ؤ�������A
            if (k==0) 
              checkboxmenuitem[k].setState(false);
            
            // �]�w�֨������涵�ت����ֳt��
            checkboxmenuitem[k].setShortcut(new MenuShortcut(cbmenuShortCut[k], false));
            checkboxmenuitem[k].setFont(new Font("dialog", Font.PLAIN, 11));

            // ���U ItemListener
            checkboxmenuitem[k].addItemListener(this);
      
            // �s�W�֨������涵�ئܤl���
            submenu.add(checkboxmenuitem[k]);
          }
      
          menu[i].add(submenu);
        }
        else if (menuitemlabel[i][j].equals("-")) {
          // �s�W���j�u
          menu[i].addSeparator();
        }
        else {
          // �إ߿�涵�بèϥο��ֳt��
          if (menuShortCut[i][j] != 0) 
            menuitem[i][j] = new MenuItem(menuitemlabel[i][j], new MenuShortcut(menuShortCut[i][j], false));
          else
            menuitem[i][j] = new MenuItem(menuitemlabel[i][j]);

          menuitem[i][j].setFont(new Font("dialog", Font.PLAIN, 11));

          // ���U ActionListener
          menuitem[i][j].addActionListener(this);

          // �s�W��涵��
          menu[i].add(menuitem[i][j]);
        }          
      }
    }

    return menuBar;
  }

  // ��@ActionListener��������k
  public void actionPerformed(ActionEvent e) {
    // ���o���Ͱʧ@�ƥ󪺿�涵��
    MenuItem menuitem = (MenuItem)e.getSource();

    if (menuitem.getLabel().equals("Exit")) { // Exit
      System.exit(0);
    }
    else {
      label.setText("Select "  + menuitem.getLabel() + " Menu Item.");
    }
  }

  public void itemStateChanged(ItemEvent e) {
    // ���o���Ͷ��بƥ󪺪���
    CheckboxMenuItem cbmi = (CheckboxMenuItem)(e.getItemSelectable());
    
    for (int i=0; i < checkboxmenuitem.length; i++) {
      if(cbmi == checkboxmenuitem[i]) {
        checkboxmenuitem[i].setState(true);

        label.setText("Select " + checkboxmenuitem[i].getLabel() + " Checkbox Menu Item.");
      }
      else
        checkboxmenuitem[i].setState(false);
    }
  }
}