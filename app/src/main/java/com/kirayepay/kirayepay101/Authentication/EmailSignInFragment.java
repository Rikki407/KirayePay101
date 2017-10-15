package com.kirayepay.kirayepay101.Authentication;

import android.app.Fragment;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.kirayepay.kirayepay101.MainActivity;
import com.kirayepay.kirayepay101.RikkiClasses.Acquire;
import com.kirayepay.kirayepay101.Network.ApiClient;
import com.kirayepay.kirayepay101.Network.ApiInterface;
import com.kirayepay.kirayepay101.Network.Responses.EmailLoginResponse;
import com.kirayepay.kirayepay101.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.MODE_PRIVATE;


/**
 * Created by rikki on 8/23/17.
 */

public class EmailSignInFragment extends Fragment implements View.OnClickListener
{
    EditText user_email,user_password;
    Button signInButton;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.auth_email_signin,container,false);
        user_email = (EditText) v.findViewById(R.id.user_email);
        user_password = (EditText) v.findViewById(R.id.user_password);
        signInButton = (Button) v.findViewById(R.id.sign_in_button);
        signInButton.setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.sign_in_button :
                emailLogin("9958692304","1234567890");
                break;
        }
    }

    private void emailLogin(final String user_email, String user_password)
    {
        ApiInterface apiInterface = ApiClient.getApiInterface();
        Call<ArrayList<EmailLoginResponse>> emailLoginCall = apiInterface.userEmailLogin(user_email,user_password);
        emailLoginCall.enqueue(new Callback<ArrayList<EmailLoginResponse>>() {
            @Override
            public void onResponse(Call<ArrayList<EmailLoginResponse>> call, Response<ArrayList<EmailLoginResponse>> response) {
                Log.e("EmailResponse","Logged In");
                EmailLoginResponse loginResponse = response.body().get(0);
                Intent intent = new Intent(getActivity(), MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                storeInfoInSharedPreference(loginResponse.getEmail(),loginResponse.getUserid(),loginResponse.getName(),Acquire.EMAIL_AUTH);
                startActivity(intent);
            }
            @Override
            public void onFailure(Call<ArrayList<EmailLoginResponse>> call, Throwable t) {
                Log.e("EmailResponse","Error "+t.getCause());
            }
        });
    }

    private void  storeInfoInSharedPreference(String user_email,String user_id, String user_name, int Auth_Method) {
        SharedPreferences.Editor editor = getActivity().getSharedPreferences(Acquire.USER_DETAILS,MODE_PRIVATE).edit();
        editor.putString(Acquire.USER_EMAIL,user_email);
        editor.putString(Acquire.USER_ID,user_id);
        editor.putString(Acquire.USER_NAME,user_name);
        editor.putInt(Acquire.USER_AUTH_METHOD,Auth_Method);
        editor.apply();

    }
}