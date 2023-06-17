package com.example.controlefinanceiro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.controlefinanceiro.ui.theme.ControleFinanceiroTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ControleFinanceiroTheme {
                Column() {
                    BemVindo()
                    Transacoes()
                }
            }
        }
    }
}

@Composable
fun Transacoes(){
    LazyColumn(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        contentPadding = PaddingValues(8.dp)
    ){
        items(transacoesLista.size){index ->
            Transacao(index)
        }
    }
}

@Composable
private fun Transacao(index: Int) {
    Card(
        elevation = CardDefaults.cardElevation(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Row() {
            Icon(
                imageVector = Icons.Filled.Settings,
                contentDescription = "teste"
            )
            Spacer(modifier = Modifier.padding(16.dp))
            Text(
                text = transacoesLista[index],
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun BemVindo(){
    Row(modifier = Modifier.padding(16.dp)){
        Text(
            text = "Bem vindo de volta, \n Cairo Medeiros",
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.weight(1f)
        )
        Icon(
            imageVector = Icons.Filled.Delete,
            contentDescription = "Limpar Transações",
            tint = MaterialTheme.colorScheme.primary
        )
    }
}

private val transacoesLista = listOf<String>(
    "Café", "Aluguel", "Academia", "Feira",
    "Café", "Aluguel", "Academia", "Feira",
    "Café", "Aluguel", "Academia", "Feira",
    "Café", "Aluguel", "Academia", "Feira",
    "Café", "Aluguel", "Academia", "Feira",
    "Café", "Aluguel", "Academia", "Feira",
    "Café", "Aluguel", "Academia", "Feira",
    "Café", "Aluguel", "Academia", "Feira",
    "Café", "Aluguel", "Academia", "Feira",
    "Café", "Aluguel", "Academia", "Feira",
    "Café", "Aluguel", "Academia", "Feira"
)