package cookirun;

import javax.swing.*;

public class calculator {
	public static boolean crush(int x,int y,int w, int h, obstacle o)
	{
		boolean s;
		
		if(w*h>(o.getImg().getIconHeight()*o.getImg().getIconWidth()))
		{
			s=crushP(x,y,w,h,o);
		}
		else
		{
			s=crushO(x,y,w,h,o);
		}
		return s;
	}
	
	private static boolean crushO(int x,int y,int w, int h, obstacle o)
	{
		double a1,a2,b1,b2;
		
		a1=o.getX()-x;
		a2=(o.getX()+o.getImg().getIconWidth())-x;
		b1=o.getY()-y;
		b2=(o.getY()+o.getImg().getIconHeight())-y;
		
		if((a1<=0 &&a2>=0)&&(b1<=0 && b2>=0))
		{
			return true;
		}
		
		a1=o.getX()-(x+w);
		a2=(o.getX()+o.getImg().getIconWidth())-(x+w);
		b1=o.getY()-(y+h);
		b2=(o.getY()+o.getImg().getIconHeight())-y;
		
		if((a1<=0 &&a2>=0)&&(b1<=0 && b2>=0))
		{
			return true;
		}
		
		a1=o.getX()-x;
		a2=(o.getX()+o.getImg().getIconWidth())-x;
		b1=o.getY()-(y+h);
		b2=(o.getY()+o.getImg().getIconHeight())-(y+h);
		
		if((a1<=0 &&a2>=0)&&(b1<=0 && b2>=0))
		{
			return true;
		}
		
		a1=o.getX()-(x+w);
		a2=(o.getX()+o.getImg().getIconWidth())-(x+w);
		b1=o.getY()-(y+h);
		b2=(o.getY()+o.getImg().getIconHeight())-(y+h);
		
		if((a1<=0 &&a2>=0)&&(b1<=0 && b2>=0))
		{
			return true;
		}
		
		return false;
	}
	
	private static boolean crushP(int x,int y,int w, int h, obstacle o)
	{
		double a1,a2,b1,b2;
		
		a1=x-o.getX();
		a2=(x+w)-o.getX();
		b1=y-o.getY();
		b2=(y+h)-o.getY();
		
		if((a1<=0 &&a2>=0)&&(b1<=0 && b2>=0))
		{
			return true;
		}
		
		a1=x-(o.getX()+o.getImg().getIconWidth());
		a2=(x+w)-(o.getX()+o.getImg().getIconWidth());
		b1=y-o.getY();
		b2=(y+h)-o.getY();
		
		if((a1<=0 &&a2>=0)&&(b1<=0 && b2>=0))
		{
			return true;
		}
		
		a1=x-o.getX();
		a2=(x+w)-o.getX();
		b1=y-(o.getY()+o.getImg().getIconHeight());
		b2=(y+h)-(o.getY()+o.getImg().getIconHeight());
		
		if((a1<=0 &&a2>=0)&&(b1<=0 && b2>=0))
		{
			return true;
		}
		
		a1=x-(o.getX()+o.getImg().getIconWidth());
		a2=(x+w)-(o.getX()+o.getImg().getIconWidth());
		b1=y-(o.getY()+o.getImg().getIconHeight());
		b2=(y+h)-(o.getY()+o.getImg().getIconHeight());
		
		if((a1<=0 &&a2>=0)&&(b1<=0 && b2>=0))
		{
			return true;
		}
		
		return false;
	}
}
