package constanta.testtask.filmsapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import constanta.testtask.filmsapplication.R
import constanta.testtask.filmsapplication.ui.fragment.ListFilmsFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().replace(R.id.holder,
            ListFilmsFragment.newInstance()).commit()
    }
}