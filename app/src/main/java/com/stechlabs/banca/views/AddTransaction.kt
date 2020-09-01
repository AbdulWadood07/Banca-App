package com.stechlabs.banca.views

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.stechlabs.banca.R
import com.stechlabs.banca.models.request.AccountID
import com.stechlabs.banca.models.request.EmployeeID
import com.stechlabs.banca.models.request.Transaction
import com.stechlabs.banca.models.request.TransactionType
import com.stechlabs.banca.viewmodels.DetailsViewModel
import kotlinx.android.synthetic.main.activity_add_transaction.*
import java.text.SimpleDateFormat
import java.util.*

class AddTransaction : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    lateinit var detailsViewModel: DetailsViewModel
    private val debit_credit_list = listOf("Debit", "Credit")
    lateinit var  employee_list:List<Int>
    private var debit_credit_Index = 1
    private var type_Index = 1
    private var employeeIndex = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_transaction)

        val account_id=intent.extras?.getInt("account_id")
        detailsViewModel = ViewModelProvider(this).get(DetailsViewModel::class.java)
        debit_credit_spinner.onItemSelectedListener = this
        transaction_type_spinner.onItemSelectedListener = this
        employee_spinner.onItemSelectedListener = this

        populateSpinner()
        create_transaction_button.setOnClickListener {

            transaction_progress.visibility=View.VISIBLE
            println("VAlues  {$debit_credit_Index,$type_Index,$employeeIndex}")
            val value = if (debit_credit_Index == 1) "C" else "D"
            val format = SimpleDateFormat("yyyy-MM-dd")
            val date= format.format(Date())
            val transaction = Transaction(
                date, value, TransactionType(type_Index),
                EmployeeID(employeeIndex), AccountID(account_id!!)
            )
            detailsViewModel.addTransaction(transaction).observe(this, {
                println(it)
            })
            finish()
        }

    }

    private fun populateSpinner() {

        val debit_credit_adapter: ArrayAdapter<String> =
            ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, debit_credit_list)
        debit_credit_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        debit_credit_spinner.adapter = debit_credit_adapter


        detailsViewModel.getTransactionType().observe(this, {
            val list = it.map { it.name }
            println("LISTTTTT ----$list")
            val transaction_type_adapter: ArrayAdapter<String> =
                ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list)
            transaction_type_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            transaction_type_spinner.adapter = transaction_type_adapter
        })


        detailsViewModel.getEmployee().observe(this, {

            val list = it.map { it.person.fname.plus(" ${it.person.lname}") }
            employee_list=it.map { it.id }
            println("LISTTTTT ----$list")
            val employee_adapter: ArrayAdapter<String> =
                ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list)
            employee_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            employee_spinner.adapter = employee_adapter
        })
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

        when {
            p0!!.id == R.id.debit_credit_spinner -> debit_credit_Index = p2
            p0.id == R.id.transaction_type_spinner -> type_Index = p2 + 1
            p0.id == R.id.employee_spinner -> employeeIndex = employee_list[p2]
        }

    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
    }
}