package com.example.centricbudgetingapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView
    private lateinit var menuButton: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        drawerLayout = findViewById(R.id.drawerLayout)
        navigationView = findViewById(R.id.navigationView)
        menuButton = findViewById(R.id.btnMenu)

        // Open drawer when menu button clicked
        menuButton.setOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }

        // Handle menu item clicks
        navigationView.setNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_add_category -> startActivity(Intent(this, AddCategoryActivity::class.java))
                R.id.nav_add_expense -> startActivity(Intent(this, AddExpenseActivity::class.java))
                R.id.nav_budget_goals -> startActivity(Intent(this, BudgetGoalsActivity::class.java))
                R.id.nav_view_expenses -> startActivity(Intent(this, ViewExpensesActivity::class.java))
                R.id.nav_category_totals -> startActivity(Intent(this, CategoryTotalsActivity::class.java))
            }
            drawerLayout.closeDrawer(GravityCompat.START)
            true
        }
    }
}

