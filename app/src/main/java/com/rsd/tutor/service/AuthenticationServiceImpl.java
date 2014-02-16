package com.rsd.tutor.service;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.rsd.tutor.activity.AuthenticationRequest;
import com.rsd.tutor.dao.AuthenticationDao;
import com.rsd.tutor.dao.CONFIG;
import com.rsd.tutor.module.Dao;

import org.json.JSONObject;

import java.io.StringReader;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

/**
 * Created by wadereweti on 9/02/14.
 */
@Singleton
public class AuthenticationServiceImpl implements AuthenticationService {

    @Override
    public void authenticateCredentials(AuthenticationRequest authenticationRequest, String userName, String password) {
        authenticationRequest.authenticationComplete(true);
    }
}
