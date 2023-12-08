package com.ahmetozaydin.ecommerceapp.fragment

import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.SearchView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ahmetozaydin.ecommerceapp.adapter.CategoryAdapter
import com.ahmetozaydin.ecommerceapp.adapter.ProductsAdapter
import com.ahmetozaydin.ecommerceapp.databinding.FragmentHomeBinding
import com.ahmetozaydin.ecommerceapp.model.Product
import com.ahmetozaydin.ecommerceapp.view.MainActivity2
import com.ahmetozaydin.ecommerceapp.viewmodel.HomeViewModel
import java.util.*


class HomeFragment : Fragment(), ProductsAdapter.Listener, CategoryAdapter.Listener {
    private var isDone: Boolean = false
    private lateinit var viewModel: HomeViewModel
    private lateinit var binding: FragmentHomeBinding
    private var matchedProduct: ArrayList<Product> = arrayListOf()
    private var products = ArrayList<Product>()
    private lateinit var productsAdapter: ProductsAdapter
    private var filter: String? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        val layoutManager = GridLayoutManager(activity, 2)// oluyorsa layout managerları birleştir.
        this.filter = arguments?.getString("inputKey")
        binding.recyclerView.layoutManager = layoutManager
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        //viewModel.getDataFromUrl()
        println("onViewCreated: $filter")
        viewModel.getData(requireContext(), filter!!)
        viewModel.products.observe(viewLifecycleOwner, androidx.lifecycle.Observer { products ->
            products.let {
                productsAdapter = products?.let { it1 ->
                    ProductsAdapter(
                        it1,
                        requireContext() // TODO Fragment HomeFragment not attached to a context.
                    )
                }!!
                binding.recyclerView.adapter = productsAdapter
            }

        })

        var state = 1

        binding.recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                state = newState
            }

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (dy > 0 && (state == 0 || state == 2)) {
                    binding.collapsingToolBarLayout.visibility = View.GONE

                } else if (dy < -10) {
                    binding.collapsingToolBarLayout.visibility = View.VISIBLE
                }
            }
        })

    }


    override fun onItemClick(products: Product) {
        Toast.makeText(activity, "item is clicked", Toast.LENGTH_SHORT).show()
    }

    /* override fun onResume() {
         super.onResume()
         binding.recyclerViewCategories.adapter = categoryAdapter;

     }*/
    override fun categoryButtonClicked(
        products: ArrayList<Product>,
        holder: CategoryAdapter.PlaceHolder,
        position: Int
    ) {
        products.forEach {
            if (it.category == products[position].category) {
                println(it.category)
            }
        }
    }

    fun search(text: String?) { //alternative to it filter(),guava(). make inside viewModel
        matchedProduct = arrayListOf()
        text?.let {
            products.forEach { product ->
                if ((product.title?.contains(text, true) == true) ||
                    product.description.toString().contains(text, true) ||
                    product.category.toString().contains(text, true) ||
                    product.brand.toString().contains(text, true)
                ) {
                    matchedProduct.add(product)
                }
            }
            updateRecyclerView()
            if (matchedProduct.isEmpty()) {
                binding.linearLayoutEmptySearchMessage.visibility = View.VISIBLE

            } else {
                binding.linearLayoutEmptySearchMessage.visibility = View.INVISIBLE
            }
            updateRecyclerView()
        }
    }

    private fun updateRecyclerView() {
        binding.recyclerView.apply {
            productsAdapter = ProductsAdapter(
                matchedProduct,
                requireContext()
            )
            binding.recyclerView.adapter = productsAdapter
            // productsAdapter!!.notifyDataSetChanged()
        }
    }
}