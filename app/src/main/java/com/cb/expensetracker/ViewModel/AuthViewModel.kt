package com.cb.expensetracker.ViewModel

import androidx.compose.runtime.Composable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.google.firebase.auth.FirebaseAuth



class AuthViewModel: ViewModel()
{
    private val auth : FirebaseAuth = FirebaseAuth.getInstance()
    private val _authstate = MutableLiveData<AuthState>()
    val authState : LiveData<AuthState> =_authstate

    init {
        checkAuthstate()
    }
    fun checkAuthstate(){

        if (auth.currentUser == null){
            _authstate.value = AuthState.Unauthenticated
        }
        else {
            _authstate.value = AuthState.Authenticated
        }
    }
    fun login(email:String,passsword:String){
        if (email.isEmpty()||passsword.isEmpty()){
            _authstate.value = AuthState.Error("Email or password can't be empty")
            return
        }
        _authstate.value = AuthState.Loading
        auth.signInWithEmailAndPassword(email,passsword)
            .addOnCompleteListener{
                    task-> if (task.isSuccessful){
                _authstate.value = AuthState.Authenticated
            }
            else{
                _authstate.value = AuthState.Error(task.exception?.message?:"Something went wrong")
            }
            }
    }
    fun Signup(email:String,passsword:String,confirmpassword:String){
        if (email.isEmpty()||passsword.isEmpty()||confirmpassword.isEmpty()){
            _authstate.value = AuthState.Error("Email or password can't be empty")
            return
        }
        _authstate.value = AuthState.Loading
        auth.createUserWithEmailAndPassword(email,passsword)
            .addOnCompleteListener{
                    task-> if (task.isSuccessful){
                _authstate.value = AuthState.Authenticated
            }
            else{
                _authstate.value = AuthState.Error(task.exception?.message?:"Something went wrong")
            }
            }
    }
    fun signout(){
        auth.signOut()
        _authstate.value = AuthState.Unauthenticated
    }
}

sealed class AuthState{
    object Authenticated : AuthState()
    object Unauthenticated : AuthState()
    object  Loading:AuthState()
    data class Error(val message: String):AuthState()



}

