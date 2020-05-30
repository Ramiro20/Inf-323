package com.example.carreradeautos;

import java.io.IOException;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class MainActivityTouch extends Activity {
	
	private GLSurfaceView superficie;
	MediaPlayer mediaPlayer;
	Renderiza2Touch ren;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		GLSurfaceView superficie = new Renderiza2Touch(this);
		//ren =  new Renderiza2Touch(this);
		//superficie = new GLSurfaceView(this);
		//superficie.setRenderer(ren);
		//RelativeLayout pantalla = (RelativeLayout) getLayoutInflater().inflate(R.layout.atras, null);
		/* Ventana sin título */
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		/* Establece las banderas de la ventana de esta Actividad */
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
		/* Se crea el objeto GLSurfaceView */		
		setContentView(superficie);
		/* Se crea el objeto TextView */
		TextView textview = new TextView(this);
		
		/* Se añade el TextView al Activity (Actividad) */ 
		setContentView(textview);
		
		/* Se activa para que el volumen del audio sea cambiado por los controles
		 * del hardware. */
		setVolumeControlStream(AudioManager.STREAM_MUSIC);
		
		/* Se crea el objeto MediaPlayer */
		mediaPlayer = new MediaPlayer();
		
		try {
			/* Provee el acceso a la carpeta assets */
			AssetManager am = getAssets();
			
			/* Abre el archivo */
			AssetFileDescriptor afd = am.openFd("ambiente.ogg");
			
			/* Inicia el MediaPlayer */
			mediaPlayer.setDataSource(afd.getFileDescriptor(),
					afd.getStartOffset(), afd.getLength());
			
			/* Prepara para que la reproducción sea de forma sincrónica. Bloquea las
			 * otras tareas para que el MediaPlayer éste listo para la reproducción. */
			mediaPlayer.prepare();
			
			/* Se establece para que el reproductor se escuche de manera continua. */
			mediaPlayer.setLooping(true);
			//mediaPlayer.release();
			
		} catch(IOException e){
			textview.setText("No se puede cargar el archivo de efecto de sonido." + e.getMessage());
            mediaPlayer = null;
		}
		setContentView(superficie);
	}
	
	@Override
    protected void onResume() {
        super.onResume();
        if (mediaPlayer != null) {
            mediaPlayer.start();
        }
    }

	@Override
    protected void onPause() {
        super.onPause();
        if (mediaPlayer != null) {
            mediaPlayer.pause();
            if (isFinishing()) {
                mediaPlayer.stop();
                mediaPlayer.release();
            }
        }
    }
	
	public void regresa(View v){
		Intent intent = new Intent(this, MainActivity.class);
    	this.startActivity(intent);
	}
}
