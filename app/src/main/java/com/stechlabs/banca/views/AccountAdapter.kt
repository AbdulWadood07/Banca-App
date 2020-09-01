package com.stechlabs.banca.views

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.stechlabs.banca.R
import com.stechlabs.banca.models.responses.Account
import kotlinx.android.synthetic.main.account_layout.view.*

class AccountAdapter: RecyclerView.Adapter<AccountAdapter.AccountViewHolder>() {


    lateinit var listerner:(Account)->Unit
    var list= listOf<Account>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AccountViewHolder {

        val inflator= LayoutInflater.from(parent.context)
        val view=inflator.inflate(R.layout.account_layout,parent,false)
        return AccountViewHolder(view)

    }

    override fun onBindViewHolder(holder: AccountViewHolder, position: Int) {

        holder.bind(list[position],listerner)
    }

    fun applyListener(listerner:(Account)->Unit){
        this.listerner=listerner
    }


    fun applyList(list:List<Account>){
        this.list=list
    }

    override fun getItemCount() = list.size


     class AccountViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

         var account_type:TextView=itemView.account_type_tv
         var rate:TextView=itemView.rate_tv
         var balance:TextView=itemView.balance_tv
         var branch:TextView=itemView.branch_tv
         var status:TextView=itemView.status_tv

         fun bind(account:Account,listener:(Account)->Unit){
             account_type.text=account.accountType.title
             rate.text=account.rate.toString()
             balance.text=account.balance.toString()
             status.text=account.status
             branch.text=account.branch.name

             itemView.setOnClickListener {
                 listener(account)
             }

         }


    }
}