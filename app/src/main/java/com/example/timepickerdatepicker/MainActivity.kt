package com.example.timepickerdatepicker

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.DialogInterface
import android.graphics.Color
import android.icu.util.Calendar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.timepickerdatepicker.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.timeButton.setOnClickListener {

            //güncel saat bilgisi alımı
            val calendar= Calendar.getInstance()
            val saat= calendar.get(Calendar.HOUR_OF_DAY)
            val dakika= calendar.get(Calendar.MINUTE)

            val timePicker=TimePickerDialog(this,TimePickerDialog.OnTimeSetListener { view, s, dk ->
                binding.textView.setText("$s:$dk")
                val sb=Snackbar.make(it,"Saat kaydedildi!",Snackbar.LENGTH_LONG)
                sb.setTextColor(Color.BLACK)
                sb.setBackgroundTint(Color.WHITE)
                sb.show()

            },saat,dakika,true)

            //timePicker.setTitle("Saat seciniz!")
            timePicker.setButton(DialogInterface.BUTTON_POSITIVE,"Ayarla",timePicker)
            timePicker.setButton(DialogInterface.BUTTON_NEGATIVE,"İptal",timePicker)
            timePicker.show()
        }

        binding.dateButton.setOnClickListener {
            val calendar= Calendar.getInstance()
            val yil= calendar.get(Calendar.YEAR)
            val ay= calendar.get(Calendar.MONTH)
            val gun=calendar.get(Calendar.DAY_OF_MONTH)

            val datePicker=DatePickerDialog(this,DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                binding.textViewTarih.setText("$dayOfMonth/${month+1}/$year")
                val sb=Snackbar.make(it,"Tarih kaydedildi!",Snackbar.LENGTH_LONG)
                sb.setTextColor(Color.BLACK)
                sb.setBackgroundTint(Color.WHITE)
                sb.show()

            },yil,ay,gun)
            datePicker.setButton(DialogInterface.BUTTON_POSITIVE,"Kaydet",datePicker)
            datePicker.setButton(DialogInterface.BUTTON_NEGATIVE,"İptal",datePicker)
            datePicker.show()
        }
    }
    //#FF03DAC5
}