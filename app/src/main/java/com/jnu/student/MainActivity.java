package com.jnu.student;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jnu.student.data.BookItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private TextView textView1;
    private TextView textView2;

    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView mainRecyclerview = findViewById(R.id.recycle_view_books);
        mainRecyclerview.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<BookItem> bookItems = new ArrayList<>();
        bookItems.add(new BookItem("软件项目管理案例教程（第4版）", R.drawable.book_2));
        bookItems.add(new BookItem("创新工程实践", R.drawable.book_no_name));
        bookItems.add(new BookItem("信息安全数学基础（第2版）", R.drawable.book_1));

        BookItemAdapter bookItemAdapter = new BookItemAdapter(bookItems);
        mainRecyclerview.setAdapter(bookItemAdapter);
    }

    public static class BookItemAdapter extends RecyclerView.Adapter<BookItemAdapter.ViewHolder> {

        private final ArrayList<BookItem> localDataSet;

        /**
         * Provide a reference to the type of views that you are using
         * (custom ViewHolder)
         */
        static class ViewHolder extends RecyclerView.ViewHolder {
            private final TextView textViewName;
            private final ImageView ImageViewNameItem;

            public ViewHolder(View view) {
                super(view);
                // Define click listener for the ViewHolder's View

                textViewName = view.findViewById(R.id.text_view_book_title);
                ImageViewNameItem = view.findViewById(R.id.bookView_item1);
            }

            public TextView getTextViewName() {
                return textViewName;
            }

            public ImageView getImageViewNameItem() {
                return ImageViewNameItem;
            }
        }

        /**
         * Initialize the dataset of the Adapter
         *
         * @param dataSet String[] containing the data to populate views to be used
         *                by RecyclerView
         */
        public BookItemAdapter(ArrayList<BookItem> dataSet) {
            localDataSet = dataSet;
        }

        // Create new views (invoked by the layout manager)
        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
            // Create a new view, which defines the UI of the list item
            View view = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.book_item_row, viewGroup, false);

            return new ViewHolder(view);
        }

        // Replace the contents of a view (invoked by the layout manager)
        @Override
        public void onBindViewHolder(ViewHolder viewHolder, final int position) {

            // Get element from your dataset at this position and replace the
            // contents of the view with that element
            viewHolder.getTextViewName().setText(localDataSet.get(position).getName());
            viewHolder.getImageViewNameItem().setImageResource(localDataSet.get(position).getImageId());
        }

        // Return the size of your dataset (invoked by the layout manager)
        @Override
        public int getItemCount() {
            return localDataSet.size();
        }
        //TextView textView = new TextView(this);
        // 设置TextView的文本内容
        //textView.setText(R.id.text_vciew_hellow_world);
        // 将TextView设置为Activity的内容视图
        // 通过资源名称获取字符串资源的ID

        // 通过资源ID获取字符串值

        // 找到TextView

        // 设置文本内容

        //setContentView(textView);
        /*textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        Button button = findViewById(R.id.button);

        button.setOnClickListener(v -> {
            String tempText = textView1.getText().toString();
            textView1.setText(textView2.getText());
            textView2.setText(tempText);

            showToast();
            showAlertDialog();
        });
    }
    private void showToast() {
        Toast.makeText(this, "交换成功", Toast.LENGTH_SHORT).show();
    }

    private void showAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("交换成功")
                .setPositiveButton("OK", null)
                .show();
    }*/
    }
}