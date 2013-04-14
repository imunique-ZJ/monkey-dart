package loopz.monkeydart.temp;

import op.android.R;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.util.Log;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

public class BtnOnClickListener implements OnClickListener {
	private Paint paint = new Paint();
	
	@Override
	public void onClick(View v) {
		Log.i(this.getClass().getName(), "In onClick");
		
		EditText editText1 = (EditText)v.getRootView().findViewById(R.id.editText1);
		EditText editText2 = (EditText)v.getRootView().findViewById(R.id.editText2);
		EditText editText3 = (EditText)v.getRootView().findViewById(R.id.editText3);
		SurfaceView surfaceView = (SurfaceView)v.getRootView().findViewById(R.id.surfaceView1);
		
		int i = Integer.valueOf(editText1.getText().toString());
		int j = Integer.valueOf(editText2.getText().toString());
		int k = Integer.valueOf(editText3.getText().toString());
		
		Log.i(getClass().getName(), "CX : " + i);
		Log.i(getClass().getName(), "CY : " + j);
		Log.i(getClass().getName(), "Radius : " + k);
		

		paint.setColor(Color.RED);
		paint.setStrokeWidth(5);
		paint.setStyle(Paint.Style.STROKE);
		
		try {
			Canvas c = surfaceView.getHolder().getSurface().lockCanvas(null);
			DartBoardDrawer.drawCircle(c, paint);
			surfaceView.getHolder().getSurface().unlockCanvasAndPost(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}