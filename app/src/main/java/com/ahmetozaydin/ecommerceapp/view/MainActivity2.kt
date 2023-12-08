package com.ahmetozaydin.ecommerceapp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import com.ahmetozaydin.ecommerceapp.R


class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val searchButton: Button = findViewById(R.id.searchButton)
        val userinput: EditText = findViewById(R.id.userinput)
        val checkBox1: CheckBox = findViewById(R.id.neww)
        val checkBox2: CheckBox = findViewById(R.id.used)
        val checkBox3: CheckBox = findViewById(R.id.unspecified)
        val checkBox4: CheckBox = findViewById(R.id.localPickupOnly)
        val checkBox5: CheckBox = findViewById(R.id.freeShippingOnly)
        val spinner: Spinner = findViewById(R.id.category)
        val categories = arrayOf("All Category", "Art", "Baby", "Books", "Clothings shoes", "Computers/Tables & Networking", "Health & Beauty", "Music", "Video Games & Consoles")
        val categoryValues = arrayOf("0","550", "2948", "267", "11450", "58058", "26395", "11233", "1249")

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, categories)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        fun constructFilter(): String {
            var keyword = userinput.text.toString()
            val checkBox1Checked = checkBox1.isChecked
            val checkBox2Checked = checkBox2.isChecked
            val checkBox3Checked = checkBox3.isChecked
            val checkBox4Checked = checkBox4.isChecked
            val checkBox5Checked = checkBox5.isChecked
            val spinnerSelected = spinner.selectedItem.toString()
            val selectedIndex = spinner.selectedItemPosition
            var conditionFilter = ""
            if (checkBox1Checked || checkBox1Checked || checkBox1Checked) {
                val conditionFilter1 = if (checkBox1Checked) "&itemFilter(3).value(0)=New" else ""
                val conditionFilter2 = if (checkBox2Checked) "&itemFilter(3).value(0)=New" else ""
                val conditionFilter3 = if (checkBox3Checked) "&itemFilter(3).value(0)=New" else ""
                conditionFilter =  "&itemFilter(4).name=Condition" +
                        "$conditionFilter1" +
                        "$conditionFilter2" +
                        "$conditionFilter3"
            }
            var categoryFilter = ""
            if (selectedIndex != 0) {
                categoryFilter = "&categoryId=${categoryValues[selectedIndex]}"
            }
            return "findingService/keywords=${keyword}&buyerPostalCode=90037" +
                    "$categoryFilter" +
                    "&itemFilter(0).name=FreeShippingOnly&itemFilter(0).value=${checkBox4Checked}" +
                    "&itemFilter(1).name=LocalPickupOnly&itemFilter(1).value=${checkBox5Checked}" +
                    "&itemFilter(2).name=HideDuplicateItems&itemFilter(2).value=true" +
                    "$conditionFilter" +
                    "&outputSelector(0)=SellerInfo&outputSelector(1)=StoreInfo"
        }


        val resetButton: Button = findViewById(R.id.resetButton)
        val errorText: TextView = findViewById(R.id.errorText)
        searchButton.setOnClickListener {
            if (userinput.text.toString().isEmpty()) {
                errorText.visibility = View.VISIBLE
                Toast.makeText(this, "Please fix all fields with errors", Toast.LENGTH_SHORT).show()
            }
            else {
                val filter = constructFilter()
                println(filter)

                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("userInput", filter)
                startActivity(intent)
            }

        }

        userinput.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
                errorText.visibility = View.GONE
            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
        })

        resetButton.setOnClickListener {

            // Clear the EditTexts
            userinput.text.clear()
            errorText.visibility = View.GONE
            spinner.setSelection(0)

            // Uncheck the CheckBoxes
            checkBox1.isChecked = false
            checkBox2.isChecked = false
            checkBox3.isChecked = false
            checkBox4.isChecked = false
            checkBox5.isChecked = false

        }
    }
}