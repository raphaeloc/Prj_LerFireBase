package com.example.rolivech.prj_lerfirebase;

public class Horarios {
    private String cor_selecionada;
    private boolean finalizado;
    private String horario;
    private String num_pessoas;

    public Horarios() {
        this.cor_selecionada = "";
        this.finalizado = false;
        this.horario = "";
        this.num_pessoas = "";
    }

    public Horarios(String cor_selecionada, boolean finalizado, String horario, String num_pessoas) {
        this.cor_selecionada = cor_selecionada;
        this.finalizado = finalizado;
        this.horario = horario;
        this.num_pessoas = num_pessoas;
    }

    public String getCor_selecionada() {
        return cor_selecionada;
    }

    public void setCor_selecionada(String cor_selecionada) {
        this.cor_selecionada = cor_selecionada;
    }

    public boolean getFinalizado() {
        return finalizado;
    }

    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getNum_pessoas() {
        return num_pessoas;
    }

    public void setNum_pessoas(String num_pessoas) {
        this.num_pessoas = num_pessoas;
    }
}
