import java.awt.*;
import java.awt.event.*;

public class ListDemo extends java.awt.Frame implements ItemListener {
  java.awt.List list;
  java.awt.Panel panel;
  public static void main(String args[]){
    new ListDemo();
  }
  
  // 建構函式
  public ListDemo() {
    super("List Demo");

    final int row = 1;    // 列
    final int column = 3; // 行

    // 定義 Layout Manager 為 GridLayout
    setLayout(new GridLayout(row, column));

    // 建構函式 1
    // 預設顯示項目列數為4
    // 且不允許多重選擇項目
    list = new List();
    list.addItemListener(this);
    // 設定List選取項目
    for (int i=0; i < 5; i++)  {  
	
      list.add("List " + i);
	}
      
    // 設定是否允許項目被多重選擇  
    list.setMultipleMode(false);

    // 選取選項項目
    list.select(3);

    panel = new Panel();
    panel.add(list);
    add(panel);

    // 建構函式 2
    // 可顯示的項目列數為5
    list = new List(6);
    list.addItemListener(this);
    // 設定List選取項目（Item）
    for (int i=0; i < 10; i++) {  
	list.add("List " + i);
	}
      
    // 設定是否允許項目被多重選擇  
    list.setMultipleMode(true);

    // 選取選項項目
	list.select(2);
    list.select(4);
    list.select(6);

    panel = new Panel();
    panel.add(list);
    add(panel);
	
	panel = new Panel();
    // Demo Only
    //panel.setText("Total items: " + list.getItemCount() + ",    First Item: " + list.getItem() + ",    Init Selected Index: " + list.getSelectedIndex());
    add(panel);

    // 設定視窗的大小
    this.setSize(420, 150);

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
    List li = (List)(e.getItemSelectable());
    if(li.isMultipleMode()==true){
		source = "Total items: " +li.getItemCount() + ", Select Item: ";
		int []iA = li.getSelectedIndexes();
		String[]sA=li.getSelectedItems();
		System.out.print(source);
		for (int i=0; i < iA.length; i++) {
			if(i+1 < iA.length) 
				System.out.print(sA[i]+",");
			else
				System.out.print(sA[i]);
		}
	System.out.println("");
  }
  else{
	  source = "Total items: " +li.getItemCount() + ", Select Item: " + li.getSelectedItem();
	  System.out.println(source);
	}
  }
}