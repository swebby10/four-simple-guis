import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class MainMenu implements ActionListener {
	JFrame mainScreen;
	JButton triangle, question, calculator, divisor;
	JLabel main;
	JPanel panel;
	public MainMenu() {
		mainScreen = new JFrame();
		mainScreen.setLocation(230, 80); 
		mainScreen.setResizable(false);
		mainScreen.setTitle("Four Programs");
		mainScreen.setContentPane(makePanel());
		mainScreen.pack();
		mainScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainScreen.setVisible(true);
	}
	public JPanel makePanel() {
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(430, 90));
		panel.setLayout(null);
		triangle = new JButton("Triangle Area Calculator");
		triangle.setBounds(10, 10, 200, 30);
		triangle.addActionListener(this);
		question = new JButton("Questioneer");
		question.setBounds(220, 10, 200, 30);
		question.addActionListener(this);
		calculator = new JButton("Simple Calculator");
		calculator.setBounds(10, 50, 200, 30);
		calculator.addActionListener(this);
		divisor = new JButton("Greatest Common Divisor");
		divisor.setBounds(220, 50, 200, 30);
		divisor.addActionListener(this);
		panel.add(triangle);
		panel.add(question);
		panel.add(calculator);
		panel.add(divisor);
		return panel;
		}

	public static void main(String[] args) {
		new MainMenu();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==triangle){
		
				new Triangle();
				mainScreen.setVisible(false);
		
		} else if(e.getSource() == question){
			new Question();
			mainScreen.setVisible(false);
		} else if(e.getSource() == calculator){
			System.out.println("click");
			new Calc();
			mainScreen.setVisible(false);
		} else if(e.getSource() == divisor){
			System.out.println("click");
			new Divisor();
			mainScreen.setVisible(false);
		}
	}

}
