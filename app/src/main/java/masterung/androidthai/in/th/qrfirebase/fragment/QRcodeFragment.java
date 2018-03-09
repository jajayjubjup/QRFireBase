package masterung.androidthai.in.th.qrfirebase.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import masterung.androidthai.in.th.qrfirebase.R;
import me.dm7.barcodescanner.zxing.ZXingScannerView;

/**
 * Created by User on 9/3/2561.
 */

public class QRcodeFragment extends Fragment implements ZXingScannerView.ResultHandler{

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


      //          QR scan

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


