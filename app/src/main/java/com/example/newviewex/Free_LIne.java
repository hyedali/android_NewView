package com.example.newviewex;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

public class Free_LIne extends AppCompatActivity {
    ArrayList<Vertex> arrVertex;
    Paint paint;
    private MyView mv;

    //선들을 이루는 점에 대한 정보를 저장하는 객체
    class Vertex {
        float x;
        float y;
        boolean draw;
        
        //기본생성자
        public Vertex(float x, float y, boolean draw) {
            this.x = x;
            this.y = y;
            this.draw = draw;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mv = new MyView(this);
        setContentView(mv); //나의 뷰를 화면에 출력함

        arrVertex = new ArrayList<Vertex>(); //컬렉션을 생성
    }

    public class MyView extends View {
        public MyView(Context context) {
            super(context);

            paint = new Paint(); //페이트(도구)에 대한 기본 속성 지정
            paint.setColor(Color.BLACK);
            paint.setStrokeWidth(3);
            paint.setAntiAlias(true); //계단 현상 없이 부드럽게 선을 그리기 위해 설정
        }

        public MyView(Context context, @Nullable AttributeSet attrs) {
            super(context, attrs);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            canvas.drawColor(Color.LTGRAY); //배경색

            for(int i=0; i< arrVertex.size(); i++){
                if(arrVertex.get(i).draw){
                    canvas.drawLine(arrVertex.get(i-1).x, arrVertex.get(i-1).y, arrVertex.get(i).x, arrVertex.get(i).y, paint);
                }
            }
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            if(event.getAction() == MotionEvent.ACTION_DOWN) {
                arrVertex.add(new Vertex(event.getX(), event.getY(), false));
                return true;
            }else if(event.getAction() == MotionEvent.ACTION_MOVE){
                arrVertex.add(new Vertex(event.getX(), event.getY(), true));
                invalidate();
                return true;
            }

            return false;
        }
    }
}