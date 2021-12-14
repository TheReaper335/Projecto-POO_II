/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JanelaComum;

/**
 *
 * @author eciom
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;;
import javax.swing.text.Document;

@SuppressWarnings("serial")
public class TextFieldCriar extends JTextField{
    private JLabel label;

  public TextFieldCriar(String txt,Color cor){
	this(txt);
	label.setForeground(cor);}
  
  public TextFieldCriar(String hint) {  
      hint=hint.trim();
      setForeground(Color.DARK_GRAY);  
      setLayout(new BorderLayout());
      label = new JLabel(hint);
      label.setFont(new Font("Segoe UI",Font.PLAIN,18));
      label.setForeground(new Color(100,100,100));
      add(label,BorderLayout.LINE_START);
      getDocument().addDocumentListener(new MyDocumentListener());
    
    addMouseListener(new MouseAdapter(){
        public void mousePressed(MouseEvent e){
            JTextField field=(JTextField) e.getSource();
            field.setFocusable(true);} }  );
    
    addKeyListener(new KeyAdapter(){
       @Override
    	public void keyPressed(KeyEvent e){
            if(e.getKeyCode()==KeyEvent.VK_ENTER){
                setFocusable(false);}}   } );
    
  
  }  
  
  
	private class MyDocumentListener implements DocumentListener {
    public void insertUpdate(DocumentEvent e) {
        updateLog(e, "inserted into");
    }
    public void removeUpdate(DocumentEvent e) {
        updateLog(e, "removed from");}
    
    public void changedUpdate(DocumentEvent e) {
        }
    
    public void updateLog(DocumentEvent e, String action){
        Document doc = (Document)e.getDocument();
        if(doc.getLength()==0){
            label.setVisible(true);
        } else{
            label.setVisible(false);} }  }
        
}
