package ru.turing.swapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.turing.swapi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), ActivityNavigator {

    /**
     * by lazy{...} инициализирует поле в момент первого обращения к полю. Не сипользуем инциаилизацию
     * "на месте", так как binding взаимодействует с View элементами, что до появления контекста делать нельзя
     * а контекст появляется только в onCreate. Соответственно, до onCreate не пользуемся биндингом
     */
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