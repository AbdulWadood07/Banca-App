package com.stechlabs.banca.views

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.stechlabs.banca.R
import com.stechlabs.banca.models.request.*
import com.stechlabs.banca.viewmodels.SignUpViewModel
import kotlinx.android.synthetic.main.activity_sign_up.*



class SignUpActivity : AppCompatActivity(),AdapterView.OnItemSelectedListener{

    lateinit var signUpViewModel: SignUpViewModel
    private var isEmployeeSelected=true;

    private var departmentIndex=1;
    private var branchIndex=1;
    private var titleIndex=1;
    private var typeIndex=1;
    val customer_type_list= listOf("Joint", "Indivisual")

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        signUpViewModel=ViewModelProvider(this).get(SignUpViewModel::class.java)
        radio_employee.isChecked=true
        onRadioBtnClick(radio_employee)
        department_spinner.onItemSelectedListener=this
        branch_spinner.onItemSelectedListener=this
        job_title_spinner.onItemSelectedListener=this
        customer_type_spinner.onItemSelectedListener=this

        sign_up_button.setOnClickListener {
         validate()
        }
        populateSpinners()
    }

    private fun validate(){

        val fname=firstname_edittext.editText?.text.toString()
        val lname=lastname_edittext.editText?.text.toString()
        val age=age_edittext.editText?.text.toString().toInt()
        val email=email_edittext.editText?.text.toString()
        val mobile=mobile_edittext.editText?.text.toString()
        val phone=phone_edittext.editText?.text.toString()
        val password=Password_edittext.editText?.text.toString()
        val confirm_password=confirm_Password_edittext.editText?.text.toString()
        val address=address_edittext.editText?.text.toString()
        var hourly_rate=0.0
        var salary=0.0
        if(isEmployeeSelected){
         hourly_rate=hourly_rate_edittext.editText?.text.toString().toDouble()
         salary=salary_edittext.editText?.text.toString().toDouble()
        }

        if(password == confirm_password) {

            Toast.makeText(applicationContext, "Password  match", Toast.LENGTH_LONG).show()

             val person = Person(fname, lname, age, address, email, phone, mobile)

             if (isEmployeeSelected) {
                 val branch = Branch(branchIndex)
                 val department = Department(departmentIndex)
                 val title = JobTitle(titleIndex)
                 val employee =
                     Employee(salary, hourly_rate, password, person, branch, department, title)
                 signUpViewModel.addEmployee(employee).observe(this,{
                     val pref=getSharedPreferences("prefs", Context.MODE_PRIVATE)
                     pref.edit().putInt("employee_id",it.id).apply()
                     startActivity(Intent(this,EmployeeList::class.java))
                     finish()
                 })

             } else {
                 val customer = Customer(customer_type_list[typeIndex], password, person)
                 signUpViewModel.addCustomer(customer).observe(this,{
                     println(it)

                     val pref=getSharedPreferences("prefs", Context.MODE_PRIVATE)
                     pref.edit().putInt("customer_id",it.customer_id).apply()


                     startActivity(Intent(this,AccountActivity::class.java))
                     finish()
                 })

            }
        }else
        Toast.makeText(applicationContext, "Password doesnot match", Toast.LENGTH_LONG).show()
    }
    private fun populateSpinners(){


        val dataAdapter: ArrayAdapter<String> =
            ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, customer_type_list)
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        customer_type_spinner.adapter=dataAdapter


        signUpViewModel.getDepartments().observe(this, {

            val list=it.map { it.name }
            val depart_Adapter: ArrayAdapter<String> =
                ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list)
            depart_Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            department_spinner.adapter=depart_Adapter
        })

        signUpViewModel.getBranches().observe(this, {

            val list=it.map { it.name }
            val branch_Adapter: ArrayAdapter<String> =
                ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list)
            branch_Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            branch_spinner.adapter=branch_Adapter
        })

        signUpViewModel.getJobTitles().observe(this, {

            val list=it.map { it.title }
            val title_Adapter: ArrayAdapter<String> =
                ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list)
            title_Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            job_title_spinner.adapter=title_Adapter
        })






    }
    fun onRadioBtnClick(view: View) {
        if (view is RadioButton) {
            val checked = view.isChecked

            // Check which radio button was clicked
            when (view.getId()) {
                R.id.radio_employee ->
                    if (checked) {
                        visibleAll()
                        customer_type_spinner.visibility = View.GONE
                        isEmployeeSelected=true;


                    }
                R.id.radio_customer ->
                    if (checked) {
                        visibleAll()
                        hourly_rate_edittext.visibility = View.GONE
                        salary_edittext.visibility = View.GONE
                        branch_spinner.visibility = View.GONE
                        department_spinner.visibility = View.GONE
                        job_title_spinner.visibility = View.GONE
                        isEmployeeSelected=false;

                    }
            }
        }


    }
    private fun visibleAll(){
        customer_type_spinner.visibility=View.VISIBLE
        hourly_rate_edittext.visibility=View.VISIBLE
        salary_edittext.visibility=View.VISIBLE
        branch_spinner.visibility=View.VISIBLE
        department_spinner.visibility=View.VISIBLE
        job_title_spinner.visibility=View.VISIBLE
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

        when {
            p0!!.id== R.id.department_spinner -> departmentIndex=p2+1
            p0.id==R.id.branch_spinner -> branchIndex=p2+1
            p0.id == R.id.job_title_spinner -> titleIndex=p2+1
            p0.id==R.id.customer_type_spinner -> typeIndex=p2
        }

    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
    }


}