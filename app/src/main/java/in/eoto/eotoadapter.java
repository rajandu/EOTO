package in.eoto;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class eotoadapter extends RecyclerView.Adapter<eotoadapter.ViewHolder>  {

    Context context;
    List<eotomodel> eoto_list;
    public eotoadapter(List<eotomodel> eoto_list) {
        this.eoto_list = eoto_list;
    }


    @NonNull
    @Override
    public eotoadapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.profile, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull eotoadapter.ViewHolder holder, int position) {

        eotomodel model = eoto_list.get(position);


            String image = model.getPicture();
            String fullname = model.getFullName();
            String age = model.getAge();
            String phone = model.getPhoneNo();
            String address = model.getAddress();

            holder.setData(image,fullname,age, address,phone);

            return;

    }

    @Override
    public int getItemCount()  {
        return eoto_list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView name_tv, age_tv, address_tv,phone_tv;
        ImageView picture_iv,buyfood_iv,buycloth_iv,buybook_iv;

        public ViewHolder(@NonNull View itemView) {

            super(itemView);

            picture_iv = itemView.findViewById(R.id.profile_pic);
            name_tv = itemView.findViewById(R.id.name_tv);
            age_tv = itemView.findViewById(R.id.age_tv);
            address_tv = itemView.findViewById(R.id.address_tv);
            phone_tv = itemView.findViewById(R.id.phone_tv);
            buybook_iv = itemView.findViewById(R.id.buybook);
            buyfood_iv = itemView.findViewById(R.id.buyfood);
            buycloth_iv = itemView.findViewById(R.id.buyclothes);
        }

        private void setData(String profilepic , String fullName, String age, String address, String phone){
            Glide.with(itemView.getContext()).load(profilepic).apply(new RequestOptions().placeholder(R.mipmap.logo)).into(picture_iv);
            name_tv.setText("Name - "+fullName);
            age_tv.setText("Age - "+age);
            address_tv.setText("Address - "+address);
            phone_tv.setText("Phone - "+phone);

            buycloth_iv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });

            buybook_iv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });

            buycloth_iv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });

        }
    }
}
