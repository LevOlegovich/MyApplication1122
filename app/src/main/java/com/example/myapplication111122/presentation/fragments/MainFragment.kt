package com.example.myapplication111122.presentation.fragments

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.myapplication111122.R
import com.example.myapplication111122.data.models.CategoriesModel
import com.example.myapplication111122.data.models.FilterModel
import com.example.myapplication111122.data.models.TablayoutData
import com.example.myapplication111122.databinding.FragmentMainBinding
import com.example.myapplication111122.presentation.adapters.TablayoutAdapter
import com.example.myapplication111122.presentation.viewmodel.MainViewModel
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding: FragmentMainBinding
        get() = _binding ?: throw RuntimeException("FragmentEmptyBinding is null")
    private val viewModel by viewModels<MainViewModel>()
    private var filter: FilterModel? = null


    lateinit var filterDialog: FilterBottomSheetDialog

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val categoriesList = TablayoutData.categoriesList
        Log.d("MainFragment", categoriesList.toString())
        initPager(categoriesList)
//        initBottomBar()
        viewModel.filterLiveData.observe(viewLifecycleOwner) {
            filter = it

        }

        binding.filterImage.setOnClickListener {
            filterShow()
        }
    }


    private fun filterShow() {
        filterDialog = FilterBottomSheetDialog()

        filterDialog.show(childFragmentManager, "Filtersdialog")

    }

    private fun initPager(categoriesList: List<CategoriesModel>) {


        binding.viewPager.adapter = TablayoutAdapter(categoriesList, requireActivity())
        //  binding.tabLayout.tabIconTint = null

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->


            val view = layoutInflater.inflate(R.layout.item_category, null, false)
            view.findViewById<ImageView>(R.id.tabIV)
                .setImageResource(categoriesList[position].image)
            view.findViewById<TextView>(R.id.tabTV).text = categoriesList[position].name

            tab.apply {
                customView = view
                if (position == 0) {

                    customView?.apply {
                        findViewById<ImageView>(R.id.tabLayoutCircle).setColorFilter(
                            ContextCompat.getColor(
                                requireContext(),
                                R.color.orange
                            )


                        )
                        findViewById<TextView>(R.id.tabTV).setTextColor(Color.parseColor("#FF6E4E"))
                        findViewById<ImageView>(R.id.tabIV).setColorFilter(
                            ContextCompat.getColor(
                                requireContext(),
                                R.color.white
                            )
                        )
                    }
                }
            }


        }.attach()


        binding.tabLayout.addOnTabSelectedListener(object :
            TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.customView?.apply {
                    findViewById<ImageView>(R.id.tabLayoutCircle).setColorFilter(
                        ContextCompat.getColor(
                            requireContext(),
                            R.color.orange
                        )
                    )
                    findViewById<TextView>(R.id.tabTV).setTextColor(Color.parseColor("#FF6E4E"))
                    findViewById<ImageView>(R.id.tabIV).setColorFilter(
                        ContextCompat.getColor(
                            requireContext(),
                            R.color.white
                        )
                    )
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                tab?.customView?.apply {
                    findViewById<ImageView>(R.id.tabLayoutCircle)
                        ?.setColorFilter(
                            ContextCompat.getColor(
                                requireContext(),
                                R.color.white
                            )
                        )
                    findViewById<TextView>(R.id.tabTV)
                        ?.setTextColor(Color.parseColor("#B3B3C3"))
                    findViewById<ImageView>(R.id.tabIV)
                        ?.setColorFilter(
                            ContextCompat.getColor(
                                requireContext(),
                                R.color.tab_layout_icon_color
                            )
                        )
                }
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })

        binding.viewPager.isUserInputEnabled = false // выключение скрола свайпом
    }


}