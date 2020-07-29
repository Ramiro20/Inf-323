package com.example.labo2;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import javax.microedition.khronos.opengles.GL10;
public class Polilinea {
	FloatBuffer bufVertices;
	int numPuntos;
public void setVertices(int numPuntos, float puntos[][]){
	this.numPuntos = numPuntos;
	/* Lee los vértices */
	ByteBuffer bufByte = ByteBuffer.allocateDirect(numPuntos * 2 * 4);
	bufByte.order(ByteOrder.nativeOrder()); // Utiliza el orden de byte nativo
	bufVertices = bufByte.asFloatBuffer(); // Convierte de byte a float
	for (int i = 0; i < numPuntos; i++) {
		bufVertices.put(puntos[i][0]);
		bufVertices.put(puntos[i][1]);
	}
	bufVertices.rewind(); // puntero al principio del buffer
}

public void dibuja(GL10 gl) {
	/* Se habilita el acceso al arreglo de vértices */
	gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
	/* Se especifica los datos del arreglo de vértices */
	gl.glVertexPointer(2, GL10.GL_FLOAT, 0, bufVertices);
	/* Se establece el color en (r,g,b,a) */
	gl.glColor4f(0, 0, 0, 0);
	/* Dibuja las lineas */
	if (numPuntos > 1)
	gl.glDrawArrays(GL10.GL_LINE_LOOP, 0, numPuntos);
	/* Se establece el color en (r,g,b,a) */
	gl.glColor4f(0, 0, 0, 0);
	/* Dibuja los puntos */
	gl.glDrawArrays(GL10.GL_POINTS, 0, numPuntos);
	/* Se deshabilita el acceso al arreglo de vértices */
	gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
	}

}