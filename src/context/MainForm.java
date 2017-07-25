package context;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainForm{

	JFrame frame;
	JLabel	lbl_Server;
	JLabel	lbl_Status;

	public MainForm() {
		frame = new JFrame();
		frame.setLayout(null);



	}


	private void LlblSet(String serverName){
		lbl_Server=new JLabel();
		lbl_Status=new JLabel();
		lbl_Server.setText(serverName);
	}


}
