package com.rsd.tutor.activity;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.rsd.tutor.R;
import com.rsd.tutor.asynctask.LoginAsyncTask;
import com.rsd.tutor.custom.DeleteEditText;
import com.rsd.tutor.custom.TextWatcherCallBack;
import com.rsd.tutor.fragment.headless.TaskFragment;
import com.rsd.tutor.util.TransitionAnimationUtil;
import com.rsd.tutor.util.TypeValueUtil;
import com.rsd.tutor.util.TypefaceUtil;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class LoginActivity extends AbstractActivity implements TextWatcherCallBack {
    private static final String TAG = "LoginActivity";

    private float mInactiveAlphaValue;
    private boolean mInvalidLogin = false;
    private boolean mInputAnimated = false;

    @InjectView(R.id.activity_login_container)
    RelativeLayout mContainer;

    @InjectView(R.id.activity_login_container_overlay)
    RelativeLayout mContainerOverlay;

    @InjectView(R.id.activity_login_container_input)
    LinearLayout mContainerInput;

    @InjectView(R.id.activity_login_tv_authentication)
    TextView mLabelAuthentication;

    @InjectView(R.id.activity_login_container_login_authentication)
    RelativeLayout mContainerLoginAuthentication;

    @InjectView(R.id.activity_login_header_title)
    TextView mTitleLogin;

    @InjectView(R.id.activity_login_et_user_name)
    DeleteEditText mInputUserName;

    @InjectView(R.id.activity_login_et_password)
    DeleteEditText mInputPassword;

    @InjectView(R.id.activity_login_bt)
    Button mButtonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initialiseInjection();
        initialiseViewProperties();
        initialiseInputs();
        initialiseKeyboardListener();
    }

    @Override
    public void onBackPressed() {
        if (mContainerLoginAuthentication.getScaleX() == 1) {
            showAutheticationView(false);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void textLengthChanged() {
        boolean enabled = (mInputUserName.length() > 0 && mInputPassword.length() > 0) ? true : false;
        float alphaLevel = enabled ? 1f : mInactiveAlphaValue;

        mButtonLogin.animate().alpha(alphaLevel);
        mButtonLogin.setEnabled(enabled);
    }

    @Override
    protected void asyncTaskComplete(boolean authenticated) {
        if (authenticated) {
            transitionToMainActivity();
        } else {
            showAuthenticationError();
        }
    }

    private void initialiseInjection() {
        ButterKnife.inject(this);
    }

    private void initialiseViewProperties() {
        mInactiveAlphaValue = TypeValueUtil.getFloatValue(R.dimen.alpha_button_disabled, this);
        mContainerLoginAuthentication.setScaleY(0);
        mTitleLogin.setTypeface(TypefaceUtil.getThin(this));
    }

    private void initialiseInputs() {
        mInputUserName.setTextWatcherCallBack(this);
        mInputPassword.setTextWatcherCallBack(this);
    }

    private void initialiseKeyboardListener() {
        Log.e(TAG, "initialising listener");

        // hide keyboard first time activity loads
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        mContainer.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                Rect rect = new Rect();
                mContainer.getWindowVisibleDisplayFrame(rect);
                int heightDelta = mContainer.getRootView().getHeight() - (rect.bottom - rect.top);
                if(debug) {
                    Log.e(TAG, "root height is " + mContainer.getRootView().getHeight());
                    Log.e(TAG, "mContainer height is " + mContainer.getHeight());
                    Log.e(TAG, "heightDelta is " + heightDelta);
                }

                int animationHeight = 0;
                if (heightDelta > 100 && !mInputAnimated) {
                    animationHeight = -175;
                } else if (mInputAnimated) {
                    if (debug) {
                        Log.e(TAG, "no animation returning");
                    }
                    return;
                }

                animateViewAboveKeyboard(animationHeight);
            }
        });
    }

    private void animateViewAboveKeyboard(int heightDelta) {
        if (debug) {
            Log.e(TAG, "animating height to " + heightDelta);
        }

        mTitleLogin.animate().translationY(heightDelta);
        mContainerInput.animate().translationY(heightDelta);
        mButtonLogin.animate().translationY(heightDelta);
    }

    @OnClick(R.id.activity_login_bt)
    public void login() {
        initialiseAsyncTask(mInputUserName.getText().toString(), mInputPassword.getText().toString());
        initialiseAuthenticationLabel();
        showAutheticationView(true);
        toggleInputAccessability();
    }

    private void initialiseAsyncTask(String userName, String password) {
        LoginAsyncTask asyncTask = new LoginAsyncTask(this, userName, password);
        TaskFragment taskFragment = new TaskFragment(asyncTask);

        initialiseTaskFragment(taskFragment);
    }

    private void initialiseAuthenticationLabel() {
        String label = mInvalidLogin ? getString(R.string.invalid_credentials) : getString(R.string.authenticating);

        mLabelAuthentication.setY(-100);
        mLabelAuthentication.setText(label);
        mLabelAuthentication.animate().translationY(0);
    }

    public void showAutheticationView(boolean display) {
        float scaleValue = display || mInvalidLogin ? 1 : 0;
        float alphaValue = display ? mInactiveAlphaValue : 1;
        int backgroundColor = display ? getResources().getColor(R.color.translucent_black) : 0;

        mContainerOverlay.setBackgroundColor(backgroundColor);
        mContainerInput.animate().alpha(alphaValue);
        mButtonLogin.animate().alpha(alphaValue);
        mTitleLogin.animate().alpha(alphaValue);
        mContainerLoginAuthentication.animate().scaleY(scaleValue);
    }

    private void toggleInputAccessability() {
        boolean enabled = mInputUserName.isEnabled() ? false : true;
        mInputUserName.setEnabled(enabled);
        mInputPassword.setEnabled(enabled);
        mButtonLogin.setEnabled(enabled);
    }

    private void transitionToMainActivity() {
        final Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        final Bundle animation = TransitionAnimationUtil.getNewNodeAnimation(this);
        startActivity(intent, animation);

        // re-enable this once styling finished of login page
        finish();
    }

    private void showAuthenticationError() {
        mInvalidLogin = true;
        initialiseAuthenticationLabel();
        showAutheticationView(false);
        toggleInputAccessability();
        mInvalidLogin = false;
    }
}

