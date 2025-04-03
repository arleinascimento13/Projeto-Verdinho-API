package org.projetoverdinho.projetoverdinhoapi.entity;


import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
@Entity
@Table(name = "pessoas")
public class PessoaEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "cpf",length = 20,unique = true)
    private String cpf;

    @Column(name = "rg", length = 20)
    private String rg;

    @Column(name = "endereco", length = 255)
    private String endereco;

    @Column(name = "telefone", length = 20)
    private String telefone;

    @Column(name = "imagem_limit")
    private Integer imagemLimit;

    /*
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "pessoa_cad_cpf")
    private List<Imagem> imagens;
    */

    @Column(name = "descricao")
    private String descricao;

}
