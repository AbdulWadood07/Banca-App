package com.stechlabs.banca.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.stechlabs.banca.R
import com.stechlabs.banca.viewmodels.DetailsViewModel
import kotlinx.android.synthetic.main.activity_details.*
import kotlinx.android.synthetic.main.activity_transaction.*

class Transaction : AppCompatActivity() {


    lateinit var detailsViewModel: DetailsViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transaction)

        val account_id=intent.extras?.getInt("account_id")

        println("Account id----- $account_id")

        detailsViewModel=ViewModelProvider(this).get(DetailsViewModel::class.java)
        setSupportActionBar(toolbar)
        actionBar?.setDisplayHomeAsUpEnabled(true)
        rv_transactions.setHasFixedSize(true)
        rv_transactions.layoutManager=LinearLayoutManager(this)

       refresh(account_id)

        add_transaction.setOnClickListener {
            val intent=Intent(this,AddTransaction::class.java)
            intent.putExtra("account_id",account_id)
            startActivity(intent)
        }

        refresh_transaction.setOnClickListener {
            refresh(account_id)
        }
    }

    private fun refresh(id:Int?){
        detailsViewModel.getTransactions().observe(this,{
            val adapter=TransactionAdapter()
            val list=it.filter { it.account.id == id}
            println("listtttt $list")
            adapter.applyList(list)
            rv_transactions.adapter=adapter
            adapter.notifyDataSetChanged()
        })
    }
}