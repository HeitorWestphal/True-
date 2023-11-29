package pkgtrue;

import java.util.ArrayList;

public class True {

    class Turma {
        private final String nome;

        public Turma(String nome) {
            this.nome = nome;
        }

        public String getNome() {
            return nome;
        }
    }

    class Aluno {
        private final String nome;
        private final ArrayList<Turma> turmasMatriculadas;

        public Aluno(String nome) {
            this.nome = nome;
            this.turmasMatriculadas = new ArrayList<>();
        }

        public void matricularEmTurma(Turma turma) {
            turmasMatriculadas.add(turma);
        }

        public String emitirDeclaracaoMatricula() {
            StringBuilder declaracao = new StringBuilder("Declaração de Matrícula para o aluno " + nome + ". Turmas: ");
            for (Turma turma : turmasMatriculadas) {
                declaracao.append(turma.getNome()).append(", ");
            }
            if (!turmasMatriculadas.isEmpty()) {
                declaracao.setLength(declaracao.length() - 2); // Remove a vírgula extra no final
            }
            return declaracao.toString();
        }
    }

    class Professor {
        private final String nome;
        private final ArrayList<Turma> turmasResponsavel;

        public Professor(String nome) {
            this.nome = nome;
            this.turmasResponsavel = new ArrayList<>();
        }

        public void responsavelPorTurma(Turma turma) {
            turmasResponsavel.add(turma);
        }

        public String emitirDeclaracaoVinculo() {
            StringBuilder declaracao = new StringBuilder("Declaração de Vínculo para o professor " + nome + ". Turmas: ");
            for (Turma turma : turmasResponsavel) {
                declaracao.append(turma.getNome()).append(", ");
            }
            // Verifica se há turmas responsáveis antes de remover a vírgula extra
            if (!turmasResponsavel.isEmpty()) {
                declaracao.setLength(declaracao.length() - 2); // Remove a vírgula extra no final
            }
            return declaracao.toString();
        }
    }

    public static void main(String[] args) {
        True trueInstance = new True();
        True.Turma turma1 = trueInstance.new Turma("Matemática");
        True.Turma turma2 = trueInstance.new Turma("História");

        True.Aluno aluno = trueInstance.new Aluno("João");
        aluno.matricularEmTurma(turma1);
        aluno.matricularEmTurma(turma2);

        True.Professor professor = trueInstance.new Professor("Maria");
        professor.responsavelPorTurma(turma1);

        String declaracaoAluno = aluno.emitirDeclaracaoMatricula();
        String declaracaoProfessor = professor.emitirDeclaracaoVinculo();

        System.out.println(declaracaoAluno);
        System.out.println(declaracaoProfessor);
    }
}