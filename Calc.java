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
import javax.swing.JTextField;


public class Calc implements ActionListener{
JLabel question, answer, num1, num2;
JTextField number1, number2;
JPanel panel;
JFrame mainScreen;
JButton submit, back;
ButtonGroup options;
JRadioButton add, subtract, divide, multiply;
	public Calc() {
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
		question = new JLabel("Pick operation then enter #'s.");
		options = new ButtonGroup();
		add = new JRadioButton("+");
		subtract = new JRadioButton("-");
		divide = new JRadioButton("/");
		multiply = new JRadioButton("*");
		add.setBounds(10, 40, 40, 15);
		subtract.setBounds(10, 55, 40, 15);
		divide.setBounds(10, 70, 40, 15);
		multiply.setBounds(10, 85, 40, 15);
		options.add(add);
		options.add(subtract);
		options.add(divide);
		options.add(multiply);
		question.setBounds(10, 10, 180, 15);
		panel.add(question);
		panel.add(add);
		panel.add(subtract);
		panel.add(divide);
		panel.add(multiply);
		number1 = new JTextField();
		number2 = new JTextField();
		number1.setBounds(55, 45, 120, 20);
		number2.setBounds(55, 75, 120, 20);
		panel.add(number1);
		panel.add(number2);
		back = new JButton("Back");
		submit = new JButton("Calculate");
		submit.setBounds(10,120,180,30);
		back.setBounds(10,155,180,30);
		panel.add(back);
		panel.add(submit);
		back.addActionListener(this);
		submit.addActionListener(this);
		answer = new JLabel("");
		answer.setBounds(10, 100, 180, 20);
		panel.add(answer);
		return panel;
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==submit){
			double answers = 0.0;
			double num1 = Double.parseDouble(number1.getText());
			double num2 = Double.parseDouble(number2.getText());
			answer.setForeground(Color.BLUE);
			if(add.isSelected()){
			answers = num1 + num2;
			answer.setText(""+num1+" + "+num2+" = "+answers);
			}else if(subtract.isSelected()){
				answers = num1 - num2;
				answer.setText(""+num1+" - "+num2+" = "+answers);
			}else if(divide.isSelected()){
				if (num2 != 0){
					answers = num1 / num2;
					answer.setText(""+num1+" / "+num2+" = "+answers);
				}
			}else if(multiply.isSelected()){
				answers = num1 * num2;
				answer.setText(""+num1+" * "+num2+" = "+answers);
			}
		}else if (e.getSource()==back){
			mainScreen.setVisible(false);
			new MainMenu();
		}
	}

}
