package com.example.hotel21.controller.ui.user_details;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.hotel21.R;
import com.example.hotel21.controller.UpdatePayment;
import com.example.hotel21.controller.UpdateSecurityDetails;
import com.example.hotel21.controller.UserDetailsUpdate;


public class UserDetailsUpdateFragment extends Fragment {

    CardView userDetails, security, payment;
    Context context;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_update_user, container, false);
        context = container.getContext();
        userDetails = view.findViewById(R.id.user_details);
        security = view.findViewById(R.id.security);
        payment = view.findViewById(R.id.payment);
        userDetails.setOnClickListener(listener);
        security.setOnClickListener(listener);
        payment.setOnClickListener(listener);
        return view;
    }

    private View.OnClickListener listener = v -> {
        Intent intent;
        switch (v.getId()) {
            case R.id.user_details:
                intent = new Intent(context, UserDetailsUpdate.class);
                startActivity(intent);
                break;
            case R.id.security:
                intent = new Intent(context, UpdateSecurityDetails.class);
                startActivity(intent);
                break;
            case R.id.payment:
                intent = new Intent(context, UpdatePayment.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    };


}