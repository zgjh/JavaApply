import java.awt.*;
import java.awt.event.*;

public class MouseEventDemo extends java.awt.Frame implements MouseWheelListener {
	public static void main(String[] args) {
		new MouseEventDemo();
	}
	public MouseEventDemo() {
		super("Mouse Event Demo");
		this.addMouseWheelListener(this);
		this.setSize(new Dimension(200, 200));
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = this.getSize();
		
		if (frameSize.height > screenSize.height)
		frameSize.height = screenSize.height;
		if (frameSize.width > screenSize.width)
		frameSize.width = screenSize.width;
		this.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
		this.setVisible(true);
	}
	public void mouseWheelMoved(MouseWheelEvent e) {
		System.out.println("Mouse Wheel Rolled");
	}
}