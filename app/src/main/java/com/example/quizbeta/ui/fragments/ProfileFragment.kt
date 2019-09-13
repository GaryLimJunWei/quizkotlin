package com.example.quizbeta.ui.fragments


import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.quizbeta.R
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment()
{

    private val REQUEST_IMAGE_CAPTURE = 100
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)

        profile_picture.setOnClickListener {
            takePictureIntent()
        }

    }

    private fun takePictureIntent()
    {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also {
            pictureIntent ->
            pictureIntent.resolveActivity(activity?.packageManager!!)?.also {
                startActivityForResult(pictureIntent,REQUEST_IMAGE_CAPTURE)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?)
    {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode==REQUEST_IMAGE_CAPTURE && resultCode == Activity.RESULT_OK)
        //IF REQUEST CODE IS EQUAL TO THE REQUEST_IMAGE_CAPTURE
        // AND ALSO TO ENSURE THAT THE PICTURE IS CAPTURE
        // THEN WE WILL CAPTURE THE IMAGE AND PUT IT INSIDE THE INTENT
        {
            val imageBitmap = data?.extras?.get("data") as Bitmap

            uploadImageAndSaveUri(imageBitmap)
        }

    }

    private fun uploadImageAndSaveUri(bitmap:Bitmap)
    {
        // Store inside local database ROOM
    }




}
