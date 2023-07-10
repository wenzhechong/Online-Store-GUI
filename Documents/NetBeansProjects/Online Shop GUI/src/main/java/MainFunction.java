
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import java.awt.Image;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author USER
 */
public class MainFunction extends JFrame {
    private JLabel shopname;
    private JLabel product1;
    private JLabel product2;
    private JLabel product3;
    private JButton choose1;
    private JButton choose2;
    private JButton choose3;
    private JLabel JLabel1;
     private JLabel JLabel2;
      private JLabel JLabel3;
public  MainFunction (){
     setTitle("Online Store");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setLayout(null);
        // Create products information fields
           String product1info = "<html>ASUS Vivobook 15<br>"
                + "Model: M1502<br>"
                + "Price: RM 2,399 <br>"
                + "Color: Silver<br>"
                + "Processor: AMD Ryzen™ 7 7730U<br>"
                + "Operating System: Windows 11 Pro<br>"
                + "Display: 15.6\" FHD<br>"
                + "Graphics: AMD Radeon graphics </html>";
           
         String product2info = "<html>ASUS TUF Gaming F15 (2022)<br>"
                + "Model: FX507Z-CHN082W<br>"
                + "Price: RM 4,799<br>"
                + "Color: Mecha Gray<br>"
                + "Processor: Intel® Core™ i7-12700H<br>"
                + "Operating System: Windows 11 Home<br>"
                + "Display: 15.6\" FHD<br>"
                + "Graphics: NVIDIA® GeForce RTX™ 3050 4GB GDDR6</html>";
         
            String product3info = "<html>ASUS ROG Strix SCAR 18 (2023) G834<br>"
                + "Model: G834J-YN6068W<br>"
                + "Price: RM 18,999<br>"
                + "Color: Black<br>"
                + "Processor: Intel® Core™ i9-13980HX<br>"
                + "Operating System: Windows 11 Home<br>"
                + "Display: 18\" QHD<br>"
                + "Graphics: NVIDIA® GeForce RTX4090 16GB GDDR6</html>";
            
     //set shop name info to Jlabel       
      shopname = new JLabel("Welcome to ABC Laptop Shop");
      shopname.setFont(new Font("Serif", Font.BOLD, 28));
      
      //set Products info to Jlabel
         product1 = new JLabel(product1info);
         product2 = new JLabel(product2info);
         product3 = new JLabel(product3info);
         
      //Create 3 buttons with action listener
         choose1= new JButton("Choose It");
         choose1.addActionListener(new MainFunction.ChooseButtonListener1());
         choose2= new JButton("Choose It");
          choose2.addActionListener(new MainFunction.ChooseButtonListener2());
         choose3= new JButton("Choose It");
         choose3.addActionListener(new MainFunction.ChooseButtonListener3());
             
            JLabel1=new JLabel("                                      ");
            JLabel2=new JLabel("                   ");
            JLabel3=new JLabel("                   ");
      

        // Create a JLabel and set the image as its icon
       JLabel labelimg1 = new JLabel();
       labelimg1.setIcon(new ImageIcon("1.png")); 
       JLabel labelimg2 = new JLabel();
       labelimg2.setIcon(new ImageIcon("2.png"));
       JLabel labelimg3 = new JLabel();
       labelimg3.setIcon(new ImageIcon("3.png"));
       
        JPanel panel0=new JPanel(); //panel for welcome
        JPanel panel1= new JPanel();  //panel for laptop1
        JPanel panel2= new JPanel(); //panel for laptop2
        JPanel panel3= new JPanel(); //panel for laptop3
        
        //set coordinate and size of each panel
        panel0.setBounds(550, 20, 400, 180);
        panel1.setBounds(100, 200, 400, 450);
        panel2.setBounds(550, 200, 400, 450);
        panel3.setBounds(1000, 200, 400, 450);
        
        panel0.add(shopname);
       
         panel1.add(labelimg1);
         panel1.add(product1); 
         panel1.add(JLabel1);//empty jlabel for skip row purpose
         panel1.add(choose1);
         
         panel2.add(labelimg2);
         panel2.add(product2);
         panel2.add(JLabel2);//empty jlabel for skip row purpose
         panel2.add(choose2);
         
         panel3.add(labelimg3);
         panel3.add(product3);
         panel3.add(JLabel3);//empty jlabel for skip row purpose
         panel3.add(choose3);
    
        //set colour for 3 JPanel of product
        panel2.setBackground(Color.white); 
         panel1.setBackground(Color.pink);
         panel3.setBackground(Color.GRAY);
      
         //add all panel into JFrame
        add(panel0);
        add(panel1);
        add(panel2);
        add(panel3);
        pack();
        setSize(getWidth() + 1500, getHeight() + 1500); //set frame size
        setVisible(true); //let frame visible
}

 private class ChooseButtonListener1 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
             
            OnlineStoreGUI a=new OnlineStoreGUI("ASUS Vivobook 15",2399);//open onlinestoregui.java with laptop1 value
          dispose();//close mainpage
        }
    }
 
 private class ChooseButtonListener2 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
              
               OnlineStoreGUI a=new OnlineStoreGUI("ASUS TUF Gaming F15 (2022)",4799);//open onlinestoregui.java with laptop2 value
               dispose();//close mainpage
        }
    }
 
 private class ChooseButtonListener3 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
               
               OnlineStoreGUI a=new OnlineStoreGUI("ASUS ROG Strix SCAR 18 (2023)",18999); //open onlinestoregui.java with laptop3 value
               dispose(); //close mainpage
        }
     }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainFunction());
    }
}
