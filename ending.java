package cookirun;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;
import javax.swing.event.*;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import java.awt.Font;

public class ending {
	public static int view(JFrame f,int coin,int score, int LV)
	{
		JLabel showScore = new JLabel();
		showScore.setFont(new Font(null).deriveFont(50.0f));
		showScore.setSize(100, 100);
		showScore.setBounds(650, 250, 300, 300);
		showScore.setOpaque(true);
		showScore.setText(Integer.toString((int)((score*(1+((float)LV/100))))));
		
		f.add(showScore);
		f.setVisible(true);
		f.revalidate();
		f.repaint();
		return coin;
	}
}
