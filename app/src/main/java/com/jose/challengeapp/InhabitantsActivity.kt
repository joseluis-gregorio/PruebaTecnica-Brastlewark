package com.jose.challengeapp

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jose.challengeapp.Network.ServiceManager
import java.util.*
import kotlin.collections.ArrayList

class InhabitantsActivity : BaseActivity() {

    var adapter:InhabitantsAdapter ?= null
    var recyclerViewInhabitants:RecyclerView?=null
    var search:EditText?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inhabitants)
        initViews()
        getInformation()
    }

    private fun initViews(){
        recyclerViewInhabitants=findViewById(R.id.recyclerView_inhabitants)
        search=findViewById(R.id.search)
    }

    private fun getInformation(){
        showLoader()
        ServiceManager.getInformation { responseDTO, error ->
            dismisLoader()
            responseDTO?.brastlewark?.let { safeListInformation->
                setDataRecyclerView(ArrayList(safeListInformation))
                onClickListener(ArrayList(safeListInformation))
            }
        }
    }

    private fun setDataRecyclerView(safeListInformation: ArrayList<Brastlewark>) {

        adapter = InhabitantsAdapter(safeListInformation,this)
        recyclerViewInhabitants?.layoutManager = GridLayoutManager(this, 3)
        recyclerViewInhabitants?.adapter = adapter
        adapter?.setOnClickItem {inhabitant->
            val intent= Intent(this,DetailInhabitantActivity::class.java)
            intent.putExtra(INHABITANT,inhabitant)
            this.startActivity(intent)
        }
    }

    private fun onClickListener(safeListInformation: ArrayList<Brastlewark>) {
        search?.addTextChangedListener {newText ->
            if (newText?.isEmpty() == true){
                setDataRecyclerView(safeListInformation)
            }else{
                val queryInhabitants = ArrayList<Brastlewark>(safeListInformation.filter { it.name?.toLowerCase(Locale.ROOT)?.contains((newText.toString() ?: "").toLowerCase(Locale.ROOT)) ?:false})
                setDataRecyclerView(queryInhabitants)
            }
        }
    }
}
