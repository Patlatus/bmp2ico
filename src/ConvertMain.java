import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

final class ComboChange implements ActionListener{
	
	ConvertMain MainForm;
	
	public ComboChange(ConvertMain Form){
		MainForm = Form;
	}
	
	public void actionPerformed(ActionEvent e){
		if (MainForm.ComboBox1.getSelectedIndex() == 2) {
			MainForm.Edit3.setEnabled(true);
			MainForm.Edit4.setEnabled(true);
		} else {
			MainForm.Edit3.setEnabled(false);
			MainForm.Edit4.setEnabled(false);
		};
	}
}

final class Button1Click implements ActionListener{
	
	ConvertMain MainForm;
	
	public Button1Click(ConvertMain Form){
		MainForm = Form;
	}
	
	public void actionPerformed(ActionEvent e){
		MainForm.Label6.setText("Status: In progress...");
		switch (MainForm.ComboBox1.getSelectedIndex()) {
		case 0: 
			DelphiTools.makeTransparentCopy(MainForm.Edit1.getText(), MainForm.Edit2.getText());
			break;
		case 1:
			DelphiTools.makeIco1(MainForm.Edit1.getText(), MainForm.Edit2.getText());
			break;
		case 2:
			DelphiTools.makeIco4(MainForm.Edit1.getText(), MainForm.Edit3.getText(), MainForm.Edit4.getText(), MainForm.Edit2.getText());
			break;
			
		};
		MainForm.Label6.setText("Status: Finished.");

	}
}






public class ConvertMain extends JFrame
    {
	String[] zero, one, two, three;
	JComboBox ComboBox1, ComboBox2, ComboBox3;
	JButton Button1, Button2;
	Insets insets;
	Container con;
	int startPos;
	JTextField Edit1, Edit2, Edit3, Edit4;
    JLabel Label6;

    private Object makeObj(final String item)  {
      return new Object() { public String toString() { return item; } };
    }
    
    public void Place(JComponent comp, int left, int top){
    	Dimension size = comp.getPreferredSize();
    	comp.setBounds(left + insets.left, top + insets.top,
                size.width, size.height);
    	con.add(comp);
    }
    


	
	 public ConvertMain() {
	    super("Image Converter"); 	
	    
    
	    setBounds(0,0,650,500);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    con = this.getContentPane();
		con.setLayout(null);
		insets = con.getInsets();

		String[] comboItems = {"MakeTransparentCopy", "MakeSingleIcon", "Make 16x16 32x32 64x64 icon"};
	    ComboBox1 = new JComboBox(comboItems);
	    ComboBox1.addActionListener(new ComboChange(this));
		Place(ComboBox1, 0, 0);
		
	    Edit1 = new JTextField();
		Place(Edit1, 0, 50);
		Edit1.setSize(300, 25);
		JLabel Label1 = new JLabel("Source");
		Place(Label1, 0, 30);
	    
	    Edit2 = new JTextField();
		Place(Edit2, 300, 50);
		Edit2.setSize(300, 25);
		JLabel Label2 = new JLabel("Dest");
		Place(Label2, 300, 30);
	    
	    Edit3 = new JTextField();
		Place(Edit3, 0, 100);
		Edit3.setSize(300, 25);
		JLabel Label4 = new JLabel("Source 32x32");
		Place(Label4, 0, 80);

	    Edit4 = new JTextField();
		Place(Edit4, 0, 150);
		Edit4.setSize(300, 25);
		JLabel Label5 = new JLabel("Source 64x64");
		Place(Label5, 0, 130);
		
		Edit3.setEnabled(false);
		Edit4.setEnabled(false);

		JButton Button1 = new JButton("Convert");
		Button1.addActionListener(new Button1Click(this));	    
		Place(Button1, 300, 100);	    

		Label6 = new JLabel("Status");
		Place(Label6, 0, 200);
		Label6.setSize(300, 25);
	 
		JLabel Label7 = new JLabel("Supported types: bmp, png, gif, ico.");
		Place(Label7, 0, 230);
		Label7.setSize(300, 25);

		JLabel Label8 = new JLabel("This program makes transparent images using color in (0, 0) as transparent color.");
		Place(Label8, 0, 260);

		setVisible(true);
	  }
	 
	public static void main(String arg[]) {
		new ConvertMain();
	}
	
}

