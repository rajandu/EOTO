package in.eoto.ui.home;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import in.eoto.DBquerries;
import in.eoto.R;
import in.eoto.eotoadapter;

public class HomeFragment extends Fragment {

    public HomeFragment() {
    }
    public static eotoadapter eotoadapter;
    private Dialog loadingDialog;
    private RecyclerView eotoRecyclerView;
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.activity_my_rewards_adapter, container, false);
        eotoRecyclerView=root.findViewById(R.id.my_eoto_recyclerview);



        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        eotoRecyclerView.setLayoutManager(linearLayoutManager);

        if(DBquerries.eotomodelList.size() == 0){
            DBquerries.userdata(getContext());
        }


        eotoadapter=new eotoadapter(DBquerries.eotomodelList);
        eotoadapter.notifyDataSetChanged();
        eotoRecyclerView.setAdapter(eotoadapter);

        return root;
    }
}