package utils;

/**
 * @author C5249742
 *
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

class PasswordEncoder{
	
	public static void main(String args[])  
    {  
	    JFrame jframe= new JFrame("Password Encoder");
	    JLabel labelPassword,labelEncodedPassword;  
	    final JTextField textEncodedPassword;
	    final JPasswordField textPassword;
	    JCheckBox chbShowPassword;
	    JButton btnGenerate,btnCopy,btnClear;

	    labelPassword=new JLabel("Password:");
	    labelEncodedPassword=new JLabel("Encrypted Password:");
	    textPassword=new JPasswordField(""); 
	    textEncodedPassword=new JTextField("");
	    chbShowPassword = new JCheckBox("Show Password",false);
	    btnGenerate=new JButton("Generate");
	    btnCopy=new JButton("Copy");
	    btnClear=new JButton("Clear");
	    
	    jframe.setSize(600,200);
	    labelPassword.setBounds(50,30, 200,20);  
	    textPassword.setBounds(180,30, 350,20);  
	    labelEncodedPassword.setBounds(50,60, 200,20);
	    textEncodedPassword.setBounds(180,60, 350,20);
	    chbShowPassword.setBounds(180,90, 120,20);
	    btnGenerate.setBounds(150,120, 100,20);
	    btnCopy.setBounds(280,120, 100,20);
	    btnClear.setBounds(410,120, 100,20);  
	    
	    jframe.add(labelPassword);
	    jframe.add(textPassword);
	    jframe.add(labelEncodedPassword);
	    jframe.add(textEncodedPassword);
	    jframe.add(chbShowPassword);
	    jframe.add(btnGenerate);
	    jframe.add(btnCopy);
	    jframe.add(btnClear);
	    
	    jframe.setLayout(null);
	    jframe.setLocationRelativeTo(null);		//Set JFrame in center of the Screen
	    jframe.setVisible(true);
	    jframe.setResizable(false);
	    jframe.getContentPane().setBackground(new Color(173,216,230));

	    //Customize Password Field
	    textPassword.setFont( new Font("Times New Roman", Font.BOLD,12));
	    
	    //Make Encrypted password UnEditable 
	    textEncodedPassword.setEditable(false);
	    textEncodedPassword.setFont( new Font("Times New Roman", Font.BOLD,12));
	    
	    //Disable Generate Button If content is Blank
	    btnGenerate.setEnabled(false);
	    Document document = textPassword.getDocument();
	    document.addDocumentListener(new JButtonStateController(btnGenerate,textEncodedPassword));
	    
	    //Disable Copy Button If content is Blank
	    btnCopy.setEnabled(false);
	    Document document1 = textEncodedPassword.getDocument();
	    document1.addDocumentListener(new JButtonStateController(btnCopy,textEncodedPassword));
	    
	    //Generate Encrypted Password
	    btnGenerate.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {       
			try {
				
				char[] input = textPassword.getPassword();
				String sPassword = new String(input);
				
				String data = PassCrypt.encrypt(sPassword);
				textEncodedPassword.setText(data);
				
				//System.out.println("Actual Password : " + sPassword);
				//System.out.println("Encrypted Password : " + data);
				//System.out.println("Decrypted Password : " + PassCrypt.decrypt(data));
				
			} catch (Exception e1) {
				e1.printStackTrace();
			}
                         
            }  
         });
	    
	   //Copy the Generated Encrypted Password to Clipboard
	    btnCopy.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {
            	String myString = textEncodedPassword.getText();
            	StringSelection stringSelection = new StringSelection(myString);
            	Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
            	clpbrd.setContents(stringSelection, null);
            }  
         });
	    
	    //Clear the content
	    btnClear.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {       
				textEncodedPassword.setText("");
				textPassword.setText("");
            }  
         });
	    
	    //Stop Execution after Closing the JFrame
	    jframe.addWindowListener(new WindowAdapter() {
	        public void windowClosing(WindowEvent evt) {
	                System.exit(0);
	        }
	    });
   	    	    
	    //Handle Show Password
	    chbShowPassword.addItemListener(new ItemListener() {
	        public void itemStateChanged(ItemEvent e) {
	            if (e.getStateChange() == ItemEvent.SELECTED) {
	            	textPassword.setEchoChar((char) 0);
	            } else {
	            	textPassword.setEchoChar('*');
	            }
	        }
	    });
    } 
}

class JButtonStateController implements DocumentListener {
	 JButton button;
	 JTextField textField;
	  
	  JButtonStateController(JButton button,JTextField textField) {
	     this.button = button ;
	     this.textField = textField ;
	  }
	  
	  public void changedUpdate(DocumentEvent e) {
	    disableIfEmpty(e);
	  }

	  public void insertUpdate(DocumentEvent e) {
	    disableIfEmpty(e);
	  }

	  public void removeUpdate(DocumentEvent e) {
	    disableIfEmpty(e);
	  }

	  public void disableIfEmpty(DocumentEvent e) {
		  if(e.getDocument().getLength() > 0){
			  button.setEnabled(true);
		  }else{
			  button.setEnabled(false);
			  textField.setText("");
		  }
	  }
}

