import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Divisor implements ActionListener{
JLabel question, answer, num1, num2;
JTextField number1, number2;
JPanel panel;
JFrame mainScreen;
JButton submit, back, average;
int averages;
ArrayList<Integer> array1;
	public Divisor() {
		mainScreen = new JFrame();
		mainScreen.setLocation(230, 80); 
		mainScreen.setResizable(false);
		mainScreen.setTitle("Greatest Common divisor");
		mainScreen.setContentPane(makePanel());
		mainScreen.pack();
		mainScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainScreen.setVisible(true);
	}
	public JPanel makePanel() {
		panel = new JPanel();
		array1 = new ArrayList<Integer>();
		panel.setLayout(null);
		panel.setPreferredSize(new Dimension(210, 205));
		question = new JLabel("Pick two numbers to find the GCD");
		question.setBounds(10, 10, 200, 15);
		panel.add(question);
		number1 = new JTextField();
		number2 = new JTextField();
		number1.setBounds(40, 30, 120, 20);
		number2.setBounds(40, 60, 120, 20);
		panel.add(number1);
		panel.add(number2);
		submit = new JButton("Find GCD");
		back = new JButton("Back");
		average = new JButton("Average of all GCD");
		submit.setBounds(15,110,180,25);
		average.setBounds(15,140,180,25);
		back.setBounds(15,170,180,25);
		panel.add(submit);
		panel.add(back);
		panel.add(average);
		submit.addActionListener(this);
		back.addActionListener(this);
		average.addActionListener(this);
		answer = new JLabel("Label");
		answer.setBounds(10, 85, 180, 20);
		panel.add(answer);
		return panel;
	}
	public int findGCD(int num1, int num2){
		 if(num2 == 0){
	            return num1;
	        }
	        return findGCD(num2, num1%num2);
	    }
	public void getAverage(){
		for(int i = 0; i < array1.size(); i++){
			averages += array1.get(i);
		}
		averages = averages / array1.size();
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == submit){
			int answers = 0;
			int num1 = Integer.parseInt(number1.getText());
			int num2 = Integer.parseInt(number2.getText());
			answers = findGCD(num1, num2);
			answer.setForeground(Color.BLUE);
			answer.setText("GCD = "+answers);
			array1.add(answers);
		}else if(e.getSource()==average){
			getAverage();
			answer.setForeground(Color.BLUE);
			answer.setText("Average of all GCD = "+averages);	
		}else if (e.getSource()==back){
			mainScreen.setVisible(false);
			new MainMenu();
		}
	}

}
