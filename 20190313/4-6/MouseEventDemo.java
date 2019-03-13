import java.awt.*;
import java.awt.event.*;

public class MouseEventDemo extends java.awt.Frame implements MouseListener, MouseMotionListener{
	public static void main(String[] args) {
		new MouseEventDemo();
	}
	
	public MouseEventDemo() {
		super("Mouse Event Demo");
		
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
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
	public void mouseClicked(MouseEvent e) {
		System.out.println("Mouse Clicked");
	}
	public void mouseEntered(MouseEvent e) {
		System.out.println("Mouse Entered");
	}
	public void mouseExited(MouseEvent e) {
		System.out.println("Mouse Exited");
	}
	public void mousePressed(MouseEvent e) {
		System.out.println("Mouse Pressed" + "\tX:" + e.getX() + "\tY:" + e.getY());
	}
	public void mouseReleased(MouseEvent e) {
		System.out.println("Mouse Released");
	}
	public void mouseDragged(MouseEvent e) {
		System.out.println("Mouse Dragged");
	}
	public void mouseMoved(MouseEvent e) {
		System.out.println("X:" + e.getX() + "\tY:" + e.getY());
	}
}