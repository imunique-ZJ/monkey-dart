package loopz.monkeydart.temp;

import op.android.R;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.Button;

public class MainActivity extends Activity {	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.i(this.getClass().getName(), "In onCreate");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setupComponent();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		Log.i(this.getClass().getName(), "In onCreateOptionsMenu");
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	private void setupComponent() {
		setupSurfaceView();
		setupButton();
	}
	
	private void setupSurfaceView() {		
		SurfaceView surfaceView = (SurfaceView)findViewById(R.id.surfaceView1);		
		SurfaceHolder surfaceHolder = surfaceView.getHolder();		
		//surfaceHolder.addCallback(new SurfaceCallback());
	}
	
	private void setupButton() {
		Button b = (Button)findViewById(R.id.button1);
		b.setOnClickListener(new BtnOnClickListener());		
	}
}
