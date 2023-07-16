package ru.turing.swapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.turing.swapi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), ActivityNavigator {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        goToFirstFragment()
    }

    override fun goToFirstFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, FirstFragment.newInstance())
            .commit()
    }

    override fun goToSecondFragment(string: String) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, SecondFragment.newInstance(string))
            .commit()
    }
}