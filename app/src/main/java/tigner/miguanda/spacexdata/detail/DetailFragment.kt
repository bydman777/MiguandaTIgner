package tigner.miguanda.spacexdata.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.appbar.CollapsingToolbarLayout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import tigner.miguanda.spacexdata.R
import tigner.miguanda.spacexdata.data.model.Launch
import tigner.miguanda.spacexdata.databinding.FragmentItemDetailBinding
import timber.log.Timber

/**
 * A fragment representing a single Item detail screen.
 * This fragment is either contained in a [HomeFragment]
 * in two-pane mode (on larger screen devices) or self-contained
 * on handsets.
 */
@AndroidEntryPoint
class DetailFragment : Fragment() {


    private val viewModel:DetailViewModel by viewModels()
    lateinit var itemDetailTextView: TextView
    private var toolbarLayout: Toolbar? = null

    private var _binding: FragmentItemDetailBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            if (it.containsKey(ARG_ITEM_ID)) {
                   viewModel.getLaunchData(  it.getInt(ARG_ITEM_ID))
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentItemDetailBinding.inflate(inflater, container, false)
        val rootView = binding.root


        itemDetailTextView = binding.itemDetail
        binding.actionBack?.setOnClickListener {
            //TODO This method does not work and needs to be changed but I'm already behind schedule...
            findNavController().navigateUp()
        }

        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
    }

    private fun setupObservers() {

        viewModel.launch.observe(viewLifecycleOwner){ launch ->
            launch?.let {
                updateContent(it)
            }
        }

        viewModel.errorMessage.observe(viewLifecycleOwner){message->
            message?.let{
                if(message.isNotBlank()) {
                    Snackbar.make(binding.itemDetailContainer, message, Toast.LENGTH_LONG).show()
                    viewModel.messageShown()
                }
            }
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        arguments?.getInt(ARG_ITEM_ID)?.let { outState.putInt(ARG_ITEM_ID, it) }
    }
    private fun updateContent(launch: Launch) {
        binding.titleText?.text =  launch.mission_name

        itemDetailTextView.text = Gson().toJson(launch)

    }

    companion object {
        /**
         * The fragment argument representing the item ID that this fragment
         * represents.
         */
        const val ARG_ITEM_ID = "item_id"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}