package in.eoto;

import android.app.Dialog;
import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import in.eoto.ui.home.HomeFragment;

public class DBquerries {

    public static List<eotomodel> eotomodelList=new ArrayList<>();

    public static FirebaseFirestore firebaseFirestore=FirebaseFirestore.getInstance();

    public static void userdata(final Context context) {

        firebaseFirestore.collection("CHILD").orderBy("index").get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {

                        for(QueryDocumentSnapshot documentSnapshot : task.getResult()){

                            if(task.isSuccessful()){
                                eotomodelList.add(new eotomodel(
                                        documentSnapshot.get("user_image").toString()
                                        , documentSnapshot.get("user_name").toString()
                                        , documentSnapshot.get("user_age").toString()
                                        , documentSnapshot.get("user_address").toString()
                                        , documentSnapshot.get("user_phone").toString()
                                ));

                                HomeFragment.eotoadapter.notifyDataSetChanged();
                            }else{
                                String error=task.getException().getMessage();
                                Toast.makeText(context,error,Toast.LENGTH_SHORT).show();
                            }

                        }

                        QuerySnapshot documentSnapshot=task.getResult();



                    }
                });
    }
}
