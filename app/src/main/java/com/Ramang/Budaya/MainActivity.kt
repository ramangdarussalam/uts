package com.Ramang.Budaya

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var data: ArrayList<DataModel>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val actionbar = supportActionBar
        //set actionbar title
        actionbar!!.title = "Adat Minang"
        //set back button
        actionbar.setDisplayHomeAsUpEnabled(true)

        //Inisialisasi Array
        data = ArrayList()


        //Simpan data

        data?.add(DataModel(R.drawable.membeli,"membeli","","Gadis Minang yang sudah berumur cukup untuk menikah dan mau melangsungkan pernikahan, harus membeli calon pasangannya dengan harga yang disepakati oleh keluarga calon suaminya. "+
                "Keluarga mempelai wanita juga harus berbesar hati untuk membiayai seluruh keperluan dalam prosesi pernikahan. "+
                "Adat seperti ini masih dipegang teguh oleh masyarakat Minangkabau khususnya Padang Pariaman."))

        data?.add(DataModel(R.drawable.jual,"jual","", "Ukuran harga dari calon pengantin laki-laki adalah tingkat pendidikannya. "+
                "Jika dia hanya lulusan SMA, maka harga jualnya akan berbeda dengan laki-laki yang lulusan S2. "+
                "Kesepakatan harga untuk uang \"japuik\" atau uang jemput yang diberikan keluarga mempelai wanita bisa disesuaikan juga dengan tingkat ekonominya."))

        data?.add(DataModel(R.drawable.panjang,"panjang","", "Prosesi pernikahan menggunakan adat Minang tergolong \"ribet\". Walau demikian, hal ini menunjukkan adat Minang sangat kaya akan adat istiadatnya. "+
                "Dan tentu saja pada setiap prosesi dalam pernikahan adat Minang memiliki makna yang dalam bagi para mempelai."))

        data?.add(DataModel(R.drawable.warisanperempuan,"warisanperempuan","", "Harta warisan dari keluarga Minang hanya jatuh ke anak perempuan saja. "+
                "Anak laki-laki tidak berhak mendapatkan warisan dari orang tuanya. "+
                "Jika sebuah keluarga Minang tidak memiliki anak perempuan, yang berhak menerima warisan adalah keponakan perempuan dari adik atau kakak perempuan. "+
                "Tujuan utama dari tradisi ini adalah, menuntut pria Minang untuk mandiri secara finansial dan tidak bergantung pada orangtuanya."))

        data?.add(DataModel(R.drawable.garis,"garis","", "Masyarakat Minangkabau menganut Matrilineal atau garis keturunan ibu. "+
                "Misalnya seorang pria Minang memiliki suku Guci lalu menikah dengan seorang wanita Minang bersuku Tanjung, maka seluruh anaknya adalah suku Tanjung. "+
                "Karena menganut Matrilineal, tak heran keluarga Minang sangat mendambakan kehadiran anak perempuan dalam pernikahannya."))

        data?.add(DataModel(R.drawable.mirip,"mirip","", "Jika setelah menikah dan memiliki anak laki-laki yang mirip dengan ayahnya, keluarga Minang akan menjual anak laki-lakinya yang masih bayi kepada saudaranya yang belum memiliki keturunan. "+
                "Sebenarnya, istilah \"jual\" di sini hanya sebuah simbolis, dan tidak benar-benar dijual."))



        //Set data to Adapter
        recyclerview.adapter = DataAdapter(data, object : DataAdapter.OnClickListener{
            override fun detail(item: DataModel?) {
                val intent = Intent(this@MainActivity, DetailActivity::class.java)
                intent.putExtra("gambar", item?.gambar)
                intent.putExtra("nama", item?.nama)
                intent.putExtra("harga", item?.harga)
                intent.putExtra("keterangan", item?.keterangan)
                startActivity(intent)
            }

        })


    }
}