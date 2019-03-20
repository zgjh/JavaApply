import java.awt.*;
import java.awt.event.*;

public class ButtonEventDemo extends java.awt.Frame implements ActionListener {
	Button[] button = new Button[6];
	public static void main(String[] args){
		new ButtonEventDemo();
	}
	public ButtonEventDemo()
	{
		super("Button Event Demo");
		setLayout(new FlowLayout());
		String[] label = {"New", "Open", "Save", "Cut", "Copy", "Paste"};
		for (int i=0; i<6; i++)
		{
			button[i] = new Button(label[i]);
			button[i].addActionListener(this);
			add(button[i]);
		}
		this.setSize(200,200);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = this.getSize();
		
		if (frameSize.height > screenSize.height)
			frameSize.height = screenSize.height;
		if (frameSize.width > screenSize.width)
			frameSize.width = screenSize.width;
		this.setLocation((screenSize.width - frameSize.width) / 2,(screenSize.height - frameSize.height) / 2);
		this.setVisible(true);
		this.addWindowListener(new WindowAdapter()
		{
			public void windowClossing(WindowEvent e)
			{
				System.exit(0);
			}
		});
	}
	public void actionPerformed(ActionEvent e)
	{
		String source = e.getActionCommand();
		switch(source){
			case "New":
				System.out.println("開啟新檔");
				break;
			case "Open":
				System.out.println("開啟舊檔");
				break;
			case "Save":
				System.out.println("存檔");
				break;
			case "Cut":
				System.out.println("剪下");
				break;
			case "Copy":
				System.out.println("複製");
				break;
			case "Paste":
				System.out.println("貼上");
				break;
		}
	}
}