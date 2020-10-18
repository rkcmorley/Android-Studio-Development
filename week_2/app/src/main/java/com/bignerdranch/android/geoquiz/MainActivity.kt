package com.bignerdranch.android.geoquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    //  Since the view objects are not inflated into and available in memory until after setContentView(…)
    //  is called in onCreate(…), you use lateinit on your property declarations to indicate to the compiler
    //  that you will provide a non-null View value before you attempt to use the contents of the property
    private lateinit var trueButton: Button
    private lateinit var falseButton: Button

    //The onCreate(Bundle?) function is called when an instance of the activity subclass is created.
    // When an activity is created, it needs a UI to manage. To give the activity its UI, you call
    // Activity.setContentView(layoutResID: Int).
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //  This is where the R.layout.activity_main comes from –
        //  it is an integer constant named activity_main within the layout inner class of R.
        setContentView(R.layout.activity_main)


        // In an activity, you can get a reference to an inflated widget by calling Activity.findViewById(Int).
        // This function returns the corresponding view. Rather than return it as a View, it is cast
        // to the expected subtype of View. Here, that type is Button.

        // In the code above, you use the resource IDs of your buttons to retrieve the inflated objects and
        // assign them to your view properties.
        trueButton = findViewById(R.id.true_button)
        falseButton = findViewById(R.id.false_button)

        // In this method, we're setting up a listener for the true button.
        // Listeners are event driven. User trigger them by clicking on it.

        //makeText(context: Context, resId: Int, duration: Int)
        // For the first parameter, the Context parameter is typically an instance of Activity
        // (and Activity is a subclass of Context). Here you pass the instance of MainActivity as
        // the Context argument.
        // The second parameter is the resource ID of the string that the toast should display.
        //  The third parameter is one of two Toast constants that specify how long the toast should be visible
        trueButton.setOnClickListener { view: View ->
            Toast.makeText(
                    this,
                    R.string.correct_toast,
                    Toast.LENGTH_SHORT)
                    .show()
        }

        // In this method, we're setting up a listener for the false button.
        // Listeners are event driven. User trigger them by clicking on it.
        falseButton.setOnClickListener { view: View ->
            Toast.makeText(
                    this,
                    R.string.incorrect_toast,
                    Toast.LENGTH_SHORT)
                    .show()
        }
    }
}
