import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
public class MusicPlayer{
  private InputStream in;
  private AudioStream audioStream;
  private String songName;
  public MusicPlayer(){
  }
public void play(String songName){
//Music implementation learned from RB Whitaker at rbwhitaker.wikidot.com
try{
in = new FileInputStream(new File(songName));
audioStream = new AudioStream(in);
AudioPlayer.player.start(audioStream);
}
catch (Exception e)
{
e.printStackTrace();
System.exit(1);
}
}
public void stop(){
  AudioPlayer.player.stop(audioStream);
}
}
