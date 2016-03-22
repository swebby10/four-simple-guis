import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


public class Question implements ActionListener{
JLabel question, answer;
JPanel panel;
JFrame mainScreen;
JButton submit, back;
ButtonGroup options;
JRadioButton a, b, c, d, e;
	public Question() {
		mainScreen = new JFrame();
		mainScreen.setLocation(230, 80); 
		mainScreen.setResizable(false);
		mainScreen.setTitle("Questioneer");
		mainScreen.setContentPane(makePanel());
		mainScreen.pack();
		mainScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainScreen.setVisible(true);
	}
	public JPanel makePanel() {
		panel = new JPanel();
		panel.setLayout(null);
		panel.setPreferredSize(new Dimension(200, 205));
		question = new JLabel("What is the captial of brazil?");
		options = new ButtonGroup();
		a = new JRadioButton("A) Washington");
		b = new JRadioButton("B) Rio de Janeiro");
		c = new JRadioButton("C) Brasilia");
		d = new JRadioButton("D) Roma");
		e = new JRadioButton("E) None of the above");
		a.setBounds(10, 40, 180, 15);
		b.setBounds(10, 55, 180, 15);
		c.setBounds(10, 70, 180, 15);
		d.setBounds(10, 85, 180, 15);
		e.setBounds(10, 100, 180, 15);
		options.add(a);
		options.add(b);
		options.add(c);
		options.add(d);
		options.add(e);
		question.setBounds(10, 10, 180, 15);
		panel.add(question);
		panel.add(a);
		panel.add(b);
		panel.add(c);
		panel.add(d);
		panel.add(e);
		back = new JButton("Back");
		submit = new JButton("submit");
		submit.setBounds(10,120,180,30);
		back.setBounds(10,155,180,30);
		panel.add(back);
		panel.add(submit);
		back.addActionListener(this);
		submit.addActionListener(this);
		answer = new JLabel("");
		answer.setBounds(80, 190, 90, 15);
		panel.add(answer);
		return panel;
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==submit){
			if(c.isSelected()){
			answer.setText("Correct!");
			answer.setForeground(Color.GREEN);
			}else{
				answer.setText("Incorrect!");
				answer.setForeground(Color.RED);
			}
		}else if (e.getSource()==back){
			mainScreen.setVisible(false);
			new MainMenu();
		}
	}

}
