package edu.poly.instagramcloneapp.activity

//Change start Acitivity: https://www.youtube.com/watch?v=6eES56mxfMs

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import edu.poly.instagramcloneapp.R

import edu.poly.instagramcloneapp.databinding.ActivityMainBinding
import edu.poly.instagramcloneapp.fragment.main.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var firebaseAuth: FirebaseAuth



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        firebaseAuth = FirebaseAuth.getInstance()

        //Bottom Navigation
        replaceFragment(home())

        //viewBinding
        binding = ActivityMainBinding.inflate(layoutInflater)

        //binding call function Navigation
        binding.navView.setOnItemSelectedListener { //Kick hoat khi an an vao menu item
            when(it.itemId){
                R.id.nav_home -> replaceFragment(home())
                R.id.nav_profile -> replaceFragment(person())
                R.id.nav_add_post -> replaceFragment(add_post())
                R.id.nav_favorite -> replaceFragment(favorite())
                R.id.nav_search -> replaceFragment(search())
            }
            true
        }
    setContentView(binding.root)
    }


    //    create fragment for bottom_nav
    private fun replaceFragment(fragment: Fragment){
        //Use supportFragmentManager to transaction
        val  fragmentManager = supportFragmentManager                        //Who
        val  fragmentTransaction = fragmentManager.beginTransaction()        //Who
        fragmentTransaction.replace(R.id.frame_id,fragment)
        fragmentTransaction.addToBackStack(null)
        //finish
        fragmentTransaction.commit()
    }
}
