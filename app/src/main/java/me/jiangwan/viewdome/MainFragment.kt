package me.jiangwan.viewdome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import jp.wasabeef.transformers.glide.CropCircleTransformation
import me.jiangwan.viewdome.databinding.FragmentMainBinding



private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class MainFragment : Fragment() {
    private val modelList = mutableListOf<Model>()
    private val modelList2 = mutableListOf<Model2>()

    private var param1: String? = null
    private var param2: String? = null
    private  var _binding: FragmentMainBinding?=null
    private val binding get() = _binding!!



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val let = arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }




    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        init() //调用init方法添加Recyclerview的数据
        init2()//调用init2方法添加Recyclerview的数据
        Recyclerview1()//调用Recyclerview1方法 绑定设置RecyclerView
        Recyclerview2()//调用Recyclerview2方法 绑定设置RecyclerView2
        ImageRoundedCorners()//调用ImageRoundedCorners方法，使图片切割圆形
        //绑定viewbinding布局

        return binding.root
    }

        override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



    companion object {


        @JvmStatic
        fun newInstance(param1: String, param2: String) = MainFragment().apply {
            arguments = Bundle().apply {
                putString(ARG_PARAM1, param1)
                putString(ARG_PARAM2, param2)
            }
        }
    }


    private fun init2() {
        repeat(6) {
            modelList2.add(Model2(R.mipmap.ic_qiandai, "Bills"))
            modelList2.add(Model2(R.mipmap.ic_phone, "Phone"))
            modelList2.add(Model2(R.mipmap.ic_taiji, "Transfer"))
            modelList2.add(Model2(R.mipmap.ic_d, "Travel"))
            modelList2.add(Model2(R.mipmap.ic_e, "Dep"))

        }
    }

    //init方法添加Recyclerview的数据
    private fun init() {
        repeat(6) {
            modelList.add(Model(R.mipmap.ic_a, "Bills"))
            modelList.add(Model(R.mipmap.ic_b, "Phone"))
            modelList.add(Model(R.mipmap.ic_c, "Transfer"))
            modelList.add(Model(R.mipmap.ic_d, "Travel"))
            modelList.add(Model(R.mipmap.ic_e, "Dep"))
        }
    }

    //ImageRoundedCorners方法，使图片切割圆形
    fun ImageRoundedCorners() {
        val myimage = binding.userImage
        myimage.let {
            Glide.with(this)
                .load("http://q1.qlogo.cn/g?b=qq&nk=1298178043&s=640")
                .apply(
                    RequestOptions.bitmapTransform(
                        CropCircleTransformation()
                    )
                ).into(it)
        }



    }

    //Recyclerview1方法 绑定设置RecyclerView
    fun Recyclerview1() {
        val layoutManager = LinearLayoutManager(this.context)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        binding.recyclerView.layoutManager = layoutManager
        val adapter = RecyclerAdapter(this.context, modelList)
        binding.recyclerView.adapter = adapter
    }



    fun Recyclerview2() {
        val layoutManager2 = LinearLayoutManager(this.context)
        layoutManager2.orientation = LinearLayoutManager.VERTICAL
        binding.recyclerView2.layoutManager = layoutManager2
        val adapter2 = RecyclerAdapter2(this.context, modelList2)
        binding.recyclerView2.adapter = adapter2
    }

}