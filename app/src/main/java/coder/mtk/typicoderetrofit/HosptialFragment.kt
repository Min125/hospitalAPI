package coder.mtk.typicoderetrofit

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import coder.mtk.typicoderetrofit.Adapter.HospitalAdapter
import coder.mtk.typicoderetrofit.model.HospitalX
import coder.mtk.typicoderetrofit.viewmodel.HospitalViewModel
import kotlinx.android.synthetic.main.fragment_hosptial.*


class HosptialFragment : Fragment(),HospitalAdapter.ClickListener{

    lateinit var viewmodel : HospitalViewModel
    lateinit var hospitalAdapter: HospitalAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hosptial, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewmodel = ViewModelProvider(this).get(HospitalViewModel::class.java)

        hospitalAdapter = HospitalAdapter()

        recyclerviewHospital.layoutManager = LinearLayoutManager(context)
        recyclerviewHospital.adapter = hospitalAdapter

        viewmodel.getHospital().observe(
            viewLifecycleOwner, Observer {
                hospitalAdapter.addHospitalItem(it.hospitals)
            }
        )
        hospitalAdapter.setOnClickListener(this)

    }

    override fun onResume() {
        super.onResume()
        viewmodel.loadHospital()
    }

    override fun onClick(hospitalx: HospitalX) {
        var action = HosptialFragmentDirections.actionHosptialFragmentToDetailFragment(hospitalx.hospital_id.toString())
        findNavController().navigate(action)
    }
}