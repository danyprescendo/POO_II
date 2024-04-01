package jogo_quiz;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;

public class Quiz {
	
	private ArrayList<Pergunta> perguntas;
	
	public void lerArquivo() {
		try {
			FileReader fr = new FileReader("perguntas.txt");
			BufferedReader br = new BufferedReader(fr);
			String linha = "";
			while ((linha = br.readLine()) != null) {
				perguntas.add(new Pergunta(linha));
			}
			br.close();
			fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int calculaPontuacao(ArrayList<Resposta> respostas) {
		int ponto = 0;
		for (Resposta r : respostas) {
			if(r.correcao().equals("acerto")) {
				ponto++;
			}
		}
		return ponto;
	}
	
	public void gravaResultado(ArrayList<Resposta> respostas) {
		try {
			FileWriter fw = new FileWriter("respostas.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			int count = 1;
			for (Resposta r : respostas) {
				bw.append((count++) + "," + 
			               r.getPergunta().getTitulo() + "," + 
						   r.correcao() + "\n");
			}
			bw.close();
			fw.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Pergunta> sorteiaRodada(int qtd) {
		ArrayList<Pergunta> sorteadas = new ArrayList<Pergunta>();
		Collections.shuffle(perguntas);
		for (int i = 0; i < qtd; i++) {
			sorteadas.add(perguntas.get(i));
		}
		return sorteadas;
	}

	public Quiz() {
		perguntas = new ArrayList<Pergunta>();
	}

	public Quiz(ArrayList<Pergunta> perguntas) {
		this.perguntas = perguntas;
	}

	public ArrayList<Pergunta> getPerguntas() {
		return perguntas;
	}

	public void setPerguntas(ArrayList<Pergunta> perguntas) {
		this.perguntas = perguntas;
	}
	
}
