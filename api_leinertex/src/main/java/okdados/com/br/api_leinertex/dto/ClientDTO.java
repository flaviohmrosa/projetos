package okdados.com.br.api_leinertex.dto;

public class ClientDTO {

    public String codigo;
    public String nomeFantasia;
    public String logradouro;
    public String fone;
    public String email;
    public String whatsapp;
    public String complemento;
    public String numero;
    public String bairro;
    public Long cepLogradouro;
    public String cidade;
    public String UF;
    public Float latitude;
    public Float longitude;
    public Float raio;

    public ClientDTO(){}

    public ClientDTO(String codigo,
                     String nomeFantasia,
                     String logradouro,
                     String fone,
                     String email,
                     String whatsapp,
                     String complemento,
                     String numero,
                     String bairro,
                     Long cepLogradouro,
                     String cidade,
                     String UF,
                     Float latitude,
                     Float longitude,
                     Float raio) {
        this.codigo = codigo;
        this.nomeFantasia = nomeFantasia;
        this.logradouro = logradouro;
        this.fone = fone;
        this.email = email;
        this.whatsapp = whatsapp;
        this.complemento = complemento;
        this.numero = numero;
        this.bairro = bairro;
        this.cepLogradouro = cepLogradouro;
        this.cidade = cidade;
        this.UF = UF;
        this.latitude = latitude;
        this.longitude = longitude;
        this.raio = raio;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWhatsapp() {
        return whatsapp;
    }

    public void setWhatsapp(String whatsapp) {
        this.whatsapp = whatsapp;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Long getCepLogradouro() {
        return cepLogradouro;
    }

    public void setCepLogradouro(Long cepLogradouro) {
        this.cepLogradouro = cepLogradouro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUF() {
        return UF;
    }

    public void setUF(String UF) {
        this.UF = UF;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public Float getRaio() {
        return raio;
    }

    public void setRaio(Float raio) {
        this.raio = raio;
    }
}
