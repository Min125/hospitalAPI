package coder.mtk.typicoderetrofit

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import coder.mtk.typicoderetrofit.viewmodel.DetailViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_detail.*

class DetailFragment : Fragment() {

    lateinit var viewModel: DetailViewModel
    var id : String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var messagearg = arguments?.let {
            DetailFragmentArgs.fromBundle(it)
        }

         id = messagearg?.id
        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        Log.d("DetailFragmentArgs",id!!)

        viewModel.getDetail().observe(
            viewLifecycleOwner, Observer {
                hospitalNameDetail.text = it.hospital.hospital_name
                Picasso.get()
                    .load("http://hospitalguideapi.dsv.hoz.mybluehost.me"+it.hospital.hospital_image)
                    .into(hospitalImageDetail)
            }
        )
    }

    override fun onResume() {
        super.onResume()
        viewModel.loadDetail(id!!)
    }
}