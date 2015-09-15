package xing.demo.android.textureview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;

public class SplashTextureView extends FrameLayout {

	private TextureView mTextureView;
	private Bitmap mBitmap = null;
	private Context mContext;

	public SplashTextureView(Context context, AttributeSet attrs) {
		super(context, attrs);
		mContext = context;
		mTextureView = new TextureView(mContext);
		setWillNotDraw(false);
		addView(mTextureView);
	}

	@Override
	public void draw(Canvas canvas) {
		super.draw(canvas);
		Paint paint = new Paint();
		paint.setColor(0x0f00ff00);
		// try {
		// canvas.drawColor(0x00897000, PorterDuff.Mode.ADD);
		// canvas.drawRect(600, 400, 850.0f, 650.0f, paint);
		// } finally {
		// mTextureView.unlockCanvasAndPost(canvas);
		// }
		//if (mBitmap != null)
			//canvas.drawBitmap(mBitmap, 0, 0, null);

	}

	public void saveBitmap() {
		mBitmap = mTextureView.getBitmap();
	}

	public void clearBitmap() {
		mBitmap = null;
	}

	public TextureView getTextureView() {
		return mTextureView;
	}

}