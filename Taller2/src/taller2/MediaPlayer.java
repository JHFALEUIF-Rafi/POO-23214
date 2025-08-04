
import taller2.AudioPlayer;
import taller2.VideoPlayer;

public class MediaPlayer implements AudioPlayer, VideoPlayer {

    @Override
    public void playAudio() {
       System.out.println("Playing audio...");
    }

    @Override
    public void playVideo() {
       System.out.println("Playing video..."); 
    }

    @Override
    public void playSubtitles() {
        System.out.println("Displaying subtitles...");
    }
    
}

