package com.wix.detoxinteractionutils

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.detoxinteractionutils.R
import com.example.detoxinteractionutils.databinding.FragmentNavBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class NavFragment : Fragment() {

    private var _binding: FragmentNavBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNavBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnNavFullVisibility.setOnClickListener {
            findNavController().navigate(R.id.action_NavFragment_to_FirstFragment)
        }

        binding.btnNavLocalObstruction.setOnClickListener {
            findNavController().navigate(R.id.action_NavFragment_to_FirstFragment, Bundle().apply { putString("obstruction", "local") })
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
