package com.example.tela

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.R
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDirection.Companion.Content
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tela.ui.theme.TelaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TelaTheme {
                MainScreen()
            }
        }
    }
}
@Preview
@Composable
fun MainScreen() {
    var texto by remember { mutableStateOf("") }

    Scaffold(
        bottomBar = { BottomBar() },
        containerColor = Color.White
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            Content(texto, onTextoChange = { texto = it })
        }
    }
}
@Composable
fun Content(texto: String, onTextoChange: (String) -> Unit) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item {
            UserHeader()
            bloco3(
                titulo = "Análise e Desenvolvimento de Sistemas",
                color = Color.LightGray,
                altura = 125,
                largura = 350,
                textAlign = TextAlign.Start,
                style = MaterialTheme.typography.titleLarge
            )
            bloco("Ambiente Virtual", Color.LightGray, 90, 350, TextAlign.Start, MaterialTheme.typography.titleLarge)
            bloco("Área do Aluno", Color.LightGray, 90, 350, TextAlign.Start, MaterialTheme.typography.titleLarge)

            Spacer(modifier = Modifier.height(8.dp))

            Text("Central de Ajuda !", style = MaterialTheme.typography.bodyMedium)
            OutlinedTextField(
                value = texto,
                onValueChange = onTextoChange,
                label = { Text("Procurar no App!!", style = MaterialTheme.typography.bodySmall) },
                modifier = Modifier
                    .width(350.dp)
                    .height(40.dp),
                shape = RoundedCornerShape(8.dp),
                singleLine = false,
                maxLines = 4
            )
        }
        item {
            Spacer(modifier = Modifier.height(8.dp))
            CategoryRows()
        }
    }
}
@Composable
fun UserHeader() {
    Spacer(modifier = Modifier.height(5.dp))
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Surface(
            modifier = Modifier.size(50.dp),
            color = Color.LightGray,
            shape = CircleShape
        ) {
            Icon(
                imageVector = Icons.Default.Face,
                contentDescription = "Ícone de rosto",
                modifier = Modifier.size(30.dp)
            )
        }
        Spacer(modifier = Modifier.width(12.dp))
        Column {
            Text("Olá {Usuário} :)", style = MaterialTheme.typography.headlineSmall)
        }
    }
    Spacer(modifier = Modifier.height(8.dp))
}
@Composable
fun CategoryRows() {
    val items = listOf(
        Pair("Disciplinas", Icons.Default.Warning),
        Pair("Documentos", Icons.Default.Email),
        Pair("Financeiro", Icons.Default.ShoppingCart),
        Pair("Bolsas", Icons.Default.Star),
        Pair("Formatura", Icons.Default.DateRange),
        Pair("Acessos", Icons.Default.AccountBox),
        Pair("Matricula", Icons.Default.Settings),
        Pair("Outros Serviços", Icons.Default.Info)
    )

    for (i in items.chunked(2)) {
        Row {
            i.forEach { (title, icon) ->
                bloco2(
                    titulo = title,
                    color = Color.LightGray,
                    altura = 50,
                    largura = 175,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.titleMedium,
                    imageVector = icon
                )
                Spacer(modifier = Modifier.width(5.dp))
            }
        }
    }
}
@Composable
fun BottomBar() {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp),
        color = Color(0xFFE0E0E0),
        shadowElevation = 6.dp,
        border = BorderStroke(1.dp, Color.Gray)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            IconButton(onClick = { /* TODO: Home */ }) {
                Icon(Icons.Default.Home, contentDescription = "Home")
            }
            IconButton(onClick = { /* TODO: Criar */ }) {
                Icon(Icons.Default.Create, contentDescription = "Criar")
            }
            IconButton(onClick = { /* TODO: Carrinho */ }) {
                Icon(Icons.Default.ShoppingCart, contentDescription = "Carrinho")
            }
            IconButton(onClick = { /* TODO: Perfil */ }) {
                Icon(Icons.Default.Person, contentDescription = "Perfil")
            }
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun bloco(
    titulo: String,
    color: Color,
    altura: Int,
    largura: Int,
    textAlign: TextAlign,
    style: TextStyle
) {
    Surface(
        modifier = Modifier.width(largura.dp)
            .height(altura.dp)
            .padding(5.dp),
        color = color,
        shadowElevation = 6.dp,
        tonalElevation = 6.dp,
        border = BorderStroke(2.dp, Color.DarkGray),
        shape = RoundedCornerShape(10.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center

        ) {
            Row {
                Text(
                    text = titulo,
                    style = style,
                    color = Color.Black,
                    modifier = Modifier.padding(5.dp),
                    textAlign = textAlign
                )
                Icon(
                    imageVector = Icons.Default.ArrowForward,
                    contentDescription = "Ícone de flecha",
                    modifier = Modifier.size(30.dp),
                )
            }

        }

    }
}
@Composable
fun bloco2(
    titulo: String,
    color: Color,
    altura: Int,
    largura: Int,
    textAlign: TextAlign,
    style: TextStyle,
    imageVector: ImageVector
) {

    Surface(
        modifier = Modifier.width(largura.dp)
            .height(altura.dp)
            .padding(5.dp),
        color = color,
        shadowElevation = 6.dp,
        tonalElevation = 6.dp,
        border = BorderStroke(2.dp, Color.DarkGray),
        shape = RoundedCornerShape(10.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier.padding(2.dp)
        ) {
            Icon(
                imageVector = imageVector,
                contentDescription = "Ícone de rosto",
                modifier = Modifier.size(30.dp)
            )
            Text(
                text = titulo,
                style = style,
                color = Color.Black,
                modifier = Modifier.padding(5.dp),
                textAlign = textAlign
            )
        }

    }
}
@Composable
fun bloco3(
    titulo: String,
    color: Color,
    altura: Int,
    largura: Int,
    textAlign: TextAlign,
    style: TextStyle
) {
    Surface(
        modifier = Modifier.width(largura.dp)
            .height(altura.dp)
            .padding(5.dp),
        color = color,
        shadowElevation = 6.dp,
        tonalElevation = 6.dp,
        border = BorderStroke(2.dp, Color.DarkGray),
        shape = RoundedCornerShape(10.dp)
    ) {
        Column {
            Text(
                text = titulo,
                style = style,
                color = Color.Black,
                modifier = Modifier.padding(5.dp),
                textAlign = textAlign,
            )
            Column(
                modifier = Modifier.width(200.dp).padding(5.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Text("RGM: 123456789 ", style = MaterialTheme.typography.bodyMedium)
                Text("Cursando", style = MaterialTheme.typography.bodyMedium)
            }

        }

    }
}