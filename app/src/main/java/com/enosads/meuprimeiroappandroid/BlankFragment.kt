package com.enosads.meuprimeiroappandroid

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "name"
private const val ARG_PARAM2 = "age"
private const val ARG_PARAM3 = "isMale"

/**
 * A simple [Fragment] subclass.
 * Use the [BlankFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BlankFragment : Fragment() {
    private var param1: String? = null
    private var param2: Int? = null
    private var param3: Boolean? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getInt(ARG_PARAM2)
            param3 = it.getBoolean(ARG_PARAM3)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val tvFragmentContent = view.findViewById<TextView>(R.id.tvFragmentContent)
        tvFragmentContent.text = """
            Name: $param1
            Age: $param2
            Sexo: ${if (param3 == true) "Masculino" else "Feminino"}
            """.trimIndent()
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param name Parameter 1.
         * @param age Parameter 2.
         * @param isMale Parameter 3.
         * @return A new instance of fragment BlankFragment.
         */
        @JvmStatic
        fun newInstance(name: String, age: Int, isMale: Boolean) =
            BlankFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, name)
                    putInt(ARG_PARAM2, age)
                    putBoolean(ARG_PARAM3, isMale)
                }
            }
    }
}