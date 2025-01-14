package com.example.instagramclone

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class Signup : AppCompatActivity() {

    val binding by com.example.instagramclone.databinding.ActivitySignupBinding.lazy {
        ActivitySignupBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.singUpBtn.setOnClickListener {
            if (binding.name.editText?.text.toString().equals("") or
                binding.email.editText?.text.toString().equals("") or
                binding.password.editText?.text.toString().equals("")
            ) {
                Toast.makeText(this@Signup, "Please fill all the fields", Toast.LENGTH_SHORT).show()

            } else {

                FirebaseAuth.getInstance().createUserWithEmailAndPassword(
                    binding.email.editText?.text.toString(),
                    binding.password.editText?.text.toString()
                ).addOnCompleteListener {
                    if (it.isSuccessful) {
                        Toast.makeText(this@Signup, "Successfully Registered", Toast.LENGTH_SHORT)
                            .show()
                    }else{
                        Toast.makeText(this@Signup, result.exception?.localizedMessage, Toast.LENGTH_SHORT)
                            .show()
                    }

                }
            }
        }
    }
}