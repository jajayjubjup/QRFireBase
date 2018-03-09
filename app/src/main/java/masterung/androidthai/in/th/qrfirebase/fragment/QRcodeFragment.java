package masterung.androidthai.in.th.qrfirebase.fragment;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.zxing.Result;

import java.util.HashMap;
import java.util.Map;

import masterung.androidthai.in.th.qrfirebase.R;
import me.dm7.barcodescanner.zxing.ZXingScannerView;

/**
 * Created by User on 9/3/2561.
 */

public class QRcodeFragment extends Fragment{

  //  Explicit
    private ZXingScannerView zXingScannerView;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

      //  QR Controller
        QRController();

    } // Main Method

    private void QRController() {
        Button button = getView().findViewById(R.id.btnQRscan);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            zXingScannerView = new ZXingScannerView(getActivity());
            getActivity().setContentView(zXingScannerView);

            zXingScannerView.startCamera();
            zXingScannerView.setResultHandler(new ZXingScannerView.ResultHandler() {
                @Override
                public void handleResult(Result result) {
                    String resultString = result.getText().toString();
                    if (resultString.length()!=0){
                        Log.d("9MarchV1", "Result ==> " + resultString);

  //                      Add Result to Realtime Service Firebase
                        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                        DatabaseReference databaseReference = firebaseDatabase.getReference();

                        Map<String, Object> stringObjectMap = new HashMap<>();
                        stringObjectMap.put("NewsFeed", resultString);
                        databaseReference.updateChildren(stringObjectMap);

                        zXingScannerView.removeAllViews();
                        zXingScannerView.stopCameraPreview();
                        zXingScannerView.stopCamera();

                        Intent intent = getActivity().getIntent();
                        getActivity().finish();
                        startActivity(intent);

                    }

                }
            });


            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_qrcode, container, false);
        return view;
    }


} // Main Class


