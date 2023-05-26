import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.nathaliariegler_rm87498.AlternativaModel
import com.example.nathaliariegler_rm87498.QuestaoModel
import com.example.nathaliariegler_rm87498.databinding.FragmentQuestaoBinding

class QuestaoFragment : Fragment() {

    private lateinit var questoes: MutableList<QuestaoModel>
    private lateinit var binding: FragmentQuestaoBinding
    private var currentQuestionIndex = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentQuestaoBinding.inflate(inflater, container, false)
        val view = binding.root

        // Carrega as questões
        carregarQuestoes()

        // Exibe a primeira questão
        displayQuestion()

        binding.btnSubmit.setOnClickListener {
            val selectedOptionId = binding.radioGroup.checkedRadioButtonId
            val selectedAnswer = when (selectedOptionId) {
                R.id.option1 -> questoes[currentQuestionIndex].alternativas[0]
                R.id.option2 -> questoes[currentQuestionIndex].alternativas[1]
                R.id.option3 -> questoes[currentQuestionIndex].alternativas[2]
                R.id.option4 -> questoes[currentQuestionIndex].alternativas[3]
                else -> null
            }

            if (selectedAnswer != null && selectedAnswer.isCorrect) {
                findNavController().navigate(R.id.action_questaoFragment_to_acertouFragment)
            } else {
                findNavController().navigate(R.id.action_questaoFragment_to_errouFragment)
            }
        }

        return view
    }

    private fun displayQuestion() {
        val currentQuestion = questoes[currentQuestionIndex]
        binding.questionTitle.text = currentQuestion.pergunta

        for (i in 0 until binding.radioGroup.childCount) {
            val radioButton = binding.radioGroup.getChildAt(i) as RadioButton
            radioButton.text = currentQuestion.alternativas[i].resposta
        }
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
            Altern
