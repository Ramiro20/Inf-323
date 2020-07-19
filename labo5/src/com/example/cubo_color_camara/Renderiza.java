package com.example.cubo_color_camara;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import android.content.Context;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import android.opengl.GLU;
import android.opengl.Matrix;
import android.view.MotionEvent;

/**
 * Clase Renderiza (OpenGL 1.x)
 * 
 * @author Jhonny Felipez
 * @version 1.0 02/04/2014
 *
 */
public class Renderiza extends GLSurfaceView implements Renderer {

	/* Objeto */
	private Cubo cubo;
	private Suelo piso;
	private Circulo circulo;
	private Esfera esfera;
	private Trapecio trap;
	private PiramideArbol piramideabierta;
    private Piramide triancar;
	//private Anillo anillo;
	
	/* Inicializa ubicación de la vista del observador */
	private final float[] vectorEntrada = { 0, 0, -1, 1 };
	private static float posicion[] = { 0, 0, 0 };
	private final float[] direccion = new float[4];

	/* Tamaño de la ventana en pixeles */
	private int alto;
	private int ancho;
	
	/* Para la rotación y traslación */
	private float rotY;
	private	float antX;
	
	final float[] matriz = new float[16];
	
	/* Contexto */
	Context contexto;
	
	public Renderiza(Context contexto) {
		super(contexto);
		this.contexto = contexto;
		this.setRenderer(this);
		this.requestFocus();
		this.setFocusableInTouchMode(true);
		this.setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
	}
	
	@Override
	public void onSurfaceCreated(GL10 gl, EGLConfig arg1) {
		
		cubo = new Cubo();
		piso = new Suelo();
		circulo = new Circulo(0.5f, 360, true);
		//kukulkan = new Kukulkan();
		//monolito = new Monolito();
		esfera = new Esfera(2,2,2);
		trap = new Trapecio();
		piramideabierta = new PiramideArbol();
		triancar = new Piramide();
		//anillo = new Anillo();
		
		gl.glEnable(GL10.GL_DEPTH_TEST);
		gl.glClearColor(0, 170, 288, 0);

	}
	
	@Override
	public void onDrawFrame(GL10 gl) {

		/* Borra el buffer de la ventana y del z-buffer */
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
		
		/* Botones de las opciones */
		gl.glMatrixMode(GL10.GL_PROJECTION);
		gl.glLoadIdentity();
		gl.glOrthof(-4, 4, -6, 6, 1, 100);
		gl.glMatrixMode(GL10.GL_MODELVIEW);
		gl.glLoadIdentity();
		
		// Botón avanza
		gl.glPushMatrix();
		gl.glTranslatef(0, -4, 0);
		circulo.dibuja(gl);
		gl.glPopMatrix();
		
		// Botón retrocede
		gl.glPushMatrix();
		gl.glTranslatef(0, -5.5f, 0);
		circulo.dibuja(gl);
		gl.glPopMatrix();
		
		gl.glMatrixMode(GL10.GL_PROJECTION);
		gl.glLoadIdentity();
		GLU.gluPerspective(gl, 67, ancho / (float)alto, 1f, 100f);
		gl.glMatrixMode(GL10.GL_MODELVIEW);
		gl.glLoadIdentity();
		gl.glRotatef(-rotY, 0, 1, 0);
		gl.glTranslatef(-posicion[0], -posicion[1], -posicion[2]);
		
		// Piso
		gl.glPushMatrix();
		gl.glTranslatef(0, 0, -6);
		piso.dibuja(gl);
		gl.glPopMatrix();
		
		// Cubo 
		
		gl.glPushMatrix();
		gl.glTranslatef(-5, 0, -25);
		gl.glScalef(1.5f, 1.5f, 1.5f);
		cubo.dibuja(gl);
		gl.glPopMatrix();
		
				
		//trapecio
		gl.glPushMatrix();
		gl.glTranslatef(20, 0, -8);
		gl.glScalef(2, 2, 2);
		trap.dibuja(gl);
		gl.glPopMatrix();
		
		//Piramide Arbol
		gl.glPushMatrix();
		gl.glTranslatef(-14, -7, -12);
		gl.glScalef(4, 4, 4);
		piramideabierta.dibuja(gl);
		gl.glPopMatrix();
		
		//piramide
		
		gl.glPushMatrix();
		gl.glTranslatef(30, 0, -3);
		gl.glScalef(4, 4, 4);
		triancar.dibuja(gl);
		gl.glPopMatrix();
		
	
		gl.glFlush();

	}
	
	@Override
	public void onSurfaceChanged(GL10 gl, int w, int h) {
		
		ancho = w;
		alto = h;
		
		gl.glViewport(0, 0, ancho, alto);
		
		GLU.gluLookAt(gl, 0, 0, 0, 0, 0, -1, 0, 1, 0);
//		GLU.gluLookAt(gl, 50, 50, 50, 0, 0, -1, 0, 1, 0);
//		GLU.gluLookAt(gl, 50, 50, 50, 0, 0, -1, 0, 1, 0);

	}
	
	/**
	 * Maneja los eventos del movimiento en la pantalla táctil. 
	 */
	@Override
	public boolean onTouchEvent(MotionEvent e) {
		
		/* Obtiene la coordenada de la pantalla */
		float posx = e.getX();
		float posy = e.getY();
		
		/* Se considera cuando se levanta el dedo de la pantalla. */ 
		if (e.getAction() == MotionEvent.ACTION_DOWN) {
			
			/* En coordenadas del OpenGL */
			posx = ((posx / (float) ancho) * 8) - 4;
			posy = ((1 - posy / (float) alto) * 12) - 6;

			/* Verifica área elegida */
			if (puntoEstaDentroDelCirculo(posx, posy, 0, -4f, 0.5f)) { // Avanza
				Matrix.setIdentityM(matriz, 0);
				Matrix.rotateM(matriz, 0, rotY, 0, 1, 0);
				Matrix.multiplyMV(direccion, 0, matriz, 0, vectorEntrada, 0);
				
				posicion[0] = posicion[0] + direccion[0] * 0.5f;
				posicion[1] = posicion[1] + direccion[1] * 0.5f;
				posicion[2] = posicion[2] + direccion[2] * 0.5f;
				
			} else if (puntoEstaDentroDelCirculo(posx, posy, 0, -5.5f, 0.5f)) { // Retrocede
				Matrix.setIdentityM(matriz, 0);
				Matrix.rotateM(matriz, 0, rotY, 0, 1, 0);
				Matrix.multiplyMV(direccion, 0, matriz, 0, vectorEntrada, 0);
				
				posicion[0] = posicion[0] - direccion[0] * 0.5f;
				posicion[1] = posicion[1] - direccion[1] * 0.5f;
				posicion[2] = posicion[2] - direccion[2] * 0.5f;
			}
			requestRender();
		} else if (e.getAction() == MotionEvent.ACTION_MOVE) {
			if(antX == -1) {
				antX = posx;
			} else {							
				rotY = rotY + (posx - antX) / 10;
				antX = posx;
			}
			
			requestRender();
		} else { 
			antX = -1;
		}	
		return true;
	}
	
	private boolean puntoEstaDentroDelCirculo(float posx, float posy, float x,
			float y, float radio) {
		return (distancia2(posx, posy, x, y) < radio * radio);
	}

	public float distancia2(float x1, float y1, float x2, float y2) {
		return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
	}
}
