import java.awt.*;  
import javax.swing.*;  
  
public class MyGridLayout{  
JFrame f;  
MyGridLayout(){  
    f=new JFrame();  
      
    JButton b1=new JButton("(0,0)");  
    JButton b2=new JButton("(0,1)");  
    JButton b3=new JButton("(0,2)");  
    JButton b4=new JButton("(1,0)");  
    JButton b5=new JButton("(1,1)");  
    JButton b6=new JButton("(1,2)");  
    JButton b7=new JButton("(2,0)");  
    JButton b8=new JButton("(2,1)");  
    JButton b9=new JButton("(2,2)");  
          
    f.add(b1);f.add(b2);f.add(b3);f.add(b4);f.add(b5);  
    f.add(b6);f.add(b7);f.add(b8);f.add(b9);  
  
    f.setLayout(new GridLayout(3,3));  
    //setting grid layout of 3 rows and 3 columns  
  
    f.setSize(300,300);  
    f.setVisible(true);  
}  
public static void main(String[] args) {  
    new MyGridLayout();  
}  
}