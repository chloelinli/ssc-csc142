// Chloe Rushing
// 7/24/29
// This program is the code of a smiley face and its animation.

//package smileyFace;

import java.awt.*;

public class SmileyFace {
	public static void main(String[] args) { // main method
		DrawingPanel panel = new DrawingPanel(800, 800);
		panel.setBackground(Color.BLACK);
		Graphics g = panel.getGraphics();
		winkFace(panel, g);
	}
	
	public static void winkFace(DrawingPanel panel, Graphics g) { // animation and drawing face
		Color paleYellow = new Color(255, 255, 150);
		Color goldish = new Color(255, 220, 100);
		int num = 0;
		while (num < 5) {
			// normal face
			g.setColor(paleYellow);
			g.fillOval(250, 250, 300, 300);
			// mouth
			g.setColor(goldish);
			g.fillOval(360, 465, 80, 45);
			g.setColor(paleYellow);
			g.fillOval(340, 440, 120, 45);
			
			// eyes
			for (int i = 0; i < 2; i++) {
				g.fillOval(334+(i*106), 329, 26, 51);
				g.setColor(Color.BLACK);
				g.drawOval(334+(i*106), 329, 26, 51);
				g.setColor(Color.WHITE);
				g.fillOval(335+(i*106), 330, 25, 50);
				g.setColor(Color.BLACK);
				g.fillOval(337+(i*106), 341, 21, 34);
				g.drawOval(346+(i*106), 346, 10, 10);
				g.setColor(Color.WHITE);
				g.fillOval(346+(i*106), 346, 10, 10);
			}
			panel.sleep(300);
			
			// wink face
			// eyes
			g.setColor(paleYellow);
			g.fillOval(441, 329, 26, 51);
			g.setColor(Color.BLACK);
			g.fillOval(440, 360, 26, 5);
			g.setColor(paleYellow);
			g.fillOval(440, 363, 26, 5);
			panel.sleep(80);
			// mouth
			g.setColor(goldish);
			g.fillOval(320, 420, 160, 90);
			g.setColor(paleYellow);
			g.fillOval(300, 375, 200, 90);
			panel.sleep(90);			
			num++;
		}
	}
}
