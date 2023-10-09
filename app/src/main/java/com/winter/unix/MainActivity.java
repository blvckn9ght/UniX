package com.winter.unix;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.winter.unix.Adapter.UniAdapter;
import com.winter.unix.Objects.UniData;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    private FirebaseFirestore mFire = FirebaseFirestore.getInstance();
    CollectionReference notebookRef = mFire.collection("UniservDB");
    UniAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpRecyclerView();

    }

    private void setUpRecyclerView() {
        recyclerView = findViewById(R.id.recycleruni);
        Query query = notebookRef.orderBy("Uni_Name", Query.Direction.ASCENDING);

        FirestoreRecyclerOptions<UniData> options = new FirestoreRecyclerOptions.Builder<UniData>()

                .setQuery(query, UniData.class)

                .build();


        adapter = new UniAdapter(options);


        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        adapter.startListening();



    }

    @Override
    protected void onStart() {
        super.onStart();
    adapter.startListening();


    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}