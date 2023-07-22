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
        goToMainFragment()
    }

    override fun goToMainFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, MainScreenFragment.newInstance())
            .commit()
    }

    override fun goToDartVaderFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, DartVaderFragment.newInstance())
            .commit()
    }

    override fun goToLuckSkywalkerFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container,  LuckSkywalkerFragment.newInstance())
            .commit()
    }

    override fun goToShivPalpatinFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, ShivPalpatinFragment.newInstance())
            .commit()
    }
}