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
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.controlefinanceiro.ui.theme.ControleFinanceiroTheme
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow


class MyViewModel : ViewModel(){
    private val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState

    fun add(transacao: String){
        val transacoesLista = _uiState.value.transacoesLista.toMutableList()
        transacoesLista.add(transacao)
        _uiState.value = UiState(transacoesLista = transacoesLista)
    }
    data class UiState(
        val transacoesLista: List<String> = emptyList()
    )
}
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
fun Transacoes(viewModel: MyViewModel = viewModel()){
    val uiState by viewModel.uiState.collectAsState()
    Column() {
        LazyColumn(
            modifier = Modifier
                .padding(16.dp)
                .weight(1f)
                .fillMaxWidth(),
            contentPadding = PaddingValues(8.dp)
        ){
            items(uiState.transacoesLista.size){index ->
                Transacao(uiState.transacoesLista[index])
            }
        }
        Button(onClick = {
            viewModel.add("Nova Transação")
        }) {
            Text(text = "Adicionar nova transação")
        }
    }
}

@Composable
private fun Transacao(transacao: String) {
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
                text = transacao,
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