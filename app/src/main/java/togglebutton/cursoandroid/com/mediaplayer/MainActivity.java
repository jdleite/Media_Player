package togglebutton.cursoandroid.com.mediaplayer;

import android.app.Activity;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    private Button btnTocar;
    private MediaPlayer mediaPlay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnTocar = (Button) findViewById(R.id.btnTocarId);
        mediaPlay = MediaPlayer.create(MainActivity.this, R.raw.musica);

        btnTocar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(mediaPlay.isPlaying()){


                    pausar();
                }else{
                    tocar();
                }





            }
        });

    }

        private void tocar(){
            if(mediaPlay != null){
                mediaPlay.start();

                btnTocar.setText("Pausar");

            }

        }

        private void pausar(){


            if(mediaPlay !=null) {
                mediaPlay.pause();

                btnTocar.setText("Tocar");
            }

        }


    @Override
    protected void onDestroy() {

        if(mediaPlay != null  && mediaPlay.isPlaying()){

            mediaPlay.stop();
            mediaPlay.release();
            mediaPlay = null;

        }

        super.onDestroy();
    }
}

