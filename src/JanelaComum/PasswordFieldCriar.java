
package JanelaComum;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.text.Document;

@SuppressWarnings("serial")
public class PasswordFieldCriar extends JPasswordField{
    private JLabel label;
    
    public char retornarEchoChar(PasswordFieldCriar pfc){
        return getEchoChar();}

    public PasswordFieldCriar(String txt,Color cor){
	  this(txt);
	  label.setForeground(cor);}
    
    public PasswordFieldCriar(String hint) { 
        hint=hint.trim();
        setForeground(Color.DARK_GRAY);  
        setLayout(new BorderLayout());
        label=new JLabel(hint);
        label.setFont(new Font("Segoe UI",Font.PLAIN,18));
        label.setForeground(new Color(100,100,100));
        add(label,BorderLayout.LINE_START);
        getDocument().addDocumentListener(new MyDocumentListener());
        
        addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent e){
                JPasswordField field=(JPasswordField) e.getSource();
    		field.setFocusable(true);} } );
        
        addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode()==KeyEvent.VK_ENTER){
                    setFocusable(false);} } } ); } 
    
    
    private class MyDocumentListener implements DocumentListener {
        public void insertUpdate(DocumentEvent e) {
            updateLog(e);}
        
	public void removeUpdate(DocumentEvent e){
	    updateLog(e);}
        
	public void changedUpdate(DocumentEvent e) {}
        
	public void updateLog(DocumentEvent e){
            Document doc = (Document)e.getDocument();
	    if(doc.getLength()==0){
                label.setVisible(true);
            } else{
                label.setVisible(false);} }
   }
}
