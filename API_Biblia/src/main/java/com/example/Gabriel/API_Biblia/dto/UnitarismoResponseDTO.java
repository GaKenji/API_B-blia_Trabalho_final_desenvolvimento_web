package com.example.Gabriel.API_Biblia.dto;

//Organiza a resposta do endpoint "unitarismo"
public class UnitarismoResponseDTO {
    private String livro;
    private int capitulo;
    private int numVersiculo;
    private String versiculo;

    public UnitarismoResponseDTO(String livro, int capitulo, int numVersiculo, String versiculo) {
        this.livro = livro;
        this.capitulo = capitulo;
        this.numVersiculo = numVersiculo;
        this.versiculo = versiculo;
    }

    public String getLivro() {return livro;}
    public int getCapitulo() {return capitulo;}
    public int getNumVersiculo() {return numVersiculo;}
    public String getVersiculo() {return versiculo;}
}
