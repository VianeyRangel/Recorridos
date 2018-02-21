package mx.edu.utng.recorridos.activities;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import mx.edu.utng.recorridos.R;
import mx.edu.utng.recorridos.adapters.MyAdapter;
import mx.edu.utng.recorridos.models.Museum;

public class MainActivity extends AppCompatActivity {

    private List<Museum> museums;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private int counter = 0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        museums = this.getAllMuseums();

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(this);

    
        mAdapter = new MyAdapter(museums, R.layout.view_item, new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Museum museums, int position) {
                //Toast.makeText(MainActivity.this, name + " - " + position, Toast.LENGTH_LONG).show();
                removeMuseum(position);
            }
        });

        mRecyclerView.setHasFixedSize(true);

        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu. menu,menu);
     return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_name:
                this.addMuseum(0);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private List<Museum> getAllMuseums() {
        return new ArrayList<Museum>() {{
            add(new Museum("Visita a portales Hidalgo, Duraciòn 20 min", R.drawable.rec1));
            add(new Museum("Visita al cuarto de armas, Duración 30 min", R.drawable.rec2));
            add(new Museum("Visita a murales antiguos, Duración 10 min", R.drawable.rec3));
            add(new Museum("Visita a estatuas de cera, Duración 15 min", R.drawable.rec4));
        }};
    }

    private void addMuseum(int position) {
        museums.add(position, new Museum("New image " + (++counter), R.drawable.newmuseum));
       
        mAdapter.notifyItemInserted(position);
        mLayoutManager.scrollToPosition(position);
    }

    private void removeMuseum(int position) {
        museums.remove(position);
      
        mAdapter.notifyItemRemoved(position);
    }
}
