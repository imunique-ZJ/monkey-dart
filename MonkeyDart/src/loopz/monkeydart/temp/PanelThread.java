package loopz.monkeydart.temp;

import android.graphics.Canvas;
import android.util.Log;
import android.view.SurfaceHolder;

public class PanelThread extends Thread {

	private SurfaceHolder _surfaceHolder;
	private CircleSurfaceView _panel;
    private boolean _run = false;
    
    public PanelThread(SurfaceHolder surfaceHolder, CircleSurfaceView panel) {
    	_surfaceHolder = surfaceHolder;
    	_panel = panel;
		Log.i(this.getClass().getName(), "In PanelThread");
    }
    
    public void setRunning(boolean run) { //Allow us to stop the thread
		Log.i(this.getClass().getName(), "In setRunning");
        _run = run;
    }
    
    @Override
    public void run() {
		Log.i(this.getClass().getName(), "In run");
		
		Canvas c = _surfaceHolder.lockCanvas();
		_panel.onDraw(c);
		_panel.postInvalidate();
		_surfaceHolder.unlockCanvasAndPost(c);
		Log.i(this.getClass().getName(), "run done.");
		
//    	Canvas c;
//        while (_run) {     //When setRunning(false) occurs, _run is 
//            c = null;      //set to false and loop ends, stopping thread
//            try {
//            	c = _surfaceHolder.lockCanvas(null);
//                synchronized (_surfaceHolder) {
//                	_panel.onDraw(c);
//                	_panel.postInvalidate();
//                	//postInvalidate();
//                }
//            } finally {
//                if (c != null) {
//                    _surfaceHolder.unlockCanvasAndPost(c);
//                }
//            }
//        }
    }
}
