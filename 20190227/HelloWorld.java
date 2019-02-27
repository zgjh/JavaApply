import java.awt.*;

public class HelloWorld extends java.awt.Frame {
	public static void main (String args[]) {
		new HelloWorld();
	}
	
	public HelloWorld(){
		
		this.setTitle("Hello MCU ITE");
		this.setSize(200, 200);
		this.setVisible(true);
	}
	
}