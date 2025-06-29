package com.enosads.meuprimeiroappandroid

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.enosads.meuprimeiroappandroid.databinding.FragmentBlankBinding

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
    private var _binding: FragmentBlankBinding? = null
    private val binding get() = _binding!!

    private var name: String? = null
    private var age: Int? = null
    private var isMale: Boolean? = null


    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("BlankFragment", "onDestroyView")
        _binding = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("BlankFragment", "onCreate")

        context?.let {
            Toast.makeText(it, "Fragment created", Toast.LENGTH_SHORT).show()
        }

        arguments?.let {
            name = it.getString(ARG_PARAM1)
            age = it.getInt(ARG_PARAM2)
            isMale = it.getBoolean(ARG_PARAM3)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.d("BlankFragment", "onCreateView")
        _binding = FragmentBlankBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("BlankFragment", "onViewCreated")
        binding.tvFragmentContent.text = getString(
            R.string.name_age_gender,
            name,
            age.toString(),
            if (isMale == true) getString(R.string.male) else getString(R.string.female)
        ).trimIndent()
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("BlankFragment", "onDestroy")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("BlankFragment", "onAttach")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d("BlankFragment", "onDetach")
    }

    override fun onStart() {
        super.onStart()
        Log.d("BlankFragment", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("BlankFragment", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("BlankFragment", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("BlankFragment", "onStop")
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        Log.d("BlankFragment", "onViewStateRestored")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d("BlankFragment", "onSaveInstanceState")
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