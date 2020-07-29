 package com.example.labo2;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

public class Linea {
	private float uno[] = { 
			1.18105f,3.3404f,
			1.23246f,3.38936f,
			1.22511f,3.24983f,
	};

	FloatBuffer bufuno;
	
	private float dos[] = { 			
			1.60317f,3.44998f,
			1.66036f, 3.50901f,
			1.69534f, 3.43881f,
			1.61993f, 3.33827f,
			1.70651f, 3.33547f,
	};

	FloatBuffer bufdos;
	
	private float tres[] = { 			
			1.94391f,3.62035f,
			2.03049f, 3.5754f,
			1.97419f,3.5754f,
			2.03049f, 3.50441f,
			1.93502f, 3.50441f,
	};

	FloatBuffer buftres;

	private float cuatro[] = { 			
			2.74549f,3.62315f,
			2.70918f, 3.55891f,
			2.79017f,3.53098f,
			2.79855f, 3.6008f,
			2.78179f, 3.43323f,
	};

	FloatBuffer bufcuatro;
	
	private float cinco[] = { 			
			3,5,
			3.2066666666667f, 5.23f,
			3.3266666666667f,5.0433333333333f,
			3.06f, 4.7366666666667f,
			3.3133333333333f, 4.7233333333333f,
	};

	FloatBuffer bufcinco;
	
	private float seis[] = { 			
			8.18754f, 2.97518f,
			8.12889f, 2.86626f,
			8.1261f, 2.79364f,
			8.23781f, 2.79085f,
			8.22943f, 2.87464f,
	};

	FloatBuffer bufseis;
	
	private float siete[] = { 			
			3,5,
			3.2066666666667f, 5.23f,
			3.3266666666667f,5.0433333333333f,
			3.06f, 4.7366666666667f,
			3.3133333333333f, 4.7233333333333f,
	};

	FloatBuffer bufsiete;
	
	private float ocho[] = { 			
			3,5,
			3.2066666666667f, 5.23f,
			3.3266666666667f,5.0433333333333f,
			3.06f, 4.7366666666667f,
			3.3133333333333f, 4.7233333333333f,
	};

	FloatBuffer bufocho;
	
	private float nueve[] = { 			
			3,5,
			3.2066666666667f, 5.23f,
			3.3266666666667f,5.0433333333333f,
			3.06f, 4.7366666666667f,
			3.3133333333333f, 4.7233333333333f,
	};

	FloatBuffer bufnueve;
	
	private float diez[] = { 			
			3,5,
			3.2066666666667f, 5.23f,
			3.3266666666667f,5.0433333333333f,
			3.06f, 4.7366666666667f,
			3.3133333333333f, 4.7233333333333f,
	};

	FloatBuffer bufdiez;
	
	private float once[] = { 			
			3,5,
			3.2066666666667f, 5.23f,
			3.3266666666667f,5.0433333333333f,
			3.06f, 4.7366666666667f,
			3.3133333333333f, 4.7233333333333f,
	};

	FloatBuffer bufonce;
	
	private float doce[] = { 			
			3,5,
			3.2066666666667f, 5.23f,
			3.3266666666667f,5.0433333333333f,
			3.06f, 4.7366666666667f,
			3.3133333333333f, 4.7233333333333f,
	};

	FloatBuffer bufdoce;
	
	private float trece[] = { 			
			3,5,
			3.2066666666667f, 5.23f,
			3.3266666666667f,5.0433333333333f,
			3.06f, 4.7366666666667f,
			3.3133333333333f, 4.7233333333333f,
	};

	FloatBuffer buftrece;
	
	private float catorce[] = { 			
			3,5,
			3.2066666666667f, 5.23f,
			3.3266666666667f,5.0433333333333f,
			3.06f, 4.7366666666667f,
			3.3133333333333f, 4.7233333333333f,
	};

	FloatBuffer bufcatorce;
	
	private float quince[] = { 			
			3,5,
			3.2066666666667f, 5.23f,
			3.3266666666667f,5.0433333333333f,
			3.06f, 4.7366666666667f,
			3.3133333333333f, 4.7233333333333f,
	};

	FloatBuffer bufquince;
	
	private float dieciseis[] = { 			
			3,5,
			3.2066666666667f, 5.23f,
			3.3266666666667f,5.0433333333333f,
			3.06f, 4.7366666666667f,
			3.3133333333333f, 4.7233333333333f,
	};

	FloatBuffer bufdieciseis;
	
	private float diecisiete[] = { 			
			3,5,
			3.2066666666667f, 5.23f,
			3.3266666666667f,5.0433333333333f,
			3.06f, 4.7366666666667f,
			3.3133333333333f, 4.7233333333333f,
	};

	FloatBuffer bufdiecisiete;
	
	private float dieciocho[] = { 			
			3,5,
			3.2066666666667f, 5.23f,
			3.3266666666667f,5.0433333333333f,
			3.06f, 4.7366666666667f,
			3.3133333333333f, 4.7233333333333f,
	};

	FloatBuffer bufdieciocho;
	
