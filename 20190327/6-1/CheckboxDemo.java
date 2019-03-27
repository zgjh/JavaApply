import java.awt.*;
import java.awt.event.*;

public class CheckboxDemo extends java.awt.Frame implements ItemListener {
	java.awt.Checkbox[] checkbox = new Checkbox[6];
  public static void main(String args[]){
    new CheckboxDemo();
  }
  
  // 建構函式
  public CheckboxDemo() {
    super("Checkbox Demo");

    final int row = 2;    // 列
    final int column = 1; // 行

    // 定義 Layout Manager 為 GridLayout
    setLayout(new GridLayout(row, column));

    java.awt.Panel panel1 = new Panel();

    // 建構函式 1
    checkbox[0] = new Checkbox();
    // 設定Checkbox類別之文字標籤
    checkbox[0].setLabel("Checkbox 0");
    // 設定Checkbox類別的選取狀態
    checkbox[0].setState(true);
	checkbox[0].addItemListener(this);
    panel1.add(checkbox[0]);

    // 建構函式 2
    checkbox[1] = new Checkbox("Checkbox 1");
    // 設定Checkbox類別的選取狀態
    checkbox[1].setState(false);
	checkbox[1].addItemListener(this);
    panel1.add(checkbox[1]);

    // 建構函式 3
    checkbox[2] = new Checkbox("Checkbox 2", true);
	checkbox[2].addItemListener(this);
    panel1.add(checkbox[2]);

    add(panel1);

    java.awt.Panel panel2 = new Panel();

    // 建構群組
    java.awt.CheckboxGroup group = new CheckboxGroup() ;

    // 建構函式 1
    checkbox[3] = new Checkbox();
    // 設定Checkbox類別之文字標籤
    checkbox[3].setLabel("Checkbox 3");
    // 設定Checkbox類別的群組
    checkbox[3].setCheckboxGroup(group);
	checkbox[3].addItemListener(this);
    panel2.add(checkbox[3]);

    // 建構函式 4
    checkbox[4] = new Checkbox("Checkbox 4", false, group);
    // 設定是否回應互動
    checkbox[4].setEnabled(false);
	// 設定Checkbox類別的群組
    checkbox[4].setCheckboxGroup(group);
	checkbox[4].addItemListener(this);
    panel2.add(checkbox[4]);

    // 建構函式 5
    // 設定Checkbox類別的選取狀態
    checkbox[5] = new Checkbox("Checkbox 5", group, false);
    // 設定Checkbox類別的群組
    checkbox[5].setCheckboxGroup(group);
	checkbox[5].addItemListener(this);
    panel2.add(checkbox[5]);

    add(panel2);

    // 以CheckboxGroup的setSelectedCheckbox方法
    // 設定Checkbox群組中被選取的項目（Item）
    group.setSelectedCheckbox(checkbox[3]);

    // 設定視窗的大小
    this.setSize(400, 100);

    // Center the frame
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    Dimension frameSize = this.getSize();

    if (frameSize.height > screenSize.height)
      frameSize.height = screenSize.height;

    if (frameSize.width > screenSize.width)
      frameSize.width = screenSize.width;

    this.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);

    // 顯示視窗
    this.setVisible(true);

    this.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
  }
  
  public void itemStateChanged(ItemEvent e) {
    String source = null;

    // 取得產生項目事件的物件
    Checkbox cb = (Checkbox)(e.getItemSelectable());
    
    for (int i=0; i < checkbox.length; i++) {
      if(cb == checkbox[i]) {
        checkbox[i].setState(true);
        source = "Select " + checkbox[i].getLabel() + " checkbox";
      }
      else
        checkbox[i].setState(false);
    }

    System.out.println(source);
  }
}
