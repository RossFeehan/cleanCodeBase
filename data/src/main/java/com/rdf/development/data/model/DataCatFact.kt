package com.rdf.development.data.model

import com.google.gson.annotations.SerializedName


data  class DataCatFact(@SerializedName("_id") val id: String,
                        @SerializedName("text") val fact: String) {
}