package com.example.companionapp.fragments

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.companionapp.Activities.LoginActivity
import com.example.companionapp.Adapters.ArmorAdapter
import com.example.companionapp.Adapters.CharacterAdapter
import com.example.companionapp.Adapters.ItemAdapter
import com.example.companionapp.Classes.Character
import com.example.companionapp.R
import com.google.firebase.auth.FirebaseAuth
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
    lateinit var sharedPreferences: SharedPreferences

    lateinit var  recyclerViewPrimary:RecyclerView
    private lateinit var primary_adapter:ItemAdapter

    lateinit var recyclerViewSpecial:RecyclerView
    private lateinit var special_adapter:ItemAdapter

    lateinit var recyclerViewHeavy:RecyclerView
    private lateinit var heavy_adapter:ItemAdapter

    lateinit var recyclerViewHelmet:RecyclerView
    private lateinit var helmet_adapter:ArmorAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null){
            characterDetails = arguments?.getParcelable<Character>(CHAR_DETAILS) as Character
        }

        setHasOptionsMenu(true)
        sharedPreferences = this.activity!!.getSharedPreferences("SHARED_PREFS", Context.MODE_PRIVATE)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        super.onOptionsItemSelected(item)

        when(item.itemId){
            R.id.order-> {
                primary_adapter.sortList()
                recyclerViewPrimary.adapter!!.notifyDataSetChanged()

                special_adapter.sortList()
                recyclerViewSpecial.adapter!!.notifyDataSetChanged()

                heavy_adapter.sortList()
                recyclerViewHeavy.adapter!!.notifyDataSetChanged()

                helmet_adapter.sortList()
                recyclerViewHelmet.adapter!!.notifyDataSetChanged()
            }
            R.id.logoutitem -> {
                FirebaseAuth.getInstance().signOut()

                val editor: SharedPreferences.Editor = sharedPreferences.edit()
                editor.putBoolean("CHECKBOX", false)
                editor.apply()

                val intent = Intent (this@FragmentB.context, LoginActivity::class.java)
                startActivity(intent)
            }
        }
        return true
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view:View = inflater.inflate(R.layout.fragment_b, container, false)

        //Primary Weapon
        recyclerViewPrimary = view.findViewById(R.id.recycler_primary_weapon)
        var gridLayoutManagerPrimary:GridLayoutManager = GridLayoutManager(context,4,LinearLayoutManager.VERTICAL,false)
        recyclerViewPrimary.layoutManager = gridLayoutManagerPrimary
        recyclerViewPrimary.setHasFixedSize(true)
        primary_adapter = ItemAdapter(context!!,characterDetails.primaryweapon!!)
        recyclerViewPrimary?.adapter = primary_adapter


        //Special Weapon
        recyclerViewSpecial = view.findViewById(R.id.recycler_special_weapon)
        var gridLayoutManagerSpecial:GridLayoutManager = GridLayoutManager(context,4,LinearLayoutManager.VERTICAL,false)
        recyclerViewSpecial.layoutManager = gridLayoutManagerSpecial
        recyclerViewSpecial.setHasFixedSize(true)
        special_adapter = ItemAdapter(context!!,characterDetails.specialweapon!!)
        recyclerViewSpecial?.adapter = special_adapter

        //Heavy Weapon
        recyclerViewHeavy = view.findViewById(R.id.recycler_heavy_weapon)
        var gridLayoutManagerHeavy:GridLayoutManager = GridLayoutManager(context,4,LinearLayoutManager.VERTICAL,false)
        recyclerViewHeavy.layoutManager = gridLayoutManagerHeavy
        recyclerViewHeavy.setHasFixedSize(true)
        heavy_adapter = ItemAdapter(context!!,characterDetails.heavyweapon!!)
        recyclerViewHeavy?.adapter = heavy_adapter

        // Helmet

        recyclerViewHelmet= view.findViewById(R.id.recycler_helmets)
        var gridLayoutManagerHelmet:GridLayoutManager = GridLayoutManager(context,4,LinearLayoutManager.VERTICAL,false)
        recyclerViewHelmet.layoutManager = gridLayoutManagerHelmet
        recyclerViewHelmet.setHasFixedSize(true)
        helmet_adapter= ArmorAdapter(context!!,characterDetails.helmet!!)
        recyclerViewHelmet?.adapter = helmet_adapter

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