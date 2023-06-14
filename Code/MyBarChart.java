import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MyBarChart extends JPanel {

    int WIDTH = 390;
    int HEIGHT = 380;
    String[] labels = {"경제", "IT", "교핵", "교필", "기타"};
    int[] data = {39, 24, 20, 10, 5};
    Color c1 = new Color(249,108,108);
	Color c2 = new Color(169,212,244);
	Color c3 = new Color(123,193,178);
	Color c4 = new Color(252,208,129);
	Color c5 = new Color(208,231,225);;

    Color[] colors = {c1, c2, c3, c4, c5};


    public MyBarChart() {
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
		b.setBounds(200,50,110,30);
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
       
        g2.drawString("<전공별 현재까지의 수강 학점에 대한 막대차트>", centerX - 80, 30);


        int maxValue = 0;
        for (int value : data) {
            if (value > maxValue) {
                maxValue = value;
            }
        }

        int barWidth = (WIDTH - 100) / data.length;
        int barHeightUnit = (HEIGHT - 100) / (maxValue + 5);

        for (int i = 0; i < data.length; i++) {
            int x = 50 + i * barWidth;
            int y = HEIGHT - 50 - data[i] * barHeightUnit;
            int barHeight = data[i] * barHeightUnit;
            g.setColor(colors[i]);
            g.fillRect(x, y, barWidth, barHeight);

            g.setColor(Color.BLACK);
            g.drawString(Integer.toString(data[i]), x + barWidth / 2 - 6, y - 5);

            g.drawString(labels[i], x, HEIGHT - 30);
    }
}
}