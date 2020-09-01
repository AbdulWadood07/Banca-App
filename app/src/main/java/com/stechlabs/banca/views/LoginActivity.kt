package com.stechlabs.banca.views

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.stechlabs.banca.R
import com.stechlabs.banca.viewmodels.SignUpViewModel
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_sign_up.*

class LoginActivity : AppCompatActivity() {


    lateinit var signUpViewModel: SignUpViewModel
    private var isEmployeeSelected=false;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        login_progress.visibility= View.GONE
        signUpViewModel = ViewModelProvider(this).get(SignUpViewModel::class.java)


        login_button.setOnClickListener {
            login_progress.visibility= View.VISIBLE
            validate()
        }
    }


    private fun validate(){

        val email=email_login_edittext.editText?.text.toString()
        val password=password_login_edittext.editText?.text.toString()


        if(isEmployeeSelected){
            signUpViewModel.getEmployees().observe(this,{
                val emp_list=it.filter { it.person.email_address==email && it.password==password }
                if(emp_list.size==0){
                    Toast.makeText(applicationContext,"Credentials Error",Toast.LENGTH_LONG).show()
                }
                else{
                    val pref=getSharedPreferences("prefs", Context.MODE_PRIVATE)
                    pref.edit().putInt("employee_id",emp_list[0].id).apply()

                    startActivity(Intent(this,EmployeeList::class.java))
                }
            })

        }else{
            signUpViewModel.getCustomers().observe(this,{
                val customer_list=it.filter { it.person.email_address==email && it.password==password }
                if(customer_list.isEmpty()){
                    Toast.makeText(applicationContext,"Credentials Error",Toast.LENGTH_LONG).show()
                    login_progress.visibility=View.GONE
                }
                else{
                    val pref=getSharedPreferences("prefs", Context.MODE_PRIVATE)
                    pref.edit().putInt("customer_id",customer_list[0].customer_id).apply()
                    startActivity(Intent(this,DetailsActivity::class.java))
                    finish()
                }
            })


        }




    }

    fun onRadioButtonClick(view: View) {
        if (view is RadioButton) {
            val checked = view.isChecked

            // Check which radio button was clicked
            when (view.getId()) {
                R.id.login_radio_employee ->
                    if (checked) {
                        isEmployeeSelected=true;

                    }
                R.id.login_radio_customer ->
                    if (checked) {
                        isEmployeeSelected=false;

                    }
            }
        }


    }
}