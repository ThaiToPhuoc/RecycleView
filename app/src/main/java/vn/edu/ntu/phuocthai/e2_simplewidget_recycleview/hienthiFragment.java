package vn.edu.ntu.phuocthai.e2_simplewidget_recycleview;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import vn.edu.ntu.phuocthai.e2_simplewidget_recycleview.controller.Icontroller;
import vn.edu.ntu.phuocthai.e2_simplewidget_recycleview.model.info;

public class hienthiFragment extends Fragment {

    Toolbar toolbar; //Nhớ chọn ...appcompat.widget
    RecyclerView recyclerView;

    NavController navController;
    Icontroller controller;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hienthi, container, false);
        setHasOptionsMenu(true);// Nhớ thêm phần này để toolbar ẩn có thể nhận menu
        addview(view);
        addevent();
        return view;
    }

    //Cách thêm menu cho toolbar bị ẩn
    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.my_menu,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    //Cách thêm sự kiện cho menu toolbar ẩn

//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        int id = item.getItemId();
//        switch (id)
//        {
//            case R.id.mnuexit: FirstFragment.this.getActivity().finish();
//            case R.id.mnumuahang: showShoppingCart();
//        }
//        return super.onOptionsItemSelected(item);
//    }
//

    private void addview(View view) {
        toolbar = view.findViewById(R.id.tbds);
        recyclerView = view.findViewById(R.id.rcvlist);

        navController = NavHostFragment.findNavController(hienthiFragment.this);
        controller = ((MainActivity)getActivity()).controller;

        recyclerView.setLayoutManager(new LinearLayoutManager(hienthiFragment.this.getActivity()));
        InfoAdapter adapter = new InfoAdapter(controller.GetAllInfo());
        recyclerView.setAdapter(adapter);
    }

    private void addevent() {
        ((MainActivity)getActivity()).setSupportActionBar(toolbar);
        ((MainActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Cho phép xuất hiện nút back
        toolbar.setNavigationIcon(R.drawable.ic_action_back); //Chỉnh sửa nút back trên thanh toolbar

        //thêm sự kiện cho nút back
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_hienthiFragment_to_themFragment);
            }
        });
    }

    private class InfoViewHolder extends RecyclerView.ViewHolder
    {

        //khai bao cac bien trong 1 thanh phan viewholder(phan tu lap di lap lai) cua adapter

        TextView txthienthi;
        public InfoViewHolder(@NonNull View itemView) {
            super(itemView);
            txthienthi = itemView.findViewById(R.id.txthienthi);
            //anh xa cac bien vao itemView (View duoc tao rieng cho viewholder)-

        }

        public void bind(info p)
        {
            txthienthi.setText(p.getNgay() + "\n" + p.getMenhgia() + "\n"
            +p.getPhuongthuc() + "\n" + " Mua vào: " + p.getMuavao() + "  Bán ra: " + p.getBanra());
            //truyen du lieu vao cac thanh phan trong viewholder tu list trong adater--
        }
    }

    private class InfoAdapter extends RecyclerView.Adapter<InfoViewHolder>
    {
        List<info> listInfo;

        public InfoAdapter(List<info> listInfos) {
            this.listInfo = listInfos;
        }


        @NonNull
        @Override
        public InfoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = getLayoutInflater();
            View view = inflater.inflate(R.layout.info, parent, false);
            return new InfoViewHolder(view);

        }

        @Override
        public void onBindViewHolder(@NonNull InfoViewHolder holder, int position) {
            holder.bind(listInfo.get(position));
        }

        @Override
        public int getItemCount() {
            return listInfo.size();
        }
    }

}