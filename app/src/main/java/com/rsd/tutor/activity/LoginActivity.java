package com.rsd.tutor.activity;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.rsd.tutor.R;
import com.rsd.tutor.custom.DeleteEditText;
import com.rsd.tutor.custom.TextWatcherCallBack;
import com.rsd.tutor.module.Service;
import com.rsd.tutor.module.ServiceModule;
import com.rsd.tutor.service.LoginService;
import com.rsd.tutor.util.AnimationUtil;
import com.rsd.tutor.util.TypeValueUtil;
import com.rsd.tutor.util.TypefaceUtil;

import javax.inject.Inject;
import javax.inject.Named;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import dagger.ObjectGraph;

public class LoginActivity extends Activity implements TextWatcherCallBack {
    private static final String TAG = "LoginActivity";

    private float mDefaultAlphaValue;

    @Inject @Named(Service.LOGIN_SERVICE_STUB)
    LoginService mLoginService;

    @InjectView(R.id.label_authentication)
    TextView mLabelAuthentication;

    @InjectView(R.id.container_login_authentication)
    RelativeLayout mContainerLoginAuthentication;

    @InjectView(R.id.title_login)
    TextView mTitleLogin;

    @InjectView(R.id.input_user_name)
    DeleteEditText mInputUserName;

    @InjectView(R.id.input_password)
    DeleteEditText mInputPassword;

    @InjectView(R.id.button_login)
    Button mButtonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getActionBar().hide();
        initialiseInjection();
        initialiseViewProperties();
        initialiseInputs();
    }


    @Override
    public void onBackPressed() {
        if (mContainerLoginAuthentication.getScaleX() == 1) {
            showAutheticationView(false);
        }
    }

    @Override
    public void textLengthChanged() {
        boolean enabled = (mInputUserName.length() > 0 && mInputPassword.length() > 0) ? true : false;
        float alphaLevel = enabled ? 1f : mDefaultAlphaValue;

        mButtonLogin.animate().alpha(alphaLevel);
        mButtonLogin.setEnabled(enabled);
    }

    private void initialiseInjection() {
        ButterKnife.inject(this);
        ObjectGraph objectGraph = ObjectGraph.create(new ServiceModule());
        objectGraph.inject(this);
    }

    private void initialiseViewProperties() {
        mDefaultAlphaValue = TypeValueUtil.getFloatValue(R.dimen.alpha_button_disabled, this);
        mContainerLoginAuthentication.setScaleY(0);
        mTitleLogin.setTypeface(TypefaceUtil.getRobotoBold(this));
    }

    private void initialiseInputs() {
        mInputUserName.setTextWatcherCallBack(this);
        mInputPassword.setTextWatcherCallBack(this);
    }

    @OnClick(R.id.button_login)
    public void login() {
        showAutheticationView(true);
        authenticate();
    }

    public void showAutheticationView(boolean display) {
        float scaleValue = display ? 1 : 0;
        mContainerLoginAuthentication.animate().scaleY(scaleValue);
        mButtonLogin.setEnabled(false);
    }

    private void authenticate() {
        if (mLoginService.login(mInputUserName.getText().toString(), mInputPassword.getText().toString())) {
            transitionToMainActivity();
        } else {
            showAuthenticationError();
        }
    }

    private void transitionToMainActivity() {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        Bundle animation = AnimationUtil.getNewNodeAnimation(this);
        startActivity(intent, animation);

        resetAuthenticationView();
    }

    private void showAuthenticationError() {
        mLabelAuthentication.setY(-400);
        mLabelAuthentication.setText(getString(R.string.invalid_credentials));
        mLabelAuthentication.animate().translationY(0);
        mButtonLogin.setEnabled(true);
    }

    private void resetAuthenticationView() {
        mContainerLoginAuthentication.setScaleX(0);
        mButtonLogin.setEnabled(true);
    }
}

