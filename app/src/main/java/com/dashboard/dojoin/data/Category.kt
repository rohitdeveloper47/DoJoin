package com.dashboard.dojoin.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Category {

    @SerializedName("result")
    @Expose
    private var result:ArrayList<CategoryList>?=null

    fun setCategory(result: ArrayList<CategoryList>){
        this.result = result

    }

    fun getCategory():ArrayList<CategoryList>?{
        return result
    }
    class CategoryList{

        @SerializedName("id")
        @Expose
        private var id:String?=null
        @SerializedName("title")
        @Expose
        private var title:String?=null
        @SerializedName("subCategories")
        @Expose
        private var sub_category:ArrayList<SubCategory>?=null

        fun setId(id:String?){

            this.id = id
        }
        fun getId():String?{

            return id
        }

        fun setTitle(title:String?){
            this.title=title
        }
        fun getTitle():String?{
            return title
        }

        fun setSubCategory(sub_category:ArrayList<SubCategory>?){
            this.sub_category=sub_category
        }

        fun getSubCategory():ArrayList<SubCategory>?{
            return sub_category
        }
        class SubCategory{

            @SerializedName("id")
            @Expose
            private var id:String?=null
            @SerializedName("title")
            @Expose
            private var title:String?=null
            fun setId(id:String?){

                this.id = id
            }
            fun getId():String?{

                return id
            }

            fun setTitle(title:String?){
                this.title=title
            }
            fun getTitle():String?{
                return title
            }


        }

    }



}