package cookirun;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

class player{
	private int x;
	private int y;
	private ArrayList<ImageIcon> img;
	private int jump=0;
	private int count=0;
	private int doubleJump=0;
	private int health;
	private boolean crush=false;

	player(int x,int y,int health,ArrayList<ImageIcon> img)
	{
		this.x=x;
		this.y=y;
		this.health=health;
		this.img=img;
	}
	
	public boolean getCrush()
	{
		return this.crush;
	}
	
	
	public void setCrush(boolean a)
	{
		this.crush = a;
	}
	
	public void setHealth(int health)
	{
		this.health=health;
	}
	
	public int getHealth()
	{
		return this.health;	
	}
	
	public ImageIcon getImg()
	{
		ImageIcon img;

		img = this.img.get(1);
		
		return img;
	}
	
	public ImageIcon img() {
		ImageIcon img;
		if(this.doubleJump == -1)
			img = this.img.get((this.count%3)+9);
		else if(this.jump<0 && this.doubleJump ==0)
			img = this.img.get( (this.count%2) +4);
		else if(this.y<=480 && this.doubleJump==2)
			img = this.img.get( (this.count%3)+6);
		else if(this.y>=495 && this.doubleJump!=0) {
			img = this.img.get( this.count%4);
			this.doubleJump=0;
		}
		else if(this.y>=495 && this.doubleJump==0)
		{
			img = this.img.get( this.count%4);
			this.doubleJump=0;
		}
		else
			img = this.img.get( (this.count%2)+4);
		this.count+=1;
		
		if(this.count > 1000000000)
			this.count=0;
		
		return img;
	}
	public void footHold()
	{
			this.doubleJump=2;
			this.jump+=65;
            this.y += this.jump;
	}
	
	public void up()
	{
		this.doubleJump=0;
		this.jump=0;
		this.y=500;
	}
	
	public void slide()
	{
		this.doubleJump=-1;
		this.y=565;
	}
	
	public void posSetting()
	{
		if(this.y<500) 
		{
            this.jump+=5;
            this.y += this.jump;
		}
        else
        {
            this.y=500;
        }
	}
	
	public void jumps()
	{
		if(this.doubleJump==0 && this.jump<65) 
		{
			this.jump=-30;
			this.y+=this.jump;
			this.doubleJump+=1;
			new PLAYSOUND().jump();
		}
		else if(this.doubleJump==1&& this.jump<6)
		{
			this.jump=-45;
			this.y+=this.jump;
			this.doubleJump+=1;
			new PLAYSOUND().jump();
		}
	}
	
	public int[] getPos() {
		int arr[] = new int[2];
		arr[0] = this.x;
		arr[1] = this.y;
		return arr;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public int getJump() {
		return this.jump;
	}
	
	public int getCount() {
		return this.count;
	}
	
	public int getDoubleJump() {
		return this.doubleJump;
	}
	
	public void setX(int x) {
		this.x =x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public void setJump(int jump) {
		this.jump = jump;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	
	public void setDoubleJump(int doubleJump) {
		this.doubleJump = doubleJump;
	}
	
}

class obstacle{
	private int x;
	private int y;
	private int state;
	private ImageIcon img;
	private int sc;
	
	obstacle(int x,int y,int state,ImageIcon img)
	{
		this.x=x;
		this.y=y;
		this.state=state;
		this.img=img;
		switch(state)
		{
		case 1:
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			break;
		case 6:
			break;
		case 7:
			this.sc=5;
			break;
		case 8:
			break;
		case 9:
			this.sc=100;
			break;
		}
	}
	
	@Override
	public String toString() {
		return String.format(x+":"+y);
	}
	
	public int getSc()
	{
		return this.sc;
	}
	
	public ImageIcon getImg() {
		return this.img;
	}
	
	public int[] getPos() {
		int arr[] = new int[2];
		arr[0] = this.x;
		arr[1] = this.y;
		return arr;
	}
	
	public int getState() {
		return this.state;
	}
	
	public void setState(int state) {
		this.state = state;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public void setX(int x) {
		this.x =x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
}

class image{
	public static ArrayList<ImageIcon> appendImg() {
		ArrayList<ImageIcon> img =new ArrayList<>();

			img.add(new ImageIcon("C:\\Users\\cndls\\OneDrive\\Desktop\\ÀÚ¹Ù ÄíÅ°·±\\»µ²Ù±â\\1.png"));
			img.add(new ImageIcon("C:\\Users\\cndls\\OneDrive\\Desktop\\ÀÚ¹Ù ÄíÅ°·±\\»µ²Ù±â\\2.png"));
			img.add(new ImageIcon("C:\\Users\\cndls\\OneDrive\\Desktop\\ÀÚ¹Ù ÄíÅ°·±\\»µ²Ù±â\\4.png"));
			img.add(new ImageIcon("C:\\Users\\cndls\\OneDrive\\Desktop\\ÀÚ¹Ù ÄíÅ°·±\\»µ²Ù±â\\5.png"));
			img.add(new ImageIcon("C:\\Users\\cndls\\OneDrive\\Desktop\\ÀÚ¹Ù ÄíÅ°·±\\»µ²Ù±â\\23.png"));
			img.add(new ImageIcon("C:\\Users\\cndls\\OneDrive\\Desktop\\ÀÚ¹Ù ÄíÅ°·±\\»µ²Ù±â\\24.png"));
			img.add(new ImageIcon("C:\\Users\\cndls\\OneDrive\\Desktop\\ÀÚ¹Ù ÄíÅ°·±\\»µ²Ù±â\\55.png"));
			img.add(new ImageIcon("C:\\Users\\cndls\\OneDrive\\Desktop\\ÀÚ¹Ù ÄíÅ°·±\\»µ²Ù±â\\56.png"));
			img.add(new ImageIcon("C:\\Users\\cndls\\OneDrive\\Desktop\\ÀÚ¹Ù ÄíÅ°·±\\»µ²Ù±â\\57.png"));
			img.add(new ImageIcon("C:\\Users\\cndls\\OneDrive\\Desktop\\ÀÚ¹Ù ÄíÅ°·±\\»µ²Ù±â\\72.png"));
			img.add(new ImageIcon("C:\\Users\\cndls\\OneDrive\\Desktop\\ÀÚ¹Ù ÄíÅ°·±\\»µ²Ù±â\\73.png"));
			img.add(new ImageIcon("C:\\Users\\cndls\\OneDrive\\Desktop\\ÀÚ¹Ù ÄíÅ°·±\\»µ²Ù±â\\74.png"));
			return img;
	}
	public ImageIcon hurdle(int want, int what) {
		ImageIcon img;
		String location= new String();
		String select = new String();
		
		if(what==9)
		{
			if(want <=50)
			{
				location = "C:\\Users\\cndls\\OneDrive\\Desktop\\ÀÚ¹Ù ÄíÅ°·±\\jelly\\";
				select = String.format("Lv_"+want+".png");
				location = location.concat(select);
			}
		}
		else {
			location = "C:\\Users\\cndls\\OneDrive\\Desktop\\ÀÚ¹Ù ÄíÅ°·±\\";
			select = String.format(what+".PNG");
			location = location.concat(select);
		}
			img =new ImageIcon(location);
		
		return img;
	}
}