
package com.example.cubo_color_camara;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import javax.microedition.khronos.opengles.GL10;

public class Piramide {

	private float vertices[] = new float[] {
			// Frente
			-1.5f, -1, 1, // 4 0
			1, -1, 1, // 5 1
			1, 1, 0, // 6 2
			-1, 1, 0, // 7 3
			// Atrás
			-1, 1, 0, // 3 4
			1, 1, 0, // 2 5
			1, -1, -1, // 1 6
			-1.5f, -1, -1, // 0 7
			// Izquierda
			-1.5f, -1, -1, // 0 8
			-1.5f, -1, 1, // 4 9
			-1, 1, 0, // 7 10
			-1, 1, 0, // 3 11
			// Derecha
			1, -1, 1, // 5 12
			1, -1, -1, // 1 13
			1, 1, 0, // 2 14
			1, 1, 0, // 6 15
			// Abajo
			-1.5f, -1, -1, // 0 16
			1, -1, -1, // 1 17
			1, -1, 1, // 5 18
			-1.5f, -1, 1, // 4 19
			// Arriba
			-1, 1, 0, // 7 20
			1, 1, 0, // 6 21
			1, 1, 0, // 2 22
			-1, 1, 0 // 3 23
	};
	//byte maxColor = (byte)255;
	private byte colores[] = new byte[] {
			
			// Frente -248, 183, 71
			(byte) 248, (byte) 183, (byte) 71, 0, // 4 0
			(byte) 248, (byte) 183, (byte) 71, 0, // 5 1
			(byte) 248, (byte) 183, (byte) 71, 0, // 6 2
			(byte) 248, (byte) 183, (byte) 71, 0, // 7 3
			
			// Atrás - 248, 183, 71
			(byte) 248, (byte) 183, (byte) 71, 0, // 3 4
			(byte) 248, (byte) 183, (byte) 71, 0, // 2 5
			(byte) 248, (byte) 183, (byte) 71, 0, // 1 6
			(byte) 248, (byte) 183, (byte) 71, 0, // 0 7
			
			// Izquierda - 248, 101, 20
			(byte) 248, (byte) 101, (byte) 20, 0, // 0 8
			(byte) 248, (byte) 101, (byte) 20, 0, // 4 9
			(byte) 248, (byte) 101, (byte) 20, 0, // 7 10
			(byte) 248, (byte) 101, (byte) 20, 0, // 3 11
			
			// Derecha - 240, 132, 53
			(byte) 240, (byte) 132, (byte) 53, 0, // 5 12
			(byte) 240, (byte) 132, (byte) 53, 0, // 1 13
			(byte) 240, (byte) 132, (byte) 53, 0, // 2 14
			(byte) 240, (byte) 132, (byte) 53, 0, // 6 15
			
			// Abajo - 248, 101, 20
			(byte) 248, (byte) 101, (byte) 20, 0, // 0 16
			(byte) 248, (byte) 101, (byte) 20, 0, // 1 17
			(byte) 248, (byte) 101, (byte) 20, 0, // 5 18
			(byte) 248, (byte) 101, (byte) 20, 0, // 4 19
			
			// Arriba -  248, 101, 20
			(byte) 248, (byte) 101, (byte) 20, 0, // 7 20
			(byte) 248, (byte) 101, (byte) 20, 0, // 6 21
			(byte) 248, (byte) 101, (byte) 20, 0, // 2 22
			(byte) 248, (byte) 101, (byte) 20, 0// 3 23
		
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
		
		public Piramide() {
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