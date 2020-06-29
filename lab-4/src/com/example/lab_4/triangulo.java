package com.example.lab_4;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

import javax.microedition.khronos.opengles.GL10;

public class triangulo {
	/* Las coordenadas cartesianas (x, y, z) */
	private float vertices[] = new float[] {
			//subnivel1
			//atras
			-6,-2,7,	//0
			6,-2,7,		//1
			5,0,8,		//2
			-5,0,8,		//3
			//derecha
			6,-2,7,
			6,-2,19,
			5,0,18,
			5,0,8,	//7
			//frente
			-5,0,18,
			5,0,18,
			6,-2,19,
			-6,-2,19	//11
			//izquierda
			,-6,-2,7,
			-5,0,8,
			-5,0,18,
			-6,-2,19,	//15
			//piso
			-5,0,8,
			5,0,8,
			5,0,18,
			-5,0,18,	
			
			//subnivel2
			//atras
			-4,0,9,
			4,0,9,
			3,2,10,
			-3,2,10,
			//derecha
			3,2,10,
			4,0,9,
			4,0,17,
			3,2,16,
			//frente
			3,2,16,
			4,0,17,
			-4,0,17,
			-3,2,16,
			//izquierda
			-4,0,9,
			-3,2,10,
			-3,2,16,
			-4,0,17,
			//piso2
			-3,2,10,
			3,2,10,
			3,2,16,
			-3,2,16,
			
			//subnivel3
			//atras
			-2,2,11,
			2,2,11,
			1,4,12,
			-1,4,12,
			//derecha
			1,4,12,
			2,2,11,
			2,2,15,
			1,4,14,
			//frente
			1,4,14,
			2,2,15,
			-2,2,15,
			-1,4,14,
			//izquierda
			-2,2,11,
			-1,4,12,
			-1,4,14,
			-2,2,15,
			//piso 3
			-1,4,12,
			1,4,12,
			1,4,14,
			-1,4,14,
			
	};
	private short indices[] = new short[] {
			//subnivel1
			0,1,2,0,2,3,
			4,5,6,4,6,7,
			8,9,10,8,10,11,
			12,13,14,12,14,15,
			16,17,18,16,18,19,
			//subnivel2
			20,21,22,20,22,23,
			24,25,26,24,26,27,
			28,29,30,28,30,31,
			32,33,34,32,34,35,
			36,37,38,36,38,39,
			//subnivel3
			40,41,42,40,42,43,
			44,45,46,44,46,47,
			48,49,50,48,50,51,
			52,53,54,52,54,55,
			56,57,58,56,58,59,
			
			 };

	/* Los colores x c/vértice (r,g,b,a) */
	byte maxColor = (byte) 255;
	private byte colores[] = new byte[] {
			//subnivel1
			(byte)194,(byte)116,(byte)14,(byte)255,
			(byte)194,(byte)116,(byte)14,(byte)255,
			(byte)194,(byte)116,(byte)14,(byte)255,
			(byte)194,(byte)116,(byte)14,(byte)255,
			
			(byte)126,(byte)91,(byte)31,(byte)255,
			(byte)126,(byte)91,(byte)31,(byte)255,
			(byte)126,(byte)91,(byte)31,(byte)255,
			(byte)126,(byte)91,(byte)31,(byte)255,
			
			(byte)194,(byte)116,(byte)14,(byte)255,
			(byte)194,(byte)116,(byte)14,(byte)255,
			(byte)194,(byte)116,(byte)14,(byte)255,
			(byte)194,(byte)116,(byte)14,(byte)255,
			
			(byte)126,(byte)91,(byte)31,(byte)255,
			(byte)126,(byte)91,(byte)31,(byte)255,
			(byte)126,(byte)91,(byte)31,(byte)255,
			(byte)126,(byte)91,(byte)31,(byte)255,
			
			(byte)169,(byte)110,(byte)34,(byte)255,
			(byte)169,(byte)110,(byte)34,(byte)255,
			(byte)169,(byte)110,(byte)34,(byte)255,
			(byte)169,(byte)110,(byte)34,(byte)255,
			
			//subnivel2
			(byte)194,(byte)116,(byte)14,(byte)255,
			(byte)194,(byte)116,(byte)14,(byte)255,
			(byte)194,(byte)116,(byte)14,(byte)255,
			(byte)194,(byte)116,(byte)14,(byte)255,
			
			(byte)126,(byte)91,(byte)31,(byte)255,
			(byte)126,(byte)91,(byte)31,(byte)255,
			(byte)126,(byte)91,(byte)31,(byte)255,
			(byte)126,(byte)91,(byte)31,(byte)255,
			
			(byte)194,(byte)116,(byte)14,(byte)255,
			(byte)194,(byte)116,(byte)14,(byte)255,
			(byte)194,(byte)116,(byte)14,(byte)255,
			(byte)194,(byte)116,(byte)14,(byte)255,
			
			(byte)126,(byte)91,(byte)31,(byte)255,
			(byte)126,(byte)91,(byte)31,(byte)255,
			(byte)126,(byte)91,(byte)31,(byte)255,
			(byte)126,(byte)91,(byte)31,(byte)255,
			
			(byte)169,(byte)110,(byte)34,(byte)255,
			(byte)169,(byte)110,(byte)34,(byte)255,
			(byte)169,(byte)110,(byte)34,(byte)255,
			(byte)169,(byte)110,(byte)34,(byte)255,
			
			
			//subnivel3
			(byte)194,(byte)116,(byte)14,(byte)255,
			(byte)194,(byte)116,(byte)14,(byte)255,
			(byte)194,(byte)116,(byte)14,(byte)255,
			(byte)194,(byte)116,(byte)14,(byte)255,
			
			(byte)126,(byte)91,(byte)31,(byte)255,
			(byte)126,(byte)91,(byte)31,(byte)255,
			(byte)126,(byte)91,(byte)31,(byte)255,
			(byte)126,(byte)91,(byte)31,(byte)255,
			
			(byte)194,(byte)116,(byte)14,(byte)255,
			(byte)194,(byte)116,(byte)14,(byte)255,
			(byte)194,(byte)116,(byte)14,(byte)255,
			(byte)194,(byte)116,(byte)14,(byte)255,
			
			(byte)126,(byte)91,(byte)31,(byte)255,
			(byte)126,(byte)91,(byte)31,(byte)255,
			(byte)126,(byte)91,(byte)31,(byte)255,
			(byte)126,(byte)91,(byte)31,(byte)255,
			
			(byte)169,(byte)110,(byte)34,(byte)255,
			(byte)169,(byte)110,(byte)34,(byte)255,
			(byte)169,(byte)110,(byte)34,(byte)255,
			(byte)169,(byte)110,(byte)34,(byte)255,
	};
	/* Indices uniones de lineas */

	private FloatBuffer bufVertices;
	private ByteBuffer bufColores;
	private ShortBuffer bufIndices;

	public triangulo() {
		/* Lee los vértices */
		ByteBuffer bufByte = ByteBuffer.allocateDirect(vertices.length * 4);
		bufByte.order(ByteOrder.nativeOrder()); // Utiliza el orden de byte nativo
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
