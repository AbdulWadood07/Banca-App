package com.stechlabs.banca.views

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.core.content.edit
import androidx.lifecycle.ViewModelProvider
import com.stechlabs.banca.R
import com.stechlabs.banca.models.request.Account
import com.stechlabs.banca.models.request.AccountType
import com.stechlabs.banca.models.request.Branch
import com.stechlabs.banca.models.request.CustomerID
import com.stechlabs.banca.viewmodels.SignUpViewModel
import kotlinx.android.synthetic.main.activity_account.*
import kotlinx.android.synthetic.main.activity_sign_up.*

class AccountActivity : AppCompatActivity(),AdapterView.OnItemSelectedListener {

    lateinit var signUpViewModel: SignUpViewModel
    private var typeIndex=1;
    private var customerIndex=1;
    private var branchIndex=1;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)



        val pref=getSharedPreferences("prefs", Context.MODE_PRIVATE)
        customerIndex=pref.getInt("customer_id",0)
        println("Customer_ID----> $customerIndex")
        signUpViewModel=ViewModelProvider(this).get(SignUpViewModel::class.java)

        account_type_spinner.onItemSelectedListener=this
        bank_branch_spinner.onItemSelectedListener=this
        populateSpinners()


        create_account_button.setOnClickListener {

            println("typeIndex  $typeIndex")
            println("branchIndex $branchIndex")
            println("customer $customerIndex")
            validate()
            startActivity(Intent(this,DetailsActivity::class.java))
            finish()

        }
    }

    private fun validate(){

        val account_type=AccountType(typeIndex)
        val customer=CustomerID(customerIndex)
        val branch=Branch(branchIndex)
        val rate=rate_edittext.editText?.text.toString().toDouble()
        val balance=balance_edittext.editText?.text.toString().toDouble()
        val status=status_edittext.editText?.text.toString()

        val account=Account(account_type,customer,rate,status,balance,branch)

        signUpViewModel.addAccount(account).observe(this,{
            println("Account details =====$it")
        })
    }

    private fun populateSpinners(){

        signUpViewModel.getAccountTypes().observe(this, {

            val list=it.map { it.title }
            val depart_Adapter: ArrayAdapter<String> =
                ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list)
            depart_Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            account_type_spinner.adapter=depart_Adapter
        })

        signUpViewModel.getBranches().observe(this, {

            val list=it.map { it.name }
            val branch_Adapter: ArrayAdapter<String> =
                ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list)
            branch_Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            bank_branch_spinner.adapter=branch_Adapter
        })

    }



    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

        when (p0?.id) {
            R.id.account_type_spinner -> typeIndex = p2+1
            R.id.bank_branch_spinner -> branchIndex = p2+1
        }

    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
    }
}