package com.example.sprint.config.validation;

public class ErroDeFormularioDTO {
    private String campo;
    private String erro;

    public ErroDeFormularioDTO(String campo, String erro){
        this.campo = campo;
        this.erro = erro;
    }

    public String getCampo() {
        return campo;
    }

    public ErroDeFormularioDTO setCampo(String campo) {
        this.campo = campo;
        return this;
    }

    public String getErro() {
        return erro;
    }

    public ErroDeFormularioDTO setErro(String erro) {
        this.erro = erro;
        return this;
    }
}
