import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MyLineChart extends JPanel {

    int WIDTH = 430;
    int HEIGHT = 380;
    String[] labels = {"경제", "IT", "교핵", "교필", "기타"};
    int[] data1 = {39, 24, 20, 10, 5};
	int[] data2 = {42, 42, 15, 12, 0};

    public MyLineChart() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }

	public void paintComponent(Graphics g) {
        super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int centerX = WIDTH / 2;
        int centerY = HEIGHT / 2;
       
        g2.drawString("<전공별 현재까지의 수강학점과 필수 수강학점에 대한 선형차트>", centerX - 150, 30);

        int maxValue = 0;
        for (int value : data1) {
            if (value > maxValue) {
                maxValue = value;
            }
        }

        int barWidth = (WIDTH - 100) / data1.length;
        int barHeightUnit = (HEIGHT - 100) / (maxValue + 5);

        g.setColor(Color.BLUE);
        for (int i = 0; i < data1.length - 1; i++) {
            int x1 = 50 + i * barWidth + barWidth / 2;
            int y1 = HEIGHT - 50 - data1[i] * barHeightUnit;
            int x2 = 50 + (i + 1) * barWidth + barWidth / 2;
            int y2 = HEIGHT - 50 - data1[i + 1] * barHeightUnit;
            g.drawLine(x1, y1, x2, y2);
        }

        g.setColor(Color.BLUE);
        for (int i = 0; i < data1.length; i++) {
            int x = 50 + i * barWidth + barWidth / 2 - 6;
            int y = HEIGHT - 50 - data1[i] * barHeightUnit - 5;
            g.drawString(Integer.toString(data1[i]), x, y);
        }

		int maxValue2 = 0;
        for (int value2 : data2) {
            if (value2 > maxValue2) {
                maxValue2 = value2;
            }
        }

	    g.setColor(Color.BLACK);
        for (int i = 0; i < data2.length - 1; i++) {
            int x1 = 50 + i * barWidth + barWidth / 2;
            int y1 = HEIGHT - 50 - data2[i] * barHeightUnit;
            int x2 = 50 + (i + 1) * barWidth + barWidth / 2;
            int y2 = HEIGHT - 50 - data2[i + 1] * barHeightUnit;
            g.drawLine(x1, y1, x2, y2);
        }

        g.setColor(Color.BLACK);
        for (int i = 0; i < data2.length; i++) {
            int x = 50 + i * barWidth + barWidth / 2 - 6;
            int y = HEIGHT - 50 - data2[i] * barHeightUnit - 5;
            g.drawString(Integer.toString(data2[i]), x, y);
        }

		for (int i = 0; i < labels.length; i++) {
            int x = 50 + i * barWidth;
            int y = HEIGHT - 30;
            g.drawString(labels[i], x, y);
        }


    }
}