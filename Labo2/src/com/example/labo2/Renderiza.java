package com.example.labo2;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import javax.xml.datatype.DatatypeConstants.Field;

import com.example.labo2.MainActivity.Lienzo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.Paint.Align;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import android.opengl.GLU;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;
/**
 * Clase Renderiza (OpenGL 1.x)
 * 
 * @author Jhonny Felipez
 * @version 1.0 13/03/2014
 *
 */
public class Renderiza extends GLSurfaceView implements Renderer {
	
	//MiCanvas canvas;
	//private ESText glText;
	private Polilinea polilinea;
	//private Linea linea;
	private Circulo circulo;
	/* Tamaño de la ventana en pixeles */
	private int alto;
	private int ancho;
	/* Contexto */
	Context contexto;
	//private Lienzo canva;
	/* Para almacenar los puntos */
	private final int MAX_NUM_PUNTOS = 70;
	private float puntos[][] = new float[MAX_NUM_PUNTOS][2];
	private int numPuntos = 0;

	public Renderiza(Context context) {
		super(context);
		//canva = new Lienzo(context);
		this.contexto = context;

		/* Inicia el renderizado */
		this.setRenderer(this);
		
		/* La ventana solicita recibir una entrada */
		this.requestFocus();

		this.setFocusable(true);
		
		/* Establece que la ventana detectará el modo táctil */
		this.setFocusableInTouchMode(true);

		/* Se renderizará al inicio o cuando se llame a requestRender() */
		this.setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
	}

	
	
	@Override
	public void onSurfaceCreated(GL10 gl, EGLConfig arg1) {
		//fondo = new Lienzo(this);
		//linea = new Linea();
		circulo = new Circulo(0.3f, 360, true);
		polilinea = new Polilinea();	
		
		//canva = new Lienzo(contexto);
		//lienzo 
		/* Color de fondo */
		gl.glClearColor(180/255f, 205/255f, 230/255f, 150/255f);
	}
	
