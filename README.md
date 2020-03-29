[![](https://jitpack.io/v/adawoud/BottomSheetTimeRangePicker.svg)](https://jitpack.io/#adawoud/BottomSheetTimeRangePicker)[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
[![Android Arsenal]( https://img.shields.io/badge/Android%20Arsenal-BottomSheetTimeRangePicker-green.svg?style=flat )]( https://android-arsenal.com/details/1/7367 )

# CustomDateTimePicker

CustomDateTimePicker is a A simple Android library for displaying a DateAndTimePicker with From and To ranges as a CustomDateTimePicker. This custom picker allow user to pick both date and time in same dialog at same time. 

## Screenshots

<img src="https://raw.githubusercontent.com/noowenz/CustomDateTimePicker/master/art/noowenz/customdatetimepickerbefore.png" width="300px" />
<img src="https://raw.githubusercontent.com/noowenz/CustomDateTimePicker/master/art/noowenz/customdatetimepickerafter.png" width="300px" />

## Installation

Add Jitpack to your project build.gralde file
      
      allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
}

Then add this dependency to your app build.gradle file.

      dependencies {
	        implementation 'https://github.com/noowenz/CustomDateTimePicker:latest-release'
	}

## Usage

Make sure your Activity/Fragment implements `ICustomDateTimeListener`, and then you 
can just do this:
      
	CustomDateTimePicker(this)
		.setDate( Calendar.getInstance())
		.showDialog()
		    
You can see this in action in the sample app [here](https://https://github.com/noowenz/CustomDateTimePicker/blob/master/sample/src/main/java/com/noowenz/customdatetimepicker/MainActivity.kt#L16)

## Customization
      
You can customize things like bellow

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
                //Get any time of date and time data here and process further...
            }

            override fun onCancel() {
               
            }
        }).apply {
            set24HourFormat(false)//24hr format is off
            setMaxMinDisplayDate(
                minDate = Calendar.getInstance().apply { add(Calendar.MINUTE, 5) }.timeInMillis,//min date is 5 min after current time
                maxDate = Calendar.getInstance().apply { add(Calendar.YEAR, 1) }.timeInMillis//max date is next 1 year 
            )
            setMaxMinDisplayedTime(5)//min time is 5 min after current time
            setDate(Calendar.getInstance())//date and time will show in dialog is current time and date. We can change this according to our need
            showDialog()
        }

## License

Copyright 2019 Nabin Shrestha

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at
         
      http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
