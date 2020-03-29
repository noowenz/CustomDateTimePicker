package com.noowenz.customdatetimepicker

import android.annotation.SuppressLint
import android.app.Dialog
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber
import java.util.*

class MainActivity : AppCompatActivity() {
    private val TAG = MainActivity::class.simpleName
    private var selectedDateAndTime = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }

    private fun initViews() {
        btn_pick_date_time.setOnClickListener {
            showDateTimePicker()
        }
    }

    /**
     * Custom date and time picker
     * We can set previous date for datetime picker
     * We can change 24 hour format
     * We can set min and max selection date
     * and also can set max and nin selection time
     */
    private fun showDateTimePicker() {
        CustomDateTimePicker(this, object : CustomDateTimePicker.ICustomDateTimeListener {
            @SuppressLint("BinaryOperationInTimber")
            override fun onSet(
                dialog: Dialog,
                calendarSelected: Calendar,
                dateSelected: Date,
                year: Int,
                monthFullName: String,
                monthShortName: String,
                monthNumber: Int,
                day: Int,
                weekDayFullName: String,
                weekDayShortName: String,
                hour24: Int,
                hour12: Int,
                min: Int,
                sec: Int,
                AM_PM: String
            ) {
                Toast.makeText(
                    this@MainActivity,
                    "Date and time selected!!!",
                    Toast.LENGTH_SHORT
                )
                    .show()
                selectedDateAndTime = calendarSelected
                val dateAndTime = "Date: $dateSelected \n " +
                        "DateInSec: ${dateSelected.time / 1000} \n " +
                        "Year: $year \n " +
                        "MonthFullName: $monthFullName \n " +
                        "MonthShortName: $monthShortName \n " +
                        "Day: $day \n " +
                        "WeekDayFullName: $weekDayFullName \n " +
                        "WeekDayShortName: $weekDayShortName \n " +
                        "Hour24: $hour24 \n " +
                        "Hour12: $hour12 \n " +
                        "Min: $min \n " +
                        "Sec: $sec \n " +
                        "AMPM: $AM_PM"
                Timber.tag(TAG).d(dateAndTime)
                tv_picked_date_time.text = dateAndTime
            }

            override fun onCancel() {
                Toast.makeText(
                    this@MainActivity,
                    "Date and time selection canceled!!!",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }).apply {
            set24HourFormat(cb_set_24_hr_format.isChecked)
            setMaxMinDisplayDate(
                minDate = Calendar.getInstance().apply { add(Calendar.MINUTE, 5) }.timeInMillis,
                maxDate = Calendar.getInstance().apply { add(Calendar.YEAR, 1) }.timeInMillis
            )
            setMaxMinDisplayedTime(5)
            setDate(if (cb_set_previous_selected_date.isChecked) selectedDateAndTime else Calendar.getInstance())
            showDialog()
        }
    }
}
