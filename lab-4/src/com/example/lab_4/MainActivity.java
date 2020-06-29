package com.example.lab_4;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.os.Build;

public class MainActivity extends Activity {

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		/* Ventana sin t�tulo */
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		/* Establece las banderas de la ventana de esta Actividad */
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		/* Se crea el objeto GLSurfaceView */
		GLSurfaceView superficie = new GLSurfaceView(this);
		/* Se crea el objeto Renderiza */
		Renderiza renderiza = new Renderiza();
		/* GLSurfaceView <- Renderiza : Inicia el renderizado */
		superficie.setRenderer(renderiza);
		/*
		 * Activity <- GLSurfaceView : Coloca la Vista de la Superficie del
		 * OpenGL como un Contexto de �sta Actividad.
		 */
		setContentView(superficie);
		// setContentView(R.layout.activity_main);
	}

}
