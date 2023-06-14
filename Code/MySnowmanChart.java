import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MySnowmanChart extends JPanel implements ActionListener{
    boolean s = true; 

    JButton s1 = new JButton("1학기");
    JButton s2 = new JButton("2학기");
	JButton s3 = new JButton("3학기");
    JButton s4 = new JButton("4학기");
 
    public MySnowmanChart(){
		setLayout(null);

        add(s1);
        add(s2);
		add(s3);
		add(s4);
		
		s1.setBounds(300,50,80,30);
		s2.setBounds(300,90,80,30);
		s3.setBounds(300,130,80,30);
		s4.setBounds(300,170,80,30);

        s1.addActionListener(this);
        s2.addActionListener(this);
		s3.addActionListener(this);
        s4.addActionListener(this);

		JLabel l = new JLabel("<html>1학기 학점: 3.95 <br>2학기 학점: 3.66 <br> 3학기 학점: 3.70 <br> 4학기 학점: 3.55 </html>");
		l.setBounds(300, 70, 400 ,400);
		add(l);

        
        setVisible(true);
    }
 
    public void paintComponent(Graphics g){
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int centerX = WIDTH / 2;
        int centerY = HEIGHT / 2;
       
        g2.drawString("<나만의 차트 - 학기별 학점을 알려주는 차트>", centerX + 80, 30);

        if(s == true)
        {
            //Head of snowman
			g.setColor(Color.WHITE);
			g.fillOval(40,100,150,150);
			g.setColor(Color.BLACK);
			g.fillOval(70,140,15,20);
			g.fillOval(140,140,15,20);
			g.drawArc(90, 150, 50, 35,180,180);
			
			//Body of snowman
			g.setColor(Color.WHITE);
			g.fillOval(20,200,200,200);

            g.setColor(Color.WHITE);
            g.fillOval(10,10, 15 ,15);
            g.fillOval(65,35, 15 ,15);
			g.fillOval(97,58, 15 ,15);
			g.fillOval(180,100, 15 ,15);
			g.fillOval(150, 44, 15 ,15);
			g.fillOval(33,65, 15 ,15);
        }
 
        else
        {
			//Head of snowman
			g.setColor(Color.WHITE);
			g.fillOval(40,140,150,150);
			g.setColor(Color.BLACK);
			g.fillOval(70,180,15,20);
			g.fillOval(140,180,15,20);
			g.drawArc(90, 200, 50, 35,180,-180);
			
			//Body of snowman
			g.setColor(Color.WHITE);
			g.fillOval(20,230,200,200);

            //Rain
            g.setColor(Color.BLUE);
			g.fillOval(10,10, 3 ,25);
            g.fillOval(65,55, 3 ,25);
			g.fillOval(97,78, 3 ,25);
			g.fillOval(200,100, 3 ,25);
			g.fillOval(150,64, 3 ,25);
			g.fillOval(33,85, 3 ,25);
        }
 
    }
 
 
    public void actionPerformed (ActionEvent e)
 
    {
        if(e.getSource() == s1 || e.getSource() == s3)
        {
            s = true;
            repaint();
        }
 
        else if(e.getSource() == s2 || e.getSource() == s4)
             {
                s = false;
                repaint();
             }
 
    }
 
}