	@Override
	public void onDrawFrame(GL10 gl) {
		//Canvas canvas = null;
		//super.onDraw(canvas);
		/* Inicializa el buffer de color */
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
	
		//Bitmap b = Bitmap.createBitmap(100, 100, Bitmap.Config.ARGB_8888);
		//Canvas c = new Canvas(b);
		/*Paint texto = new Paint();
		texto.setARGB(50, 254, 30, 10);
		texto.setTextAlign(Align.CENTER);
		texto.setTextSize(30);
		canvas.drawText("Hola Mundo",canvas.getWidth(),100,texto);*/
	   /*
		//gl.glEnable(GL10.GL_LINE_SMOOTH);
		//gl.glLineWidth(18f);
		gl.glLoadIdentity();
		gl.glTranslatef(-4.4f, -1.0f, 0);
		//linea.dibuja(gl);
		*/

		gl.glColor4f(0, 0, 0, 0);
		gl.glLoadIdentity();
		//punto 1
		gl.glTranslatef(1.5f, 4.8f, 0);
		circulo.dibuja(gl);
		
		gl.glColor4f(0, 0, 0, 0);
		gl.glLoadIdentity();
		//punto2
		gl.glTranslatef(2f, 3.5f, 0);
		circulo.dibuja(gl);
		
		gl.glColor4f(0, 0, 0, 0);
		gl.glLoadIdentity();
		//posicion 3
		gl.glTranslatef(2.99f, 2.8f, 0);
		circulo.dibuja(gl);
		
		gl.glColor4f(0, 0, 0, 0);
		gl.glLoadIdentity();
		//posicion 4
		gl.glTranslatef(-0.8f, 2, 0);
		circulo.dibuja(gl);
		
		gl.glColor4f(0, 0, 0, 0);
		gl.glLoadIdentity();
		//posicion 5
		gl.glTranslatef(1.8f, -0.5f, 0);
		circulo.dibuja(gl);
		
		gl.glColor4f(0, 0, 0, 0);
		gl.glLoadIdentity();
		//posicion 6
		gl.glTranslatef(1.9f, -4.99f, 0);
		circulo.dibuja(gl);
		
		gl.glColor4f(0, 0, 0, 0);
		gl.glLoadIdentity();
		//posicion 7
		gl.glTranslatef(0.5f, -2.99f, 0);
		circulo.dibuja(gl);
		
		gl.glColor4f(0, 0, 0, 0);
		gl.glLoadIdentity();
		//posicion 8
		gl.glTranslatef(-1.1f, -3f, 0);
		circulo.dibuja(gl);
		
		gl.glColor4f(0, 0, 0, 0);
		gl.glLoadIdentity();
		//posicion 9
		gl.glTranslatef(-2.1f, -4f, 0);
		circulo.dibuja(gl);
		
		gl.glColor4f(0, 0, 0, 0);
		gl.glLoadIdentity();
		//posicion 10
		gl.glTranslatef(-3.5f, -3.5f, 0);
		circulo.dibuja(gl);
		
		gl.glColor4f(0, 0, 0, 0);
		gl.glLoadIdentity();
		//posicion 11
		gl.glTranslatef(-3.5f, -2.5f, 0);
		circulo.dibuja(gl);
		
		gl.glColor4f(0, 0, 0, 0);
		gl.glLoadIdentity();
		//posicion 12
		gl.glTranslatef(-2.5f, -2.89f, 0);
		circulo.dibuja(gl);
		
		gl.glColor4f(0, 0, 0, 0);
		gl.glLoadIdentity();
		//posicion 13
		gl.glTranslatef(2.5f, 2f, 0);
		circulo.dibuja(gl);
		
		gl.glColor4f(0, 0, 0, 0);
		gl.glLoadIdentity();
		//posicion 14
		gl.glTranslatef(-1f, -1.778f, 0);
		circulo.dibuja(gl);
		
		gl.glColor4f(0, 0, 0, 0);
		gl.glLoadIdentity();
		//posicion 15
		gl.glTranslatef(-3.5f, 1.8f, 0);
		circulo.dibuja(gl);
		
		gl.glColor4f(0, 0, 0, 0);
		gl.glLoadIdentity();
		//posicion 16
		gl.glTranslatef(-3.5f, 2.9f, 0);
		circulo.dibuja(gl);
		
		gl.glColor4f(0, 0, 0, 0);
		gl.glLoadIdentity();
		//posicion 17
		gl.glTranslatef(3.5f, 2f, 0);
		circulo.dibuja(gl);
		
		gl.glColor4f(0, 0, 0, 0);
		gl.glLoadIdentity();
		//posicion 18
		gl.glTranslatef(-2.0f, 2.6f, 0);
		circulo.dibuja(gl);
		
		gl.glColor4f(0, 0, 0, 0);
		gl.glLoadIdentity();
		//posicion 19
		gl.glTranslatef(0f, 3.2f, 0);
		circulo.dibuja(gl);
		
		gl.glColor4f(0, 0, 0, 0);
		gl.glLoadIdentity();
		//posicion
		gl.glTranslatef(0f, 4.2f, 0);
		circulo.dibuja(gl);
		
		gl.glColor4f(0, 0, 0, 0);
		gl.glLoadIdentity();
		//posicion
		gl.glTranslatef(3.5f, 2f, 0);
		//circulo.dibuja(gl);
		
		gl.glColor4f(0, 0, 0, 0);
		gl.glLoadIdentity();
		//posicion
		gl.glTranslatef(3.5f, 2f, 0);
		//circulo.dibuja(gl);
		
		//gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		//ultimo punto refencial
		gl.glColor4f(180/255f, 205/255f, 230/255f, 150/255f);
		gl.glLoadIdentity();
		//posicion
		gl.glTranslatef(0, 0, 0);
		circulo.dibuja(gl);
		

		//apartir de aqui se comienza con el graficado de las lineas
		//gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		gl.glLineWidth(12);
		gl.glEnable (GL10.GL_LINEAR);
		gl.glPointSize(8);
		gl.glEnable (GL10.GL_LINES);
		polilinea.setVertices(numPuntos, puntos);
		polilinea.dibuja(gl);
		
	}
	
	@Override
	public void onSurfaceChanged(GL10 gl, int width, int height) {
	 
		ancho = width;
		alto = height;
		
		/* Ventana de despliegue */
		gl.glViewport(0, 0, width, height);
	 
		/* Matriz de Proyección */
		gl.glMatrixMode(GL10.GL_PROJECTION);
	 
		/* Inicializa la Matriz de Proyección */
		gl.glLoadIdentity();
	 
		/* Proyección paralela */
		GLU.gluOrtho2D(gl, -4, 4, -6, 6);
		//GLU.gluOrtho2D(gl, left, right, bottom, top);
		
		/* Matriz del Modelo-Vista */
		gl.glMatrixMode(GL10.GL_MODELVIEW);
		
		/* Inicializa la Matriz del Modelo-Vista */
		gl.glLoadIdentity();
	}
	
