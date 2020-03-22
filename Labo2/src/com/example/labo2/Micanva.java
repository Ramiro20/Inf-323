package com.example.labo2;



import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;

import java.awt.*;

import javax.microedition.khronos.opengles.GL10;

import android.text.Layout.Alignment;
import android.view.View;

public class Micanva extends View{

	public Micanva(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onDraw(Canvas canvas) {
		GL10 gl = null;
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		//canvas.drawColor(Color.WHITE);
		//canvas.translate(30.3f, 25.3f);
		Paint texto = new Paint();
		texto.setARGB(255, 0, 0, 0);
		texto.setTextAlign(Align.LEFT);
		texto.setTextSize(90);
		canvas.drawText("Hola", canvas.getWidth()/2, 100, texto);
		gl.glTranslatef(-4.4f, -1.0f, 0);
		//canvas.translate(getX(), getY());
	}


 
}

