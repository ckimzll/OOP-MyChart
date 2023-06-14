import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;
import java.awt.event.*;

public class MyChart extends JFrame{
	public MyChart(){
		setTitle("나만의 차트만들기 : KCY");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setBounds(100,100,1400,1000);
		Color c1 = new Color(6,58,81);
		Border br = BorderFactory.createLineBorder(c1);
		Container c = getContentPane();

		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		JPanel p4 = new JPanel();
		JPanel p5 = new JPanel();
		JPanel p6 = new JPanel();

		//creation p1
		JLabel l1 = new JLabel("<html>2023년 1학기 기준 현재 수강하고 있는 강의를 포함하여 졸업학점기준에 따라 남은 학점을 전공, 복수전공, 교양으로 나누어 정리하였습니다. 경제 전공은 42학점 중 39학점, IT 전공은 42학점 중 24학점 수강했습니다. 교양핵심은 각 영역별로 3학점 이상 20학점 수강하여 필수 수강학점을 초과했습니다. 교양필수는 2학점이 부족하나 IT 공학전공 졸업이수 시 교양핵심 학점으로 대체 가능합니다. 이러한 전공별 학점을 원형그래프, 막대그래프, 선형그래프로 정리하였습니다. 나만의 차트에서는 1학기부터 4학기까지의 학점을 목표학점인 3.7학점 이상일 경우 눈이 오는 행복한 눈사람을, 3.7이하일 경우 비가 와 슬픈 눈사람을 그려 표현하였습니다. 마지막 입력 데이터 패널에서는 이번 학기인 5학기 학점을 입력하면 누계 학점을 계산해주는 계산기를 구현해보았습니다.</html>");
		l1.setBounds(20,40,400,500);
		p1.add(l1);

		JLabel l11 = new JLabel("");
		l11.setBounds(110,10,200,200);
		ImageIcon song = new ImageIcon("Images\\song.png");
		l11.setIcon(song);
		p1.add(l11);

		//creation p2
		JPanel p22 = new MyPieChart();
		p22.setBounds(15,5,400,390);
		p2.add(p22);   
		setVisible(true);

		//creation p3
		JPanel p33 = new MyBarChart();
		p33.setBounds(15,5,400,390);
		p3.add(p33);   
		setVisible(true);

		//creation p4
		JPanel p44 = new MyLineChart();
		p44.setBounds(1,5,410,390);
		p4.add(p44);   
		setVisible(true);

		//creation p5
		JPanel p55 = new MySnowmanChart();
		p55.setBounds(1,5,410,390);
		p5.add(p55);

		//creation p6
		JPanel p66 = new InputDataChart();
		p66.setBounds(1,5,410,390);
		p6.add(p66);
		
		p1.setLayout(null);
		p2.setLayout(null);
		p3.setLayout(null);
		p4.setLayout(null);
		p5.setLayout(null);
		p6.setLayout(null);

		p1.setBounds(10,10,450,400);
		p2.setBounds(470,10,450,400);
		p3.setBounds(930,10,450,400);
		p4.setBounds(10,420,450,400);
		p5.setBounds(470,420,450,400);
		p6.setBounds(930,420,450,400);

		p1.setBorder(br);
		p2.setBorder(br);
		p3.setBorder(br);
		p4.setBorder(br);
		p5.setBorder(br);
		p6.setBorder(br);

		c.add(p1);
		c.add(p2);
		c.add(p3);
		c.add(p4);
		c.add(p5);
		c.add(p6);

		setVisible(true);

	}
}