package com.example.myapplication


import android.os.Bundle
import android.view.Menu
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recuclerview.Model.RowModel


class MainActivity : AppCompatActivity() {
    var recyclerView: RecyclerView? = null
    var myAadpter: Adpter? = null
    var modelList: MutableList<RowModel>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val actionBar = supportActionBar
        actionBar!!.setTitle("Recycler View")
        actionBar.setDisplayShowHomeEnabled(true)
        recyclerView = findViewById(R.id.recylerView)
        modelList = ArrayList()
        recyclerView!!.setLayoutManager(LinearLayoutManager(this))
        (modelList as ArrayList<RowModel>).add(RowModel("John Wick", "Hi there i'm doing great", R.drawable.ic_launcher_background))
        (modelList as ArrayList<RowModel>).add(RowModel("Ali john", "this is john ", R.drawable.ic_launcher_background))
        (modelList as ArrayList<RowModel>).add(RowModel("Compare things", "I;m fine ", R.drawable.ic_launcher_background))
        (modelList as ArrayList<RowModel>).add(RowModel("Pakistan", "I;m fine ", R.drawable.ic_launcher_background))
        (modelList as ArrayList<RowModel>).add(RowModel("India", "I;m fine ", R.drawable.ic_launcher_background))
        (modelList as ArrayList<RowModel>).add(RowModel("USA", "I;m fine ", R.drawable.ic_launcher_foreground))
        (modelList as ArrayList<RowModel>).add(RowModel("China", "I;m fine ", R.drawable.ic_launcher_background))
        (modelList as ArrayList<RowModel>).add(RowModel("Rusia", "I;m fine ", R.drawable.ic_launcher_background))
        (modelList as ArrayList<RowModel>).add(RowModel("Japan", "I;m fine ", R.drawable.ic_launcher_background))
        (modelList as ArrayList<RowModel>).add(RowModel("Professor", "Hi there i'm doing great", R.drawable.ic_launcher_background))
        (modelList as ArrayList<RowModel>).add(RowModel("Berlin", "Hi there i'm doing great", R.drawable.ic_launcher_background))
        (modelList as ArrayList<RowModel>).add(RowModel("Oslo", "Hi there i'm doing great", R.drawable.ic_launcher_background))
        (modelList as ArrayList<RowModel>).add(RowModel("John Wick", "Hi there i'm doing great", R.drawable.ic_launcher_background))
        (modelList as ArrayList<RowModel>).add(RowModel("John Wick", "Hi there i'm doing great", R.drawable.ic_launcher_background))
        (modelList as ArrayList<RowModel>).add(RowModel("John Wick", "Hi there i'm doing great", R.drawable.ic_launcher_background))


//        for (int i = 0 ; i < 10 ; i++ ){
//            RowModel rowModel = new RowModel("John Wick" , "Hi there i'm doing great" , R.drawable.profile);
//            modelList.add(rowModel);
//
//        }
        myAadpter = Adpter(this, modelList as ArrayList<RowModel>)
        recyclerView!!.setAdapter(myAadpter)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        val item = menu.findItem(R.id.search_bar)
        val searchView = item.actionView as SearchView
        searchView.maxWidth = Int.MAX_VALUE
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                myAadpter!!.getFilter().filter(query)
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                myAadpter!!.getFilter().filter(newText)
                return false
            }
        })
        return super.onCreateOptionsMenu(menu)
    }
}