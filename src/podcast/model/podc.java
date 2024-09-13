/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package podcast.model;

import java.time.LocalDate;

@Entity
@Table(name="podc")
public class podc {
 
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
      
    private String produtor;
    private String nome;
    private String ep;
    private String duracao;
    private String url;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getProdutor() {
            return produtor;
        }

        public void setProdutor(String produtor) {
            this.produtor = produtor;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getEp() {
            return ep;
        }

        public void setEp(String ep) {
            this.ep = ep;
        }

        public String getDuracao() {
            return duracao;
        }

        public void setDuracao(String duracao) {
            this.duracao = duracao;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    
    

    }
    

