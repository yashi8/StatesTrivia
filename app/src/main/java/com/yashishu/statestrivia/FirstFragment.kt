package com.yashishu.statestrivia

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.yashishu.statestrivia.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvStateList.let{
            it.layoutManager=LinearLayoutManager(context)
            it.adapter=StateAdapter(Util.generate()){ pos->
              val dir = FirstFragmentDirections.actionFirstFragmentToSecondFragment(pos)
                findNavController().navigate(dir)
            }
            it.setHasFixedSize(true) //for better performance
        }
    }

    private fun showTrivia(state: State) {
AlertDialog.Builder(requireActivity())
    .setTitle(state.name)
    .setMessage("No Infomation Available")
    .setPositiveButton("Ok"){
        dialog,_ -> dialog.dismiss()
    }
    .show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}