package com.cb.expensetracker.Screen


import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.cb.expensetracker.R
import com.cb.expensetracker.Screen.Addexpanse.Screen
import com.cb.expensetracker.ViewModel.AuthState
import com.cb.expensetracker.ViewModel.AuthViewModel


@Composable
fun SignUpScreen(modifier: Modifier,navController: NavController,authViewModel: AuthViewModel)
{
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmpassword by remember { mutableStateOf("") }

    val context = LocalContext.current
    val authState = authViewModel.authState.observeAsState()
    LaunchedEffect(authState.value)
    {
        when(authState.value)
        {
            is AuthState.Authenticated->navController.navigate("home")
            is AuthState.Error->Toast.makeText(context,(authState.value as AuthState.Error)
                .message,Toast.LENGTH_SHORT).show()
            else-> Unit
        }
    }


    Box(
        modifier = Modifier.fillMaxSize()
            .background(color = Color.White)
    )

    {
        Image(
            painter = painterResource(R.drawable.backgroubd),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            Text(
                text = " SignUp ",
                Modifier
                    .padding(top = 155.dp),
                color = Color(0xFF2A7C76),
                fontSize = 45.sp,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.size(45.dp))


            OutlinedTextField(value =email,
                onValueChange = {
                    email=it

                },
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.fillMaxWidth()
                    .padding(start = 22.dp, end = 22.dp),
                label = {
                    Text(text = "Email")
                })
            Spacer(modifier = Modifier.size(35.dp))

            OutlinedTextField(value = password,
                onValueChange = {
               password = it
                },
                shape = RoundedCornerShape(18.dp),
                modifier = Modifier.fillMaxWidth()
                    .padding(start = 22.dp, end = 22.dp),

                label = {
                    Text(text = "Password")
                })
            Spacer(modifier = Modifier.size(35.dp))
            OutlinedTextField(value = confirmpassword,
                onValueChange = {
                    confirmpassword = it
                }, shape = RoundedCornerShape(18.dp),
                modifier = Modifier.fillMaxWidth()
                    .padding(start = 22.dp, end = 22.dp),

                label = {
                    Text(text = "confirmpaswword")
                })
            Spacer(modifier = Modifier.size(35.dp))

            Button(
                onClick = { authViewModel.Signup(email,password,confirmpassword)
                },
                enabled = true,
                modifier = Modifier.fillMaxWidth()
                    .padding(start = 22.dp, end = 22.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF2A7C76),
                    contentColor = Color.White,
                )
            ) {
                Text(text = "SignUp",
                    fontWeight = FontWeight.Bold)
            }


            TextButton(onClick = { navController.navigate(Screen.LogIn.route)
        }) {
                Text(text="Already have an account ! , Login",
                    fontSize = 12.sp, color = Color(0xFF16715F))
            }
        }


    }

}
