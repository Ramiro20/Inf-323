package com.example.cubo_color_camara;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import javax.microedition.khronos.opengles.GL10;

public class Cubo {
	/* Las coordenadas cartesianas (x, y, z) */
	private float vertices[] = new float[] {
	// se escriven los vertices en orden antiorario
			
			//pared frente
			-2,-2,2,	//0
			-2,2,2,		//1
			2,2,2,		//2
			2,-2,2,		//3
		
			//pared derecha
			2,-2,2,		//4
			2,2,2,		//5
			2,2,-2,		//6
			2,-2,-2,	//7
			
			//pared izquierda
			-2,-2,-2,	//8
			-2,2,-2,	//9
			-2,2,2,		//10
			-2,-2,2,	//11
			
			//pared atras
			2,-2,-2,	//12
			2,2,-2,		//13
			-2,2,-2,	//14
			-2,-2,-2,	//15
			
			//techo
			-2,2,-2,	//16
			-2,2,2,		//17
			2,2,2,		//18
			2,2,-2,		//19
			
			//suelo
			-4,-2,-2,	//20
			-4,-2,4,	//21
			2,-2,4,		//22
			2,-2,-2,	//23
			
			//casita frente
			-2,2,0,		//24
			-2,4,0,		//25
			0,4,0,		//26
			0,2,0,		//27
			
			//casita derecha
			0,4,0,		//24
			0,4,-2,		//25
			0,2,-2,		//26
			0,2,0,		//27
			
			//casita izquierda
			-2,4,-2,		//24
			-2,4,0,			//25
			-2,2,0,			//26
			-2,2,-2,		//27
			
			//casita atras
			-2,4,-2,		//24
			0,4,-2,			//25
			0,2,-2,			//26
			-2,2,-2,		//27
			
			//CASITA TECHO
			//frente
			-1,5,-1,
			0,4,0,
			-2,4,0,
			//drecha
			-1,5,-1,
			0,4,-2,
			0,4,0,
			//izquierda
			-1,5,-1,
			-2,4,0,
			-2,4,-2,
			//atras
			-1,5,-1,
			0,4,-2,
			-2,4,-2,
			
			//cerca frente
			-2,3,2,
			2,3,2,
			2,2,2,
			-2,2,2,
			//cerca derecha
			2,3,2,
			2,3,-2,
			2,2,-2,
			2,2,2,
			//cerca izquierda
			-2,3,0,
			-2,3,2,
			-2,2,2,
			-2,2,0,
			//cerca atras
			0,3,-2,
			2,3,-2,
			2,2,-2,
			0,2,-2,
	};
	private short indices[] = new short[] {
			//pared frente
			0,1,2,0,2,3,
			//pared derecha
			4,5,6,4,6,7,
			//pared izquierda
			8,9,10,8,10,11,
			//pared atras
			12,13,14,12,14,15,
			
			//techo
			16,17,18,16,18,19,
			
			//piso
			20,21,22,20,22,23,
			
			//casita frente
			24,25,26,24,26,27,
			//casita derecha
			28,29,30,28,30,31,
			//casita derecha
			32,33,34,32,34,35,
			//casita atras
			36,37,38,36,38,39,
			
			//CASITA TECHO
			//FRENTE
			40,41,42,
			//DERECHA
			43,44,45,
			//IZQUIERDA
			46,47,48,
			//ATRAS
			49,50,51,
			
			//cerca frente
			52,53,54,52,54,55,
			//cerca derecha
			56,57,58,56,58,59,
			//cerca izquierda
			60,61,62,60,62,63,
			//cerca atras
			64,65,66,64,66,67,
	};

	
	/* Los colores x c/vértice (r,g,b,a) */
	byte maxColor = (byte) 255;
	private byte colores[] = new byte[] {
			// Frente - lila
			(byte)161,(byte)136,(byte)127,(byte)255,
			(byte)161,(byte)136,(byte)127,(byte)255,
			(byte)161,(byte)136,(byte)127,(byte)255,
			(byte)161,(byte)136,(byte)127,(byte)255,
			
			//pared derecha
			(byte)141,(byte)110,(byte)99,(byte)255,
			(byte)141,(byte)110,(byte)99,(byte)255,
			(byte)141,(byte)110,(byte)99,(byte)255,
			(byte)141,(byte)110,(byte)99,(byte)255,
			
			//pared izquierda
			(byte)141,(byte)110,(byte)99,(byte)255,
			(byte)141,(byte)110,(byte)99,(byte)255,
			(byte)141,(byte)110,(byte)99,(byte)255,
			(byte)141,(byte)110,(byte)99,(byte)255,
			
			//pared atras
			(byte)161,(byte)136,(byte)127,(byte)255,
			(byte)161,(byte)136,(byte)127,(byte)255,
			(byte)161,(byte)136,(byte)127,(byte)255,
			(byte)161,(byte)136,(byte)127,(byte)255,
			
			//techo
			(byte)38,(byte)166,(byte)154,(byte)255,
			(byte)38,(byte)166,(byte)154,(byte)255,
			(byte)38,(byte)166,(byte)154,(byte)255,
			(byte)38,(byte)166,(byte)154,(byte)255,
			
			
			//piso
			(byte)67,(byte)160,(byte)71,(byte)255,
			(byte)67,(byte)160,(byte)71,(byte)255,
			(byte)67,(byte)160,(byte)71,(byte)255,
			(byte)67,(byte)160,(byte)71,(byte)255,
			
			//casita frente
			(byte)120,(byte)144,(byte)156,(byte)255,
			(byte)120,(byte)144,(byte)156,(byte)255,
			(byte)120,(byte)144,(byte)156,(byte)255,
			(byte)120,(byte)144,(byte)156,(byte)255,
			
			//casita derecha
			(byte)96,(byte)125,(byte)139,(byte)255,
			(byte)96,(byte)125,(byte)139,(byte)255,
			(byte)96,(byte)125,(byte)139,(byte)255,
			(byte)96,(byte)125,(byte)139,(byte)255,

			//casita IZQUIERDA
			(byte)96,(byte)125,(byte)139,(byte)255,
			(byte)96,(byte)125,(byte)139,(byte)255,
			(byte)96,(byte)125,(byte)139,(byte)255,
			(byte)96,(byte)125,(byte)139,(byte)255,
			
			//casita atras
			(byte)120,(byte)144,(byte)156,(byte)255,
			(byte)120,(byte)144,(byte)156,(byte)255,
			(byte)120,(byte)144,(byte)156,(byte)255,
			(byte)120,(byte)144,(byte)156,(byte)255,
			
			//casita techo frente
			(byte)245,(byte)127,(byte)23,(byte)255,
			(byte)245,(byte)127,(byte)23,(byte)255,
			(byte)245,(byte)127,(byte)23,(byte)255,
			
			//casita techo derecha
			(byte)249,(byte)168,(byte)37,(byte)255,
			(byte)249,(byte)168,(byte)37,(byte)255,
			(byte)249,(byte)168,(byte)37,(byte)255,
			
			//casita techo izquierdda
			(byte)249,(byte)168,(byte)37,(byte)255,
			(byte)249,(byte)168,(byte)37,(byte)255,
			(byte)249,(byte)168,(byte)37,(byte)255,
			
			//casita techo atras
			(byte)245,(byte)127,(byte)23,(byte)255,
			(byte)245,(byte)127,(byte)23,(byte)255,
			(byte)245,(byte)127,(byte)23,(byte)255,
			
			//cerca frente
			(byte)0,(byte)172,(byte)193,(byte)255,
			(byte)0,(byte)172,(byte)193,(byte)255,
			(byte)0,(byte)172,(byte)193,(byte)255,
			(byte)0,(byte)172,(byte)193,(byte)255,
			
			//cerca derecha
			(byte)0,(byte)151,(byte)167,(byte)255,
			(byte)0,(byte)151,(byte)167,(byte)255,
			(byte)0,(byte)151,(byte)167,(byte)255,
			(byte)0,(byte)151,(byte)167,(byte)255,
			
			//cerca izquierda
			(byte)0,(byte)131,(byte)143,(byte)255,
			(byte)0,(byte)131,(byte)143,(byte)255,
			(byte)0,(byte)131,(byte)143,(byte)255,
			(byte)0,(byte)131,(byte)143,(byte)255,
			
			//cerca atras
			(byte)0,(byte)96,(byte)100,(byte)255,
			(byte)0,(byte)96,(byte)100,(byte)255,
			(byte)0,(byte)96,(byte)100,(byte)255,
			(byte)0,(byte)96,(byte)100,(byte)255,
	};
	/* Indices uniones de lineas */

