package com.example.newviewex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Move_round extends AppCompatActivity {
    ArrayList<dat> arrayList;
    Paint paint;
    private MyMoveView mv;

    class dat {
        float x;
        float y;
        boolean draw;

        public dat(float x, float y, boolean draw) {
            this.x = x;
            this.y = y;
            this.draw = draw;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mv = new MyMoveView(this);
        setContentView(mv);

        arrayList = new ArrayList<dat>()
    }

    class MyMoveView extends View {
        public MyMoveView(Context context) {
            super(context);

            paint = new Paint();
            paint.setStrokeWidth(3);
            paint.setStyle(Paint.Style.STROKE);
            paint.setColor(Color.BLUE);
            paint.setAntiAlias(true);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            canvas.drawPaint(paint);
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            if(event.getAction() == MotionEvent.ACTION_DOWN){
                arrayList.add(new dat(event.getX(), event.getY(),false));
                return true;
            }else if(event.getAction() == MotionEvent.ACTION_MOVE){

            }
            return false;
        }
    }
}