package com.example.labo2;

//import com.androidya.proyecto040.R;
//import com.androidya.proyecto040.MainActivity.Lienzo;

//import com.androidya.proyecto040.EffectsRenderer;

import javax.microedition.khronos.opengles.GL10;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;

/**
 * Programa que despliega un Circulo en OpenGL ES 1.x.
 * 
 * @author Jhonny Felipez
 * @version 1.0 13/03/2014
 *
 */
public class MainActivity extends Activity {

	GLSurfaceView superficie;
	//MiCanvas canvas;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
		/* Se crea el objeto GLSurfaceView */
		//GLSurfaceView superficie = new GLSurfaceView(this);

		/* Se crea el objeto Renderiza */
		//canvas = new MiCanvas(this);
		superficie = new Renderiza(this);
		
		/* GLSurfaceView <- Renderiza : Inicia el renderizado */ 
		

		/*
		 * Activity <- GLSurfaceView  : Coloca la Vista de la Superficie del
		 * OpenGL como un Contexto de ésta Actividad.
		 */
		
		setContentView(superficie);
		//setContentView(superficie);
		//superficie.add
		//RelativeLayout layout1 = (RelativeLayout) findViewById(R.id.container);
		//Lienzo fondo = new Lienzo(this);
		//setContentView(fondo);
		//layout1.setZOrderOnTop(true);
		//layout1.addView(fondo);
		//layout1.addView(superficie);
		
		
		//layout1.add
		//layout1.addView(superficie.setRenderer(new Renderiza(this)));
		//superficie.setRenderer(new Renderiza(this));
		//layout1.addVi
		}
	
	class Lienzo extends View {
		
		Renderiza ren;

		public Lienzo(Context context) {
			super(context);
			ren = new Renderiza(context);
		}

		protected void onDraw(Canvas canvas) {
			//canvas.drawRGB(0, 0, 255);
			Paint pincel1 = new Paint();
			pincel1.setARGB(255, 255, 0, 0);
			pincel1.setTextSize(30);
			pincel1.setTypeface(Typeface.SERIF);
			canvas.drawText("1", 350, 600, pincel1);
			pincel1.setTypeface(Typeface.SANS_SERIF);
			canvas.drawText("2", 200, 100, pincel1);
			pincel1.setTypeface(Typeface.MONOSPACE);
			canvas.drawText("3", 200, 140, pincel1);
			Typeface tf = Typeface.create(Typeface.SERIF, Typeface.ITALIC);
			pincel1.setTypeface(tf);
			canvas.drawText("4", 200, 180, pincel1);
			tf = Typeface.create(Typeface.SERIF, Typeface.ITALIC
					| Typeface.BOLD);
			pincel1.setTypeface(tf);
			canvas.drawText("5", 200, 220, pincel1);
		}
	}
}
