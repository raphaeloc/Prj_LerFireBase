package com.example.rolivech.prj_lerfirebase;

public class Visitantes {

    private String nome, telefone, hora;

    public Visitantes() {
        this.nome = "";
        this.telefone = "";
        this.hora = "";
    }

    public Visitantes(String nome, String telefone, String hora) {
        this.nome = nome;
        this.telefone = telefone;
        this.hora = hora;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

}
