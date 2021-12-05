package id.ac.ubaya.informatika.a160419013_vaccinecovid19.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import id.ac.ubaya.informatika.a160419013_vaccinecovid19.R
import id.ac.ubaya.informatika.a160419013_vaccinecovid19.databinding.FragmentQRCodeBinding
import kotlinx.android.synthetic.main.fragment_q_r_code.*

class QRCodeFragment : BottomSheetDialogFragment(), ButtonFinishQrCodeListener {
    private lateinit var dataBinding: FragmentQRCodeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_q_r_code, container, false)
        dataBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_q_r_code,container,false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataBinding.finish = this
        /*btnSelesai.setOnClickListener {
            dismiss()
        }*/
    }

    override fun onButtonFinishQrCodeListener(v: View) {
        dismiss()
    }
}