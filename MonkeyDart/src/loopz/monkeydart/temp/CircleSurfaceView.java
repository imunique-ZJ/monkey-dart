package loopz.monkeydart.temp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;

public class CircleSurfaceView extends SurfaceView implements Callback {
	private SurfaceHolder surfaceHolder = null;
	private Paint paint;
	private float cx;
	private float cy;
	private float radius;

	public CircleSurfaceView(Context context) {
		super(context); 
		Log.i(this.getClass().getName(), "In CustomSurfaceView");
		surfaceHolder = getHolder();
		surfaceHolder.addCallback(this);

        paint = new Paint();
		paint.setColor(Color.BLUE);
		paint.setStrokeWidth(5);
		paint.setStyle(Paint.Style.STROKE);
	}
	
	@Override
	public void surfaceChanged(SurfaceHolder arg0, int arg1, int arg2, int arg3) {
		Log.i(this.getClass().getName(), "In surfaceChanged");

	}

	@Override
	public void surfaceCreated(SurfaceHolder arg0) {
		Log.i(this.getClass().getName(), "In surfaceCreated");
		Log.i(this.getClass().getName(), "getLayoutParams().height : " + getLayoutParams().height);
		Log.i(this.getClass().getName(), "getLayoutParams().width : " + getLayoutParams().width);
		
		
		//this.setBottom(getLayoutParams().height/2);
		
		Canvas c = surfaceHolder.lockCanvas(null);
		onDraw(c);
		surfaceHolder.unlockCanvasAndPost(c);
		
		
//		setWillNotDraw(false); //Allows us to use invalidate() to call onDraw()
//		thread = new PanelThread(getHolder(), this);
//	    thread.setRunning(true);
//	    thread.start();
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder arg0) {
		Log.i(this.getClass().getName(), "In surfaceDestroyed");
//		try {
//			thread.setRunning(false);
//			thread.join();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
    }
	
	@Override
    protected void onDraw(Canvas canvas) {
		Log.i(this.getClass().getName(), "In onDraw");
		Log.i(this.getClass().getName(), "canvas : " + String.valueOf(canvas.hashCode()));
        Log.i(getClass().getName(), "Width : " + this.getWidth());
        Log.i(getClass().getName(), "Height : " + this.getHeight());
        

		
		cx = getWidth()/2;
		cy = getHeight()/4;
		radius = getWidth()/4;
        

        Log.i(getClass().getName(), "OriCx : " + cx);
        Log.i(getClass().getName(), "OriCy : " + cy);
        Log.i(getClass().getName(), "OriRadius : " + radius);
        
        //canvas.drawColor(Color.WHITE);
        canvas.drawCircle(cx, cy, radius, paint);
        radius += 20;
        canvas.drawCircle(cx, cy, radius, paint);
        
        Log.i(getClass().getName(), "PostCx : " + cx);
        Log.i(getClass().getName(), "PostCy : " + cy);
        Log.i(getClass().getName(), "PostRadius : " + radius);
        
        canvas.save();
        
		Log.i(this.getClass().getName(), "onDraw done.");
    }
	
	public CircleSurfaceView setCx(float cx) {
		this.cx = cx;
		return this;
	}
	
	public CircleSurfaceView setCy(float cy) {
		this.cy = cy;
		return this;
	}
	
	public CircleSurfaceView setRadius(float radius) {
		this.radius = radius;
		return this;
	}
}
