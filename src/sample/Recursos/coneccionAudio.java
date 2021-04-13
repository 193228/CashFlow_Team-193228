package sample.Recursos;

import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;

import java.nio.file.Paths;

public class coneccionAudio {

    public AudioClip audioClip[] = new AudioClip[6];

    String ruta = "CashFlow-193228/src/sample/Recursos/Canciones/";
    String extension = ".mp3";

    public void listSong(coneccionAudio coneccionAudio){
        for(int i=0; i<2; i++){
            String rutaCancion = ruta+i+extension;
            Media hit = new Media(Paths.get(rutaCancion).toUri().toString());
            audioClip[i] = new AudioClip(hit.getSource());
        }
    }
}