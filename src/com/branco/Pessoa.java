package com.branco;

import com.frame.JSON;

import java.util.Date;
import java.util.Objects;

/**
 * Classe pessoa que está sendo usado em todos os exemplos.
 */
public class Pessoa {

    String  cpf;
    Date DataNascimento;
    String Nome;
    String OrgaoEspedido;
    String RG;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(cpf, pessoa.cpf) &&
                Objects.equals(DataNascimento, pessoa.DataNascimento) &&
                Objects.equals(Nome, pessoa.Nome) &&
                Objects.equals(OrgaoEspedido, pessoa.OrgaoEspedido) &&
                Objects.equals(RG, pessoa.RG);
    }

    @Override
    public int hashCode() {

        return Objects.hash(cpf, DataNascimento, Nome, OrgaoEspedido, RG);
    }
    @JSON
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return DataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        DataNascimento = dataNascimento;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getOrgaoEspedido() {
        return OrgaoEspedido;
    }

    public void setOrgaoEspedido(String orgaoEspedido) {
        OrgaoEspedido = orgaoEspedido;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }
}
