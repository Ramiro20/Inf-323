package com.example.carreradeautos;

import java.util.Random;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import android.content.Context;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import android.opengl.GLU;
import android.view.MotionEvent;

public class Renderiza2Touch extends GLSurfaceView implements Renderer {

	/* Objeto */
	Context context;
	MainActivityTouch mmm;
	private Textura textura;
	private Textura texturaPrincipal;
//cerrar	
	private Textura cerrar;
	
	private Textura texturaRoca;
	private Textura texturaMeteorito;
	private Textura texturaAsteroide;
//colision	
	private Textura explosion;

	float c=0;
	private float despLineasY;
	//private float velocidadCoche1;
	private float despNavex;
	
	private float despRocax;
	private float despRocay;
	
	private float despMeteoritox;
	private float despMeteoritoy;
	
	private float despAsteroidex;
	private float despAsteroidey;
	
	//private Rectangulo rectangulocoche1;
	//private Rectangulo rectangulocoche2;
	
	
	Random ran  = new Random();
	
	public Renderiza2Touch(Context contexto) {
		super(contexto);
		context = contexto;
		mmm=(MainActivityTouch)contexto;
		this.setRenderer(this);
		this.requestFocus();
		this.setFocusableInTouchMode(true);
		this.setRenderMode(GLSurfaceView.RENDERMODE_CONTINUOUSLY);
	}
	
	@Override
	public void onSurfaceCreated(GL10 gl, EGLConfig arg1) {

		textura = new Textura(gl, context, "space.png");
		textura.setVertices(0, 0, 320, 480);	
		//despCochePrincipalx = 0;		
		texturaPrincipal = new Textura(gl, context, "bb9.png");
		texturaPrincipal.setVertices(100, 50, 40, 45);
		
//cerrar
		cerrar = new Textura(gl, context, "cerrar.png");
		cerrar.setVertices(280, 430, 25, 25);
		
		texturaRoca = new Textura(gl, context, "bb10.png");
		texturaRoca.setVertices(100, 50, 40, 45);
		texturaMeteorito = new Textura(gl, context, "bb13.png");
		texturaMeteorito.setVertices(100, 50, 40, 45);
		texturaAsteroide = new Textura(gl, context, "bb14.png");
		texturaAsteroide.setVertices(100, 50, 40, 45);
		
//explosion
		explosion = new Textura(gl, context, "explosion.png");
		explosion.setVertices(80, 50, 70, 70);
		
		despNavex = 0;
		despLineasY = 0;
		
		
		
		if (ran.nextInt(2) == 0) {
			despRocax = 0;
		}		
		else {
			despRocax = 80;
		}
		
		if (ran.nextInt(2) == 0) {
			despMeteoritox = 0;
		}		
		else {
			despMeteoritox = 80;
		}
		
		if (ran.nextInt(2) == 0) {
			despAsteroidex = 0;
		}		
		else {
			despAsteroidex = 80;
		}
		
		
		despRocay = 460;
		despMeteoritoy = 780;
		despAsteroidey = 1080;
		
		gl.glEnable(GL10.GL_TEXTURE_2D);
		gl.glBlendFunc(GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA);
		
		/* Color de fondo */
		gl.glClearColor(8f/255, 4f/255, 24f/255, 0);
		
	}
	public void dibujaCarretera(GL10 gl){
		
		gl.glMatrixMode(GL10.GL_MODELVIEW);
		gl.glLoadIdentity();
		
		gl.glMatrixMode(GL10.GL_TEXTURE);
		gl.glLoadIdentity();
		gl.glTranslatef(0, despLineasY, 0);
		gl.glBindTexture(GL10.GL_TEXTURE_2D, textura.getCodigoTextura());
		textura.muestra(gl);
	}
	
	public void dibujaCerrar(GL10 gl){
		gl.glMatrixMode(GL10.GL_MODELVIEW);
		gl.glLoadIdentity();

		gl.glTranslatef(0, 0, 0);
		gl.glMatrixMode(GL10.GL_TEXTURE);
		gl.glLoadIdentity();
		gl.glBindTexture(GL10.GL_TEXTURE_2D, cerrar.getCodigoTextura());
		//texturaPrincipal.setVertices(100+despCochePrincipalx, 50, 40, 45);
		cerrar.muestra(gl);
	}	
	
	public void dibujaCoche1(GL10 gl){
	
		
		gl.glMatrixMode(GL10.GL_MODELVIEW);
		gl.glLoadIdentity();

		gl.glTranslatef(despNavex, 0, 0);
		gl.glMatrixMode(GL10.GL_TEXTURE);
		gl.glLoadIdentity();
		gl.glBindTexture(GL10.GL_TEXTURE_2D, texturaPrincipal.getCodigoTextura());
		//texturaPrincipal.setVertices(100+despCochePrincipalx, 50, 40, 45);
		texturaPrincipal.muestra(gl);
	}
	
