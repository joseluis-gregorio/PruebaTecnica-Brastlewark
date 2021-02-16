package com.jose.challengeapp

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail_inhabitant.*

class DetailInhabitantActivity : BaseActivity() {
    var inhabitant:Brastlewark? = null
    var imageInhabitant:ImageView? =null
    var nameInhabitant:TextView? =null
    var weightInhabitant:TextView? =null
    var heightInhabitant:TextView? =null
    var ageInhabitant:TextView? =null
    var hairColorInhabitant:TextView? =null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_inhabitant)
        initToolbar(EMPTY)
        enableBack()
        getExtra()
    }
    private fun getExtra() {
        intent.getSerializableExtra(INHABITANT)?.let {
            inhabitant = it as Brastlewark
            initUI()
            paintUI()
        }
    }

    private fun initUI() {
        imageInhabitant=findViewById(R.id.imageView_inhabitant)
        nameInhabitant=findViewById(R.id.name_inhabitant)
        weightInhabitant=findViewById(R.id.weight)
        heightInhabitant=findViewById(R.id.height)
        ageInhabitant=findViewById(R.id.age)
        hairColorInhabitant=findViewById(R.id.hair_color)
    }

    private fun paintUI() {
        nameInhabitant?.text = inhabitant?.name?:EMPTY
        weightInhabitant?.text = inhabitant?.weight.toString()
        heightInhabitant?.text = inhabitant?.height.toString()
        ageInhabitant?.text = inhabitant?.age.toString()
        hairColorInhabitant?.text = inhabitant?.hair_color?:EMPTY
        val imageURLs=inhabitant?.thumbnail?:EMPTY
        val imageURL=inhabitant?.getImageURL()?:EMPTY
        imageInhabitant?.let {
            Glide.with(this)
                .load(imageURL)
                .error(R.drawable.ic_gnomo)
                .into(it)

        }
        toolbar.setNavigationOnClickListener { finish() }
    }
}
