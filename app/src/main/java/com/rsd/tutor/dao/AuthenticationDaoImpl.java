package com.rsd.tutor.dao;

/**
 * Created by wadereweti on 11/02/14.
 */
public class AuthenticationDaoImpl implements AuthenticationDao {
    private final String TAG = this.getClass().getSimpleName();
    private boolean authenticated = false;

    @Override
    public void authenticateLogin(final String username, final String password) {

        /*Request request = new JacksonRequest<WorksheetDTO>(Request.Method.GET,
                "http://date.jsontest.com",
                new JacksonRequestListener<WorksheetDTO>() {
                    @Override
                    public void onResponse(WorksheetDTO dto, int statusCode, VolleyError error) {
                        if (dto != null) {

                        } else {
                            error.printStackTrace();
                        }
                    }

                    @Override
                    public JavaType getReturnType() {
                        return SimpleType.construct(WorksheetDTO.class);
                    }
                });

        KaiakoApplication.getInstance().addToRequestQueue(request, TAG);*/
    }
}
