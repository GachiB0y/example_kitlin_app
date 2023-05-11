package com.example.exmaplekotlinapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import com.example.exmaplekotlinapp.databinding.ActivitySignUpInBinding

class SignUpInActivity : AppCompatActivity() {
    lateinit var bindingClass: ActivitySignUpInBinding
    private var  signState:String = "empty"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivitySignUpInBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)
        signState = intent.getStringExtra(Constance.SIGN__STATE)!!

        if(signState == Constance.SIGN_IN_STATE){

            bindingClass.edFName.visibility = View.GONE
            bindingClass.edSName.visibility = View.GONE
            bindingClass.edFemale.visibility = View.GONE
            bindingClass.bAvatar.visibility = View.INVISIBLE

        }




    }

    fun onClickDone(view: View){
        if(signState == Constance.SIGN_UP_STATE){
            val intent = Intent()
            intent.putExtra(Constance.LOGIN, bindingClass.edLogin.toString())
            intent.putExtra(Constance.PASSWORD, bindingClass.edPass.toString())
            intent.putExtra(Constance.NAME, bindingClass.edFName.toString())
            intent.putExtra(Constance.NAME2, bindingClass.edSName.toString())
            intent.putExtra(Constance.NAME3, bindingClass.edFemale.toString())
            if(bindingClass.avatar.isVisible)intent.putExtra(Constance.AVATAR_ID, R.drawable.cook)
            setResult(RESULT_OK,intent)
            finish()

        }else if (signState == Constance.SIGN_IN_STATE){
            intent.putExtra(Constance.LOGIN, bindingClass.edLogin.toString())
            intent.putExtra(Constance.PASSWORD, bindingClass.edPass.toString())
            setResult(RESULT_OK,intent)
            finish()
        }
    }

    fun onClickAvatar(view: View){
        bindingClass.avatar.visibility = View.VISIBLE
    }
}