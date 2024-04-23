package jogo_quiz;

public class Resposta {
	
	private Pergunta pergunta;
	private boolean resposta;
	
	public String correcao() {
		if(pergunta.isRespostaCorreta() == resposta) {
			return "acerto";
		}
		return "erro";
	}
	
	public Resposta() {
		this(new Pergunta(), false);
	}
	
	public Resposta(Pergunta pergunta, boolean respostas) {
		super();
		this.pergunta = pergunta;
		this.resposta = respostas;
	}

	public Pergunta getPergunta() {
		return pergunta;
	}

	public void setPergunta(Pergunta pergunta) {
		this.pergunta = pergunta;
	}

	public boolean isRespostas() {
		return resposta;
	}

	public void setRespostas(boolean respostas) {
		this.resposta = respostas;
	}

}
