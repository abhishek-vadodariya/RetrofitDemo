package com.example.abhishek.firebase

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener
{
    private lateinit var recycler_view : RecyclerView
    private var activity= this@MainActivity
    val pojolist = ArrayList<Pojo>()
    private lateinit var myAdapter : RecyclerviewAdapter

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        SetUpView();

        myAdapter = RecyclerviewAdapter(pojolist,applicationContext)
        recycler_view.setHasFixedSize(true)
        var linearLayoutManager : LinearLayoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        recycler_view.layoutManager = linearLayoutManager
        recycler_view.itemAnimator = DefaultItemAnimator()
        recycler_view.adapter = myAdapter

        getData();


        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
    }

    private fun getData()
    {

        /*pojolist.add(Pojo(R.mipmap.logo,"Abhishek", "Vadodariya","06/02/1995"))
        pojolist.add(Pojo(R.mipmap.logo,"Tejas", "Monpara","06/02/1995"))
        pojolist.add(Pojo(R.mipmap.logo,"Bhavdeep", "Patel","06/02/1995"))
        pojolist.add(Pojo(R.mipmap.logo,"Mayur", "Malaviya","06/02/1995"))*/



        recycler_view.adapter = RecyclerviewAdapter(pojolist,applicationContext);
    }

    private fun SetUpView()
    {
        recycler_view=findViewById(R.id.recycler_view)as RecyclerView;
    }

    override fun onBackPressed()
    {
        if (drawer_layout.isDrawerOpen(GravityCompat.START))
        {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else
        {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId)
        {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean
    {
        // Handle navigation view item clicks here.
        when (item.itemId)
        {
            R.id.home ->
            {

            }
            R.id.profile ->
            {
                val intent = Intent(this@MainActivity,ProfileActivity::class.java)
                startActivity(intent)
            }
            R.id.logout ->
            {
                val intent=Intent(this@MainActivity,LoginActivity::class.java)
                startActivity(intent)
                finish();
            }
            R.id.nav_share -> {

            }
            R.id.nav_send -> {

            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
