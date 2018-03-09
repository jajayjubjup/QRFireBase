package masterung.androidthai.in.th.qrfirebase.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

import masterung.androidthai.in.th.qrfirebase.R;

/**
 * Created by User on 9/3/2561.
 */

public class ReadAllcodeFragment extends Fragment {

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        final ListView listView = getView().findViewById(R.id.list_item);
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = firebaseDatabase.getReference();

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {


                Map<String, Object> stringObjectMap = (Map<String, Object>) dataSnapshot.getValue();
                String resultString = String.valueOf(stringObjectMap.get("Product"));
                showlog(resultString);

//                Remove {}
                int i = resultString.length();
                resultString = resultString.substring(1, (i-1));
                showlog(resultString);

                String[] dateTimeStrings = resultString.split("Px");
                for (int il=0; il<dateTimeStrings.length; il +=1){
                    Log.d("9MarchV1", "dateTime[" + il +"] ==>" +dateTimeStrings[il]);
                }

                ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                        android.R.layout.simple_list_item_1, dateTimeStrings);
                listView.setAdapter(stringArrayAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void showlog(String resultString) {
        Log.d("9MarchV1", "JSON ==> " + resultString);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_read_all, container, false);
        return view;
    }
}
