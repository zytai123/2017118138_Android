package com.example.recycleview2;


import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.PopupMenu;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public  class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder> {
    private List<Fruit> mFruitList;
    private AdapterView.OnItemClickListener mOnItemClickListener = null;
    private AdapterView.OnItemLongClickListener mOnItemLongClickListener = null;

    static  class ViewHolder extends RecyclerView.ViewHolder{
        View fruitView;
        ImageView fruitImage;
        TextView fruitName;
        public ViewHolder(View view){
            super(view);
            fruitView=view;
            fruitImage = (ImageView) view.findViewById(R.id.fruit_image);
            fruitName = (TextView) view.findViewById(R.id.fruit_name);
        }
    }
    public FruitAdapter(List<Fruit> fruitList){
        mFruitList = fruitList;
    } //FruitAdapter构造方法

    @Override
    public  ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){    //在这里实现点击事件，设置监听器
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fruit_item,parent,false);
        final ViewHolder holder = new ViewHolder(view);
        holder.fruitView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position=holder.getAdapterPosition();
                Fruit fruit = mFruitList.get(position);
                Toast.makeText(v.getContext(),"you clicked name is "+fruit.getName(),Toast.LENGTH_LONG).show();
            }
        });
        holder.fruitImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position=holder.getAdapterPosition();
                Fruit fruit = mFruitList.get(position);
                Toast.makeText(v.getContext(),"you clicked image is "+fruit.getName(),Toast.LENGTH_LONG).show();
            }
        });

        holder.fruitView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(final View v) {
                PopupMenu popupMenu = new PopupMenu(v.getContext(),v);
                popupMenu.getMenuInflater().inflate(R.menu.main,popupMenu.getMenu());

                //弹出式菜单的菜单项点击事件
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    int position=holder.getAdapterPosition();
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.add:
                                Fruit orange=new Fruit("orange",R.drawable.orange);
                                mFruitList.add(position,orange);
                                notifyItemInserted(position);
                                if(position != getItemCount()) {
                                    notifyItemRangeChanged(position, getItemCount());
                                    Toast.makeText(v.getContext(), "add orange successfully.", Toast.LENGTH_SHORT).show();
                                }
                                break;
                            case R.id.del:
                                mFruitList.remove(position);
                                notifyItemRemoved(position);
                                if(position != getItemCount()) {
                                    notifyItemRangeChanged(position, getItemCount());
                                    Toast.makeText(v.getContext(), "del successfully.", Toast.LENGTH_SHORT).show();
                                }
                            case R.id.change:
                                Fruit grape=new Fruit("grape",R.drawable.grape);
                                mFruitList.set(position,grape);
                                notifyItemChanged(position);
                                if(position != getItemCount()) {
                                    notifyItemRangeChanged(position, getItemCount());
                                    Toast.makeText(v.getContext(), "change the grape successfully.", Toast.LENGTH_SHORT).show();
                                }
                        }
                        return false;
                    }
                });

                //弹出式菜单的菜单的关闭事件
                popupMenu.setOnDismissListener(new PopupMenu.OnDismissListener() {
                    @Override
                    public void onDismiss(PopupMenu menu) {

                    }
                });
                popupMenu.show();

                return false;
            }
        });

        holder.fruitImage.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(final View v) {
                PopupMenu popupMenu = new PopupMenu(v.getContext(),v);
                popupMenu.getMenuInflater().inflate(R.menu.main,popupMenu.getMenu());

                //弹出式菜单的菜单项点击事件
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    int position=holder.getAdapterPosition();
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.add:
                                Fruit orange=new Fruit("orange",R.drawable.orange);
                                mFruitList.add(position,orange);
                                notifyItemInserted(position);
                                if(position != getItemCount()) {
                                    notifyItemRangeChanged(position, getItemCount());
                                    Toast.makeText(v.getContext(), "add orange successfully.", Toast.LENGTH_SHORT).show();
                                }
                                break;
                            case R.id.del:
                                mFruitList.remove(position);
                                notifyItemRemoved(position);
                                if(position != getItemCount()) {
                                    notifyItemRangeChanged(position, getItemCount());
                                    Toast.makeText(v.getContext(), "del successfully.", Toast.LENGTH_SHORT).show();
                                }
                            case R.id.change:
                                Fruit grape=new Fruit("grape",R.drawable.grape);
                                mFruitList.set(position,grape);
                                notifyItemChanged(position);
                                if(position != getItemCount()) {
                                    notifyItemRangeChanged(position, getItemCount());
                                    Toast.makeText(v.getContext(), "change the grape successfully.", Toast.LENGTH_SHORT).show();
                                }
                        }
                        return false;
                    }
                });

                //弹出式菜单的菜单的关闭事件
                popupMenu.setOnDismissListener(new PopupMenu.OnDismissListener() {
                    @Override
                    public void onDismiss(PopupMenu menu) {

                    }
                });
                popupMenu.show();

                return false;
            }


        });

        return holder;
    }

    @Override
    public  void onBindViewHolder(ViewHolder holder, int position){
        Fruit fruit = mFruitList.get(position);
        holder.fruitImage.setImageResource(fruit.getImageId());
        holder.fruitName.setText(fruit.getName());
    }

    @Override
    public int getItemCount(){
        return mFruitList.size();
    }



}