	private FloatBuffer bufVertices;
	private ByteBuffer bufColores;
	private ShortBuffer bufIndices;

	public Cubo() {
		/* Lee los vértices */
		ByteBuffer bufByte = ByteBuffer.allocateDirect(vertices.length * 4);
		bufByte.order(ByteOrder.nativeOrder()); // Utiliza el orden de byte
												// nativo
		bufVertices = bufByte.asFloatBuffer(); // Convierte de byte a float
		bufVertices.put(vertices);
		bufVertices.rewind(); // puntero al principio del buffer
		/* Lee los colores */
		bufColores = ByteBuffer.allocateDirect(colores.length);
		bufColores.put(colores);
		bufColores.position(0); // puntero al principio del buffer
		/* Lee los indices */
		bufByte = ByteBuffer.allocateDirect(indices.length * 2);
		bufByte.order(ByteOrder.nativeOrder()); // Utiliza el orden de byte
												// nativo
		bufIndices = bufByte.asShortBuffer(); // Convierte de byte a short
		bufIndices.put(indices);
		bufIndices.rewind(); // puntero al principio del buffer
	}

	public void dibuja(GL10 gl) {
		/* Se habilita el acceso al arreglo de vértices */
		gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
		/* Se habilita el acceso al arreglo de colores */
		gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
		/*
		 * Se especifica los datos del arreglo de vértices SE UTILIZA EL 3 POR
		 * LOS 3 EJES DE COORDENADAS
		 */
		gl.glVertexPointer(3, GL10.GL_FLOAT, 0, bufVertices);
		/* Se especifica los datos del arreglo de colores */
		gl.glColorPointer(4, GL10.GL_UNSIGNED_BYTE, 0, bufColores);
		/* Se dibuja el cubo */
		gl.glDrawElements(GL10.GL_TRIANGLES, indices.length,
				GL10.GL_UNSIGNED_SHORT, bufIndices);
		/* Se deshabilita el acceso a los arreglos */
		gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
		gl.glDisableClientState(GL10.GL_COLOR_ARRAY);
	}
}