
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.EmptyBorder;
import javax.swing.text.AbstractDocument;
import javax.swing.text.DocumentFilter;


public class OnlineStoreGUI extends JFrame {

    private JTextField nameField;
    private JTextField phoneField;
    private JTextField addressField;
    private JRadioButton smallerRadioButton;
    private JRadioButton biggerRadioButton;
    private JCheckBox addonACheckBox;
    private JCheckBox addonBCheckBox;
    private JButton buyButton;
     private JButton backButton;
    

    public OnlineStoreGUI(String choice, int price) {
        setTitle("Online Store");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create student information fields
        JLabel product =new JLabel("Chosen Product: "+choice);
        String money = String.valueOf(price);
        JLabel productprice =new JLabel("RM"+money);
        
        JLabel nameLabel = new JLabel("Name:");
        JLabel phoneLabel = new JLabel("No. Telephone:");
        JLabel addressLabel = new JLabel("Address:"); 
        
        JLabel storageLabel = new JLabel("Storage and Ram:");
        nameField = new JTextField(20); // Instantiate nameField
        phoneField = new JTextField(20); // Instantiate phonenumField
        addressField= new JTextField(20);
        smallerRadioButton = new JRadioButton("512GB+8GB ram");
        biggerRadioButton = new JRadioButton("1TB+16GB ram(+RM400)");
        ButtonGroup storageGroup = new ButtonGroup();
        storageGroup.add(smallerRadioButton);
        storageGroup.add(biggerRadioButton);

        // Create product checkboxes
        JLabel productLabel = new JLabel("Select Addons:");
        addonACheckBox = new JCheckBox("Warranty 2years (+RM200)");
        addonBCheckBox = new JCheckBox("Damage Protection (+RM15)");
        //Create back button
        backButton = new JButton("Back");
        backButton.addActionListener(new BackButtonListener());
        // Create buy button
        buyButton = new JButton("Buy");
        buyButton.addActionListener(new BuyButtonListener(price));

        // Create panel and add components
        JPanel panel = new JPanel(new GridLayout(9,2, 10, 10));
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));
        
        panel.add(product);
        panel.add(productprice);
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(phoneLabel);
        panel.add(phoneField);
        //input validation on phone number(prevent alphabet input)
        AbstractDocument doc = (AbstractDocument) phoneField.getDocument();
        doc.setDocumentFilter(new DocumentFilter() {
            public void replace(FilterBypass fb, int offset, int length, String text, javax.swing.text.AttributeSet attrs) throws javax.swing.text.BadLocationException {
                // Only allow numeric input
                if (text.matches("\\d*")) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        });
        panel.add(addressLabel);
        panel.add(addressField);
        
        panel.add(storageLabel);
        panel.add(new JLabel()); //spacing purpose
        panel.add(smallerRadioButton);
        panel.add(biggerRadioButton);
        panel.add(productLabel);
        panel.add(new JLabel()); //spacing purpose
        panel.add(addonACheckBox);
        panel.add(addonBCheckBox);

      
        panel.add(backButton);
        panel.add(buyButton);
        
        add(panel);

        pack();
        setSize(getWidth() + 100, getHeight() + 50);
        setLocationRelativeTo(null);
        setVisible(true);
    }
private class BackButtonListener implements ActionListener {
        //open main page and dispose current page
        public void actionPerformed(ActionEvent e) {
           MainFunction a =new MainFunction();
               dispose();
        }
}
        
 private class BuyButtonListener implements ActionListener {
        private int price;

        public BuyButtonListener(int price) {
            this.price = price;
        }

        public void actionPerformed(ActionEvent e) {
            //alert if no radiobutton is chosen
            if (!smallerRadioButton.isSelected() && !biggerRadioButton.isSelected()) {
            JOptionPane.showMessageDialog(OnlineStoreGUI.this, "Please select a storage and RAM option.");
            return; // Stop further execution
        }
            // Get buyer information
            int totalprice=price;
            String name = nameField.getText();
            String phonenum = phoneField.getText();
            String address=addressField.getText();
            String storage=null;
            if(smallerRadioButton.isSelected())
           {
               storage ="512GB+8GB ram";
               totalprice+=0;
           }
           if(biggerRadioButton.isSelected())
           {
               storage ="1TB+16GB ram";
               totalprice+=400;
           }

            // Get selected addons
            StringBuilder addon = new StringBuilder();
            if (addonACheckBox.isSelected()) {
                addon.append("Warranty 2years, ");
                totalprice+=200;
            }
            if (addonBCheckBox.isSelected()) {
                addon.append("Damage Protection, ");
                 totalprice+=15;
            }
        

            // Remove trailing comma and whitespace
            String selectedAddonsString = addon.toString().trim();
            if (selectedAddonsString.endsWith(",")) {
                selectedAddonsString = selectedAddonsString.substring(0, selectedAddonsString.length() - 1);
            }

            // Perform purchase logic based on the selected products and student information
            // ...

            // Show a message dialog to indicate the purchase, selected products, and student information
            String message = "Purchase Successful!\n\nSelected Storage and Ram: "+storage+"\nSelected Addons: " + selectedAddonsString
                    +"\nTotal Price: RM" +totalprice+ "\n\nStudent Information:\nName: " + name + "\nPhone number: " + phonenum
                    + "\nAddress: "+address ;
            JOptionPane.showMessageDialog(OnlineStoreGUI.this, message);
            //return to main page
            MainFunction mainPage = new MainFunction();
            dispose();
        }
    }
    
}

    
