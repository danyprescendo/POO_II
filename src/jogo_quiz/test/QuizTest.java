package jogo_quiz.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import jogo_quiz.Pergunta;
import jogo_quiz.Quiz;

public class QuizTest {

    private Quiz quiz;

    @Before
    public void setUp() {
        quiz = new Quiz();
    }

    @Test
    public void testLerArquivo() {
        quiz.lerArquivo();
        ArrayList<Pergunta> perguntas = quiz.getPerguntas();
        assertNotNull(perguntas);
        assertTrue(perguntas.size() > 0);

        try (BufferedReader reader = new BufferedReader(new FileReader("perguntas.txt"))) {
            int index = 0;
            String line;
            while ((line = reader.readLine()) != null && index < perguntas.size()) {
                assertEquals(line.split(",")[0], perguntas.get(index).getTitulo());
                assertEquals(line.split(",")[1].equals("Verdadeiro"), perguntas.get(index).isRespostaCorreta());
                index++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
