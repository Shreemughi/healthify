package com.example.healthify.ui.gallery

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.healthify.MainActivity2
import com.example.healthify.databinding.FragmentGalleryBinding

class GalleryFragment : Fragment() {

    private var _binding: FragmentGalleryBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val galleryViewModel =
            ViewModelProvider(this).get(GalleryViewModel::class.java)

        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        val root: View = binding.root

        //Access the views through the binding object
        val cardView1: CardView = binding.cardview1
        val cardView2: CardView = binding.cardview2
        val cardView3: CardView = binding.cardview3
        val button: Button = binding.button

        //Add the correct functionality to the views
        cardView1.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://www.amazon.in/Seer-Secrets-Ayurvedic-%E2%94%82Microwaveable-Relieving/dp/B076G14F52?dib=eyJ2IjoiMSJ9.Gb3fSfaSjD33OjB_sXuQXykSUnYKXULdEw4Bte3iZwmogs7TkCjUxG-Vy7k1it_nHakb4xrIJ7E3ouA8yjtNSOH9Mf2Y9NDJ9eOyJj-tajmCp8OCycPhcj-LVmg4nUXQ4Ii26k_dBLBOkZwaV6UrOL2RC8DRx12eLoRs448m940Bz_snUOJCY4L8EnppP0n-q02yD_F2wb7VEGDM-aWO9w8unHNLy4UI4VcGZVPH1dI6rAGJBw_SMZGUO_Y678mkp_EHzrksICcYniKtVFC_0Y43h0Qq77R-FeymzAbj-Mh7QEXOp_DjccKzcvurR1RpAp84xEB3uj0tbis9yMcA3SWFFxNSTcpRBOGyDqbNX-SdKoIH9PUGSMbjFzbLu_vYAmH6TX76-BaEEKaISpvVfqgH2Rq21rUQlmxeuWIND85q6G6jMWWLS1oQV0YNbbKe.IpYKbWOEBkv9MNSepRyFYfG8vn43eVB0Cm1HmrRLhrs&dib_tag=se&keywords=naturopathy%2Bproducts&qid=1741430031&sr=8-29&th=1")
            startActivity(intent)
        }

        cardView2.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://www.amazon.in/Dr-RELAXI-DR_RELAXI_40_CAP-Dr-Relaxi_40_Cap_shet_1/dp/B0BMVF5J7C?dib=eyJ2IjoiMSJ9.Gb3fSfaSjD33OjB_sXuQXykSUnYKXULdEw4Bte3iZwmogs7TkCjUxG-Vy7k1it_nHakb4xrIJ7E3ouA8yjtNSOH9Mf2Y9NDJ9eOyJj-tajmCp8OCycPhcj-LVmg4nUXQ4Ii26k_dBLBOkZwaV6UrOL2RC8DRx12eLoRs448m940Bz_snUOJCY4L8EnppP0n-q02yD_F2wb7VEGDM-aWO9w8unHNLy4UI4VcGZVPH1dI6rAGJBw_SMZGUO_Y678mkp_EHzrksICcYniKtVFC_0Y43h0Qq77R-FeymzAbj-Mh7QEXOp_DjccKzcvurR1RpAp84xEB3uj0tbis9yMcA3SWFFxNSTcpRBOGyDqbNX-SdKoIH9PUGSMbjFzbLu_vYAmH6TX76-BaEEKaISpvVfqgH2Rq21rUQlmxeuWIND85q6G6jMWWLS1oQV0YNbbKe.IpYKbWOEBkv9MNSepRyFYfG8vn43eVB0Cm1HmrRLhrs&dib_tag=se&keywords=naturopathy+products&qid=1741430031&sr=8-30")
            startActivity(intent)
        }

        cardView3.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://www.amazon.in/Elecious-Shikakai-Natural-cleanser-luxirious/dp/B09J54WH17?source=ps-sl-shoppingads-lpcontext&ref_=fplfs&smid=A15APWRK6P7LBV&gQT=1&th=1")
            startActivity(intent)
        }

        button.setOnClickListener{
            val intent = Intent(activity, MainActivity2::class.java)
            startActivity(intent)
        }
        return root

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}