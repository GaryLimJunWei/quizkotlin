package com.example.quizbeta.ui.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.quizbeta.R
import kotlinx.android.synthetic.main.fragment_manage_test.*


class ManageTestFragment : Fragment()
{

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_manage_test, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)

        ProgrammingAndFrameWorkBtn.setOnClickListener {
            val action = ManageTestFragmentDirections.actionManageTestFragmentToProgrammingFrameworkFragment()
            Navigation.findNavController(it).navigate(action)
        }

    }


}