	private float diecinueve[] = { 			
			3,5,
			3.2066666666667f, 5.23f,
			3.3266666666667f,5.0433333333333f,
			3.06f, 4.7366666666667f,
			3.3133333333333f, 4.7233333333333f,
	};

	FloatBuffer bufdiecinueve;
	
	private float veinte[] = { 			
			3,5,
			3.2066666666667f, 5.23f,
			3.3266666666667f,5.0433333333333f,
			3.06f, 4.7366666666667f,
			3.3133333333333f, 4.7233333333333f,
	};

	FloatBuffer bufveinte;
	
	private float veintiuno[] = { 			
			3,5,
			3.2066666666667f, 5.23f,
			3.3266666666667f,5.0433333333333f,
			3.06f, 4.7366666666667f,
			3.3133333333333f, 4.7233333333333f,
	};

	FloatBuffer bufveintiuno;
	

	public Linea() {
		ByteBuffer bufByte = ByteBuffer.allocateDirect(uno.length * 4);
		bufByte.order(ByteOrder.nativeOrder()); // Utiliza el orden del byte										// nativo
		bufuno = bufByte.asFloatBuffer(); // Convierte de byte a float
		bufuno.put(uno);
		bufuno.rewind(); // puntero al principio del buffer
		
		ByteBuffer bufd = ByteBuffer.allocateDirect(dos.length * 5);
		bufd.order(ByteOrder.nativeOrder()); // Utiliza el orden del byte										// nativo
		bufdos = bufd.asFloatBuffer(); // Convierte de byte a float
		bufdos.put(dos);
		bufdos.rewind(); // puntero al principio del buffer
		
		ByteBuffer buft = ByteBuffer.allocateDirect(tres.length * 5);
		buft.order(ByteOrder.nativeOrder()); // Utiliza el orden del byte										// nativo
		buftres = buft.asFloatBuffer(); // Convierte de byte a float
		buftres.put(tres);
		buftres.rewind(); // puntero al principio del buffer
		
		ByteBuffer bufcua = ByteBuffer.allocateDirect(cuatro.length * 5);
		bufcua.order(ByteOrder.nativeOrder()); // Utiliza el orden del byte										// nativo
		bufcuatro = bufcua.asFloatBuffer(); // Convierte de byte a float
		bufcuatro.put(cuatro);
		bufcuatro.rewind(); // puntero al principio del buffer
		
		ByteBuffer bufcin = ByteBuffer.allocateDirect(cinco.length * 5);
		bufcin.order(ByteOrder.nativeOrder()); // Utiliza el orden del byte										// nativo
		bufcinco = bufcin.asFloatBuffer(); // Convierte de byte a float
		bufcinco.put(cinco);
		bufcinco.rewind(); // puntero al principio del buffer
		
		ByteBuffer bufse = ByteBuffer.allocateDirect(seis.length * 5);
		bufse.order(ByteOrder.nativeOrder()); // Utiliza el orden del byte										// nativo
		bufseis = bufse.asFloatBuffer(); // Convierte de byte a float
		bufseis.put(seis);
		bufseis.rewind(); // puntero al principio del buffer
		
	}

	public void dibuja(GL10 gl) {
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
		/* Se especifica los datos del arreglo de vértices */
		gl.glVertexPointer(2, GL10.GL_FLOAT, 0, bufuno);
		/* Se establece el color en (r,g,b,a) */
		gl.glColor4f(1, 1, 1, 0);
		/* Dibuja el triángulo */
		gl.glDrawArrays(GL10.GL_LINE_STRIP, 0, 3);
		/* Se deshabilita el acceso al arreglo de vértices */
		gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
		
				//gl.glEnable (GL10.GL_LINEAR);
		//gl.glPointSize(8);
		//gl.glEnable (GL10.GL_LINES);
		gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
		gl.glVertexPointer(2, GL10.GL_FLOAT, 0, bufdos);
		gl.glColor4f(1, 1, 1, 0);
		//gl.glPointSize(12);
		gl.glDrawArrays(GL10.GL_LINE_STRIP, 0, 5);
		
		gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
		gl.glVertexPointer(2, GL10.GL_FLOAT, 0, buftres);
		gl.glColor4f(1, 1, 1, 0);
		//gl.glPointSize(12);
		gl.glDrawArrays(GL10.GL_LINE_STRIP, 0, 5);
		
		gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
		gl.glVertexPointer(2, GL10.GL_FLOAT, 0, bufcuatro);
		gl.glColor4f(1, 1, 1, 0);
		//gl.glPointSize(12);
		gl.glDrawArrays(GL10.GL_LINE_STRIP, 0, 5);
		
		gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
		gl.glVertexPointer(2, GL10.GL_FLOAT, 0, bufcinco);
		gl.glColor4f(1, 1, 1, 0);
		//gl.glPointSize(12);
		gl.glDrawArrays(GL10.GL_LINE_STRIP, 0, 5);
		
		gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
		gl.glVertexPointer(2, GL10.GL_FLOAT, 0, bufseis);
		gl.glColor4f(1, 1, 1, 0);
		//gl.glPointSize(12);
		gl.glDrawArrays(GL10.GL_LINE_STRIP, 0, 5);
		
		gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
	}
}