	/*public boolean onTouchEvent(MotionEvent e) {

		// Obtiene la coordenada de la pantalla 
		float posx = e.getX();
		float posy = e.getY();

		// Se considera cuando el dedo toca la pantalla. 
		if (e.getAction() == MotionEvent.ACTION_DOWN) {

		// En coordenadas del OpenGL 
		posx = ((posx / (float) ancho) * 8) - 4;
		posy = ((1 - posy / (float) alto) * 12) - 6;

		// Adiciona un nuevo punto 
		adicionaUnNuevoPunto(posx, posy);
		requestRender(); // Llama por defecto
	}
	return true;
	}*/
	
	public boolean onTouchEvent(MotionEvent e){
		float x=e.getX();
		float y=e.getY();
		float posx,posy;
		if(e.getAction()==MotionEvent.ACTION_DOWN){
			posx=(x*8/(float)ancho)-4;
			posy=(12-y*12/(float)alto)-6;
			/*if (puntoEstaDentroDelRectangulo(posx,posy, -2,-2, 4, 4))
				Toast.makeText(contexto.getApplicationContext(),
				"Rectangulo ",Toast.LENGTH_SHORT).show();*/
			if (puntoEstaDentroDelCirculo(posx,posy,1.5f, 4.8f, 0.3f))
				{//Toast.makeText(contexto.getApplicationContext(),	"Circulo ",Toast.LENGTH_SHORT).show();
				adicionaUnNuevoPunto(posx, posy);
				requestRender();
				}else if (puntoEstaDentroDelCirculo(posx,posy,2f, 3.5f, 0.3f))
			{adicionaUnNuevoPunto(posx, posy);
			requestRender();
			//Toast.makeText(contexto.getApplicationContext(),
			//"Circulo ",Toast.LENGTH_SHORT).show();
			}else if (puntoEstaDentroDelCirculo(posx,posy,2.99f, 2.8f, 0.3f))
			{adicionaUnNuevoPunto(posx, posy);
			requestRender();
			//Toast.makeText(contexto.getApplicationContext(),
			//"Circulo ",Toast.LENGTH_SHORT).show();
			}else if (puntoEstaDentroDelCirculo(posx,posy,-0.8f, 2, 0.3f))
			{adicionaUnNuevoPunto(posx, posy);
			requestRender();
			//Toast.makeText(contexto.getApplicationContext(),
			//"Circulo ",Toast.LENGTH_SHORT).show();
			}else if (puntoEstaDentroDelCirculo(posx,posy,1.8f, -0.5f, 0.3f))
			{
			adicionaUnNuevoPunto(posx, posy);
			requestRender();
			//Toast.makeText(contexto.getApplicationContext(),
			//"Circulo ",Toast.LENGTH_SHORT).show();
			}else if (puntoEstaDentroDelCirculo(posx,posy,1.9f, -4.99f, 0.3f))
			{adicionaUnNuevoPunto(posx, posy);
			requestRender();
			//Toast.makeText(contexto.getApplicationContext(),
			//"Circulo ",Toast.LENGTH_SHORT).show();
			}else if (puntoEstaDentroDelCirculo(posx,posy,0.5f, -2.99f, 0.3f))
			{adicionaUnNuevoPunto(posx, posy);
			requestRender();
			//Toast.makeText(contexto.getApplicationContext(),
			//"Circulo ",Toast.LENGTH_SHORT).show();
			}else if (puntoEstaDentroDelCirculo(posx,posy,-1.1f, -3f, 0.3f))
			{adicionaUnNuevoPunto(posx, posy);
			requestRender();
			//Toast.makeText(contexto.getApplicationContext(),
			//"Circulo ",Toast.LENGTH_SHORT).show();
			}else if (puntoEstaDentroDelCirculo(posx,posy,-2.1f, -4f, 0.3f))
			{adicionaUnNuevoPunto(posx, posy);
			requestRender();
			//Toast.makeText(contexto.getApplicationContext(),
			//"Circulo ",Toast.LENGTH_SHORT).show();
			}else if (puntoEstaDentroDelCirculo(posx,posy,-3.5f, -3.5f, 0.3f))
			{adicionaUnNuevoPunto(posx, posy);
			requestRender();
			//Toast.makeText(contexto.getApplicationContext(),
			//"Circulo ",Toast.LENGTH_SHORT).show();
			}else if (puntoEstaDentroDelCirculo(posx,posy,-3.5f, -2.5f, 0.3f))
			{adicionaUnNuevoPunto(posx, posy);
			requestRender();
			//Toast.makeText(contexto.getApplicationContext(),
			//"Circulo ",Toast.LENGTH_SHORT).show();
			}else if (puntoEstaDentroDelCirculo(posx,posy,-2.5f, -2.89f, 0.3f))
			{adicionaUnNuevoPunto(posx, posy);
			requestRender();
			//Toast.makeText(contexto.getApplicationContext(),
			//"Circulo ",Toast.LENGTH_SHORT).show();
			}else if (puntoEstaDentroDelCirculo(posx,posy,2.5f, 2f, 0.3f))
			{adicionaUnNuevoPunto(posx, posy);
			requestRender();
			//Toast.makeText(contexto.getApplicationContext(),
			//"Circulo ",Toast.LENGTH_SHORT).show();
			}else if (puntoEstaDentroDelCirculo(posx,posy,-1f, -1.778f, 0.3f))
			{adicionaUnNuevoPunto(posx, posy);
			requestRender();
			//Toast.makeText(contexto.getApplicationContext(),
			//"Circulo ",Toast.LENGTH_SHORT).show();
			}else if (puntoEstaDentroDelCirculo(posx,posy,-3.5f, 1.8f, 0.3f))
			{adicionaUnNuevoPunto(posx, posy);
			requestRender();
			//Toast.makeText(contexto.getApplicationContext(),
			//"Circulo ",Toast.LENGTH_SHORT).show();
			}else if (puntoEstaDentroDelCirculo(posx,posy,-3.5f, 2.9f, 0.3f))
			{adicionaUnNuevoPunto(posx, posy);
			requestRender();
			//Toast.makeText(contexto.getApplicationContext(),
			//"Circulo ",Toast.LENGTH_SHORT).show();
			}else if (puntoEstaDentroDelCirculo(posx,posy,3.5f, 2f, 0.3f))
			{adicionaUnNuevoPunto(posx, posy);
			requestRender();
			//Toast.makeText(contexto.getApplicationContext(),
			//"Circulo ",Toast.LENGTH_SHORT).show();
			}else if (puntoEstaDentroDelCirculo(posx,posy,-2.0f, 2.6f, 0.3f))
			{adicionaUnNuevoPunto(posx, posy);
			requestRender();
			//Toast.makeText(contexto.getApplicationContext(),
			//"Circulo ",Toast.LENGTH_SHORT).show();
			}else if (puntoEstaDentroDelCirculo(posx,posy,0f, 3.2f, 0.3f))
			{adicionaUnNuevoPunto(posx, posy);
			requestRender();
			//Toast.makeText(contexto.getApplicationContext(),
			//"Circulo ",Toast.LENGTH_SHORT).show();
			}else if (puntoEstaDentroDelCirculo(posx,posy,0f, 4.2f, 0.3f))
			{adicionaUnNuevoPunto(posx, posy);
			requestRender();
			//Toast.makeText(contexto.getApplicationContext(),
			//"Circulo ",Toast.LENGTH_SHORT).show();
			}else {
				Toast.makeText(contexto.getApplicationContext(),	"Presiona el Punto Indicado ",Toast.LENGTH_SHORT).show();
			}
			
			//adicionaUnNuevoPunto(posx, posy);
			//requestRender();
		}
		return true;
	}
	
		/* Elimina el primer punto */
	public void eliminaElPrimerPunto() {
		if (numPuntos > 0) {
			numPuntos--;
		for (int i = 0; i < numPuntos; i++) {
			puntos[i][0] = puntos[i + 1][0];
			puntos[i][1] = puntos[i + 1][1];
		}
	}
	}
	/* Adiciona un nuevo punto */
	public void adicionaUnNuevoPunto(float x, float y) {
		if (numPuntos >= MAX_NUM_PUNTOS) {
			eliminaElPrimerPunto();
	}
		puntos[numPuntos][0] = x;
		puntos[numPuntos][1] = y;
		numPuntos++;
		}
	
	/*private boolean puntoEstaDentroDelRectangulo(float posx, float posy,
			int x, int y, int ancho, int alto){
		return (x < posx && posx < x + ancho &&
				y < posy && posy < y + alto);
	}
	*/
	private boolean puntoEstaDentroDelCirculo(float posx, float posy,
			float x, float y, float radio){
		float d2 = distancia2(posx,posy,x,y);
		return d2 < radio * radio;
	}
	
	public float distancia2(float x1, float y1, float x2, float y2){
		return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);  
	}
}
