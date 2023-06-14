import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.text.*;

public class InputDataChart extends JPanel
{

	public InputDataChart(){
		setLayout(null);

		JLabel l = new JLabel("<5학기 학점을 누계하여 볼 수 있는 학점계산기>");
		add(l);
		l.setBounds(70,20, 500,20);

		JLabel linput = new JLabel("5학기 학점을 입력해주세요. (4.3만점)");
		add(linput);
		linput.setBounds(50,100,500,20);

		JTextField inputField = new JTextField(10);
		add(inputField);
		inputField.setBounds(280,90,100,30);

		JButton cal = new JButton("계산하기");
		add(cal);
		cal.setBounds(150,170,100,40);

		JLabel loutput = new JLabel("");
		add(loutput);
		loutput.setBounds(110,200,500,100);

		cal.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String input = inputField.getText();
				double num = Double.parseDouble(input);

				 double result = (3.95 * 17  +3.66 * 22 + 3.7 * 18 + 3.55 * 21 + 3.3 * 2 + num * 18) / 98.0;
				 DecimalFormat decimalFormat = new DecimalFormat("#.##");
                 String formattedResult = decimalFormat.format(result);

				loutput.setText("전체누계학점은 " + formattedResult + "입니다");
			}
		});
	
	}

}