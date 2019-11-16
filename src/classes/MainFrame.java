package classes;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class MainFrame {
	
	private JFrame frame;
	private JPanel leftPanel,rightPanel, midPanel, resultPanel, firstHalfPanel, secondHalfPanel, panelConsole, fullPanel;
	private JLabel firstLabel,secondLabel,thirdLabel;
	private JButton button1,button2;
	private JTextField firstValue, secondValue, resultedValue;
	private JTextArea console;
	private Double result;
	
	public MainFrame() {
		
		initFrame();
		initMenu();
		initPanel();
		initLabel();
		initButton();
		initTextField();
		initTextArea();
		pack();
		frame.pack();
		
		frame.setVisible(true);
	}

	public void initFrame() {
		
		frame = new JFrame("Third application");
		frame.setSize(600,600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null); 
		frame.setLayout(new BorderLayout());
		frame.setResizable(true);
		
	}
	
	private void initMenu() {
		
		JMenuBar bar = new JMenuBar();
		JMenu menu = new JMenu("Menu");
		JMenuItem item1 = new JMenuItem("About");
		menu.add(item1);
		bar.add(menu);
		frame.setJMenuBar(bar);
		
	}
	
	public void initPanel() {
		
		leftPanel = new JPanel(new BorderLayout());
		
		rightPanel = new JPanel(new BorderLayout());
		
		midPanel = new JPanel(new BorderLayout());
		
		resultPanel = new JPanel(new BorderLayout());
		
		panelConsole = new JPanel(new BorderLayout());
		Border outsideBorder = BorderFactory.createEmptyBorder(5,5,5,5);
		Border insideBorder = BorderFactory.createTitledBorder("Console");
		Border fullBorder = BorderFactory.createCompoundBorder(outsideBorder,insideBorder);
		panelConsole.setBorder(fullBorder);
		
		firstHalfPanel = new JPanel();
		
		secondHalfPanel = new JPanel();
		
		fullPanel = new JPanel();
		fullPanel.setLayout(new BorderLayout());
		
	}
	
	public void initLabel() {
		
		firstLabel = new JLabel("First value");
		secondLabel = new JLabel("Second value");
		thirdLabel = new JLabel("Result");
		
	}
	
	public void initButton() {
		
		button1 = new JButton("+");
		button1.setSize(30,50);
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				
				try {
					result =  Double.parseDouble(firstValue.getText()) +  Double.parseDouble(secondValue.getText());
					resultedValue.setText(result.toString() + '\n');
					console.append(firstValue.getText() + "+" + secondValue.getText() + '\n');
				} catch(NumberFormatException exception) {
					console.append("Invalit input." + '\n');
					console.append(exception.getMessage() + '\n');
				}
				
			}
		});
		
		button2	= new JButton("-");
		button2.setSize(30,50);
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				
				try {
					result = Double.parseDouble(firstValue.getText()) -  Double.parseDouble(secondValue.getText());
					resultedValue.setText(result.toString() + '\n');
					console.append(firstValue.getText() + "-" + secondValue.getText() + '\n');
				} catch(NumberFormatException exception) {
					console.append("Invalid input." + '\n');
					console.append(exception.getMessage() + "\n");
				}
				
			}
		});
		
	}
	
	
	private void initTextField() {
		
		firstValue = new JTextField();
		firstValue.setSize(40,20);
		
		secondValue = new JTextField();
		secondValue.setSize(40, 20);
		
		resultedValue = new JTextField();
		resultedValue.setPreferredSize(new Dimension(44,24));
		resultedValue.setEditable(false);
	}
	
	public void initTextArea() {
		
		console = new JTextArea();
		console.setPreferredSize(new Dimension(200,100));
		console.setEditable(false);
		
	}
	
	public void pack() {
		
		leftPanel.add(firstLabel, BorderLayout.NORTH);
		leftPanel.add(firstValue, BorderLayout.CENTER);
		leftPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5)); //setBorder pentru a face un spatiu intre toate elementele
		
		rightPanel.add(secondLabel, BorderLayout.NORTH);
		rightPanel.add(secondValue, BorderLayout.CENTER);
		rightPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		midPanel.add(button1, BorderLayout.NORTH);
		midPanel.add(button2, BorderLayout.CENTER);
		midPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		resultPanel.add(thirdLabel, BorderLayout.NORTH);
		resultPanel.add(resultedValue, BorderLayout.CENTER);
		resultPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		firstHalfPanel.add(leftPanel);
		firstHalfPanel.add(midPanel);
		firstHalfPanel.add(rightPanel);
		firstHalfPanel.add(resultPanel);
		firstHalfPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		panelConsole.add(console, BorderLayout.CENTER);
		
		secondHalfPanel.add(panelConsole);
		
		fullPanel.add(firstHalfPanel, BorderLayout.NORTH);
		fullPanel.add(secondHalfPanel, BorderLayout.SOUTH);
		
		frame.add(fullPanel);
		
	}
	
}
