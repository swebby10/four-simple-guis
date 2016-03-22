import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Triangle implements ActionListener{
JLabel question, answer, basee, heightt;
JPanel panel;
JFrame mainScreen;
JButton submit, back;
JTextField base, height;
	public Triangle() {
		mainScreen = new JFrame();
		mainScreen.setLocation(230, 80); 
		mainScreen.setResizable(false);
		mainScreen.setTitle("Triangle Area");
		mainScreen.setContentPane(makePanel());
		mainScreen.pack();
		mainScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainScreen.setVisible(true);
	}
	public JPanel makePanel()  {
		panel = new JPanel();
		panel.setLayout(null);
		panel.setPreferredSize(new Dimension(200, 205));
		question = new JLabel("Enter the Heigh and Base");
		question.setBounds(10, 10, 180, 15);
		panel.add(question);
		basee = new JLabel("Base: ");
		heightt = new JLabel("Height: ");
		basee.setBounds(10, 30, 40, 15);
		heightt.setBounds(10, 60, 45, 15);
		panel.add(basee);
		panel.add(heightt);
		base = new JTextField();
		base.setBounds(55, 30, 120, 20);
		panel.add(base);
		height = new JTextField();
		height.setBounds(55, 60, 120, 20);
		panel.add(height);	
		back = new JButton("Back");
		submit = new JButton("Calculate");
		submit.setBounds(10,120,180,30);
		back.setBounds(10,155,180,30);
		panel.add(back);
		panel.add(submit);
		back.addActionListener(this);
		submit.addActionListener(this);
		answer = new JLabel("A = 1/2 * B * H");
		answer.setBounds(10, 90, 180, 20);
		panel.add(answer);
		return panel;
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==submit){
			if(base.getText()==null || height.getText()==null){
				answer.setText("YOU NEED TO ENTER NUMBERS");
				answer.setForeground(Color.RED);
			}else{
			double answers = 0.0;
			int num1 = Integer.parseInt(base.getText());
			int num2  = Integer.parseInt(height.getText());
			answers = num1*num2;
			answers = answers * .5;
			answer.setText("A = "+answers);
			answer.setForeground(Color.BLUE);
			}
		}else if (e.getSource()==back){
			mainScreen.setVisible(false);
			new MainMenu();
		}
	}

}
