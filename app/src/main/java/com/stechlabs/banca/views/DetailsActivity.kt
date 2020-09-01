package com.stechlabs.banca.views

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.stechlabs.banca.R
import com.stechlabs.banca.viewmodels.DetailsViewModel
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {

    lateinit var detailsViewModel: DetailsViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        setSupportActionBar(toolbar)


        val pref=getSharedPreferences("prefs", Context.MODE_PRIVATE)
        val customer_id=pref.getInt("customer_id",0)

        detailsViewModel=ViewModelProvider(this).get(DetailsViewModel::class.java)
        accounts_recyclerview.setHasFixedSize(true)
        accounts_recyclerview.layoutManager=LinearLayoutManager(this)
        val rv_adapter=AccountAdapter()


        detailsViewModel.getAccounts().observe(this,{

            val list=it.filter { it.customer.customer_id== customer_id}
            println("Accounts --------- $list")
            rv_adapter.applyList(list)
            accounts_recyclerview.adapter=rv_adapter
            rv_adapter.notifyDataSetChanged()
            toolbar.setTitle("Accounts (${list[0].customer.person.fname})")
        })

        logout.setOnClickListener {
            val pref=getSharedPreferences("prefs", Context.MODE_PRIVATE)
            pref.edit().putInt("customer_id",0).apply()
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }

        add_accounts.setOnClickListener {
            startActivity(Intent(this,AccountActivity::class.java))
            finish()
        }

        refresh.setOnClickListener {
            detailsViewModel.getAccounts().observe(this,{
                val list=it.filter { it.customer.customer_id== customer_id}
                println("Accounts --------- $list")
                rv_adapter.applyList(list)
                accounts_recyclerview.adapter=rv_adapter
                rv_adapter.notifyDataSetChanged()
            })
        }

        rv_adapter.applyListener {
            val intent=Intent(this,Transaction::class.java)
            intent.putExtra("account_id",it.id)
            startActivity(intent)
        }


    }
}