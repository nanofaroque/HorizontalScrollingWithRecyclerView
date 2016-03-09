package com.nanofaroque.horizontalscrolling;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MyItemClickCallback {
    @Bind(R.id.my_recycler_view)
    RecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private com.nanofaroque.horizontalscrolling.MyAdapter mAdapter;
    private ArrayList myDataset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        myDataset=buildMockData();
        mRecyclerView.setHasFixedSize(true);
        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecyclerView.setLayoutManager(mLayoutManager);
        // specify an adapter (see also next example)
        mAdapter = new MyAdapter(myDataset, this);
        mRecyclerView.setAdapter(mAdapter);
    }

    private ArrayList buildMockData() {
        ArrayList myDataset = new ArrayList();
        myDataset.add(new Integer(R.mipmap.relativity1));
        myDataset.add(new Integer(R.mipmap.relativity2));
        myDataset.add(new Integer(R.mipmap.relativity3));
        myDataset.add(new Integer(R.mipmap.bigbang));
        myDataset.add(new Integer(R.mipmap.ic_launcher));
        myDataset.add(new Integer(R.mipmap.relativity1));
        myDataset.add(new Integer(R.mipmap.relativity2));
        myDataset.add(new Integer(R.mipmap.relativity3));
        myDataset.add(new Integer(R.mipmap.bigbang));
        myDataset.add(new Integer(R.mipmap.ic_launcher));
        return myDataset;
    }

    @Override
    public void addImage() {
        Toast.makeText(MainActivity.this, "Add Image Please", Toast.LENGTH_LONG).show();
    }

    @Override
    public void showImage() {
        Toast.makeText(MainActivity.this, "Do Something else", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }
}
