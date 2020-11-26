package com.example.companionapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.companionapp.Character
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

        view.CharacterClassText.text = characterDetails.characterclass
        view.powerText.text = characterDetails.power.toString()
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
        fun newInstance(character:Character): FragmentB {
            val fragment = FragmentB()
            val args = Bundle()
            args.putParcelable(CHAR_DETAILS , character )
            fragment.arguments = args
            return fragment
        }
    }
}