package com.example.companionapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.companionapp.Adapters.ArmorAdapter
import com.example.companionapp.Adapters.ItemAdapter
import com.example.companionapp.Classes.Character
import com.example.companionapp.R
import kotlinx.android.synthetic.main.fragment_b.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val CHAR_DETAILS = "charDetails"



/**
 * A simple [Fragment] subclass.
 * Use the [FragmentB.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentB : Fragment() {
    // TODO: Rename and change types of parameters
    private lateinit var characterDetails: Character


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null){
            characterDetails = arguments?.getParcelable<Character>(CHAR_DETAILS) as Character
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view:View = inflater.inflate(R.layout.fragment_b, container, false)

        //Primary Weapon
        var recyclerViewPrimary:RecyclerView = view.findViewById(R.id.recycler_primary_weapon)
        var gridLayoutManagerPrimary:GridLayoutManager = GridLayoutManager(context,4,LinearLayoutManager.VERTICAL,false)
        recyclerViewPrimary.layoutManager = gridLayoutManagerPrimary
        recyclerViewPrimary.setHasFixedSize(true)
        var primaryAdapter:ItemAdapter = ItemAdapter(context!!,characterDetails.primaryweapon!!)
        recyclerViewPrimary?.adapter = primaryAdapter


        //Special Weapon
        var recyclerViewSpecial:RecyclerView = view.findViewById(R.id.recycler_special_weapon)
        var gridLayoutManagerSpecial:GridLayoutManager = GridLayoutManager(context,4,LinearLayoutManager.VERTICAL,false)
        recyclerViewSpecial.layoutManager = gridLayoutManagerSpecial
        recyclerViewSpecial.setHasFixedSize(true)
        var specialAdapter:ItemAdapter = ItemAdapter(context!!,characterDetails.specialweapon!!)
        recyclerViewSpecial?.adapter = specialAdapter

        //Heavy Weapon
        var recyclerViewHeavy:RecyclerView = view.findViewById(R.id.recycler_heavy_weapon)
        var gridLayoutManagerHeavy:GridLayoutManager = GridLayoutManager(context,4,LinearLayoutManager.VERTICAL,false)
        recyclerViewHeavy.layoutManager = gridLayoutManagerHeavy
        recyclerViewHeavy.setHasFixedSize(true)
        var heavyAdapter:ItemAdapter = ItemAdapter(context!!,characterDetails.heavyweapon!!)
        recyclerViewHeavy?.adapter = heavyAdapter

        // Helmet

        var recyclerViewHelmet:RecyclerView = view.findViewById(R.id.recycler_helmets)
        var gridLayoutManagerHelmet:GridLayoutManager = GridLayoutManager(context,4,LinearLayoutManager.VERTICAL,false)
        recyclerViewHelmet.layoutManager = gridLayoutManagerHelmet
        recyclerViewHelmet.setHasFixedSize(true)
        var helmetAdapter:ArmorAdapter = ArmorAdapter(context!!,characterDetails.helmet!!)
        recyclerViewHelmet?.adapter = helmetAdapter

        view.CharacterClassText.text = characterDetails.characterclass
        view.powerWeaponText.text = characterDetails.power.toString()

        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FragmentB.
         */
        // TODO: Rename and change types and number of parameters

       /* fun newInstance(param1: String, param2: String) =
            FragmentB().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }*/
        @JvmStatic
        fun newInstance(character: Character): FragmentB {
            val fragment = FragmentB()
            val args = Bundle()
            args.putParcelable(CHAR_DETAILS , character )
            fragment.arguments = args
            return fragment
        }
    }
}