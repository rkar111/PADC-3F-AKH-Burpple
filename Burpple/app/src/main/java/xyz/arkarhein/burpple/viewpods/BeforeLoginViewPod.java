package xyz.arkarhein.burpple.viewpods;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

import butterknife.ButterKnife;
import butterknife.OnClick;
import xyz.arkarhein.burpple.R;
import xyz.arkarhein.burpple.delegates.BeforeLoginDelegate;

/**
 * Created by Arkar Hein on 1/27/2018.
 */

public class BeforeLoginViewPod extends RelativeLayout {

    private BeforeLoginDelegate mDelegate;

    public BeforeLoginViewPod(Context context) {
        super(context);
    }

    public BeforeLoginViewPod(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BeforeLoginViewPod(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this, this);
    }

    public void setDelegate(BeforeLoginDelegate delegate) {
        mDelegate = delegate;
    }

    @OnClick(R.id.btn_login)
    public void onTapLogin(View view) {
        mDelegate.onTapLogin();
    }

    @OnClick(R.id.btn_register)
    public void onTapRegister(View view){
        mDelegate.onTapRegister();
    }
}
