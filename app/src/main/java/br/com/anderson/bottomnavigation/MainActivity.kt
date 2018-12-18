package br.com.anderson.bottomnavigation

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                trocaFragment("HOME")
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                trocaFragment("DASHBOARD")
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                trocaFragment("NOTIFICACAO")
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    private fun trocaFragment(texto: String) {
        val ft = supportFragmentManager.beginTransaction()
        val fragment = BlankFragment.newInstance(texto)
        ft.replace(R.id.flContainer, fragment)
        ft.addToBackStack(null)
        ft.commit()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val fragmentManager = supportFragmentManager
        if(fragmentManager.backStackEntryCount > 0) {
            fragmentManager.popBackStack()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        trocaFragment("Home")
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }
}
