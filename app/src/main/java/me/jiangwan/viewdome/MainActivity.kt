package me.jiangwan.viewdome


import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        supportActionBar?.hide()
        setContentView(R.layout.activity_main)
       var bottomnavigationview :BottomNavigationView =findViewById(R.id.bottomnavigation)
      val navcontroller :NavController =Navigation.findNavController(this,R.id.fragment)
      val configuration = AppBarConfiguration(bottomnavigation.menu)
       NavigationUI.setupActionBarWithNavController(this,navcontroller,configuration)
     NavigationUI.setupWithNavController(bottomnavigationview,navcontroller)





    }



}
