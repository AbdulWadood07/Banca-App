package com.stechlabs.banca.views

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.stechlabs.banca.R
import com.stechlabs.banca.apiService.RetrofitBuilder
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pref=getSharedPreferences("prefs", Context.MODE_PRIVATE)
        val customer_exist=pref.getInt("customer_id",0)
        val employee_exit=pref.getInt("employee_id",0)

        if(customer_exist!=0){
            startActivity(Intent(this,DetailsActivity::class.java))
            finish()
        }else  if (employee_exit!=0){
            startActivity(Intent(this,EmployeeList::class.java))
            finish()

        }


        button_1.setOnClickListener {
            startActivity(Intent(this,SignUpActivity::class.java))
            finish()
        }

        button_2.setOnClickListener {
            startActivity(Intent(this,LoginActivity::class.java))
            finish()
        }
    }
}