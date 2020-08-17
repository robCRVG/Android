package br.com.provaandroid.entities;

import java.util.Map;

public class Cliente {

    private String id, codigo, razao_social, nomefantasia, cnpj, ramo_atividade, endereco, status;
    private Contato contatos;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getRazao_social() {
        return razao_social;
    }

    public void setRazao_social(String razao_social) {
        this.razao_social = razao_social;
    }

    public String getNomefantasia() {
        return nomefantasia;
    }

    public void setNomefantasia(String nomefantasia) {
        this.nomefantasia = nomefantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRamo_atividade() {
        return ramo_atividade;
    }

    public void setRamo_atividade(String ramo_atividade) {
        this.ramo_atividade = ramo_atividade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getStatus() {
        return status;
    }

    public Contato getContatos() {
        return contatos;
    }

    public void setContatos(Contato contatos) {
        this.contatos = contatos;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id='" + id + '\'' +
                ", codigo='" + codigo + '\'' +
                ", razao_social='" + razao_social + '\'' +
                ", nomefantasia='" + nomefantasia + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", ramo_atividade='" + ramo_atividade + '\'' +
                ", endereco='" + endereco + '\'' +
                ", status='" + status + '\'' +
                ", contatos=" + contatos +
                '}';
    }
}
