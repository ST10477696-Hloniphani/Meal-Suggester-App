/*
* Samantha MacAvoy, 2025, 45 Easy Breakfast Ideas for Even the Busiest Mornings.
 [online] Available at:
 <https://www.goodhousekeeping.com/food-recipes/easy/g871/quick-breakfasts/> [Accessed 20 March 2025].

*Melanie Fincher, 2024, 38 Quick Lunch Ideas You Can Make in 20 Minutes or Less.
 [online] Available at:
 < https://www.allrecipes.com/gallery/quick-and-easy-lunch-recipes/> [Accessed 20 March 2025].

*Food Network Kitchen, 2024, 50 Easy Dinner Recipes Everyone Will Love
 [online] Available at:
 < https://www.foodnetwork.com/recipes/photos/easy-dinner-recipes> [Accessed 20 March 2025].

*healthbeat, 2025, 10 Foods to Energize Your Afternoon
 [online] Available at:
 < https://www.nm.org/healthbeat/healthy-tips/nutrition/jump-start-snacks> [Accessed 20 March 2025].
 */

package vcmsa.ci.mealsuggesterapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {

    //Declaration of non-constant variables
    private var txtTitle : TextView? = null
    private var txtPageInfo : TextView? = null
    private var txtMealResults : TextView? = null
    private var edtTimeOfDay : EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //Identifying the EditText and TextView by there respective id name
        txtTitle = findViewById(R.id.txtTitle)
        txtPageInfo = findViewById(R.id.txtPageInfo)
        txtMealResults = findViewById(R.id.txtMealResults)
        edtTimeOfDay = findViewById(R.id.edtTimeOfDay)

        //Identifying the buttons by there respective id name
        val btnExit = findViewById<Button>(R.id.btnExit)
        val btnClear = findViewById<Button>(R.id.btnClear)
        val btnGiveMeal = findViewById<Button>(R.id.btnGiveMeal)

        //Declared a function that will active when btnGiveMeal is clicked
        btnGiveMeal.setOnClickListener {
            GiveMeal()
        }

        btnExit.setOnClickListener {
            finishAffinity()
            exitProcess(1)
        }

        //this will clear whats in the textview and edittext
        btnClear.setOnClickListener {
            txtMealResults?.text = ""
            edtTimeOfDay?.text?.clear()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    //Function to located unfilled editText
    private fun isEmpty():Boolean {
        return edtTimeOfDay?.text.toString().trim().isEmpty() == true
    }

    //function to give diffferent output when different input are entered
    private fun GiveMeal() {
        if (isEmpty()){
            txtMealResults?.text = "Required Input"
            edtTimeOfDay?.error = "Invalid Iuput"

        }

        val timeOfDay = edtTimeOfDay?.text.toString().trim()

        when (timeOfDay){
            "Morning" -> txtMealResults?.text = "Avocado Toast, " +
                    "Breakfast Tacos with leftover meat, " +
                    "Oatmeal, " +
                    "eggs with whole-wheat toast, " +
                    "yogurt with granola and fruit"
            "Mid-Morning" -> txtMealResults?.text = "peanut butter sandwich, " +
                    "Fruits, " +
                    "rice cake, " +
                    "Banana on toast, " +
                    "Dried apricots and almonds, " +
                    "Avocado on crispbread, " +
                    "Crumpet, " +
                    "Milk and raisins."
            "Afternoon" -> txtMealResults?.text = "Baked chicken fingers, " +
                    "Veggie fried cauliflower rice, " +
                    "Smoked black pepper and salmon Caesar salad, " +
                    "Easy coconut curry, " +
                    "Spicy shrimp tacos with mango salsa, " +
                    "Chicken mayo sandwich," +
                    "Noodles."
            "Mid-Afternoon" -> txtMealResults?.text = "Drilled Cheese, " +
                    "Smoothies, " +
                    "popcorn, " +
                    "muffins, " +
                    "crackers, " +
                    "lite egg sandwich, " +
                    "Fruit salad"
            "Dinner" -> txtMealResults?.text = "Pap, soup and meat," +
                    "Rice, soup and meat, " +
                    "Baked potatoes and fried chicken, " +
                    "Mashed potatoes and mize meat."
            else -> {
                txtMealResults?.text = "Invalid time of Day. Only enter Morning, Mid-Morning, Afternoon, Mid-Afternoon, Dinner as time of Day"
            }
        }
    }

}