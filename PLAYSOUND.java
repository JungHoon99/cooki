package cookirun;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.*;

public class PLAYSOUND {
	void playBGM()
	{
		File file = new File("C:/Users/cndls/OneDrive/Desktop/자바 쿠키런/BGM.wav");
		playMusic(file,100);
	}
	
	void jump()
	{
		File file = new File("C:/Users/cndls/OneDrive/Desktop/자바 쿠키런/jump.wav");
		playMusic(file,0);

	}
	
	void slide()
	{
		File file = new File("C:/Users/cndls/OneDrive/Desktop/자바 쿠키런/slide.wav");
		playMusic(file,0);

	}

	private void playMusic(File file, int count)
	{   
        try {
            AudioInputStream stream = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(stream);
            clip.loop(count);
            clip.start();
            
        } catch(Exception e) {
            
            e.printStackTrace();
        }
	}
	
}
