package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = LaptopAdapter(getLaptops())
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.adapter = adapter
    }

    private fun getLaptops(): List<Laptop> {

        val acer = Laptop(1, "Acer", "USD 700$", R.drawable.acer)
        val apple = Laptop(2, "Apple", "USD 2000$", R.drawable.apple)
        val asus = Laptop(3, "Asus", "USD 1200$", R.drawable.asus)
        val dell = Laptop(4, "Dell", "USD 800$", R.drawable.dell)
        val hp = Laptop(5, "HP", "USD 1000$", R.drawable.hp)
        val lenovo = Laptop(6, "Lenovo", "USD 500$", R.drawable.lenovo)
        val lg = Laptop(7, "LG", "USD 1300$", R.drawable.lg)
        val microsoft = Laptop(8, "Microsoft", "USD 1199$", R.drawable.microsoft)
        val razer = Laptop(9, "Razer", "USD 1700$", R.drawable.razer)
        val sony = Laptop(10, "SONY", "USD 1500$", R.drawable.sony)

        val returnList = ArrayList<Laptop>()

        returnList.add(acer)
        returnList.add(apple)
        returnList.add(asus)
        returnList.add(dell)
        returnList.add(hp)
        returnList.add(lenovo)
        returnList.add(lg)
        returnList.add(microsoft)
        returnList.add(razer)
        returnList.add(sony)

        return returnList
    }
}
