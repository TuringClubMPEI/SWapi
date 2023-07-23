package ru.turing.swapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import ru.turing.swapi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    /**
     * by lazy{...} инициализирует поле в момент первого обращения к полю. Не сипользуем инциаилизацию
     * "на месте", так как binding взаимодействует с View элементами, что до появления контекста делать нельзя
     * а контекст появляется только в onCreate. Соответственно, до onCreate не пользуемся биндингом
     */
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.bottomNavigationView.setOnNavigationItemSelectedListener(this)
        routeTo(FirstFragment.newInstance())
    }

    override fun onNavigationItemSelected(item: MenuItem) = when(item.itemId) {
        R.id.first -> routeTo(FirstFragment.newInstance())
        R.id.second -> routeTo(SecondFragment.newInstance("olol"))
        else -> false
    }

    private fun routeTo(fragment: Fragment): Boolean {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .commit()
        return true
    }
}