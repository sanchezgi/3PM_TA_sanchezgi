package com.example.companionapp.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.TextView
import com.example.companionapp.*
import kotlinx.android.synthetic.main.fragment_a.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val CHAR_ARRAY = "charArray"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentA.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentA : Fragment() {
    // TODO: Rename and change types of parameters
    private lateinit var characters: Array<Character>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null){
             characters = arguments?.getParcelableArray(CHAR_ARRAY) as Array<Character>

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view:View = inflater.inflate(R.layout.fragment_a, container, false)
        var list1 = view.findViewById<ListView>(R.id.list)

        list1.setOnItemClickListener{parent,view,position,id->
            val fragmentB = FragmentB.newInstance(characters[position])
            val transaction = activity?.supportFragmentManager?.beginTransaction()
            transaction?.replace(R.id.frame_layout, fragmentB)
            transaction?.addToBackStack(null)
            transaction?.commit()
        }

        val adapter = CharacterAdapter(context!!,characters)
        list1.adapter = adapter

        return list1.parent as View
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FragmentA.
         */
        // TODO: Rename and change types and number of parameters

        /*fun newInstance(param1: String, param2: String) =
            FragmentA().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }*/
        @JvmStatic
        fun newInstance(character: Array<Character>): FragmentA {
            val fragment = FragmentA()
            val args = Bundle()
            args.putParcelableArray(CHAR_ARRAY , character as Array<out Parcelable>)
            fragment.arguments = args
            return fragment
        }
    }
}