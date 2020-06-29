package com.example.lab_4;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.opengl.GLSurfaceView.Renderer;

public class Renderiza implements Renderer {
	/* Objeto */
	//private cubo cubo;
	private piso suelo;
	private triangulo trian;
	private Cubo cubo;
	/* Para la rotación */
	private float rotZ;

	@Override
	public void onSurfaceCreated(GL10 gl, EGLConfig arg1) {
		cubo = new Cubo();
		suelo = new piso();
	 trian = new triangulo();
		//monolito = new monolito();
		//cubo = new Cubo();
		/* Habilita el modo de sombreado plano */
		gl.glShadeModel(GL10.GL_FLAT);
		/* Habilita el ocultamiento de superficies */
		gl.glEnable(GL10.GL_DEPTH_TEST);
		/* Color de fondo */
		gl.glClearColor(0, 0, 0, 0);
	}

	@Override
	public void onDrawFrame(GL10 gl) {
//		/* Inicializa el buffer de color y de profundidad */
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
		gl.glLoadIdentity();
		
		//paraq cadapiramide tenga diferente transformacion gl.glPushMatrix(); y gl.glPopMatrix();
		gl.glPushMatrix();
		//gl.glRotatef(43, 55, 35, 1);
		gl.glRotatef(200, 1, 1, 1);
		//gl.glRotatef(rotZ, 1, 1, 1);
		cubo.dibuja(gl);
		suelo.dibuja(gl);
		//cubo.dibuja(gl);
		trian.dibuja(gl);
		gl.glPopMatrix();
		
		rotZ += 1;
	}

	@Override
	public void onSurfaceChanged(GL10 gl, int w, int h) {

		/* Ventana de despliegue */
		gl.glViewport(0, 0, w, h);
		/* Matriz de Proyección */
		gl.glMatrixMode(GL10.GL_PROJECTION);
		/* Inicializa la Matriz de Proyección */
		gl.glLoadIdentity();
		/* Proyección paralela  AQUI TAMBIEN SE MUESTRA EL EJE Z*/
				//	-x, x, -y, y, -z,  z
		//gl.glOrthof(-4, 4, -6, 6, -10, 10); original
		//gl.glOrthof(-16, 16, -18, 18, -22, 22); //utilizado en e grafico
		gl.glOrthof(-36, 36, -38, 38, -50, 50);//paraver mas pequeño

		
		gl.glMatrixMode(GL10.GL_MODELVIEW);
		/* Inicializa la Matriz del Modelo-Vista */
		gl.glLoadIdentity();
	}
}
