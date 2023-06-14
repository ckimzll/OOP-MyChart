import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MyPieChart extends JPanel {

    int WIDTH = 390;
    int HEIGHT = 380;
    int CHART_RADIUS = 150;
    int CHART_START_ANGLE = 90;
    String[] labels = {"경제", "IT    ", "교핵", "교필", "기타"};
    int[] data = {39, 24, 20, 10, 5};

	Color c1 = new Color(249,108,108);
	Color c2 = new Color(169,212,244);
	Color c3 = new Color(123,193,178);
	Color c4 = new Color(252,208,129);
	Color c5 = new Color(208,231,225);

    Color[] colors = {c1, c2, c3, c4, c5};

    public MyPieChart() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setLayout(null);

		JButton b = new JButton("색상 변경");
		b.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				rotateColors();
				repaint();
			}
		});
		add(b);
		b.setBounds(1,300,110,30);
    }

	private void rotateColors() {
        Color first = colors[0];
        System.arraycopy(colors, 1, colors, 0, colors.length - 1);
        colors[colors.length - 1] = first;
    }

	public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int centerX = WIDTH / 2;
        int centerY = HEIGHT / 2;
       
        g2.drawString("<전공별 현재까지의 수강 학점에 대한 원형차트>", centerX - 80, 30);

        int total = 0;
        for (int value : data) {
            total += value;
        }

        int startAngle = CHART_START_ANGLE;
        for (int i = 0; i < data.length; i++) {
            int arcAngle = (int) Math.round((double) data[i] / total * 360);
            g2.setColor(colors[i]);
            g2.fillArc(centerX - CHART_RADIUS + 55, centerY - CHART_RADIUS +10, CHART_RADIUS * 2, CHART_RADIUS * 2, startAngle, arcAngle);
            startAngle += arcAngle;
        }

        int legendX = 1;
        int legendY = 60;
        int legendWidth = 20;
        int legendHeight = 20;

        for (int i = 0; i < labels.length; i++) {
            g2.setColor(colors[i]);
            g2.fillRect(legendX, legendY, legendWidth, legendHeight);
            g2.setColor(Color.BLACK);
            g2.drawString(labels[i] + " (" + data[i] + "학점)", legendX + legendWidth + 5, legendY + legendHeight - 5);
            legendY += legendHeight + 10;
        }
    }
}
