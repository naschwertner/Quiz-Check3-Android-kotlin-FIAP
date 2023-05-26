
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.nathaliariegler_rm87498.AlternativaModel
import com.example.nathaliariegler_rm87498.QuestaoModel
import kotlinx.android.synthetic.main.fragment_quiz_game.*


class QuestaoFragment : Fragment() {

    private lateinit var questoes: MutableList<QuestaoFragment>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_questao, container, false)

        // Carrega as questões
        carregarQuestoes()

        // Exibe a primeira questão
        val primeiraQuestao = questoes[0]
        val questionTitle: TextView = view.findViewById(R.id.questionTitle)
        questionTitle.text = primeiraQuestao.pergunta

        // Exibe as alternativas
        val radioGroup: RadioGroup = view.findViewById(R.id.radioGroup)
        for (i in 0 until radioGroup.childCount) {
            val radioButton = radioGroup.getChildAt(i) as RadioButton
            radioButton.text = primeiraQuestao.alternativas[i].resposta
        }


        return view
    }




    private fun carregarQuestoes() {
        questoes = mutableListOf()

        // Questão 1
        val alternativas1 = mutableListOf(
            AlternativaModel("Paris", false),
            AlternativaModel("Lyon", true),
            AlternativaModel("Marseille", false),
            AlternativaModel("Bordeaux", false)
        )
        val questao1 = QuestaoModel("Qual é a capital da França?", alternativas1)
        questoes.add(questao1)

        // Questão 2
        val alternativas2 = mutableListOf(
            AlternativaModel("Água", true),
            AlternativaModel("Oxigênio", false),
            AlternativaModel("Hidrogênio", false),
            AlternativaModel("Carbono", false)
        )
        val questao2 = QuestaoModel("O que é H2O?", alternativas2)
        questoes.add(questao2)

        // Questão 3
        val alternativas3 = mutableListOf(
            AlternativaModel("Rio de Janeiro", false),
            AlternativaModel("São Paulo", false),
            AlternativaModel("Brasília", true),
            AlternativaModel("Belo Horizonte", false)
        )
        val questao3 = QuestaoModel("Qual é a capital do Brasil?", alternativas3)
        questoes.add(questao3)
    }
}
