package com.codemobile.rcvcollab.oldexpandtext

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.codemobile.rcvcollab.R
import com.codemobile.rcvcollab.oldexpandtext.database.ApiInterface
import com.codemobile.rcvcollab.oldexpandtext.datatype.BaseDataType
import com.codemobile.rcvcollab.oldexpandtext.datatype.CrazyType
import com.codemobile.rcvcollab.oldexpandtext.datatype.StarWarResponse
import kotlinx.android.synthetic.main.activity_rcvcollab.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RCVCollabActivity : AppCompatActivity() {
    private var peopleAdapter: PeopleRecycleViewAdapter? = null
    private var testDataArray: ArrayList<BaseDataType> = arrayListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rcvcollab)

        addFakeData()
        peopleAdapter =
            PeopleRecycleViewAdapter(this, testDataArray)
        rcv_collab.let {
            it.adapter = peopleAdapter
            it.layoutManager = LinearLayoutManager(this)
        }
    }

    private fun addFakeData() {
        addCrazyData("Opening")
        addCrazyData(
            "1Line\n" +
                    "2Line\n" +
                    "3Line\n" +
                    "4Line\n" +
                    "5Line\n" +
                    "6Line"
        )
        //        feedPeople("1")
        addCrazyData(
            "The Espresso Test Recorder tool lets you create UI tests for your app without writing any test code. By recording a test scenario, " +
                    "you can record your interactions with a device and add assertions to verify UI elements in particular snapshots of your app. " +
                    "Espresso Test Recorder then takes the saved recording and automatically generates a corresponding UI test that you can run to test your app.\n" +
                    "Espresso Test Recorder writes tests based on the Espresso Testing framework, an API in AndroidX Test. " +
                    "The Espresso API encourages you to create concise and reliable UI tests based on user actions. " +
                    "By stating expectations, interactions, and assertions without directly accessing the underlying app’s activities and views, this structure prevents test flakiness and optimizes test run speed."
        )
        addCrazyData(
            "Activities are one of the fundamental building blocks of apps on the Android platform. " +
                    "They serve as the entry point for a user's interaction with an app, " +
                    "and are also central to how a user navigates within an app (as with the Back button) or " +
                    "between apps (as with the Recents button).\n" +
                    "Skillfully managing activities allows you to ensure that, for example:"
        )
        addCrazyData(
            "When your UI changes in response to user action, you should animate the layout transitions. These animations give users feedback on their actions and help keep them oriented to the UI.\n" +
                    "\n" +
                    "Android includes the transitions framework, which enables you to easily animate changes between two view hierarchies. The framework animates the views at runtime by changing some of their property values over time. The framework includes built-in animations for common effects and lets you create custom animations and transition lifecycle callbacks."
        )
        addCrazyData(
            "The Espresso Test Recorder tool lets you create UI tests for your app without writing any test code. By recording a test scenario, " +
                    "you can record your interactions with a device and add assertions to verify UI elements in particular snapshots of your app. " +
                    "Espresso Test Recorder then takes the saved recording and automatically generates a corresponding UI test that you can run to test your app.\n" +
                    "Espresso Test Recorder writes tests based on the Espresso Testing framework, an API in AndroidX Test. " +
                    "The Espresso API encourages you to create concise and reliable UI tests based on user actions. " +
                    "By stating expectations, interactions, and assertions without directly accessing the underlying app’s activities and views, this structure prevents test flakiness and optimizes test run speed."
        )
        addCrazyData(
            "Activities are one of the fundamental building blocks of apps on the Android platform. " +
                    "They serve as the entry point for a user's interaction with an app, " +
                    "and are also central to how a user navigates within an app (as with the Back button) or " +
                    "between apps (as with the Recents button).\n" +
                    "Skillfully managing activities allows you to ensure that, for example:"
        )
        addCrazyData(
            "When your UI changes in response to user action, you should animate the layout transitions. These animations give users feedback on their actions and help keep them oriented to the UI.\n" +
                    "\n" +
                    "Android includes the transitions framework, which enables you to easily animate changes between two view hierarchies. The framework animates the views at runtime by changing some of their property values over time. The framework includes built-in animations for common effects and lets you create custom animations and transition lifecycle callbacks."
        )
        addCrazyData(
            "The Espresso Test Recorder tool lets you create UI tests for your app without writing any test code. By recording a test scenario, " +
                    "you can record your interactions with a device and add assertions to verify UI elements in particular snapshots of your app. " +
                    "Espresso Test Recorder then takes the saved recording and automatically generates a corresponding UI test that you can run to test your app.\n" +
                    "Espresso Test Recorder writes tests based on the Espresso Testing framework, an API in AndroidX Test. " +
                    "The Espresso API encourages you to create concise and reliable UI tests based on user actions. " +
                    "By stating expectations, interactions, and assertions without directly accessing the underlying app’s activities and views, this structure prevents test flakiness and optimizes test run speed."
        )
        addCrazyData(
            "Activities are one of the fundamental building blocks of apps on the Android platform. " +
                    "They serve as the entry point for a user's interaction with an app, " +
                    "and are also central to how a user navigates within an app (as with the Back button) or " +
                    "between apps (as with the Recents button).\n" +
                    "Skillfully managing activities allows you to ensure that, for example:"
        )
        addCrazyData(
            "When your UI changes in response to user action, you should animate the layout transitions. These animations give users feedback on their actions and help keep them oriented to the UI.\n" +
                    "\n" +
                    "Android includes the transitions framework, which enables you to easily animate changes between two view hierarchies. The framework animates the views at runtime by changing some of their property values over time. The framework includes built-in animations for common effects and lets you create custom animations and transition lifecycle callbacks."
        )
        addCrazyData(
            "The Espresso Test Recorder tool lets you create UI tests for your app without writing any test code. By recording a test scenario, " +
                    "you can record your interactions with a device and add assertions to verify UI elements in particular snapshots of your app. " +
                    "Espresso Test Recorder then takes the saved recording and automatically generates a corresponding UI test that you can run to test your app.\n" +
                    "Espresso Test Recorder writes tests based on the Espresso Testing framework, an API in AndroidX Test. " +
                    "The Espresso API encourages you to create concise and reliable UI tests based on user actions. " +
                    "By stating expectations, interactions, and assertions without directly accessing the underlying app’s activities and views, this structure prevents test flakiness and optimizes test run speed."
        )
        addCrazyData(
            "Activities are one of the fundamental building blocks of apps on the Android platform. " +
                    "They serve as the entry point for a user's interaction with an app, " +
                    "and are also central to how a user navigates within an app (as with the Back button) or " +
                    "between apps (as with the Recents button).\n" +
                    "Skillfully managing activities allows you to ensure that, for example:"
        )
        addCrazyData(
            "When your UI changes in response to user action, you should animate the layout transitions. These animations give users feedback on their actions and help keep them oriented to the UI.\n" +
                    "\n" +
                    "Android includes the transitions framework, which enables you to easily animate changes between two view hierarchies. The framework animates the views at runtime by changing some of their property values over time. The framework includes built-in animations for common effects and lets you create custom animations and transition lifecycle callbacks."
        )
        addCrazyData(
            "The Espresso Test Recorder tool lets you create UI tests for your app without writing any test code. By recording a test scenario, " +
                    "you can record your interactions with a device and add assertions to verify UI elements in particular snapshots of your app. " +
                    "Espresso Test Recorder then takes the saved recording and automatically generates a corresponding UI test that you can run to test your app.\n" +
                    "Espresso Test Recorder writes tests based on the Espresso Testing framework, an API in AndroidX Test. " +
                    "The Espresso API encourages you to create concise and reliable UI tests based on user actions. " +
                    "By stating expectations, interactions, and assertions without directly accessing the underlying app’s activities and views, this structure prevents test flakiness and optimizes test run speed."
        )
        addCrazyData(
            "Activities are one of the fundamental building blocks of apps on the Android platform. " +
                    "They serve as the entry point for a user's interaction with an app, " +
                    "and are also central to how a user navigates within an app (as with the Back button) or " +
                    "between apps (as with the Recents button).\n" +
                    "Skillfully managing activities allows you to ensure that, for example:"
        )
        addCrazyData(
            "When your UI changes in response to user action, you should animate the layout transitions. These animations give users feedback on their actions and help keep them oriented to the UI.\n" +
                    "\n" +
                    "Android includes the transitions framework, which enables you to easily animate changes between two view hierarchies. The framework animates the views at runtime by changing some of their property values over time. The framework includes built-in animations for common effects and lets you create custom animations and transition lifecycle callbacks."
        )
        addCrazyData("Closing")
    }

    private fun addCrazyData(string: String) {
        val crazyData: CrazyType =
            CrazyType(string)
        testDataArray.add(crazyData)
    }

    private fun feedPeople(page: String) {
        val callPeople = ApiInterface.getClient().getAllPeople(page)
        //check request
        Log.d("SCB_Network", callPeople.request().url().toString())
        callPeople.enqueue(object : Callback<StarWarResponse> {
            override fun onFailure(call: Call<StarWarResponse>, t: Throwable) {
                Log.d("SCB_Network_Error", t.message.toString())
            }

            override fun onResponse(
                call: Call<StarWarResponse>,
                response: Response<StarWarResponse>
            ) {
                Log.d("SCB_Network", response.body().toString())
                if (response.isSuccessful) {
                    testDataArray.add(response.body()!!)
                    addCrazyData("EndFeed")
                    peopleAdapter?.notifyDataSetChanged()
                }
            }

        })
    }
}
