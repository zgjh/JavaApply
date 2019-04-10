import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*; 

class BoderLayoutDemo extends JFrame { 

	BoderLayoutDemo() 
	{ 
		JPanel pa = new JPanel(); 
		pa.setLayout(new BorderLayout()); 
		pa.add(new JButton("NORTH"), BorderLayout.NORTH); 
		pa.add(new JButton("SOUTH"), BorderLayout.SOUTH); 
		pa.add(new JButton("EAST"), BorderLayout.EAST); 
		pa.add(new JButton("WEST"), BorderLayout.WEST); 
		add(pa); 
		setSize(300, 300); 
		setVisible(true); 
	} 
} 

class EWSNbutton { 
	public static void main(String[] args) 
	{ 
		new BoderLayoutDemo(); 
	} 
}
