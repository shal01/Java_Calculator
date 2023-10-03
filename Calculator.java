package calculator;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D.Float;
import java.lang.ref.Cleaner.Cleanable;

import javax.imageio.plugins.tiff.GeoTIFFTagSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Calculator  implements ActionListener{
	JFrame frame;
	JLabel displayLabel;
	JButton plusButton,minButton,mulButton,divButton,dotButton,equalButton,clrButton,delButton,negButton;
	JButton[] numberButton=new JButton[10];
	JButton[] functionButton=new JButton[9];
	JPanel panel;
	
	double oldValue=0,newValue=0,result=0;
	char operator;
	boolean isOperatorClicked=false;
	
	Font myfont=new Font("Monospace",Font.TRUETYPE_FONT,30);
	
	
	
	public Calculator() {
		frame=new JFrame("calculator");
		frame.setLayout(null);
		frame.setSize(450, 550);
		frame.setLocation(500, 150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.gray);
		
		
	
		displayLabel=new JLabel();
		displayLabel.setBounds(40, 20, 350,40);
		displayLabel.setBackground(Color.black);
		displayLabel.setOpaque(true);
		displayLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		displayLabel.setForeground(Color.white);
		frame.add(displayLabel);
		
		plusButton=new JButton("+");
		minButton=new JButton("-");
		mulButton=new JButton("x");
		divButton=new JButton("/");
		dotButton=new JButton(".");
		clrButton=new JButton("Ac");
		delButton=new JButton("Del");
		equalButton=new JButton("=");
		negButton=new JButton("Neg");
		
		
		functionButton[0]=plusButton;
		functionButton[1]=minButton;
		functionButton[2]=mulButton;
		functionButton[3]=divButton;
		functionButton[4]=dotButton;
		functionButton[5]=equalButton;
		functionButton[6]=clrButton;
		functionButton[7]=delButton;
		functionButton[8]=negButton;
		
		for(int i=0;i<9;i++) {
			functionButton[i].addActionListener(this);
			functionButton[i].setFont(myfont);
			functionButton[i].setFocusable(false);
			functionButton[i].setBackground(Color.BLACK);
			functionButton[i].setForeground(Color.white);
		}
		
		for(int i=0;i<10;i++) {
			numberButton[i]=new JButton(String.valueOf(i));
			numberButton[i].addActionListener(this);
			numberButton[i].setFont(myfont);
			numberButton[i].setFocusable(false);
			numberButton[i].setBackground(Color.white);
		}
		
		panel=new JPanel();
		panel.setBounds(40, 80, 350, 350);
		panel.setLayout(new GridLayout(4,4,5,5));
		panel.setBackground(Color.GRAY);
//		panel.setBackground(Color.black);
		
		panel.add(numberButton[7]);
		panel.add(numberButton[8]);
		panel.add(numberButton[9]);
		panel.add(plusButton);
		panel.add(numberButton[4]);
		panel.add(numberButton[5]);
		panel.add(numberButton[6]);
		panel.add(minButton);
		panel.add(numberButton[1]);
		panel.add(numberButton[2]);
		panel.add(numberButton[3]);
		panel.add(mulButton);
		panel.add(dotButton);
		panel.add(numberButton[0]);
		panel.add(equalButton);
		panel.add(divButton);
		
		
		clrButton.setBounds(40, 440, 108, 50);
		clrButton.setBackground(Color.red);
		negButton.setBounds(160, 440, 108, 50);
		negButton.setBackground(Color.black);
		delButton.setBounds(280, 440, 108, 50);
		delButton.setBackground(Color.red);
		
		
		
		frame.add(panel);
		frame.add(negButton);
		frame.add(delButton );
		frame.add(clrButton);
		frame.setVisible(true);
		
		
	}
	
	public static void main(String[] args) {
		new Calculator();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		for(int i=0;i<10;i++) {
			if (e.getSource()==numberButton[i]) {
				displayLabel.setText(displayLabel.getText().concat(String.valueOf(i)));
			}
		}
			
		if (e.getSource()==dotButton) {
			
			displayLabel.setText(displayLabel.getText().concat("."));
		}
		
		if(e.getSource()==plusButton){
			if(isOperatorClicked) {
				newValue=Double.parseDouble(displayLabel.getText());
				if(operator=='-') {
					oldValue=oldValue+newValue;
				}else if(operator=='*'){
					oldValue=oldValue*newValue;
				}else if(operator=='/') {
					oldValue=oldValue/newValue;
				}else {
					oldValue=oldValue+newValue;
				}
				
				
				operator='+';
				displayLabel.setText("");
			}else {
				oldValue=Double.parseDouble(displayLabel.getText());
				operator='+';
				displayLabel.setText("");
				isOperatorClicked=true;
				
			}
			
		}
		
		if(e.getSource()==minButton){
			
			if (isOperatorClicked) {
				newValue=Double.parseDouble(displayLabel.getText());
				
				if(operator=='+') {
					oldValue=oldValue+newValue;
				}else if(operator=='/'){
					oldValue=oldValue/newValue;
				}else if(operator=='*') {
					oldValue=oldValue*newValue;
				}else {
					oldValue=oldValue-newValue;
				}
				
				
				operator='-';
				displayLabel.setText("");
				
			}else {
				
				oldValue=Double.parseDouble(displayLabel.getText());
				operator='-';
				displayLabel.setText("");
				isOperatorClicked=true;
			}
			
		}
		
		if(e.getSource()==mulButton){
			if(isOperatorClicked) {
				newValue=Double.parseDouble(displayLabel.getText());
				
				if(operator=='+') {
					oldValue=oldValue+newValue;
				}else if(operator=='-'){
					oldValue=oldValue-newValue;
				}else if(operator=='/') {
					oldValue=oldValue/newValue;
				}else {
					oldValue=oldValue*newValue;
				}
				
				operator='*';
				displayLabel.setText("");
			}
			else {
			oldValue=Double.parseDouble(displayLabel.getText());
			operator='*';
			displayLabel.setText("");
			isOperatorClicked=true;
		}
			
		}
		
		if(e.getSource()==divButton){
			
			if(isOperatorClicked) {
				newValue=Double.parseDouble(displayLabel.getText());
				
				if(operator=='+') {
					oldValue=oldValue+newValue;
				}else if(operator=='*'){
					oldValue=oldValue*newValue;
				}else if(operator=='-') {
					oldValue=oldValue-newValue;
				}else {
					oldValue=oldValue/newValue;
				}
				
				operator='/';
				displayLabel.setText("");
			}else {
			
				oldValue=Double.parseDouble(displayLabel.getText());
				operator='/';
				displayLabel.setText("");
				isOperatorClicked=true;
			}
			
		}
		
		if(e.getSource()==equalButton){

			 newValue=Double.parseDouble(displayLabel.getText());
			
			 
			 switch(operator) {
			 case'+':
				 newValue=Double.parseDouble(displayLabel.getText());
				 result=oldValue+newValue;
				 isOperatorClicked=false;
				 break;
			 
			 case'-':
				 newValue=Double.parseDouble(displayLabel.getText());
				 result=oldValue-newValue;
				 isOperatorClicked=false;
				 break;
				 
			 case'*':
				 newValue=Double.parseDouble(displayLabel.getText());
				 result=oldValue*newValue;
				 isOperatorClicked=false;
				 break;
				 
			 case'/':
				 newValue=Double.parseDouble(displayLabel.getText());
				 result=oldValue/newValue;
				 isOperatorClicked=false;
				 break;
			 }
			 displayLabel.setText(String.valueOf(result));
			 oldValue=result;
			 
				
			
		}

		if(e.getSource()==clrButton){
			displayLabel.setText("");
			oldValue=0;
			newValue=0;
			isOperatorClicked=false;
			
		}
		
		if(e.getSource()==delButton){
			
			String string=displayLabel.getText();
			displayLabel.setText(" ");
			for(int i=0;i<string.length()-1;i++) {
				displayLabel.setText(displayLabel.getText()+string.charAt(i));
			}
			
			}
		
		if(e.getSource()==negButton){
			double temp=Double.parseDouble(displayLabel.getText());
			temp=temp*-1;
			displayLabel.setText(String.valueOf(temp));
			
		}
		
		
	}

}
