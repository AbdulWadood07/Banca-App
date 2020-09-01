package com.stechlabs.banca.views

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.stechlabs.banca.R
import com.stechlabs.banca.viewmodels.SignUpViewModel
import kotlinx.android.synthetic.main.activity_employee_list.*

class EmployeeList : AppCompatActivity() {


    private lateinit var signUpViewModel: SignUpViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employee_list)


        setSupportActionBar(transaction_toolbar)

        signUpViewModel=ViewModelProvider(this).get(SignUpViewModel::class.java)
        val pref=getSharedPreferences("prefs", Context.MODE_PRIVATE)
        val employee_id=pref.getInt("employee_id",0)


        signUpViewModel.getEmployeeById(employee_id).observe(this,{
            transaction_toolbar.title="Logged in as  ${it.person.fname.plus(" "+it.person.lname)}"
            employee_name.text=it.person.fname.plus(" ${it.person.lname}")
            branch_name.text=it.branch.name
            bank_name.text=it.branch.bank_name
            department_name.text=it.department.name
            jobtitle_name.text=it.jobTitle.title
        })

        logout_employee.setOnClickListener {
            val pref=getSharedPreferences("prefs", Context.MODE_PRIVATE)
            pref.edit().putInt("employee_id",0).apply()
            startActivity(Intent(this,LoginActivity::class.java))
            finish()
        }
    }
}