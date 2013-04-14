package loopz.monkeydart.temp;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;

public class DartBoardDrawer {	
	public static void drawCircle(Canvas canvas, Paint paint) {
		float cx = canvas.getWidth()/2;
		float cy = canvas.getHeight()/2;
		float radius = ((float)canvas.getWidth())*0.5f;
        
        canvas.drawCircle(cx, cy, radius, paint);
        Log.i("CircleDrawer", "cx : " + cx);
        Log.i("CircleDrawer", "cy : " + cy);
        Log.i("CircleDrawer", "radius : " + radius);
        Log.i("CircleDrawer", "Draw1 done.");
        
        radius = ((float)canvas.getWidth())*0.25f;
        canvas.drawCircle(cx, cy, radius, paint);
        Log.i("CircleDrawer", "cx : " + cx);
        Log.i("CircleDrawer", "cy : " + cy);
        Log.i("CircleDrawer", "radius : " + radius);
        Log.i("CircleDrawer", "Draw2 done.");
	}
}
