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

public class img{
	static int jump=0;
	public static  int playing(JFrame a,int LV, int Jelly, int HP) throws InterruptedException, IOException
	{
		JFrame frame = a;
		int k = 0,i=0, Line=0,th=0,crush=0,scoreInt=0,coinInt=0;
		image img= new image();
		player cooki =  new player(100,500,HP,image.appendImg());
		loadFile load = new loadFile();
		String map[];
		long time =40;
		ArrayList<obstacle> view = new ArrayList<obstacle>();
		JLabel target,var= new JLabel() ,health = new JLabel(),before[] = new JLabel[100];
		JLabel score= new JLabel(), coin= new JLabel();
		new PLAYSOUND().playBGM();
		new loadFile();
		map = load.map();
		
		score.setFont(new Font(null).deriveFont(25.0f));
		coin.setFont(new Font(null).deriveFont(25.0f));
		target = new JLabel(cooki.img());
		
		for(k=0;k<80;k++)
		{
			for(i=0;i<31;i++)
			{
				if(map[k].charAt(i) !='0')
				{
					view.add(new obstacle(i*50,k*10,map[k].charAt(Line)-'0',img.hurdle(Jelly,map[k].charAt(Line)-'0')));
				}
			} 
		}
		Line=i;
		
		frame.setTitle("cookirun");
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setLocation(300,100);
		frame.setLayout(null);
		frame.setSize(1500,770);
		frame.setVisible(true);
		
		var.setBackground(Color.black);
		var.setSize(th, 20);
		var.setBounds(20, 60, cooki.getHealth()*10, 20);
		var.setOpaque(true);
		
		health.setBackground(Color.RED);
		
		k=0;
		while(true) {
			if(k==2)
			{
				i=0;
				for(k=0;k<80;k++)
				{
					if(Line<1024)
					{
						if(map[k].charAt(Line) !='0')
						{
							for(i=view.size();i>60;i--)
							{
								view.remove(0);
							}
							view.add(new obstacle((30)*50,k*10,map[k].charAt(Line)-'0',img.hurdle(Jelly,map[k].charAt(Line)-'0')));
						}
					}
					i++;
				}
				Line+=1;
				k=0;
			}
			
			frame.addKeyListener(new KeyListener()
					{
						@Override
						public void keyPressed(KeyEvent e) {
							if(e.getKeyCode() == KeyEvent.VK_UP)
							{
								if(jump==0) {
									jump=1;
									cooki.jumps();
								}
							}
							if(cooki.getDoubleJump()<=0)
							{
								if(e.getKeyCode() == KeyEvent.VK_DOWN)
								{
									if(cooki.getDoubleJump()==-2) {
										cooki.slide();
									}
									if(jump==0)
									{
										new PLAYSOUND().slide();
									}
									jump=-1;
								}
							}
						}
						@Override
						public void keyReleased(KeyEvent e) {
							if(e.getKeyCode() == KeyEvent.VK_UP)
							{
								jump=0;
							}

							if(e.getKeyCode() == KeyEvent.VK_DOWN)
							{
								cooki.up();
								jump=0;
							}
						}
						@Override
						public void keyTyped(KeyEvent e) {
						}
				
					});
			
			if(jump==-1){cooki.slide();}
			
			if(cooki.getDoubleJump() != -1)
			{
				cooki.posSetting();
			}
			
			i=0;
			for(obstacle bk : view)
			{
				if(bk.getState()==1)
				{
					if( bk.getX() < (cooki.getX() + cooki.getX()+cooki.getImg().getIconWidth())/2 && bk.getX()+bk.getImg().getIconWidth() > (cooki.getX() + cooki.getX()+cooki.getImg().getIconWidth())/2)
					{
						i++;
					}
				}
			}
			
			if(i==0 && cooki.getDoubleJump() <= 0)
			{
				cooki.footHold();
			}
			
			for(i=0;i<view.size();i++)
			{
				if(view.get(i).getState()>=5)
				{
					if(calculator.crush(cooki.getX()+20, cooki.getY()+60, cooki.getImg().getIconWidth()-50, cooki.getImg().getIconHeight()-60, view.get(i)))
					{
						if(view.get(i).getState()==9 || view.get(i).getState()<7)
							scoreInt+=view.get(i).getSc();
						else
							coinInt+=view.get(i).getSc();
						view.remove(i);
						break;
					}
				}

				else if(view.get(i).getState()>=2 && !cooki.getCrush())
				{
					if(calculator.crush(cooki.getX()+30, cooki.getY()+60, cooki.getImg().getIconWidth()-50, cooki.getImg().getIconHeight()-60, view.get(i)))
					{
						cooki.setHealth(cooki.getHealth()-(HP/5));
						cooki.setCrush(true);
					}
				}
			}

			target = new JLabel(cooki.img());
			target.setSize(cooki.img().getIconWidth(),cooki.img().getIconHeight());
			target.setBounds(cooki.getX(), cooki.getY(), cooki.img().getIconWidth(), cooki.img().getIconHeight());
			
			i=0;
			
			for(obstacle bk : view)
			{
				if(i<before.length)
				{
					before[i] = new JLabel(bk.getImg());
					before[i].setSize(bk.getImg().getIconWidth(), bk.getImg().getIconHeight());
					before[i].setBounds(bk.getX(), bk.getY()-57, bk.getImg().getIconWidth(), bk.getImg().getIconHeight());
					bk.setX(bk.getX()-25);
					frame.add(before[i]);
				}
				i++;
			}

			health.setSize(th, 20);
			health.setBounds(20, 60, cooki.getHealth()*10, 20);
			health.setOpaque(true);
			
			score.setText(Integer.toString(scoreInt));
			score.setBounds(700, 20, 100, 20);
			score.setOpaque(true);
			
			coin.setText(Integer.toString(coinInt));
			coin.setBounds(1300, 20, 100, 20);
			coin.setOpaque(true);
			
			frame.add(coin);
			frame.add(score);
			frame.add(health);
			frame.add(var);
			frame.add(target);
			frame.setVisible(true);
			frame.revalidate();
			frame.repaint();
			Thread.sleep(time);
			
			frame.remove(health);
			
			if(crush<25 && cooki.getCrush())
			{
				crush++;
				if(crush==19)
				{
					crush=0;
					cooki.setCrush(false);
				}
			}
			frame.remove(var);
			
			if(th%19==0)
			{
				cooki.setHealth(cooki.getHealth()-1);
			}
			
			for(i=0;i<view.size();i++)
			{
				frame.remove(before[i]);
			}
			
			frame.remove(target);
			
			if(cooki.getY()>700 || Line==1040||cooki.getHealth()<0)
			{
				frame.remove(health);
				frame.remove(var);
				frame.remove(score);
				frame.remove(coin);
				
				for(i=0;i<view.size();i++)
				{
					frame.remove(before[i]);
					frame.remove(target);
				}
				frame.setVisible(true);
				frame.revalidate();
				frame.repaint();
				new ending().view(frame, coinInt, scoreInt,LV);
				return 0;
			}
			
			k++;
			th++;
			
		}
	}
}