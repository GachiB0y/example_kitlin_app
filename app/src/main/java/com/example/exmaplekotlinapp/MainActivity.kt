package com.example.exmaplekotlinapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult
import androidx.core.view.isVisible
import com.example.exmaplekotlinapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var launcherSignIn: ActivityResultLauncher<Intent>? = null
    private var launcherSignUp: ActivityResultLauncher<Intent>? = null
    lateinit var bindingClass: ActivityMainBinding
    private var login: String = "empty"
    private var password: String = "empty"
    private var name: String = "empty"
    private var name2: String = "empty"
    private var name3: String = "empty"
    private var avatarImageId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)
        launcherSignIn = registerForActivityResult(StartActivityForResult()) { result ->
            if(result.resultCode == RESULT_OK){
                val  l = result.data?.getStringExtra(Constance.LOGIN)
                val  p = result.data?.getStringExtra(Constance.PASSWORD)
                if(login == l && password == p){
                    val textInfo = "$name $name2 $name3"
                    bindingClass.tvInfo.text = textInfo
                    bindingClass.imAvatar.visibility = View.VISIBLE
                    bindingClass.imAvatar.setImageResource(avatarImageId)
                    bindingClass.bExit.visibility = View.GONE
                    bindingClass.bSign.text = "Выйти"
                } else {
                    bindingClass.tvInfo.text = "Такого аккаунта не существуцет!"
                }
            }
        }

        launcherSignUp = registerForActivityResult(StartActivityForResult()) { result ->
            if(result.resultCode == RESULT_OK){
                val  l = result.data?.getStringExtra(Constance.LOGIN)
                val  p = result.data?.getStringExtra(Constance.PASSWORD)
                if(login == l && password == p){
                    val textInfo = "$name $name2 $name3"
                    bindingClass.tvInfo.text = textInfo
                    bindingClass.imAvatar.visibility = View.VISIBLE
                    bindingClass.imAvatar.setImageResource(avatarImageId)
                    bindingClass.bExit.visibility = View.GONE
                    bindingClass.bSign.text = "Выйти"
                } else {
                    bindingClass.tvInfo.text = "Такого аккаунта не существуцет!"
                }
            }
        }


    }

//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//
//        if(requestCode == Constance.REQUEST_CCODE_SIGN_IN){
//            val  l = data?.getStringExtra(Constance.LOGIN)
//            val  p = data?.getStringExtra(Constance.PASSWORD)
//            if(login == l && password == p){
//                val textInfo = "$name $name2 $name3"
//                bindingClass.tvInfo.text = textInfo
//                bindingClass.imAvatar.visibility = View.VISIBLE
//                bindingClass.imAvatar.setImageResource(avatarImageId)
//                bindingClass.bExit.visibility = View.GONE
//                bindingClass.bSign.text = "Выйти"
//            } else {
//                bindingClass.tvInfo.text = "Такого аккаунта не существуцет!"
//            }
//
//        }else if(requestCode == Constance.REQUEST_CCODE_SIGN_UP){
//            login = data?.getStringExtra(Constance.LOGIN)!!
//            password = data?.getStringExtra(Constance.PASSWORD)!!
//            name = data?.getStringExtra(Constance.NAME)!!
//            name2 = data?.getStringExtra(Constance.NAME2)!!
//            name3 = data?.getStringExtra(Constance.NAME3)!!
//            avatarImageId = data.getIntExtra(Constance.AVATAR_ID, 0)
//            bindingClass.imAvatar.visibility = View.VISIBLE
//            val textInfo = "$name $name2 $name3"
//            bindingClass.tvInfo.text = textInfo
//            bindingClass.imAvatar.setImageResource(avatarImageId)
//            bindingClass.bExit.visibility = View.GONE
//            bindingClass.bSign.text = "Выйти"
//
//        }
//    }

    fun onClikcSignIn(view: View){

        if(bindingClass.imAvatar.isVisible &&  bindingClass.tvInfo.text.toString() != "Такого аккаунта не существуцет!"){
            bindingClass.imAvatar.visibility = View.INVISIBLE
            bindingClass.tvInfo.text = ""
            bindingClass.bExit.visibility = View.VISIBLE
            bindingClass.bSign.text = getString(R.string.sign_in)
        }else {
            val intent = Intent(this, SignUpInActivity::class.java)
            intent.putExtra(Constance.SIGN__STATE, Constance.SIGN_IN_STATE)
            launcherSignIn?.launch(intent);
//            startActivityForResult(intent, Constance.REQUEST_CCODE_SIGN_IN)
        }
    }
    fun onClikcSignUp(view: View){
        val intent = Intent(this,SignUpInActivity::class.java)
        intent.putExtra(Constance.SIGN__STATE,Constance.SIGN_UP_STATE)
        launcherSignUp?.launch(intent);
//        startActivityForResult(intent,Constance.REQUEST_CCODE_SIGN_UP)
    }
}