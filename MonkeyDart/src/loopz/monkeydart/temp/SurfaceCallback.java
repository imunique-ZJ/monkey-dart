package loopz.monkeydart.temp;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;

public class SurfaceCallback implements Callback {
	private Paint paint;
	private float cx;
	private float cy;
	private float radius;

	public SurfaceCallback() {
		super();
		setupPaint();
	}

	private void setupPaint() {
		paint = new Paint();
		paint.setColor(Color.BLUE);
		paint.setStrokeWidth(5);
		paint.setStyle(Paint.Style.STROKE);
	}

	@Override
	public void surfaceCreated(SurfaceHolder surfaceHolder) {
		Log.i(this.getClass().getName(), "In surfaceCreated");		
		try {
			Canvas c = surfaceHolder.getSurface().lockCanvas(null);
			Log.i(this.getClass().getName(), "Canvas : " + c.hashCode());
			drawCircle(c);
			
			surfaceHolder.getSurface().unlockCanvasAndPost(c);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@Override
	public void surfaceChanged(SurfaceHolder surfaceHolder, int format, int width, int heigth) {
		Log.i(this.getClass().getName(), "In surfaceChanged");
		try {
			Canvas c = surfaceHolder.getSurface().lockCanvas(null);
			Log.i(this.getClass().getName(), "Canvas : " + c.hashCode());
			drawCircle(c);
			surfaceHolder.getSurface().unlockCanvasAndPost(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
		Log.i(this.getClass().getName(), "In surfaceDestroyed");

	}
	
    private void drawCircle(Canvas canvas) {
		Log.i(this.getClass().getName(), "In onDraw");
		Log.i(this.getClass().getName(), "canvas : " + String.valueOf(canvas.hashCode()));
		
        Log.i(getClass().getName(), "Width : " + canvas.getWidth());
        Log.i(getClass().getName(), "Height : " + canvas.getHeight());
        

		
		cx = canvas.getWidth()/2;
		cy = canvas.getHeight()/2;
		radius = canvas.getWidth()/4;
        
        canvas.drawCircle(cx, cy, radius, paint);
        radius += 20;
        canvas.drawCircle(cx, cy, radius, paint);
        
		Log.i(this.getClass().getName(), "onDraw done.");
    }
}
