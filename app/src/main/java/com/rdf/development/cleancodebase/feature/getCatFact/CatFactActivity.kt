package com.rdf.development.cleancodebase.feature.getCatFact

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.rdf.development.cleancodebase.R
import com.rdf.development.cleancodebase.base.BaseActivity
import com.rdf.development.domain.model.Fact
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import javax.inject.Inject

class CatFactActivity : BaseActivity(), GetCatFactContract.View {

    @Inject
    lateinit var presenter: CatFactPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        presenter.takeView(this)

        fab.setOnClickListener {
          Toast.makeText(this, "Hello world", Toast.LENGTH_LONG).show()
        }
    }

    override fun displayCatFact(fact: Fact) {
        catFactTextView.text = fact.fact
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
