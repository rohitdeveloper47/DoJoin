package com.dashboard.dojoin

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ExpandableListView
import androidx.appcompat.app.AppCompatActivity
import com.dashboard.dojoin.Network.ApiClient.client
import com.dashboard.dojoin.Network.ApiInterface
import com.dashboard.dojoin.Network.SecondActivity
import com.dashboard.dojoin.adapter.ExpandableListAdapter
import com.dashboard.dojoin.data.Category
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    var listAdapter: ExpandableListAdapter? = null
    var expListView: ExpandableListView? = null
    var listDataHeader: ArrayList<String>? = null
    var categoryList:Category?=null
    var listDataChild: HashMap<String,List<String>>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showDialog()
        prepareListData()

        //listAdapter = ExpandableListAdapter(this, listDataHeader!!, listDataChild!!)
        //lvExp!!.setAdapter(listAdapter)
        lvExp!!.setOnGroupClickListener { parent, v, groupPosition, id ->

            false
        }

        lvExp!!.setOnGroupExpandListener { groupPosition ->
            //Toast.makeText( applicationContext,
                //listDataHeader!![groupPosition] + " Expanded",
                //Toast.LENGTH_SHORT
            //).show()
        }


        lvExp!!.setOnGroupCollapseListener { groupPosition ->
           // Toast.makeText(
             //   applicationContext,
               // listDataHeader!![groupPosition] + " Collapsed",
                //Toast.LENGTH_SHORT
            //).show()
        }

        lvExp!!.setOnChildClickListener { parent, v, groupPosition, childPosition, id ->

            val intent =  Intent(this, SecondActivity::class.java)
            startActivity(intent)
            //Toast.makeText(
              //  applicationContext,
                //listDataHeader!![groupPosition] + " : "
                        //+ listDataChild!![listDataHeader!![groupPosition]]!![childPosition],
               // Toast.LENGTH_SHORT
            //)
              //  .show()
            false
        }

    }
    private fun prepareListData() {
        val apiService =
            client!!.create(ApiInterface::class.java)
        val call: Call<Category?> = apiService.getCategory()!!
        call.enqueue(object : Callback<Category?> {
            override fun onFailure(call: Call<Category?>, t: Throwable) {
                hideDialog()
               // Log.d("ERROR","Response = "+t.toString())
            }

            override fun onResponse(call: Call<Category?>, response: Response<Category?>) {
                hideDialog()
                categoryList = response.body()
                listDataHeader = ArrayList<String>()
                listDataChild = HashMap()
                for (i in 0 until categoryList!!.getCategory()!!.size) {

                    listDataHeader!!.add(categoryList!!.getCategory()!![i].getTitle()!!)
                    //Log.d("RESULT Category",categoryList!!.getCategory()!![i].getTitle()!!)
                    val subCategory: MutableList<String> =
                        ArrayList()

                    for(j in 0 until categoryList!!.getCategory()!![i].getSubCategory()!!.size){

                        subCategory.add(categoryList!!.getCategory()!![i].getSubCategory()!![j]!!.getTitle()!!)
                        //Log.d("RESULT SubCategory",categoryList!!.getCategory()!![i].getSubCategory()!![j]!!.getTitle()!!)
                    }


                    listDataChild!![listDataHeader!![i]] = subCategory
                }
                listAdapter = ExpandableListAdapter(this@MainActivity, listDataHeader!!,listDataChild!!)
                lvExp!!.setAdapter(listAdapter)

            }


        })

    }
    private fun hideDialog(){

        progressBar.visibility = View.GONE

    }

    private fun showDialog(){

        progressBar.visibility = View.VISIBLE
    }
}