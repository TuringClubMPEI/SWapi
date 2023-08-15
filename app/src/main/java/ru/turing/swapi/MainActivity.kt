package ru.turing.swapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView
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
        routeTo(MainScreenFragment.newInstance())
    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean = when(item.itemId) {
        R.id.bot_menu_home_screen -> routeTo(MainScreenFragment.newInstance())
        R.id.bot_menu_about_screen -> routeTo(AboutFragment.newInstance())
        else -> false
    }

    private fun routeTo(fragment: Fragment): Boolean {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .commit()

        return true
    }
}
