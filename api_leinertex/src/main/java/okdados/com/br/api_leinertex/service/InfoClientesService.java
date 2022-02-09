    package okdados.com.br.api_leinertex.service;


    import javax.persistence.*;
    import java.util.Date;

    @Entity(name = "pessoa_informacoes")
    public class InfoClientesService {

        @Id
        @Column(name = "id_pessoa_informacoes")
        @GeneratedValue(strategy = GenerationType.AUTO)
        public Integer id;

        @Column(name = "id_pessoa")
        public Integer idPessoa;

        @Column(name = "cpf")
        public String cpf;

        @Column(name = "cnpj")
        public String cnpj;

        @Column(name = "data_nascimento")
        public Date dataNascimento;


        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getIdPessoa() {
            return idPessoa;
        }

        public void setIdPessoa(Integer idPessoa) {
            this.idPessoa = idPessoa;
        }

        public String getCpf() {
            return cpf;
        }

        public void setCpf(String cpf) {
            this.cpf = cpf;
        }

        public String getCnpj() {
            return cnpj;
        }

        public void setCnpj(String cnpj) {
            this.cnpj = cnpj;
        }

        public Date getDataNascimento() {
            return dataNascimento;
        }

        public void setDataNascimento(Date dataNascimento) {
            this.dataNascimento = dataNascimento;
        }
    }
