package com.example.animcare.MainActivityFiles.Adapters

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.example.animcare.MainActivityFiles.Fragments.DetailsAboutAnimal
import com.example.animcare.MainActivityFiles.Objects.AnimalsTypes
import com.example.animcare.R
import kotlinx.android.synthetic.main.animals_types_position_in_list_rw.view.*

class BreedOfAnimalsAdapter (val context: Context, val typeOfAnimal: String?, val supportFragmentManager: FragmentManager): RecyclerView.Adapter<MyAnimalsTypesAdapter>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAnimalsTypesAdapter {
        val inflate = LayoutInflater.from(parent.context)
        val positionList = inflate.inflate(R.layout.animals_types_position_in_list_rw, parent, false)
        return MyAnimalsTypesAdapter(positionList)
    }

    override fun onBindViewHolder(holder: MyAnimalsTypesAdapter, position: Int) {
        val detailsAboutAnimal = DetailsAboutAnimal()

        val layout = holder.view.animals_types_position_in_list_rw
        val breedOfAnimal = holder.view.typeOfAnimal
        when(typeOfAnimal){
            "Pies" -> {
                breedOfAnimal.text = AnimalsTypes.breedOfDogs[position]

            }
            "Kot" -> {
                breedOfAnimal.text = AnimalsTypes.breedOfCats[position]

            }


        }

        layout.setOnClickListener{
            //it.setBackgroundColor(Color.parseColor("#25875C"))
            it.setBackgroundColor(Color.parseColor("#8EC5AD"))
            breedOfAnimal.textSize = 28f
            breedOfAnimal.setTextColor(Color.WHITE)


            Handler().postDelayed({
                val args = Bundle()
                args.putString("BreedOfAnimal", breedOfAnimal.text.toString())
                detailsAboutAnimal.arguments = args
                goToFragment(detailsAboutAnimal)

            }, 300)



        }



    }

    override fun getItemCount(): Int {
        return when(typeOfAnimal){
            "Pies" -> {
                AnimalsTypes.breedOfDogs.size
            }
            "Kot" -> {
                AnimalsTypes.breedOfCats.size
            }
            else -> {
                0
            }


        }

    }

    private fun goToFragment(fragment: Fragment){
        var backName = fragment.javaClass.name
        val manager = supportFragmentManager
        var fragmentsInBackStack = manager.popBackStackImmediate(backName,0)

        if (!fragmentsInBackStack){
            val fragmentTransaction = manager.beginTransaction()
                .replace(R.id.fragmentContainerView, fragment)
                .addToBackStack(backName)
            fragmentTransaction.commit()
        }

    }


}



class MyBreedOfAnimalsAdapter(val view: View):RecyclerView.ViewHolder(view){}