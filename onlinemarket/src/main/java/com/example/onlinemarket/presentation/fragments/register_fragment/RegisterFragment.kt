package com.example.onlinemarket.presentation.fragments.register_fragment

import android.Manifest
import android.app.Activity
import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.onlinemarket.R
import com.example.onlinemarket.databinding.FragmentRegisterBinding
import com.example.onlinemarket.domain.models.Image
import com.example.onlinemarket.presentation.RootActivity
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.button.MaterialButton
import com.google.android.material.card.MaterialCardView
import com.parse.ParseFile
import com.parse.SaveCallback
import com.squareup.picasso.Picasso
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.io.ByteArrayOutputStream

class RegisterFragment : Fragment() {

    private val binding by lazy {
        FragmentRegisterBinding.inflate(layoutInflater)
    }
    private var cameraUri: Uri? = null
    private var imageUri: Uri? = null
    private var pickImageIntent: Intent? = null
    private var selectImage: Bitmap? = null
    private var imageFile: ParseFile? = null
    private val values: ContentValues by lazy {
        ContentValues()
    }

    private val viewModel by viewModel<RegisterFragmentViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (!hasPermissions(requireContext(), *PERMISSIONS)) {
            ActivityCompat.requestPermissions(requireActivity(), PERMISSIONS, 1)
        }
        observe()
        setClickers()
    }

    private fun observe() {
        viewModel.userResponse.observe(viewLifecycleOwner) {
            openRootActivity()
        }
    }

    private fun setClickers() {
        binding.profileImageCardView.setOnClickListener {
            openBottomSheet()
        }

        binding.registerBtn.setOnClickListener {
            registerUser()
        }
        binding.loginText.setOnClickListener {
            openLoginFragment()
        }
    }

    private fun openLoginFragment() {
        findNavController().navigate(
            RegisterFragmentDirections.actionRegisterFragmentToLoginFragment()
        )
    }

    private fun openRootActivity() {
        startActivity(Intent(requireContext(), RootActivity::class.java))
        requireActivity().finish()
    }

    private fun openBottomSheet() {
        val dialog = BottomSheetDialog(requireContext())
        dialog.setContentView(R.layout.bottom_sheet_dialog)
        val cancel = dialog.findViewById<MaterialButton>(R.id.cancel_button)
        val takePicture = dialog.findViewById<MaterialCardView>(R.id.take_picture_card)
        val pickGallery = dialog.findViewById<MaterialCardView>(R.id.pick_gallery_card)
        cancel?.setOnClickListener {
            dialog.dismiss()
        }
        takePicture?.setOnClickListener {
            takePicture()
            dialog.dismiss()
        }

        pickGallery?.setOnClickListener {
            pickFromGallery()
            dialog.dismiss()
        }
        dialog.setCancelable(true)
        dialog.show()

    }


    private fun uploadImage() {
        val steam = ByteArrayOutputStream()
        selectImage = MediaStore.Images.Media.getBitmap(requireActivity().contentResolver, imageUri)
        selectImage?.compress(Bitmap.CompressFormat.PNG, 100, steam)
        val byteArray = steam.toByteArray()
        val parseFile = ParseFile("image.png", byteArray)
        parseFile.saveInBackground(
            SaveCallback { e ->
                if (e == null) {
                    showToast("Image uploaded!")
                    imageFile = parseFile
                } else {
                    showToast("Не удалось загрузить файл!")
                }
            }
        )
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == REQUEST_CODE) {
            imageUri = cameraUri
            getImage()
        }
        if (resultCode == Activity.RESULT_OK && requestCode == IMAGE_PICK_CODE && data != null) {
            imageUri = data.data
            getImage()
        }
    }

    private fun registerUser() {

        binding.apply {
            if (userPassword.text.toString() == userPasswordReset.text.toString()) {
                viewModel.register(
                    userNameEt.text.toString(),
                    userEmailEt.text.toString(),
                    userLoginEt.text.toString(),
                    userPassword.text.toString(),
                    userAvatar = parseFileToImage(imageFile!!)
                )
            } else {
                showToast("Error password")
            }

        }

    }

    private fun parseFileToImage(file: ParseFile): Image {
        return Image(name = file.name, imageUrl = file.url)
    }

    private fun getImage() {
        if (imageUri != null) {
            Picasso.get().load(imageUri).into(binding.profileImage)
            uploadImage()
        }
    }

    private fun pickFromGallery() {
        pickImageIntent = Intent(
            Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI
        )
        pickImageIntent?.type = "image/*"
        pickImageIntent?.putExtra(Intent.EXTRA_MIME_TYPES, MIME_TYPES)
        pickImageIntent?.let {
            startActivityForResult(it, IMAGE_PICK_CODE)
        }
    }

    private fun takePicture() {
        values.put(MediaStore.Images.Media.TITLE, "MyPicture")
        values.put(
            MediaStore.Images.Media.DESCRIPTION,
            "photo taken from ${System.currentTimeMillis()}"
        )
        cameraUri = requireContext().contentResolver.insert(
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values
        )
        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, cameraUri)
        startActivityForResult(cameraIntent, REQUEST_CODE)
    }

    private fun hasPermissions(context: Context, vararg permissions: String): Boolean =
        permissions.all {
            ActivityCompat.checkSelfPermission(
                context,
                it
            ) == PackageManager.PERMISSION_GRANTED
        }


    private fun showToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    companion object {
        const val REQUEST_CODE = 200
        const val IMAGE_PICK_CODE = 100
        val PERMISSIONS = arrayOf(
            Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA
        )
        val MIME_TYPES = arrayOf("image/jpeg", "image/png")
    }

}