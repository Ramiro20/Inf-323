
package com.example.cubo_color_camara;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import javax.microedition.khronos.opengles.GL10;

public class PiramideArbol {

	private float vertices[] = new float[] {
		// Frente
		0, 4, 0, // 0
		-1, 1, 1, // 1 
		-1, 1, 1, // 1 
		1, 1, 1, // 2
		// Derecha
		0, 4, 0, // 3
		1, 1, 1, // 4
		1, 1, 1, // 4
		1, 1, -1, // 5
		// Detrás
		0, 4, 0,  // 6
		1, 1,-1,  // 7
		1, 1,-1,  // 7
		-1, 1,-1, // 8
		// Izquierda
		 0, 4, 0,  // 9
		-1, 1, -1, // 10
		-1, 1, -1, // 10
		-1, 1, 1,  //11
		// Abajo
		-1, 1, -1, // 0 12
		1, 1, -1, // 1 13
		1, 1, 1, // 5 14
		-1, 1, 1, // 4 15
	};
	//byte maxColor = (byte)255;
	private byte colores[] = new byte[] {
			
			// Frente verde
			0, (byte) 124, (byte) 1, 0,  // 0
			0, (byte) 124, (byte) 1, 0,  // 1
			0, (byte) 124, (byte) 1, 0,  // 2
			0, (byte) 124, (byte) 1, 0,  // 2
			
			// Derecha 9, 61, 11
			(byte) 9, (byte) 61, (byte) 11, 0,  // 3
			(byte) 9, (byte) 61, (byte) 11, 0,  // 4
			(byte) 9, (byte) 61, (byte) 11, 0,  // 5
			(byte) 9, (byte) 61, (byte) 11, 0,  // 5
			
			// Detrás  
			0, (byte) 124, (byte) 1, 0,  // 6
			0, (byte) 124, (byte) 1, 0,  // 7
			0, (byte) 124, (byte) 1, 0,  // 8
			0, (byte) 124, (byte) 1, 0,  // 8
			
			// Izquierda 12, 118, 14
			(byte) 9, (byte) 61, (byte) 11, 0,  // 9
			(byte) 9, (byte) 61, (byte) 11, 0,  // 10
			(byte) 9, (byte) 61, (byte) 11, 0,  // 11
			(byte) 9, (byte) 61, (byte) 11, 0,  // 11
			
			// Abajo 
			0, (byte) 124, (byte) 1, 0, // 0 12
			0, (byte) 124, (byte) 1, 0, // 1 13
			0, (byte) 124, (byte) 1, 0, // 5 14
			0, (byte) 124, (byte) 1, 0, // 4 15
		};
		private short indices[] = new short [] {
			0, 1, 2, 0, 2, 3, // Frente
			4, 5, 6, 4, 6, 7, // Derecha
			8, 9, 10, 8, 10, 11, // Detrás
			12, 13, 14, 12, 14, 15 // Detrás
		};
		
		private FloatBuffer bufVertices;
		private ByteBuffer bufColores;
		private ShortBuffer bufIndices;
		
		public PiramideArbol() {
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
			bufByte.order(ByteOrder.nativeOrder()); // Utiliza el orden de byte nativo
			bufIndices = bufByte.asShortBuffer(); // Convierte de byte a short
			bufIndices.put(indices);
			bufIndices.rewind(); // puntero al principio del buffer
		}
		
		public void dibuja(GL10 gl) {
			/* Se activa el arreglo de vértices */
			gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
			/* Se activa el arreglo de colores */
			gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
			/* Se especifica los datos del arreglo de vértices */
			gl.glVertexPointer(3, GL10.GL_FLOAT, 0, bufVertices);
			/* Se especifica los datos del arreglo de colores */
			gl.glColorPointer(4, GL10.GL_UNSIGNED_BYTE, 0, bufColores);
			/* Se dibuja el cubo */
			gl.glDrawElements(GL10.GL_TRIANGLES, indices.length,
			GL10.GL_UNSIGNED_SHORT, bufIndices);
			/* Se desactiva el arreglo de vértices */
			gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
			/* Se desactiva el arreglo de colores */
			gl.glDisableClientState(GL10.GL_COLOR_ARRAY);
		}
}		