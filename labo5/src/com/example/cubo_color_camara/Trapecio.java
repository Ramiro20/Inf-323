
package com.example.cubo_color_camara;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import javax.microedition.khronos.opengles.GL10;

public class Trapecio {

	private float vertices[] = new float[] {
			// Frente
			-1, -1, 1, // 4 0
			1, -1, 1, // 5 1
			0.3f, 3, 0.3f, // 6 2
			-0.3f, 3, 0.3f, // 7 3
			// Atrás
			-0.3f, 3, -0.3f, // 3 4
			0.3f, 3, -0.3f, // 2 5
			1, -1, -1, // 1 6
			-1, -1, -1, // 0 7
			// Izquierda
			-1, -1, -1, // 0 8
			-1, -1, 1, // 4 9
			-0.3f, 3, 0.3f, // 7 10
			-0.3f, 3, -0.3f, // 3 11
			// Derecha
			1, -1, 1, // 5 12
			1, -1, -1, // 1 13
			0.3f, 3, -0.3f, // 2 14
			0.3f, 3, 0.3f, // 6 15
			// Abajo
			-1, -1, -1, // 0 16
			1, -1, -1, // 1 17
			1, -1, 1, // 5 18
			-1, -1, 1, // 4 19
			// Arriba
			-0.3f, 3, 0.3f, // 7 20
			0.3f, 3, 0.3f, // 6 21
			0.3f, 3, -0.3f, // 2 22
			-0.3f, 3, -0.3f // 3 23
	};
	//byte maxColor = (byte)255;
	private byte colores[] = new byte[] {
			
			// Frente -165, 158, 148
			(byte) 165, (byte) 158, (byte) 148, 0, // 4 0
			(byte) 165, (byte) 158, (byte) 148, 0, // 5 1
			(byte) 165, (byte) 158, (byte) 148, 0, // 6 2
			(byte) 165, (byte) 158, (byte) 148, 0, // 7 3
			
			// Atrás - 165, 158, 148
			(byte) 165, (byte) 158, (byte) 148, 0, // 3 4
			(byte) 165, (byte) 158, (byte) 148, 0, // 2 5
			(byte) 165, (byte) 158, (byte) 148, 0, // 1 6
			(byte) 165, (byte) 158, (byte) 148, 0, // 0 7
			
			// Izquierda - 168, 167, 172
			(byte) 168, (byte) 166, (byte) 119, 0, // 0 8
			(byte) 168, (byte) 167, (byte) 172, 0, // 4 9
			(byte) 168, (byte) 167, (byte) 172, 0, // 7 10
			(byte) 168, (byte) 167, (byte) 172, 0, // 3 11
			
			// Derecha - 
			(byte) 189, (byte) 195, (byte) 198, 0, // 5 12
			(byte) 189, (byte) 195, (byte) 198, 0, // 1 13
			(byte) 189, (byte) 195, (byte) 198, 0, // 2 14
			(byte) 189, (byte) 195, (byte) 198, 0, // 6 15
			
			// Abajo - 107, 97, 74
			(byte) 107, (byte) 97, (byte) 74, 0, // 0 16
			(byte) 107, (byte) 97, (byte) 74, 0, // 1 17
			(byte) 107, (byte) 97, (byte) 74, 0, // 5 18
			(byte) 107, (byte) 97, (byte) 74, 0, // 4 19
			
			// Arriba - 107, 97, 74
			(byte) 107, (byte) 97, (byte) 74, 0, // 7 20
			(byte) 107, (byte) 97, (byte) 74, 0, // 6 21
			(byte) 107, (byte) 97, (byte) 74, 0, // 2 22
			(byte) 107, (byte) 97, (byte) 74, 0 // 3 23
		
		};
		private short indices[] = new short [] {
			0, 1, 2, 0, 2, 3, // Frente
			4, 5, 6, 4, 6, 7, // Atrás
			8, 9, 10, 8, 10, 11, // Izquierda
			12, 13, 14, 12, 14, 15, // Derecha
			16, 17, 18, 16, 18, 19, // Abajo
			20, 21, 22, 20, 22, 23 // Arriba
		};
		
		private FloatBuffer bufVertices;
		private ByteBuffer bufColores;
		private ShortBuffer bufIndices;
		
		public Trapecio() {
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