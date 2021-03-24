package me.jiangwan.viewdome

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import jp.wasabeef.transformers.glide.CropCircleTransformation
import me.jiangwan.viewdome.databinding.FragmentBlankBinding



private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class BlankFragment : Fragment() {
    private val modelList3 = mutableListOf<Model3>()
    private val modelList = mutableListOf<Model>()
    private val modelList4 = mutableListOf<Model4>()
    private var param1: String? = null
    private var param2: String? = null
    private  var _binding2: FragmentBlankBinding?=null
    private val binding2 get() = _binding2!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ImageRoundedCorners()
        init3() //调用init方法添加Recyclerview的数据
        init()
        init2()
        Recyclerview3()
        Recyclerview1()
        Recyclerview2()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding2 = FragmentBlankBinding.inflate(inflater, container, false)
        return binding2.root
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BlankFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
    //ImageRoundedCorners方法，使图片切割圆形
    fun ImageRoundedCorners() {
        val myimage = binding2.userImageBlank
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
    private fun init3() {
        repeat(6) {
            modelList3.add(Model3((Color.rgb(68,63,62)),"Balance","3625 **** **** 5747","$1150,6"))
            modelList3.add(Model3((Color.rgb(223,73,124)),"Balance","3666 **** **** 5747","$0.02" ))
            modelList3.add(Model3((Color.rgb(3,169,244)),"Balance","3600 **** **** 5237","$1263398.5"))
            modelList3.add(Model3((Color.rgb(129,59,36)), "Balance","2825 **** **** 5742","$3.0"))
        }
    }
    //Recyclerview1方法 绑定设置RecyclerView
    private fun Recyclerview3() {
        val layoutManager = LinearLayoutManager(this.context)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        binding2.blankRecycler.layoutManager = layoutManager
        val adapter = RecyclerAdapter3(this.context, modelList3)
        binding2.blankRecycler.adapter = adapter
    }
    //Recyclerview1方法 绑定设置RecyclerView
    fun Recyclerview1() {
        val layoutManager = LinearLayoutManager(this.context)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        binding2.blankRecycler2.layoutManager = layoutManager
        val adapter = RecyclerAdapter(this.context, modelList)
        binding2.blankRecycler2.adapter = adapter
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
    fun Recyclerview2() {
        val layoutManager = LinearLayoutManager(this.context)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        binding2.blankRecycler3.layoutManager = layoutManager
        val adapter = RecyclerAdapter4(this.context, modelList4)
        binding2.blankRecycler3.adapter = adapter
    }
    private fun init2() {
        repeat(6) {
            modelList4.add(Model4(R.mipmap.ic_1, "Bills"))
            modelList4.add(Model4(R.mipmap.ic_2, "Phone"))
            modelList4.add(Model4(R.mipmap.ic_3, "Transfer"))
            modelList4.add(Model4(R.mipmap.ic_4, "Travel"))
            modelList4.add(Model4(R.mipmap.ic_5, "Dep"))
            modelList4.add(Model4(R.mipmap.ic_6, "ep"))
        }
    }
}