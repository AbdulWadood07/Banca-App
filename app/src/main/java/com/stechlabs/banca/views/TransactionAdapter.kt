package com.stechlabs.banca.views

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.stechlabs.banca.R
import com.stechlabs.banca.models.responses.Transaction
import kotlinx.android.synthetic.main.transaction_layout.view.*

class TransactionAdapter: RecyclerView.Adapter<TransactionAdapter.TransactionViewHolder>() {


    var list= listOf<Transaction>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionViewHolder {

        val inflator= LayoutInflater.from(parent.context)
        val view=inflator.inflate(R.layout.transaction_layout,parent,false)
        return TransactionViewHolder(view)

    }

    override fun onBindViewHolder(holder: TransactionViewHolder, position: Int) {

        holder.bind(list[position])
    }

    fun applyList(list:List<Transaction>){
        this.list=list
    }

    override fun getItemCount() = list.size


    class TransactionViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

        var transaction_type:TextView=itemView.transaction_type
        var transaction_date:TextView=itemView.transaction_date
        var transaction_employee:TextView=itemView.transaction_employee

        fun bind(transaction:Transaction){
           transaction_type.text=transaction.transactionType.name
            transaction_date.text=transaction.date
            transaction_employee.text=transaction.employee.person.fname.plus(" ${transaction.employee.person.lname}")

        }


    }
}