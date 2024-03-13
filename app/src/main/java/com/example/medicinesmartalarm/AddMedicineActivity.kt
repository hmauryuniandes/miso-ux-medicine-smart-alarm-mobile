package com.example.medicinesmartalarm

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.shape.CornerFamily
import com.google.android.material.shape.MaterialShapeDrawable


class AddMedicineActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_add_medicine)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val toolbar = findViewById<MaterialToolbar>(R.id.materialToolbar)
        val materialShapeDrawable = toolbar.background as MaterialShapeDrawable
        materialShapeDrawable.shapeAppearanceModel = materialShapeDrawable.shapeAppearanceModel
            .toBuilder()
            .setBottomLeftCorner(CornerFamily.ROUNDED, 40F)
            .setBottomRightCorner(CornerFamily.ROUNDED, 40F)
            .build()

        val buttonCancel = findViewById<Button>(R.id.buttonCancel)
        buttonCancel.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this, MedicineActivity::class.java))
        })

        val buttonSave = findViewById<Button>(R.id.buttonSaveMedicine)
        buttonSave.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this, MedicineActivity::class.java))
        })

        val spinner = findViewById<Spinner>(R.id.spinner1)
        val items = arrayOf("Pastilla", "Inyección", "Jarabe", "Supositorio")
        val adapter = ArrayAdapter<String>(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            items
        )
        spinner.setAdapter(adapter)

        spinner.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(
                arg0: AdapterView<*>?,
                arg1: View?,
                arg2: Int,
                arg3: Long
            ) {
                // Do what you want
                val items = spinner.selectedItem.toString()

            }

            override fun onNothingSelected(arg0: AdapterView<*>?) {}
        }
    }
}