package com.codemobile.rcvcollab.newexpandtext

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.codemobile.rcvcollab.R
import kotlinx.android.synthetic.main.activity_expand_text.rcv_expand_text_state

class ExpandTextActivity : AppCompatActivity() {

    private var dataFake = arrayListOf<ExpandText>()
    private var expandAdapter: RCVExpandTextAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_expand_text)

        addDataExpandText(
                string = "1Line\n" +
                        "2Line\n" +
                        "3Line\n" +
                        "4Line\n" +
                        "5Line\n" +
                        "6Line",
        state = ExpandState.Collapsed
        )
        addDataExpandText(
            string = "The Espresso Test Recorder tool lets you create UI tests for your app without writing any test code. By recording a test scenario, " +
                    "you can record your interactions with a device and add assertions to verify UI elements in particular snapshots of your app. " +
                    "Espresso Test Recorder then takes the saved recording and automatically generates a corresponding UI test that you can run to test your app.\n" +
                    "Espresso Test Recorder writes tests based on the Espresso Testing framework, an API in AndroidX Test. " +
                    "The Espresso API encourages you to create concise and reliable UI tests based on user actions. " +
                    "By stating expectations, interactions, and assertions without directly accessing the underlying app’s activities and views, this structure prevents test flakiness and optimizes test run speed."
            , state = ExpandState.Collapsed
        )
        addDataExpandText(
            string = "Activities are one of the fundamental building blocks of apps on the Android platform. " +
                    "They serve as the entry point for a user's interaction with an app, " +
                    "and are also central to how a user navigates within an app (as with the Back button) or " +
                    "between apps (as with the Recents button).\n" +
                    "Skillfully managing activities allows you to ensure that, for example:",
            state = ExpandState.Collapsed
        )
        addDataExpandText(
            string = "1Line\n" +
                    "2Line\n" +
                    "3Line\n" +
                    "4Line\n" +
                    "5Line\n" +
                    "6Line",
            state = ExpandState.Collapsed
        )
        addDataExpandText(
            string = "The Espresso Test Recorder tool lets you create UI tests for your app without writing any test code. By recording a test scenario, " +
                    "you can record your interactions with a device and add assertions to verify UI elements in particular snapshots of your app. " +
                    "Espresso Test Recorder then takes the saved recording and automatically generates a corresponding UI test that you can run to test your app.\n" +
                    "Espresso Test Recorder writes tests based on the Espresso Testing framework, an API in AndroidX Test. " +
                    "The Espresso API encourages you to create concise and reliable UI tests based on user actions. " +
                    "By stating expectations, interactions, and assertions without directly accessing the underlying app’s activities and views, this structure prevents test flakiness and optimizes test run speed."
            , state = ExpandState.Collapsed
        )
        addDataExpandText(
            string = "Activities are one of the fundamental building blocks of apps on the Android platform. " +
                    "They serve as the entry point for a user's interaction with an app, " +
                    "and are also central to how a user navigates within an app (as with the Back button) or " +
                    "between apps (as with the Recents button).\n" +
                    "Skillfully managing activities allows you to ensure that, for example:",
            state = ExpandState.Collapsed
        )
        addDataExpandText(
            string = "1Line\n" +
                    "2Line\n" +
                    "3Line\n" +
                    "4Line\n" +
                    "5Line\n" +
                    "6Line",
            state = ExpandState.Collapsed
        )
        addDataExpandText(
            string = "The Espresso Test Recorder tool lets you create UI tests for your app without writing any test code. By recording a test scenario, " +
                    "you can record your interactions with a device and add assertions to verify UI elements in particular snapshots of your app. " +
                    "Espresso Test Recorder then takes the saved recording and automatically generates a corresponding UI test that you can run to test your app.\n" +
                    "Espresso Test Recorder writes tests based on the Espresso Testing framework, an API in AndroidX Test. " +
                    "The Espresso API encourages you to create concise and reliable UI tests based on user actions. " +
                    "By stating expectations, interactions, and assertions without directly accessing the underlying app’s activities and views, this structure prevents test flakiness and optimizes test run speed."
            , state = ExpandState.Collapsed
        )
        addDataExpandText(
            string = "Activities are one of the fundamental building blocks of apps on the Android platform. " +
                    "They serve as the entry point for a user's interaction with an app, " +
                    "and are also central to how a user navigates within an app (as with the Back button) or " +
                    "between apps (as with the Recents button).\n" +
                    "Skillfully managing activities allows you to ensure that, for example:",
            state = ExpandState.Collapsed
        )
        addDataExpandText(
            string = "1Line\n" +
                    "2Line\n" +
                    "3Line\n" +
                    "4Line\n" +
                    "5Line\n" +
                    "6Line",
            state = ExpandState.Collapsed
        )
        addDataExpandText(
            string = "The Espresso Test Recorder tool lets you create UI tests for your app without writing any test code. By recording a test scenario, " +
                    "you can record your interactions with a device and add assertions to verify UI elements in particular snapshots of your app. " +
                    "Espresso Test Recorder then takes the saved recording and automatically generates a corresponding UI test that you can run to test your app.\n" +
                    "Espresso Test Recorder writes tests based on the Espresso Testing framework, an API in AndroidX Test. " +
                    "The Espresso API encourages you to create concise and reliable UI tests based on user actions. " +
                    "By stating expectations, interactions, and assertions without directly accessing the underlying app’s activities and views, this structure prevents test flakiness and optimizes test run speed."
            , state = ExpandState.Collapsed
        )
        addDataExpandText(
            string = "Activities are one of the fundamental building blocks of apps on the Android platform. " +
                    "They serve as the entry point for a user's interaction with an app, " +
                    "and are also central to how a user navigates within an app (as with the Back button) or " +
                    "between apps (as with the Recents button).\n" +
                    "Skillfully managing activities allows you to ensure that, for example:",
            state = ExpandState.Collapsed
        )
        addDataExpandText(
            string = "1Line\n" +
                    "2Line\n" +
                    "3Line\n" +
                    "4Line\n" +
                    "5Line\n" +
                    "6Line",
            state = ExpandState.Collapsed
        )
        addDataExpandText(
            string = "The Espresso Test Recorder tool lets you create UI tests for your app without writing any test code. By recording a test scenario, " +
                    "you can record your interactions with a device and add assertions to verify UI elements in particular snapshots of your app. " +
                    "Espresso Test Recorder then takes the saved recording and automatically generates a corresponding UI test that you can run to test your app.\n" +
                    "Espresso Test Recorder writes tests based on the Espresso Testing framework, an API in AndroidX Test. " +
                    "The Espresso API encourages you to create concise and reliable UI tests based on user actions. " +
                    "By stating expectations, interactions, and assertions without directly accessing the underlying app’s activities and views, this structure prevents test flakiness and optimizes test run speed."
            , state = ExpandState.Collapsed
        )
        addDataExpandText(
            string = "Activities are one of the fundamental building blocks of apps on the Android platform. " +
                    "They serve as the entry point for a user's interaction with an app, " +
                    "and are also central to how a user navigates within an app (as with the Back button) or " +
                    "between apps (as with the Recents button).\n" +
                    "Skillfully managing activities allows you to ensure that, for example:",
            state = ExpandState.Collapsed
        )
        addDataExpandText(
            string = "1Line\n" +
                    "2Line\n" +
                    "3Line\n" +
                    "4Line\n" +
                    "5Line\n" +
                    "6Line",
            state = ExpandState.Collapsed
        )
        addDataExpandText(
            string = "The Espresso Test Recorder tool lets you create UI tests for your app without writing any test code. By recording a test scenario, " +
                    "you can record your interactions with a device and add assertions to verify UI elements in particular snapshots of your app. " +
                    "Espresso Test Recorder then takes the saved recording and automatically generates a corresponding UI test that you can run to test your app.\n" +
                    "Espresso Test Recorder writes tests based on the Espresso Testing framework, an API in AndroidX Test. " +
                    "The Espresso API encourages you to create concise and reliable UI tests based on user actions. " +
                    "By stating expectations, interactions, and assertions without directly accessing the underlying app’s activities and views, this structure prevents test flakiness and optimizes test run speed."
            , state = ExpandState.Collapsed
        )
        addDataExpandText(
            string = "Activities are one of the fundamental building blocks of apps on the Android platform. " +
                    "They serve as the entry point for a user's interaction with an app, " +
                    "and are also central to how a user navigates within an app (as with the Back button) or " +
                    "between apps (as with the Recents button).\n" +
                    "Skillfully managing activities allows you to ensure that, for example:",
            state = ExpandState.Collapsed
        )
        addDataExpandText(
            string = "1Line\n" +
                    "2Line\n" +
                    "3Line\n" +
                    "4Line\n" +
                    "5Line\n" +
                    "6Line",
            state = ExpandState.Collapsed
        )
        addDataExpandText(
            string = "The Espresso Test Recorder tool lets you create UI tests for your app without writing any test code. By recording a test scenario, " +
                    "you can record your interactions with a device and add assertions to verify UI elements in particular snapshots of your app. " +
                    "Espresso Test Recorder then takes the saved recording and automatically generates a corresponding UI test that you can run to test your app.\n" +
                    "Espresso Test Recorder writes tests based on the Espresso Testing framework, an API in AndroidX Test. " +
                    "The Espresso API encourages you to create concise and reliable UI tests based on user actions. " +
                    "By stating expectations, interactions, and assertions without directly accessing the underlying app’s activities and views, this structure prevents test flakiness and optimizes test run speed."
            , state = ExpandState.Collapsed
        )
        addDataExpandText(
            string = "Activities are one of the fundamental building blocks of apps on the Android platform. " +
                    "They serve as the entry point for a user's interaction with an app, " +
                    "and are also central to how a user navigates within an app (as with the Back button) or " +
                    "between apps (as with the Recents button).\n" +
                    "Skillfully managing activities allows you to ensure that, for example:",
            state = ExpandState.Collapsed
        )
        addDataExpandText(
            string = "1Line\n" +
                    "2Line\n" +
                    "3Line\n" +
                    "4Line\n" +
                    "5Line\n" +
                    "6Line",
            state = ExpandState.Collapsed
        )
        addDataExpandText(
            string = "The Espresso Test Recorder tool lets you create UI tests for your app without writing any test code. By recording a test scenario, " +
                    "you can record your interactions with a device and add assertions to verify UI elements in particular snapshots of your app. " +
                    "Espresso Test Recorder then takes the saved recording and automatically generates a corresponding UI test that you can run to test your app.\n" +
                    "Espresso Test Recorder writes tests based on the Espresso Testing framework, an API in AndroidX Test. " +
                    "The Espresso API encourages you to create concise and reliable UI tests based on user actions. " +
                    "By stating expectations, interactions, and assertions without directly accessing the underlying app’s activities and views, this structure prevents test flakiness and optimizes test run speed."
            , state = ExpandState.Collapsed
        )
        addDataExpandText(
            string = "Activities are one of the fundamental building blocks of apps on the Android platform. " +
                    "They serve as the entry point for a user's interaction with an app, " +
                    "and are also central to how a user navigates within an app (as with the Back button) or " +
                    "between apps (as with the Recents button).\n" +
                    "Skillfully managing activities allows you to ensure that, for example:",
            state = ExpandState.Collapsed
        )
        addDataExpandText(
            string = "1Line\n" +
                    "2Line\n" +
                    "3Line\n" +
                    "4Line\n" +
                    "5Line\n" +
                    "6Line",
            state = ExpandState.Collapsed
        )
        addDataExpandText(
            string = "The Espresso Test Recorder tool lets you create UI tests for your app without writing any test code. By recording a test scenario, " +
                    "you can record your interactions with a device and add assertions to verify UI elements in particular snapshots of your app. " +
                    "Espresso Test Recorder then takes the saved recording and automatically generates a corresponding UI test that you can run to test your app.\n" +
                    "Espresso Test Recorder writes tests based on the Espresso Testing framework, an API in AndroidX Test. " +
                    "The Espresso API encourages you to create concise and reliable UI tests based on user actions. " +
                    "By stating expectations, interactions, and assertions without directly accessing the underlying app’s activities and views, this structure prevents test flakiness and optimizes test run speed."
            , state = ExpandState.Collapsed
        )
        addDataExpandText(
            string = "Activities are one of the fundamental building blocks of apps on the Android platform. " +
                    "They serve as the entry point for a user's interaction with an app, " +
                    "and are also central to how a user navigates within an app (as with the Back button) or " +
                    "between apps (as with the Recents button).\n" +
                    "Skillfully managing activities allows you to ensure that, for example:",
            state = ExpandState.Collapsed
        )
        addDataExpandText(
            string = "1Line\n" +
                    "2Line\n" +
                    "3Line\n" +
                    "4Line\n" +
                    "5Line\n" +
                    "6Line",
            state = ExpandState.Collapsed
        )
        addDataExpandText(
            string = "The Espresso Test Recorder tool lets you create UI tests for your app without writing any test code. By recording a test scenario, " +
                    "you can record your interactions with a device and add assertions to verify UI elements in particular snapshots of your app. " +
                    "Espresso Test Recorder then takes the saved recording and automatically generates a corresponding UI test that you can run to test your app.\n" +
                    "Espresso Test Recorder writes tests based on the Espresso Testing framework, an API in AndroidX Test. " +
                    "The Espresso API encourages you to create concise and reliable UI tests based on user actions. " +
                    "By stating expectations, interactions, and assertions without directly accessing the underlying app’s activities and views, this structure prevents test flakiness and optimizes test run speed."
            , state = ExpandState.Collapsed
        )
        addDataExpandText(
            string = "Activities are one of the fundamental building blocks of apps on the Android platform. " +
                    "They serve as the entry point for a user's interaction with an app, " +
                    "and are also central to how a user navigates within an app (as with the Back button) or " +
                    "between apps (as with the Recents button).\n" +
                    "Skillfully managing activities allows you to ensure that, for example:",
            state = ExpandState.Collapsed
        )
        addDataExpandText(
            string = "1Line\n" +
                    "2Line\n" +
                    "3Line\n" +
                    "4Line\n" +
                    "5Line\n" +
                    "6Line",
            state = ExpandState.Collapsed
        )
        addDataExpandText(
            string = "The Espresso Test Recorder tool lets you create UI tests for your app without writing any test code. By recording a test scenario, " +
                    "you can record your interactions with a device and add assertions to verify UI elements in particular snapshots of your app. " +
                    "Espresso Test Recorder then takes the saved recording and automatically generates a corresponding UI test that you can run to test your app.\n" +
                    "Espresso Test Recorder writes tests based on the Espresso Testing framework, an API in AndroidX Test. " +
                    "The Espresso API encourages you to create concise and reliable UI tests based on user actions. " +
                    "By stating expectations, interactions, and assertions without directly accessing the underlying app’s activities and views, this structure prevents test flakiness and optimizes test run speed."
            , state = ExpandState.Collapsed
        )
        addDataExpandText(
            string = "Activities are one of the fundamental building blocks of apps on the Android platform. " +
                    "They serve as the entry point for a user's interaction with an app, " +
                    "and are also central to how a user navigates within an app (as with the Back button) or " +
                    "between apps (as with the Recents button).\n" +
                    "Skillfully managing activities allows you to ensure that, for example:",
            state = ExpandState.Collapsed
        )
        addDataExpandText(
            string = "1Line\n" +
                    "2Line\n" +
                    "3Line\n" +
                    "4Line\n" +
                    "5Line\n" +
                    "6Line",
            state = ExpandState.Collapsed
        )
        addDataExpandText(
            string = "The Espresso Test Recorder tool lets you create UI tests for your app without writing any test code. By recording a test scenario, " +
                    "you can record your interactions with a device and add assertions to verify UI elements in particular snapshots of your app. " +
                    "Espresso Test Recorder then takes the saved recording and automatically generates a corresponding UI test that you can run to test your app.\n" +
                    "Espresso Test Recorder writes tests based on the Espresso Testing framework, an API in AndroidX Test. " +
                    "The Espresso API encourages you to create concise and reliable UI tests based on user actions. " +
                    "By stating expectations, interactions, and assertions without directly accessing the underlying app’s activities and views, this structure prevents test flakiness and optimizes test run speed."
            , state = ExpandState.Collapsed
        )
        addDataExpandText(
            string = "Activities are one of the fundamental building blocks of apps on the Android platform. " +
                    "They serve as the entry point for a user's interaction with an app, " +
                    "and are also central to how a user navigates within an app (as with the Back button) or " +
                    "between apps (as with the Recents button).\n" +
                    "Skillfully managing activities allows you to ensure that, for example:",
            state = ExpandState.Collapsed
        )
        addDataExpandText(
            string = "1Line\n" +
                    "2Line\n" +
                    "3Line\n" +
                    "4Line\n" +
                    "5Line\n" +
                    "6Line",
            state = ExpandState.Collapsed
        )
        addDataExpandText(
            string = "The Espresso Test Recorder tool lets you create UI tests for your app without writing any test code. By recording a test scenario, " +
                    "you can record your interactions with a device and add assertions to verify UI elements in particular snapshots of your app. " +
                    "Espresso Test Recorder then takes the saved recording and automatically generates a corresponding UI test that you can run to test your app.\n" +
                    "Espresso Test Recorder writes tests based on the Espresso Testing framework, an API in AndroidX Test. " +
                    "The Espresso API encourages you to create concise and reliable UI tests based on user actions. " +
                    "By stating expectations, interactions, and assertions without directly accessing the underlying app’s activities and views, this structure prevents test flakiness and optimizes test run speed."
            , state = ExpandState.Collapsed
        )
        addDataExpandText(
            string = "Activities are one of the fundamental building blocks of apps on the Android platform. " +
                    "They serve as the entry point for a user's interaction with an app, " +
                    "and are also central to how a user navigates within an app (as with the Back button) or " +
                    "between apps (as with the Recents button).\n" +
                    "Skillfully managing activities allows you to ensure that, for example:",
            state = ExpandState.Collapsed
        )
        addDataExpandText(
            string = "1Line\n" +
                    "2Line\n" +
                    "3Line\n" +
                    "4Line\n" +
                    "5Line\n" +
                    "6Line",
            state = ExpandState.Collapsed
        )
        addDataExpandText(
            string = "The Espresso Test Recorder tool lets you create UI tests for your app without writing any test code. By recording a test scenario, " +
                    "you can record your interactions with a device and add assertions to verify UI elements in particular snapshots of your app. " +
                    "Espresso Test Recorder then takes the saved recording and automatically generates a corresponding UI test that you can run to test your app.\n" +
                    "Espresso Test Recorder writes tests based on the Espresso Testing framework, an API in AndroidX Test. " +
                    "The Espresso API encourages you to create concise and reliable UI tests based on user actions. " +
                    "By stating expectations, interactions, and assertions without directly accessing the underlying app’s activities and views, this structure prevents test flakiness and optimizes test run speed."
            , state = ExpandState.Collapsed
        )
        addDataExpandText(
            string = "Activities are one of the fundamental building blocks of apps on the Android platform. " +
                    "They serve as the entry point for a user's interaction with an app, " +
                    "and are also central to how a user navigates within an app (as with the Back button) or " +
                    "between apps (as with the Recents button).\n" +
                    "Skillfully managing activities allows you to ensure that, for example:",
            state = ExpandState.Collapsed
        )
        addDataExpandText(
            string = "1Line\n" +
                    "2Line\n" +
                    "3Line\n" +
                    "4Line\n" +
                    "5Line\n" +
                    "6Line",
            state = ExpandState.Collapsed
        )
        addDataExpandText(
            string = "The Espresso Test Recorder tool lets you create UI tests for your app without writing any test code. By recording a test scenario, " +
                    "you can record your interactions with a device and add assertions to verify UI elements in particular snapshots of your app. " +
                    "Espresso Test Recorder then takes the saved recording and automatically generates a corresponding UI test that you can run to test your app.\n" +
                    "Espresso Test Recorder writes tests based on the Espresso Testing framework, an API in AndroidX Test. " +
                    "The Espresso API encourages you to create concise and reliable UI tests based on user actions. " +
                    "By stating expectations, interactions, and assertions without directly accessing the underlying app’s activities and views, this structure prevents test flakiness and optimizes test run speed."
            , state = ExpandState.Collapsed
        )
        addDataExpandText(
            string = "Activities are one of the fundamental building blocks of apps on the Android platform. " +
                    "They serve as the entry point for a user's interaction with an app, " +
                    "and are also central to how a user navigates within an app (as with the Back button) or " +
                    "between apps (as with the Recents button).\n" +
                    "Skillfully managing activities allows you to ensure that, for example:",
            state = ExpandState.Collapsed
        )
        expandAdapter = RCVExpandTextAdapter(this, dataFake)
        rcv_expand_text_state.let {
            it.adapter = expandAdapter
            it.layoutManager = LinearLayoutManager(this)
        }
    }

    fun addDataExpandText(string: String, state: ExpandState) {
        val mockExpandText = ExpandText(string, state)
        dataFake.add(mockExpandText)
    }
}