	public void dibujaCoche2(GL10 gl){
		gl.glMatrixMode(GL10.GL_MODELVIEW);
		gl.glLoadIdentity();
		gl.glTranslatef(despRocax, despRocay, 0);
		gl.glMatrixMode(GL10.GL_TEXTURE);
		gl.glLoadIdentity();
		
		gl.glBindTexture(GL10.GL_TEXTURE_2D, texturaRoca.getCodigoTextura());
		texturaRoca.muestra(gl);
		
	}
	
	public void dibujaCoche3(GL10 gl){
		gl.glMatrixMode(GL10.GL_MODELVIEW);
		gl.glLoadIdentity();
		gl.glTranslatef(despMeteoritox, despMeteoritoy, 0);
		gl.glMatrixMode(GL10.GL_TEXTURE);
		gl.glLoadIdentity();
		
		gl.glBindTexture(GL10.GL_TEXTURE_2D, texturaMeteorito.getCodigoTextura());
		texturaMeteorito.muestra(gl);
		
	}
	
	public void dibujaCoche4(GL10 gl){
		gl.glMatrixMode(GL10.GL_MODELVIEW);
		gl.glLoadIdentity();
		gl.glTranslatef(despAsteroidex, despAsteroidey, 0);
		gl.glMatrixMode(GL10.GL_TEXTURE);
		gl.glLoadIdentity();
		
		gl.glBindTexture(GL10.GL_TEXTURE_2D, texturaAsteroide.getCodigoTextura());
		texturaAsteroide.muestra(gl);
		
	}
	

	
	@Override
	public void onDrawFrame(GL10 gl) {
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		dibujaCarretera(gl);
		
		dibujaCoche1(gl);
//cerrar
		dibujaCerrar(gl);
		
		dibujaCoche2(gl);
		dibujaCoche3(gl);
		dibujaCoche4(gl);

		
		
		if (!seSobrePonen(despNavex, despRocax, despRocay) 
			&&  !seSobrePonen(despNavex, despMeteoritox, despMeteoritoy)
			&&  !seSobrePonen(despNavex, despAsteroidex, despAsteroidey)) {
			
			
			mmm.onResume();
			
			despLineasY = despLineasY - 0.01f;
			despRocay =  despRocay - 10;
			despMeteoritoy =  despMeteoritoy - 10;
			despAsteroidey =  despAsteroidey - 10;
			if (despLineasY < -60)
				despLineasY = 0;
			
			if (despRocay < -660){
				c=c+10;
				despRocay = 460;
				despMeteoritoy = 760;
				despAsteroidey = 1060;
				
				if (ran.nextInt(2) == 0) {
					despRocax = 0;
				}		
				else {
					despRocax = 80;
				}
				if (ran.nextInt(2) == 0) {
					despMeteoritox = 0;
				}		
				else {
					despMeteoritox = 80;
				}
				if (ran.nextInt(2) == 0) {
					despAsteroidex = 0;
				}		
				else {
					despAsteroidex = 80;
				}
			}
		}
		else{
			mmm.onPause();
			gl.glMatrixMode(GL10.GL_MODELVIEW);
			gl.glLoadIdentity();
			gl.glTranslatef(despNavex, 0, 0);
			gl.glMatrixMode(GL10.GL_TEXTURE);
			gl.glLoadIdentity();
			gl.glBindTexture(GL10.GL_TEXTURE_2D,explosion.getCodigoTextura());
			//texturaPrincipal.setVertices(100+despCochePrincipalx, 50, 40, 45);
			explosion.muestra(gl);
			
			//texturaPrincipal.setVertices(100+despCochePrincipalx, 50, 40, 45);
			
		}			
	}
	
	@Override
	public void onSurfaceChanged(GL10 gl, int width, int height) {
	 
		/* Ventana de despliegue */
		gl.glViewport(0, 0, width, height);
	 
		/* Matriz de Proyección */
		gl.glMatrixMode(GL10.GL_PROJECTION);
	 
		/* Inicializa la Matriz de Proyección */
		gl.glLoadIdentity();
	 
		/* Proyección paralela */
		GLU.gluOrtho2D(gl, 0, 320, 0, 480);
	 
		/* Matriz del Modelo-Vista */
		gl.glMatrixMode(GL10.GL_MODELVIEW);
	 
		/* Inicializa la Matriz del Modelo-Vista */
		gl.glLoadIdentity();
	}
	
	public boolean onTouchEvent (MotionEvent e){
		if (e.getAction() == MotionEvent.ACTION_UP) {
			//Toast.makeText(context.getApplicationContext(), despCoche1x+"", Toast.LENGTH_LONG).show();
			if (despNavex == 0) {
				despNavex = 80;
			}
			else
				despNavex = 0;
			requestRender();
		}
		return true;
	}
	
	
	public boolean seSobrePonen (float desAx, float desBx, float desBy){
		if (Math.abs(desAx-desBx) == 0) {
			if (desBy <= 50 && desBy >=-35) {
				return true;
			}
			return false;
		}
		return false;
	}
}
